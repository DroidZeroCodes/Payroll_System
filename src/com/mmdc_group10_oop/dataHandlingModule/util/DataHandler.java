package com.mmdc_group10_oop.dataHandlingModule.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
 *     <li>{@link DataHandler#updateData(String, String, String, String)}</li>
 *     <li>{@link DataHandler#retrieveMultipleData(String, String)} </li>
 *     <li>{@link DataHandler#retrieveAllData()}  </li>
 *     <li>{@link DataHandler#retrieveRowData(String, String)}</li>
 *     <li>{@link DataHandler#createData(String[], boolean)}</li>
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
     * Example:
     * <pre>{@code
     * DataHandler dataHandler = new DataHandler("path/to/csv");
     * int index = dataHandler.findAttributeIndex("First Name");
     * }</pre>
     */
    public int findAttributeIndex(@NotNull String attribute) throws FileNotFoundException {
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

            System.out.println("Attribute Index Not Found");
            return -1; // Return -1 if the attribute is not found
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method searches for a specific data's index in a CSV file.
     *
     * @param headerName The name of the data to search for, for example: "First Name".
     * @param dataValue The value of the data to search for, for example: "John".
     * @return The index of the data if found, or -1 if not found.
     * Example:
     * <pre>{@code
     * DataHandler dataHandler = new DataHandler("path/to/csv");
     * int index = dataHandler.findDataIndex("First Name", "John");
     * }</pre>
     */
    public int findDataIndex(String headerName, String dataValue){
        // Open the CSV file for reading
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            //
            reader.skip(0);

            // Read the rows from the CSV file
            String[] rows;
            while ((rows = reader.readNext()) != null) {

                // Find the index of the data
                int dataIndex = findAttributeIndex(headerName);

                if (rows[dataIndex].equals(dataValue)) {
                    return dataIndex;
                }
            }
            System.out.println("Data Index Not Found");
            return -1; // Return -1 if the data is not found
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieve a single data value based on the given identifierValue and data name.
     *
     * @param  headerNameOfIdentifier  The name of the identifierValue attribute (column header).
     * @param  identifierValue      The value of the identifierValue attribute to match.
     * @param  headerName        The name of the data attribute to retrieve.
     * @return                 the retrieved data value
     */
    public String retrieveSingleData(@NotNull String headerNameOfIdentifier, @NotNull String identifierValue, @NotNull String headerName) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            int identifierValueIndex = findAttributeIndex(headerNameOfIdentifier);
            int dataIndex = findAttributeIndex(headerName);

            if (identifierValueIndex == -1 || dataIndex == -1) {
                return null;
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                if (row.length > Math.max(identifierValueIndex, dataIndex) && row[identifierValueIndex].equals(identifierValue)) {
                    return row[dataIndex];
                }
            }
            return null;
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves row data from the CSV file based on the provided data identifierValue and data name.
     *
     * @param headerNameOfIdentifier The name of the identifierValue to search for, for example: "Employee ID".
     * @param identifierValue The value of the identifierValue to search for, for example: "123".
     * @return The retrieved data value, or null if not found.
     */
    public String[] retrieveRowData(String headerNameOfIdentifier, String identifierValue) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            while ((row = reader.readNext()) != null) {
                int identifierValueIndex = findAttributeIndex(headerNameOfIdentifier);
                if (identifierValueIndex != -1) {
                    if (row.length > identifierValueIndex && row[identifierValueIndex].equals(identifierValue)) {
                        return row;
                    }
                } else {
                    throw new RuntimeException("Identifier Value not found in the CSV file.");
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Retrieves multiple data rows from the CSV file based on the specified identifierValue.
     *
     * @param headerNameOfIdentifier The name of the identifierValue attribute (column header).
     * @param identifierValue     The value of the identifierValue attribute to match.
     * @return A list of String arrays, each containing the data of the specified identifierValue.
     *         Returns null if the identifierValue is not found in the CSV file.
     */
    public List<String[]> retrieveMultipleData(String headerNameOfIdentifier, String identifierValue) {
        // Create a list to store the data of the specified identifierValue
        List<String[]> dataOfSpecifiedIdentifierValue = new ArrayList<>();

        // Open the CSV file and read the data
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Create an array of String to store the data of each row
            String[] row;

            // Read the CSV file line by line
            while ((row = reader.readNext()) != null) {
                // Find the index of the identifierValue
                int identifierValueIndex = findAttributeIndex(headerNameOfIdentifier);

                // If the identifierValue is found, add the row to the list
                if (identifierValueIndex != -1) {
                    if (row[identifierValueIndex].equals(identifierValue)) {
                        dataOfSpecifiedIdentifierValue.add(row);
                    }
                } else {
                    // If the identifierValue is not found, print a message, close the reader, and return null
                    System.out.println("Data not found");
                    reader.close();
                    return null;
                }
            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }

        return dataOfSpecifiedIdentifierValue;
    }

    /**
     * Retrieves all data from a CSV file.
     *
     * @return a list of string arrays containing the data
     *
     */
    public List<String[]> retrieveAllData() {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.skip(1);
            try {
                return reader.readAll();
            } catch (IOException | CsvException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Update the specified data in the CSV file based on the provided data identifierValue name and value, and new data.
     *
     * @param headerNameOfIdentifier The name of the identifierValue attribute (column header).
     * @param identifierValue The value of the identifierValue attribute to match.
     * @param headerName The name of the attribute to be updated.
     * @param newData The new data value to be written.
     */
    public void updateData(@NotNull String headerNameOfIdentifier, String identifierValue, String headerName, @NotNull String newData){
        List<String[]> updatedRows = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            while ((row = reader.readNext()) != null) {
                int identifierValueIndex = findAttributeIndex(headerNameOfIdentifier);
                int dataIndex = findAttributeIndex(headerName);
                if (identifierValueIndex != -1 && dataIndex != -1) {
                    if (row[identifierValueIndex].equals(identifierValue)) {
                        row[dataIndex] = newData;
                    }
                } else {
                    System.out.println("Data not found");
                    return;
                }
                updatedRows.add(row);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(updatedRows);
            System.out.println("Data updated successfully!!!");
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    /**
     * A method to create data in a CSV file.
     *
     * @param  dataToAdd    the data to be added to the CSV file
     * @param  insertLast   a flag to determine whether to insert the data at the end
     */
    public void createData(String[] dataToAdd, boolean insertLast) {
        // Read existing data
        List<String[]> existingData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            existingData = reader.readAll();
        } catch (CsvException | IOException e) {
            // File not found, this could be the first entry, so we proceed
        }

        // Add new data at the beginning or end based on insertLast flag
        if (insertLast) {

            existingData.add(dataToAdd);
        } else {
            existingData.add(1, dataToAdd);
        }

        // Write updated data back to the CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(existingData);
            System.out.println("Data added successfully!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

