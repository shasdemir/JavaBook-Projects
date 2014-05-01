// A panel that demonstrates the flow layout manager.

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class FlowPanel extends JPanel {
	public FlowPanel() {
		setLayout(new FlowLayout());
//		setBackground(Color.green);
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		for (int k = 1; k < 6; k++) {
			buttons.add(new JButton("Button " + k));
			add(buttons.get(k - 1));
		}
	}
}
