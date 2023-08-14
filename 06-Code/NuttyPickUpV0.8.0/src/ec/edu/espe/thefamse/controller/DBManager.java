package ec.edu.espe.thefamse.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


/**
 *
 * @author Team 5, The FAMSE, DCCO-ESPE
 */
public class DBManager {

    static MongoDatabase database = null;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            String uri = "mongodb+srv://LeoNarvaez:LeoNarvaez@leonarvaez.obdo638.mongodb.net/";

            MongoClient mongoClient = MongoClients.create(uri);

            database = mongoClient.getDatabase("NuttyPickUp");
        }
        return database;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
