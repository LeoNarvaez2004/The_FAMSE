
package ec.edu.espe.thefamse.model;

import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class Customer {
    private ObjectId _id;
    private int ci;
    private String name;
    private String cellphone;
    private String address;

    public Customer() {
    }

    public Customer(ObjectId _id, int ci, String name, String cellphone, String address) {
        this._id = _id;
        this.ci = ci;
        this.name = name;
        this.cellphone = cellphone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "_id=" + _id + ", ci=" + ci + ", name=" + name + ", cellphone=" + cellphone + ", address=" + address + '}';
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
     * @return the ci
     */
    public int getCi() {
        return ci;
    }

    /**
     * @param ci the ci to set
     */
    public void setCi(int ci) {
        this.ci = ci;
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
     * @return the cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * @param cellphone the cellphone to set
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
