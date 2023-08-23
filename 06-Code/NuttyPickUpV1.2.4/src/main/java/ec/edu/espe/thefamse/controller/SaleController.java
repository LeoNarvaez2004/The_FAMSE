package ec.edu.espe.thefamse.controller;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.thefamse.model.Detail;
import ec.edu.espe.thefamse.model.Sale;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class SaleController {
    private MongoCollection<Document> salesCollection;
    private MongoCollection<Document> detailCollection;
    
    private static SaleController instance;
    
    private SaleController() {
        this.salesCollection = DataBaseController.getInstance().changeCollection("Sales");
        this.detailCollection = DataBaseController.getInstance().changeCollection("Detail");
    }
    
    public synchronized static SaleController getInstance (){
        if (instance != null){
        } 
        else {
            instance = new SaleController();
        }
        return instance;
    }

    public ObjectId getIdSale() {
        Document sort = new Document("_id", -1);
        Document result = salesCollection.find().sort(sort).limit(1).first();

        ObjectId _id = null;
        if (result != null) {
            _id = result.getObjectId("_id");
        }
        return _id;
    }

    public int registerSale(Sale sale) {
        Document venta = new Document();
        venta.append("customer", sale.getCustomer())
                .append("seller", sale.getSeller())
                .append("total", sale.getTotal());

        try {
            salesCollection.insertOne(venta);
            return 1;
        } catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }

    public int registerDetail(Detail detail) {
        Document detalle = new Document();
        detalle.append("id_pro", detail.getCod_pro())
                .append("cantidad", detail.getQuantity())
                .append("precio", detail.getPrice())
                .append("id_venta", detail.getId_sale());

        try {
            detailCollection.insertOne(detalle);
            return 1;
        } catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }
    
    public boolean updateStock(int cant, String cod) {
    try {
            MongoCollection<Document> productsCollection = DataBaseController.getInstance().changeCollection("Products");
            Document filter = new Document("codigo", cod);
            Document update = new Document("$set", new Document("stock", cant));
            productsCollection.updateOne(filter, update);

            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List<Sale> listSales() {
        List<Sale> saleList = new ArrayList<>();
        try {
            FindIterable<Document> documents = salesCollection.find();

            for (Document document : documents) {
                Sale sale = new Sale();
                sale.setId(document.getObjectId("_id"));
                sale.setCustomer(document.getString("customer"));
                sale.setSeller(document.getString("seller"));
                Double total = document.getDouble("total");
                if (total != null) {
                    sale.setTotal(total);
                }
                saleList.add(sale);
            }
        } catch (MongoException e) {
            System.out.println(e.toString());
        }
        return saleList;
    }

}
