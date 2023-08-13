
package ec.edu.espe.thefamse.controller;

import ec.edu.espe.thefamse.model.Config;
import ec.edu.espe.thefamse.model.Customer;
import ec.edu.espe.thefamse.model.Detail;
import ec.edu.espe.thefamse.model.Events;
import ec.edu.espe.thefamse.model.Products;
import ec.edu.espe.thefamse.model.Sale;
import ec.edu.espe.thefamse.model.Supplier;
import ec.edu.espe.thefamse.view.FrmSystem;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;


/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class SystemController {
    Customer cl = new Customer();
    CustomerController customer = new CustomerController();
    Supplier sp = new Supplier();
    SupplierController prDao = new SupplierController();
    Products pro = new Products();
    ProductsController proDao = new ProductsController();
    Sale s = new Sale();
    SaleController sdb = new SaleController();
    Detail di = new Detail();
    Config cf = new Config();
    Events event = new Events();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
    int item;
    double totalPay = 0.00;
    
    private FrmSystem form;

    public SystemController(FrmSystem form) {
        this.form = form;
    }   
    
    public void btnSaveSupplierActionPerformed(JTextField txtRucSupplier, JTextField txtNameSupplier, JTextField txtCellphoneSupplier, JTextField txtAddressSupplier){
        if(!"".equals(txtRucSupplier.getText()) || !"".equals(txtNameSupplier.getText()) || !"".equals(txtCellphoneSupplier.getText()) || !"".equals(txtAddressSupplier.getText())){
           sp.setRuc(Integer.parseInt(txtRucSupplier.getText()));
           sp.setName(txtNameSupplier.getText());
           sp.setCellphone(txtCellphoneSupplier.getText());
           sp.setAddress(txtAddressSupplier.getText());
           prDao.registerProvider(sp);
           JOptionPane.showMessageDialog(null,"Proveedor Registrado.");
           form.CleanTable();
           form.ListSupplier();
           form.cleanSupplier();
        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }
    
    public void btnUpdateSupplierActionPerformed(JTextField txtIdSupplier, JTextField txtRucSupplier, JTextField txtNameSupplier, JTextField txtCellphoneSupplier, JTextField txtAddressSupplier){
        if ("".equals(txtIdSupplier.getText())) {
        JOptionPane.showMessageDialog(null, "Seleccione una Fila.");
        } else {
            if (!"".equals(txtRucSupplier.getText()) || !"".equals(txtNameSupplier.getText()) || !"".equals(txtCellphoneSupplier.getText()) || !"".equals(txtAddressSupplier.getText())) {
                ObjectId id = new ObjectId(txtIdSupplier.getText());
                sp.setId(id);
                sp.setRuc(Integer.parseInt(txtRucSupplier.getText()));
                sp.setName(txtNameSupplier.getText());
                sp.setCellphone(txtCellphoneSupplier.getText());
                sp.setAddress(txtAddressSupplier.getText());
                prDao.updateProvider(sp);
                JOptionPane.showMessageDialog(null, "Proveedor Actualizado.");
                form.CleanTable();
                form.ListSupplier();
                form.cleanSupplier();
            }
        }
    }
    
    public void btnDeletSupplierActionPerformed(JTextField txtIdSupplier){
        if (!"".equals(txtIdSupplier.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar");
            if (pregunta == 0){
                ObjectId id = new ObjectId(txtIdSupplier.getText());
                prDao.deleteProvider(id);
                JOptionPane.showMessageDialog(null, "Proveedor Eliminado.");
                form.CleanTable();
                form.ListSupplier();
                form.cleanSupplier();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una Fila.");
        }
    }
    
    public void btnSaveCustomerActionPerformed(JTextField txtIdCustomer, JTextField txtCustomerCI, JTextField txtNameCustomer, JTextField txtCustomerCellphone, JTextField txtCustomerAddress){
        if (!txtCustomerCI.getText().isEmpty() && !txtNameCustomer.getText().isEmpty() && !txtCustomerCellphone.getText().isEmpty() && !txtCustomerAddress.getText().isEmpty()) {
          cl.setCi(Integer.parseInt(txtCustomerCI.getText()));
          cl.setName(txtNameCustomer.getText()); 
          cl.setCellphone(txtCustomerCellphone.getText());
          cl.setAddress(txtCustomerAddress.getText());
          customer.registerCustomer(cl);
          JOptionPane.showMessageDialog(null,"Cliente Registrado.");
          form.CleanTable();
          form.cleanCustomer();
          form.ListCustomer();
        }else{
            JOptionPane.showMessageDialog(null,"Los campos estan vacios");
        }
    }

    public void btnUpdateCustomerActionPerformed(JTextField txtIdCustomer, JTextField txtCustomerCI, JTextField txtNameCustomer, JTextField txtCustomerCellphone, JTextField txtCustomerAddress){
        if("".equals(txtIdCustomer.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una Fila");
        }else{
            if(!"".equals(txtCustomerCI.getText()) || !"".equals(txtNameCustomer.getText()) || !"".equals(txtCustomerCellphone.getText()) || !"".equals(txtCustomerAddress.getText())){
                cl.setCi(Integer.parseInt(txtCustomerCI.getText()));
                cl.setName(txtNameCustomer.getText());
                cl.setCellphone(txtCustomerCellphone.getText());
                cl.setAddress(txtCustomerAddress.getText());
                cl.setId(new ObjectId(txtIdCustomer.getText()));
                customer.updateCustomer(cl);
                JOptionPane.showMessageDialog(null,"Cliente Actualizado.");
                form.CleanTable();
                form.cleanCustomer();
                form.ListCustomer();
            }else{
                JOptionPane.showMessageDialog(null,"Los campos estan Vacios");
            }
            
        }
    }

    public void btnDeleteCustomerActionPerformed(JTextField txtIdCustomer){
                if (!"".equals(txtIdCustomer.getText())) {
            int question = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?");
            if (question == 0) {
                String id = txtIdCustomer.getText();
                
                try {
                    ObjectId objectId = new ObjectId(id);

                    if (customer.deleteCustomer(objectId)) {
                        JOptionPane.showMessageDialog(null, "Cliente Eliminado.");
                        form.CleanTable();
                        form.cleanCustomer();
                        form.ListCustomer();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el cliente.");
                    }
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "ID de cliente no válido.");
                }
            }
        }
    }
        
    public void btnSaveProActionPerformed(JTextField txtCodePro, JTextField txtDesPro, JComboBox<String> cbxSupplierPro, JTextField txtQuantityPro, JTextField txtPricePro){
        if(!"".equals(txtCodePro.getText()) || !"".equals(txtDesPro.getText()) || !"".equals(cbxSupplierPro.getSelectedItem()) || !"".equals(txtQuantityPro.getText()) || !"".equals(txtPricePro.getText())){
            pro.setCode(txtCodePro.getText());
            pro.setName(txtDesPro.getText());
            pro.setSupplier(cbxSupplierPro.getSelectedItem().toString());
            pro.setStock(Integer.parseInt(txtQuantityPro.getText()));
            pro.setPrice(Double.parseDouble(txtPricePro.getText()));
            proDao.registerProduct(pro);
            JOptionPane.showMessageDialog(null, "Productos Registrados");
            form.CleanTable();
            form.ListProducts();
            form.cleanProducts();
        }else{
            JOptionPane.showMessageDialog(null,"Los campos estan vacios");
        }
    }

    public void btnUpdateProActionPerformed(JTextField txtIdPro, JTextField txtCodePro, JTextField txtDesPro, JTextField txtQuantityPro, JTextField txtPricePro, JComboBox<String> cbxSupplierPro){
        if ("".equals(txtIdPro.getText())) {
        JOptionPane.showMessageDialog(null, "Seleccione una Fila.");
        } else {
            if (!"".equals(txtCodePro.getText()) || !"".equals(txtDesPro.getText()) || !"".equals(txtQuantityPro.getText()) || !"".equals(txtPricePro.getText())) {
                ObjectId id = new ObjectId(txtIdPro.getText());
                pro.setId(id);
                pro.setCode(txtCodePro.getText());
                pro.setName(txtDesPro.getText());
                pro.setSupplier(cbxSupplierPro.getSelectedItem().toString());
                pro.setStock(Integer.parseInt(txtQuantityPro.getText()));
                pro.setPrice(Double.parseDouble(txtPricePro.getText()));
                proDao.updateProduct(pro);
                JOptionPane.showMessageDialog(null, "Producto Actualizado.");
                form.CleanTable();
                form.ListProducts();
                form.cleanProducts();
            }
        }
    }

    public void btnDeleteProActionPerformed(JTextField txtIdPro){
        if(!"".equals(txtIdPro.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null,"Estas seguro de eliminar");
            if(pregunta == 0){
                ObjectId id = new ObjectId(txtIdPro.getText());
                proDao.deleteProduct(id);
                JOptionPane.showMessageDialog(null,"Producto Eliminado.");
                form.CleanTable();
                form.ListProducts();
                form.cleanProducts();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una Fila.");
        }
    }

    public void btnGenerateSalesActionPerformed(JTable TableSales, JTextField txtCustomerName){
        if(TableSales.getRowCount() > 0 ){
            if(!"".equals(txtCustomerName.getText())){
                form.registerSale();
                form.registerDetail();
                form.updateStock();
                form.generatePDF();
                form.cleanTableSale();
                form.cleanCustomerSale();
            }else{
                JOptionPane.showMessageDialog(null, "Debe buscar un Cliente.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay productos seleccionados para vender.");
        }
    }
    
    public void TableProductMouseClicked(int fila, JTable TableProduct, JTextField txtIdPro, JTextField txtCodePro, JTextField txtDesPro, JComboBox<String> cbxSupplierPro, JTextField txtQuantityPro, JTextField txtPricePro){
        int row = TableProduct.getSelectedRow();
            if (row >= 0) {
                String id = TableProduct.getValueAt(row, 0).toString();
                String codigo = TableProduct.getValueAt(row, 1).toString();
                String nombre = TableProduct.getValueAt(row, 2).toString();
                String proveedor = TableProduct.getValueAt(row, 3).toString();
                String stock = TableProduct.getValueAt(row, 4).toString();
                String precio = TableProduct.getValueAt(row, 5).toString();

                txtIdPro.setText(id);
                txtCodePro.setText(codigo);
                txtDesPro.setText(nombre);
                cbxSupplierPro.setSelectedItem(proveedor);
                txtQuantityPro.setText(stock);
                txtPricePro.setText(precio);
            }
    }
    
    public void txtSalesCodeKeyPressed(KeyEvent evt, JTextField txtQuantitySale, JTextField txtSalesCode, JTextField txtDescriptionSale, JTextField txtSellingPrice, JTextField txtStockAvailable, JTable TableSales) {                                        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtSalesCode.getText())){
                String cod = txtSalesCode.getText();
                pro = proDao.findProductByCode(cod);
                if(pro.getName() != null){
                    txtDescriptionSale.setText(""+pro.getName());
                    txtSellingPrice.setText(""+pro.getPrice());
                    txtStockAvailable.setText(""+pro.getStock());
                    txtQuantitySale.requestFocus();
                }else{
                   form.cleanSales();
                   txtSalesCode.requestFocus(); 
                }
            }else{
                JOptionPane.showMessageDialog(null,"Ingrese el Codigo del Producto.");
                txtSalesCode.requestFocus();
            }
        }
    }

    public void txtQuantitySaleKeyPressed(KeyEvent evt, JTextField txtQuantitySale, JTextField txtSalesCode, JTextField txtDescriptionSale, JTextField txtSellingPrice, JTextField txtStockAvailable, JTable TableSales){
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtQuantitySale.getText())){
                String cod = txtSalesCode.getText();
                String description = txtDescriptionSale.getText();
                int cant = Integer.parseInt(txtQuantitySale.getText());
                double price = Double.parseDouble(txtSellingPrice.getText());
                double total = cant * price;
                int stock = Integer.parseInt(txtStockAvailable.getText());
                if(stock >= cant){
                    item = item + 1;
                    tmp = (DefaultTableModel) TableSales.getModel();
                    for(int i = 0; i < TableSales.getRowCount(); i++){
                        if(TableSales.getValueAt(i, 1).equals(txtDescriptionSale.getText())){
                            JOptionPane.showMessageDialog(null, "El Producto ya esta Registrado.");
                            return;
                        }
                    }
                    ArrayList list = new ArrayList();
                    list.add(item);
                    list.add(cod);
                    list.add(description);
                    list.add(cant);
                    list.add(price);
                    list.add(total);
                    Object[] Obj = new Object[5];
                    Obj[0] = list.get(1);
                    Obj[1] = list.get(2);
                    Obj[2] = list.get(3);
                    Obj[3] = list.get(4);
                    Obj[4] = list.get(4);
                    tmp.addRow(Obj);
                    TableSales.setModel(tmp);
                    form.totalPay();
                    form.cleanSales();
                    txtSalesCode.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Stock no Disponible.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad.");
            }
        }        
    }
    
    public void txtRucSaleKeyPressed(KeyEvent evt, JTextField txtRucSale, JTextField txtCustomerName, JTextField txtCellphoneCusS, JTextField txtAddressCusS){
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtRucSale.getText())){
                int ci = Integer.parseInt(txtRucSale.getText());
                cl = customer.searchCustomerByCI(ci);
                if(cl.getName() != null){
                    txtCustomerName.setText(""+cl.getName());
                    txtCellphoneCusS.setText(""+cl.getCellphone());
                    txtAddressCusS.setText(""+cl.getAddress());
                }else{
                    txtRucSale.setText("");
                    JOptionPane.showMessageDialog(null, "El Cliente No Existe.");
                }
            }
        }
    }

    public void btnPdfSalesActionPerformed(){
        try{
            ObjectId _id = sdb.getIdSale();
            File file = new File("src\\main\\java\\ec\\edu\\espe\\thefamse\\utils\\ventas"+_id+".pdf");
            Desktop.getDesktop().open(file);
        }catch(IOException ex){
            Logger.getLogger(FrmSystem.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
}
