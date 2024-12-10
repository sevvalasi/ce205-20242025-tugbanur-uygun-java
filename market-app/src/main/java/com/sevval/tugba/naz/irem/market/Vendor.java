package com.sevval.tugba.naz.irem.market;

import java.io.RandomAccessFile;

public class Vendor {
	
	private int vendorId;
	private String vendorName;

	// Parametreli Yapıcı Metot
    public Vendor(int vendorId, String vendorName) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
    }

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void readFromFile(RandomAccessFile vendorRAF) {
		// TODO Auto-generated method stub
		
	}

}
