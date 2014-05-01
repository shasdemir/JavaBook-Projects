// Frame to display all that

import java.awt.*;
import javax.swing.*;

public class LeftRightFrame extends JFrame {
	private LeftRightPanel LRP;
	
	public LeftRightFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		LRP = new LeftRightPanel();
		getContentPane().add(LRP);
		pack();
	}
	
	public static void main(String[] args) {
		LeftRightFrame tinkywinky = new LeftRightFrame();
		tinkywinky.setVisible(true);
	}
}