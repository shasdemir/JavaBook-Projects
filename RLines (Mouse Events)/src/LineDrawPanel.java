// drawing panel for the LineDraw program

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LineDrawPanel extends JPanel {
	private ArrayList<Line> linesDrawn;
	private final double THICKNESS = 10;
	
	private class Line {
		private Point startPoint = null, endPoint = null;
		private double x1, x2, y1, y2;
		private double xDiff, yDiff; // Forming a rectangle with thickness:
		private int[] xBorders; // THICKNESS.
		private int[] yBorders;
		private double lineLength;
		
		public void setStartPoint(Point startPoint) {
			this.startPoint = startPoint;
		}
		
		
		public void setEndPoint(Point endPoint) {
			this.endPoint = endPoint;
		}
		
		
		public void draw(Graphics page) {
			if (startPoint != null && endPoint != null) {
				if (THICKNESS != 1) {
					x1 = startPoint.x;
					x2 = endPoint.x;
					y1 = startPoint.y;
					y2 = endPoint.y;
					
					lineLength = Math.sqrt(Math.pow(y2 - y1, 2) + 
							Math.pow(x2 -x1, 2));
					
					xBorders = new int[4]; // 4 borders of a rectangle
					yBorders = new int[4];
					
					xDiff = ((y2 - y1) / lineLength) * (THICKNESS / 2);
					yDiff = ((x2 - x1) / lineLength) * (THICKNESS / 2);
					
					// If we casted these to int directly without rounding, 
					// they would be rounded down, decreasing the thickness
					// of the lines. round() rounds to the nearest long, which
					// is more accurate.
					xBorders[0] = (int) Math.round(x1 - xDiff);
					xBorders[1] = (int) Math.round(x2 - xDiff);
					xBorders[2] = (int) Math.round(x2 + xDiff);
					xBorders[3] = (int) Math.round(x1 + xDiff);
					
					yBorders[0] = (int) Math.round(y1 + yDiff);
					yBorders[1] = (int) Math.round(y2 + yDiff);
					yBorders[2] = (int) Math.round(y2 - yDiff);
					yBorders[3] = (int) Math.round(y1 - yDiff);
					
					page.setColor(Color.black);
					page.fillPolygon(xBorders, yBorders, 4); // rectangle
					
					// now, to make the end points smoother:
					page.fillOval((int)(x1 - (THICKNESS / 2)), 
							(int)(y1 - (THICKNESS / 2)),
							(int)THICKNESS, (int)THICKNESS);
					
					page.fillOval((int)(x2 - (THICKNESS / 2)), 
							(int)(y2 - (THICKNESS / 2)),
							(int)THICKNESS, (int)THICKNESS);
				} else
				page.drawLine(startPoint.x, startPoint.y, 
						endPoint.x, endPoint.y);
			}
		}
	}
	
	private class LineListener implements MouseListener, MouseMotionListener {
		public void mousePressed(MouseEvent event) {
			Line currentLine = new Line();
			currentLine.setStartPoint(event.getPoint());
			linesDrawn.add(currentLine);
		}
		
		
		public void mouseDragged(MouseEvent event) {
			linesDrawn.get(linesDrawn.size()-1).setEndPoint(event.getPoint());
			repaint();
		}
		
		
		public void mouseClicked(MouseEvent event) {
			mousePressed(event);
			mouseDragged(event);
		}
		
		
		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseMoved(MouseEvent event) {}
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		for (Line oneLine : linesDrawn)
			oneLine.draw(page);
	}
	
	
	public LineDrawPanel() {
		LineListener listener = new LineListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
		linesDrawn = new ArrayList<Line>();
		
		setBackground(Color.white);
		setPreferredSize(new Dimension(700, 700));
	}
}
