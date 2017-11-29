/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.game;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.card.Card;
import model.game.GameModel;
import util.AppLog;
import view.MainFrameController;
import view.ViewController;
import model.game.GameEventsInterface;
import view.menu.MenuPanelController;

/**
 *
 * @author sergi
 */
public class GamePanelController implements ViewController, GameEventsInterface {

    private GamePanel myView;
    private GameModel gameModel = GameModel.myInstance();
    private final int MAX_TIME_TO_CULP = 5;

    private boolean userClickedOnCard = false;

    public GamePanelController() {
        gameModel.setGameStatusInterface(this);

    }

    @Override
    public void startView() {
        myView = new GamePanel(this);
        MainFrameController.setView(myView);
        gameModel.onGameViewLoaded();
    }

    @Override
    public void returnPage() {
        new MenuPanelController().startView();
    }

    @Override
    public void shareStartCards() {
        System.out.println("view.game.GamePanelController.shareStartCards()");
        for (int i = 0; i < gameModel.getGamePlayers().length; i++) {
            String scrUserCard = gameModel.getGamePlayers()[i].getStartCard().getIconSRC();
            try {
                Thread.sleep(200);
                myView.getLabels(4)[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + scrUserCard)));
                myView.getLabels(4)[i].setVisible(true);

            } catch (Exception e) {
                System.out.println("Erro ao atribuir carta de inicio: " + scrUserCard + " E:" + e.getMessage());
                AppLog.error("Erro ao atribuir carta de inicio: " + scrUserCard + " E:" + e.getMessage());
            }
        }
        refreshActiveActualUser();
        myView.showStartButton();
    }

    private void refreshPlayersCards(boolean distribute) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < gameModel.getGamePlayers().length; i++) {
                    for (int j = 0; j < gameModel.getGamePlayers()[i].getCardsOnHand().size(); j++) {
                        String scrUserCard = gameModel.getGamePlayers()[i].getCardsOnHand().get(j).getIconSRC();
                        try {
                            if (i == 0) {
                                if (j <= 6) {
                                    myView.getLabels(i)[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + scrUserCard)));
                                    myView.getLabels(i)[j].setName(String.valueOf(j));
                                    //Adicionar click de cada label
                                    myView.getLabels(i)[j].addMouseListener(new java.awt.event.MouseAdapter() {
                                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                            myView.onUserLabelCardClicked(evt);
                                        }
                                    });
                                } else {
                                    //Adicionar cartas restantes no panel auxiliar
                                }
                            }
                            if (j <= myView.getLabels(i).length) {
                                myView.getLabels(i)[j].setVisible(true);
                            } else {
                                myView.getLabels(i)[j].setVisible(false);
                            }
                            if (distribute) {
                                Thread.sleep(150);
                            }
                        } catch (Exception e) {
                            System.out.println("Erro ao atribuir carta :" + scrUserCard + " Para player: "+gameModel.getGamePlayers()[i].getUser().getName()+" E:" + e.getMessage());
                        }

                    }

                }
                if (distribute) {
                    myView.setStartCardVisible(false);
                    gameModel.onCardsShared();
                }
            }
        }).start();

    }

    private void setUserLoggedCardsEnable(boolean b) {
        for (int j = 0; j < gameModel.getGamePlayers()[0].getCardsOnHand().size(); j++) {
            myView.getLabels(0)[j].setEnabled(b);
        }
    }

    @Override
    public void distributeCards() {
        refreshStacksGame();
        refreshPlayersCards(true);
        setUserLoggedCardsEnable(false);
    }

    void onBtnStartClicked() {
        gameModel.onStartCardsShared();
    }

    @Override
    public void requestLoggedPlayerCulp() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int time_remaining = MAX_TIME_TO_CULP;
                //System.out.println(".run() do RequestLoggedPlayerCulp");
                setUserLoggedCardsEnable(true);
                myView.setTimePlayerVisible(0, true);
                myView.updateTimeForUser(0, MAX_TIME_TO_CULP);
                while (time_remaining > 0 && !userClickedOnCard) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GamePanelController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    time_remaining--;
                    myView.updateTimeForUser(0, time_remaining);
                }
                myView.setTimePlayerVisible(0, false);
                setUserLoggedCardsEnable(false);
                gameModel.userCulp(myView.getSelectedUserCard());
                userClickedOnCard = false;
                myView.setUserCardSelectedIndex(0);
            }
        }).start();
    }

    @Override
    public void culpExecuted() {
        refreshPlayersCards(false);
        refreshStacksGame();
        refreshActiveActualUser();

        gameModel.onViewUpdate();
    }

    @Override
    public void requestMachinePlayerCulp(int playerIndex) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int time_remaining = MAX_TIME_TO_CULP;
                //System.out.println(".run() do RequestMachinePlayerCulp");
                myView.setTimePlayerVisible(playerIndex, true);
                myView.updateTimeForUser(playerIndex, MAX_TIME_TO_CULP);
                while (time_remaining > 0) {
                    if (time_remaining == 2) {//Com alguns segundos à IA joga
                        myView.setTimePlayerVisible(playerIndex, false);
                        gameModel.machineCulp();
                        return;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GamePanelController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    time_remaining--;
                    myView.updateTimeForUser(playerIndex, time_remaining);
                }
                myView.setTimePlayerVisible(playerIndex, false);
            }
        }).start();

    }

    private void refreshStacksGame() {
        //Atualizar labels para as cartas jogadas
        Card[] cards_played = gameModel.getCountCardsStackPlayed(3);
        myView.setStackPlayedVisible(false);
        for (int i = 0; i < cards_played.length; i++) {
            try {
                String scrIconCard = cards_played[i].getIconSRC();
                myView.getLabels(6)[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + scrIconCard)));
                myView.getLabels(6)[i].setVisible(true);
            } catch (Exception e) {
                System.out.println("Falha ao atualziar labels de cartas jogadas");
            }
        }
        //Atualizar labels daas cartas que ainda nao foram jogadas
        Card[] cards_not_played = gameModel.getCountCardsStack(3);
        myView.setStartCardVisible(false);
        for (int i = 0; i < cards_played.length; i++) {
            try {
                myView.getLabels(7)[i].setVisible(true);
            } catch (Exception e) {
                System.out.println("Falha ao atualziar labels de cartas");
            }
        }
    }

    private void refreshActiveActualUser() {
        myView.setActiveUserLabelsVisible(false);
        myView.getLabels(5)[gameModel.getActualPlayerPosition()].setVisible(true);
    }

    void setUserClickedOnCard(boolean b) {
        this.userClickedOnCard = b;
    }

}
