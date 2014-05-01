// Conditionals and loops in drawing

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class BoxesPanel extends JPanel {
	private int invBoxDensity = 2400; // inverse box density
	private int thickness = 5, maxSide = 50;
	private int maxX = 350, maxY = 250;
	private Random generator;
	
	public BoxesPanel() {
		generator = new Random();
		
		setBackground(Color.black);
		setPreferredSize(new Dimension(400, 300));
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		int x, y, width, height;

		maxX = super.getWidth();
		maxY = super.getHeight();
		
		int numBoxes = (maxX * maxY) / invBoxDensity;
		
		maxX -= 50;	maxY -= 50;
		
		for (int count = 0; count < numBoxes; count++) {
			x = generator.nextInt(maxX) + 1;
			y = generator.nextInt(maxY) + 1;
			
			width = generator.nextInt(maxSide) + 1;
			height = generator.nextInt(maxSide) + 1;
		
			if (width <= thickness) {
				page.setColor(Color.red);
				page.fillRect(x, y, width, height);
			} else if (height <= thickness) {
				page.setColor(Color.green);
				page.fillRect(x, y, width, height);
			} else {
				page.setColor(Color.white);
				page.drawRect(x, y, width, height);
			}
		}
	}
}
