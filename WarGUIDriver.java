import javax.swing.*;
/**
 * Write a description of class WarGUIDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WarGUIDriver
{
    public static void main(String [] args)
    {
        JFrame frame = new WarGUI("jack", "Jill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // OR
        //frame.setSize(900,900);
        //frame.validate();
        frame.setVisible(true);

   
    }
}
