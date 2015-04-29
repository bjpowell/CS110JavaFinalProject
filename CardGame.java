
/**
 * Abstract class CardGame -defines simple paramters for any two person card game
 * 
 * 
 * @author Brendan Powell
 * @version 4/17/2015
 */
public abstract class CardGame
{
    //stores the names of each player
    private String player1;
    private String player2;
    
    public CardGame(String name1, String name2)
    {
        setPlayer1(name1);
        setPlayer2(name2);
    }
    
    
    /**
     * Sets the name of player 1
     * @param String name
     */
    public void setPlayer1(String name)
    {
        player1 = name;
    }
    
    /**
     * Sets the name of player 2
     * @param
     */
    public void setPlayer2(String name)
    {
        player2 = name;
    }
    
    /**
     * returns the name of player 1
     * @return String name
     */
    public String getPlayer1()
    {
        return player1;
    }
    
    /**
     * returns the name of player 2
     * @return String name
     */
    public String getPlayer2()
    {
        return player2;
    }
}
