// Demo of the box layout manager

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class BoxPanel extends JPanel {
	public BoxPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		setBackground(Color.green);
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		for (int k = 1; k < 6; k++)
			buttons.add(new JButton("Button " + k));
		
		add(buttons.get(0));
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(buttons.get(1));
		add(Box.createVerticalGlue());
		add(buttons.get(2));
		add(buttons.get(3));
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(buttons.get(4));
	}
}
