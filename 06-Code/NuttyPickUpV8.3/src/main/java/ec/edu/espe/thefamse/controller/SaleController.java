package ec.edu.espe.thefamse.controller;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.thefamse.model.Detail;
import ec.edu.espe.thefamse.model.Products;
import ec.edu.espe.thefamse.model.Sale;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Team 5, The_FAMSE
 */
public class SaleController {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> salesCollection;

    public SaleController() {
        try {
            String username = "anthonymorales"; 
            String password = "anthonymorales"; 
            String databaseName = "NuttyPickUp";

            String uri = "mongodb+srv://" + username + ":" + password + "@cluster0.nngqbpt.mongodb.net/" + databaseName + "?retryWrites=true&w=majority";

            mongoClient = MongoClients.create(uri);
            database = mongoClient.getDatabase(databaseName);
            salesCollection = database.getCollection("Sales");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        MongoCollection<Document> detailCollection = database.getCollection("Detail");

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
            
            MongoCollection<Document> collection = database.getCollection("Products");
            Document filter = new Document("codigo", cod);
            Document update = new Document("$set", new Document("stock", cant));
            collection.updateOne(filter, update);

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
