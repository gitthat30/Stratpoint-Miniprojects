package stratpoint.samuelnieva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Catalog. This contains the available products that can be added to the
 * Cart.
 */
public class Catalog {
    private Logger logger;
    private List<Product> productList;
    private List<Product> queryList;
    private Product tempProduct; //To store product objects for logging

    /**
     * Instantiates a new Catalog.
     *
     * @param p The list of products to be used for the Catalog
     */
    Catalog(List<Product> p) {
        logger = LoggerFactory.getLogger(Catalog.class);
        this.productList = p;
    }

    /**
     * Output products within the Catalog using the outputInfo method of each of the
     * products inside.
     */
    public void outputProducts() {
        System.out.println("\nList of products:");

        int counter = 0;
        for(Product p : productList) {
            System.out.println("\nProduct #" + (counter+1) + ":");
            p.outputInfo();
            counter++;
        }
    }

    /**
     * Adds a product into the Catalog's list of products.
     *
     * @param p The Product object to be added.
     */
    public void addProduct(Product p) {
        logger.trace("Entering addProduct with the product {}", p.getName());

        productList.add(p);
        logger.debug("Added product {} to productList", productList.get(productList.size()-1).getName());
    }

    /**
     * Deletes a product from the catalog's productList variable.
     *
     * @param n The index of the product to be deleted.
     */
    public void delProduct(int n) {
        tempProduct = productList.get(n);
        logger.trace("Entered delProduct with index {}", n);

        productList.remove(n);

        //Check if productList is empty (removed for sure)
        //Check if index is no equal to tempProduct (removed since old product isn't there anymore)
        if(productList.isEmpty() || !productList.get(n).equals(tempProduct))
            logger.debug("Product {} successfully removed from productList", tempProduct.getName());
        else
            logger.error("Failed to remove product {}", tempProduct);
    }

    /**
     * Searches for a product using a query. This query is compared against the
     * name, brand, and category of the product. The respective products are added
     * to the Catalog's queryList.
     *
     * @param q the q
     */
    public void searchProduct(String q) {
        this.queryList = new ArrayList<>();
        productList.forEach((p) -> {
            if(p.getName().contains(q) || p.getBrand().contains(q) || p.getCategory().contains(q)) {
                queryList.add(p);
                logger.debug("Product {} successfully added to queryList.", p.getName());
            }

        });

        queryList.forEach((p) -> { p.outputInfo(); });
    }

    /**
     * Returns a product from the queryList which is displayed after calling searchProduct.
     * The index to be used has to coincide with the queryList ArrayList.
     *
     * @param n The index of the product within the queryList to be added to the productList of the Cart
     * @return The product object to be added to the cart
     */
//This method is only to be called after calling searchProduct
    public Product addFromQuery(int n) {
        logger.trace("Entering addFromQuery with index {}", n);
        tempProduct = queryList.get(n);

        return tempProduct;
    }

    /**
     * Gets productList object.
     *
     * @return the product list
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * Sets product list.
     *
     * @param productList the product list
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * Gets query list.
     *
     * @return the query list
     */
    public List<Product> getQueryList() {
        return queryList;
    }

    /**
     * Sets query list.
     *
     * @param queryList the query list
     */
    public void setQueryList(List<Product> queryList) {
        this.queryList = queryList;
    }

    /**
     * Gets from product list.
     *
     * @param n the n
     * @return the from product list
     */
    public Product getFromProductList(int n) {
        return productList.get(n);
    }
}
