package ec.edu.espe.thefamse.view;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ec.edu.espe.thefamse.model.Customer;
import ec.edu.espe.thefamse.controller.CustomerController;
import ec.edu.espe.thefamse.model.Detail;
import ec.edu.espe.thefamse.model.Events;
import ec.edu.espe.thefamse.model.Products;
import ec.edu.espe.thefamse.controller.ProductsController;
import ec.edu.espe.thefamse.model.Supplier;
import ec.edu.espe.thefamse.controller.SupplierController;
import ec.edu.espe.thefamse.model.Sale;
import ec.edu.espe.thefamse.controller.SaleController;
import ec.edu.espe.thefamse.model.Config;
import ec.edu.espe.thefamse.utils.ReportExcel;
import java.awt.Desktop;
import java.util.ArrayList;
import org.bson.types.ObjectId;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class FrmSystem extends javax.swing.JFrame {
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
    
    public FrmSystem() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdCustomer.setVisible(false);
        txtIdPro.setVisible(false);
        txtIdSales.setVisible(false);
        txtIdSupplier.setVisible(false);
        txtIdSales.setVisible(false);
        txtIdConfig.setVisible(false);
        proDao.getSuppliers(cbxSupplierPro);
        ListConfig();
    }
    
    public void ListCustomer() {
        List<Customer> ListarCl = customer.listCustomers();
        modelo = (DefaultTableModel) TableCustomer.getModel();
        Object[] ob = new Object[6];
        for(int i = 0; i < ListarCl.size(); i++){
            ob[0] = ListarCl.get(i).getId();
            ob[1] =  ListarCl.get(i).getCi();
            ob[2] = ListarCl.get(i).getName();
            ob[3] = ListarCl.get(i).getCellphone();
            ob[4] = ListarCl.get(i).getAddress();
            modelo.addRow(ob);
        }
        TableCustomer.setModel(modelo);
    }
    
    public void ListSupplier() {
        List<Supplier> ListarPr = prDao.listProviders();
        modelo = (DefaultTableModel) TableSupplier.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarPr.size(); i++) {
            ob[0] = ListarPr.get(i).getId();
            ob[1] = ListarPr.get(i).getRuc();
            ob[2] = ListarPr.get(i).getName();
            ob[3] = ListarPr.get(i).getCellphone();
            ob[4] = ListarPr.get(i).getAddress();
            modelo.addRow(ob);
        }
        TableSupplier.setModel(modelo);
    }
    
    public void ListProducts() {
        List<Products> ListarPro = proDao.listProducts();
        modelo = (DefaultTableModel) TableProduct.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarPro.size(); i++) {
            ob[0] = ListarPro.get(i).getId();
            ob[1] = ListarPro.get(i).getCode();
            ob[2] = ListarPro.get(i).getName();
            ob[3] = ListarPro.get(i).getSupplier();
            ob[4] = ListarPro.get(i).getStock();
            ob[5] = ListarPro.get(i).getPrice();
            modelo.addRow(ob);
        }
        TableProduct.setModel(modelo);
    }
    
    public void ListConfig(){
       cf = proDao.findData();
       txtIdConfig.setText(""+cf.getId());
       txtRucConfig.setText(""+cf.getRuc());
       txtNameConfig.setText(""+cf.getName());
       txtCellphoneConfig.setText(""+cf.getCellphone());
       txtAddressConfig.setText(""+cf.getAddress());
       txtRazonConfig.setText(""+cf.getMesage());
    }
    
    public void ListSales() {
        List<Sale> ListSale = sdb.listSales();
        modelo = (DefaultTableModel) TableSales2.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < ListSale.size(); i++) {
            ob[0] = ListSale.get(i).getId();
            ob[1] = ListSale.get(i).getCustomer();
            ob[2] = ListSale.get(i).getSeller();
            ob[3] = ListSale.get(i).getTotal();
            modelo.addRow(ob);
        }
        TableSales2.setModel(modelo);
    }
    
    public void CleanTable(){
        for(int i = 0; i<modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableSale = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnNuevaVenta = new javax.swing.JButton();
        btnClient = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnProducts = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        LabelSeller = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnElminateSale = new javax.swing.JButton();
        txtSalesCode = new javax.swing.JTextField();
        txtDescriptionSale = new javax.swing.JTextField();
        txtQuantitySale = new javax.swing.JTextField();
        txtSellingPrice = new javax.swing.JTextField();
        txtStockAvailable = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRucSale = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        btnGenerateSales = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtLabelTotal = new javax.swing.JLabel();
        txtIdProduct = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableSales = new javax.swing.JTable();
        txtCellphoneCusS = new javax.swing.JTextField();
        txtAddressCusS = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCustomerCI = new javax.swing.JTextField();
        txtNameCustomer = new javax.swing.JTextField();
        txtCustomerCellphone = new javax.swing.JTextField();
        txtCustomerAddress = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCustomer = new javax.swing.JTable();
        btnSaveCustomer = new javax.swing.JButton();
        btnUpdateCustomer = new javax.swing.JButton();
        btnDeleteCustomer = new javax.swing.JButton();
        btnCreateCustomer = new javax.swing.JButton();
        txtIdCustomer = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtRucSupplier = new javax.swing.JTextField();
        txtNameSupplier = new javax.swing.JTextField();
        txtCellphoneSupplier = new javax.swing.JTextField();
        txtAddressSupplier = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableSupplier = new javax.swing.JTable();
        btnSaveSupplier = new javax.swing.JButton();
        btnUpdateSupplier = new javax.swing.JButton();
        btnDeletSupplier = new javax.swing.JButton();
        btnCreateSupplier = new javax.swing.JButton();
        txtIdSupplier = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtCodePro = new javax.swing.JTextField();
        txtDesPro = new javax.swing.JTextField();
        txtQuantityPro = new javax.swing.JTextField();
        txtPricePro = new javax.swing.JTextField();
        cbxSupplierPro = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableProduct = new javax.swing.JTable();
        btnSavePro = new javax.swing.JButton();
        btnUpdatePro = new javax.swing.JButton();
        btnCreatePro = new javax.swing.JButton();
        btnDeletePro = new javax.swing.JButton();
        btnJsonPro = new javax.swing.JButton();
        txtIdPro = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableSales2 = new javax.swing.JTable();
        btnPdfSales = new javax.swing.JButton();
        txtIdSales = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtRucConfig = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtNameConfig = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtAddressConfig = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtRazonConfig = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtCellphoneConfig = new javax.swing.JTextField();
        btnUpdateConfig = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtIdConfig = new javax.swing.JTextField();

        TableSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCIÓN", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(TableSale);
        if (TableSale.getColumnModel().getColumnCount() > 0) {
            TableSale.getColumnModel().getColumn(0).setPreferredWidth(30);
            TableSale.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableSale.getColumnModel().getColumn(2).setPreferredWidth(30);
            TableSale.getColumnModel().getColumn(3).setPreferredWidth(30);
            TableSale.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));

        btnNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevav.jpg"))); // NOI18N
        btnNuevaVenta.setText("Nueva Venta");
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        btnClient.setText("Clientes");
        btnClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientActionPerformed(evt);
            }
        });

        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prov.png"))); // NOI18N
        btnProveedor.setText("Proveedor");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product.png"))); // NOI18N
        btnProducts.setText("Productos");
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });

        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sells.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config.png"))); // NOI18N
        btnConfig.setText("Configuración");
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2.png"))); // NOI18N

        LabelSeller.setText("Laura Jacome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConfig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVentas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProducts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevaVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(LabelSeller)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaVenta)
                .addGap(18, 18, 18)
                .addComponent(btnClient)
                .addGap(18, 18, 18)
                .addComponent(btnProveedor)
                .addGap(18, 18, 18)
                .addComponent(btnProducts)
                .addGap(18, 18, 18)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(LabelSeller)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 460));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banner1.jpg"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 880, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Código");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Descripción");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Cantidad");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Precio");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Stock Disponible");

        btnElminateSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        btnElminateSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElminateSaleActionPerformed(evt);
            }
        });

        txtSalesCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSalesCodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalesCodeKeyTyped(evt);
            }
        });

        txtDescriptionSale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescriptionSaleKeyTyped(evt);
            }
        });

        txtQuantitySale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantitySaleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantitySaleKeyTyped(evt);
            }
        });

        txtSellingPrice.setEditable(false);

        txtStockAvailable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockAvailableKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("CI/RUC");

        txtRucSale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucSaleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucSaleKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("NOMBRE");

        txtCustomerName.setEditable(false);
        txtCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomerNameKeyTyped(evt);
            }
        });

        btnGenerateSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print.png"))); // NOI18N
        btnGenerateSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateSalesActionPerformed(evt);
            }
        });

        jLabel10.setText("Total a Pagar");

        txtLabelTotal.setText("----------");

        TableSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "DESCRIPCIÓN", "CANTIDAD", "PRECIO U.", "PRECIO TOTAL"
            }
        ));
        jScrollPane6.setViewportView(TableSales);
        if (TableSales.getColumnModel().getColumnCount() > 0) {
            TableSales.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableSales.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableSales.getColumnModel().getColumn(2).setPreferredWidth(40);
            TableSales.getColumnModel().getColumn(3).setPreferredWidth(40);
            TableSales.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtSalesCode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescriptionSale, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtQuantitySale, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtStockAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnElminateSale, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtRucSale, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(txtCellphoneCusS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(txtAddressCusS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, Short.MAX_VALUE)
                        .addComponent(btnGenerateSales)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLabelTotal)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 98, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStockAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantitySale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalesCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescriptionSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnElminateSale, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtLabelTotal))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerateSales)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRucSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCellphoneCusS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddressCusS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Nueva Venta", jPanel2);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("CI/RUC:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Nombre:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Télefono:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Dirección:");

        txtCustomerCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomerCIKeyTyped(evt);
            }
        });

        txtNameCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameCustomerKeyTyped(evt);
            }
        });

        txtCustomerCellphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomerCellphoneKeyTyped(evt);
            }
        });

        txtCustomerAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomerAddressKeyTyped(evt);
            }
        });

        TableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "CI/RUC", "NOMBRE", "TÉLEFONO", "DIRECCIÓN"
            }
        ));
        TableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCustomerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableCustomer);
        if (TableCustomer.getColumnModel().getColumnCount() > 0) {
            TableCustomer.getColumnModel().getColumn(0).setPreferredWidth(30);
            TableCustomer.getColumnModel().getColumn(1).setPreferredWidth(60);
            TableCustomer.getColumnModel().getColumn(2).setPreferredWidth(120);
            TableCustomer.getColumnModel().getColumn(3).setPreferredWidth(50);
            TableCustomer.getColumnModel().getColumn(4).setPreferredWidth(90);
        }

        btnSaveCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnSaveCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCustomerActionPerformed(evt);
            }
        });

        btnUpdateCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        btnUpdateCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });

        btnDeleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnDeleteCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        btnCreateCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create.png"))); // NOI18N
        btnCreateCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCustomerActionPerformed(evt);
            }
        });

        txtIdCustomer.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(34, 34, 34)
                        .addComponent(txtCustomerCI, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNameCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtCustomerCellphone)
                            .addComponent(txtCustomerAddress)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnSaveCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCustomerCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtCustomerCellphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(btnSaveCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Clientes", jPanel3);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("CI/RUC:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Nombre:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Télefono:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Dirección:");

        txtRucSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucSupplierKeyTyped(evt);
            }
        });

        txtNameSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameSupplierKeyTyped(evt);
            }
        });

        txtCellphoneSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCellphoneSupplierKeyTyped(evt);
            }
        });

        txtAddressSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressSupplierKeyTyped(evt);
            }
        });

        TableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CI/RUC", "NOMBRE", "TÉLEFONO", "DIRECCIÓN"
            }
        ));
        TableSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSupplierMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableSupplier);
        if (TableSupplier.getColumnModel().getColumnCount() > 0) {
            TableSupplier.getColumnModel().getColumn(0).setPreferredWidth(30);
            TableSupplier.getColumnModel().getColumn(1).setPreferredWidth(50);
            TableSupplier.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableSupplier.getColumnModel().getColumn(3).setPreferredWidth(50);
            TableSupplier.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        btnSaveSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnSaveSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSupplierActionPerformed(evt);
            }
        });

        btnUpdateSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        btnUpdateSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSupplierActionPerformed(evt);
            }
        });

        btnDeletSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnDeletSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletSupplierActionPerformed(evt);
            }
        });

        btnCreateSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create.png"))); // NOI18N
        btnCreateSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateSupplierActionPerformed(evt);
            }
        });

        txtIdSupplier.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnSaveSupplier)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(29, 29, 29))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(27, 27, 27)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addGap(23, 23, 23)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(37, 37, 37)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtRucSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtAddressSupplier)
                                .addComponent(txtCellphoneSupplier)
                                .addComponent(txtNameSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtRucSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNameSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtCellphoneSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtAddressSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSaveSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreateSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Proveedor", jPanel4);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Código:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Descripción:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Cantidad:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Precio:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Proveedor:");

        txtCodePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeProKeyTyped(evt);
            }
        });

        txtDesPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesProActionPerformed(evt);
            }
        });
        txtDesPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDesProKeyTyped(evt);
            }
        });

        txtQuantityPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityProKeyTyped(evt);
            }
        });

        txtPricePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceProKeyTyped(evt);
            }
        });

        cbxSupplierPro.setEditable(true);
        cbxSupplierPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSupplierProActionPerformed(evt);
            }
        });
        cbxSupplierPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbxSupplierProKeyTyped(evt);
            }
        });

        TableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CÓDIGO", "DESCRIPCIÓN", "PROVEEDOR", "STOCK", "PRECIO"
            }
        ));
        TableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableProduct);
        if (TableProduct.getColumnModel().getColumnCount() > 0) {
            TableProduct.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableProduct.getColumnModel().getColumn(1).setPreferredWidth(50);
            TableProduct.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableProduct.getColumnModel().getColumn(3).setPreferredWidth(60);
            TableProduct.getColumnModel().getColumn(4).setPreferredWidth(40);
            TableProduct.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        btnSavePro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnSavePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProActionPerformed(evt);
            }
        });

        btnUpdatePro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        btnUpdatePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProActionPerformed(evt);
            }
        });

        btnCreatePro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create.png"))); // NOI18N

        btnDeletePro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnDeletePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProActionPerformed(evt);
            }
        });

        btnJsonPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/json.png"))); // NOI18N
        btnJsonPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJsonProActionPerformed(evt);
            }
        });

        txtIdPro.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnSavePro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdatePro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreatePro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletePro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnJsonPro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxSupplierPro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPricePro, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantityPro, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(txtCodePro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtDesPro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(txtDesPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(jLabel24)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel25))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCodePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79)
                                .addComponent(txtQuantityPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtPricePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(cbxSupplierPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnJsonPro, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(btnDeletePro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreatePro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdatePro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSavePro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(58, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Productos", jPanel5);

        TableSales2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "VENDEDOR", "TOTAL"
            }
        ));
        TableSales2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSales2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TableSales2);
        if (TableSales2.getColumnModel().getColumnCount() > 0) {
            TableSales2.getColumnModel().getColumn(0).setPreferredWidth(10);
            TableSales2.getColumnModel().getColumn(1).setPreferredWidth(80);
            TableSales2.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableSales2.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        btnPdfSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pdf.png"))); // NOI18N
        btnPdfSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnPdfSales, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdSales, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPdfSales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdSales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ventas", jPanel6);

        jLabel27.setText("CI/RUC");

        txtRucConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucConfigKeyTyped(evt);
            }
        });

        jLabel28.setText("NOMBRE");

        txtNameConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameConfigKeyTyped(evt);
            }
        });

        jLabel29.setText("DIRECCIÓN");

        txtAddressConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressConfigKeyTyped(evt);
            }
        });

        jLabel30.setText("RAZON SOCIAL");

        txtRazonConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonConfigKeyTyped(evt);
            }
        });

        jLabel31.setText("TELÉFONO");

        txtCellphoneConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCellphoneConfigKeyTyped(evt);
            }
        });

        btnUpdateConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        btnUpdateConfig.setText("ACTUALIZAR");
        btnUpdateConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateConfigActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel32.setText("DATOS DE LA EMPRESA");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdateConfig)
                        .addGap(351, 351, 351))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(txtRucConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(txtAddressConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(txtRazonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(txtNameConfig, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addGap(162, 162, 162))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCellphoneConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addGap(34, 34, 34))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtIdConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCellphoneConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRucConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRazonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAddressConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnUpdateConfig)
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Configuración", jPanel7);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 890, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSupplierActionPerformed
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
                CleanTable();
                ListSupplier();
                cleanSupplier();
            }
        }
    }//GEN-LAST:event_btnUpdateSupplierActionPerformed

    private void txtDesProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesProActionPerformed

    private void btnSaveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCustomerActionPerformed
        if(!"".equals(txtCustomerCI.getText()) || !"".equals(txtNameCustomer.getText()) || !"".equals(txtCustomerCellphone.getText()) || !"".equals(txtCustomerAddress.getText())){
          cl.setCi(Integer.parseInt(txtCustomerCI.getText()));
          cl.setName(txtNameCustomer.getText()); 
          cl.setCellphone(txtCustomerCellphone.getText());
          cl.setAddress(txtCustomerAddress.getText());
          customer.registerCustomer(cl);
          JOptionPane.showMessageDialog(null,"Cliente Registrado.");
          CleanTable();
          cleanCustomer();
          ListCustomer();
        }else{
            JOptionPane.showMessageDialog(null,"Los campos estan vacios");
        }
    }//GEN-LAST:event_btnSaveCustomerActionPerformed

    private void btnClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientActionPerformed
        CleanTable();
        ListCustomer();
        jTabbedPane1.setSelectedIndex(1);
        
    }//GEN-LAST:event_btnClientActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        CleanTable();
        ListSupplier();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void TableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCustomerMouseClicked
        int fila = TableCustomer.rowAtPoint(evt.getPoint());
        txtIdCustomer.setText(TableCustomer.getValueAt(fila, 0).toString());
        txtCustomerCI.setText(TableCustomer.getValueAt(fila, 1).toString());
        txtNameCustomer.setText(TableCustomer.getValueAt(fila, 2).toString());
        txtCustomerCellphone.setText(TableCustomer.getValueAt(fila,3).toString());
        txtCustomerAddress.setText(TableCustomer.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_TableCustomerMouseClicked

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        if (!"".equals(txtIdCustomer.getText())) {
            int question = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?");
            if (question == 0) {
                String id = txtIdCustomer.getText();
                
                try {
                    ObjectId objectId = new ObjectId(id);

                    if (customer.deleteCustomer(objectId)) {
                        JOptionPane.showMessageDialog(null, "Cliente Eliminado.");
                        CleanTable();
                        cleanCustomer();
                        ListCustomer();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el cliente.");
                    }
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "ID de cliente no válido.");
                }
            }
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed
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
                CleanTable();
                cleanCustomer();
                ListCustomer();
            }else{
                JOptionPane.showMessageDialog(null,"Los campos estan Vacios");
            }
            
        }
    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    private void btnCreateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCustomerActionPerformed
        cleanCustomer();
    }//GEN-LAST:event_btnCreateCustomerActionPerformed

    private void btnSaveSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSupplierActionPerformed
        if(!"".equals(txtRucSupplier.getText()) || !"".equals(txtNameSupplier.getText()) || !"".equals(txtCellphoneSupplier.getText()) || !"".equals(txtAddressSupplier.getText())){
           sp.setRuc(Integer.parseInt(txtRucSupplier.getText()));
           sp.setName(txtNameSupplier.getText());
           sp.setCellphone(txtCellphoneSupplier.getText());
           sp.setAddress(txtAddressSupplier.getText());
           prDao.registerProvider(sp);
           JOptionPane.showMessageDialog(null,"Proveedor Registrado.");
           CleanTable();
           ListSupplier();
           cleanSupplier();
        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnSaveSupplierActionPerformed

    private void TableSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSupplierMouseClicked
        int fila = TableSupplier.rowAtPoint(evt.getPoint());
        txtIdSupplier.setText(TableSupplier.getValueAt(fila,0).toString());
        txtRucSupplier.setText(TableSupplier.getValueAt(fila,1).toString());
        txtNameSupplier.setText(TableSupplier.getValueAt(fila, 2).toString());
        txtCellphoneSupplier.setText(TableSupplier.getValueAt(fila,3).toString());
        txtAddressSupplier.setText(TableSupplier.getValueAt(fila, 4).toString());
        
    }//GEN-LAST:event_TableSupplierMouseClicked

    private void btnDeletSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletSupplierActionPerformed
        if (!"".equals(txtIdSupplier.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar");
            if (pregunta == 0){
                ObjectId id = new ObjectId(txtIdSupplier.getText());
                prDao.deleteProvider(id);
                JOptionPane.showMessageDialog(null, "Proveedor Eliminado.");
                CleanTable();
                ListSupplier();
                cleanSupplier();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una Fila.");
        }
    }//GEN-LAST:event_btnDeletSupplierActionPerformed

    private void btnCreateSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateSupplierActionPerformed
        cleanSupplier();
    }//GEN-LAST:event_btnCreateSupplierActionPerformed

    private void btnSaveProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProActionPerformed
        if(!"".equals(txtCodePro.getText()) || !"".equals(txtDesPro.getText()) || !"".equals(cbxSupplierPro.getSelectedItem()) || !"".equals(txtQuantityPro.getText()) || !"".equals(txtPricePro.getText())){
            pro.setCode(txtCodePro.getText());
            pro.setName(txtDesPro.getText());
            pro.setSupplier(cbxSupplierPro.getSelectedItem().toString());
            pro.setStock(Integer.parseInt(txtQuantityPro.getText()));
            pro.setPrice(Double.parseDouble(txtPricePro.getText()));
            proDao.registerProduct(pro);
            JOptionPane.showMessageDialog(null, "Productos Registrados");
            CleanTable();
            ListProducts();
            cleanProducts();
        }else{
            JOptionPane.showMessageDialog(null,"Los campos estan vacios");
        }
    }//GEN-LAST:event_btnSaveProActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsActionPerformed
        CleanTable();
        ListProducts();
        jTabbedPane1.setSelectedIndex(3);
        
    }//GEN-LAST:event_btnProductsActionPerformed

    private void TableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductMouseClicked
        int fila = TableProduct.rowAtPoint(evt.getPoint());
        int row = TableProduct.getSelectedRow();
        if (row >= 0) {
            String id = TableProduct.getValueAt(row, 0).toString();
            String codigo = TableProduct.getValueAt(row, 1).toString();
            String nombre = TableProduct.getValueAt(row, 2).toString();
            String proveedor = TableProduct.getValueAt(row, 3).toString();
            String stock = TableProduct.getValueAt(row, 4).toString();
            String precio = TableProduct.getValueAt(row, 5).toString();

            txtIdPro.setText(TableProduct.getValueAt(fila,0).toString());
            txtCodePro.setText(TableProduct.getValueAt(fila,1).toString());
            txtDesPro.setText(TableProduct.getValueAt(fila, 2).toString());
            cbxSupplierPro.setSelectedItem(TableProduct.getValueAt(fila,3).toString());
            txtQuantityPro.setText(TableProduct.getValueAt(fila, 4).toString());
            txtPricePro.setText(TableProduct.getValueAt(fila, 5).toString());
        }
    }//GEN-LAST:event_TableProductMouseClicked

    private void btnDeleteProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProActionPerformed
        if(!"".equals(txtIdPro.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null,"Estas seguro de eliminar");
            if(pregunta == 0){
                ObjectId id = new ObjectId(txtIdPro.getText());
                proDao.deleteProduct(id);
                JOptionPane.showMessageDialog(null,"Producto Eliminado.");
                CleanTable();
                ListProducts();
                cleanProducts();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una Fila.");
        }
    }//GEN-LAST:event_btnDeleteProActionPerformed

    private void cbxSupplierProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSupplierProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSupplierProActionPerformed

    private void btnUpdateProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProActionPerformed
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
                CleanTable();
                ListProducts();
                cleanProducts();
            }
        } 
    }//GEN-LAST:event_btnUpdateProActionPerformed

    private void btnJsonProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJsonProActionPerformed
       ReportExcel.report();
    }//GEN-LAST:event_btnJsonProActionPerformed

    private void btnGenerateSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateSalesActionPerformed
        if(TableSales.getRowCount() > 0 ){
            if(!"".equals(txtCustomerName.getText())){
                registerSale();
                registerDetail();
                updateStock();
                generatePDF();
                cleanTableSale();
                cleanCustomerSale();
            }else{
                JOptionPane.showMessageDialog(null, "Debe buscar un Cliente.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay productos seleccionados para vender.");
        }

    }//GEN-LAST:event_btnGenerateSalesActionPerformed

    private void txtSalesCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalesCodeKeyPressed
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
                   cleanSales();
                   txtSalesCode.requestFocus(); 
                }
            }else{
                JOptionPane.showMessageDialog(null,"Ingrese el Codigo del Producto.");
                txtSalesCode.requestFocus();
            }
        }
    }//GEN-LAST:event_txtSalesCodeKeyPressed

    private void txtQuantitySaleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantitySaleKeyPressed
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
                    totalPay();
                    cleanSales();
                    txtSalesCode.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Stock no Disponible.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad.");
            }
        }
    }//GEN-LAST:event_txtQuantitySaleKeyPressed

    private void btnElminateSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElminateSaleActionPerformed
        modelo = (DefaultTableModel) TableSales.getModel();
        modelo.removeRow(TableSales.getSelectedRow());
        totalPay();
        txtSalesCode.requestFocus();
    }//GEN-LAST:event_btnElminateSaleActionPerformed

    private void txtRucSaleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucSaleKeyPressed
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
    }//GEN-LAST:event_txtRucSaleKeyPressed

    private void txtSalesCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalesCodeKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtSalesCodeKeyTyped

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void txtDescriptionSaleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionSaleKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtDescriptionSaleKeyTyped

    private void txtQuantitySaleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantitySaleKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtQuantitySaleKeyTyped

    private void txtRucSaleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucSaleKeyTyped
                event.numberKeyPress(evt);
    }//GEN-LAST:event_txtRucSaleKeyTyped

    private void txtCustomerNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerNameKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtCustomerNameKeyTyped
