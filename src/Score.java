import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Score {

	public String text;
	public Font font;
	public double x, y;
	
	public Score(String text, Font font, double x, double y) {
		
		this.text = text;
		this.font = font;
		this.x = x;
		this.y = y;
		
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setColor(Color.white);
		g2.setFont(font);
		g2.drawString(text, (float)x, (float)y);
		
	}
	
}
