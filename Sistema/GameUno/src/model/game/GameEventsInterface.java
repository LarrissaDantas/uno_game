/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.game;

import model.card.CardColor;
import model.player.Player;

/**
 *
 * @author Bianca
 */
public interface GameEventsInterface {

    public void shareStartCards();

    public void distributeCards();

    public void requestLoggedPlayerCulp();

    public void culpExecuted();

    public void requestMachinePlayerCulp(int playerIndex);

    public void refreshPlayerCards(int playerIndex);

    public void showAnimationToPunition(Player toPlayer,GamePunition gamePunition);

    public void finalizeGame(int sum);

    public void updateGameStatus(GameStatus gameStatus);
    
    public void switchActualGameColor(CardColor color);

    public void refreshStacks();

    public void acceptUserCulp();

    public void showCulpRefused();

    public void disableUserLoggedComponents();

    public void requestLoggedPlayerNewGameColor();

    public void setGamePaused(boolean b);

}
