package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * this is an improved version of the basket class that sorts products in the basket by number and merges duplicate ones to reduce clutter on big orders
 * 
 * @author Joe Papie
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Product> productMap; // hashmap used to store products by their product number

    public BetterBasket() {
        super(); // initialises basket part of the class
        productMap = new HashMap<>();
    }

    @Override
    public boolean add(Product pr) { //overrides existing add method with new and improved
        if (productMap.containsKey(pr.getProductNum())) { // check if product is already in the basket
            Product existingProduct = productMap.get(pr.getProductNum());
            existingProduct.setQuantity(existingProduct.getQuantity() + pr.getQuantity()); // adds the quantity of the new product as well as the existing one to merge the two
        } else {
            productMap.put(pr.getProductNum(), pr); // adds it to the hashmap
        }
        super.clear();
        super.addAll(productMap.values());
        Collections.sort(this, (p1, p2) -> p1.getProductNum().compareTo(p2.getProductNum())); // sorts newly added products based on their product number
        return true;
    }

    @Override
    public void clear() {
        super.clear();
        productMap.clear();
    }
}
