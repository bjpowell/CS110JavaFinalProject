import java.util.*;
/**
 * Public Class War sets up a war card game with two players and a standard deck of 52 playing cards
 * 
 * @author Brendan Powell 
 * @version 4/20/2015
 */
public class War extends CardGame
{
    //each player has half the deck of cards to play war with
    private ArrayList<Card> player1Deck = new ArrayList<Card>();
    private ArrayList<Card> player2Deck = new ArrayList<Card>();
    
    private Card battle1Card;
    private Card battle2Card;
    private String handWinner;
    
    //basically an arena to contain the cards at war
    public ArrayList<Card> battlePile = new ArrayList<Card>();
    /**
     * 
     */
    public War(String p1, String p2)
    {
        super(p1,p2);
        Deck warDeck = new Deck();
        dealHands(warDeck);
    }
    
    /**
     * sets the sting of the winning hand
     */
    public void setHandWinner(String s)
    {
        handWinner = s;    
    }
    
    /**
     * gets the winner of the current hand
     */
    public String getHandWinner()
    {
        return handWinner;
    }
    
    /**
     * method returns the card being played by player 1
     */
    public Card getBattle1Card()
    {
        return battle1Card;
    }
    
    /**
     * method returns the card being played by player 2
     */
    public Card getBattle2Card()
    {
        return battle2Card;
    }
    
    
    /**
     * method sets the card being played by player 1
     */
    public void setBattle1Card(Card x)
    {
        battle1Card = x;
    }
    
    /**
     * method sets the card being played by player 2
     */
    public void setBattle2Card(Card x)
    {
        battle2Card = x;
    }
    
    /**
     * Method splits the deck and diveds it into the player1 and player 2 decks evenly
     * @param Deck d
     */
    public void dealHands(Deck d)
    {
        for(int i = 1; i <=52; i++)
        {
            if(i%2 == 0) 
            {
                player1Deck.add(d.drawWithoutRepl());
            }
            else
            {
                player2Deck.add(d.drawWithoutRepl());
            }
        }
    }
    
    /**
     * draws the top card from player1's deck
     * @return Card
     */
    public Card player1Draw() throws EmptyDeckException
    {
        if(player1Deck.size() >=1)
        {
            Card x = player1Deck.get(0);
            player1Deck.remove(0);
            player1Deck.trimToSize();
            return x;
        }
        else
        {
            throw new EmptyDeckException("Player 1 has no remaining cards");
        }
    }
    
    /**
     * draws the top card from player2's deck
     * @return Card
     */
    public Card player2Draw() throws EmptyDeckException
    {
        if(player2Deck.size() >= 1)
        {
            Card x = player2Deck.get(0);
            player2Deck.remove(0);
            player2Deck.trimToSize();
            return x;
        }
        else
        {
            throw new EmptyDeckException("Player 2 has no remaining cards");
        }
    }
    
    /**
     * method returns how many cards player 1 has
     * @return String num cards
     */
    public String getP1Size()
    {
        return Integer.toString(player1Deck.size());
    }
    
    /**
     * method returns how many cards player 2 has
     * @return String num cards
     */
    public String getP2Size()
    {
        return Integer.toString(player2Deck.size());
    }
    
    
    
    /**
     * method draws two players cards and duals them, returns 1 if player 1 wins or 2 of player 2 wins
     * method also puts all of the battle cards into the winning players deck, but in the back of that deck
     * this method uses  ****RECURSION****
     * @return int winner
     */
    public int battle() throws EmptyDeckException
    {
        try
        {
            int winner = 0;
            
            Card p1 = player1Draw();
            //System.out.println("player 1 draws a " + p1.toString());    // for cmd windown
            setBattle1Card(p1);
            
            Card p2 = player2Draw();
            //System.out.println("player 2 draws a " + p2.toString());    // for cmd window
            setBattle2Card(p2);
            
            battlePile.add(p1);
            battlePile.add(p2);
            
            if(p1.greaterThan(p2))
            {
                winner = 1;
                //add battle pile to the end of the players list
                int len = player1Deck.size();
                player1Deck.addAll(len,battlePile);
                battlePile.clear();
                //System.out.println("player 1 wins this hand "); ///ihoiuhi
            }
            else if(p1.lessThan(p2))
            {
                winner = 2;
                //smasies
                int len = player2Deck.size();
                player2Deck.addAll(len,battlePile);
                battlePile.clear();
                //System.out.println("Player 2 wins this hand ");
            }
            else
            {
                for(int i = 0; i < 3; i++) //burns 3 cards before calling
                {
                    battlePile.add(player1Draw());
                    battlePile.add(player2Draw());
                    //System.out.println("War! 3 cards are burned");
                }
                
                //this is the pint where recusion is used***************
                battle();
            }
            
            return winner;
        }
        catch(EmptyDeckException e)
        {
            //if the empty deck eception is thrown that means one of the players
            //has no cards left, the game is over and the other player wins
            return 0;
            
            
        }
    }
    
    /**
     * play should continuously call battle until one of the players has no cards left.
     * when one player owns the entire deck or the other player cant produce the cards to continue playing
     * the player with the most cards wins
     */
    public void play()
    {
        int x;
        x = battle();
        if(x == 1)
        {
            setHandWinner("Player 1 Wins this hand");
        }
        else if(x==2)
        {
            setHandWinner("Player 2 wins this hand");
        }
        else
        {
            setHandWinner(winnerOfWar());
        }
    }
    
    
    /**
     * returns a string name of the winning player
     * @return string name
     */
    public String winnerOfWar()
    {
        String winningPlayer;
        if(player1Deck.size() == 0)
        {
            winningPlayer = "Player 2 Wins!";
        }
        else
        {
            winningPlayer = "Player 1 Wins!";
        }
        
        return winningPlayer;
    }
    
}
