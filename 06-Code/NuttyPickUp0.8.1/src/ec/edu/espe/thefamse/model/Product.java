package ec.edu.espe.thefamse.model;

import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author David Moran, The FAMSE, DCCO-ESPE
 * 
 */
public class Product extends Abstract {
    private int code;
    private float price;
    private int lote;
    private String name;
    private String descrption;
    private ArrayList<Customer> costumers;

    public Product(int code, float price, int lote, String name, String descrption, ArrayList<Customer> costumers) {
        this.code = code;
        this.price = price;
        this.lote = lote;
        this.name = name;
        this.descrption = descrption;
        this.costumers = costumers;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the lote
     */
    public int getLote() {
        return lote;
    }

    /**
     * @param lote the lote to set
     */
    public void setLote(int lote) {
        this.lote = lote;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the descrption
     */
    public String getDescrption() {
        return descrption;
    }

    /**
     * @param descrption the descrption to set
     */
    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    /**
     * @return the costumers
     */
    public ArrayList<Customer> getCostumers() {
        return costumers;
    }

    /**
     * @param costumers the costumers to set
     */
    public void setCostumers(ArrayList<Customer> costumers) {
        this.costumers = costumers;
    }

    /**
     * @return the cachiers
     */

    @Override
    public Document buildDocument() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}    