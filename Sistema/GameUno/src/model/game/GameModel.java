/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.game;

import exception.GameException;
import view.game.GamePanelEventsInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.card.Card;
import model.card.CardModel;
import model.card.CardType;
import model.game.Game.Sense;
import model.player.Player;
import model.user.User;
import model.user.UserModel;
import util.AppLog;

/**
 * Modelo de jogo
 *
 * @author LelaScarlet
 */
public class GameModel implements GamePanelEventsInterface {

    private Game actualGame;
    private GameEventsInterface gameEvents;

    private static GameModel myInstaModel;

    private GameModel() {
    }

    /**
     * Iniciar um novo jogo
     *
     * @param gameMode
     */
    public void startNewGame(GameMode gameMode) {
        actualGame = new Game();

        //Setar o modo de jogo
        actualGame.setGameMode(gameMode);

        //Definir o sentido inicial do jogo
        actualGame.setGameSense(Sense.RIGTH);

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
        actualGame.setFirstPlayerPosition(generateFirstPlayer());

        //Atribuir o jogador da vez
        actualGame.setActualPlayerPosition(actualGame.getFirstPlayerPosition());

        //Distribui as cartas
        shareUserCards(players);

        //Jogo criado
        actualGame.setGameStatus(GameStatus.CREATED);

    }

    public Stack<Card> getActualStakCard() {
        return actualGame.getStackCard();
    }

    public void setGameStatusInterface(GameEventsInterface gameStatusInterface) {
        this.gameEvents = gameStatusInterface;
    }

    /**
     * Retirar a primeira carta do topo da pilha
     *
     * @return
     */
    private Card popStackGame() {
        return actualGame.getStackCard().pop();
    }

    /**
     * Metodo para buscar a primeira carta da pilha de cartas joigadas
     *
     * @return
     */
    private Card getHeadStackPlayed() {
        try {
            return actualGame.getStackCardPlayed().peek();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Selecionar o jogador que iniciará o jogo
     *
     * @return
     */
    private int generateFirstPlayer() {
        Stack<Card> allCards = (Stack<Card>) actualGame.getStackCard().clone();
        Random random = new Random();
        int index = 0;
        for (Player player : actualGame.getPlayers()) {
            index = random.nextInt(allCards.size());
            while (isEspecialCard(allCards.get(index).getCardType())) {
                index = random.nextInt(allCards.size());
            }
            player.setStartCard(allCards.get(index));
            allCards.remove(index);
        }
        int firstPlayer = checkCards(actualGame.getPlayers());
        return firstPlayer;
    }

    private int checkCards(Player[] players) {
        int cardBigger = -1;
        int firstPlayer = 0;//Posição do jogador a iniciar a partida
        for (int i = 0; i < players.length; i++) {
            if (players[i].getStartCard().getCardType().getValue() > cardBigger) {
                cardBigger = players[i].getStartCard().getCardType().getValue();
                firstPlayer = i;
            }
        }
        for (int i = 0; i < players.length; i++) {
            for (int j = i + 1; j < players.length; j++) {
                //Se doi
                if (players[i].getStartCard().getCardType().getValue()
                        == players[j].getStartCard().getCardType().getValue()) {
                    return 0;//Jogador humano (sempre vai estar na posição 0;
                }
            }
        }

        return firstPlayer;
    }

    /**
     * Gerar os players para nova partida
     *
     * @return
     */
    private Player[] generatePlayers() {
        //Primeiro player sempre é o usuario loggado
        Player p1 = new Player(UserModel.USER_LOGGED, Player.PlayerType.HUMAN);

        //Gerar Players Sem IA
        //TODO: Futuramente com IA
        User u2 = new User();
        u2.setName("Maquina 1");
        Player p2 = new Player(u2, Player.PlayerType.MACHINE);

        User u3 = new User();
        u3.setName("Maquina 2");
        Player p3 = new Player(u3, Player.PlayerType.MACHINE);

        User u4 = new User();
        u4.setName("Maquina 3");
        Player p4 = new Player(u4, Player.PlayerType.MACHINE);

        return new Player[]{p1, p2, p3, p4};

    }

    /**
     * *
     * Distribuir as cartas entre os players
     *
     * @param players
     */
    private void shareUserCards(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < 7; j++) {
                players[i].addCardsOnHand(popStackGame());
            }
        }
    }

