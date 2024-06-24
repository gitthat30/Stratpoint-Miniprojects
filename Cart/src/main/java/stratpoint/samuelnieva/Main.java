package stratpoint.samuelnieva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        List<Product> testProducts = new ArrayList<>();
        Catalog testCatalog = new Catalog(testProducts);
        
        testCatalog.addProduct(new Product(100, "Mentos 100 Pack", "Food", "Mentos"));
    }
}