/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.game;

import java.util.Stack;
import model.card.Card;
import model.card.CardColor;
import model.player.Player;

/**
 *
 * @author sergi
 */
public class Game {

    private Stack<Card> stackCard;
    private Stack<Card> stackCardPlayed;

    public enum Sense {
        RIGTH, LEFT
    };

    private Player[] players = new Player[4];
    private GameMode gameMode;
    private GameStatus gameStatus;
    private CardColor gameActualColor;
    private Sense gameSense;
    private boolean tableEfected;

    private int gameFirstPlayerPosition;
    private int actualPlayerPosition;
    private int[] gameTime;

    public GameMode getGameMode() {
        return gameMode;
    }

    public int[] getGameTime() {
        return gameTime;
    }

    public void setGameTime(int[] gameTime) {
        this.gameTime = gameTime;
    }

    
    public Sense getGameSense() {
        return gameSense;
    }

    public void setGameSense(Sense gameSense) {
        this.gameSense = gameSense;
    }

    public CardColor getGameActualColor() {
        return gameActualColor;
    }

    public void setGameActualColor(CardColor gameActualColor) {
        this.gameActualColor = gameActualColor;
    }

    public int getGameFirstPlayerPosition() {
        return gameFirstPlayerPosition;
    }

    public void setGameFirstPlayerPosition(int gameFirstPlayerPosition) {
        this.gameFirstPlayerPosition = gameFirstPlayerPosition;
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

    public void setFirstPlayerPosition(int selectFirstPlayer) {
        this.gameFirstPlayerPosition = selectFirstPlayer;
    }

    public int getFirstPlayerPosition() {
        return this.gameFirstPlayerPosition;
    }

    void setActualPlayerPosition(int playerPosition) {
        this.actualPlayerPosition = playerPosition;
    }

    public int getActualPlayerPosition() {
        return actualPlayerPosition;
    }

    public boolean isTableEfected() {
        return tableEfected;
    }

    public void setTableEfected(boolean tableEfected) {
        this.tableEfected = tableEfected;
    }

}
