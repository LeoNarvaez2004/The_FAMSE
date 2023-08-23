package ec.edu.espe.thefamse.controller;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.thefamse.model.Config;
import ec.edu.espe.thefamse.model.Products;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class ProductsController {
    MongoCollection<Document> collection;  
        
    private static ProductsController instance;
    
    private ProductsController() {
        this.collection = DataBaseController.getInstance().changeCollection("Products");
    }
    
    public synchronized static ProductsController getInstance (){
        if (instance != null){
        } 
        else {
            instance = new ProductsController();
        }
        return instance;
    }

    public boolean registerProduct(Products product) {
        try {
            Document document = new Document();
            document.append("codigo", product.getCode());
            document.append("name", product.getName());
            document.append("supplier", product.getSupplier());
            document.append("stock", product.getStock());
            document.append("price", product.getPrice());

            collection.insertOne(document);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void getSuppliers(JComboBox<String> supplierComboBox) {
        try {
            FindIterable<Document> documents = collection.find();
            for (Document document : documents) {
                String supplier = document.getString("supplier");
                supplierComboBox.addItem(supplier);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public List<Products> listProducts() {
        List<Products> productList = new ArrayList<>();
        try {
            FindIterable<Document> documents = collection.find();

            for (Document document : documents) {
                Products product = new Products();
                product.setId(document.getObjectId("_id"));
                product.setCode(document.getString("codigo"));
                product.setName(document.getString("name"));
                product.setSupplier(document.getString("supplier"));
                Integer stock = document.getInteger("stock");
                if (stock != null) {
                    product.setStock(stock.intValue());
                }
                Double price = document.getDouble("price");
                if (price != null) {
                    product.setPrice(price);
                }
                productList.add(product);
            }
        } catch (MongoException e) {
            System.out.println(e.toString());
        }
        return productList;
    }

    public boolean deleteProduct(ObjectId id) {
        try {
            Bson filter = Filters.eq("_id", id);
            DeleteResult result = collection.deleteOne(filter);
            return result.getDeletedCount() > 0;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean updateProduct(Products product) {
        try {
            Bson filter = Filters.eq("_id", product.getId());
            Document update = new Document("$set", new Document("codigo", product.getCode())
                    .append("name", product.getName())
                    .append("supplier", product.getSupplier())
                    .append("stock", product.getStock())
                    .append("price", product.getPrice()));

            collection.updateOne(filter, update);

            return true;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public Products findProductByCode(String code) {
        Document query = new Document("codigo", code);
        Document result = collection.find(query).first();

        Products product = new Products();

        if (result != null) {
            product.setId(result.getObjectId("_id"));
            product.setName(result.getString("name"));
            product.setPrice(result.getDouble("price"));
            Integer stock = result.getInteger("stock");
            if (stock != null) {
                product.setStock(stock.intValue());
            }
        }

        return product;
    }
    
    public Config findData() {
        Config conf = new Config();
        try {
            DataBaseController database = DataBaseController.getInstance(); 
            MongoCollection<Document> collection = database.changeCollection("Config");
            FindIterable<Document> documents = collection.find();

            for (Document doc : documents) {
                conf.setId(doc.getObjectId("_id"));
                conf.setRuc(doc.getString("ruc"));
                conf.setName(doc.getString("name"));
                conf.setCellphone(doc.getString("cellphone"));
                conf.setAddress(doc.getString("address"));
                conf.setMesage(doc.getString("message"));
                break;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return conf;
    }


}
