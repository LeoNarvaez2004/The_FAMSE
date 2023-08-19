
package ec.edu.espe.thefamse.model;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class ProductsTest {
    
    public ProductsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testProducts() {
        ObjectId id = new ObjectId();
        String code = "P123";
        String name = "Product A";
        String supplier = "Laura Jacome";
        int stock = 50;
        double price = 29.99;

        Products product = new Products(id, code, name, supplier, stock, price);

        assertEquals(id, product.getId());
        assertEquals(code, product.getCode());
        assertEquals(name, product.getName());
        assertEquals(supplier, product.getSupplier());
        assertEquals(stock, product.getStock());
        assertEquals(price, product.getPrice(), 0.001);
    }
    
    @Test
    public void testProductsSetters() {
        Products product = new Products();

        ObjectId id = new ObjectId();
        String code = "P234";
        String name = "Peras";
        String supplier = "Maria Flores";
        int stock = 100;
        double price = 49.99;

        product.setId(id);
        product.setCode(code);
        product.setName(name);
        product.setSupplier(supplier);
        product.setStock(stock);
        product.setPrice(price);

        assertEquals(id, product.getId());
        assertEquals(code, product.getCode());
        assertEquals(name, product.getName());
        assertEquals(supplier, product.getSupplier());
        assertEquals(stock, product.getStock());
        assertEquals(price, product.getPrice(), 0.001);
    }

    @Test
    public void testToString() {
        ObjectId id = new ObjectId();
        String code = "P123";
        String name = "Product A";
        String supplier = "Pedro";
        int stock = 5;
        double price = 9.99;

        Products product = new Products(id, code, name, supplier, stock, price);
        
        String expectedString = "Products{_id=" + id + ", code=" + code + ", name=" + name +
                               ", supplier=" + supplier + ", stock=" + stock + ", price=" + price + "}";
        
        assertEquals(expectedString, product.toString());
    }
    
        @Test
    public void testProducts1() {
        ObjectId id = new ObjectId();
        String code = "123";
        String name = "Peras";
        String supplier = "Maria Jacome";
        int stock = 10;
        double price = 5.50;

        Products product = new Products(id, code, name, supplier, stock, price);

        assertEquals(id, product.getId());
        assertEquals(code, product.getCode());
        assertEquals(name, product.getName());
        assertEquals(supplier, product.getSupplier());
        assertEquals(stock, product.getStock());
        assertEquals(price, product.getPrice(), 0.001);
    }
    
    @Test
    public void testProductsSetters1() {
        Products product = new Products();

        ObjectId id = new ObjectId();
        String code = "12";
        String name = "Arandanos";
        String supplier = "Pedro";
        int stock = 42;
        double price = 20.00;

        product.setId(id);
        product.setCode(code);
        product.setName(name);
        product.setSupplier(supplier);
        product.setStock(stock);
        product.setPrice(price);

        assertEquals(id, product.getId());
        assertEquals(code, product.getCode());
        assertEquals(name, product.getName());
        assertEquals(supplier, product.getSupplier());
        assertEquals(stock, product.getStock());
        assertEquals(price, product.getPrice(), 0.001);
    }

    @Test
    public void testToString1() {
        ObjectId id = new ObjectId();
        String code = "16";
        String name = "Nuez";
        String supplier = "Maria";
        int stock = 8;
        double price = 9.99;

        Products product = new Products(id, code, name, supplier, stock, price);
        
        String expectedString = "Products{_id=" + id + ", code=" + code + ", name=" + name +
                               ", supplier=" + supplier + ", stock=" + stock + ", price=" + price + "}";
        
        assertEquals(expectedString, product.toString());
    }
    
        @Test
    public void testProducts2() {
        ObjectId id = new ObjectId();
        String code = "P123";
        String name = "Pistachos A";
        String supplier = "Eliza Jacome";
        int stock = 10;
        double price = 9.55;

        Products product = new Products(id, code, name, supplier, stock, price);

        assertEquals(id, product.getId());
        assertEquals(code, product.getCode());
        assertEquals(name, product.getName());
        assertEquals(supplier, product.getSupplier());
        assertEquals(stock, product.getStock());
        assertEquals(price, product.getPrice(), 0.001);
    }
    
    @Test
    public void testProductsSetters2() {
        Products product = new Products();

        ObjectId id = new ObjectId();
        String code = "12";
        String name = "Arandanos";
        String supplier = "Laura Jacome";
        int stock = 2;
        double price = 1.99;

        product.setId(id);
        product.setCode(code);
        product.setName(name);
        product.setSupplier(supplier);
        product.setStock(stock);
        product.setPrice(price);

        assertEquals(id, product.getId());
        assertEquals(code, product.getCode());
        assertEquals(name, product.getName());
        assertEquals(supplier, product.getSupplier());
        assertEquals(stock, product.getStock());
        assertEquals(price, product.getPrice(), 0.001);
    }

    @Test
    public void testToString2() {
        ObjectId id = new ObjectId();
        String code = "P1";
        String name = "Mazana";
        String supplier = "Pedro";
        int stock = 1;
        double price = 0.30;

        Products product = new Products(id, code, name, supplier, stock, price);
        
        String expectedString = "Products{_id=" + id + ", code=" + code + ", name=" + name +
                               ", supplier=" + supplier + ", stock=" + stock + ", price=" + price + "}";
        
        assertEquals(expectedString, product.toString());
    }
    
        @Test
    public void testProducts3() {
        ObjectId id = new ObjectId();
        String code = "P123";
        String name = "Product A";
        String supplier = "Laura Jacome";
        int stock = 25;
        double price = 19.99;

        Products product = new Products(id, code, name, supplier, stock, price);

        assertEquals(id, product.getId());
        assertEquals(code, product.getCode());
        assertEquals(name, product.getName());
        assertEquals(supplier, product.getSupplier());
        assertEquals(stock, product.getStock());
        assertEquals(price, product.getPrice(), 0.001);
    }
    
    @Test
    public void testProductsSetters3() {
        Products product = new Products();

        ObjectId id = new ObjectId();
        String code = "111";
        String name = "Peras";
        String supplier = "Pedro Flores";
        int stock = 2;
        double price = 0.40;

        product.setId(id);
        product.setCode(code);
        product.setName(name);
        product.setSupplier(supplier);
        product.setStock(stock);
        product.setPrice(price);

        assertEquals(id, product.getId());
        assertEquals(code, product.getCode());
        assertEquals(name, product.getName());
        assertEquals(supplier, product.getSupplier());
        assertEquals(stock, product.getStock());
        assertEquals(price, product.getPrice(), 0.001);
    }

    @Test
    public void testToString3() {
        ObjectId id = new ObjectId();
        String code = "p234";
        String name = "PRODUCT A";
        String supplier = "Elizabeth";
        int stock = 5;
        double price = 9.99;

        Products product = new Products(id, code, name, supplier, stock, price);
        
        String expectedString = "Products{_id=" + id + ", code=" + code + ", name=" + name +
                               ", supplier=" + supplier + ", stock=" + stock + ", price=" + price + "}";
        
        assertEquals(expectedString, product.toString());
    }
    
}
