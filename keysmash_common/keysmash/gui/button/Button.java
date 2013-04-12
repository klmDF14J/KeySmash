package keysmash.gui.button;

import org.newdawn.slick.geom.Rectangle;


public class Button {
	public float startX;
	public float startY;
	public float xLength;
	public float yLength;
	
	public Button(float x1, float y1, float x2, float y2) {
		super();
		startX = x1;
		startY = y1;
		xLength = x2;
		yLength = y2;
	}

	
	public Rectangle getBounds() {
		return new Rectangle(startX, startY, xLength, yLength); 
	}
	
	public float getStartX() {
		return startX;
	}
	
	public float getStartY() {
		return startY;
	}
	
	
	public float getXLength() {
		return xLength;
	}
	
	public float getYLength() {
		return yLength;
	}
}
