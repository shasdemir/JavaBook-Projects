// whatever
// the picture becomes too fast!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReboundPanel extends JPanel {
	private final int WIDTH = 600, HEIGHT = 600;
	private final int DELAY = 10, IMAGE_SIZE = 100;
	
	private ImageIcon image;
	private Timer timer;
	private int x, y, moveX, moveY;
	
	public ReboundPanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		
		image = new ImageIcon("Clojure-icon.png");
		
		x = 0;
		y = 40;
		moveX = moveY = 1;
		
		timer = new Timer(DELAY, new ReboundListener());
		timer.start();
		
		addMouseListener(new StartStopListener());
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		image.paintIcon(this, page, x, y);
	}
	
	
	private class ReboundListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			x += moveX;
			y += moveY;
			
			if (x <= 0 || x >= getWidth() - IMAGE_SIZE)
				moveX *= -1;
			
			if (y <= 0 || y >= getHeight() - IMAGE_SIZE)
				moveY *= -1;
			
			repaint();
		}
	}
	
	
	private class StartStopListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (timer.isRunning())
				timer.stop();
			else
				timer.start();
		}
	}
}
