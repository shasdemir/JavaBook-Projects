/**
 * Created with IntelliJ IDEA.
 * User: shasdemir
 * Date: 1/8/13
 * Time: 5:37 PM
 * To change this template use File | Settings | File Templates.
 */

import java.awt.*;
import javax.swing.*;

public class DisplayColor {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Display Color");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.white);
        colorPanel.setPreferredSize(new Dimension(300, 100));

        myFrame.getContentPane().add(colorPanel);
        myFrame.pack();
        myFrame.setVisible(true);

        Color shade = Color.white;
        int again;

        do {
            shade = JColorChooser.showDialog(myFrame, "Pick a color.", shade);
            colorPanel.setBackground(shade);

            again = JOptionPane.showConfirmDialog(null,
                    "Display another color?");

        } while (again == JOptionPane.YES_OPTION);
    }
}
