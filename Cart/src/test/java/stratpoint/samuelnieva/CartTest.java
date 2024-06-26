package stratpoint.samuelnieva;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void addProduct() {
        Cart testCart = new Cart();
        testCart.addProduct(new Product(100, "Mentos 100 Pack", "Food & Beverages", "Mentos"));
        assertEquals(1, testCart.getCartSize());
    }

    @Test
    void delProduct() {
        Cart testCart = new Cart();
        testCart.addProduct(new Product(100, "Mentos 100 Pack", "Food & Beverages", "Mentos"));
        testCart.delProduct(0);
        assertEquals(0, testCart.getCartSize());
    }
}