// generic panel holder frame with PenPanel

import java.awt.*;
import javax.swing.*;

public class PenFrame extends JFrame {
	private PenPanel thePanel;
	
	public PenFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		thePanel = new PenPanel();
		getContentPane().add(thePanel);
		
		setTitle("A Drawing Pen");
		pack();
	}
	
	public static void main(String[] args) {
		PenFrame myFrame = new PenFrame();
		myFrame.setVisible(true);
	}
}
