package stratpoint.samuelnieva.ServiceLayer;

import stratpoint.samuelnieva.EntityLayer.ProductEntity;

/**
 * The Catalog interface meant to represent a catalog of products
 * a user of an e-commerce website can choose from.
 */
public interface CatalogService {

    /**
     * Output products within the Catalog using the outputInfo method of each of the
     * products inside.
     */
    public void outputProducts();

    /**
     * Adds a product into the Catalog's list of products.
     *
     * @param p The Product object to be added.
     */
    public void addProduct(ProductEntity p);

    /**
     * Deletes a product from the catalog's productList variable.
     *
     * @param n The index of the product to be deleted.
     */
    public void delProduct(int n);

    /**
     * Searches for a product using a query. This query is compared against the
     * name, brand, and category of the product. The respective products are added
     * to the Catalog's queryList.
     *
     * @param q the q
     */
    public void searchProduct(String q);

    /**
     * Returns a product from the queryList which is displayed after calling searchProduct.
     * The index to be used has to coincide with the queryList ArrayList.
     *
     * This function should only be called after calling searchProduct so the user can see the
     * list of products they can choose from.
     *
     * @param n The index of the product within the queryList to be added to the productList of the Cart
     * @return The product object to be added to the cart
     */
    public ProductEntity addFromQuery(int n);
}
