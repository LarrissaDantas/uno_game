/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.game;

import exception.GameException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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

    private final int MAX_TIME = 5;

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

    private void setUserLoggedCardsEnable(boolean b) {
        for (int j = 0; j < gameModel.getGamePlayers()[0].getCardsOnHand().size(); j++) {
            myView.getLabels(0)[j].setEnabled(b);
        }
    }

    @Override
    public void refreshPlayerCards(int userIndex) {
        myView.setInvisibleUserCardsLabel(userIndex);//Desabilitar todas, antes de atualizar
        for (int i = 0; i < gameModel.getGamePlayers()[userIndex].getCardsOnHand().size(); i++) {
            if (userIndex == 0) {//Apenas para o usuario Logado
                if (i < 7) {
                    String srcImg = gameModel.getGamePlayers()[userIndex].getCardsOnHand().get(i).getIconSRC();
                    myView.getLabels(userIndex)[i].setIcon(new ImageIcon(getClass().getResource("/" + srcImg)));
                    //Atribuir o click para cada label
                    myView.getLabels(userIndex)[i].setName(String.valueOf(i));
                    myView.getLabels(userIndex)[i].addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            myView.onUserLabelCardClicked(evt);
                        }
                    });
                } else {
                    //Limpar o ArrayList

                }
            }
            if (i < 7) {
                myView.getLabels(userIndex)[i].setVisible(true);
            }
        }
    }

    @Override
    public void distributeCards() {
        refreshStacksGame();
        distributePlayerCards();
        setUserLoggedCardsEnable(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int[] Tempo = new int[2];
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GamePanelController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (Tempo[1] < 60) {
                        Tempo[1]++;
                    } else {
                        Tempo[0]++;
                        Tempo[1] = 0;
                    }
                    myView.updateLabel(Tempo[0] + ":" + Tempo[1]);
                }

            }
        }).start();

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
                refreshPlayerCards(0);
            }
        }).start();
    }

    @Override
    public void culpExecuted() {
        refreshStacksGame();
        refreshActiveActualUser();
        gameModel.onViewUpdate();
    }

    @Override
    public void requestMachinePlayerCulp(int machinePlayerIndex) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int time_remaining = MAX_TIME_TO_CULP;
                //System.out.println(".run() do RequestMachinePlayerCulp");
                myView.setTimePlayerVisible(machinePlayerIndex, true);
                myView.updateTimeForUser(machinePlayerIndex, MAX_TIME_TO_CULP);
                while (time_remaining > 0) {
                    if (time_remaining == 2) {//Com alguns segundos à IA joga
                        myView.setTimePlayerVisible(machinePlayerIndex, false);
                        gameModel.machineCulp();
                        refreshPlayerCards(machinePlayerIndex);
                        return;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GamePanelController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    time_remaining--;
                    myView.updateTimeForUser(machinePlayerIndex, time_remaining);
                }
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

    void executeInstantUserCulp(boolean b) {
        this.userClickedOnCard = b;
    }

    private void distributePlayerCards() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < gameModel.getGamePlayers().length; i++) {
                    for (int j = 0; j < 7; j++) {
                        try {
                            myView.getLabels(i)[j].setVisible(true);
                            Thread.sleep(150);
                        } catch (Exception e) {
                            System.out.println("Erro ao atribuir carta");
                        }

                    }

                }
                myView.setStartCardVisible(false);
                refreshPlayerCards(0);
                gameModel.onCardsShared();
            }
        }).start();
    }

}
