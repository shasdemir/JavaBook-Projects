// The JFrame containing a GCDPanel

import java.awt.*;
import javax.swing.*;

public class GCDFrame extends JFrame {
	private GCDPanel thePanel;
	
	public GCDFrame() {
		setTitle("Grayscale Greatest Common Denominator");
		
		thePanel = new GCDPanel();
		add(thePanel);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		GCDFrame myFrame = new GCDFrame();
		myFrame.setVisible(true);
	}
}
