import javax.swing.JFrame;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Window extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	public Graphics2D g2;
	public KL keyListener = new KL();
	public static Rect playerOne, playerTwo, ball;
	public Ball ballMovement;
	Random random = new Random();
	public PlayerController controller = new PlayerController(keyListener);
	
	public Window() {
		
		ImageIcon icone = new ImageIcon("pong.png");
		
		this.setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
		this.setTitle(Constants.SCREEN_TITLE);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icone.getImage());
		
		this.addKeyListener(keyListener);
		
		Constants.SCREEN_TOP = this.getInsets().top;
		Constants.SCREEN_BOTTOM = this.getInsets().bottom;
		
		g2 = (Graphics2D)this.getGraphics();
		
		playerOne = new Rect(40 - Constants.PADDLE_WIDTH, Constants.Y_PLAYERONE, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, new Color(237, 41, 44));
		
		playerTwo = new Rect(Constants.SCREEN_WIDTH - 40, Constants.Y_PLAYERTWO, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, new Color(0, 149, 213));
		
		ball = new Rect((Constants.SCREEN_WIDTH / 2) - (Constants.BALL_SIZE / 2), random.nextInt(Constants.SCREEN_HEIGHT - Constants.BALL_SIZE), Constants.BALL_SIZE, Constants.BALL_SIZE, Color.white);
		ballMovement = new Ball(random.nextBoolean(), random.nextBoolean());
	}
	
	public void update(double dt) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Image dbImage = createImage(getWidth(), getHeight());
		Graphics dbg = dbImage.getGraphics();
		this.draw(dbg);
		g2.drawImage(dbImage, 0, 0, this);
		
		controller.update(dt);
		
		ballMovement.BallMovement(dt);
		ballMovement.CheckWallCollision();
		ballMovement.ResetGame(random.nextBoolean(), random.nextBoolean());
		
	}
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(new Color(13, 21, 32));
		g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		
		
		Font font = new Font("Monospaced", Font.PLAIN, 100);
		Score score1 = new Score("" + Constants.SCORE_PLAYERONE, font, 100, 150);
		Score score2 = new Score("" + Constants.SCORE_PLAYERTWO, font, Constants.SCREEN_WIDTH - 200, 150);
		
		
		playerOne.draw(g2);
		playerTwo.draw(g2);
		ball.draw(g2);
		
		score1.draw(g2);
		score2.draw(g2);
		
	}
	
	@Override
	public void run() {
		
		double lastFrameTime = 0.0;
		
		while (true) {
			
			double time = Time.getTime();
			double deltaTime = time - lastFrameTime;
			lastFrameTime = time;
			
			try {
				update(deltaTime);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
