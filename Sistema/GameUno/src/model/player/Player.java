/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import java.util.ArrayList;
import model.card.Card;
import model.user.User;

/**
 *
 * @author sergi
 */
public class Player {
    private User user;
    /**
     * No inicio do jogo, para definir qual jogador iniciará a partida cada um recebe uma carta.
     * Ela será guardada em drawnCard
     */
    private Card drawnCard;
    private ArrayList<Card> cardsOnHand;

    public Player(User user) {
        this.user = user;
        cardsOnHand = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }
    
    public ArrayList<Card> getCardsOnHand() {
        return cardsOnHand;
    }

    public void addCardsOnHand(Card card){
        cardsOnHand.add(card);
    }
    
    public void removeCardOnHand(int index){
        cardsOnHand.remove(index);
    }
    
    public Card getDrawnCard() {
        return drawnCard;
    }

    public void setDrawnCard(Card drawnCard) {
        this.drawnCard = drawnCard;
    }
 
    
    
}
