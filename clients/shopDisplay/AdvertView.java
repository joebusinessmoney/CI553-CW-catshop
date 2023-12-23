package clients.shopDisplay;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class AdvertView extends JPanel implements Observer {


	private static final long serialVersionUID = 1L;
	
	private JLabel imageLabel;
    
    public AdvertView() {
    	setLayout(new BorderLayout());
    	
    	imageLabel = new JLabel(); // images are displayed using JLabel and image icon
    	add(imageLabel, BorderLayout.CENTER);
    }
    
    public void updateImage(String Images) { // switches image using the current image file location
    	ImageIcon icon = new ImageIcon(Images);
    	imageLabel.setIcon(icon); //sets the new image
    }
    
    @Override
    
    public void update(Observable o, Object arg) {
    	if (o instanceof AdvertModel) {
    		AdvertModel advertModel = (AdvertModel) o;
    		updateImage(advertModel.getCurrentImage());
    	}
    }
}
