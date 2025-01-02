/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and structures related to the Market application.
 * @details This package includes data structures for managing products and their storage in buckets.
 */
package com.sevval.tugba.naz.irem.market;

import java.util.ArrayList;
import java.util.List;

/**
 * @class Bucket
 * @brief Represents a container for storing products in a bucket.
 * @details This class provides methods for managing a list of products within a bucket. 
 *          It supports adding products and retrieving the product list.
 */
public class Bucket {
    public static Product[] product; ///< Static array of products for global access (if needed).
	private List<Product> products;  ///< List to store products in the bucket.

	/**
     * @brief Constructor for the `Bucket` class.
     * @details Initializes an empty list to hold the products.
     */
    public Bucket() {
        this.products = new ArrayList<>();
    }

    /**
     * @brief Retrieves the list of products stored in the bucket.
     * @return A list of `Product` objects currently in the bucket.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @brief Adds a product to the bucket.
     * @param product The `Product` object to add to the bucket.
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * @brief Converts the bucket contents to a readable string representation.
     * @details Overrides the default `toString` method to display all products in the bucket.
     * @return A string representation of the bucket's contents.
     */
    @Override
    public String toString() {
        return "Bucket contains: " + products;
    }
}
