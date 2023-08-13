package ec.edu.espe.thefamse.model;

import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class Config {
    private ObjectId _id;
    private String ruc;
    private String name;
    private String cellphone;
    private String address;
    private String mesage;

    public Config() {
    }

    public Config(ObjectId _id, String ruc, String name, String cellphone, String address, String mesage) {
        this._id = _id;
        this.ruc = ruc;
        this.name = name;
        this.cellphone = cellphone;
        this.address = address;
        this.mesage = mesage;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
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

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }
    
    
}
