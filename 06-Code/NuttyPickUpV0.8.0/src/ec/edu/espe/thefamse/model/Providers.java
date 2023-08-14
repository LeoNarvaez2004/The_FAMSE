package ec.edu.espe.thefamse.model;
import java.util.ArrayList;
import org.bson.Document;
/**
 * @author Team 5, The FAMSE, DCCO-ESPE
 */
public class Providers extends Abstract {
    private int cellPhone;
    private String providerName;
    private ArrayList<KairosDeDios> viveresPedros;
    private ArrayList<ProviderProduct> providerProduct;

    public Providers(int cellPhone, String providerName, ArrayList<KairosDeDios> viveresPedros) {
        this.cellPhone = cellPhone;
        this.providerName = providerName;
        this.viveresPedros = viveresPedros;
    }
  
     public void viveresPedro(KairosDeDios viverespedros){ 
      }
     
    public ArrayList<Money> getMoney(){
        ArrayList<Money> money = new ArrayList<>();
        
        return money;
    }
    /**
     * @return the cellPhone
     */
    public int getCellPhone() {
        return cellPhone;
    }

    /**
     * @param cellPhone the cellPhone to set
     */
    public void setCellPhone(int cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * @return the providerName
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * @param providerName the providerName to set
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * @return the viveresPedros
     */
    public ArrayList<KairosDeDios> getViveresPedros() {
        return viveresPedros;
    }

    /**
     * @param viveresPedros the viveresPedros to set
     */
    public void setViveresPedros(ArrayList<KairosDeDios> viveresPedros) {
        this.viveresPedros = viveresPedros;
    }
    public void ProviderProduct(ArrayList<ProviderProduct> providerProduct){
        this.providerProduct = providerProduct;
    }

    @Override
    public Document buildDocument() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
