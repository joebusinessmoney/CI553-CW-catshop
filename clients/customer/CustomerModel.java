package clients.customer;

import catalogue.Basket;
import catalogue.Product;
import debug.DEBUG;
import middle.MiddleFactory;
import middle.OrderProcessing;
import middle.StockException;
import middle.StockReader;

import javax.swing.*;
import java.util.HashMap;
import java.util.Observable;

public class CustomerModel extends Observable {
    private Product theProduct = null;          // Current product
    private Basket theBasket = null;            // Bought items

    private String pn = "";                    // Product being processed

    private StockReader theStock = null;
    private OrderProcessing theOrder = null;
    private ImageIcon thePic = null;

    
    private HashMap<String, String> stringToIDMap = new HashMap<>(); // hashmap that will store the possible user string entries to the product ids

    public CustomerModel(MiddleFactory mf) {
        try {
            theStock = mf.makeStockReader();  
        } catch (Exception e) {
            DEBUG.error("CustomerModel.constructor\n" +
                    "Database not created?\n%s\n", e.getMessage());
        }
        theBasket = makeBasket();  

        
        populateProductMap(); // fill product hashmap
    }

    
    private void populateProductMap() { // method to fill product hashmap
        stringToIDMap.put("tv", "0001");
        stringToIDMap.put("television", "0001");
        stringToIDMap.put("radio", "0002");
        stringToIDMap.put("toaster", "0003");
        stringToIDMap.put("watch", "0004");
        stringToIDMap.put("camera", "0005");
        stringToIDMap.put("mp3 player", "0006");
        stringToIDMap.put("mp3", "0006");
        stringToIDMap.put("usb", "0007");
    }

    public Basket getBasket() {
        return theBasket;
    }

    public void doCheck(String userSearch) {
        theBasket.clear();  // clear shopping basket
        String theAction = "";
        String userInputTrimmed = userSearch.trim().toLowerCase();  // remove spaces and stuff as well as convert to lowercase to avoid case sensitivity
        pn = userInputTrimmed;
        int amount = 1;
        
        try {
            if (userInputTrimmed.matches("\\d+")) { 
            	if (theStock.exists(pn)) {						// in the case the user input is an id
                    Product pr = theStock.getDetails(pn);
                    if (pr.getQuantity() >= amount) {			// display product details (no change from original docheck)
                        theAction = String.format("%s : %7.2f (%2d) ",
                                pr.getDescription(),
                                pr.getPrice(),
                                pr.getQuantity());
                        pr.setQuantity(amount);
                        theBasket.add(pr);
                        thePic = theStock.getImage(pn);
                    } else {
                        theAction = pr.getDescription() + " not in stock";	// in the case product is out of stock
                    }
                } else {
                    theAction = "Unknown product number " + pn;	// or unkown product number
                }
            } else {   									// in the case the user input is a string
                if (stringToIDMap.containsKey(userInputTrimmed)) {	//check if the string has been mapped to an id
                    String mappedProductID = stringToIDMap.get(userInputTrimmed); // turn user input into the id that was mapped to the string
                    doCheck(mappedProductID);									// re-run check using the generated id
                } else {
                    doCheck(userInputTrimmed); // re-run check as regular search using product id
                }
            }
        } catch (StockException e) {
            DEBUG.error("CustomerClient.doCheck()\n%s", e.getMessage());
        }

        setChanged();
        notifyObservers(theAction);
    }

    public void doClear() {
        String theAction = "";
        theBasket.clear();  // clear basket
        theAction = "Enter Product Number";  // set display
        thePic = null;  // clear picture
        setChanged();
        notifyObservers(theAction);
    }

    public void doExpand(boolean expanded) { //increase customer client size
        if (expanded) {
            setChanged();
            notifyObservers("REVERT");
        } else {
            setChanged();
            notifyObservers("EXPAND");
        }
    }

    public ImageIcon getPicture() {
        return thePic;
    }

    private void askForUpdate() {
        setChanged();
        notifyObservers("START only");  
    }

    protected Basket makeBasket() {
        return new Basket();
    }
}
