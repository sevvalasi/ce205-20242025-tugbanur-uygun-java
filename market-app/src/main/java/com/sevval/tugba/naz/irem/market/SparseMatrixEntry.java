package com.sevval.tugba.naz.irem.market;

public class SparseMatrixEntry {
    private int vendorId;
    private int productId;
    private float price;

    public SparseMatrixEntry(int vendorId, int productId, float price) {
        this.vendorId = vendorId;
        this.productId = productId;
        this.price = price;
    }

    public int getVendorId() {
        return vendorId;
    }

    public int getProductId() {
        return productId;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vendor ID: " + vendorId + ", Product ID: " + productId + ", Price: " + price;
    }
}

