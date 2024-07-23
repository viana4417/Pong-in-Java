import java.awt.Color;
import java.awt.Graphics2D;

public class Rect {
	
	public double x, y;
	public int width, height;
	private Color color;
	
	public Rect(int x, int y, int width, int height, Color color) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setColor(color);
		g2.fillRect((int)x, (int)y, width, height);
		
	}

}