    /**
     * *
     * Single
     *
     * @return
     */
    public static GameModel myInstance() {
        if (myInstaModel == null) {
            myInstaModel = new GameModel();
        }
        return myInstaModel;
    }

    /**
     * Carregar jogo do usuario, caso exista
     *
     * @param user
     * @return
     */
    public boolean loadGameSavedFromUser(User user) {
        return false;
    }

    /**
     * Meotodo para embaralhar as cartas
     *
     * @param stackCard
     */
    private void shuffleCards(Stack<Card> stackCard) {
        ArrayList<Card> listCards = new ArrayList<>();
        while (!stackCard.isEmpty()) {
            listCards.add(stackCard.pop());
        }
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
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
        System.out.println("Pilha embaralhada: " + stackCard);
    }

    /**
     * Metodo para buscar todos os jogadores
     *
     * @return
     */
    public Player[] getGamePlayers() {
        return actualGame.getPlayers();
    }

    /**
     * *
     *
     * @return A posicao do jogador definido para iniciar a partida
     */
    public int getFirstPlayer() {
        return this.actualGame.getFirstPlayerPosition();
    }

    /**
     * *
     *
     * @return O jogador da vez
     */
    public Player getActualPlayer() {
        return actualGame.getPlayers()[actualGame.getActualPlayerPosition()];
    }

    @Override
    public void onGameViewLoaded() {
        gameEvents.shareStartCards();
    }

    @Override
    public void onStartCardsShared() {
        actualGame.setGameStatus(GameStatus.CREATED);
        gameEvents.distributeCards();
    }

    @Override
    public void onCardsShared() {
        actualGame.setGameStatus(GameStatus.RUNNING);

        if (getActualPlayer().getMyType() == Player.PlayerType.HUMAN) {
            gameEvents.requestLoggedPlayerCulp();
        } else {
            gameEvents.requestMachinePlayerCulp(actualGame.getActualPlayerPosition());
        }

    }

    @Override
    public void userLoggedCulp(Card cardToPlay) {
        //JOGADA DE USUARIO

    }

    @Override
    public void machineCulp() {
        //JOGADA DE IA
        System.out.println("Machine Culp");
       
            //TODO: Verificar se há algum efeito de jogo para ser aplicado
            //Verificar se a pilha esta vazia para poder jogar
            if (actualGame.getStackCardPlayed().isEmpty()) {
                System.out.println("Pilha de jogadas esta vazia");
                executeCulp(0);
            } else {
                executeCulp(0);
            }
     
        gameEvents.culpExecuted();

    }

    @Override
    public void userCulp(int cardIndex)  {
        //JOGADA DE USUARIO
        System.out.println("User Culp");
        //TODO: Verificar se há algum efeito de jogo para ser aplicado

        //Verificar se a pilha esta vazia para poder jogar
        if (actualGame.getStackCardPlayed().isEmpty()) {
            System.out.println("Pilha de jogadas esta vazia");
            executeCulp(cardIndex);
        } else {
            executeCulp(cardIndex);
        }
        gameEvents.culpExecuted();

    }

