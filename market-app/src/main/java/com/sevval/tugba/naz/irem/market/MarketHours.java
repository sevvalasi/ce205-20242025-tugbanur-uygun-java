package com.sevval.tugba.naz.irem.market;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MarketHours {
	private int id;
    private String day;
    private String hours;
    private String location;

    public MarketHours() {
    }

    public MarketHours(int id, String day, String hours, String location) {
        this.id = id;
        this.day = day;
        this.hours = hours;
        this.location = location;
    }

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

    public void readFromFile(RandomAccessFile file) throws IOException {
        this.id = file.readInt();
        this.day = file.readUTF();
        this.hours = file.readUTF();
        this.location = file.readUTF();
    }

    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(id);
        file.writeUTF(day);
        file.writeUTF(hours);
        file.writeUTF(location);
    }
}
