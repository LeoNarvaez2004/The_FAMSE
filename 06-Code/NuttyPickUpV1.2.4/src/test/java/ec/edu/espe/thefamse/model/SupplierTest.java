
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
public class SupplierTest {
    
    public SupplierTest() {
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
        int ruc = 1234567890;
        String name = "Jordan";
        String cellphone = "1234567";
        String address = "123 Quito";

        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setRuc(ruc);
        supplier.setName(name);
        supplier.setCellphone(cellphone);
        supplier.setAddress(address);

        assertEquals(id, supplier.getId());
        assertEquals(ruc, supplier.getRuc());
        assertEquals(name, supplier.getName());
        assertEquals(cellphone, supplier.getCellphone());
        assertEquals(address, supplier.getAddress());
    }
    
    @Test
    public void testGetterAndSetterMethods1() {
        ObjectId id = new ObjectId();
        int ruc = 1234567890;
        String name = "Moran";
        String cellphone = "2323233";
        String address = "Quito";

        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setRuc(ruc);
        supplier.setName(name);
        supplier.setCellphone(cellphone);
        supplier.setAddress(address);

        assertEquals(id, supplier.getId());
        assertEquals(ruc, supplier.getRuc());
        assertEquals(name, supplier.getName());
        assertEquals(cellphone, supplier.getCellphone());
        assertEquals(address, supplier.getAddress());
    }
    
    @Test
    public void testGetterAndSetterMethods2() {
        ObjectId id = new ObjectId();
        int ruc = 1234567890;
        String name = "Alisson Vega";
        String cellphone = "0999999999";
        String address = "Quito";

        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setRuc(ruc);
        supplier.setName(name);
        supplier.setCellphone(cellphone);
        supplier.setAddress(address);

        assertEquals(id, supplier.getId());
        assertEquals(ruc, supplier.getRuc());
        assertEquals(name, supplier.getName());
        assertEquals(cellphone, supplier.getCellphone());
        assertEquals(address, supplier.getAddress());
    }

    @Test
    public void testDefaultConstructor() {
        Supplier supplier = new Supplier();

        assertNull(supplier.getId());
        assertEquals(0, supplier.getRuc());
        assertNull(supplier.getName());
        assertNull(supplier.getCellphone());
        assertNull(supplier.getAddress());
    }

    @Test
    public void testConstructorWithParameters(){
        ObjectId id = new ObjectId();
        int ruc = 987654321;
        String name = "Supplier";
        String cellphone = "5555555555";
        String address = "456St";

        Supplier supplier = new Supplier(id, ruc, name, cellphone, address);

        assertEquals(id, supplier.getId());
        assertEquals(ruc, supplier.getRuc());
        assertEquals(name, supplier.getName());
        assertEquals(cellphone, supplier.getCellphone());
        assertEquals(address, supplier.getAddress());
    }
    
    @Test
    public void testSupplier(){
        ObjectId id = new ObjectId();
        int ruc = 987654211;
        String name = "Alfaro";
        String cellphone = "0998887771";
        String address = "Quito";

        Supplier supplier = new Supplier(id, ruc, name, cellphone, address);

        assertEquals(id, supplier.getId());
        assertEquals(ruc, supplier.getRuc());
        assertEquals(name, supplier.getName());
        assertEquals(cellphone, supplier.getCellphone());
        assertEquals(address, supplier.getAddress());
    }

    @Test
    public void testSettersAndGetters() {
        Supplier supplier = new Supplier();

        ObjectId id = new ObjectId();
        int ruc = 555555555;
        String name = "Test";
        String cellphone = "9999999999";
        String address = "Recreo";

        supplier.setId(id);
        supplier.setRuc(ruc);
        supplier.setName(name);
        supplier.setCellphone(cellphone);
        supplier.setAddress(address);

        assertEquals(id, supplier.getId());
        assertEquals(ruc, supplier.getRuc());
        assertEquals(name, supplier.getName());
        assertEquals(cellphone, supplier.getCellphone());
        assertEquals(address, supplier.getAddress());
    }
    
    @Test
    public void testSettersAndGetters1() {
        Supplier supplier = new Supplier();

        ObjectId id = new ObjectId();
        int ruc = 1717234356;
        String name = "Anahi";
        String cellphone = "0982315678";
        String address = "Quitumbe";

        supplier.setId(id);
        supplier.setRuc(ruc);
        supplier.setName(name);
        supplier.setCellphone(cellphone);
        supplier.setAddress(address);

        assertEquals(id, supplier.getId());
        assertEquals(ruc, supplier.getRuc());
        assertEquals(name, supplier.getName());
        assertEquals(cellphone, supplier.getCellphone());
        assertEquals(address, supplier.getAddress());
    }
    
    @Test
    public void testSettersAndGetters2() {
        Supplier supplier = new Supplier();

        ObjectId id = new ObjectId();
        int ruc = 1245458798;
        String name = "Erick san";
        String cellphone = "0998765432";
        String address = "Recreo";

        supplier.setId(id);
        supplier.setRuc(ruc);
        supplier.setName(name);
        supplier.setCellphone(cellphone);
        supplier.setAddress(address);

        assertEquals(id, supplier.getId());
        assertEquals(ruc, supplier.getRuc());
        assertEquals(name, supplier.getName());
        assertEquals(cellphone, supplier.getCellphone());
        assertEquals(address, supplier.getAddress());
    }
}
