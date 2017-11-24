/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import model.card.Card;
import model.card.CardModel;

/**
 *
 * @author sergi
 */
public class PlayerModel {
    
    public Card executeCulp(Player p,int cardPlayed,Card stackCardPlayed){
        Card headStackPlayed = stackCardPlayed;
        Card playerCard = p.getCardsOnHand().get(cardPlayed);
        //Cartas do mesmo tipo
        if(headStackPlayed != null){
            if(CardModel.normalCardTypes.contains(playerCard.getCardType())){
                System.out.println("Carta normal");
                if(stackCardPlayed.getCardColor()==playerCard.getCardColor()){
                    //TODO: Continuar logica de jogada
                }
            }else if(CardModel.especialCardTypes.contains(playerCard.getCardType())){
                System.out.println("Carta de efeito");
            }
        }else{
            //
        }
        
        return null;
    }

    public Card executeMachineCulp(Player p, Card stackCardPlayed) {
        //IA de jogo
        return null;
    }   
}
