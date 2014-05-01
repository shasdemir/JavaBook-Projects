// Draws a map of Greatest common denominators of x and y coordinates of pixels

import java.awt.*;
import javax.swing.*;

public class GCDPanel extends JPanel {
	private int gcdValue;
	private Color pixelColor;
	
	public GCDPanel() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(1000, 1000));
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		for (int j = 1; j < 1000; j++) {
			for (int k = j; k < 1000; k++) {
				gcdValue = RationalNumber.gcd((int)(j/5)+1, (int)(k/5)+1);
				
				if (gcdValue != 1)
					gcdValue = 255;
					
				pixelColor = new Color(gcdValue, gcdValue, gcdValue);
				page.setColor(pixelColor);
				page.drawLine(k, j, k, j);
			}
		}
	}
}
