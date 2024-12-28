package com.sevval.tugba.naz.irem.market;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MarketHours {
    private int id;
    private String day;
    private String hours;
    private String location;

    // Constructor
    public MarketHours() {}

    // Getter ve Setter'lar
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static MarketHours readMarketHours(RandomAccessFile file) throws IOException {
        try {
            int id = file.readInt(); // Read Market ID
            String day = file.readUTF(); // Read Day
            String hours = file.readUTF(); // Read Working Hours
            String location = file.readUTF(); // Read Location
            return new MarketHours();
        } catch (IOException e) {
            System.err.println("Error reading MarketHours from file: " + e.getMessage());
            throw e;
        }
    }

    public static void writeMarketHours(RandomAccessFile file, MarketHours market) throws IOException {
        file.writeInt(market.getId());        // ID'yi yaz
        file.writeUTF(market.getDay());       // Gün bilgisini yaz
        file.writeUTF(market.getHours());     // Saat bilgisini yaz
        file.writeUTF(market.getLocation());  // Lokasyon bilgisini yaz
    }

    public void readFromFile(RandomAccessFile file) throws IOException {
        id = file.readInt();
        day = file.readUTF();
        hours = file.readUTF();
        location = file.readUTF();
    }
}
