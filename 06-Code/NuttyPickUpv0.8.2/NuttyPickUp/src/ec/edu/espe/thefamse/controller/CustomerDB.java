package ec.edu.espe.thefamse.controller;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.thefamse.model.Customer;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

import javax.swing.JOptionPane;
import org.bson.conversions.Bson;

public class CustomerDB {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public CustomerDB() {
        try {
            mongoClient = new MongoClient("localhost", 27017);
            database = mongoClient.getDatabase("NuttyPickUp");
            collection = database.getCollection("Clientes");
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public boolean registrarCliente(Customer cl) {
        try {
            Document document = new Document();
            document.append("ci", cl.getCi());
            document.append("name", cl.getName());
            document.append("cellphone", cl.getCellphone());
            document.append("address", cl.getAddress());
            collection.insertOne(document);
            return true;
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List<Customer> listarClientes() {
        List<Customer> listaClientes = new ArrayList<>();
        try {
            FindIterable<Document> documents = collection.find();

            for (Document document : documents) {
                Customer cliente = new Customer();
                cliente.setId(document.getObjectId("_id"));
                cliente.setCi(document.getInteger("ci"));
                cliente.setName(document.getString("name"));
                cliente.setCellphone(document.getString("cellphone"));
                cliente.setAddress(document.getString("address"));
                listaClientes.add(cliente);
            }
        } catch (MongoException e) {
            System.out.println(e.toString());
        }
        return listaClientes;
    }  
    
    public boolean eliminarCliente(ObjectId id) {
        try {
            Bson filter = Filters.eq("_id", id);
            DeleteResult result = collection.deleteOne(filter);
            return result.getDeletedCount() > 0;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean modificarCliente(Customer cl) {
        try {
            Document query = new Document("_id", cl.getId());
            Document update = new Document("$set", new Document("ci", cl.getCi())
                    .append("name", cl.getName())
                    .append("cellphone", cl.getCellphone())
                    .append("address", cl.getAddress()));

            collection.updateOne(query, update);

            return true;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public Customer searchCustomer(int ci) {
    MongoCollection<Document> clientesCollection = database.getCollection("Clientes");

    Document query = new Document("ci", ci);
    Document result = clientesCollection.find(query).first();

    Customer cus = new Customer();

    if (result != null) {
        cus.setId(new ObjectId(result.get("_id").toString()));
        cus.setName(result.getString("name"));
        cus.setCellphone(result.getString("cellphone"));
        cus.setAddress(result.getString("address"));
    }

    return cus;
}

}
