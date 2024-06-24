package stratpoint.samuelnieva;

public class Product {
    private double price;
    private String name;
    private String category;
    private String brand;


    public Product(double price, String name, String category, String brand) {
        this.price = price;
        this.name = name;
        this.category = category;
        this.brand = brand;
    }

    public void outputInfo() {
        System.out.println("Product Name: " + this.name);
        System.out.println("Price: " + price);
        System.out.println("Category " + category);
        System.out.println("Brand: " + brand + "\n");
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
