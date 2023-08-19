package ec.edu.espe.thefamse.utils;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author Anthony Morales, The_FAMSE
 */
public class ReportExcel {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public ReportExcel() {
        try {
            String username = "anthonymorales"; 
            String password = "anthonymorales"; 
            String databaseName = "NuttyPickUp";

            String uri = "mongodb+srv://" + username + ":" + password + "@cluster0.nngqbpt.mongodb.net/" + databaseName + "?retryWrites=true&w=majority";

            mongoClient = MongoClients.create(uri);
            database = mongoClient.getDatabase(databaseName);
            collection = database.getCollection("Products");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateReport() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Productos");

        try {
            InputStream is = new FileInputStream("C:\\Users\\ANTHONY\\Desktop\\NuttyPickUp\\src\\main\\resources\\1am.png");
            byte[] imageBytes = IOUtils.toByteArray(is);
            int pictureIdx = workbook.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);
            is.close();

            CreationHelper helper = workbook.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture picture = drawing.createPicture(anchor, pictureIdx);
            picture.resize(1, 3);

            CellStyle titleStyle = workbook.createCellStyle();
            titleStyle.setAlignment(HorizontalAlignment.CENTER);
            titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            Font titleFont = workbook.createFont();
            titleFont.setFontName("Arial");
            titleFont.setBold(true);
            titleFont.setFontHeightInPoints((short) 12);
            titleStyle.setFont(titleFont);

            Row titleRow = sheet.createRow(1);
            Cell titleCell = titleRow.createCell(1);
            titleCell.setCellStyle(titleStyle);
            titleCell.setCellValue("Reporte de Productos");

            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));

            String[] headers = new String[]{"Código", "Producto", "Precio", "Stock"};

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderTop(BorderStyle.THIN);
            Font headerFont = workbook.createFont();
            headerFont.setFontName("Arial");
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.WHITE.getIndex());
            headerFont.setFontHeightInPoints((short) 12);
            headerStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(4);

            for (int i = 0; i < headers.length; i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellStyle(headerStyle);
                headerCell.setCellValue(headers[i]);
            }

            FindIterable<Document> documents = collection.find();

            int dataRowNum = 5;

            CellStyle dataStyle = workbook.createCellStyle();
            dataStyle.setBorderBottom(BorderStyle.THIN);
            dataStyle.setBorderLeft(BorderStyle.THIN);
            dataStyle.setBorderRight(BorderStyle.THIN);
            dataStyle.setBorderTop(BorderStyle.THIN);

            for (Document document : documents) {

                Row dataRow = sheet.createRow(dataRowNum);
                dataRow.createCell(0).setCellValue(document.getString("codigo"));
                dataRow.createCell(1).setCellValue(document.getString("name"));
                dataRow.createCell(2).setCellValue(document.getDouble("price"));
                dataRow.createCell(3).setCellValue(document.getInteger("stock"));

                for (int i = 0; i < headers.length; i++) {
                    Cell dataCell = dataRow.getCell(i);
                    dataCell.setCellStyle(dataStyle);
                }

                dataRowNum++;
            }

            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            sheet.setZoom(150);

            String fileName = "Productos";
            String home = System.getProperty("user.home");
            File file = new File(home + "/Downloads/" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            workbook.write(fileOut);
            fileOut.close();
            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, "Reporte Generado");

        } catch (IOException ex) {
            Logger.getLogger(ReportExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void report(){
        ReportExcel report = new ReportExcel();
        report.generateReport();
    }

}
