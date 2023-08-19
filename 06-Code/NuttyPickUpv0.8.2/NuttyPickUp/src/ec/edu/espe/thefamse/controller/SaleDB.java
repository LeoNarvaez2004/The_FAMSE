package ec.edu.espe.thefamse.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.thefamse.model.Detail;
import ec.edu.espe.thefamse.model.Sale;
import org.bson.Document;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class SaleDB {
    MongoClient mongoClient = (MongoClient) MongoClients.create("mongodb://localhost:27017");
    MongoDatabase database = mongoClient.getDatabase("NuttyPickUp");
    MongoCollection<Document> salesCollection = database.getCollection("Ventas");

    public int getIdSale() {
        Document query = new Document();
        query.append("_id", -1);
        Document sort = new Document();
        sort.append("_id", -1);

        Document result = salesCollection.find().sort(sort).limit(1).projection(query).first();

        int id = 0;
        if (result != null) {
            id = result.getInteger("_id");
        }
    return id;
    }

    
    public int registerSale(Sale s) {
        Document venta = new Document();
        venta.append("cliente", s.getCustomer())
                .append("vendedor", s.getSeller())
                .append("total", s.getTotal());

        try {
            salesCollection.insertOne(venta);
            return 1;
        } catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }
    
    public int registrarDetalle(Detail di) {
        MongoCollection<Document> detalleCollection = database.getCollection("Detail");

        Document detalle = new Document();
        detalle.append("id_pro", di.getId())
                .append("cantidad", di.getQuantity())
                .append("precio", di.getPrice())
                .append("id_venta", di.getId());

        try {
            detalleCollection.insertOne(detalle);
            return 1;
        } catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }


}
