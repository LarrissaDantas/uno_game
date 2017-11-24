/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.game;

import view.game.GamePanelEventsInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;
import model.card.Card;
import model.card.CardModel;
import model.card.CardNormalType;
import model.player.Player;
import model.player.PlayerModel;
import model.user.User;
import model.user.UserModel;

/**
 * Modelo de jogo
 * @author LelaScarlet
 */
public class GameModel implements GamePanelEventsInterface{
    private Game actualGame;
    private GameEventsInterface gameEvents;
    
    private static GameModel myInstaModel;
    
    private GameModel(){}
    /**
     * Iniciar um novo jogo
     * @param gameMode 
     */
    public void startNewGame(GameMode gameMode){
        actualGame = new Game();
        
        //Setar o modo de jogo
        actualGame.setGameMode(gameMode);
        
        //Instanciar uma nova pilha de cartas que ja foram jogadas
        actualGame.setStackCardPlayed(new Stack());
        
        //Gerar a pilha de cartas para o jogo
        CardModel cardModel = new CardModel();
        Stack newStack = cardModel.generateCardStack();
        
        //Embaralhar cartas
        shuffleCards(newStack);
        
        //Atribuir a pilha de cartas gerada ao jogo
        actualGame.setStackCard(newStack);
        
        //Gerar os players da partida
        Player[] players = generatePlayers();
        
        actualGame.setPlayers(players);
        
        //Decidir e Atribuir o primeiro jogador
        actualGame.setFirstPlayer(generateFirstPlayer());
        actualGame.setActualPlayer(actualGame.getFirstPlayer());
        
        //Distribui as cartas
        shareUserCards(players);
        
        //Jogo criado
        actualGame.setGameStatus(GameStatus.CREATED);
    }
    public Stack<Card> actualStakCard(){
        return actualGame.getStackCard();
    }
    
    public void setGameStatusInterface(GameEventsInterface gameStatusInterface){
        this.gameEvents = gameStatusInterface;
    }
    
    
    /**
     * Retirar a primeira carta do topo da pilha
     * @return 
     */
    private Card popStackGame(){
        return actualGame.getStackCard().pop();
    }
    
    public Card getHeadStackPlayed(){
        try{
            return actualGame.getStackCardPlayed().peek();
        }catch(Exception e){
            return null;
        }
    }
    /**
     * Executar a jogada de um player 
     * @param p
     * @param cardPositon 
     */
    public void executeCulp(Player p,int cardPositon){
        
    }
    /**
     * Selecionar o jogador que iniciará o jogo
     * @return 
     */
    private int generateFirstPlayer(){
        Stack<Card> allCards = (Stack<Card>) actualGame.getStackCard().clone();
        Random random = new Random();
        int index = 0;
        for (Player player : actualGame.getPlayers()) {
            index = random.nextInt(allCards.size());
            while(isCardEspecial(allCards.get(index).getCardType())){
                index = random.nextInt(allCards.size());
            }
            player.setDrawnCard(allCards.get(index));
            allCards.remove(index);
        }
        int firstPlayer = checkCards(actualGame.getPlayers());
        return firstPlayer;
    }
    
    private boolean isCardEspecial(CardNormalType cardType) {
        switch(cardType){
            case CANCEL: return true;
            case REVERSES: return true;
            case JOKER: return true;
            case PLUS_TWO: return true;
            case PLUS_FOUR: return true;
            default:return false;
        }
    }
    
    private int checkCards(Player[] players){
        int cardBigger = -1;
        int firstPlayer = 0;//Posição do jogador a iniciar a partida
        for(int i = 0; i<players.length; i++){
            if(players[i].getDrawnCard().getCardType().getValue()>cardBigger){
                cardBigger = players[i].getDrawnCard().getCardType().getValue();
                firstPlayer = i;
            }
        }
        for(int i = 0; i<players.length; i++){
            for(int j = i+1; j<players.length; j++){
                //Se doi
                if(players[i].getDrawnCard().getCardType().getValue()==
                        players[j].getDrawnCard().getCardType().getValue()){
                        return 0;//Jogador humano (sempre vai estar na posição 0;
                }
            }
        }
        return firstPlayer;
    }
    
    /**
     * Gerar os players para nova partida
     * @return 
     */
    private Player[] generatePlayers() {
        //Primeiro player sempre é o usuario loggado
        Player p1 = new Player(UserModel.USER_LOGGED,Player.PlayerType.HUMAN);
        
        //Gerar Players Sem IA
        //TODO: Futuramente com IA
        User u2 = new User();
        u2.setName("Maquina 1");
        Player p2 = new Player(u2,Player.PlayerType.MACHINE);
        
        User u3 = new User();
        u3.setName("Maquina 2");
        Player p3 = new Player(u3,Player.PlayerType.MACHINE);
        
        User u4 = new User();
        u4.setName("Maquina 3");
        Player p4 = new Player(u4,Player.PlayerType.MACHINE);
        
        return new Player[]{p1,p2,p3,p4};
   
    }

    /***
     * Distribuir as cartas entre os players
     * @param players 
     */
    private void shareUserCards(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < 7; j++) {
                players[i].addCardsOnHand(popStackGame());
            }
        }
    }
    
    public static GameModel myInstance(){
        if(myInstaModel==null){
            myInstaModel = new GameModel();
        }
        return myInstaModel;
    }
    
    /**
     * CArregar jogo do usuari, caso exista
     * @param user
     * @return 
     */
    public boolean loadGameSavedFromUser(User user) {
        return false;
    }
    /**
     * Meotodo para embaralhar as cartas
     * @param stackCard 
     */
    private void shuffleCards(Stack<Card> stackCard) {
        ArrayList<Card> listCards = new ArrayList<>();
        while(!stackCard.isEmpty()){
            listCards.add(stackCard.pop());
        }
        Random random = new Random();
        for (int i =0;i<1000;i++) {
            int n1 = random.nextInt(listCards.size());
            
            Card auxCard = listCards.get(n1);
            
            int n2 = random.nextInt(listCards.size());
            Card auxCard2 = listCards.get(n2);
            
            listCards.set(n1, auxCard2);
            listCards.set(n2, auxCard);
        }
        Iterator<Card> iterable = listCards.iterator();
        while (iterable.hasNext()) {
            stackCard.push(iterable.next());
        }
        System.out.println(stackCard);
    }

   
    public Player[] getGamePlayers() {
            return actualGame.getPlayers();
    }

    public int getFirstPlayer() {
        return this.actualGame.getFirstPlayer();
    }
    public Player getActualPlayer(){
        return actualGame.getPlayers()[actualGame.getActualPlayerIndex()];
    }
    
    @Override
    public void onGameViewLoaded() {
        gameEvents.shareStartCards();
    }

    @Override
    public void onStartCardsShared() {
        gameEvents.distributeCards();
    }

    @Override
    public void onCardsShared() {
        if(getActualPlayer().getMyType()==Player.PlayerType.HUMAN){
            gameEvents.requestLoggedPlayerCulp();
        }else{
            resolveMachineCulp();
        }
        
    }

    private void resolveMachineCulp() {
        //UserModel 
        Player p = getActualPlayer();
        PlayerModel model = new PlayerModel();
        model.executeMachineCulp(p,getHeadStackPlayed());
        
    }
}
