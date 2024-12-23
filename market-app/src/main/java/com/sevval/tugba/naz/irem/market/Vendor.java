package com.sevval.tugba.naz.irem.market;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Vendor {
	
	int vendorId;
    private String vendorName;

    // Parametreli Yapıcı Metot
    public Vendor(int vendorId, String vendorName) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
    }

    // Default Constructor
    public Vendor() {}

    // Getter for ID
    public int getId() {
        return this.vendorId; // vendorId değerini döndür
    }

    // Getter for Name
    public String getName() {
        return this.vendorName; // vendorName değerini döndür
    }

    public void writeToRandomAccessFile(RandomAccessFile file) throws IOException {
        file.writeInt(vendorId);
        file.writeUTF(vendorName);
    }

    public void readFromRandomAccessFile(RandomAccessFile file) throws IOException {
        this.vendorId = file.readInt();
        this.vendorName = file.readUTF();
    }

    // toString metodu
    @Override
    public String toString() {
        return "Vendor ID: " + vendorId + ", Name: " + vendorName;
    }


}
