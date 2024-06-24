package stratpoint.samuelnieva;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cart {
    private final Logger logger;
    private List<Product> inCart;
    private double totalPrice;
    private double oldPrice; //Var to store to log
    private Product tempProduct; //Var to store object for logging

    Cart() {
        logger = LoggerFactory.getLogger(Cart.class);
        inCart = new ArrayList<>();
        totalPrice = 0;
    }

    public void viewProducts() {
        System.out.println("List of products:");

        int counter = 0;
        for(Product p : inCart) {
            System.out.println("\nProduct #" + (counter+1) + ":");
            p.outputInfo();
            counter++;
        }
    }

    public void addProduct(Product p) {
        logger.trace("Entered addProduct with product {}", p.getName());

        oldPrice = totalPrice;

        //Set random ID in the case of duplicates. This is so the delProduct check works
        p.setID(Math.random());

        inCart.add(p);
        logger.debug("Product {} added to productList", inCart.get(inCart.size()-1).getName());

        totalPrice += p.getPrice();
        logger.debug("Total Price of Cart has been increased to {}. Previous value was {}.", totalPrice, oldPrice);
    }

    public void delProduct(int n) {
        n--;
        tempProduct = inCart.get(n);
        logger.trace("Entered delProduct with index {}", n);
        oldPrice = totalPrice;

        totalPrice -= inCart.get(n).getPrice();
        logger.debug("Total Price of Cart has been decreased to {}. Previous value was {}.", totalPrice, oldPrice);

        inCart.remove(n);

        //Check if cart is empty (removed for sure)
        //Compare the ID of the product within the original index is the same as the stored product's ID to see if they're different
        if(inCart.isEmpty() || (inCart.get(n).getID() == tempProduct.getID()))
            logger.debug("Product {} successfully removed from productList", tempProduct.getName());
        else
            logger.error("Failed to remove product {}", tempProduct);

    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getCartSize() {
        return inCart.size();
    }
}