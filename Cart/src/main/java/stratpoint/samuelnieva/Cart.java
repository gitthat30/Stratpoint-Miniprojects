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

    Cart() {
        logger = LoggerFactory.getLogger(Cart.class);
        inCart = new ArrayList<>();
        totalPrice = 0;
    }

    public void viewProducts() {
        System.out.println("List of products:");
        inCart.forEach((p) -> { p.outputInfo(); });
    }

    public void addProduct(Product p) {
        oldPrice = totalPrice;
        inCart.add(p);
        totalPrice += p.getPrice();
        logger.debug("Total Price of Cart has been increased to {}. Previous value was {}.", totalPrice, oldPrice);
    }

    public void delProduct(int n) {
        oldPrice = totalPrice;
        totalPrice += inCart.get(n).getPrice();
        logger.debug("Total Price of Cart has been decreased to {}. Previous value was {}.", totalPrice, oldPrice);

        inCart.remove(n);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        oldPrice = totalPrice;
        this.totalPrice = totalPrice;

        logger.debug("Total Price of Cart has been set to {}. Previous value was {}.", totalPrice, oldPrice);

    }
}