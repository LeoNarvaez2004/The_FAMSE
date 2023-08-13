package ec.edu.espe.thefamse.model;

import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class Products {
   private ObjectId _id;
   private String code;
   private String name;
   private String supplier;
   private int stock;
   private double price;

    @Override
    public String toString() {
        return "Products{" + "_id=" + _id + ", code=" + code + ", name=" + name + ", supplier=" + supplier + ", stock=" + stock + ", price=" + price + '}';
    }

    public Products() {
    }

    public Products(ObjectId _id, String code, String name, String supplier, int stock, double price) {
        this._id = _id;
        this.code = code;
        this.name = name;
        this.supplier = supplier;
        this.stock = stock;
        this.price = price;
    }
   
    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
   
}
