/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import model.card.CardType;

/**
 *
 * @author sdteotonio
 */
public class GameException extends Exception {
    private CardType myPunitionType;
    /**
     * Creates a new instance of <code>GameException</code> without detail
     * message.
     */
    public GameException() {
    }
    
    /**
     * Constructs an instance of <code>GameException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GameException(CardType cardType) {
        super(cardType.toString());
        this.myPunitionType =cardType;
    }
    public CardType getPunitionType(){
        return myPunitionType;
    }
}
