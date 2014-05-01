// draw more

import javax.swing.JApplet;
import java.awt.*;

public class Einstein2 extends JApplet{
	public void paint(Graphics page)
	{
		page.drawRect(50, 50, 40, 40);
		page.drawRect(60, 80, 225, 30);
		page.drawOval(75, 65, 20, 20);
		page.drawLine(35, 60, 100, 120);
		
		page.drawString("Out of clutter, find simplicity.", 110, 70);
		page.drawString("-- Albert Einstein", 130, 100);
		
		for (int k = 1; k < 11; k++)
		{
			page.drawOval(75, 65 + 10*k, 20, 20 + 5*k);
			
		}
	}
}
