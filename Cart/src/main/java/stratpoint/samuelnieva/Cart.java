package stratpoint.samuelnieva;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> inCart;
    private double totalPrice;

    Cart() {
        inCart = new ArrayList<>();
        totalPrice = 0;
    }

    public void viewProducts() {
        System.out.println("List of products:");
        inCart.forEach((p) -> { p.outputInfo(); });
    }

    public void addProduct(Product p) {
        inCart.add(p);
        totalPrice += p.getPrice();
    }

    public void delProduct(int n) {
        totalPrice += inCart.get(n).getPrice();
        inCart.remove(n);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}