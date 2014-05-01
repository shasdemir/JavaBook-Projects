// the main frame (lol)

import java.awt.*;
import javax.swing.*;

public class DotsFrame extends JFrame {
	private DotsPanel thePanel;
	
	public DotsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		thePanel = new DotsPanel();
		getContentPane().add(thePanel);
		
		setTitle("The Dots");
		pack();
	}
	
	public static void main(String[] args) {
		DotsFrame myFrame = new DotsFrame();
		myFrame.setVisible(true);
	}
}
