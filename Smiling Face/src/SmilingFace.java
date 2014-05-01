// separate panel class will be used

import javax.swing.*;
//import javax.swing.JPanel;

public class SmilingFace {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Smiling Face");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SmilingFacePanel myPanel = new SmilingFacePanel();
		SmilingFacePanel yourPanel = new SmilingFacePanel();

		JPanel container = new JPanel();
		
		container.add(myPanel);
		container.add(yourPanel);

		myFrame.getContentPane().add(container);
		
		myFrame.pack();
		myFrame.setVisible(true);
	}
}
