package ec.edu.espe.thefamse.controller;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.thefamse.model.Supplier;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class SupplierController {
    MongoCollection<Document> collection;  
        
    private static SupplierController instance;
    
    private SupplierController() {
        this.collection = DataBaseController.getInstance().changeCollection("Supplier");
    }
    
    public synchronized static SupplierController getInstance (){
        if (instance != null){
        } 
        else {
            instance = new SupplierController();
        }
        return instance;
    }

    public boolean registerProvider(Supplier supplier) {
        try {
            Document document = new Document();
            document.append("ruc", supplier.getRuc());
            document.append("name", supplier.getName());
            document.append("cellphone", supplier.getCellphone());
            document.append("address", supplier.getAddress());
            collection.insertOne(document);
            return true;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public List<Supplier> listProviders() {
        List<Supplier> supplierList = new ArrayList<>();
        try {
            FindIterable<Document> documents = collection.find();
            for (Document document : documents) {
                Supplier supplier = new Supplier();
                supplier.setRuc(document.getInteger("ruc"));
                supplier.setName(document.getString("name"));
                supplier.setCellphone(document.getString("cellphone"));
                supplier.setAddress(document.getString("address"));
                supplier.setId(document.getObjectId("_id"));
                supplierList.add(supplier);
            }
        } catch (MongoException e) {
            System.out.println(e.toString());
        }
        return supplierList;
    }

    public boolean deleteProvider(ObjectId id) {
        try {
            Bson filter = Filters.eq("_id", id);
            DeleteResult result = collection.deleteOne(filter);
            return result.getDeletedCount() > 0;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean updateProvider(Supplier supplier) {
        try {
            Bson filter = Filters.eq("_id", supplier.getId());
            Document update = new Document("$set", new Document("ruc", supplier.getRuc())
                    .append("name", supplier.getName())
                    .append("cellphone", supplier.getCellphone())
                    .append("address", supplier.getAddress()));

            UpdateResult result = collection.updateOne(filter, update);
            return result.getModifiedCount() > 0;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
