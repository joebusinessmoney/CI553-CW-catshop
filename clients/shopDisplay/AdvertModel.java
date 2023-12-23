package clients.shopDisplay;

import debug.DEBUG;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.util.Observable;
import java.util.Observer;

public class AdvertModel extends Observable {

	private static final long serialVersionUID = 1L;
	
	List<String> Images;
	int currentImage;
	
	public AdvertModel() {
		
		// add image locations to the array
		
		Images = new ArrayList<>();
		Images.add("ad1.png");
		Images.add("ad2.png");
		Images.add("ad3.png");
		
		currentImage = 0;

	}
	
	public String getCurrentImage() {
		return Images.get(currentImage);  // gets current image index
	}
	
	void nextImage() {
		
		currentImage = (currentImage + 1) % Images.size(); //add 1 to current image index, loop back to start if needed
		setChanged();
		notifyObservers();
	}

}
