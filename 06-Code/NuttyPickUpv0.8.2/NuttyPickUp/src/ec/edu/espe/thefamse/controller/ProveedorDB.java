package ec.edu.espe.thefamse.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.thefamse.model.Proveedor;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class ProveedorDB{
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public ProveedorDB() {
        try {
            mongoClient = (MongoClient) MongoClients.create("mongodb://localhost:27017");
            database = mongoClient.getDatabase("NuttyPickUp");
            collection = database.getCollection("Proveedor");
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public boolean RegistrarProveedor(Proveedor pr) {
        try {
            Document document = new Document();
            document.append("ruc", pr.getRuc());
            document.append("name", pr.getName());
            document.append("cellphone", pr.getCellphone());
            document.append("address", pr.getAddress());
            collection.insertOne(document);
            return true;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List<Proveedor> listarProveedores() {
        
    List<Proveedor> listaProveedores = new ArrayList<>();
        try {
            FindIterable<Document> documents = collection.find();
            for (Document document : documents) {
                Proveedor proveedor = new Proveedor();
                proveedor.setRuc(document.getInteger("ruc"));
                proveedor.setName(document.getString("name"));
                proveedor.setCellphone(document.getString("cellphone"));
                proveedor.setAddress(document.getString("address"));
                proveedor.setId(document.getObjectId("_id"));
                listaProveedores.add(proveedor);
            }

        } catch (MongoException e) {
            System.out.println(e.toString());
        }
        return listaProveedores;
    }

    public boolean eliminarProveedor(ObjectId id) {
        try {
            Bson filter = Filters.eq("_id", id);
            DeleteResult result = collection.deleteOne(filter);
            
            return result.getDeletedCount() > 0;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean modificarProveedor(Proveedor pr) {
        try {
            Bson filter = Filters.eq("_id", pr.getId());
            Document update = new Document("$set", new Document("ruc", pr.getRuc())
                    .append("name", pr.getName())
                    .append("cellphone", pr.getCellphone())
                    .append("address", pr.getAddress()));

            UpdateResult result = collection.updateOne(filter, update);
            
            return result.getModifiedCount() > 0;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
}
