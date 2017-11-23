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
        
    }

    @Override
    public void returnPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gameCreated() {
        myView.setBtnStartGameVisible(true);
    }

    @Override
    public void gameStarted() {
        //Thread de temporizador
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Temporizador
            }
        }).start();
    }
    
}
