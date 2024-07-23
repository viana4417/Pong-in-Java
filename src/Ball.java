import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Ball {
	
	boolean up, right;
	
	Ball(boolean up, boolean right) {
		
		this.up = up;
		this.right = right;
		
	}
	
	public void ResetGame(boolean up, boolean right) {
		Random random = new Random();
		if (Window.ball.x >= Constants.SCREEN_WIDTH) {
			
			Window.ball.x = (Constants.SCREEN_WIDTH / 2) - (Constants.BALL_SIZE / 2);
			Window.ball.y = random.nextInt(Constants.SCREEN_HEIGHT - Constants.BALL_SIZE);
			Window.playerOne.y = Constants.Y_PLAYERONE;
			Window.playerTwo.y = Constants.Y_PLAYERTWO;
			Constants.BALL_SPEED = 300;
			this.up = up;
			this.right = right;
			Constants.SCORE_PLAYERONE++;
			
		}
		else if (Window.ball.x <= 0) {
			
			Window.ball.x = (Constants.SCREEN_WIDTH / 2) - (Constants.BALL_SIZE / 2);
			Window.ball.y = random.nextInt(Constants.SCREEN_HEIGHT - Constants.BALL_SIZE);
			Window.playerOne.y = Constants.Y_PLAYERONE;
			Window.playerTwo.y = Constants.Y_PLAYERTWO;
			Constants.BALL_SPEED = 300;
			this.up = up;
			this.right = right;
			Constants.SCORE_PLAYERTWO++;
			
		}
		
	}
	
	public void CheckWallCollision() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		if(Window.ball.y + Constants.BALL_SIZE >= Constants.SCREEN_HEIGHT - Constants.SCREEN_BOTTOM) {
			
			up = true;
			
		}
		else if (Window.ball.y <= Constants.SCREEN_TOP) {
			
			up = false;
			
		}
		
		if (Window.ball.y > Window.playerOne.y && Window.ball.y < Window.playerOne.y + Constants.PADDLE_HEIGHT && Window.ball.x <= 40 && Window.ball.x >= 30) {
			
			if (right == false) {
				
				Constants.BALL_SPEED += 25;
				right = true;
				Audio.audio();
				
			}

		}
		else if (Window.ball.y > Window.playerTwo.y && Window.ball.y < Window.playerTwo.y + Constants.PADDLE_HEIGHT && Window.ball.x + Constants.PADDLE_WIDTH >= Constants.SCREEN_WIDTH - 50 && Window.ball.x + Constants.PADDLE_WIDTH <= Constants.SCREEN_WIDTH - 40) {
			
			if (right == true) {
				
				Constants.BALL_SPEED += 25;
				right = false;
				Audio.audio();
				
			}
			
		}
		
	}
	
	public void BallMovement(double dt) {
		
		
		if (up == true) {
			
			Window.ball.y -= Constants.BALL_SPEED * dt;
			
		}
		else {
			
			Window.ball.y += Constants.BALL_SPEED * dt;
			
		}
	

		if (right == true) {
			
			Window.ball.x += Constants.BALL_SPEED * dt;
			
		}
		else {
			
			Window.ball.x -= Constants.BALL_SPEED * dt;
			
		}
		
	}
	
}
