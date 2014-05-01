// The grid layout manager demo.

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GridPanel extends JPanel {
	public GridPanel() {
		setLayout(new GridLayout(2, 3));
//		setBackground(Color.green);
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		for (int k = 1; k < 6; k++) {
			buttons.add(new JButton("Button " + k));
			add(buttons.get(k - 1));
		}
	}
}
