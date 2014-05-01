// This represents a yellow window

import java.awt.*;
import javax.swing.*;

public class YellowWindow {
	private int width, height, upperX, upperY;
	
	private Color windowColor;	// not changeable
	
	public YellowWindow(int width, int height, int upperX, int upperY) {
		this.width= width;
		this.height = height;
		this.upperX = upperX;
		this.upperY = upperY;
		
		windowColor = Color.yellow;
	}
	
	public void draw(Graphics myContext) {
		myContext.setColor(windowColor);
		myContext.fillRect(upperX, upperY, width, height);
	}
}