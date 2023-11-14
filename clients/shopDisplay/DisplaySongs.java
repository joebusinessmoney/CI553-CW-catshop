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
		  AudioInputStream song;
		  static String filePath = "song1.wav";
	
	  public void musicPlayer()  {
		  
		  try {
			  song = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile()); //gets the song from the given file path
			  clip = AudioSystem.getClip();
			  clip.open(song);
			  clip.start(); // starts the song
			  clip.loop(Clip.LOOP_CONTINUOUSLY); // loops the song
			  
		  } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			  e.printStackTrace();
		  }
		  
	  }

}
