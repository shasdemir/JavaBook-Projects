// the panel that will act like a canvas for our dynamic polyline

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.ArrayList;

public class PolyLineDrawPanel extends JPanel {
	private ArrayList<Point> borders;
	private Point previousClickPoint;
	private Point movingPoint;
	
	public PolyLineDrawPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(600, 600));
		
		previousClickPoint = null;
		movingPoint = null;
		
		borders = new ArrayList<Point>();
		
		addMouseListener(new polyMouseListener());
		addMouseMotionListener(new polyMouseListener());
	}
	
	
	public void clearCanvas() {
		borders.clear();
		repaint();
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		if (borders.size() != 0) {
			int[] xBorders = new int[borders.size()];
			int[] yBorders = new int[borders.size()];
			
			for (int k = 0; k < borders.size(); k++) {
				xBorders[k] = borders.get(k).x;
				yBorders[k] = borders.get(k).y;
			}
			
			page.drawPolyline(xBorders, yBorders, xBorders.length);
			
			if (previousClickPoint != null && movingPoint != null)
				page.drawLine(previousClickPoint.x, previousClickPoint.y, 
						movingPoint.x, movingPoint.y);
		}
	}
	
	
	private class polyMouseListener implements MouseListener, 
	MouseMotionListener {
		public void mouseClicked(MouseEvent event) {
			previousClickPoint = event.getPoint();
			borders.add(previousClickPoint);
			repaint();
		}

		
		public void mouseMoved(MouseEvent event) {
			movingPoint = event.getPoint();
			repaint();
		}
		
		
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		public void mouseDragged(MouseEvent event) {}
	}
}
