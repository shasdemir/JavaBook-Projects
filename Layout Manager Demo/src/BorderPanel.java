// Demos the border layout manager

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class BorderPanel extends JPanel {
	public BorderPanel() {
		setLayout(new BorderLayout());
//		setBackground(Color.green);
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		for (int k = 1; k < 6; k++)
			buttons.add(new JButton("Button " + k));
		
		add(buttons.get(0), BorderLayout.CENTER);
		add(buttons.get(1), BorderLayout.NORTH);
		add(buttons.get(2), BorderLayout.SOUTH);
		add(buttons.get(3), BorderLayout.EAST);
		add(buttons.get(4), BorderLayout.WEST);
	}
}
