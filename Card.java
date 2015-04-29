import javax.swing.*;
/**
 * public class card represents a single playing card out of a deck of 52 playing cards
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card
{
    public final int SPADES = 1;
    public final int CLUBS = 2;
    public final int HEARTS = 3;
    public final int DIAMONDS = 4;
    
    public final int ACE = 1;
    public final int JACK = 11;
    public final int QUEEN = 12;
    public final int KING = 13;
    
    private ImageIcon image;
    private int suit;
    private int rank;
    
    /**
     * Constructor for objects of class Card
     * @param int suit
     * @param int rank
     * @param String image
     */
    public Card(int kind, int number, String imageName)
    {
        suit = kind;
        rank = number;
        image = new ImageIcon(imageName);
    }
    
    /**
     * returns the card's suit
     * @return int suit
     */
    public int getSuit()
    {
        return suit;
    }
    
    /**
     * returns the card's rank
     * @return int rank
     */
    public int getRank()
    {
        return rank;
    }
    
    /**
     * tests to see if two cards contain the same rank
     * @param card object
     */
    public boolean equals(Card card2)
    {
        boolean status = false;
        if(getRank() == card2.getRank())
        {
            status = true;
        }
        return status;
    }
    
    /**
     * test to see if this card is greater in numeric rank than the arguments
     * @return boolean
     */
    public boolean greaterThan(Card card2)
    {
        boolean status = false;
        if(getRank() > card2.getRank())
        {
            status = true;
        }
        return status;
    }
    
    /**
     * test to see if this card is less in numeric rank than the arguments
     * @return boolean
     */
    public boolean lessThan(Card card2)
    {
        boolean status = false;
        if(getRank() < card2.getRank())
        {
            status = true;
        }
        return status;
    }
    
    
    /**
     * returns the card image icon to be set up the constructor
     * and used by the GUI
     * @return ImageIcon
     */
    public ImageIcon getImage()
    {
        return image;
    }
    
    /**
     * to string method prints a cards identity in terms of its suit and rank
     * @return String
     */
    public String toString()
    {
        String stra = "";
        
        switch(getRank())
        {
            case 1:
                stra +="Ace ";
                break;
            case 11:
                stra +="Jack ";
                break;
            case 12:
                stra +="Queen ";
                break;
            case 13:
                stra +="King ";
                break;
            default:
                stra += getRank() + " ";
                break;
        }
        
        stra +="of ";
        
        switch(getSuit())
        {
            case 1:
                stra +="Spades";
                break;
            case 2:
                stra +="Clubs";
                break;
            case 3:
                stra +="Hearts";
                break;
            case 4:
                stra +="Diamonds";
                break;
        }
        
        //return the concadinated name of the card in a string form.
        return stra;
    }
    
}
