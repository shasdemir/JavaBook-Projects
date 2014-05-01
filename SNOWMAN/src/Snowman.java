// Trying to draw a snowman!

import javax.swing.JApplet;
import java.awt.*;

public class Snowman extends JApplet
{
	public void paint(Graphics page)
	{
		final int MID = 150;
		final int TOP = 50;
		
		//getContentPane().setBackground(Color.cyan);
		Color skyBlue = new Color(135, 206, 250);
		page.setColor(skyBlue);
		page.fillRect(0, 0, 300, 500);
		
		Color Bisque2 = new Color(238, 213, 183); // brown-ish
		page.setColor(Bisque2);
		page.fillRect(0, 175, 300, 50);  // ground
		
		page.setColor(Color.yellow);
		page.fillOval(-40, -40, 80, 80); // sun
		
		page.setColor(Color.white);
		page.fillOval(MID-20, TOP, 40, 40);	// head
		page.fillOval(MID-35, TOP+35, 70, 50);	// upper torso
		page.fillOval(MID-50, TOP+80, 100, 60);	// lover torso
		
		page.setColor(Color.black);
		page.fillOval(MID-10, TOP+10, 5, 5); //eyes
		page.fillOval(MID+5, TOP+10, 5, 5);
		
		page.drawArc(MID-10, TOP+20, 20, 10, 190, 160); // smile
		
		page.drawLine(MID-25, TOP+60, MID-50, TOP+40); // arms
		page.drawLine(MID+25, TOP+60, MID+55, TOP+60);
		
		page.drawLine(MID-20, TOP+5, MID+20, TOP+5); // brim of hat
		page.fillRect(MID-15, TOP-20, 30, 25); // top of hat
		
		Color HadisinRengi = new Color(255, 0, 0);
		page.setColor(HadisinRengi);
		page.drawString("Hadis'ten merhabalar!", 5, 80);
		
		Color orange = new Color(255, 69, 0);
		page.setColor(orange);
		page.fillOval(MID-2, TOP+15, 5, 5);
		
		
	}
}
