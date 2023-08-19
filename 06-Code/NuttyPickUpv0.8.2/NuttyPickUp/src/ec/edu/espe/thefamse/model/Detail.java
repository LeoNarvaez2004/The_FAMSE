
package ec.edu.espe.thefamse.model;

import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class Detail {
    private ObjectId _id;
    private String cod_pro;
    private int quantity;
    private double price;
    private int id_sale;

    public Detail() {
    }

    public Detail(ObjectId _id, String cod_pro, int quantity, double price, int id_sale) {
        this._id = _id;
        this.cod_pro = cod_pro;
        this.quantity = quantity;
        this.price = price;
        this.id_sale = id_sale;
    }

    /**
     * @return the _id
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * @return the cod_pro
     */
    public String getCod_pro() {
        return cod_pro;
    }

    /**
     * @param cod_pro the cod_pro to set
     */
    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the id_sale
     */
    public int getId_sale() {
        return id_sale;
    }

    /**
     * @param id_sale the id_sale to set
     */
    public void setId_sale(int id_sale) {
        this.id_sale = id_sale;
    }
    
}
