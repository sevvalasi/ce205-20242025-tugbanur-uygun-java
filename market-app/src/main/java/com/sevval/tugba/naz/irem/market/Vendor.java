package com.sevval.tugba.naz.irem.market;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Vendor {
	
	private int vendorId;
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

    // RandomAccessFile'dan veri okuma
    public void readFromFile(RandomAccessFile vendorRAF) throws IOException {
        this.vendorId = vendorRAF.readInt();
        this.vendorName = vendorRAF.readUTF();
    }

    // toString metodu
    @Override
    public String toString() {
        return "Vendor ID: " + vendorId + ", Name: " + vendorName;
    }

}
