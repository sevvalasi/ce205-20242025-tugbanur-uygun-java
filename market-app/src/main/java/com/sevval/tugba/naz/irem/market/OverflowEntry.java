/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of an overflow entry for handling collision resolution in hash tables.
 */

package com.sevval.tugba.naz.irem.market;


/**
 * @class OverflowEntry
 * @brief Represents an entry in the overflow area for hash table collision resolution.
 * @details This class is used to manage overflow entries in a hash table, storing whether the entry is occupied 
 *          and the associated key.
 */
public class OverflowEntry {
    private boolean isOccupied;   ///< Indicates whether the entry is occupied.
    private int key;              ///< The key associated with this overflow entry.
 
    
    /**
     * @brief Default constructor for the `OverflowEntry` class.
     * @details Initializes an overflow entry with default values. The entry is set to unoccupied and the key is set to -1.
     */
    public OverflowEntry() {
        this.isOccupied = false;
        this.key = -1;
    }

    
    /**
     * @brief Parameterized constructor for the `OverflowEntry` class.
     * @details Initializes an overflow entry with the specified occupancy status and key value.
     * @param isOccupied A boolean indicating whether the entry is occupied.
     * @param key The key associated with the entry.
     */
    public OverflowEntry(boolean isOccupied, int key) {
        this.isOccupied = isOccupied;
        this.key = key;
    }

    
    /**
     * @brief Checks whether the entry is occupied.
     * @return `true` if the entry is occupied; otherwise, `false`.
     */
    public boolean isOccupied() {
        return isOccupied;
    }

    
    /**
     * @brief Sets the occupancy status of the entry.
     * @param occupied A boolean indicating the occupancy status to set.
     */
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    
    /**
     * @brief Retrieves the key associated with the entry.
     * @return The key value.
     */
    public int getKey() {
        return key;
    }

    /**
     * @brief Sets the key associated with the entry.
     * @param key The key value to set.
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * @brief Converts the overflow entry to a readable string format.
     * @details Provides a string representation of the key and occupancy status of the entry.
     * @return A string containing the key and occupancy status.
     */
    @Override
    public String toString() {
        return "Key: " + key + ", Is Occupied: " + isOccupied;
    }
}