/**/
    private void txtCustomerCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerCIKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCustomerCIKeyTyped

    private void txtNameCustomerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameCustomerKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtNameCustomerKeyTyped

    private void txtCustomerCellphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerCellphoneKeyTyped
               event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCustomerCellphoneKeyTyped

    private void txtCustomerAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerAddressKeyTyped
        event.textKeyPress(evt);

    }//GEN-LAST:event_txtCustomerAddressKeyTyped

    private void txtRucSupplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucSupplierKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtRucSupplierKeyTyped

    private void txtCellphoneSupplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCellphoneSupplierKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCellphoneSupplierKeyTyped

    private void txtCodeProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeProKeyTyped
        event.numberKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeProKeyTyped

    private void txtQuantityProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityProKeyTyped
        event.numberKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityProKeyTyped

    private void txtPriceProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceProKeyTyped
        event.numberKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceProKeyTyped

    private void txtNameSupplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameSupplierKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtNameSupplierKeyTyped

    private void txtAddressSupplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressSupplierKeyTyped
        event.textKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressSupplierKeyTyped

    private void txtDesProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDesProKeyTyped
        event.textKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesProKeyTyped

    private void cbxSupplierProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxSupplierProKeyTyped
        event.textKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSupplierProKeyTyped

    private void txtRucConfigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucConfigKeyTyped
        event.textKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucConfigKeyTyped

    private void txtNameConfigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameConfigKeyTyped
        event.textKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameConfigKeyTyped

    private void txtAddressConfigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressConfigKeyTyped
        event.textKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressConfigKeyTyped

    private void txtCellphoneConfigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCellphoneConfigKeyTyped
        event.numberKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCellphoneConfigKeyTyped

    private void txtRazonConfigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonConfigKeyTyped
        event.textKeyPress(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonConfigKeyTyped

    private void btnUpdateConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateConfigActionPerformed
        JOptionPane.showMessageDialog(null,"EN DESARROLLO");
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateConfigActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        CleanTable();
        ListSales();
    }//GEN-LAST:event_btnVentasActionPerformed

    private void txtStockAvailableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockAvailableKeyTyped
               event.numberKeyPress(evt);
    }//GEN-LAST:event_txtStockAvailableKeyTyped

    private void TableSales2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSales2MouseClicked
        int fila = TableSales2.rowAtPoint(evt.getPoint());
        txtIdSales.setText(TableSales2.getValueAt(fila, 0).toString());
        
    }//GEN-LAST:event_TableSales2MouseClicked

    private void btnPdfSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfSalesActionPerformed
        try{
            ObjectId _id = sdb.getIdSale();
            File file = new File("src\\main\\java\\ec\\edu\\espe\\thefamse\\utils\\ventas"+_id+".pdf");
            Desktop.getDesktop().open(file);
        }catch(IOException ex){
            Logger.getLogger(FrmSystem.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
    }//GEN-LAST:event_btnPdfSalesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSeller;
    private javax.swing.JTable TableCustomer;
    private javax.swing.JTable TableProduct;
    private javax.swing.JTable TableSale;
    private javax.swing.JTable TableSales;
    private javax.swing.JTable TableSales2;
    private javax.swing.JTable TableSupplier;
    private javax.swing.JButton btnClient;
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnCreateCustomer;
    private javax.swing.JButton btnCreatePro;
    private javax.swing.JButton btnCreateSupplier;
    private javax.swing.JButton btnDeletSupplier;
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnDeletePro;
    private javax.swing.JButton btnElminateSale;
    private javax.swing.JButton btnGenerateSales;
    private javax.swing.JButton btnJsonPro;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnPdfSales;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnSaveCustomer;
    private javax.swing.JButton btnSavePro;
    private javax.swing.JButton btnSaveSupplier;
    private javax.swing.JButton btnUpdateConfig;
    private javax.swing.JButton btnUpdateCustomer;
    private javax.swing.JButton btnUpdatePro;
    private javax.swing.JButton btnUpdateSupplier;
    private javax.swing.JButton btnVentas;
    private javax.swing.JComboBox<String> cbxSupplierPro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtAddressConfig;
    private javax.swing.JTextField txtAddressCusS;
    private javax.swing.JTextField txtAddressSupplier;
    private javax.swing.JTextField txtCellphoneConfig;
    private javax.swing.JTextField txtCellphoneCusS;
    private javax.swing.JTextField txtCellphoneSupplier;
    private javax.swing.JTextField txtCodePro;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerCI;
    private javax.swing.JTextField txtCustomerCellphone;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtDesPro;
    private javax.swing.JTextField txtDescriptionSale;
    private javax.swing.JTextField txtIdConfig;
    private javax.swing.JTextField txtIdCustomer;
    private javax.swing.JTextField txtIdPro;
    private javax.swing.JTextField txtIdProduct;
    private javax.swing.JTextField txtIdSales;
    private javax.swing.JTextField txtIdSupplier;
    private javax.swing.JLabel txtLabelTotal;
    private javax.swing.JTextField txtNameConfig;
    private javax.swing.JTextField txtNameCustomer;
    private javax.swing.JTextField txtNameSupplier;
    private javax.swing.JTextField txtPricePro;
    private javax.swing.JTextField txtQuantityPro;
    private javax.swing.JTextField txtQuantitySale;
    private javax.swing.JTextField txtRazonConfig;
    private javax.swing.JTextField txtRucConfig;
    private javax.swing.JTextField txtRucSale;
    private javax.swing.JTextField txtRucSupplier;
    private javax.swing.JTextField txtSalesCode;
    private javax.swing.JTextField txtSellingPrice;
    private javax.swing.JTextField txtStockAvailable;
    // End of variables declaration//GEN-END:variables
    
    private void cleanCustomer(){
        txtIdCustomer.setText("");
        txtCustomerCI.setText("");
        txtNameCustomer.setText("");
        txtCustomerCellphone.setText("");
        txtCustomerAddress.setText("");
    }
    
    private void cleanSupplier(){
        txtIdSupplier.setText("");
        txtRucSupplier.setText("");
        txtNameSupplier.setText("");
        txtCellphoneSupplier.setText("");
        txtAddressSupplier.setText("");
    }
    
    private void cleanProducts(){
        txtIdPro.setText("");
        txtCodePro.setText("");
        cbxSupplierPro.setSelectedItem(null);
        txtDesPro.setText("");
        txtQuantityPro.setText("");
        txtPricePro.setText("");
    }
    
    private void totalPay(){
        totalPay = 0.00;
        int numFila = TableSales.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(TableSales.getModel().getValueAt(i, 4)));
            totalPay = totalPay + cal;
        }
        txtLabelTotal.setText(String.format("%.2f", totalPay));
    }
    
    private void cleanSales(){
        txtSalesCode.setText("");
        txtDescriptionSale.setText("");
        txtQuantitySale.setText("");
        txtStockAvailable.setText("");
        txtSellingPrice.setText("");
        txtIdSales.setText("");
    }
    
    private void registerSale(){
        String customer = txtCustomerName.getText();
        String seller = LabelSeller.getText();
        double amount = totalPay;
        s.setCustomer(customer);
        s.setSeller(seller);
        s.setTotal(totalPay);
        sdb.registerSale(s);
    }
    
    private void registerDetail(){
        ObjectId _id = sdb.getIdSale();
        for (int i = 0; i < TableSales.getRowCount() ; i++) {
            String cod = TableSales.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(TableSales.getValueAt(i, 2).toString());
            double price = Double.parseDouble(TableSales.getValueAt(i, 3).toString());
            di.setCod_pro(cod);
            di.setQuantity(cant);
            di.setPrice(price);
            di.setId(_id);
            sdb.registerDetail(di);
            
        }
    }
    
    private void updateStock(){
        for (int i = 0; i < TableSales.getRowCount(); i++) {
            String cod = TableSales.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(TableSales.getValueAt(i, 2).toString());
            pro = proDao.findProductByCode(cod);
            int stockCurrent = pro.getStock()- cant;
            sdb.updateStock(stockCurrent, cod);
        }
    }
    
    private void cleanTableSale(){
        tmp = (DefaultTableModel) TableSales.getModel();
        int fila = TableSales.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }
    
    private void cleanCustomerSale(){
        txtRucSale.setText("");
        txtCustomerName.setText("");
    }
    
    private void generatePDF(){
        try {
            ObjectId _id = sdb.getIdSale();
            FileOutputStream archivo;
            File file = new File("src\\main\\java\\ec\\edu\\espe\\thefamse\\utils\\ventas"+_id+".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc,archivo);  
            doc.open();
            Image img = Image.getInstance("src\\main\\resources\\1am.png");
            
            Paragraph date = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK);
            date.add(Chunk.NEWLINE);
            Date date1 = new Date();
            date.add("Factura:"+_id+"\n" + "Fecha: "+ new SimpleDateFormat("dd-mm-yyyy").format(date1)+"\n\n"); 
            
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{20f,30f,70f,40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            Encabezado.addCell(img);
            
            String  ruc = txtRucConfig.getText();
            String name = txtNameConfig.getText();
            String cell = txtCellphoneConfig.getText();
            String address = txtAddressConfig.getText();
            String razon = txtRazonConfig.getText();
            
            Encabezado.addCell("");
            Encabezado.addCell("Ruc: " +ruc+ "\nNombre: " +name+ "\nTelefono: " +cell+ "\nDirección: " +address+ "\nRazon: " +razon);
            Encabezado.addCell(date);
            doc.add(Encabezado);
            
            Paragraph cus = new Paragraph();
            cus.add(Chunk.NEWLINE);
            cus.add("Datos de los Clientes" + "\n\n");
            doc.add(cus);
            
            PdfPTable tablecus = new PdfPTable(4);
            tablecus.setWidthPercentage(100);
            tablecus.getDefaultCell().setBorder(0);
            float[] ColumnaCus = new float[]{20f,50f,30f,40f};
            tablecus.setWidths(ColumnaCus);
            tablecus.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cus1 = new PdfPCell(new Phrase("Ci/Ruc: ", negrita));
            PdfPCell cus2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cus3 = new PdfPCell(new Phrase("Telefono: ", negrita));
            PdfPCell cus4 = new PdfPCell(new Phrase("Dirección: ", negrita));
            cus1.setBorder(0);
            cus2.setBorder(0);
            cus3.setBorder(0);
            cus4.setBorder(0);
            tablecus.addCell(cus1);
            tablecus.addCell(cus2);
            tablecus.addCell(cus3);
            tablecus.addCell(cus4);
            tablecus.addCell(txtRucSale.getText());
            tablecus.addCell(txtCustomerName.getText());
            tablecus.addCell(txtCellphoneCusS.getText());
            tablecus.addCell(txtAddressCusS.getText());

            doc.add(tablecus);
            
            //Productos
            PdfPTable tablepro = new PdfPTable(4);
            tablepro.setWidthPercentage(100);
            tablepro.getDefaultCell().setBorder(0);
            float[] ColumnaPro = new float[]{20f,50f,15f,20f};
            tablepro.setWidths(ColumnaPro);
            tablepro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell pro2 = new PdfPCell(new Phrase("Descripción: ", negrita));
            PdfPCell pro3 = new PdfPCell(new Phrase("Precio U: ", negrita));
            PdfPCell pro4 = new PdfPCell(new Phrase("Precio T: ", negrita));
            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);
            pro1.setBackgroundColor(BaseColor.DARK_GRAY);
            pro2.setBackgroundColor(BaseColor.DARK_GRAY);
            pro3.setBackgroundColor(BaseColor.DARK_GRAY);
            pro4.setBackgroundColor(BaseColor.DARK_GRAY);

            tablepro.addCell(pro1);
            tablepro.addCell(pro2);
            tablepro.addCell(pro3);
            tablepro.addCell(pro4);
            for (int i = 0; i < TableSales.getRowCount(); i++) {
                String product  = TableSales.getValueAt(i, 1).toString();
                String cant  = TableSales.getValueAt(i, 2).toString();
                String price  = TableSales.getValueAt(i, 3).toString();
                String total  = TableSales.getValueAt(i, 4).toString();
                
                tablepro.addCell(cant);
                tablepro.addCell(product);
                tablepro.addCell(price);
                tablepro.addCell(total);
            }

            doc.add(tablepro);

            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a Pagar: " + totalPay);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            Paragraph signature = new Paragraph();
            signature.add(Chunk.NEWLINE);
            signature.add("Cancelación y Firma\n\n");
            signature.add("------------------------");
            signature.setAlignment(Element.ALIGN_CENTER);
            doc.add(signature);
            
            Paragraph message = new Paragraph();
            message.add(Chunk.NEWLINE);
            message.add("Gracias por su Compra\n\n");
            message.setAlignment(Element.ALIGN_CENTER);
            doc.add(message);
            
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.out.println(e.toString());
        }
    }
}
