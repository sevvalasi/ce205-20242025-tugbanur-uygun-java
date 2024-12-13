package com.sevval.tugba.naz.irem.market;

import java.io.*;

public class Product {
    private int vendorId;          // Ürünü satan satıcının ID'si
    private String productName;    // Ürün adı
    private double price;           // Ürün fiyatı
    private int quantity;          // Ürün miktarı
    private String season;         // Ürün sezon bilgisi

    // --- Constructor ---
    public Product() {}

    public Product(int vendorId, String productName, double price, int quantity, String season) {
        this.vendorId = vendorId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.season = season;
    }
   
	// --- Getter ve Setter Metotları ---
    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    // --- Dosyaya Yazma Metodu ---
    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(vendorId);                  // vendorId yaz
        file.writeUTF(productName);               // productName yaz
        file.writeDouble(price);                   // price yaz
        file.writeInt(quantity);                  // quantity yaz
        file.writeUTF(season);                    // season yaz
    }

    // --- Dosyadan Okuma Metodu ---
    public void readFromFile(RandomAccessFile file) throws IOException {
        this.vendorId = file.readInt();           // vendorId oku
        this.productName = file.readUTF();        // productName oku
        this.price = file.readFloat();            // price oku
        this.quantity = file.readInt();           // quantity oku
        this.season = file.readUTF();             // season oku
    }

    // --- Ürünü Konsola Yazdırma ---
    @Override
    public String toString() {
        return "Vendor ID: " + vendorId +
               ", Product Name: " + productName +
               ", Price: " + price +
               ", Quantity: " + quantity +
               ", Season: " + season;
    }
}

