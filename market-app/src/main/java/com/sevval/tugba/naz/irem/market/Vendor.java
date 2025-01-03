/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes related to the Market application.
 * @details This package includes the implementation of the `Vendor` class, representing a vendor in the market system.
 */
package com.sevval.tugba.naz.irem.market;

import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * @class Vendor
 * @brief Represents a vendor in the market system.
 * @details The `Vendor` class contains information about a vendor, including their ID and name. 
 *          It provides methods for reading from and writing to a `RandomAccessFile` for persistence.
 */
public class Vendor {
	
	int vendorId;                 ///< The unique ID of the vendor.
    private String vendorName;    ///< The name of the vendor.


    /**
     * @brief Parameterized constructor for the `Vendor` class.
     * @details Initializes a `Vendor` object with the specified ID and name.
     * @param vendorId The unique ID of the vendor.
     * @param vendorName The name of the vendor.
     */
    public Vendor(int vendorId, String vendorName) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
    }

    /**
     * @brief Default constructor for the `Vendor` class.
     * @details Initializes a `Vendor` object with default values.
     */
    public Vendor() {}

    /**
     * @brief Retrieves the vendor's ID.
     * @return The ID of the vendor.
     */
    public int getId() {
        return this.vendorId; 
    }

    /**
     * @brief Retrieves the vendor's name.
     * @return The name of the vendor.
     */
    public String getName() {
        return this.vendorName; 
    }

    /**
     * @brief Writes the vendor's data to a `RandomAccessFile`.
     * @details Saves the vendor's ID and name to a file for persistence.
     * @param file The `RandomAccessFile` object to write to.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public void writeToRandomAccessFile(RandomAccessFile file) throws IOException {
        file.writeInt(vendorId);
        file.writeUTF(vendorName);
    }

    
    /**
     * @brief Reads the vendor's data from a `RandomAccessFile`.
     * @details Loads the vendor's ID and name from a file.
     * @param file The `RandomAccessFile` object to read from.
     * @throws IOException If an I/O error occurs while reading from the file.
     */
    public void readFromRandomAccessFile(RandomAccessFile file) throws IOException {
        this.vendorId = file.readInt();
        this.vendorName = file.readUTF();
    }

    /**
     * @brief Converts the vendor's information to a readable string format.
     * @details Provides a string representation of the vendor, including their ID and name.
     * @return A string containing the vendor's details.
     */
    @Override
    public String toString() {
        return "Vendor ID: " + vendorId + ", Name: " + vendorName;
    }

}
