
package ec.edu.espe.thefamse.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.thefamse.utils.DataBaseManager;
import org.bson.Document;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class DataBaseController {
    String clientURL;
    String databaseName;
    MongoDatabase database;

    private static DataBaseController instance;
    
    private DataBaseController() {
        this.clientURL = "mongodb+srv://anthonymorales:anthonymorales@cluster0.nngqbpt.mongodb.net/";
        this.databaseName = "NuttyPickUp";
        this.database = DataBaseManager.connectToDatabase(clientURL, databaseName);
    }
    
    public synchronized static DataBaseController getInstance (){
        if (instance != null){
        
        } 
        else {
            instance = new DataBaseController();
        }
        
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    public MongoCollection changeCollection(String collectionName){
        MongoCollection <Document> collection = DataBaseManager.connectToCollection(database, collectionName);
        return collection;
    }
}
