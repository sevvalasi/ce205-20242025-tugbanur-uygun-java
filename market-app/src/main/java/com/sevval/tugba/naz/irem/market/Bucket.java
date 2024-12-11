package com.sevval.tugba.naz.irem.market;

public class Bucket {

	private static final int MAX_PRODUCTS = 100; // Set a maximum limit for products
    private Product[] products; // Array to hold Product objects
    private int productCount; // Counter for the number of products

    // Constructor
    public Bucket() {
        products = new Product[MAX_PRODUCTS];
        productCount = 0;
    }

    // Method to add a product to the bucket
    public void addProduct(Product product) {
        if (productCount < MAX_PRODUCTS) {
            products[productCount++] = product; // Add the product and increment the counter
        } else {
            System.out.println("Bucket is full. Cannot add more products.");
        }
    }

    // Method to retrieve all products
    public Product[] getProducts() {
        Product[] result = new Product[productCount];
        System.arraycopy(products, 0, result, 0, productCount); // Copy non-null products to a new array
        return result;
    }

    // Method to get the current product count
    public int getProductCount() {
        return productCount;
    }
	
}
