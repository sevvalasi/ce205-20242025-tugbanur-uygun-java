package com.sevval.tugba.naz.irem.market;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ProductSelection {

    public static StringBuffer selectedProductName = new StringBuffer();

    static class Product {
        private String productName;
        private double price;
        private int quantity;
        private String season;
        private int vendorId;

        public Product() {
            this.productName = "";
            this.price = 0.0;
            this.quantity = 0;
            this.season = "";
            this.vendorId = 0;
        }

        public Product(String productName, double price, int quantity, String season, int vendorId) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
            this.season = season;
            this.vendorId = vendorId;
        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public String getSeason() {
            return season;
        }

        public int getVendorId() {
            return vendorId;
        }

        public void readFromRandomAccessFile(RandomAccessFile raf) throws IOException {
            this.vendorId = raf.readInt();
            this.productName = raf.readUTF();
            this.price = raf.readDouble();
            this.quantity = raf.readInt();
            this.season = raf.readUTF();
        }
    }	
}