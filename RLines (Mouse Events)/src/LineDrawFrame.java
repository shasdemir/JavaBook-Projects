// generic panel holder frame with LineDrawPanel

import java.awt.*;
import javax.swing.*;

public class LineDrawFrame extends JFrame {
	private LineDrawPanel thePanel;
	
	public LineDrawFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		thePanel = new LineDrawPanel();
		getContentPane().add(thePanel);
		
		setTitle("The Rubber Lines");
		pack();
	}
	
	public static void main(String[] args) {
		LineDrawFrame myFrame = new LineDrawFrame();
		myFrame.setVisible(true);
	}
}
