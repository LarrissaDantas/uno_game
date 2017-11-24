/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.game;

import model.game.GameModel;
import util.AppLog;
import view.MainFrameController;
import view.ViewController;
import model.game.GameEventsInterface;

/**
 *
 * @author sergi
 */
public class GamePanelController implements ViewController,GameEventsInterface{
    private GamePanel myView;
    private GameModel gameModel = GameModel.myInstance();
    
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
        
    }
    
    
     
    @Override
    public void shareStartCards() {
        System.out.println("view.game.GamePanelController.shareStartCards()");
         for(int i=0;i< gameModel.getGamePlayers().length ;i++){
                String scrUserCard = gameModel.getGamePlayers()[i].getDrawnCard().getIconSRC();
                try{
                    Thread.sleep(200);
                    myView.getLabels(4)[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/"+scrUserCard)));
                    myView.getLabels(4)[i].setVisible(true);
                    
                }catch(Exception e){
                    System.out.println("Erro ao atribuir carta de inicio: "+scrUserCard+" E:"+e.getMessage());
                    AppLog.error("Erro ao atribuir carta de inicio: "+scrUserCard+" E:"+e.getMessage());
                }
        }
        myView.getLabels(5)[gameModel.getFirstPlayer()].setVisible(true);
        myView.showStartButton();
    }
 
    
    private void refreshUsersCards(boolean distribute) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i< gameModel.getGamePlayers().length ;i++){
                    for (int j = 0; j < gameModel.getGamePlayers()[i].getCardsOnHand().size(); j++) {
                        String scrUserCard = gameModel.getGamePlayers()[i].getCardsOnHand().get(j).getIconSRC();
                        try{
                            if(i==0){
                                myView.getLabels(i)[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/"+scrUserCard)));                        
                            }
                            myView.getLabels(i)[j].setVisible(true);
                            if(distribute){
                                Thread.sleep(200);
                            }
                        }catch(Exception e){
                            System.out.println("Erro ao atribuir carta :"+scrUserCard+" E:"+e.getMessage());
                        }

                    }

                }
                myView.setStartCardVisible(false);
                gameModel.onCardsShared();
            }
        }).start();
        
        
    }

    @Override
    public void distributeCards() {
        refreshUsersCards(true);
    }

    void onBtnStartClicked() {
        gameModel.onStartCardsShared();
    }

    @Override
    public void requestLoggedPlayerCulp() {
        
    }

    @Override
    public void culpExecuted() {
        refreshUsersCards(false);
        refreshStacksGame();
    }

    private void refreshStacksGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
