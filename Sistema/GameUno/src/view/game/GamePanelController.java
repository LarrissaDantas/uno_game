/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.game;

import model.game.GameModel;
import model.game.GameStatusInterface;
import view.MainFrameController;
import view.ViewController;

/**
 *
 * @author sergi
 */
public class GamePanelController implements ViewController,GameStatusInterface{
    private GamePanel myView;
    private GameModel gameModel = GameModel.myInstance();

    public GamePanelController() {
        gameModel.setGameStatusInterface(this);
    }
    
    
    
    @Override
    public void startView() {
        myView = new GamePanel(this);
        MainFrameController.setView(myView);
        gameStarted();
    }

    @Override
    public void returnPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gameCreated() {
        //Atualizar cartas da mao do jogador
    }

    @Override
    public void gameStarted() {
        System.out.println("Chamado");
        attUsersCards(true);
        //Thread de temporizador
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Temporizador
            }
        });
    }

    private void attUsersCards(boolean distribute) {
        //ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/images/400X300_logo_uno.png"));
        for(int i=0;i< gameModel.getActualPlayers().length ;i++){
            for (int j = 0; j < gameModel.getActualPlayers()[i].getCardsOnHand().size(); j++) {
                String scrUserCard = gameModel.getActualPlayers()[i].getCardsOnHand().get(j).getIconSRC();
                try{
                    if(i==0){
                        myView.getUserLabelCard(i)[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/"+scrUserCard)));                        
                    }
                    myView.getUserLabelCard(i)[j].setVisible(true);
                    if(distribute){
                        Thread.sleep(200);
                    }
                }catch(Exception e){
                    System.out.println("Erro ao atribuir carta :"+scrUserCard+" E:"+e.getMessage());
                }
                
            }
            
        }
        
    }
}
