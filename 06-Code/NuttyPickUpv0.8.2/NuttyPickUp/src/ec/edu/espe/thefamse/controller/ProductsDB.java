package ec.edu.espe.thefamse.controller;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.thefamse.model.Products;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class ProductsDB {
    private MongoClient mongoClient;
    private MongoDatabase db;
    private MongoCollection<Document> collection;
    
    public ProductsDB() {
        try {
            mongoClient = (MongoClient) MongoClients.create("mongodb://localhost:27017");
            db = mongoClient.getDatabase("NuttyPickUp");
            collection = db.getCollection("Productos");
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
  
    public boolean RegistrarProductos(Products pro){
        try {
            Document document = new Document();
            document.append("codigo", pro.getCodigo());
            document.append("name", pro.getName());
            document.append("supplier", pro.getSupplier());
            document.append("stock", pro.getStock());
            document.append("price", pro.getPrecio());

            collection.insertOne(document);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public void ConsultarProveedor(JComboBox proveedor) {
        try {
            FindIterable<Document> documents = collection.find();
            for (Document document : documents) {
                String supplier = document.getString("supplier");
                proveedor.addItem(supplier);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public List<Products> listarProductos() {
        List<Products> listaPro = new ArrayList<>();
        try {
            FindIterable<Document> documents = collection.find();

            for (Document document : documents) {
                Products pro = new Products();
                pro.setId(document.getObjectId("_id"));
                pro.setCodigo(document.getString("codigo"));
                pro.setName(document.getString("name"));
                pro.setSupplier(document.getString("supplier"));
                Integer stock = document.getInteger("stock");
                if (stock != null) {
                    pro.setStock(stock.intValue());
                }
                Double price = document.getDouble("price");
                if (price != null) {
                    pro.setPrecio(price);
                }
                listaPro.add(pro);
            }
        } catch (MongoException e) {
            System.out.println(e.toString());
        }
        return listaPro;
    }

    public boolean eliminarProductos(ObjectId id) {
        try {
            Bson filter = Filters.eq("_id", id);
            DeleteResult result = collection.deleteOne(filter);
            return result.getDeletedCount() > 0;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean modificarProducto(Products pro) {
        try {
            Document query = new Document("_id", pro.getId());
            Document update = new Document("$set", new Document("codigo", pro.getCodigo())
                    .append("name", pro.getName())
                    .append("supplier", pro.getSupplier())
                    .append("stock", pro.getStock())
                    .append("price", pro.getPrecio()));
                    
            collection.updateOne(query, update);

            return true;
        } catch (MongoException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public Products buscarProducto(String cod) {
        Document query = new Document("codigo", cod);
        Document result = collection.find(query).first();

        Products producto = new Products();

        if (result != null) {
            producto.setId(result.getObjectId("_id"));
            producto.setName(result.getString("name"));
            producto.setPrecio(result.getDouble("price"));
            producto.setStock(result.getInteger("stock"));
        }

        return producto;
    }

    
}


