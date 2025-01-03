/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of the `MarketHours` class, which represents the operating hours and location of a market.
 */
package com.sevval.tugba.naz.irem.market;

import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * @class MarketHours
 * @brief Represents the working hours and location of a market.
 * @details The `MarketHours` class provides attributes and methods for managing a market's ID, working day, hours, and location.
 *          It also includes methods for reading and writing market information to and from a `RandomAccessFile`.
 */
public class MarketHours {
	 /**
     * @var id
     * @brief The unique identifier for a market.
     * @details This integer variable stores the unique ID assigned to each market, allowing it to be uniquely identified.
     */
    private int id;
    
    /**
     * @var day
     * @brief The operating day of the market.
     * @details This string variable stores the day of the week (e.g., "Monday", "Tuesday") when the market is operational.
     */
    private String day;
    
    /**
     * @var hours
     * @brief The operating hours of the market.
     * @details This string variable specifies the hours during which the market operates (e.g., "09:00 - 18:00").
     */
    private String hours;
    
    /**
     * @var location
     * @brief The physical location of the market.
     * @details This string variable stores the address or description of the market's location.
     */
    private String location;

    /**
     * @brief Default constructor for the `MarketHours` class.
     * @details Initializes a `MarketHours` object with default values.
     */
    public MarketHours() {}

    /**
     * @brief Retrieves the market ID.
     * @return The unique identifier for the market.
     */
    public int getId() {
        return id;
    }

    /**
     * @brief Sets the market ID.
     * @param id The unique identifier to set for the market.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @brief Retrieves the operating day of the market.
     * @return The day of operation for the market.
     */
    public String getDay() {
        return day;
    }

    /**
     * @brief Sets the operating day of the market.
     * @param day The day of operation to set for the market.
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @brief Retrieves the working hours of the market.
     * @return The working hours of the market.
     */
    public String getHours() {
        return hours;
    }

    /**
     * @brief Sets the working hours of the market.
     * @param hours The working hours to set for the market.
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    /**
     * @brief Retrieves the location of the market.
     * @return The location of the market.
     */
    public String getLocation() {
        return location;
    }

    /**
     * @brief Sets the location of the market.
     * @param location The location to set for the market.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    
    /**
     * @brief Reads market hours data from a `RandomAccessFile`.
     * @details Reads market ID, day, working hours, and location from the specified file.
     * @param file The `RandomAccessFile` object to read from.
     * @return A new `MarketHours` object with data read from the file.
     * @throws IOException If an I/O error occurs while reading from the file.
     */
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

    /**
     * @brief Writes the market hours data to a `RandomAccessFile`.
     * @details Saves the market's ID, day, working hours, and location to the specified file.
     * @param file The `RandomAccessFile` object to write to.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(id);        // Market ID
        file.writeUTF(day);       // Day
        file.writeUTF(hours);     // Working Hours
        file.writeUTF(location);  // Location
    }

    /**
     * @brief Reads a `MarketHours` object from a `RandomAccessFile`.
     * @details Reads market hours data (ID, day, working hours, location) and initializes a `MarketHours` object.
     * @param file The `RandomAccessFile` object to read from.
     * @return A new `MarketHours` object populated with data read from the file.
     * @throws IOException If an I/O error occurs while reading from the file.
     */
    public static MarketHours readFromFile(RandomAccessFile file) throws IOException {
        MarketHours market = new MarketHours();
        market.setId(file.readInt());          // Market ID
        market.setDay(file.readUTF());         // Day
        market.setHours(file.readUTF());       // Working Hours
        market.setLocation(file.readUTF());    // Location
        return market;
    }

}
