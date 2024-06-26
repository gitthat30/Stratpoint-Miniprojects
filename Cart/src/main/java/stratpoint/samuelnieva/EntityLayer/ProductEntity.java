package stratpoint.samuelnieva.EntityLayer;

/**
 * The Product class represents a product from an e-commerce website and contains information related to a product
 * which can then be searched for, added and deleted from the lists in the Cart and Catalog classes.
 */
public class ProductEntity {
    private double price;
    private String name;
    private String category;
    private String brand;
    private double ID = Math.random();

    /**
     * Instantiates a new Product.
     *
     * @param price    The price of the product
     * @param name     The name of the product
     * @param category The category of the product
     * @param brand    The brand of the product
     */
    public ProductEntity(double price, String name, String category, String brand) {
        this.price = price;
        this.name = name;
        this.category = category;
        this.brand = brand;
    }

    /**
     * Outputs the info of the product for the user to see.
     */
    public void outputInfo() {
        System.out.print("Product Name: " + this.name);
        System.out.print(" | Price: " + price);
        System.out.print(" | Category " + category);
        System.out.print(" | Brand: " + brand + "\n");
    }


    /**
     * Getter for the product's price
     *
     * @return The price of the Product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for the product's price
     *
     * @param price The new price to be set for the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for the product's name
     *
     * @return The name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the product's name
     *
     * @param name The new name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the product's category
     *
     * @return The category of the product
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for the product's category
     *
     * @param category The new category of the product
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter for the product's brand
     *
     * @return The brand of the product
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter for the product's brand
     *
     * @param brand The new brand of the product
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter for the product's ID
     *
     * @return The ID of the product
     */
    public double getID() {
        return ID;
    }

    /**
     * Setter for the product's ID
     *
     * @param ID The new ID of the product
     */
    public void setID(double ID) {
        this.ID = ID;
    }
}
