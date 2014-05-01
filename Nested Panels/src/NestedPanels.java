// Nested panels

import java.awt.*;
import javax.swing.*;

public class NestedPanels {
	//--------------------------------------
	// Two colored panels inside a third
	//--------------------------------------
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Nested Panels Example");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Setting up the first subpanel
		JPanel subPanel1 = new JPanel();
		subPanel1.setPreferredSize(new Dimension(150, 100));
		subPanel1.setBackground(Color.green); // awful taste
		JLabel label1 = new JLabel("One");
		subPanel1.add(label1);
		
		// second subpanel
		JPanel subPanel2 = new JPanel();
		subPanel2.setPreferredSize(new Dimension(150, 100));
		subPanel2.setBackground(Color.red);
		JLabel label2 = new JLabel("Two");
		subPanel2.add(label2);
		
		// Primary panel
		JPanel primary = new JPanel();
		primary.setBackground(Color.blue);
		primary.add(subPanel1);
		primary.add(subPanel2);
		
		myFrame.getContentPane().add(primary);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}
