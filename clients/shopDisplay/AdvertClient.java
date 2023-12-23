package clients.shopDisplay;

import middle.MiddleFactory;
import middle.Names;
import middle.RemoteMiddleFactory;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 * The standalone shop Display Client.
 * @author  Mike Smith University of Brighton
 * @version 2.0
 */
public class AdvertClient
{
   public static void main (String args[])
   {
     String stockURL = args.length < 1     // URL of stock RW
                     ? Names.STOCK_RW      //  default  location
                     : args[0];            //  supplied location
     String orderURL = args.length < 2     // URL of order
                     ? Names.ORDER         //  default  location
                     : args[1];            //  supplied location
     
    RemoteMiddleFactory mrf = new RemoteMiddleFactory();
    mrf.setStockRWInfo( stockURL );
    mrf.setOrderInfo  ( orderURL );        //
    //advertGUI(mrf);                       // Create GUI
  }
  
//  private static void advertGUI(MiddleFactory mf)
//  {     
//    JFrame  window = new JFrame();
//
//    window.setTitle( "Pick Client MVC");
//    window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//    
//    AdvertModel    model = new  AdvertModel(mf);
//    AdvertView     view  = new  AdvertView( window, mf, 0, 0 );
//    AdvertController cont  = new AdvertController( model, view );
//    view.setController( cont );
//
//    model.addObserver( view );       // Add observer to the model
//    window.setVisible(true);         // Display Screen 
//  }
}
