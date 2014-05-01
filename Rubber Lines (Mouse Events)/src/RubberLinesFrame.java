// generic panel holder frame with RubberLinesPanel

import java.awt.*;
import javax.swing.*;

public class RubberLinesFrame extends JFrame {
	private RubberLinesPanel thePanel;
	
	public RubberLinesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		thePanel = new RubberLinesPanel();
		getContentPane().add(thePanel);
		
		setTitle("The Rubber Lines");
		pack();
	}
	
	public static void main(String[] args) {
		RubberLinesFrame myFrame = new RubberLinesFrame();
		myFrame.setVisible(true);
	}
}
