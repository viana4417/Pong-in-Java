import java.awt.event.KeyEvent;

public class PlayerController {

	public KL keyListener;
	
	PlayerController(KL keyListener) {
		
		this.keyListener = keyListener;
		
	}
	
	public void update(double dt) {
		
		if (keyListener.isKeyPressed(KeyEvent.VK_W)) {
			
			if (Window.playerOne.y >= Constants.SCREEN_TOP) {
				Window.playerOne.y -= 400 * dt;
			}
		
		}
		else if (keyListener.isKeyPressed(KeyEvent.VK_S)) {
			
			if (Window.playerOne.y + Constants.PADDLE_HEIGHT <= Constants.SCREEN_HEIGHT - Constants.SCREEN_BOTTOM) {
				Window.playerOne.y += 400 * dt;
			}
		}
		if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
			
			if (Window.playerTwo.y >= Constants.SCREEN_TOP) {
				Window.playerTwo.y -= 400 * dt;
			}
			
		}
		else if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
			
			if (Window.playerTwo.y + Constants.PADDLE_HEIGHT <= Constants.SCREEN_HEIGHT - Constants.SCREEN_BOTTOM) {
				Window.playerTwo.y += 400 * dt;
			}
			
		}
		
		
	}
	
}