    private void verifyPunition() throws GameException {
        //Verificar punicao
        if (actualGame.isTableEfected()) {
            System.out.println("Carta de punição na mesa: " + getHeadStackPlayed().getCardType().toString());
            //EXECUTA A PUNICAO E RETIRA O EFEITO DA MESA
            switch (getHeadStackPlayed().getCardType()) {
                case CANCEL:
                    changePlayer();
                    actualGame.setTableEfected(false);
                    System.out.println("Player :"+getActualPlayer().getUser().getName() + " recebeu uma punição de "+getHeadStackPlayed().getCardType().toString());
                    throw new GameException(" punição de cancelar");
                case PLUS_TWO:
                    plusCardToActualPlayer(2);
                    changePlayer();
                    actualGame.setTableEfected(false);
                    System.out.println("Player :"+getActualPlayer().getUser().getName() + " recebeu uma punição de "+getHeadStackPlayed().getCardType().toString());
                    throw new GameException(" punição de +2");

                case PLUS_FOUR:
                    plusCardToActualPlayer(4);
                    changePlayer();
                    actualGame.setTableEfected(false);
                    System.out.println("Player :"+getActualPlayer().getUser().getName() + " recebeu uma punição de "+getHeadStackPlayed().getCardType().toString());
                    throw new GameException(" punição de +4");
            }

        }

    }

    private void executeCulp(int cardIndex) {
        Card cardToPlay = getActualPlayer().getCardsOnHand().get(cardIndex);
        //@Teste
        if (isPunitionCard(cardToPlay.getCardType())) {
            actualGame.setTableEfected(true);
        }

        getActualStakCardPlayed().push(cardToPlay);
        actualGame.setGameActualColor(cardToPlay.getCardColor());
        getActualPlayer().getCardsOnHand().remove(cardIndex);
        changePlayer();
        /*
        //Testar se é possivel jogar
        if (!actualGame.getStackCardPlayed().isEmpty()) {
            Card headStackPlayed = getHeadStackPlayed();

            //A carta da mao é normal e da mesa tbm
            if (isNormalCard(cardToPlay.getCardType()) && isNormalCard(headStackPlayed.getCardType())) {
                //Se elas possuem o mesmo numero ou a mesma cor
                if (((cardToPlay.getCardType().getValue() == headStackPlayed.getCardType().getValue()))
                        || cardToPlay.getCardColor().equals(headStackPlayed.getCardColor())) {
                    //JOGADA

                } else {
                    //JOGADA RECUSADA
                }
                // A carta da mao é normal e a da mesa é um joker ou um +4
            } else if (isNormalCard(cardToPlay.getCardType()) && ((headStackPlayed.getCardType().equals(CardType.JOKER)) || (headStackPlayed.getCardType().equals(CardType.PLUS_FOUR)))) {//CARTA JOGADA FOR NORMAL E A  DA MESA FOR UM JOKER
                //Se for a mesma cor definida no jogo
                if (cardToPlay.getCardColor().equals(actualGame.getGameActualColor())) {
                    //JOGADA
                } else {
                    //JOGADA RECUSADA
                }
                //A carta da mao é normal e a da mesa é uma carta de efeito 
            } else if (isNormalCard(cardToPlay.getCardType()) && (isEfectCard(headStackPlayed.getCardType()))) {
                //Se elas possuem a mesma cor
                if (cardToPlay.getCardColor().equals(headStackPlayed.getCardColor())) {
                    //JOGADA
                } else {
                    //JOGADA RECUSADA
                }
                //A carta da mao é especial e a da mesa é normal
            } else if (isEspecialCard(cardToPlay.getCardType()) && isNormalCard(headStackPlayed.getCardType())) {
                if (isEfectCard(cardToPlay.getCardType())) {
                    //Se for de efeito, testa apenas a cor 
                    if (cardToPlay.getCardColor().equals(headStackPlayed.getCardColor())) {
                        //JOGADA
                    } else {
                        //JOGADA RECUSDA 
                    }
                } else {
                    //è um JOKER ou +4

                    //JOGADA
                }
                //A carta da mao é de efeito e da mesa tbm
            } else {
                //JOGADA RECUSADA
            }
            //Nao existe carta na mesa
        } else {
            //Pode Jogar quaquer carta 
            getActualStakCardPlayed().push(cardToPlay);
            actualGame.setGameActualColor(cardToPlay.getCardColor());
            changePlayer();

        }
         */
    }

