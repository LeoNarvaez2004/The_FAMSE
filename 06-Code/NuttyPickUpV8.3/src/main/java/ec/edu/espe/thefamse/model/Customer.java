package ec.edu.espe.thefamse.model;

import org.bson.types.ObjectId;

/**
 *
 * @author Team 5, The_FAMSE
 */
public class Customer {
  private ObjectId _id;
  private int ci;
  private String name;
  private String cellphone;
  private String address;

    @Override
    public String toString() {
        return "Customer{" + "_id=" + _id + ", ci=" + ci + ", name=" + name + ", cellphone=" + cellphone + ", address=" + address + '}';
    }

    public Customer(ObjectId _id, int ci, String name, String cellphone, String address) {
        this._id = _id;
        this.ci = ci;
        this.name = name;
        this.cellphone = cellphone;
        this.address = address;
    }

    public Customer() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
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
