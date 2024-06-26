package stratpoint.samuelnieva.ServiceLayer.IMPL;

import org.junit.jupiter.api.Test;
import stratpoint.samuelnieva.EntityLayer.ProductEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatalogServiceIMPLTest {

    @Test
    void addProduct() {
        List<ProductEntity> testList = new ArrayList<>();
        CatalogServiceIMPL testService = new CatalogServiceIMPL(testList);

        testService.addProduct(new ProductEntity(1000, "Test Product", "Food", "Brand"));

        assertEquals(testService.getFromProductList(0).getPrice(), 1000);
        assertEquals(testService.getFromProductList(0).getName(), "Test Product");
        assertEquals(testService.getFromProductList(0).getCategory(), "Food");
        assertEquals(testService.getFromProductList(0).getBrand(), "Brand");
    }

    @Test
    void delProduct() {
        List<ProductEntity> testList = new ArrayList<>();
        CatalogServiceIMPL testService = new CatalogServiceIMPL(testList);

        testService.addProduct(new ProductEntity(1000, "Test Product", "Food", "Brand"));

        testService.delProduct(0);

        assertEquals(testService.getProductList().size(), 0);
    }

    @Test
    void searchProduct() {
        List<ProductEntity> testList = new ArrayList<>();
        CatalogServiceIMPL testService = new CatalogServiceIMPL(testList);

        testService.addProduct(new ProductEntity(1000, "Test Product", "Food", "Brand"));

        testService.searchProduct("Test Product");

        assertEquals(testService.getQueryList().get(0).getPrice(), 1000);
        assertEquals(testService.getQueryList().get(0).getName(), "Test Product");
        assertEquals(testService.getQueryList().get(0).getCategory(), "Food");
        assertEquals(testService.getQueryList().get(0).getBrand(), "Brand");
    }

    @Test
    void getFromQuery() {
        List<ProductEntity> testList = new ArrayList<>();
        CatalogServiceIMPL testService = new CatalogServiceIMPL(testList);

        testService.addProduct(new ProductEntity(1000, "Test Product", "Food", "Brand"));
        testService.searchProduct("Test Product");

        assertEquals(testService.getFromQuery(0).getPrice(), 1000);
        assertEquals(testService.getFromQuery(0).getName(), "Test Product");
        assertEquals(testService.getFromQuery(0).getCategory(), "Food");
        assertEquals(testService.getFromQuery(0).getBrand(), "Brand");
    }

    @Test
    void getFromProductList() {
        List<ProductEntity> testList = new ArrayList<>();
        CatalogServiceIMPL testService = new CatalogServiceIMPL(testList);

        testService.addProduct(new ProductEntity(1000, "Test Product", "Food", "Brand"));

        assertEquals(testService.getFromProductList(0).getPrice(), 1000);
        assertEquals(testService.getFromProductList(0).getName(), "Test Product");
        assertEquals(testService.getFromProductList(0).getCategory(), "Food");
        assertEquals(testService.getFromProductList(0).getBrand(), "Brand");
    }
}