package stratpoint.samuelnieva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initializing logger and test data
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.trace("Entered main method.");

        Scanner sc = new Scanner(System.in);

        List<Product> testProducts = new ArrayList<>();

        Cart testCart = new Cart();
        Catalog testCatalog = new Catalog(testProducts);

        /** Categories:
         * 0 - F&B
         * 1 - Elec
         * 2 - Cosmetics
         */
        String[] categories = {"Food & Beverages", "Electronics", "Cosmetics"};

        testCatalog.addProduct(new Product(100, "Mentos 100 Pack", categories[0], "Mentos"));
        testCatalog.addProduct(new Product(50, "Coke Zero", categories[0], "Coca Cola"));

        testCatalog.addProduct(new Product(10000, "Samsung Z20", categories[1], "Samsung"));
        testCatalog.addProduct(new Product(20000, "MyPhone ZZZ", categories[1], "Apple"));

        testCatalog.addProduct(new Product(2000, "Red Hat", categories[2], "Gucci"));
        testCatalog.addProduct(new Product(5000, "White T-Shirt", categories[2], "Supreme"));

        //Main program loop

        int choice;
        try {
            while (true) {
                System.out.println("Your cart currently has " + testCart.getCartSize() + " items in it.\n");
                if(testCart.getCartSize() != 0) {
                    System.out.println("Items in the cart:");
                    testCart.viewProducts();
                }

                System.out.println("What would you like to do?");
                System.out.println("1 - See all products in catalog");
                System.out.println("2 - Search for product in catalog");
                System.out.println("3 - Add product to cart");
                System.out.println("4 - Remove product to cart\n");

                System.out.println("Choice: ");
                choice = sc.nextInt();

                switch(choice) {
                    case 1:
                        testCatalog.outputProducts();
                        break;

                    case 2:
                        System.out.println("\nPlease enter your query: ");
                        testCatalog.searchProduct(sc.next());
                        break;

                    case 3:
                        //Output products
                        testCatalog.outputProducts();

                        //Select from list
                        System.out.println("\nSelect product to add (By number):");

                        testCart.addProduct(testCatalog.getFromProductList(sc.nextInt() - 1));
                        break;

                    case 4:
                        //Output products in cart
                        testCart.viewProducts();

                        //Select from list to delete
                        System.out.println("\nSelect product to delete (By number)");
                        testCart.delProduct(sc.nextInt()-1);
                        break;

                    default:
                        throw new Exception("Invalid choice.");
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }


    }
}