package ec.edu.espe.thefamse.controller;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.thefamse.model.Login;
import org.bson.Document;

public class LoginDB {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public LoginDB() {
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            database = mongoClient.getDatabase("NuttyPickUp");
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
        // Cerrar la conexión a MongoDB
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
