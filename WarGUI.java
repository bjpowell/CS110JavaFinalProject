import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Graphical user interface for War Card game
 * 
 * @author Brendan Powell 
 * @version 4/27/2015
 */
public class WarGUI extends JFrame
{
    private War game; //the actaul wargame
    private JPanel gamePanel, buttonPanel;  // break up regions
    private JLabel title, bCard1, bCard2, display;   // static title
    private JLabel name1, numCards1, name2, numCards2;
    private JButton battleButton; //button to battle cards
    //private JButton quitButton;

    public WarGUI(String player1, String player2)
    {
        //create the game
        game = new War(player1,player2);
        
        //make a panel for the cards
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.green);
        gamePanel.setLayout(new BorderLayout());
        
        //make a panel as a scoreboard for buttons and such
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.CYAN);
        buttonPanel.setLayout(new GridLayout(1,5));
        
        //make a button to battle two cards
        battleButton = new JButton("Battle");
        battleButton.addActionListener(new ButtonListenerWar());
        
        //scoreboard labels
        name2 = new JLabel("Player 2, Cards:");
        numCards2 = new JLabel("26");
        name1 = new JLabel("Player 1, Score:");
        numCards1 = new JLabel("26");
        
        //add all this stuff to the bottom panel
        buttonPanel.add(name2);
        buttonPanel.add(numCards2);
        buttonPanel.add(battleButton);
        buttonPanel.add(name1);
        buttonPanel.add(numCards1);
        
        //title at the top of the program
        title = new JLabel("Brendan's card game of War");
        title.setFont(new Font("HELVETICA",Font.ITALIC,30));

        gamePanel.add(title, BorderLayout.NORTH);

        bCard1 = new JLabel("",new ImageIcon("back.jpg"),JLabel.CENTER);
        bCard2 = new JLabel("",new ImageIcon("back.jpg"),JLabel.CENTER);
        
        display = new JLabel("Click war to begin",JLabel.CENTER);
        
        gamePanel.add(title,BorderLayout.NORTH);
        gamePanel.add(bCard1,BorderLayout.EAST);
        gamePanel.add(bCard2,BorderLayout.WEST);
        gamePanel.add(display,BorderLayout.CENTER);
        
        gamePanel.add(buttonPanel,BorderLayout.SOUTH);

        add(gamePanel);

    }

    class ButtonListenerWar implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //activate play and battle two cards when the button is pressed
            game.play();
            
            //set all new images and text, update display
            bCard1.setIcon((game.getBattle1Card()).getImage());
            bCard2.setIcon((game.getBattle2Card()).getImage());
            display.setText(game.getHandWinner());
            numCards2.setText(game.getP2Size());
            numCards1.setText(game.getP1Size());

        }

    }
}

