/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.game;

import java.util.Stack;
import model.card.Card;
import model.player.Player;


/**
 *
 * @author sergi
 */
public class Game {
    private Stack<Card> stackCard;
    private Stack<Card> stackCardPlayed;
    
    private Player[] players = new Player[4];
    private GameMode gameMode;
    private GameStatus gameStatus;
    
    public GameMode getGameMode() {
        return gameMode;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Stack<Card> getStackCardPlayed() {
        return stackCardPlayed;
    }

    public void setStackCardPlayed(Stack stackCardPlayed) {
        this.stackCardPlayed = stackCardPlayed;
    }
    
    

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }
    
    
    public Stack<Card> getStackCard() {
        return stackCard;
    }

    public void setStackCard(Stack stackCard) {
        this.stackCard = stackCard;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
    
    
}
