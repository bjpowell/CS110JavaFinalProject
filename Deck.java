import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Class deck creats a deck of 52 playing cards and stores them in an array list
 * 
 * @author Brendan Powell
 * @version 4/17/2015
 */
public class Deck
{
    private ArrayList<Card> deckOfCards = new ArrayList<Card>();
    private final int FIRST_CARD = 1;
    /**
     * this array holds the sting names of the deck of cards
     * index 0 is the back image of a card
     */
    private String imageNames[] = {"back.jpg","aces.jpg","acec.jpg","aceh.jpg","aced.jpg",
            "2s.jpg","2c.jpg","2h.jpg","2d.jpg",
            "3s.jpg","3c.jpg","3h.jpg","3d.jpg",
            "4s.jpg","4c.jpg","4h.jpg","4d.jpg",
            "5s.jpg","5c.jpg","5h.jpg","5d.jpg",
            "6s.jpg","6c.jpg","6h.jpg","6d.jpg",
            "7s.jpg","7c.jpg","7h.jpg","7d.jpg",
            "8s.jpg","8c.jpg","8h.jpg","8d.jpg",
            "9s.jpg","9c.jpg","9h.jpg","9d.jpg",
            "10s.jpg","10c.jpg","10h.jpg","10d.jpg",
            "jacks.jpg","jackc.jpg","jackh.jpg","jackd.jpg",
            "queens.jpg","queenc.jpg","queenh.jpg","queend.jpg",
            "kings.jpg","kingc.jpg","kingh.jpg","kingd.jpg"};
    /**
     * Constructor creats a deck of 52 playing cards, then shuffles the deck twice
     */
    public Deck()
    {
        int imageIndex = 0;
        for(int i = 1; i<=13;i++)
        {
            for(int j = 1; j <=4; j++)
            {
                imageIndex++;
                Card tempCard = new Card(j,i,imageNames[imageIndex]);
                deckOfCards.add(tempCard);
            }
        }

        //shuffles the deck after creation
        shuffle();
        shuffle();

    }

    /**
     * randomized the deck of cards
     * uses the collections.shuffle method
     */
    public void shuffle()
    {
        Collections.shuffle(deckOfCards);
    }

    /**
     * draws the first card from the top of the deck and does not return it to the deck
     * trims the deck to size after the card is removed
     * @return Card
     */
    public Card drawWithoutRepl()
    {
        Card topCard = deckOfCards.get(0);
        deckOfCards.remove(0);
        deckOfCards.trimToSize();

        return topCard;
    }
}
