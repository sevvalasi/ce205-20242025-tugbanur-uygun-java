/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes implementations for managing product selections and their associated data.
 */

package com.sevval.tugba.naz.irem.market;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * @class ProductSelection
 * @brief Manages product selection and storage.
 * @details This class provides mechanisms for managing selected products and contains an inner class `Product` 
 *          for handling individual product details.
 */
public class ProductSelection {

    public static StringBuffer selectedProductName = new StringBuffer();  ///< Stores the name of the currently selected product.

    
    /**
     * @class Product
     * @brief Represents a product in the market system.
     * @details The `Product` class encapsulates details about a product, such as its name, price, quantity, 
     *          season, and associated vendor ID. It also provides methods for reading product data from a `RandomAccessFile`.
     */
    static class Product {
        private String productName;      ///< The name of the product.
        private double price;             ///< The price of the product.
        private int quantity;            ///< The quantity of the product available.
        private String season;           ///< The season associated with the product.
        private int vendorId;            ///< The ID of the vendor offering the product.

        /**
         * @brief Default constructor for the `Product` class.
         * @details Initializes a `Product` object with default values.
         */
        public Product() {
            this.productName = "";
            this.price = 0.0;
            this.quantity = 0;
            this.season = "";
            this.vendorId = 0;
        }

        
        /**
         * @brief Parameterized constructor for the `Product` class.
         * @details Initializes a `Product` object with specified values.
         * @param productName The name of the product.
         * @param price The price of the product.
         * @param quantity The quantity of the product.
         * @param season The season associated with the product.
         * @param vendorId The ID of the vendor offering the product.
         */
        public Product(String productName, double price, int quantity, String season, int vendorId) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
            this.season = season;
            this.vendorId = vendorId;
        }

        
        /**
         * @brief Retrieves the name of the product.
         * @return The name of the product.
         */
        public String getProductName() {
            return productName;
        }

        /**
         * @brief Retrieves the price of the product.
         * @return The price of the product.
         */
        public double getPrice() {
            return price;
        }

        
        /**
         * @brief Retrieves the quantity of the product available.
         * @return The quantity of the product.
         */
        public int getQuantity() {
            return quantity;
        }

        
        
        /**
         * @brief Retrieves the season associated with the product.
         * @return The season of the product.
         */
        public String getSeason() {
            return season;
        }

        /**
         * @brief Retrieves the ID of the vendor offering the product.
         * @return The vendor ID.
         */
        public int getVendorId() {
            return vendorId;
        }

        
        /**
         * @brief Reads product data from a `RandomAccessFile`.
         * @details Reads product details such as vendor ID, name, price, quantity, and season from the given file.
         * @param raf The `RandomAccessFile` object to read from.
         * @throws IOException If an I/O error occurs while reading the file.
         */
        public void readFromRandomAccessFile(RandomAccessFile raf) throws IOException {
            this.vendorId = raf.readInt();
            this.productName = raf.readUTF();
            this.price = raf.readDouble();
            this.quantity = raf.readInt();
            this.season = raf.readUTF();
        }
    }	
}