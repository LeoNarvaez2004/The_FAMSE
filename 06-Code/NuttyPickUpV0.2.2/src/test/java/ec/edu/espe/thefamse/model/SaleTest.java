
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
public class SaleTest {
    
    public SaleTest() {
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
    public void testGetterAndSetterMethods() {
        ObjectId id = new ObjectId();
        String customer = "Edison Lascano";
        String seller = "Laura Jacome";
        double total = 20.0;

        Sale sale = new Sale();
        sale.setId(id);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setTotal(total);

        assertEquals(id, sale.getId());
        assertEquals(customer, sale.getCustomer());
        assertEquals(seller, sale.getSeller());
        assertEquals(total, sale.getTotal(), 0.001);
    }
    
        @Test
    public void testGetterAndSetterMethods1() {
        ObjectId id = new ObjectId();
        String customer = "Joan Cobeña";
        String seller = "Laura Jacome";
        double total = 100.0;

        Sale sale = new Sale();
        sale.setId(id);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setTotal(total);

        assertEquals(id, sale.getId());
        assertEquals(customer, sale.getCustomer());
        assertEquals(seller, sale.getSeller());
        assertEquals(total, sale.getTotal(), 0.001);
    }
    
        @Test
    public void testGetterAndSetterMethods2() {
        ObjectId id = new ObjectId();
        String customer = "Anabel";
        String seller = "Laura Jacome";
        double total = 10.1;

        Sale sale = new Sale();
        sale.setId(id);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setTotal(total);

        assertEquals(id, sale.getId());
        assertEquals(customer, sale.getCustomer());
        assertEquals(seller, sale.getSeller());
        assertEquals(total, sale.getTotal(), 0.001);
    }

    @Test
    public void testDefaultConstructor() {
        Sale sale = new Sale();

        assertNull(sale.getId());
        assertNull(sale.getCustomer());
        assertNull(sale.getSeller());
        assertEquals(0.0, sale.getTotal(), 0.001);
    }
    
    @Test
    public void test1() {
        Sale sale = new Sale();

        assertNull(sale.getId());
        assertNull(sale.getCustomer());
        assertNull(sale.getSeller());
        assertEquals(0.0, sale.getTotal(), 0.001);
    }
    
    @Test
    public void testConstructorWithParameters() {
        ObjectId id = new ObjectId();
        String customer = "Jane Smith";
        String seller = "Laura Jacome";
        double total = 5.0;

        Sale sale = new Sale(id, customer, seller, total);

        assertEquals(id, sale.getId());
        assertEquals(customer, sale.getCustomer());
        assertEquals(seller, sale.getSeller());
        assertEquals(total, sale.getTotal(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        Sale sale = new Sale();

        ObjectId id = new ObjectId();
        String customer = "Prueba Customer";
        String seller = "Laura Jacome";
        double total = 25.0;

        sale.setId(id);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setTotal(total);

        assertEquals(id, sale.getId());
        assertEquals(customer, sale.getCustomer());
        assertEquals(seller, sale.getSeller());
        assertEquals(total, sale.getTotal(), 0.001);
    }
    
    @Test
    public void testSettersAndGetters1() {
        Sale sale = new Sale();

        ObjectId id = new ObjectId();
        String customer = "Edison Customer";
        String seller = "Laura Jacome";
        double total = 10;

        sale.setId(id);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setTotal(total);

        assertEquals(id, sale.getId());
        assertEquals(customer, sale.getCustomer());
        assertEquals(seller, sale.getSeller());
        assertEquals(total, sale.getTotal(), 0.001);
    }
    
    @Test
    public void testSettersAndGetters2() {
        Sale sale = new Sale();

        ObjectId id = new ObjectId();
        String customer = "Pamela Chipe";
        String seller = "Laura Jacome";
        double total = 30;

        sale.setId(id);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setTotal(total);

        assertEquals(id, sale.getId());
        assertEquals(customer, sale.getCustomer());
        assertEquals(seller, sale.getSeller());
        assertEquals(total, sale.getTotal(), 0.001);
    }
    
    @Test
    public void testSettersAndGetters3() {
        Sale sale = new Sale();

        ObjectId id = new ObjectId();
        String customer = "Anthony";
        String seller = "Laura Jacome";
        double total = 2;

        sale.setId(id);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setTotal(total);

        assertEquals(id, sale.getId());
        assertEquals(customer, sale.getCustomer());
        assertEquals(seller, sale.getSeller());
        assertEquals(total, sale.getTotal(), 0.001);
    }
    
    @Test
    public void testSettersAndGetters4() {
        Sale sale = new Sale();

        ObjectId id = new ObjectId();
        String customer = "jordan XD";
        String seller = "Laura Jacome";
        double total = 23;

        sale.setId(id);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setTotal(total);

        assertEquals(id, sale.getId());
        assertEquals(customer, sale.getCustomer());
        assertEquals(seller, sale.getSeller());
        assertEquals(total, sale.getTotal(), 0.001);
    }
    
    @Test
    public void testSettersAndGetters5() {
        Sale sale = new Sale();

        ObjectId id = new ObjectId();
        String customer = "Customer";
        String seller = "Laura Jacome";
        double total = 13.2;

        sale.setId(id);
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setTotal(total);

        assertEquals(id, sale.getId());
        assertEquals(customer, sale.getCustomer());
        assertEquals(seller, sale.getSeller());
        assertEquals(total, sale.getTotal(), 0.001);
    }
}
