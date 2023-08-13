package ec.edu.espe.thefamse.model;

import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class Supplier {
    private ObjectId _id;
    private int ruc;
    private String name;
    private String cellphone;
    private String address;

    public Supplier() {
    }

    public Supplier(ObjectId _id, int ruc, String name, String cellphone, String address) {
        this._id = _id;
        this.ruc = ruc;
        this.name = name;
        this.cellphone = cellphone;
        this.address = address;
    }
    
    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
