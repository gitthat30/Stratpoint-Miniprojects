package stratpoint.samuelnieva.ServiceLayer.IMPL;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stratpoint.samuelnieva.EntityLayer.ProductEntity;
import stratpoint.samuelnieva.ServiceLayer.CartService;

/**
 * This class implements the Cart interface. It facilitates the methods to add and delete products from it, as well
 * as displaying the contents of the cart.
 */
public class CartServiceIMPL implements CartService {
    private final Logger logger;
    private List<ProductEntity> inCart;
    private double totalPrice;
    private double oldPrice; //Var to store to log
    private ProductEntity tempProduct; //Var to store object for logging

    /**
     * Instantiates a new Cart.
     */
    public CartServiceIMPL() {
        logger = LoggerFactory.getLogger(CartServiceIMPL.class);
        inCart = new ArrayList<>();
        totalPrice = 0;
    }

    public void viewProducts() {
        int counter = 0;
        for(ProductEntity p : inCart) {
            System.out.println("\nProduct #" + (counter+1) + ":");
            p.outputInfo();
            counter++;
        }
    }

    public void addProduct(ProductEntity p) {
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
        int oldSize = inCart.size();
        tempProduct = inCart.get(n);
        logger.trace("Entered delProduct with index {}", n);
        oldPrice = totalPrice;

        totalPrice -= inCart.get(n).getPrice();
        logger.debug("Total Price of Cart has been decreased to {}. Previous value was {}.", totalPrice, oldPrice);

        inCart.remove(n);

        //Check if cart is empty (removed for sure)
        if(inCart.size() == oldSize - 1)
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