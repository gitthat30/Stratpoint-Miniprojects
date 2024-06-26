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
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets brand.
     *
     * @param brand the brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public double getID() {
        return ID;
    }

    /**
     * Sets id.
     *
     * @param ID the id
     */
    public void setID(double ID) {
        this.ID = ID;
    }
}
