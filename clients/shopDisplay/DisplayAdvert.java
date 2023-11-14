package clients.shopDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class DisplayAdvert extends JFrame {

	private static final long serialVersionUID = 1L;
	
	List<ImageIcon> Images;
	int currentImage;
	JLabel imageLabel;
	
	public DisplayAdvert() {
		
		// add image locations to the array
		
		Images = new ArrayList<>();
		Images.add(new ImageIcon ("ad1.png"));
		Images.add(new ImageIcon ("ad2.png"));
		Images.add(new ImageIcon ("ad3.png"));
		
		setTitle("Advertisement");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		imageLabel = new JLabel();
		add(imageLabel, BorderLayout.CENTER);
		
		currentImage = 0;
		
		imageLooper(); 
	}
	
	void imageLooper() {
		
		Timer timer = new Timer(10000, new ActionListener() { // will swap images every 10 seconds
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextImage();
				
			}
		});
				timer.start();
		
	}
	
	void nextImage() {
		
		ImageIcon icon = Images.get(currentImage); //load next image
		imageLabel.setIcon(icon);				   //display image
		
		currentImage = (currentImage + 1) % Images.size(); //add 1 to current image index, loop back to start if needed
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new DisplayAdvert().setVisible(true);
			}
		});
		
	}
}
