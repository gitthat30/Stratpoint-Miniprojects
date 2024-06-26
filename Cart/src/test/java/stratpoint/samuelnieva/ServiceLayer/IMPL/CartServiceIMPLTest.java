package stratpoint.samuelnieva.ServiceLayer.IMPL;

import org.junit.jupiter.api.Test;
import stratpoint.samuelnieva.EntityLayer.ProductEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class CartServiceIMPLTest {

    @Test
    void addProduct() {
        CartServiceIMPL testService = new CartServiceIMPL();

        testService.addProduct(new ProductEntity(1000, "Test Product", "Food", "Brand"));

        List<ProductEntity> testList = new ArrayList<>();
        testList.add(new ProductEntity(1000, "Test Product", "Food", "Brand"));

        assertEquals(testService.getCartSize(), 1);
    }

    @Test
    void delProduct() {
        CartServiceIMPL testService = new CartServiceIMPL();

        testService.addProduct(new ProductEntity(1000, "Test Product", "Food", "Brand"));

        testService.delProduct(1);

        assertEquals(testService.getCartSize(), 0);
        assertEquals(testService.getTotalPrice(), 0);
    }

    @Test
    void getTotalPrice() {
        CartServiceIMPL testService = new CartServiceIMPL();

        testService.addProduct(new ProductEntity(1000, "Test Product", "Food", "Brand"));

        assertEquals(testService.getTotalPrice(), 1000);
    }

    @Test
    void getCartSize() {
        CartServiceIMPL testService = new CartServiceIMPL();

        testService.addProduct(new ProductEntity(1000, "Test Product", "Food", "Brand"));

        assertEquals(testService.getCartSize(), 1);
    }
}