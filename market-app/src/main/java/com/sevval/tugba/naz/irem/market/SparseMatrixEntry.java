/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of a sparse matrix entry for efficient storage of vendor-product relationships.
 */
package com.sevval.tugba.naz.irem.market;


/**
 * @class SparseMatrixEntry
 * @brief Represents an entry in a sparse matrix.
 * @details This class models a single entry in a sparse matrix, used to store relationships between vendors and products along with their associated prices.
 */
public class SparseMatrixEntry {
    private int vendorId;         ///< The ID of the vendor.
    private int productId;       ///< The ID of the product.
    private float price;        ///< The price associated with the vendor-product pair.

    
    /**
     * @brief Constructor for the `SparseMatrixEntry` class.
     * @details Initializes the entry with the specified vendor ID, product ID, and price.
     * @param vendorId The ID of the vendor.
     * @param productId The ID of the product.
     * @param price The price associated with the vendor-product pair.
     */
    public SparseMatrixEntry(int vendorId, int productId, float price) {
        this.vendorId = vendorId;
        this.productId = productId;
        this.price = price;
    }

    
    /**
     * @brief Retrieves the vendor ID.
     * @return The ID of the vendor.
     */
    public int getVendorId() {
        return vendorId;
    }

    /**
     * @brief Retrieves the product ID.
     * @return The ID of the product.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @brief Retrieves the price associated with the vendor-product pair.
     * @return The price of the product from the vendor.
     */
    public float getPrice() {
        return price;
    }

    
    /**
     * @brief Converts the sparse matrix entry to a readable string format.
     * @details Provides a string representation of the vendor ID, product ID, and price.
     * @return A string containing the details of the sparse matrix entry.
     */
    @Override
    public String toString() {
        return "Vendor ID: " + vendorId + ", Product ID: " + productId + ", Price: " + price;
    }
}

