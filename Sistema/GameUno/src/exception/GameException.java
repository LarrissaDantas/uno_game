/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import model.game.GamePunition;

/**
 *
 * @author sdteotonio
 */
public class GameException extends Exception {

    private GamePunition myPunitionType;

    /**
     * Creates a new instance of <code>GameException</code> without detail
     * message.
     */
    public GameException() {
    }

    public GameException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of <code>GameException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GameException(GamePunition gamePunition) {
        super(gamePunition.toString());
        this.myPunitionType = gamePunition;
    }

    public GamePunition getPunitionType() {
        return myPunitionType;
    }
}
