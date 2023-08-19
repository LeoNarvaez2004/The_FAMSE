package ec.edu.espe.thefamse.model;

import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class Products {
    ObjectId _id;
    private String codigo;
    private String name;
    private String supplier;
    private int stock;
    private double precio;

    @Override
    public String toString() {
        return "Products{" + "_id=" + _id + ", codigo=" + codigo + ", name=" + name + ", supplier=" + supplier + ", stock=" + stock + ", precio=" + precio + '}';
    }

    public Products() {
    }

    public Products(ObjectId _id, String codigo, String name, String supplier, int stock, double precio) {
        this._id = _id;
        this.codigo = codigo;
        this.name = name;
        this.supplier = supplier;
        this.stock = stock;
        this.precio = precio;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the supplier
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
