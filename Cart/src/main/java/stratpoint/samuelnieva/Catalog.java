package stratpoint.samuelnieva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private Logger logger;
    private List<Product> productList;
    private List<Product> queryList;
    private Product tempProduct; //To store product objects for logging

    Catalog(List<Product> p) {
        logger = LoggerFactory.getLogger(Catalog.class);
        this.productList = p;
    }

    public void outputProducts() {
        System.out.println("\nList of products:");

        int counter = 0;
        for(Product p : productList) {
            System.out.println("\nProduct #" + (counter+1) + ":");
            p.outputInfo();
            counter++;
        }
    }

    public void addProduct(Product p) {
        logger.trace("Entering addProduct with the product {}", p.getName());

        productList.add(p);
        logger.debug("Added product {} to productList", productList.get(productList.size()-1).getName());
    }

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

    //This method is only to be called after calling searchProduct
    public void addFromQuery(int n) {
        logger.trace("Entering addFromQuery with index {}", n);
        tempProduct = queryList.get(n);

        productList.add(tempProduct);
        logger.debug("Product {} successfully added to the productList.", tempProduct);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getQueryList() {
        return queryList;
    }

    public void setQueryList(List<Product> queryList) {
        this.queryList = queryList;
    }

    public Product getFromProductList(int n) {
        return productList.get(n);
    }
}
