package stratpoint.samuelnieva.ServiceLayer;

import stratpoint.samuelnieva.EntityLayer.ProductEntity;

/**
 * The CartService interface represents a cart from an e-commerce website. It contains information related to a cart
 * which can then be searched for, added and deleted from the lists in the Cart and Catalog classes.
 */
public interface CartService {

    /**
     * Iterates through the list of products in the cart and uses the outputInfo
     * function to display the information on the product.
     */
    public void viewProducts();

    /**
     * Adds a product to the productList variable. In addition to this, the method
     * also adds the price of the added product ot the totalPrice of the cart.
     *
     * @param p   The Product object to be added to the list
     */
    public void addProduct(ProductEntity p);

    /**
     * Deletes a product from the list. The list used in this function is the
     * variable named: productList. This method also subtracts the price of that
     * product from the totalPrice of the cart.
     *
     * @param n  The index of the product to be removed from the list (First index = 1).
     */
    public void delProduct(int n);

    /**
     * Returns the total price of all items in the cart. The cart's total
     * is increased and decreased in the addProduct and delProduct to remove the
     * need to iterate through the list and tally the price.
     *
     * @return the total price
     */
    public double getTotalPrice();

    /**
     * Gets cart size.
     *
     * @return the cart size
     */
    public int getCartSize();
}
