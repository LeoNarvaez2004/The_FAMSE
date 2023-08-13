
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
public class CustomerTest {
    
    public CustomerTest() {
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
        int ci = 123456897;
        String name = "Adonny Mateo";
        String cellphone = "1234567890";
        String address = "123 Espe";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setCi(ci);
        customer.setName(name);
        customer.setCellphone(cellphone);
        customer.setAddress(address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }
    
    @Test
    public void testGetterAndSetter1() {
        ObjectId id = new ObjectId();
        int ci = 1726068971;
        String name = "Elias Santan";
        String cellphone = "0999999999";
        String address = "La Merced";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setCi(ci);
        customer.setName(name);
        customer.setCellphone(cellphone);
        customer.setAddress(address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }
    
        @Test
    public void testGetterAndSetter2() {
        ObjectId id = new ObjectId();
        int ci = 1786068971;
        String name = "Gabriel Morti";
        String cellphone = "0988888889";
        String address = "El Carmen";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setCi(ci);
        customer.setName(name);
        customer.setCellphone(cellphone);
        customer.setAddress(address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }
    
    @Test
    public void testGetterAndSetter3() {
        ObjectId id = new ObjectId();
        int ci = 1711111111;
        String name = "Leonardo Narvaez";
        String cellphone = "0965656588";
        String address = "Quito";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setCi(ci);
        customer.setName(name);
        customer.setCellphone(cellphone);
        customer.setAddress(address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }
    
    @Test
    public void testGetterAndSetter4() {
        ObjectId id = new ObjectId();
        int ci = 1736363971;
        String name = "Mesias Mariscal";
        String cellphone = "0911188889";
        String address = "Sangolqui";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setCi(ci);
        customer.setName(name);
        customer.setCellphone(cellphone);
        customer.setAddress(address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }
    
    @Test
    public void testGetterAndSetter5() {
        ObjectId id = new ObjectId();
        int ci = 1711111111;
        String name = "Pablo Carrera";
        String cellphone = "0222222222";
        String address = "Quito";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setCi(ci);
        customer.setName(name);
        customer.setCellphone(cellphone);
        customer.setAddress(address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }
    
    @Test
    public void testGetterAndSetter6() {
        ObjectId id = new ObjectId();
        int ci = 1736363971;
        String name = "Jordan Guaman";
        String cellphone = "0911188889";
        String address = "Santo Domingo";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setCi(ci);
        customer.setName(name);
        customer.setCellphone(cellphone);
        customer.setAddress(address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }
    
    @Test
    public void testGetterAndSetter7() {
        ObjectId id = new ObjectId();
        int ci = 1736363971;
        String name = "Elisabeth Vargas";
        String cellphone = "0911231119";
        String address = "Quito Norte";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setCi(ci);
        customer.setName(name);
        customer.setCellphone(cellphone);
        customer.setAddress(address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }
    
    @Test
    public void testGetterAndSetter8() {
        ObjectId id = new ObjectId();
        int ci = 1736363971;
        String name = "Edison Verdesoto";
        String cellphone = "0988458895";
        String address = "Puente 1";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setCi(ci);
        customer.setName(name);
        customer.setCellphone(cellphone);
        customer.setAddress(address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }
    
    @Test
    public void testDefaultConstructor() {
        Customer customer = new Customer();

        assertNull(customer.getId());
        assertEquals(0, customer.getCi());
        assertNull(customer.getName());
        assertNull(customer.getCellphone());
        assertNull(customer.getAddress());
    }

    @Test
    public void testConstructorWithParameters() {
        ObjectId id = new ObjectId();
        int ci = 922876543;
        String name = "Jane Smith";
        String cellphone = "987-654-1";
        String address = "456 Guayaquil";

        Customer customer = new Customer(id, ci, name, cellphone, address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }

    @Test
    public void testSettersAndGetters() {
        Customer customer = new Customer();

        ObjectId id = new ObjectId();
        int ci = 5555555;
        String name = "Prueba 1";
        String cellphone = "111-555-0000";
        String address = "Direccion";

        customer.setId(id);
        customer.setCi(ci);
        customer.setName(name);
        customer.setCellphone(cellphone);
        customer.setAddress(address);

        assertEquals(id, customer.getId());
        assertEquals(ci, customer.getCi());
        assertEquals(name, customer.getName());
        assertEquals(cellphone, customer.getCellphone());
        assertEquals(address, customer.getAddress());
    }
    
}