    private boolean isNormalCard(CardType cardType) {
        switch (cardType) {
            case ZERO:
                return true;
            case ONE:
                return true;
            case TWO:
                return true;
            case THREE:
                return true;
            case FOUR:
                return true;
            case FIVE:
                return true;
            case SIX:
                return true;
            case SEVEN:
                return true;
            case EIGHT:
                return true;
            case NINE:
                return true;
            default:
                return false;
        }
    }

    private boolean isEspecialCard(CardType cardType) {
        switch (cardType) {
            case CANCEL:
                return true;
            case REVERSES:
                return true;
            case JOKER:
                return true;
            case PLUS_TWO:
                return true;
            case PLUS_FOUR:
                return true;
            default:
                return false;
        }
    }

    private boolean isEfectCard(CardType cardType) {
        switch (cardType) {
            case REVERSES:
                return true;
            case JOKER:
                return true;
            default:
                return false;
        }
    }

    private boolean isPunitionCard(CardType cardType) {
        switch (cardType) {
            case CANCEL:
                return true;
            case PLUS_TWO:
                return true;
            case PLUS_FOUR:
                return true;
            default:
                return false;
        }
    }

    /**
     * Metodo para mudar para o proximo jogador
     */
    private void changePlayer() {
        int side = 1;
        if (actualGame.getGameSense().equals(Sense.LEFT)) {
            side = -1;
        }
        int actualPosition = actualGame.getActualPlayerPosition();
        boolean positionNotSeted = true;
        while (positionNotSeted) {
            actualPosition += side;

            if (actualPosition >= 4) {
                actualPosition = 0;
            } else if (actualPosition < 0) {
                actualPosition = 3;
            }

            actualGame.setActualPlayerPosition(actualPosition);
            positionNotSeted = false;

        }

    }

    public Card[] getCountCardsStackPlayed(int i) {
        Stack<Card> t = (Stack<Card>) actualGame.getStackCardPlayed().clone();
        Card[] cards = new Card[i];
        for (int j = 0; j < i; j++) {
            try {
                cards[j] = t.pop();
            } catch (Exception e) {
                System.out.println("(Jogada) Pilha de cartas jogadas nao possui cartas suficientes para retornar às :" + i + " cartas iniciais");
            }
        }
        return cards;
    }

    public Card[] getCountCardsStack(int i) {
        Stack<Card> t = (Stack<Card>) actualGame.getStackCard().clone();
        Card[] cards = new Card[i];
        for (int j = 0; j < i; j++) {
            try {
                cards[j] = t.pop();
            } catch (Exception e) {
                System.out.println("(Não Jogada) Pilha de cartas nao possui cartas suficientes para retornar às :" + i + " cartas iniciais");
            }
        }
        return cards;
    }

    public int getActualPlayerPosition() {
        return actualGame.getActualPlayerPosition();
    }

    private void plusCardToActualPlayer(int quant) {
        try {
            for (int i = 0; i < quant; i++) {
                getActualPlayer().getCardsOnHand().add(getActualStakCard().pop());
            }
        } catch (Exception e) {
            System.out.println("Pilha de cartas está vazia");
            AppLog.error("Pilha de cartas está vazia");
        }
    }

    private Stack<Card> getActualStakCardPlayed() {
        return actualGame.getStackCardPlayed();
    }

    @Override
    public void onViewUpdate() {
        try {
            verifyPunition();
            if (getActualPlayer().getMyType() == Player.PlayerType.HUMAN) {
                gameEvents.requestLoggedPlayerCulp();
            } else {
                gameEvents.requestMachinePlayerCulp(actualGame.getActualPlayerPosition());
            }
        } catch (GameException ex) {
            gameEvents.culpExecuted();
            System.out.println("Punição na mesa");
        }
    }

}
