package com.mmdc_group10_oop.service.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.jetbrains.annotations.NotNull;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to handle data operations for CSV files.
 * It includes methods to find, retrieve, create, update, and delete data from CSV files.
 * Available methods:
 * <ul>
 *     <li>{@link DataHandler#findAttributeIndex(String)}</li>
 *     <li>{@link DataHandler#findDataIndex(String, String)} </li>
 *     <li>{@link DataHandler#retrieveSingleData(String, String, String)}  </li>
 *     <li>{@link DataHandler#retrieveDataInt(String, String, String)}  </li>
 *     <li>{@link DataHandler#retrieveDataDouble(String, String, String)} </li>
 *     <li>{@link DataHandler#updateData(String, String, String, String)}</li>
 *     <li>{@link DataHandler#retrieveMultipleData(String, String)} </li>
 *     <li>{@link DataHandler#retrieveAllData()}  </li>
 *     <li>{@link DataHandler#retrieveRowData(String, String)}</li>
 * </ul>
 * @author Harvey Dela Flor
 */
final public class DataHandler {
    private final String filePath;

    /**
     * Creates a new DataHandler object, given the database path.
     * @param filePath The path to the directory where CSV files are stored.
     */
    public DataHandler(@NotNull String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method searches for a specific attribute (header) in a CSV file.
     *
     * @param attribute The attribute to search for, for example: "First Name".
     * @return The index of the attribute if found, or -1 if not found.
     * @throws IOException If an I/O error occurs while reading the CSV file.
     * @throws CsvValidationException If a CSV validation error occurs.
     * Example:
     * <pre>{@code
     * DataHandler dataHandler = new DataHandler("path/to/csv");
     * int index = dataHandler.findAttributeIndex("First Name");
     * }</pre>
     */
    public int findAttributeIndex(@NotNull String attribute) throws IOException, CsvValidationException {
        // Open the CSV file for reading
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the headers from the CSV file
            String[] headers = reader.readNext();
            // Throw an exception if the file is empty or invalid
            if (headers == null) {
                throw new IOException("Empty or invalid CSV file: " + filePath);
            }

            // Iterate through the headers to find the index of the specified attribute
            for (int columnIndex = 0; columnIndex < headers.length; columnIndex++) {
                if (headers[columnIndex].equals(attribute)) {
                    return columnIndex; // Return the index if the attribute is found
                }
            }
            return -1; // Return -1 if the attribute is not found
        }
    }

    /**
     * This method searches for a specific data's index in a CSV file.
     *
     * @param dataName The name of the data to search for, for example: "First Name".
     * @param dataValue The value of the data to search for, for example: "John".
     * @return The index of the data if found, or -1 if not found.
     * @throws IOException If an I/O error occurs while reading the CSV file.
     * @throws CsvValidationException If a CSV validation error occurs.
     * Example:
     * <pre>{@code
     * DataHandler dataHandler = new DataHandler("path/to/csv");
     * int index = dataHandler.findDataIndex("First Name", "John");
     * }</pre>
     */
    public int findDataIndex(String dataName, String dataValue) throws IOException, CsvValidationException {
        // Open the CSV file for reading
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            //
            reader.skip(0);

            // Read the rows from the CSV file
            String[] rows;
            while ((rows = reader.readNext()) != null) {

                // Find the index of the data
                int dataIndex = findAttributeIndex(dataName);

                if (rows[dataIndex].equals(dataValue)) {
                    return dataIndex;
                }
            }
            return -1; // Return -1 if the data is not found
        }
    }

    /**
     * Retrieve a single data value based on the given identifier and data name.
     *
     * @param  identifierName  The name of the identifier attribute (column header).
     * @param  identifier      The value of the identifier attribute to match.
     * @param  dataName        The name of the data attribute to retrieve.
     * @return                 the retrieved data value
     * @throws IOException If an I/O error occurs while reading the CSV file.
     * @throws CsvValidationException If a CSV validation error occurs.
     * Example:
     * <pre>{@code
     * DataHandler dataHandler = new DataHandler("path/to/csv");
     * String value = dataHandler.retrieveSingleData("Employee ID", "123", "First Name");
     * }</pre>
     */
    public String retrieveSingleData(@NotNull String identifierName, @NotNull String identifier, @NotNull String dataName) throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            int identifierIndex = findAttributeIndex(identifierName);
            int dataIndex = findAttributeIndex(dataName);

            if (identifierIndex == -1 || dataIndex == -1) {
                return null;
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                if (row.length > Math.max(identifierIndex, dataIndex) && row[identifierIndex].equals(identifier)) {
                    return row[dataIndex];
                }
            }
            return null;
        }
    }

    /**
     * Retrieve an integer data value based on the given identifier and data name.
     * @param  identifierName  The name of the identifier attribute (column header).
     * @param  identifier      The value of the identifier attribute to match.
     * @param  dataName        The name of the data attribute to retrieve.
     * @return                 the retrieved integer data value
     * @throws IOException If an I/O error occurs while reading the CSV file.
     * @throws CsvValidationException If a CSV validation error occurs.
     * Example:
     * <pre>{@code
     * DataHandler dataHandler = new DataHandler("path/to/csv");
     * String value = dataHandler.retrieveSingleData("Employee ID", "123", "Leave Balance");
     * }</pre>
     */
    public int retrieveDataInt(@NotNull String identifierName, @NotNull String identifier, @NotNull String dataName) throws IOException, CsvValidationException {
        String data = retrieveSingleData(identifierName, identifier, dataName);
        if (data == null || data.isEmpty()) {
            throw new IOException("No data found for the given identifier and data name");
        }
        return Integer.parseInt(data);
    }

    /**
     * Retrieve a double data value based on the given identifier and data name.
     * @param  identifierName  The name of the identifier attribute (column header).
     * @param  identifier      The value of the identifier attribute to match.
     * @param  dataName        The name of the data attribute to retrieve.
     * @return                 the retrieved double data value
     * @throws IOException If an I/O error occurs while reading the CSV file.
     * @throws CsvValidationException If a CSV validation error occurs.
     * Example:
     * <pre>{@code
     * DataHandler dataHandler = new DataHandler("path/to/csv");
     * String value = dataHandler.retrieveSingleData("Employee ID", "123", "Salary");
     * }</pre>
     */
    public double retrieveDataDouble(@NotNull String identifierName, @NotNull String identifier, @NotNull String dataName) throws IOException, CsvValidationException {
        String data = retrieveSingleData(identifierName, identifier, dataName);
        if (data == null || data.isEmpty()) {
            throw new IOException("No data found for the given identifier and data name");
        }

        // Parse strings with commas such as "1,000.00"
        DecimalFormat format = new DecimalFormat("#,##0.0#");
        format.setParseBigDecimal(true);
        try {
            return format.parse(data).doubleValue();
        } catch (ParseException e) {
            throw new IOException("Error parsing the data value");
        }
    }

    /**
     * Retrieves row data from the CSV file based on the provided data identifier and data name.
     *
     * @param identifierName The name of the identifier to search for, for example: "Employee ID".
     * @param identifier The value of the identifier to search for, for example: "123".
     * @return The retrieved data value, or null if not found.
     * @throws IOException If an I/O error occurs.
     * @throws CsvException If a CSV validation error occurs.
     */
    public List<String[]> retrieveRowData(String identifierName, String identifier) throws IOException, CsvException {
        // Create a list to store the data of the specified identifier
        List<String[]> dataList = new ArrayList<>();

        // Open the CSV file
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Create an array of String to store the data of each row
            String[] row;

            boolean found = false;
            // Read the CSV file line by line
            while ((row = reader.readNext()) != null && !found) {

                // Find the index of the identifier
                int identifierIndex = findAttributeIndex(identifierName);

                // If the identifier is found, add the row to the list
                if (identifierIndex != -1) {
                    if (row[identifierIndex].equals(identifier)) {
                        found = true;
                        dataList.add(row);
                    }
                } else {
                    reader.close();
                    return null;
                }
            }
        }

        return dataList;
    }

    /**
     * Retrieves multiple data rows from the CSV file based on the specified identifier.
     *
     * @param identifierName The name of the identifier attribute (column header).
     * @param identifier     The value of the identifier attribute to match.
     * @return A list of String arrays, each containing the data of the specified identifier.
     *         Returns null if the identifier is not found in the CSV file.
     * @throws IOException            If an I/O error occurs while reading the CSV file.
     * @throws CsvValidationException If a CSV validation error occurs.
     * Example:
     * <pre>{@code
     * List<String[]> data = retrieveMultipleData("EmployeeID", "12345");
     * }</pre>
     */
    List<String[]> retrieveMultipleData(String identifierName, String identifier) throws IOException, CsvException {
        // Create a list to store the data of the specified identifier
        List<String[]> dataOfSpecifiedIdentifier = new ArrayList<>();

        // Open the CSV file and read the data
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Create an array of String to store the data of each row
            String[] row;

            // Read the CSV file line by line
            while ((row = reader.readNext()) != null) {
                // Find the index of the identifier
                int identifierIndex = findAttributeIndex(identifierName);

                // If the identifier is found, add the row to the list
                if (identifierIndex != -1) {
                    if (row[identifierIndex].equals(identifier)) {
                        dataOfSpecifiedIdentifier.add(row);
                    }
                } else {
                    // If the identifier is not found, print a message, close the reader, and return null
                    System.out.println("Data not found");
                    reader.close();
                    return null;
                }
            }
        }

        return dataOfSpecifiedIdentifier;
    }

    /**
     * Retrieves all data from a CSV file.
     *
     * @return a list of string arrays containing the data
     * @throws IOException if an I/O error occurs
     * @throws CsvException if an error occurs while parsing the CSV file
     *
     */
    public List<String[]> retrieveAllData() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.close();
            return reader.readAll();
        }
    }

    /**
     * Update the specified data in the CSV file based on the provided data identifier name and value, and new data.
     *
     * @param identifierName The name of the identifier attribute (column header).
     * @param identifier The value of the identifier attribute to match.
     * @param dataName The name of the attribute to be updated.
     * @param newData The new data value to be written.
     * @throws IOException If an I/O error occurs while reading or writing to the CSV file.
     * @throws CsvValidationException If a CSV validation error occurs during the read operation.
     * Example:
     * <pre>{@code
     * DataHandler dataHandler = new DataHandler("path/to/csv");
     * dataHandler.updateData("Employee ID", "001", "First Name", "John");
     * }</pre>
     */
    public void updateData(@NotNull String identifierName, String identifier, String dataName, @NotNull String newData) throws IOException, CsvValidationException {
        // Create a list to store the updated rows from the CSV file
        List<String[]> updatedRows = new ArrayList<>();

        // Open a CSV reader to read from the file
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            // Read each row from the CSV file
            while ((row = reader.readNext()) != null) {
                // Find the index of the identifier attribute and the data attribute
                int identifierIndex = findAttributeIndex(identifierName);
                int dataIndex = findAttributeIndex(dataName);

                // Check if both the identifier and data attributes are found in the CSV file
                if (identifierIndex != -1 && dataIndex != -1) {
                    // If the current row's identifier matches the specified identifier, update the data
                    if (row[identifierIndex].equals(identifier)) {
                        row[dataIndex] = newData;
                    }
                } else {
                    // If either the identifier or data attribute is not found, print an error message and return
                    System.out.println("Data not found");
                    return;
                }

                // Add the updated row to the list of updated rows
                updatedRows.add(row);
            }
        }

        // Open a CSV writer to write to the file
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write all the updated rows to the CSV file
            writer.writeAll(updatedRows);
            System.out.println("Data updated successfully!!!");
        } catch (IOException e) {
            // If an error occurs during the write operation, print an exception message and re-throw the exception
            System.out.println("Exception occurred: " + e.getMessage());
            throw e;
        }
    }
}

