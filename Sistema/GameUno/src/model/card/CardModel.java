/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.card;

import java.util.ArrayList;
import java.util.Stack;



/**
 *
 * @author sergi
 */
public class CardModel {
    public static ArrayList<CardNormalType>  normalCardTypes = new ArrayList<>();
    public static ArrayList<CardNormalType> especialCardTypes = new ArrayList<>();
    public static ArrayList<CardNormalType> jokerCardTypes = new ArrayList<>();
    
    private ArrayList<Card> redCardList,greenCardList,blueCardList,yellowCardList,especialCardList;
    
    public CardModel(){
        //ArrayList Normal
        normalCardTypes.add(CardNormalType.ZERO);
        normalCardTypes.add(CardNormalType.ONE);
        normalCardTypes.add(CardNormalType.TWO);
        normalCardTypes.add(CardNormalType.THREE);
        normalCardTypes.add(CardNormalType.FOUR);
        normalCardTypes.add(CardNormalType.FIVE);
        normalCardTypes.add(CardNormalType.SIX);
        normalCardTypes.add(CardNormalType.SEVEN);
        normalCardTypes.add(CardNormalType.EIGHT);
        normalCardTypes.add(CardNormalType.NINE);
                    
        //Especial Cartas
        especialCardTypes.add(CardNormalType.CANCEL);
        especialCardTypes.add(CardNormalType.PLUS_TWO);
        especialCardTypes.add(CardNormalType.REVERSES);
        //Joker cards
        jokerCardTypes.add(CardNormalType.JOKER);
        jokerCardTypes.add(CardNormalType.PLUS_FOUR);
    }
    public Stack generateCardStack(){
        Stack<Card> newStack = new Stack<>();
        //Gerar cartas normais
        generateNormalCards();
        
        //Gerar cartas especiais
        generateEspecialCards();
        
        
        
//        System.out.println(blueCardList);
//        System.out.println(greenCardList);
//        System.out.println(yellowCardList);
//        System.out.println(redCardList);
//        System.out.println(especialCardList);

    newStack.addAll(redCardList);
    newStack.addAll(greenCardList);
    newStack.addAll(blueCardList);
    newStack.addAll(yellowCardList);
    newStack.addAll(especialCardList);
    
    System.out.println("model.card.CardModel.generateCardStack()\n" + newStack + "\n Stack Size("+newStack.size()+")");
    
    return newStack;
    }

    private void generateNormalCards() {
        blueCardList = new ArrayList<>();
        greenCardList = new ArrayList<>();
        yellowCardList = new ArrayList<>();
        redCardList = new ArrayList<>();
        //Criar cartas normais
        for(int i=0;i<normalCardTypes.size();i++){
            if(normalCardTypes.get(i)==CardNormalType.ZERO){
                Card cRed = new Card(CardNormalType.ZERO,CardColor.RED,"images/cartas/vermelha/0.png");
                Card cBlue = new Card(CardNormalType.ZERO,CardColor.BLUE,"images/cartas/azul/0.png");
                Card cYellow = new Card(CardNormalType.ZERO,CardColor.YELLOW,"images/cartas/amarela/0.png");
                Card cGreen = new Card(CardNormalType.ZERO,CardColor.GREEN,"images/cartas/verde/0.png");
                redCardList.add(cRed);
                blueCardList.add(cBlue);
                yellowCardList.add(cYellow);
                greenCardList.add(cGreen);
            }else{
                 //Pra cada cor
                Card cRed = new Card(normalCardTypes.get(i),CardColor.RED,"images/cartas/vermelha/"+normalCardTypes.get(i).getValue()+".png");
                Card cBlue = new Card(normalCardTypes.get(i),CardColor.BLUE,"images/cartas/azul/"+normalCardTypes.get(i).getValue()+".png");
                Card cYellow = new Card(normalCardTypes.get(i),CardColor.YELLOW,"images/cartas/amarela/"+normalCardTypes.get(i).getValue()+".png");
                Card cGreen = new Card(normalCardTypes.get(i),CardColor.GREEN,"images/cartas/verde/"+normalCardTypes.get(i).getValue()+".png");

                redCardList.add(cRed);
                blueCardList.add(cBlue);
                yellowCardList.add(cYellow);
                greenCardList.add(cGreen);
                
                redCardList.add(cRed);
                blueCardList.add(cBlue);
                yellowCardList.add(cYellow);
                greenCardList.add(cGreen);
            }  
        }
                
    }

    private void generateEspecialCards() {
        especialCardList = new ArrayList<>();
        //Para as cores
        for (int i = 0; i < especialCardTypes.size(); i++) {
                Card cRed = new Card(especialCardTypes.get(i),CardColor.RED,"images/cartas/vermelha/"+especialCardTypes.get(i).toString()+".png");
                Card cBlue = new Card(especialCardTypes.get(i),CardColor.BLUE,"images/cartas/azul/"+especialCardTypes.get(i).toString()+".png");
                Card cYellow = new Card(especialCardTypes.get(i),CardColor.YELLOW,"images/cartas/amarela/"+especialCardTypes.get(i).toString()+".png");
                Card cGreen = new Card(especialCardTypes.get(i),CardColor.GREEN,"images/cartas/verde/"+especialCardTypes.get(i).toString()+".png");
                
                redCardList.add(cRed);
                blueCardList.add(cBlue);
                yellowCardList.add(cYellow);
                greenCardList.add(cGreen);
                
                redCardList.add(cRed);
                blueCardList.add(cBlue);
                yellowCardList.add(cYellow);
                greenCardList.add(cGreen);
        }
        
        //Para +4 e Coringa
        for (int i = 0; i < jokerCardTypes.size(); i++) {
            Card cPlusFour = new Card(CardNormalType.PLUS_FOUR,CardColor.NEUTRON,"images/cartas/plus_4.png");
            Card cJoker = new Card(CardNormalType.JOKER,CardColor.NEUTRON,"images/cartas/joker.png");
            
            especialCardList.add(cPlusFour);
            especialCardList.add(cJoker);
            
            especialCardList.add(cPlusFour);
            especialCardList.add(cJoker);
                
        }
    }
        
 
}
