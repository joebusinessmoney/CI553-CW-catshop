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

public class AdvertView {

    public static class ImageLabel extends JPanel implements Serializable {
        private static final long serialVersionUID = 1L;
        private BufferedImage img;

        public ImageLabel() {
            try {
                img = ImageIO.read(getClass().getResource("/testing/ad.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }

            // Set the initial size (width and height) of the ImageLabel
            setPreferredSize(new Dimension(400, 300)); // Set your desired width and height
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();
            g.drawImage(img, 0, 0, width, height, null);
        }
    }

    public static class Image {

        public Image() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame frame = new JFrame("Image Viewer");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    ImageLabel imageLabel = new ImageLabel();
                    frame.add(imageLabel, BorderLayout.CENTER);

                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            });
        }
    }

    public static void main(String[] args) throws Exception {
        new Image();
    }
}
