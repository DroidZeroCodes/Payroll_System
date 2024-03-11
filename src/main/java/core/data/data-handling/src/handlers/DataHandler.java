package handlers;


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
 *     <li>{@link DataHandler#retrieveMultipleData(String, String)} </li>
 *     <li>{@link DataHandler#retrieveAllData()}  </li>
 *     <li>{@link DataHandler#retrieveRowData(String, String)}</li>
 *     <li>{@link DataHandler#createData(String[])}</li>
 *     <li>{@link DataHandler#(String, String)}</li>
 *     <li>{@link DataHandler#updateRowData(String, String, String[])}</li>
 * </ul>
 *
 * @author Harvey Dela Flor
 */
final public class DataHandler {
    private String csvFile_OR_FolderPath;

    /**
     * Creates a new DataHandler object, given the database path.
     *
     * @param csvFile_OR_FolderPath The path to the directory where CSV files are stored.
     */
    public DataHandler(@NotNull String csvFile_OR_FolderPath) {
        this.csvFile_OR_FolderPath = csvFile_OR_FolderPath;
    }

    public void setCsvFile_OR_FolderPath(String csvFile_OR_FolderPath) {
        this.csvFile_OR_FolderPath = csvFile_OR_FolderPath;
    }

    /**
     * This method searches for a specific attribute (header) in a CSV file.
     *
     * @param attributeName The attribute to search for, for example: "First Name".
     * @return The index of the attribute if found, or -1 if not found.
     * Example:
     * <pre>{@code
     * DataHandler dataHandler = new DataHandler("path/to/csv");
     * int index = dataHandler.findAttributeIndex("First Name");
     * }</pre>
     */
    public int findAttributeIndex(String attributeName) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            // Read the first row to get headers
            String[] headers = reader.readNext();
            if (headers == null) {
                throw new IOException("Empty or invalid CSV file: " + csvFile_OR_FolderPath);
            }

            // Search for the attribute index
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals(attributeName)) {
                    return i;
                }
            }

            // Attribute not found
            System.err.println("Attribute Index Not Found");
            return -1;
        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + csvFile_OR_FolderPath);
            return -1;
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return -1;
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves row data from the CSV file based on the provided data identifierAttributeName and data name.
     *
     * @param identifierAttributeName The name of the identifierAttribute to search for, for example: "Employee ID".
     * @param identifierValue         The value of the identifierAttribute to search for, for example: "123".
     * @return The retrieved data value, or null if not found.
     */
    public String[] retrieveRowData(String identifierAttributeName, String identifierValue) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            String[] row;
            while ((row = reader.readNext()) != null) {
                int identifierValueIndex = findAttributeIndex(identifierAttributeName);
                if (identifierValueIndex != -1) {
                    if (row.length > identifierValueIndex && row[identifierValueIndex].equals(identifierValue)) {
                        return row;
                    }
                } else {
                    throw new RuntimeException("Identifier Value not found in the CSV file.");
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Row Data Not Found");
            return null;
        }
        return null;
    }

    /**
     * Retrieve column data based on the header name of the identifier.
     *
     * @param identifierAttributeName the name of the header to identify the column data
     * @return an array of String containing the column data
     */
    public Integer[] retrieveColumnData_AsInt(String identifierAttributeName) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            List<Integer> columnData = new ArrayList<>();
            reader.skip(1);

            int identifierValueIndex = findAttributeIndex(identifierAttributeName);
            if (identifierValueIndex != -1) {
                String[] row;
                while ((row = reader.readNext()) != null) {
                    if (row.length > identifierValueIndex) {
                        columnData.add(Integer.valueOf(row[identifierValueIndex]));
                    }
                }
            }
            return columnData.toArray(new Integer[0]);
        } catch (IOException | CsvValidationException e) {
            System.err.println("Column Data Not Found");
            return null;
        }
    }

    /**
     * Retrieves multiple data rows from the CSV file based on the specified identifierAttribute.
     *
     * @param identifierAttributeName The name of the identifierAttribute attribute (column header).
     * @param identifierValue         The value of the identifierAttribute attribute to match.
     * @return A list of String arrays, each containing the data of the specified identifierAttribute.
     * Returns null if the identifierAttribute is not found in the CSV file.
     */
    public List<String[]> retrieveMultipleData(String identifierAttributeName, String identifierValue) {
        // Create a list to store the data of the specified identifierAttribute
        List<String[]> dataOfSpecifiedIdentifierValue = new ArrayList<>();

        // Open the CSV file and read the data
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            // Create an array of String to store the data of each row
            String[] row;

            // Find the index of the identifierAttribute
            int identifierValueIndex = findAttributeIndex(identifierAttributeName);

            // Read the CSV file line by line
            while ((row = reader.readNext()) != null) {
                // Check if the identifierAttribute is found
                if (identifierValueIndex != -1) {
                    // If the identifierAttribute matches, add the row to the list
                    if (row.length > identifierValueIndex && row[identifierValueIndex].equals(identifierValue)) {
                        dataOfSpecifiedIdentifierValue.add(row);
                    }
                } else {
                    // If the identifierAttribute is not found, throw an exception
                    throw new IllegalArgumentException("Identifier attribute not found");
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Multiple Row Data not found: " + e.getMessage());
            return null;
        }

        return dataOfSpecifiedIdentifierValue;
    }

    /**
     * Retrieves all data from a CSV file.
     *
     * @return a list of string arrays containing the data
     */
    public List<String[]> retrieveAllData() {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            reader.skip(1);
            try {
                return reader.readAll();
            } catch (IOException | CsvException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            System.err.println("Data not found");
            return null;
        }
    }

    /**
     * A method to create data in a CSV file.
     *
     * @param dataToAdd the data to be added to the CSV file
     */
    public void createData(String[] dataToAdd) {
        // Read existing data
        List<String[]> existingData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            existingData = reader.readAll();
        } catch (CsvException | IOException e) {
            // File not found, this could be the first entry, so we proceed
            System.err.println("Duplicate entry not found, proceeding");
        }

        // Add new data
        existingData.add(dataToAdd);

        // Write updated data back to the CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile_OR_FolderPath))) {
            writer.writeAll(existingData);
            System.out.println("Data added successfully!!!");
        } catch (IOException e) {
            System.err.println("Exception occurred: " + e.getMessage());
            System.err.println("Data not created");
        }
    }

    public void updateRowData(String identifierAttributeName, String identifierValue, String[] newValues) {
        List<String[]> updatedRows = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            String[] row;

            while ((row = reader.readNext()) != null) {
                int identifierValueIndex = findAttributeIndex(identifierAttributeName);
                if (identifierValueIndex != -1) {
                    if (row[identifierValueIndex].equals(identifierValue)) {
                        updatedRows.add(newValues);
                    } else {
                        updatedRows.add(row);
                    }
                } else {
                    System.err.println("Data not found");
                    return;
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile_OR_FolderPath))) {
            writer.writeAll(updatedRows);
            System.out.println("Data updated successfully!!!");
        } catch (IOException e) {
            System.err.println("Exception occurred: " + e.getMessage());
            System.err.println("Row Data not updated");
        }
    }

    public void deleteRowData(String identifierAttributeName, String identifierValue) {
        //Read existing data
        List<String[]> existingData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            existingData = reader.readAll();
        } catch (CsvException | IOException e) {
            // File not found, this could be the first entry, so we proceed
            System.err.println("No existing records found");
            return;
        }

        //Delete the row
        for (int i = 0; i < existingData.size(); i++) {
            if (existingData.get(i)[findAttributeIndex(identifierAttributeName)].equals(identifierValue)) {
                existingData.remove(i);
                break;
            }
        }

        //Write updated data back to the CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile_OR_FolderPath))) {
            writer.writeAll(existingData);
            System.out.println("Data deleted successfully!!!");
        } catch (IOException e) {
            System.err.println("Exception occurred: " + e.getMessage());
            System.err.println("Data not deleted");
        }
    }

    public void createCSVFile(List<String[]> rowLists, String[] headers, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(headers);
            writer.writeAll(rowLists);
            System.out.println("Data created successfully!!!");
        } catch (IOException e) {
            System.err.println("Exception occurred: " + e.getMessage());
            System.err.println("Data not created");
        }
    }

    public void insertDataFromCSV(String employeeCSVPath) {
        try {
            List<String[]> rowLists = new ArrayList<>();
            try (CSVReader reader = new CSVReader(new FileReader(employeeCSVPath))) {
                String[] row;
                while ((row = reader.readNext()) != null) {
                    rowLists.add(row);
                }
            } catch (IOException | CsvValidationException e) {
                System.err.println("Error: " + e.getMessage());
            }
            String[] headers = rowLists.get(0);
            rowLists.remove(0);

            List<String[]> existingData = new ArrayList<>();
            try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
                String[] row;
                while ((row = reader.readNext()) != null) {
                    existingData.add(row);
                }
            } catch (IOException | CsvValidationException e) {
                System.err.println("Error: " + e.getMessage());
            }
            existingData.remove(0);

            existingData.addAll(rowLists);
            createCSVFile(existingData, headers, csvFile_OR_FolderPath);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public int getCsvSize() {
        try {
            List<String[]> rowLists = new ArrayList<>();
            try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
                String[] row;
                reader.skip(1);
                while ((row = reader.readNext()) != null) {
                    rowLists.add(row);
                }
            } catch (IOException | CsvValidationException e) {
                System.err.println("Error: " + e.getMessage());
            }
            return rowLists.size();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 0;
        }
    }
}

