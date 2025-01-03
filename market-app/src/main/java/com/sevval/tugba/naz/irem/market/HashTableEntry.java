/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of a hash table entry for managing key-value pairs and collision handling.
 */
package com.sevval.tugba.naz.irem.market;


/**
 * @class HashTableEntry
 * @brief Represents an entry in a hash table.
 * @details The `HashTableEntry` class encapsulates the key and occupancy status of a hash table entry. It is used to store
 *          and manage individual entries within a hash table, supporting collision resolution strategies.
 */
public class HashTableEntry {
	/**
     * @var key
     * @brief The key associated with an entry.
     * @details This variable stores the key value used in hash table operations or other data structures.
     */
    private int key;
    
    /**
     * @var isOccupied
     * @brief Indicates whether an entry is occupied.
     * @details This boolean variable tracks whether the current entry in a hash table or similar data structure is occupied.
     *          It helps manage empty or deleted slots during operations like insertion or deletion.
     */
    private boolean isOccupied;

    
    /**
     * @brief Default constructor for the `HashTableEntry` class.
     * @details Initializes the entry with a default key value of -1 and sets the occupancy status to `false`.
     */
    public HashTableEntry() {
        this.key = -1;
        this.isOccupied = false;
    }

    
    /**
     * @brief Parameterized constructor for the `HashTableEntry` class.
     * @details Initializes the entry with the specified key and occupancy status.
     * @param isOccupied A boolean indicating whether the entry is occupied.
     * @param key The key associated with the entry.
     */
    public HashTableEntry(boolean isOccupied, int key) {
        this.isOccupied = isOccupied;
        this.key = key;
    }

    /**
     * @brief Retrieves the key associated with the hash table entry.
     * @return The key value.
     */
    public int getKey() {
        return key;
    }

    
    /**
     * @brief Sets the key associated with the hash table entry.
     * @param key The key value to set.
     */
    public void setKey(int key) {
        this.key = key;
    }

    
    /**
     * @brief Checks if the hash table entry is occupied.
     * @return `true` if the entry is occupied; otherwise, `false`.
     */
    public boolean isOccupied() {
        return isOccupied;
    }

    
    /**
     * @brief Sets the occupancy status of the hash table entry.
     * @param occupied A boolean indicating the occupancy status to set.
     */
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    /**
     * @brief Converts the hash table entry to a readable string format.
     * @details Provides a string representation of the key and occupancy status of the entry.
     * @return A string containing the key and occupancy status.
     */
    @Override
    public String toString() {
        return "Key: " + key + ", Is Occupied: " + isOccupied;
    }
}
