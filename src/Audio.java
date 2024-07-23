import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
	
	public static void audio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
	File bonk = new File("bonk.wav");
	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bonk);
	Clip clip = AudioSystem.getClip();
	clip.open(audioStream);
	clip.start();
	
	}
	
}
