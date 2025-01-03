/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes implementations for managing products and their associated data.
 */
package com.sevval.tugba.naz.irem.market;

import java.io.*;


/**
 * @class Product
 * @brief Represents a product in the market system.
 * @details The `Product` class encapsulates details about a product, such as its vendor ID, name, price, quantity,
 *          and season. It provides methods for reading from and writing to a `RandomAccessFile`, along with
 *          getter and setter methods for managing product attributes.
 */
public class Product {
    private int vendorId;         ///< The ID of the vendor offering the product.
    private String productName;    ///< The name of the product.
    private double price;           ///< The price of the product.
    private int quantity;         ///< The quantity of the product available.
    private String season;         ///< The season associated with the product.
    
    /**
     * @brief Default constructor for the `Product` class.
     * @details Initializes a `Product` object with default values for all attributes.
     */
    public Product() {
        this.vendorId = 0;
        this.productName = "";
        this.price = 0.0;
        this.quantity = 0;
        this.season = "";
    }
    
    /**
     * @brief Parameterized constructor for the `Product` class.
     * @details Initializes a `Product` object with specified values for all attributes.
     * @param vendorId The ID of the vendor offering the product.
     * @param productName The name of the product.
     * @param price The price of the product.
     * @param quantity The quantity of the product available.
     * @param season The season associated with the product.
     */
	public Product(int vendorId, String productName, double price, int quantity, String season) {
		 this.vendorId = vendorId;
	        this.productName = productName;
	        this.price = price;
	        this.quantity = quantity;
	        this.season = season;
	}

	/**
     * @brief Retrieves the vendor ID.
     * @return The ID of the vendor.
     */
    public int getVendorId() {
        return vendorId;
    }

    /**
     * @brief Sets the vendor ID.
     * @param vendorId The ID of the vendor to set.
     */
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * @brief Retrieves the product name.
     * @return The name of the product.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @brief Sets the product name.
     * @param productName The name of the product to set.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @brief Retrieves the product price.
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * @brief Sets the product price.
     * @param price The price of the product to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @brief Retrieves the product quantity.
     * @return The quantity of the product available.
     */
    public int getQuantity() {
        return quantity;
    }

    
    /**
     * @brief Sets the product quantity.
     * @param quantity The quantity of the product to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @brief Retrieves the product season.
     * @return The season associated with the product.
     */
    public String getSeason() {
        return season;
    }

    /**
     * @brief Sets the product season.
     * @param season The season associated with the product to set.
     */
    public void setSeason(String season) {
        this.season = season;
    }

    /**
     * @brief Writes the product data to a `RandomAccessFile`.
     * @details Saves the product's vendor ID, name, price, quantity, and season to the specified file.
     * @param file The `RandomAccessFile` object to write to.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(vendorId);                  
        file.writeUTF(productName);              
        file.writeDouble(price);                  
        file.writeInt(quantity);                  
        file.writeUTF(season);                  
    }

    /**
     * @brief Reads the product data from a `RandomAccessFile`.
     * @details Loads the product's vendor ID, name, price, quantity, and season from the specified file.
     * @param file The `RandomAccessFile` object to read from.
     * @throws IOException If an I/O error occurs while reading from the file.
     */
    public void readFromFile(RandomAccessFile file) throws IOException {
        this.vendorId = file.readInt();         
        this.productName = file.readUTF();      
        this.price = file.readDouble();          
        this.quantity = file.readInt();          
        this.season = file.readUTF();           
    }

    /**
     * @brief Converts the product to a readable string format.
     * @details Provides a string representation of the product's attributes.
     * @return A string containing the product's vendor ID, name, price, quantity, and season.
     */
    @Override
    public String toString() {
        return "Vendor ID: " + vendorId +
               ", Product Name: " + productName +
               ", Price: " + price +
               ", Quantity: " + quantity +
               ", Season: " + season;
    }

}

