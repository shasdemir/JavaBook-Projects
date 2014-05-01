// no, it won't be yellow.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class OffCenterPanel extends JPanel {
	final int WIDTH = 300, HEIGHT = 300;
	int midX, midY;
	Line theLine;
	double distance;
	String caption, distText;
	DecimalFormat distFormatter;
	
	private class Line {
		private Point startingPoint, endingPoint;
		
		private Line(Point startPoint, Point endPoint) {
			startingPoint = startPoint;
			endingPoint = endPoint;
		}
		
		
		public double getLength() {
			return (Math.sqrt(Math.pow(endingPoint.y - startingPoint.y, 2) + 
					Math.pow(endingPoint.x - startingPoint.x, 2)));
		}
		
		
		public void draw(Graphics page) {
			if (startingPoint != null && endingPoint != null) {
				page.setColor(Color.black);
				
				page.drawLine(startingPoint.x, startingPoint.y,
						endingPoint.x, endingPoint.y);
			}
		}
	}
	
	
	private class ocListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			midX = getWidth() / 2;
			midY = getHeight() / 2;
			
			theLine = new Line(new Point(midX, midY), e.getPoint());
			distText = distFormatter.format(theLine.getLength());
				
			repaint();
		}
	}
	
	
	public OffCenterPanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.white);
		
		caption = "The distance to the center is: ";
		distFormatter = new DecimalFormat("0.##");
		addMouseListener(new ocListener());
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		page.drawString(caption + distText, 20, 20);
		
		if (theLine != null)
			theLine.draw(page);
	}
}
