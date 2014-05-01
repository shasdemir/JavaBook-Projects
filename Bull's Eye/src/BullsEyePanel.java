// a panel that draws a bull's eye

import java.awt.*;
import javax.swing.JPanel;

public class BullsEyePanel extends JPanel {
	private final int MAX_WIDTH = 300, NUM_RINGS = 5, RING_WIDTH = 25;
	
	public BullsEyePanel() {
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(300, 300));
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		int x = 0, y = 0, diameter = MAX_WIDTH;
		
		page.setColor(Color.white);
		
		for (int count = 0; count < NUM_RINGS; count++) {
			if (page.getColor() == Color.black) // alternate colors
				page.setColor(Color.white);
			else
				page.setColor(Color.black);
			
			page.fillOval(x, y, diameter, diameter);
			
			diameter -= (2 * RING_WIDTH);
			x += RING_WIDTH;
			y += RING_WIDTH;
		}
		
		// Red dot in the center
		page.setColor(Color.red);
		page.fillOval(x, y, diameter, diameter);
	}
}
