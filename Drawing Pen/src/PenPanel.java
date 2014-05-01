// drawing panel for the LineDraw program

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PenPanel extends JPanel {
	private ArrayList<Circle> circlesDrawn;
	private final int RADIUS = 1;
	
	private class Circle {
		private Point middlePoint;
		private int x, y;
		
		public Circle(Point midPoint) {
			middlePoint = midPoint;
			
			x = middlePoint.x - RADIUS;
			y = middlePoint.y - RADIUS;
		}
		
		
		public void draw(Graphics page) {
			page.setColor(Color.black);
			page.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
		}
	}
	
	private class LineListener implements MouseListener, MouseMotionListener {
		public void mousePressed(MouseEvent event) {
			Circle currentCircle = new Circle(event.getPoint());
			circlesDrawn.add(currentCircle);
			repaint();
		}
		
		
		public void mouseDragged(MouseEvent event) {
			mousePressed(event);
		}
		
		
		public void mouseClicked(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseMoved(MouseEvent event) {}
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		for (Circle oneCircle : circlesDrawn)
			oneCircle.draw(page);
	}
	
	
	public PenPanel() {
		LineListener listener = new LineListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
		circlesDrawn = new ArrayList<Circle>();
		
		setBackground(Color.white);
		setPreferredSize(new Dimension(700, 700));
	}
}
