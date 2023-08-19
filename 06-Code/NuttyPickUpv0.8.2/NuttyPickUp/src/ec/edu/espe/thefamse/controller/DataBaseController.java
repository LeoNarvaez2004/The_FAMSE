package ec.edu.espe.thefamse.controller;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DataBaseController {
    String clientURL;
    String databaseName;
    MongoDatabase database;
    MongoClient mongoClient;
    

    private DataBaseController(){
        this.clientURL = "mongodb+srv://anthonymorales:anthonymorales@cluster0.nngqbpt.mongodb.net/";
        this.databaseName = "NuttyPickUp";
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión cerrada");
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public static void main(String[] args) {
        DataBaseController connection = new DataBaseController();
        //connection.connect();

        // Realiza tus operaciones con la base de datos aquí

        connection.close();
    }
}
