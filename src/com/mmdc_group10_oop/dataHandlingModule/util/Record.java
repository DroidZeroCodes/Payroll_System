package com.mmdc_group10_oop.dataHandlingModule.util;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

/**
 * Abstract class representing a record in the database.
 * This class provides methods for managing records such as checking existence,
 * validating keys, updating records, and retrieving records.
 */
public abstract class Record extends Query {

    /**
     * Checks if a record with the specified data exists in the file.
     *
     * @param dataName  the name of the data column to check
     * @param dataValue the value to search for in the specified column
     * @return true if the record exists, false otherwise
     */
    public boolean doesExist(@NotNull String dataName, String dataValue) {
        DataHandler dataHandler = new DataHandler(filePath());
        return dataHandler.findDataIndex(dataName, dataValue) != -1;
    }


    /**
     * Checks if the provided primary key is valid.
     *
     * @param primaryKey the primary key to validate
     * @return true if the primary key is valid, false otherwise
     */
    public boolean isValidKey(int primaryKey) {
        if (primaryKey <= 0) {
            throw new IllegalArgumentException("Employee ID cannot be zero or negative.");
        }
        return true;
    }

    /**
     * Checks if the provided primary key is valid.
     *
     * @param primaryKey the primary key to validate
     * @return true if the primary key is valid, false otherwise
     */
    public boolean isValidKey(String primaryKey) {
        if (primaryKey == null || primaryKey.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be empty.");
        }
        return true;
    }

    /**
     * Checks if the provided identifier is valid.
     *
     * @param identifierName the name of the identifier
     * @param identifier     the identifier to validate
     * @return true if the identifier is valid, false otherwise
     */
    public boolean isValidKey(String identifierName, String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException(identifierName + " cannot be empty.");
        }
        return true;
    }

    /**
     * Update the specified record with the new value.
     *
     * @param identifierValue the identifierValue of the record to update
     * @param dataName   the name of the data column to update
     * @param newValue   the new value to be set
     */
    public void updateRecord(@NotNull String identifierValue, @NotNull String dataName, @NotNull String newValue) {
        DataHandler dataHandler = new DataHandler(filePath());
        dataHandler.updateData(primaryKey(), identifierValue, dataName, newValue);
    }

    /**
     * Retrieves all records from the data file.
     *
     * @return a list containing arrays representing all records
     * @throws RuntimeException if an I/O error occurs
     */
    public List<String[]> retrieveAllRecords() {
        DataHandler dataHandler = new DataHandler(filePath());
        return dataHandler.retrieveAllData();
    }

    /**
     * Parses a financial value from a string by removing commas and converting it to a double.
     *
     * @param value the string representing the financial value
     * @return the parsed double value
     */
    public static double parseDoubleValue(String value) {
        try {
            String cleanedValue = value.replace(",", "");
            return Double.parseDouble(cleanedValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid financial value: " + value);
        }
    }


    /**
     * Retrieves a specific record from the data file to set the attributes of the record class.
     *
     * @throws CsvValidationException if there is an error in CSV validation
     * @throws IOException            if an I/O error occurs
     */
    protected abstract void retrieveRecord() throws CsvException, IOException;

    protected abstract void addRecord() throws CsvException, IOException;
}
