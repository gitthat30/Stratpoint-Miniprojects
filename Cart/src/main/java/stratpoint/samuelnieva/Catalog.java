package stratpoint.samuelnieva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        System.out.println("List of products:");
        productList.forEach((p) -> { p.outputInfo(); });
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

    public void searchProduct(String q, int t) {
        productList.forEach((p) -> {
            switch(t) {
                case 1: //Name
                    if(p.getName().contains(q))
                        queryList.add(p);
                    break;

                case 2: //Category
                    if(p.getName().equals(q))
                        queryList.add(p);
                    break;

                case 3: //Brand
                    if(p.getBrand().equals(q))
                        queryList.add(p);
            }
        });

        queryList.forEach((p) -> { p.outputInfo(); });
    }

    //This method is only to be called after calling searchProduct
    public void delFromQuery(int n) {
        logger.trace("Entering delFromQuery with index {}", n);
        tempProduct = queryList.get(n);

        int tempIndex = productList.indexOf(tempProduct);
        productList.remove(tempIndex);

        //Check if productList is empty (removed for sure)
        //Check if index is no equal to tempProduct (removed since old product isn't there anymore)
        if(productList.isEmpty() || !productList.get(tempIndex).equals(tempProduct))
            logger.debug("Product {} successfully removed from productList", tempProduct.getName());
        else
            logger.error("Failed to remove product {}", tempProduct);
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


}
