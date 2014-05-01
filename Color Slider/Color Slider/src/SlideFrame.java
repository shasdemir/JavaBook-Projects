// the container form

import javax.swing.*;
import java.awt.*;

public class SlideFrame extends JFrame {
    SlideColorPanel myPanel;

    public SlideFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Slide Colors");

        myPanel = new SlideColorPanel();

        getContentPane().add(myPanel);
        pack();
    }


    public static void main(String[] args) {
        SlideFrame myFrame = new SlideFrame();
        myFrame.setVisible(true);
    }
}
