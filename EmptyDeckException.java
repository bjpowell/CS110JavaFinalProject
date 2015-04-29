
/**
 * expetion is thrown when a player tries to draw a card from a deck witch is empty.
 * 
 * @author Brendan Powell 
 * @version 4/27/2015
 */
public class EmptyDeckException extends IndexOutOfBoundsException
{
        public EmptyDeckException(String s) {
        super(s);
    } 
}
