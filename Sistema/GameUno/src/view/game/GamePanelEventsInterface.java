/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.game;

import model.card.CardColor;

/**
 *
 * @author sergi
 */
public interface GamePanelEventsInterface {
    public void onGameViewLoaded();
    
    public void onStartCardsShared();
    
    public void onCardsShared();
    
    public void onViewUpdate();
    
    public void machineCulp();
    
    public void skipCulp();
    
    public void userCulp(int cardIndex);
    
    public void onUserSelectedNewColor(CardColor c);
    
    
}
