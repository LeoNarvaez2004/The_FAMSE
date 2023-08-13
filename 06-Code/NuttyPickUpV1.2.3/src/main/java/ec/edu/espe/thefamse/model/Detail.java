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

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getCod_pro() {
        return cod_pro;
    }

    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId_sale() {
        return id_sale;
    }

    public void setId_sale(int id_sale) {
        this.id_sale = id_sale;
    }
    
}
