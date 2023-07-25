/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.thefamse.controller;

import ec.edu.espe.thefamse.controller.Validation;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anthony Morales, The FAMSE, DCCO-ESPE
 */
public class ValidationTest {
    
    public ValidationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of NumberValidation method, of class Validation.
     */
    @Test
    public void testNumberValidation() {
        System.out.println("NumberValidation");
        JTextField txtField = new JTextField();  
        KeyEvent evt = new KeyEvent(txtField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, '1');  
        JLabel lblfield = new JLabel();  
        int length = 10;  
        Validation instance = new Validation();
        instance.NumberValidation(txtField, evt, lblfield, length);
    }

    @Test
    public void testStringValidation() {
    System.out.println("StringValidation");
    JTextField txtField = new JTextField();  
    KeyEvent evt = new KeyEvent(txtField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');  
    JLabel lblfield = new JLabel();  
    int length = 20; 
    Validation instance = new Validation();
    instance.StringValidation(txtField, evt, lblfield, length);
    }

    
}
