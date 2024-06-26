package stratpoint.samuelnieva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stratpoint.samuelnieva.EntityLayer.ProductEntity;
import stratpoint.samuelnieva.ServiceLayer.IMPL.CartServiceIMPL;
import stratpoint.samuelnieva.ServiceLayer.IMPL.CatalogServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initializing logger and test data
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.trace("Entered main method.");

        Scanner sc = new Scanner(System.in);

        List<ProductEntity> testProducts = new ArrayList<>();

        CartServiceIMPL testCart = new CartServiceIMPL();
        CatalogServiceIMPL testCatalog = new CatalogServiceIMPL(testProducts);
        Main.addSampleData(testCatalog);

        //Main program loop
        int choice = 0;
        while (true) {
            try {
                System.out.println("\nYour cart currently has " + testCart.getCartSize() + " items in it.\n");
                if (testCart.getCartSize() != 0) {
                    System.out.println("Items in the cart:");
                    testCart.viewProducts();
                }
                System.out.println("\nCart's total price: " + testCart.getTotalPrice());

                choice = 0;
                while (choice < 1 || choice > 4) {
                    System.out.println("\nWhat would you like to do?");
                    System.out.println("1 - See all products in catalog");
                    System.out.println("2 - Search for product in catalog");
                    System.out.println("3 - Add product to cart");
                    System.out.println("4 - Remove product to cart\n");

                    System.out.println("Choice: ");
                    choice = sc.nextInt();
                }

                switch (choice) {
                    case 1:
                        testCatalog.outputProducts();
                        break;

                    case 2:
                        System.out.println("\nPlease enter your query: ");

                        sc.nextLine();
                        testCatalog.searchProduct(sc.nextLine());

                        System.out.println("\nWould you like to: ");
                        System.out.println("1 - Add a product from this list");
                        System.out.println("2 - Return to main menu\n");

                        System.out.println("Choice: ");

                        choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                System.out.println("\nSelect product to add (By number):");
                                testCart.addProduct(testCatalog.getFromQuery(sc.nextInt() - 1));
                                break;
                            case 2:
                                break;
                            default:
                                throw new Exception("Invalid choice.");
                        }
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
                        testCart.delProduct(sc.nextInt());
                        break;

                    default:
                        throw new Exception("Invalid choice.");
                }
            }
            catch (Exception e) {
                System.out.println("\nInvalid choice. Please try again.");
                sc.next();
                choice = 0;
            }
        }
    }

    public static void addSampleData(CatalogServiceIMPL c) {
        /** Categories:
         * 0 - F&B
         * 1 - Elec
         * 2 - Cosmetics
         */
        String[] categories = {"Food & Beverages", "Electronics", "Cosmetics"};

        c.addProduct(new ProductEntity(100, "Mentos 100 Pack", categories[0], "Mentos"));
        c.addProduct(new ProductEntity(50, "Coke Zero", categories[0], "Coca Cola"));
        c.addProduct(new ProductEntity(120, "KitKat Assorted Pack", categories[0], "Nestle"));
        c.addProduct(new ProductEntity(75, "Pepsi Max", categories[0], "PepsiCo"));
        c.addProduct(new ProductEntity(200, "Oreo Cookies", categories[0], "Mondelez"));
        c.addProduct(new ProductEntity(10000, "Samsung Z20", categories[1], "Samsung"));
        c.addProduct(new ProductEntity(20000, "MyPhone ZZZ", categories[1], "Apple"));
        c.addProduct(new ProductEntity(15000, "Sony Xperia XZ", categories[1], "Sony"));
        c.addProduct(new ProductEntity(18000, "Google Pixel 5", categories[1], "Google"));
        c.addProduct(new ProductEntity(25000, "HP Pavilion Laptop", categories[1], "HP"));
        c.addProduct(new ProductEntity(2000, "Red Hat", categories[2], "Gucci"));
        c.addProduct(new ProductEntity(5000, "White T-Shirt", categories[2], "Supreme"));
        c.addProduct(new ProductEntity(2500, "Chanel No. 5", categories[2], "Chanel"));
        c.addProduct(new ProductEntity(4500, "Lipstick Red", categories[2], "MAC Cosmetics"));
        c.addProduct(new ProductEntity(3000, "L'Oréal Paris Mascara", categories[2], "L'Oréal"));
        c.addProduct(new ProductEntity(3500, "Maybelline Foundation", categories[2], "Maybelline"));
    }
}