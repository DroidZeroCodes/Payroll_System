package logic;

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
     * This method searches for a specific data's index in a CSV file.
     *
     * @param attributeName The name of the data to search for, for example: "First Name".
     * @param dataValue     The value of the data to search for, for example: "John".
     * @return The index of the data if found, or -1 if not found.
     * Example:
     * <pre>{@code
     * DataHandler dataHandler = new DataHandler("path/to/csv");
     * int index = dataHandler.findDataIndex("First Name", "John");
     * }</pre>
     */
    public int findDataIndex(String attributeName, String dataValue) {
        // Open the CSV file for reading
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            //
            reader.skip(0);

            // Read the rows from the CSV file
            String[] rows;
            while ((rows = reader.readNext()) != null) {

                // Find the index of the data
                int dataIndex = findAttributeIndex(attributeName);

                if (rows[dataIndex].equals(dataValue)) {
                    return dataIndex;
                }
            }
            System.out.println("Data Index Not Found");
            return -1; // Return -1 if the data is not found
        } catch (IOException | CsvValidationException e) {
            System.out.println("Data Index Not Found");
            return -1;
        }
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
            System.out.println("Attribute Index Not Found");
            return -1;
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found: " + csvFile_OR_FolderPath);
            return -1;
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
            return -1;
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieve a single data value based on the given identifierAttributeName and data name.
     *
     * @param identifierAttributeName The name of the identifierAttribute attribute (column header).
     * @param identifierValue         The value of the identifierAttribute attribute to match.
     * @param dataName                The name of the data attribute to retrieve.
     * @return the retrieved data value
     */
    public String retrieveSingleData(@NotNull String identifierAttributeName, @NotNull String identifierValue, @NotNull String dataName) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            int identifierValueIndex = findAttributeIndex(identifierAttributeName);
            int dataIndex = findAttributeIndex(dataName);

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
            System.out.println("Data Not Found");
            return null;
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
            System.out.println("Row Data Not Found");
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
            System.out.println("Column Data Not Found");
            return null;
        }
    }

    /**
     * Retrieve column data based on the header name of the identifier.
     *
     * @param identifierAttributeName the name of the header to identify the column data
     * @return an array of String containing the column data
     */
    public String[] retrieveColumnData_AsString(String identifierAttributeName) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            List<String> columnData = new ArrayList<>();
            reader.skip(1);

            int identifierValueIndex = findAttributeIndex(identifierAttributeName);
            if (identifierValueIndex != -1) {
                String[] row;
                while ((row = reader.readNext()) != null) {
                    if (row.length > identifierValueIndex) {
                        columnData.add(row[identifierValueIndex]);
                    }
                }
            }
            return columnData.toArray(new String[0]);
        } catch (IOException | CsvValidationException e) {
            System.out.println("Column Data Not Found");
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
            System.out.println("Multiple Row Data not found");
            e.printStackTrace();
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
            System.out.println("Data not found");
            return null;
        }
    }

    /**
     * Update the specified data in the CSV file based on the provided data identifierAttribute name and value, and new data.
     *
     * @param identifierAttributeName The name of the identifierAttribute attribute (column header).
     * @param identifierValue         The value of the identifierAttribute attribute to match.
     * @param dataName                The name of the attribute to be updated.
     * @param newData                 The new data value to be written.
     */
    public void updateData(@NotNull String identifierAttributeName, String identifierValue, String dataName, @NotNull String newData) {
        List<String[]> updatedRows = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            String[] row;
            while ((row = reader.readNext()) != null) {
                int identifierValueIndex = findAttributeIndex(identifierAttributeName);
                int dataIndex = findAttributeIndex(dataName);
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
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile_OR_FolderPath))) {
            writer.writeAll(updatedRows);
            System.out.println("Data updated successfully!!!");
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            System.out.println("Data not updated");
        }
    }

    /**
     * A method to create data in a CSV file.
     *
     * @param dataToAdd  the data to be added to the CSV file
     * @param insertLast a flag to determine whether to insert the data at the end
     */
    public void createData(String[] dataToAdd, boolean insertLast) {
        // Read existing data
        List<String[]> existingData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            existingData = reader.readAll();
        } catch (CsvException | IOException e) {
            // File not found, this could be the first entry, so we proceed
            System.out.println("Duplicate entry not found, proceeding");
        }

        // Add new data at the beginning or end based on insertLast flag
        if (insertLast) {

            existingData.add(dataToAdd);
        } else {
            existingData.add(1, dataToAdd);
        }

        // Write updated data back to the CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile_OR_FolderPath))) {
            writer.writeAll(existingData);
            System.out.println("Data added successfully!!!");
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            System.out.println("Data not created");
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
                    System.out.println("Data not found");
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
            System.out.println("Exception occurred: " + e.getMessage());
            System.out.println("Row Data not updated");
        }
    }

    public void deleteRowData(String identifierAttributeName, String identifierValue) {
        //Read existing data
        List<String[]> existingData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile_OR_FolderPath))) {
            existingData = reader.readAll();
        } catch (CsvException | IOException e) {
            // File not found, this could be the first entry, so we proceed
            System.out.println("No existing records found");
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
            System.out.println("Exception occurred: " + e.getMessage());
            System.out.println("Data not deleted");
        }
    }

    public void createCSVFile(List<String[]> rowLists, String newCSVFileName) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile_OR_FolderPath + "/" + newCSVFileName))) {
            writer.writeAll(rowLists);
            System.out.println("Data created successfully!!!");
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            System.out.println("Data not created");
        }
    }
}

