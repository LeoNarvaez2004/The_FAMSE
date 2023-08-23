package ec.edu.espe.thefamse.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.thefamse.model.Login;
import org.bson.Document;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class LoginController {
    MongoCollection<Document> collection;  
        
    private static LoginController instance;
    
    private LoginController() {
        this.collection = DataBaseController.getInstance().changeCollection("Users");
    }
    
    public synchronized static LoginController getInstance (){
        if (instance != null){
        } 
        else {
            instance = new LoginController();
        }
        return instance;
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

}
