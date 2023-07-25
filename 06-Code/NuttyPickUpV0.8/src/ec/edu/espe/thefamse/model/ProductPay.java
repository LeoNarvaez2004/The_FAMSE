package ec.edu.espe.thefamse.model;

/**
 *
 * @author David Moran, The FAMSE, DCCO-ESPE
 */
public class ProductPay {
    private double iva;
    private double discount;
    private int unit;
    private float price;
    private float totalPay;
    private float totalPayIva;

   
    public ProductPay(double iva, double discount, int unit, float price, float totalPay, float totalPayIva) {
        this.iva = iva;
        this.discount = discount;
        this.unit = unit;
        this.price = price;
        this.totalPay = totalPay;
        this.totalPayIva = totalPayIva;
    }

     public ProductPay() {
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the unit
     */
    public int getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(int unit) {
        this.unit = unit;
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
     * @return the totalPay
     */
    public float getTotalPay() {
        return totalPay;
    }

    /**
     * @param totalPay the totalPay to set
     */
    public void setTotalPay(float totalPay) {
        this.totalPay = totalPay;
    }

    /**
     * @return the totalPayIva
     */
    public float getTotalPayIva() {
        return totalPayIva;
    }

    /**
     * @param totalPayIva the totalPayIva to set
     */
    public void setTotalPayIva(float totalPayIva) {
        this.totalPayIva = totalPayIva;
    }
    
}
