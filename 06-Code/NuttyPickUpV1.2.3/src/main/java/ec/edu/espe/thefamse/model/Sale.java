package ec.edu.espe.thefamse.model;

import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */

public class Sale {
    private ObjectId _id;
    private String customer;
    private String seller;
    private double total;

    public Sale() {
    }

    public Sale(ObjectId _id, String customer, String seller, double total) {
        this._id = _id;
        this.customer = customer;
        this.seller = seller;
        this.total = total;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
