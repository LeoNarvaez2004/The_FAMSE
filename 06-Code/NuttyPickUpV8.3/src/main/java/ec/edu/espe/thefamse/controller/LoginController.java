package ec.edu.espe.thefamse.controller;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.thefamse.model.Login;
import org.bson.Document;

/**
 *
 * @author Team 5, The_FAMSE
 */
public class LoginController {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public LoginController() {
        try {
            String username = "anthonymorales"; 
            String password = "anthonymorales"; 
            String databaseName = "NuttyPickUp";

            String uri = "mongodb+srv://" + username + ":" + password + "@cluster0.nngqbpt.mongodb.net/" + databaseName + "?retryWrites=true&w=majority";

            mongoClient = new MongoClient(new MongoClientURI(uri));
            database = mongoClient.getDatabase(databaseName);
            collection = database.getCollection("Users");
        } catch (Exception e) {
            System.out.println("Error al conectar a MongoDB: " + e.getMessage());
        }
    }

    public Login log(String name, String pass) {
        Login l = new Login();
        try {
            Document query = new Document("name", name)
                    .append("pass", pass);
            Document result = collection.find(query).first();

            if (result != null) {
                l.setId(result.getInteger("id"));
                l.setName(result.getString("name"));
                l.setPass(result.getString("pass"));
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta en MongoDB: " + e.getMessage());
        }

        return l;
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
