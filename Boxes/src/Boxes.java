// The main Boxes frame

import java.awt.*;
import javax.swing.*;

public class Boxes extends JFrame {
	private BoxesPanel thePanel;
	
	public Boxes() {
		thePanel = new BoxesPanel();
		getContentPane().add(thePanel);
		
		setTitle("Boxes");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) {
		Boxes theBoxes = new Boxes();
		theBoxes.setVisible(true);
	}
}
