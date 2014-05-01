// ok, all in a single file now, for whatever reason...

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class RubberCircleFrame extends JFrame {
	private circleCanvas myCanvas;
	
	public RubberCircleFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Draw Some Circles!");
		
		myCanvas = new circleCanvas();
		getContentPane().add(myCanvas);
		pack();
	}
	
	
	public static void main(String[] args) {
		RubberCircleFrame myFrame = new RubberCircleFrame();
		myFrame.setVisible(true);
	}
	
	
	private class circleCanvas extends JPanel {
		private ArrayList<Circle> myCircles;
		private Point currentMidPoint;
		private double currentRadius;
		private boolean mouseMoving;
		
		private class Circle {
			private Point midPoint;
			private double radius;
			
			public Circle(Point midPoint, double radius) {
				this.midPoint = midPoint;
				this.radius = radius;
			}	
			
			
			public void draw(Graphics page) {
					int drawingR = (int) radius;
					
					page.setColor(Color.black);
					page.drawOval(midPoint.x - drawingR, midPoint.y - drawingR,
							drawingR * 2, drawingR * 2);
			}
		}
		
		
		public circleCanvas() {
			setBackground(Color.white);
			setPreferredSize(new Dimension(600, 500));
			
			myCircles = new ArrayList<Circle>();
			mouseMoving = false;
			
			addMouseListener(new circleListener());
			addMouseMotionListener(new circleListener());
		}
		
		
		public void paintComponent(Graphics page) {
			super.paintComponent(page);
			
			for (Circle cCircle : myCircles)
				cCircle.draw(page);
		}
		
		
		public class circleListener implements MouseListener, 
			MouseMotionListener {
			public void mousePressed(MouseEvent e) {
				currentMidPoint = e.getPoint();
				repaint();
			}
			
			
			public void mouseDragged(MouseEvent e) {
				if (mouseMoving)
					myCircles.remove(myCircles.size() - 1);
				mouseMoving = true;
				
				currentRadius = Math.sqrt(Math.pow(e.getPoint().y - 
						currentMidPoint.y, 2) 
						+ Math.pow(e.getPoint().x - currentMidPoint.x, 2));
				
				Circle currentCircle = new Circle(currentMidPoint, 
						currentRadius);
				myCircles.add(currentCircle);
				
				repaint();
			}
			
			
			public void mouseReleased(MouseEvent e) {
				mouseMoving = false;
			}

			
			public void mouseMoved(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		}
	}
}