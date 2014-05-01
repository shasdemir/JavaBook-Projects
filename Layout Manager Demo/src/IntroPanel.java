// The introduction panel for the Layout Tester program.

import java.awt.*;
import javax.swing.*;

public class IntroPanel extends JPanel {
	public IntroPanel() {
//		setBackground(Color.green);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel l1 = new JLabel("Layout Manager Demonstration");
		JLabel l2 = new JLabel("Choose a tab to see an example of a layout" + 
							   " manager.");
		add(l1);
		add(Box.createRigidArea(new Dimension(0, 30)));
		add(l2);
	}
}
