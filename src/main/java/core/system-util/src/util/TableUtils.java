package util;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Provides utility methods for working with tables.
 */
public class TableUtils {

    /**
     * Prints the content of the specified table.
     *
     * @param table the table to print
     */
    public static void printTable(JTable table) {
        try {
            // Show print dialog
            if (!table.print()) {
                JOptionPane.showMessageDialog(null, "Printing cancelled by user.", "Printing", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(null, "Error printing: " + e.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error printing: " + e);
        }
    }

    /**
     * Saves the content of the specified table to a PDF file.
     *
     * @param table    the table to save
     * @param filePath the path of the PDF file to save
     */
    public static void saveTableToPDF(JTable table, String filePath) {
        Document document = new Document(PageSize.A4.rotate());

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Add table content to PDF
            TableModel model = table.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Object cellValue = model.getValueAt(i, j);
                    String cellText = (cellValue != null) ? cellValue.toString() : ""; // Handle null cell values
                    document.add(new Paragraph(cellText));
                }
                document.add(new Paragraph("\n"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving to PDF: " + e.getMessage(), "PDF Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error saving to PDF: " + e);
        } finally {
            document.close();
        }
    }

    /**
     * Opens the specified PDF file using the default PDF viewer.
     *
     * @param filePath the path of the PDF file to open
     */
    public static void viewPDF(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "PDF file not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Open the PDF file with the default PDF viewer
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error opening PDF file.", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error opening PDF file: " + e);
        }
    }
}
