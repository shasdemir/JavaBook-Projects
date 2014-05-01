// Frame to hold an OffCenterPanel

import java.awt.*;
import javax.swing.*;

public class OffCenter extends JFrame {
	private OffCenterPanel myPanel;
	
	public OffCenter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Off Center");
		
		myPanel = new OffCenterPanel();
		getContentPane().add(myPanel);
		pack();
	}
	
	
	public static void main(String[] args) {
		OffCenter myFrame = new OffCenter();
		myFrame.setVisible(true);
	}
}
