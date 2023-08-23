package ec.edu.espe.thefamse.controller;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.thefamse.model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class CustomerController {
    MongoCollection<Document> collection;  
        
    private static CustomerController instance;
    
    private CustomerController() {
        this.collection = DataBaseController.getInstance().changeCollection("Customers");
    }
    
    public synchronized static CustomerController getInstance (){
        if (instance != null){
        } 
        else {
            instance = new CustomerController();
        }
        return instance;
    }

    public boolean registerCustomer(Customer customer) {
        try {
            Document document = new Document();
            document.append("ci", customer.getCi());
            document.append("name", customer.getName());
            document.append("cellphone", customer.getCellphone());
            document.append("address", customer.getAddress());
            collection.insertOne(document);
            return true;
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List<Customer> listCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {
            FindIterable<Document> documents = collection.find();

            for (Document document : documents) {
                Customer customer = new Customer();
                customer.setId(document.getObjectId("_id"));
                customer.setCi(document.getInteger("ci"));
                customer.setName(document.getString("name"));
                customer.setCellphone(document.getString("cellphone"));
                customer.setAddress(document.getString("address"));
                customerList.add(customer);
            }
        } catch (MongoException e) {
            System.out.println(e.toString());
        }
        return customerList;
    }  
    
    public boolean deleteCustomer(ObjectId id) {
        try {
            Bson filter = Filters.eq("_id", id);
            DeleteResult result = collection.deleteOne(filter);
            return result.getDeletedCount() > 0;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean updateCustomer(Customer customer) {
        try {
            Document query = new Document("_id", customer.getId());
            Document update = new Document("$set", new Document("ci", customer.getCi())
                    .append("name", customer.getName())
                    .append("cellphone", customer.getCellphone())
                    .append("address", customer.getAddress()));

            collection.updateOne(query, update);

            return true;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public Customer searchCustomerByCI(int ci) {
        Document query = new Document("ci", ci);
        Document result = collection.find(query).first();

        Customer customer = new Customer();

        if (result != null) {
            customer.setId(new ObjectId(result.get("_id").toString()));
            customer.setName(result.getString("name"));
            customer.setCellphone(result.getString("cellphone"));
            customer.setAddress(result.getString("address"));
        }

        return customer;
    }
}
