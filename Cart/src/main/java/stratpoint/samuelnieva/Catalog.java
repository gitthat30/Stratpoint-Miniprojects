package stratpoint.samuelnieva;

import java.util.List;

public class Catalog {
    private List<Product> productList;
    private List<Product> queryList;

    Catalog(List<Product> p) {
        this.productList = p;
    }

    public void outputProducts() {
        System.out.println("List of products:");
        productList.forEach((p) -> { p.outputInfo(); });
    }

    public void addProduct(Product p) {
        productList.add(p);
    }

    public void delProduct(int n) {
        productList.remove(n);
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
        queryList.remove(n);
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
