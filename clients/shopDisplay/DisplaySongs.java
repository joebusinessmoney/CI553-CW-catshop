package clients.shopDisplay;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class DisplaySongs {
	
		  Clip clip;
		  AudioInputStream audioInputStream;
		  static String filePath = "song1.wav";
	
	  public void musicPlayer()  {
		  
		  try {
			  audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
			  clip = AudioSystem.getClip();
			  clip.open(audioInputStream);
			  clip.start();
			  clip.loop(Clip.LOOP_CONTINUOUSLY);
			  
		  } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			  e.printStackTrace();
		  }
		  
	  }

}
