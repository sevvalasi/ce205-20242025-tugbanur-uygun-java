/**
 * @file Market.java
 * @brief Demonstration file for the Market class.
 * @details Contains the implementation of the Market class and its related functionalities.
 */

/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package for the Market application.
 * @details Includes all the classes and utilities required for the Market App.
 */

package com.sevval.tugba.naz.irem.market;

/**
 * @import java.util.Scanner
 * @brief Used for obtaining user input from the console.
 * @details Provides methods to read different types of input such as strings, integers, and doubles.
 */
import java.util.Scanner;

/**
 * @import java.util.Set
 * @brief Represents a collection of unique elements.
 * @details Commonly used for ensuring that a group of elements contains no duplicates.
 */
import java.util.Set;

/**
 * @import static java.lang.System.out
 * @brief Provides a shorthand for System.out for printing output to the console.
 * @details Simplifies calls to `System.out.println` by directly using `out.println`.
 */
import static java.lang.System.out;

/**
 * @import java.io.BufferedReader
 * @brief Reads text from a character input stream efficiently.
 * @details Often used for reading lines of text from a file or user input.
 */
import java.io.BufferedReader;

/**
 * @import java.io.DataOutputStream
 * @brief Writes primitive data types to an output stream in a machine-independent way.
 * @details Useful for writing data in binary format.
 */

import java.io.DataOutputStream;

/**
 * @import java.io.EOFException
 * @brief Signals that the end of a file or stream has been reached unexpectedly.
 * @details Often used in conjunction with file input streams to handle end-of-file scenarios.
 */
import java.io.EOFException;

/**
 * @import java.io.File
 * @brief Represents file and directory pathnames.
 * @details Provides methods for file creation, deletion, and metadata access.
 */
import java.io.File;

/**
 * @import java.io.FileNotFoundException
 * @brief Signals that an attempt to open a file has failed.
 * @details Often thrown by file input/output operations.
 */
import java.io.FileNotFoundException;

/**
 * @import java.io.FileOutputStream
 * @brief Writes raw byte data to a file.
 * @details Useful for writing binary files or streams.
 */
import java.io.FileOutputStream;

/**
 * @import java.io.IOException
 * @brief Signals that an I/O operation has failed or been interrupted.
 * @details This is a general exception for input/output errors.
 */
import java.io.IOException;

/**
 * @import java.io.PrintStream
 * @brief Outputs data to a stream.
 * @details Can print representations of objects, strings, and primitive data types.
 */
import java.io.PrintStream;

/**
 * @import java.util.Random
 * @brief Provides methods to generate pseudo-random numbers.
 * @details Can be used for creating random integers, doubles, and other data types.
 */
import java.util.Random;

/**
 * @import java.io.RandomAccessFile
 * @brief Supports reading and writing to a random access file.
 * @details Allows file pointer manipulation to read or write at arbitrary locations.
 */
import java.io.RandomAccessFile;

/**
 * @import java.nio.charset.StandardCharsets
 * @brief Provides constants for standard charsets.
 * @details Includes charsets like UTF-8, UTF-16, and ISO-8859-1.
 */
import java.nio.charset.StandardCharsets;

/**
 * @import java.util.Arrays
 * @brief Contains utility methods for manipulating arrays.
 * @details Includes methods for sorting, searching, and comparing arrays.
 */

import java.util.Arrays;

/**
 * @import java.util.HashMap
 * @brief Implements the Map interface using a hash table.
 * @details Provides efficient key-value pair storage and retrieval.
 */
import java.util.HashMap;

/**
 * @import java.util.HashSet
 * @brief Implements the Set interface using a hash table.
 * @details Ensures no duplicate elements and provides efficient lookup.
 */
import java.util.HashSet;

/**
 * @import java.util.LinkedList
 * @brief Implements a doubly-linked list.
 * @details Supports both list and queue operations.
 */
import java.util.LinkedList;

/**
 * @import java.util.Queue
 * @brief Represents a collection designed for holding elements prior to processing.
 * @details Typically supports FIFO (first-in-first-out) operations.
 */
import java.util.Queue;

/**
 * @import java.util.Stack
 * @brief Implements a last-in-first-out (LIFO) stack of objects.
 * @details Provides methods for pushing, popping, and peeking at elements.
 */
import java.util.Stack;

/**
 * @import java.util.ArrayList
 * @brief Implements a resizable array.
 * @details Provides dynamic storage for elements with random access.
 */
import java.util.ArrayList;

/**
 * @import java.util.List
 * @brief Represents an ordered collection of elements.
 * @details Lists allow duplicate elements and provide positional access.
 */
import java.util.List;

/**
 * @import java.util.Map
 * @brief Represents a collection of key-value pairs.
 * @details Allows for efficient data lookup by key.
 */
import java.util.Map;

/**
 * @import java.util.Comparator
 * @brief Defines a comparison function for ordering objects.
 * @details Commonly used for sorting and custom ordering of collections.
 */
import java.util.Comparator;

/**
 * @class Market
 * @brief Represents a Market that performs mathematical operations and provides utility functions.
 * @details The Market class includes methods for mathematical operations and utility functions such as clearing the screen and user input handling.
 * @note This class is designed for demonstration purposes and includes a placeholder for clear screen functionality.
 * @author Sevval Asi - Tugba Nur Uygun - Durdane Naz Babaoglu - Irem Acinan
 * @date 02-01-2025
 */
public class Market {
	
	/**
     * @var top
     * @brief Represents the top of the stack.
     * @details Used to manage a stack-based data structure within the Market class.
     */
    public StackNode top;
    
    /**
     * @var scanner
     * @brief A static Scanner object for reading user input.
     * @details Shared across the class to handle console input operations.
     */
	public static Scanner scanner;
	
	/**
     * @var out
     * @brief A static PrintStream object for printing output to the console.
     * @details Shared across the class to handle console output operations.
     */
    public static PrintStream out;
    
    /**
     * @brief Constructor for the Market class.
     * @details Initializes the Market class with user-provided Scanner and PrintStream objects.
     * @param scanner A Scanner object for reading user input.
     * @param out A PrintStream object for printing output to the console.
     */
    public Market(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }
    
    /**
     * @var isAuthenticated
     * @brief A static flag indicating authentication status.
     * @details Used to manage access control for certain functionalities.
     * @note This flag is currently set to `false` by default.
     */
    private static boolean isAuthenticated = false;
    
    /**
     * @brief Clears the console screen.
     * @details Sends escape sequences to the console to clear the screen.
     * @note This is a placeholder and may behave differently depending on the platform.
     */
    private static void clearScreen() {
        // This is just a placeholder for clear screen in Java since it's platform-dependent
        out.print("\033[H\033[2J");
        out.flush();
    }
    
    /**
     * @brief Reads an integer input from the user.
     * @details Continuously prompts the user until a valid integer is entered.
     * @return The integer value entered by the user.
     * @note Provides validation to ensure the input is an integer.
     */
    private static int getInput() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            out.println("Invalid input. Please enter a valid number.");
        }
        return scanner.nextInt();
    }

    /**
     * @brief Handles user authentication and account management.
     * @details Provides options for users to log in, register, use guest mode, or exit the application.
     * @return `true` if the user chooses to exit the program; otherwise, continues to prompt for input.
     */
    public static boolean userAuthentication() {

        int choice;

        do {
        	clearScreen();
            out.println("==========================================");
            out.println("|           User Authentication          |");
            out.println("==========================================");
            out.println("| 1. Login                               |");
            out.println("| 2. Register                            |");
            out.println("| 3. Guest Mode                          |");
            out.println("| 4. Exit                                |");
            out.println("==========================================");
            out.print("Choose an option: ");
            choice = getInput();

            switch (choice) {
                case 1:
                	/**
                     * @brief Handles user login.
                     * @details Prompts the user to enter credentials and validates them. On success, navigates to the main menu.
                     */
                    if (loginUser()) 
                	{
                        mainMenu();
                    }
                    break;
                case 2:
                	/**
                     * @brief Handles user registration.
                     * @details Collects user details, registers the user, and sets `isAuthenticated` to `true`.
                     */
                    registerUser();
                   isAuthenticated = true;
                    break;
                case 3:
                	/**
                     * @brief Provides guest access to the application.
                     * @details Allows users to access the main menu without authentication.
                     */
                    mainMenu();
                    break;
                case 4:
                    out.println("Exiting the program...");
                    return true;
                default:
                    out.println("Invalid option. Please try again.");
                    scanner.nextLine(); // Clear buffer
                    break;
            }
    
        }     while (choice != 4);
        
        return true ; 
}

    /**
     * @brief Displays the main menu and handles user navigation.
     * @details Provides various options for users, such as viewing local vendors, products, price comparison, and more.
     * @return `true` when the user chooses to exit the main menu.
     */
	    public static boolean mainMenu() {

	        int choice;


	        do {
	        	clearScreen();
	        	out.println("==========================================\n");
	            out.println("|               Main Menu                |\n");
	            out.println("==========================================\n");
	            out.println("| 1. Listing of Local Vendors            |\n");
	            out.println("| 2. Listing of Local Products           |\n");
	            out.println("| 3. Price Comparison                    |\n");
	            out.println("| 4. Market Hours and Locations          |\n");
	            out.println("| 5. Search Products or Enter Keywords   |\n");
	            out.println("| 0. Exit                                |\n");
	            out.println("==========================================\n");
	            out.print("Choose an option: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                	/**
	                     * @brief Navigates to the local vendors listing menu.
	                     * @details Provides options to add, update, delete, or view vendors.
	                     */
	                    listingOfLocalVendors();
	                    break;
	                case 2:
	                	/**
	                     * @brief Navigates to the local products listing menu.
	                     * @details Provides options to add, update, delete, or view products.
	                     */
	                    listingOfLocalProducts();
	                    break;
	                case 3:
	                	/**
	                     * @brief Handles price comparison functionality.
	                     * @details Allows users to compare product prices across vendors.
	                     */
	                    priceComparison();
	                    break;
	                case 4:
	                	/**
	                     * @brief Displays market hours and locations.
	                     * @details Provides information about local market schedules and locations.
	                     */
	                    marketHoursAndLocations();
	                    break;
	                case 5:
	                	/**
	                     * @brief Searches for products based on user input.
	                     * @details Allows users to search for products or enter keywords.
	                     */
	                    searchProductsOrEnterKeyword();
	                    break;
	                case 0:
	                    out.println("Exiting the program...");
	                    break;
	                default:
	                    out.println("Invalid option. Please try again.");
	            }
	        } while (choice != 0);

	        return true;
	    }

	    /**
	     * @brief Displays the menu for managing local vendors.
	     * @details Allows users to add, update, delete, or list vendors.
	     * @return `true` when the user chooses to return to the main menu.
	     */
	    public static boolean listingOfLocalVendors() {

	        int choice;

	        do {
	        	clearScreen();
	        	 out.println("==========================================\n");
	        	 out.println("|     Listing of Local Vendors           |\n");
	        	 out.println("==========================================\n");
	        	 out.println("| 1. Add Vendor                          |\n");
	        	 out.println("| 2. Update Vendor                       |\n");
	        	 out.println("| 3. Delete Vendor                       |\n");
	        	 out.println("| 4. List Vendors                        |\n");
	        	 out.println("| 0. Return to Main Menu                 |\n");
	        	 out.println("==========================================\n");
	            out.print("Choose an option: ");
	            choice = getInput();
	        
	            switch (choice) {
	                case 1:
	                	/**
	                     * @brief Adds a new vendor to the list.
	                     * @details Collects vendor details and adds them to the database.
	                     */
	                    addVendor();
	                    break;
	                case 2:
	                	/**
	                     * @brief Updates an existing vendor's information.
	                     * @details Prompts the user for vendor details to modify.
	                     */
	                    updateVendor();
	                    break;
	                case 3:
	                	/**
	                     * @brief Deletes a vendor from the list.
	                     * @details Removes a vendor based on user selection.
	                     */
	                    deleteVendor();
	                    break;
	                case 4:
	                	/**
	                     * @brief Displays the list of all vendors.
	                     * @details Provides detailed information about each vendor.
	                     */
	                    listVendors();
	                    break;
	                case 0:
	                    out.println("Returning to main menu...");
	                    break;
	                default:
	                    out.println("Invalid option. Please try again.");
	            }
	        } while (choice != 0);

	        return true;
	    }
	    
	    /**
	     * @brief Displays the menu for managing local products.
	     * @details Allows users to add, update, delete, or list products.
	     * @return `true` when the user chooses to return to the main menu.
	     */
		public static boolean listingOfLocalProducts() {
	        int choice;

	        do {
	        	clearScreen();
	        	 out.println("==========================================\n");
	        	 out.println("|           List All Products            |\n");
	        	 out.println("==========================================\n");
	        	 out.println("| 1. Add Product                         |\n");
	        	 out.println("| 2. Update Product                      |\n");
	        	 out.println("| 3. Delete Product                      |\n");
	        	 out.println("| 4. Listing of Local Products           |\n");
	        	 out.println("| 0. Return to Main Menu                 |\n");
	        	 out.println("==========================================\n");
	            out.print("Choose an option: ");
	            choice = getInput();

	            switch (choice) {
	                case 1:
	                	/**
	                     * @brief Adds a new product to the list.
	                     * @details Collects product details and adds them to the database.
	                     */
	                    addProduct();
	                    break;
	                case 2:
	                	/**
	                     * @brief Updates an existing product's information.
	                     * @details Prompts the user for product details to modify.
	                     */
	                    updateProduct();
	                    break;
	                case 3:
	                	/**
	                     * @brief Deletes a product from the list.
	                     * @details Removes a product based on user selection.
	                     */
	                    deleteProduct();
	                    break;
	                case 4:
	                	/**
	                     * @brief Displays the list of all products.
	                     * @details Provides detailed information about each product.
	                     */
	                    listingOfLocalVendorsandProducts();
	                    break;
	                case 0:
	                    out.println("Returning to main menu...");
	                    break;
	                default:
	                    out.println("Invalid option. Please try again.");
	                    break;
	            }

	        } while (choice != 0);

	        return true;
	    }
		
		/**
		 * @brief Authenticates a user by checking credentials from a Huffman-encoded file.
		 * @details Reads a Huffman-encoded file (`users.huff`) containing usernames and passwords to validate the provided credentials.
		 *          The file is read sequentially, and each username-password pair is checked against the input.
		 * @param username The username provided by the user.
		 * @param password The password provided by the user.
		 * @return `true` if the credentials match a username-password pair in the file; otherwise, `false`.
		 * @note The file must exist and be in the expected format (length-prefixed username and password pairs).
		 * @throws IOException If there is an error reading the file (silently handled in the code).
		 */
		 public static boolean loginUserFromHuffFile(String username, String password) {
		        try (RandomAccessFile file = new RandomAccessFile("users.huff", "r")) {
		            while (true) {
		                try {
		                    // Read username length and username
		                    int usernameLength = file.readInt();

		                    byte[] fileUsername = new byte[usernameLength];
		                    file.readFully(fileUsername);
		                    String readUsername = new String(fileUsername);

		                    // Read password length and password
		                    int passwordLength = file.readInt();

		                    byte[] filePassword = new byte[passwordLength];
		                    file.readFully(filePassword);
		                    String readPassword = new String(filePassword);

		                    // Check if the credentials match
		                    if (username.equals(readUsername) && password.equals(readPassword)) {
		                        return true;
		                    }
		                } catch (EOFException eof) {
		                    break;  // End of file reached
		                }
		            }
		        } catch (IOException e) {
		        	// Handle exceptions silently

		        }
		        return false;
		    }

		 /**
		  * @brief Handles user login by collecting input and validating credentials.
		  * @details Prompts the user to enter a username and password, validates them against stored credentials using the 
		  *          `loginUserFromHuffFile` method, and provides feedback on success or failure.
		  * @return `true` if the login is successful; otherwise, `false`.
		  * @note This method ensures that neither the username nor the password is empty by repeatedly prompting the user until valid input is provided.
		  * @see loginUserFromHuffFile(String username, String password)
		  */
	public static boolean loginUser() {
		String username;
		String password;

		// Username validation
		do {
			out.print("Username: ");
			username = scanner.nextLine();
			if (username.trim().isEmpty()) {
				out.println("Username cannot be empty. Please enter a valid username.");
			}
		} while (username.trim().isEmpty()); // Prompt until a non-empty username is entered

		// Password validation
		do {
			out.print("Password: ");
			password = scanner.nextLine();
			if (password.trim().isEmpty()) {
				out.println("Password cannot be empty. Please enter a valid password.");
			}
		} while (password.trim().isEmpty()); // Prompt until a non-empty password is entered

		// Validate credentials
		if (loginUserFromHuffFile(username, password)) {
			out.printf("Login successful. Welcome! %s.\n", username);
			return true;
		} else {
			out.println("Incorrect username or password.");
			return false;
		}
	}


//	public static boolean saveUserToHuffFile(String username, int passwordHash) {
//		try (RandomAccessFile file = new RandomAccessFile("users.huff", "rw")) {
//			file.seek(file.length());  // Move to the end of the file
//			byte[] usernameBytes = username.getBytes();
//			file.writeInt(usernameBytes.length);
//			file.write(usernameBytes);
//			file.writeInt(passwordHash);
//			return true;
//		} catch (IOException e) {
//			System.err.println("Error opening file: " + e.getMessage());
//			return false;
//		}
//	}


	/**
	 * @brief Registers a new user by collecting username and password.
	 * @details This method collects a username and password from the user, ensures they are not empty, and saves the credentials 
	 *          in both a binary file (`users.bin`) and a Huffman-encoded file (`users.huff`).
	 * @return `true` if the registration process is successful; otherwise, `false`.
	 * @note Ensures that both username and password are validated before saving them to the files.
	 * @see saveUserToHuffFile(String username, String password)
	 */
	public static boolean registerUser() {
		
		clearScreen(); // Clear the screen

		// Create a User class to hold user information
		class User {
			String username;
			String password;
		}

		User user = new User();

		// Validate and collect username
		do {
			out.print("Username: ");
			user.username = scanner.nextLine();
			if (user.username.trim().isEmpty()) {
				out.println("Username cannot be empty. Please enter a valid username.");
			}
		} while (user.username.trim().isEmpty()); // Username boş ise tekrar sor

		// Validate and collect password
		do {
			out.print("Password: ");
			user.password = scanner.nextLine();
			if (user.password.trim().isEmpty()) {
				out.println("Password cannot be empty. Please enter a valid password.");
			}
		} while (user.password.trim().isEmpty());

		// Save user data to a binary file
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("users.bin", true))) {
			dos.writeUTF(user.username); // Save username
			dos.writeUTF(user.password); // Save password
		} catch (IOException e) {

		}

		// Save user data to a Huffman-encoded file
		if (!saveUserToHuffFile(user.username, user.password)) {
			out.println("Failed to save user to .huff file.");
			return false;
		}

		// Successful registration message
		out.println("Register is successful!");
		out.println("Press Enter to continue...");
		try {
			scanner.nextLine(); // Wait for user to press Enter
		} catch (Exception e) {

		}
		return true;
	}

	/**
	 * @brief Saves a user's credentials to a Huffman-encoded file.
	 * @details Appends the username and password to the end of the file (`users.huff`) with length-prefixed encoding for efficient retrieval.
	 * @param username The username to be saved.
	 * @param password The password to be saved.
	 * @return `true` if the user is successfully saved to the file; otherwise, `false`.
	 * @throws IOException If there is an error opening or writing to the file (handled within the method).
	 * @note This method assumes that the file is writable and appends data without overwriting existing content.
	 */
	public static boolean saveUserToHuffFile(String username, String password) {
		        try (RandomAccessFile file = new RandomAccessFile("users.huff", "rw")) {
		            file.seek(file.length());  // Move to the end of the file
		            file.writeInt(username.length()); // Write username length
		            file.write(username.getBytes());  // Write username
		            file.writeInt(password.length()); // Write password length
		            file.write(password.getBytes());  // Write password
		            return true;
		        } catch (IOException e) {
		            System.err.println("Error opening file: " + e.getMessage());
		            return false;
		        }
		    }


	/**
	 * @brief Adds a new vendor to the vendor file.
	 * @details Generates a random vendor ID, collects the vendor name from the user, and appends the data to a binary file (`vendor.bin`).
	 * @throws IOException If there is an error writing to the file.
	 */
	public static void addVendor() {
		Random random = new Random();

		File file = new File("vendor.bin");

		try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
			raf.seek(raf.length()); 

			int vendorId = 100000 + random.nextInt(900000); 
			System.out.println("Assigned Vendor ID: " + vendorId);

			String vendorName;
			do {
				System.out.print("Enter Vendor Name: ");
				vendorName = scanner.nextLine();
				if (vendorName.trim().isEmpty()) {
					System.out.println("Vendor Name cannot be empty. Please enter a valid name.");
				}
			} while (vendorName.trim().isEmpty()); 

			raf.writeInt(vendorId); 
			raf.writeUTF(vendorName);

			System.out.println("Vendor added successfully!");
		} catch (IOException e) {

		}
	}

	/**
	 * @brief Updates the name of an existing vendor.
	 * @details Searches for a vendor by name in the binary file (`vendor.bin`) and allows the user to update its name.
	 * @throws IOException If there is an error reading or writing to the file.
	 */
	public static void updateVendor() {
		File file = new File("vendor.bin");

		try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
			String vendorNameToUpdate;
			while (true) {
				System.out.print("Enter Vendor Name to update: ");
				vendorNameToUpdate = scanner.nextLine().trim();
				if (!vendorNameToUpdate.isEmpty()) {
					break;
				} else {
					System.out.println("Vendor Name cannot be empty. Please enter a valid name.");
				}
			}

			boolean isUpdated = false;
			while (raf.getFilePointer() < raf.length()) { 
				long recordPosition = raf.getFilePointer();
				int vendorId = raf.readInt(); 
				String vendorName = raf.readUTF();

				if (vendorName.equalsIgnoreCase(vendorNameToUpdate)) { 
					String newVendorName;
					do {
						System.out.print("Enter new Vendor Name: ");
						newVendorName = scanner.nextLine().trim();
						if (newVendorName.isEmpty()) {
							System.out.println("Vendor Name cannot be empty. Please enter a valid name.");
						}
					} while (newVendorName.isEmpty());

					raf.seek(recordPosition + 4); 
					raf.writeUTF(newVendorName); 
					System.out.println("Vendor updated successfully!");
					isUpdated = true;
					break;
				}
			}

			if (!isUpdated) {
				System.out.println("Vendor Name not found.");
			}
		} catch (IOException e) {

		}
	}

	/**
	 * @brief Deletes a vendor by ID.
	 * @details Removes the vendor with the specified ID from the binary file (`vendor.bin`) by creating a temporary file.
	 * @return `true` if the vendor was successfully deleted; otherwise, `false`.
	 * @throws IOException If there is an error during file operations.
	 */
	public static boolean deleteVendor() {
	        RandomAccessFile raf = null, tempRaf = null;
	        File file = new File("vendor.bin");
	        File tempFile = new File("temp.bin");

	        try {
	            raf = new RandomAccessFile(file, "r");
	            tempRaf = new RandomAccessFile(tempFile, "rw");


	            System.out.print("Enter Vendor ID to delete: ");
	            int id = scanner.nextInt();
	            scanner.nextLine(); // Clear input buffer

	            boolean found = false;
	            while (raf.getFilePointer() < raf.length()) {
	                int vendorId = raf.readInt();
	                String vendorName = raf.readUTF();

	                if (vendorId != id) {
	                    tempRaf.writeInt(vendorId);
	                    tempRaf.writeUTF(vendorName);
	                } else {
	                    found = true;
	                }
	            }

	            raf.close();
	            tempRaf.close();

	            if (!file.delete() || !tempFile.renameTo(file)) {
	                System.out.println("Error updating vendor file.");
	                return false;
	            }

	            if (found) {
	                System.out.println("Vendor deleted successfully!");
	            } else {
	                System.out.println("Vendor with ID " + id + " not found.");
	            }

	            System.out.println("Press Enter to continue...");
	            System.in.read();

	        } catch (IOException e) {

	        } finally {
	            try {
	                if (raf != null) raf.close();
	                if (tempRaf != null) tempRaf.close();
	            } catch (IOException e) {

	            }
	        }
	        return true;
	    }

	/**
	 * @brief Lists all vendors from the vendor file.
	 * @details Reads vendors from the binary file (`vendor.bin`) and displays them using different data structures for traversal.
	 * @return `true` if vendors are successfully listed; otherwise, `false`.
	 * @throws IOException If there is an error reading the file.
	 */
	    public static boolean listVendors() {
	        clearScreen();
	        File file = new File("vendor.bin");
	        if (!file.exists()) {
	            System.out.println("Error opening vendor file.");
	            return false;
	        }

	        Stack<Vendor> vendorStack = new Stack<>();
	        Queue<Vendor> vendorQueue = new LinkedList<>();
	        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

	        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
	            while (raf.getFilePointer() < raf.length()) {
	                int vendorId = raf.readInt();
	                String vendorName = raf.readUTF();
	                Vendor vendor = new Vendor(vendorId, vendorName);
	                if (!isDuplicate(vendorQueue, vendor)) {
	                    vendorQueue.add(vendor);
	                }
	                vendorStack.push(vendor);
	                doubleLinkedList.insertVendor(vendor);
	            }
	        } catch (EOFException e) {
	            
	        } catch (Exception e) {

	        }

	        DoubleLinkedListNode current = doubleLinkedList.getHead();

	        while (current != null) {
	            System.out.printf("ID: %d, Name: %s%n", current.getVendor().getId(), current.getVendor().getName());
	            System.out.print("\n'n' for Next, 'p' for Previous, 's' for Stack traversal, 'q' for Queue traversal, 'x' to Quit: ");
	            String choice = scanner.nextLine().trim();

	            if ("n".equalsIgnoreCase(choice)) {
	                if (current.getNext() != null) {
	                    current = current.getNext();
	                } else {
	                    System.out.println("No more vendors in this direction.");
	                }
	            } else if ("p".equalsIgnoreCase(choice)) {
	                if (current.getPrevious() != null) {
	                    current = current.getPrevious();
	                } else {
	                    System.out.println("No more vendors in this direction.");
	                }
	            } else if ("s".equalsIgnoreCase(choice)) {
	                System.out.println("\n--- Stack Traversal (Last In, First Out) ---");
	                while (!vendorStack.isEmpty()) {
	                    Vendor v = vendorStack.pop();
	                    System.out.printf("ID: %d, Name: %s%n", v.getId(), v.getName());
	                }
	            } else if ("q".equalsIgnoreCase(choice)) {
	                System.out.println("\n--- Queue Traversal (First In, First Out) ---");
	                while (!vendorQueue.isEmpty()) {
	                    Vendor v = vendorQueue.poll();
	                    System.out.printf("ID: %d, Name: %s%n", v.getId(), v.getName());
	                }
	            } else if ("x".equalsIgnoreCase(choice)) {
	                break;
	            } else {
	                System.out.println("Invalid input. Please use 'n', 'p', 's', 'q', or 'x'.");
	            }
	        }

	        System.out.println("Returning to menu...");
	        return true;
	    }

	    /**
	     * @brief Checks if a vendor is a duplicate in the queue.
	     * @details Compares the vendor's ID with the IDs of vendors in the queue to determine duplication.
	     * @param queue The queue of vendors.
	     * @param vendor The vendor to check for duplication.
	     * @return `true` if the vendor is a duplicate; otherwise, `false`.
	     */
	    public static boolean isDuplicate(Queue<Vendor> queue, Vendor vendor) {
	        for (Vendor v : queue) {
	            if (v.getId() == vendor.getId()) {
	           
	                return true;
	            }
	        }
	        return false;
	    }

	    /**
	     * @brief Checks if the stack is empty.
	     * @return `true` if the stack is empty; otherwise, `false`.
	     */
	    public boolean isStackEmpty() {
	        return top == null;
	    }

	    /**
	     * @brief Pushes a vendor onto the stack.
	     * @details Adds a new vendor node to the top of the stack.
	     * @param vendor The vendor to push onto the stack.
	     */
	    public void push(Vendor vendor) {
	        StackNode newNode = new StackNode(vendor);
	        newNode.next = top;
	        top = newNode;
	    }
	    
	  
	    /**
	     * @brief Pops a vendor from the stack.
	     * @details Removes the top vendor node from the stack and returns it.
	     * @return The popped vendor object or an empty vendor object if the stack is empty.
	     */
	    public Vendor pop() {
	        if (isStackEmpty()) {
	            out.println("Stack is empty.");
	            return new Vendor(0, ""); // Return an empty vendor object
	        }
	        Vendor vendor = top.vendor;
	        top = top.next;
	        return vendor;
	    }

	    /**
	     * @brief Frees all nodes in the stack.
	     * @details Removes all vendors from the stack and clears the stack.
	     */
	    public void freeStack() {
	        while (!isStackEmpty()) {
	            pop();
	        }
	    }
	    
	    /**
	     * @brief Adds a new product to the product file.
	     * @details Prompts the user for product details such as name, price, quantity, season, and associated vendor ID.
	     *          Verifies the vendor ID before saving the product to the binary file `products.bin`.
	     * @return `true` if the product is successfully added; otherwise, `false`.
	     * @throws IOException If there is an error writing to the product file.
	     */
	    public static boolean addProduct() {
	        clearScreen();
	        File productFile = new File("products.bin");
	        File vendorFile = new File("vendor.bin");
	        Product product = new Product();
	        boolean found = false;

	        try (RandomAccessFile productRAF = new RandomAccessFile(productFile, "rw");
	             RandomAccessFile vendorRAF = new RandomAccessFile(vendorFile, "r")) {

	            out.print("Enter Vendor ID for the product: ");
	            product.setVendorId(scanner.nextInt());
	            scanner.nextLine(); // Clear buffer

	            // Check Vendor ID
	            while (vendorRAF.getFilePointer() < vendorRAF.length()) {
	                Vendor vendor = new Vendor(0, null);
	                vendor.readFromRandomAccessFile(vendorRAF);
	                if (vendor.getId() == product.getVendorId()) {
	                    found = true;
	                    break;
	                }
	            }

	            if (!found) {
	                out.println("Error: Vendor with ID " + product.getVendorId() + " does not exist.");
	                out.println("Press Enter to continue...");
	                scanner.nextLine();
	                return false;
	            }

	            // Get Product details
	            out.print("Enter Product Name: ");
	            product.setProductName(scanner.nextLine());

	            out.print("Enter Product Price: ");
	            product.setPrice(scanner.nextFloat());
	            scanner.nextLine(); // Clear buffer

	            out.print("Enter Product Quantity: ");
	            product.setQuantity(scanner.nextInt());
	            scanner.nextLine(); // Clear buffer

	            out.print("Enter Product Season: ");
	            product.setSeason(scanner.nextLine());

	            // Append product to file
	            productRAF.seek(productRAF.length());
	            product.writeToFile(productRAF);

	            out.println("Product added successfully!");
	            out.println("Press Enter to continue...");
	            scanner.nextLine();

	        } catch (IOException e) {

	        }

	        return true;
	    }

	    /**
	     * @brief Updates an existing product in the product file.
	     * @details Searches for a product by name and allows the user to modify its details. Saves the updated product to a temporary file.
	     * @return `true` if the product is successfully updated; otherwise, `false`.
	     * @throws IOException If there is an error reading or writing to the product file.
	     */
	public static boolean updateProduct() {
		clearScreen();
		File productFile = new File("products.bin");
		File tempFile = new File("temp.bin");
		boolean found = false;

		if (!productFile.exists()) {
			System.out.println("Error: Product file not found.");
			return false;
		}

		try (RandomAccessFile productRAF = new RandomAccessFile(productFile, "r");
			 RandomAccessFile tempRAF = new RandomAccessFile(tempFile, "rw")) {

			String productName = "";
			while (productName.isEmpty()) {
				System.out.print("Enter Product Name to update: ");
				productName = scanner.nextLine().trim();
				if (productName.isEmpty()) {
					System.out.println("No product name entered. Please enter a valid product name.");
				}
			}

			while (productRAF.getFilePointer() < productRAF.length()) {
				Product product = new Product();
				product.readFromFile(productRAF);

				if (product.getProductName().equalsIgnoreCase(productName)) {
					found = true;

					// Update product details
					System.out.print("Enter new Product Name: ");
					product.setProductName(scanner.nextLine().trim());
					System.out.print("Enter new Product Price: ");
					product.setPrice(scanner.nextDouble());
					scanner.nextLine(); 
					System.out.print("Enter new Product Quantity: ");
					product.setQuantity(scanner.nextInt());
					scanner.nextLine(); 
					System.out.print("Enter new Product Season: ");
					product.setSeason(scanner.nextLine().trim());
				}

				product.writeToFile(tempRAF);
			}

			if (!found) {
				System.out.println("Product with name '" + productName + "' not found.");
				tempFile.delete();
			} else {
				productRAF.close();
				tempRAF.close(); 


				System.out.println("Product updated successfully!");
			}

		} catch (IOException e) {

		}

		System.out.println("Press Enter to continue...");
		scanner.nextLine();
		return true;
	}

	/**
	 * @brief Deletes a product from the product file.
	 * @details Prompts the user for a product name, removes the matching product from the file, and updates the file with the remaining products.
	 * @return `true` if the product is successfully deleted; otherwise, `false`.
	 * @throws IOException If there is an error during file operations.
	 */
	public static boolean deleteProduct() {
	        clearScreen();
	        File productFile = new File("products.bin");
	        File tempFile = new File("temp.bin");
	        boolean found = false;


	        try (RandomAccessFile productRAF = new RandomAccessFile(productFile, "r");
	             RandomAccessFile tempRAF = new RandomAccessFile(tempFile, "rw")) {

	            String productName = "";
	            while (productName.isEmpty()) {
	                System.out.print("Enter Product Name to delete: ");
	                productName = scanner.nextLine().trim();
	                if (productName.isEmpty()) {
	                    System.out.println("No product name entered. Please enter a valid product name.");
	                }
	            }

	            while (productRAF.getFilePointer() < productRAF.length()) {
	                Product product = new Product();
	                product.readFromFile(productRAF);

	                if (product.getProductName().equalsIgnoreCase(productName)) {
	                    found = true;
	                    System.out.println("Product with name '" + productName + "' deleted successfully!");
	                    continue;
	                }

	                product.writeToFile(tempRAF);
	            }

	            if (!found) {
	                System.out.println("Product with name '" + productName + "' not found.");
	                tempFile.delete();
	//            } else {
	//                if (productFile.delete() && tempFile.renameTo(productFile)) {
	//                    System.out.println("Product deleted successfully!");
	//               } else {
	//                  System.out.println("Error updating the product file.");
	//             }
	            }

	        } catch (IOException e) {

	        }

	        System.out.println("Press Enter to continue...");
	        scanner.nextLine();
	        return true;
	    }
	    
	    static final int MAX_VENDORS = 100;
	    static final int MAX_PRODUCTS = 100;
	    static final int TABLE_SIZE = 100;
	    static final int OVERFLOW_SIZE = 50;

	    static SparseMatrixEntry[] sparseMatrix = new SparseMatrixEntry[MAX_VENDORS * MAX_PRODUCTS];
	    static int sparseMatrixSize = 0;

	    static HashTableEntry[] hashTable = new HashTableEntry[TABLE_SIZE];
	    static Bucket[] hashTableBuckets = new Bucket[TABLE_SIZE];
	    static OverflowEntry[] overflowArea = new OverflowEntry[OVERFLOW_SIZE];
	    
	    
	    /**
	     * @brief Lists all vendors and their associated products.
	     * @details Displays vendors and their products, allowing the user to choose a collision resolution strategy for listing.
	     * @return `true` if the listing operation completes successfully.
	     * @throws IOException If there is an error reading the files.
	     */
	    public static boolean listingOfLocalVendorsandProducts() {
	        File productFile = new File("products.bin");
	        File vendorFile = new File("vendor.bin");


	        try (RandomAccessFile productRAF = new RandomAccessFile(productFile, "r");
	             RandomAccessFile vendorRAF = new RandomAccessFile(vendorFile, "r")) {

	            System.out.println("\n--- Listing All Vendors and Their Products ---\n");

	            System.out.println("Select Collision Resolution Strategy for All Vendors:");
	            System.out.println("1. Linear Probing");
	            System.out.println("2. Quadratic Probing");
	            System.out.println("3. Double Hashing");
	            System.out.println("4. Linear Quotient");
	            System.out.println("5. Progressive Overflow");
	            System.out.println("6. Use of Buckets");
	            System.out.println("7. Brent's Method");
	            System.out.println("8. Exit");

	            int strategy = new java.util.Scanner(System.in).nextInt();

	            if (strategy == 8) {System.out.println("Exiting the product list");return true;}

	            boolean found = false;
	            while (vendorRAF.getFilePointer() < vendorRAF.length()) {
	                Vendor vendor = new Vendor();
	                vendor.readFromRandomAccessFile(vendorRAF);

	                System.out.println("\nVendor: " + vendor.getName() + " (ID: " + vendor.getId() + ")\n");
	                System.out.println("--------------------------\n");

	                boolean productFound = false;
	                productRAF.seek(0);

	                while (productRAF.getFilePointer() < productRAF.length()) {
	                    Product product = new Product();
	                    product.readFromFile(productRAF);

	                    if (product.getVendorId() == vendor.getId() && product.getPrice() != 0 && product.getQuantity() != 0) {
	                        switch (strategy) {
	                            case 1:
	                                System.out.println("Using Linear Probing for Product: " + product.getProductName());
	                                break;
	                            case 2:
	                                System.out.println("Using Quadratic Probing for Product: " + product.getProductName());
	                                break;
	                            case 3:
	                                System.out.println("Using Double Hashing for Product: " + product.getProductName());
	                                break;
	                            case 4:
	                                System.out.println("Using Linear Quotient for Product: " + product.getProductName());
	                                break;
	                            case 5:
	                                System.out.println("Using Progressive Overflow for Product: " + product.getProductName());
	                                break;
	                            case 6:
	                                System.out.println("Using Use of Buckets for Product: " + product.getProductName());
	                                break;
	                            case 7:
	                                System.out.println("Using Brent's Method for Product: " + product.getProductName());
	                                break;
	                            default:
	                                System.out.println("Invalid strategy selected.");
	                                return false;
	                        }
	                        System.out.println("Product: " + product.getProductName() + ", Price: " + product.getPrice() + ", Quantity: " + product.getQuantity() + ", Season: " + product.getSeason());
	                        productFound = true;
	                        found = true;
	                    }
	                }
	                if (!productFound) {
	                    System.out.println("No products available for this vendor.");
	                }
	            }

	            if (!found) {
	                System.out.println("No products found for any vendor.");
	            }

	        } catch (IOException e) {

	        }

	        System.out.println("\nPress Enter to return to menu...");
	        try {
	            System.in.read();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return true;
	    }

	    /**
	     * @brief Adds a vendor-product relationship to a sparse matrix.
	     * @details Records the vendor ID, product ID, and price in the sparse matrix for efficient access.
	     * @param vendorId The ID of the vendor.
	     * @param productId The ID of the product.
	     * @param price The price of the product.
	     */
	    public static void addVendorProductRelation(int vendorId, int productId, float price) {
	        if (price == 0) return;
	        sparseMatrix[sparseMatrixSize] = new SparseMatrixEntry(vendorId, productId, price);
	        sparseMatrixSize++;
	    }

	    /**
	     * @brief Lists all products offered by a specific vendor.
	     * @details Searches the sparse matrix for products associated with the given vendor ID and displays them.
	     * @param vendorId The ID of the vendor.
	     * @return `true` if the operation completes successfully.
	     */
	    public static boolean listProductsByVendor(int vendorId) {
	        System.out.println("\n--- Products offered by Vendor " + vendorId + " ---");
	        boolean found = false;
	        for (int i = 0; i < sparseMatrixSize; i++) {
	            if (sparseMatrix[i].getVendorId() == vendorId) {
	                System.out.printf("Product ID: %d, Price: %.2f\n", sparseMatrix[i].getProductId(), sparseMatrix[i].getPrice());
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No products found for Vendor " + vendorId + ".");
	        }
	        return true;
	    }

	    /**
	     * @brief Computes the hash value for a given key.
	     * @param key The key to hash.
	     * @return The computed hash value.
	     */
	    public static int hashFunction(int key) {
	        return key % TABLE_SIZE;
	    }

	    /**
	     * @brief Initializes the hash table and overflow area.
	     * @details Resets all hash table and bucket entries, and clears the overflow area.
	     */
	    public static void initializeHashTable() {
	        for (int i = 0; i < TABLE_SIZE; i++) {
	            hashTable[i] = new HashTableEntry(false, 0);
	            hashTableBuckets[i] = new Bucket();
	        }
	        for (int i = 0; i < OVERFLOW_SIZE; i++) {
	            overflowArea[i] = new OverflowEntry(false, 0);
	        }
	    }

	    /**
	     * @brief Resolves hash collisions using linear probing.
	     * @param key The key to hash.
	     * @param i The probe number.
	     * @return The computed index after probing.
	     */
	    public static int linearProbing(int key, int i) {
	        return (key + i) % TABLE_SIZE;
	    }

	    /**
	     * @brief Resolves hash collisions using quadratic probing.
	     * @param key The key to hash.
	     * @param i The probe number.
	     * @return The computed index after probing.
	     */
	    public static int quadraticProbing(int key, int i) {
	        return (key + i * i) % TABLE_SIZE;
	    }

	    /**
	     * @brief Resolves hash collisions using double hashing.
	     * @param key The key to hash.
	     * @param i The probe number.
	     * @return The computed index after probing.
	     */
	    public static int doubleHashing(int key, int i) {
	        int h1 = key % TABLE_SIZE;
	        int h2 = 1 + (key % (TABLE_SIZE - 1));
	        return (h1 + i * h2) % TABLE_SIZE;
	    }

	    /**
	     * @brief Resolves hash collisions using linear quotient.
	     * @param key The key to hash.
	     * @param i The probe number.
	     * @return The computed index after probing.
	     */
	    public static int linearQuotient(int key, int i) {
	        return (key + i * 7) % TABLE_SIZE;
	    }

	    /**
	     * @brief Searches for a key in the progressive overflow area.
	     * @param key The key to search for.
	     * @return `true` if the key is found; otherwise, `false`.
	     */
	    public static boolean progressiveOverflowSearch(int key) {
	        for (int i = 0; i < OVERFLOW_SIZE; i++) {
	            if (overflowArea[i].isOccupied() && overflowArea[i].getKey() == key) {
	                return true;
	            }
	        }
	        return false;
	    }

	    /**
	     * @brief Searches for a key using buckets.
	     * @param key The key to search for.
	     * @return `true` if the key is found; otherwise, `false`.
	     */
	    public static boolean useOfBucketsSearch(int key) {
	        int index = hashFunction(key);
	        for (Product product : hashTableBuckets[index].product) {
	            if (product.getVendorId() == key) {
	                return true;
	            }
	        }
	        return false;
	    }

	    /**
	     * @brief Searches for a key using Brent's method.
	     * @param key The key to search for.
	     * @return The index of the key if found; otherwise, `-1`.
	     */
	    public static int brentsMethodSearch(int key) {
	        int index = hashFunction(key);
	        int i = 0;
	        while (hashTable[index].isOccupied()) {
	            if (hashTable[index].getKey() == key) {
	                return index;
	            }
	            int newIndex = linearProbing(key, i);
	            if (!hashTable[newIndex].isOccupied()) {
	                return -1;
	            }
	            i++;
	            if (i >= TABLE_SIZE) {
	                break;
	            }
	        }
	        return -1;
	    }
	    
	    /**
	     * @brief Reads a fixed-length string from a file.
	     * @param raf The `RandomAccessFile` to read from.
	     * @param length The length of the string to read.
	     * @return The read string, trimmed of whitespace.
	     * @throws IOException If there is an error reading the file.
	     */
	    public static String readFixedLengthString(RandomAccessFile raf, int length) throws IOException {
	        byte[] bytes = new byte[length];
	        raf.readFully(bytes);
	        return new String(bytes).trim();
	    }

	    /**
	     * @brief Reads a vendor object from a file.
	     * @param raf The `RandomAccessFile` to read from.
	     * @return The read `Vendor` object.
	     * @throws IOException If there is an error reading the file.
	     */
	    public static Vendor readVendor(RandomAccessFile raf) throws IOException {
	        int vendorId = raf.readInt();
	        String vendorName = raf.readUTF();
	        return new Vendor(vendorId, vendorName);
	    }

	    /**
	     * @brief Reads a product object from a file.
	     * @param raf The `RandomAccessFile` to read from.
	     * @return The read `Product` object, or `null` if EOF is reached.
	     * @throws IOException If there is an error reading the file.
	     */
	    public static Product readProduct(RandomAccessFile raf) throws IOException {
	        try {
	            String productName = raf.readUTF(); 
	            double price = raf.readDouble();   
	            int quantity = raf.readInt();      
	            String season = raf.readUTF();    
	            int vendorId = raf.readInt(); 

	            return new Product(vendorId, productName, price, quantity, season);
	        } catch (EOFException e) {
	            return null; // Dosya sonuna ulaşıldığında null döndür
	        } catch (IOException e) {
	            System.out.println("Error reading product: " + e.getMessage());
	            throw e;
	        }
	    }

	    /**
	     * @brief Writes a vendor object to a file.
	     * @param raf The `RandomAccessFile` to write to.
	     * @param vendor The `Vendor` object to write.
	     * @throws IOException If there is an error writing to the file.
	     */
	    public static void writeVendor(RandomAccessFile raf, Vendor vendor) throws IOException {
	        raf.writeInt(vendor.getId()); // Write vendor ID
	        raf.writeUTF(vendor.getName()); // Write vendor name
	    }

	    /**
	     * @brief Writes a product object to a file.
	     * @param raf The `RandomAccessFile` to write to.
	     * @param product The `Product` object to write.
	     * @throws IOException If there is an error writing to the file.
	     */
	    public static void writeProduct(RandomAccessFile raf, Product product) throws IOException {
	        raf.writeUTF(product.getProductName()); // Ürün adı
	        raf.writeDouble(product.getPrice());    // Fiyat
	        raf.writeInt(product.getQuantity());    // Miktar
	        raf.writeUTF(product.getSeason());      // Sezon bilgisi
	        raf.writeInt(product.getVendorId());    // Vendor ID
	    }
	
	    
	    /**
	     * @brief Manages price comparison for selected products.
	     * @details Provides a menu to select a product or compare prices of the selected product. 
	     *          Users can navigate back to the main menu or continue with the options.
	     * @return `true` if the user exits to the main menu; otherwise, the menu loops.
	     */
	    public static boolean priceComparison() {
            int choice;
            StringBuffer selectedProductName = new StringBuffer();

            do {
                clearScreen();
                out.println("==========================================");
                out.println("|            Price Comparison            |");
                out.println("==========================================");
                out.println("| 1. Select Product                      |");
                out.println("| 2. Compare Prices                      |");
                out.println("| 0. Return to Main Menu                 |");
                out.println("==========================================");
                out.print("Choose an option: ");
                choice = getInput();

                switch (choice) {
                    case 1:
                    	selectProduct();
                        break;
                    case 2:
                    	comparePrices();
                        break;
                    case 0:
                        out.println("Returning to main menu...");
                        break;
                    default:
                        out.println("Invalid option. Please try again.");
                        break;
                }

                out.println("Press Enter to continue...");
                scanner.nextLine();

            } while (choice != 0);

            return true;
        }

	    /**
	     * @brief Allows the user to select a product by name.
	     * @details Prompts the user to enter a product name and searches for matching products in the binary file `products.bin`.
	     *          Displays details of all matching products and sets the selected product name for further operations.
	     * @throws IOException If there is an error accessing or reading the file.
	     */
	public static void selectProduct() {
		clearScreen();
		File productFile = new File("products.bin");

		String productName = "";

		while (productName.isEmpty()) {
			out.print("Enter the Product Name to search: ");
			productName = scanner.nextLine().trim();

			if (productName.isEmpty()) {
				out.println("Error: Product name cannot be empty.");
			}
		}

		boolean found = false;
		List<ProductSelection.Product> matchingProducts = new ArrayList<>();

		try (RandomAccessFile productRAF = new RandomAccessFile(productFile, "r")) {
			while (productRAF.getFilePointer() < productRAF.length()) {
				ProductSelection.Product product = new ProductSelection.Product();
				product.readFromRandomAccessFile(productRAF);

				if (product.getProductName().equalsIgnoreCase(productName)) {
					matchingProducts.add(product);
					found = true;
				}
			}

			if (found) {
				ProductSelection.selectedProductName.setLength(0); // Eski değeri temizle
				ProductSelection.selectedProductName.append(productName); // Yeni adı kaydet

				out.println("==========================================");
				out.println("|            Matching Products           |");
				out.println("==========================================");
				for (ProductSelection.Product product : matchingProducts) {
					out.println("Vendor ID      : " + product.getVendorId());
					out.println("Product Name   : " + product.getProductName());
					out.println("Product Price  : " + product.getPrice());
					out.println("Product Quantity: " + product.getQuantity());
					out.println("Product Season : " + product.getSeason());
					out.println("------------------------------------------");
				}
			} else {
				out.println("No products found with the name: " + productName);
			}

		} catch (IOException e) {
			out.println("Error accessing file: " + e.getMessage());
		}

		out.println("Press Enter to continue...");
		scanner.nextLine(); 
	}

	/**
	 * @brief Compares prices of the selected product across different vendors.
	 * @details Retrieves all matching products from the binary file `products.bin`, sorts them by price, and displays the 
	 *          details of the products with the lowest and highest prices.
	 * @throws IOException If there is an error accessing or reading the file.
	 * @note Requires a product to be selected first using the `selectProduct` method.
	 */
	public static void comparePrices() {
	        if (ProductSelection.selectedProductName.length() == 0) {
	            out.println("No product selected. Please select a product first (Option 1).");
	            return;
	        }

	        String productName = ProductSelection.selectedProductName.toString();
	        File productFile = new File("products.bin");

	        List<ProductSelection.Product> matchingProducts = new ArrayList<>();

	        try (RandomAccessFile productRAF = new RandomAccessFile(productFile, "r")) {
	            while (productRAF.getFilePointer() < productRAF.length()) {
	                ProductSelection.Product product = new ProductSelection.Product();
	                product.readFromRandomAccessFile(productRAF);

	                if (product.getProductName().equalsIgnoreCase(productName)) {
	                    matchingProducts.add(product);
	                }
	            }

	            if (matchingProducts.isEmpty()) {
	                out.println("No products found with the name: " + productName);
	                return;
	            }

	            matchingProducts.sort(Comparator.comparingDouble(ProductSelection.Product::getPrice));

	            ProductSelection.Product lowestPriceProduct = matchingProducts.get(0);
	            ProductSelection.Product highestPriceProduct = matchingProducts.get(matchingProducts.size() - 1);

	            out.println("==========================================");
	            out.println("|       Product with Lowest Price        |");
	            out.println("==========================================");
	            out.println("Vendor ID      : " + lowestPriceProduct.getVendorId());
	            out.println("Product Name   : " + lowestPriceProduct.getProductName());
	            out.println("Product Price  : " + lowestPriceProduct.getPrice());
	            out.println("Product Quantity: " + lowestPriceProduct.getQuantity());
	            out.println("Product Season : " + lowestPriceProduct.getSeason());
	            out.println("------------------------------------------");

	            out.println("==========================================");
	            out.println("|       Product with Highest Price       |");
	            out.println("==========================================");
	            out.println("Vendor ID      : " + highestPriceProduct.getVendorId());
	            out.println("Product Name   : " + highestPriceProduct.getProductName());
	            out.println("Product Price  : " + highestPriceProduct.getPrice());
	            out.println("Product Quantity: " + highestPriceProduct.getQuantity());
	            out.println("Product Season : " + highestPriceProduct.getSeason());
	            out.println("------------------------------------------");

	        } catch (IOException e) {

	        }
	    }


//
//	    private static void heapSort(Product[] arr, int n) {
//	        for (int i = n / 2 - 1; i >= 0; i--) {
//	            heapify(arr, n, i);
//	        }
//
//	        for (int i = n - 1; i >= 0; i--) {
//	            Product temp = arr[0];
//	            arr[0] = arr[i];
//	            arr[i] = temp;
//
//	            heapify(arr, i, 0);
//	        }
//	    }
//
//	    private static void heapify(Product[] arr, int n, int i) {
//	        int largest = i;
//	        int left = 2 * i + 1;
//	        int right = 2 * i + 2;
//
//	        if (left < n && arr[left].getPrice() > arr[largest].getPrice())
//	            largest = left;
//
//	        if (right < n && arr[right].getPrice() > arr[largest].getPrice())
//	            largest = right;
//
//	        if (largest != i) {
//	            Product swap = arr[i];
//	            arr[i] = arr[largest];
//	            arr[largest] = swap;
//
//	            heapify(arr, n, largest);
//	        }
//
//	    }

	/**
	 * @brief Creates a new node for a B+ Tree.
	 * @details Initializes a new B+ Tree node with the specified properties and default values.
	 * @param isLeaf A boolean indicating whether the new node is a leaf node.
	 * @return A new instance of `BPlusTreeNode` initialized with default values.
	 * @note This method is typically used internally by the B+ Tree implementation during insertions or tree setup.
	 */
	    public BPlusTreeNode createNode(boolean isLeaf) {
	        BPlusTreeNode newNode = new BPlusTreeNode(isLeaf);
	        newNode.setIsLeaf(isLeaf);
	        newNode.setKeyCount(0);
	        newNode.setNext(null);
	        return newNode;
	    }

	    public BPlusTreeNode insert(BPlusTreeNode root, int key) {
	        return null;
	    }

	    public boolean search(BPlusTreeNode root, int key) {
	        return false;
	    }
	    
	    /**
	     * @brief Manages market hours and locations menu.
	     * @details Displays a menu allowing the user to add, update, or view market hours and locations. 
	     *          Handles invalid inputs and navigates back to the main menu upon selection.
	     * @return `true` if the user exits the menu; otherwise, loops through the menu options.
	     */
	    public static boolean marketHoursAndLocations() {
	        
	        int choice;

	        do {
	        	clearScreen();
	            out.println("==========================================");
	            out.println("|      Market Hours and Locations        |");
	            out.println("==========================================");
	            out.println("| 1. Add Working Hours and Location      |");
	            out.println("| 2. Update Market Hours and Location    |");
	            out.println("| 3. View Market Hours and Locations     |");
	            out.println("| 0. Return to Main Menu                 |");
	            out.println("==========================================");
	            out.print("Choose an option: ");

	            if (!scanner.hasNextInt()) {
	                out.println("Invalid input. Please enter a valid option.");
	                scanner.next(); // Clear invalid input
	                choice = -1;
	                continue;
	            }

	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            switch (choice) {
	                case 1:
	                    addMarketHoursAndLocation();
	                    break;
	                case 2:
	                    updateMarketHoursAndLocation();
	                    break;
	                case 3:
	                    displayMarketHoursAndLocations();
	                    break;
	                case 0:
	                	out.println("Returning to main menu...");
	                    break;
	                default:
	                    out.println("Invalid option. Please try again.");
	                    break;
	            }
	        } while (choice != 0);

	        return true;
	    }


	    /**
	     * @brief Adds a new market's hours and location.
	     * @details Prompts the user for market ID, day, working hours, and location. Validates the inputs and appends the data 
	     *          to the `marketHours.bin` file.
	     * @return `true` if the market hours and location are successfully added; otherwise, `false`.
	     * @throws IOException If there is an error accessing or writing to the file.
	     * @note Requires that the market ID exists in the vendor file.
	     */
	public static boolean addMarketHoursAndLocation() {
		clearScreen();

		try (RandomAccessFile marketHoursRAF = new RandomAccessFile("marketHours.bin", "rw");
			 RandomAccessFile vendorRAF = new RandomAccessFile("vendor.bin", "r")) {

			MarketHours market = new MarketHours();
			boolean found = false;

			System.out.print("Enter Market ID: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a valid numeric Market ID: ");
				scanner.next(); 
			}
			market.setId(scanner.nextInt());
			scanner.nextLine();

			vendorRAF.seek(0);
			while (vendorRAF.getFilePointer() < vendorRAF.length()) {
				int vendorId = vendorRAF.readInt();
				String vendorName = vendorRAF.readUTF();
				if (vendorId == market.getId()) {
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Invalid Market ID. Exiting function...");
				return false;
			}

			System.out.print("Enter Day (e.g., Monday): ");
			market.setDay(scanner.nextLine());
			while (!validateDay(market.getDay())) {
				System.out.println("Invalid day. Please enter a valid day (e.g., Monday): ");
				market.setDay(scanner.nextLine());
			}

			System.out.print("Enter Working Hours (e.g., 09:00 - 18:00): ");
			market.setHours(scanner.nextLine());
			while (!validateWorkingHours(market.getHours())) {
				System.out.println("Invalid hours. Please enter valid hours (e.g., 09:00 - 18:00): ");
				market.setHours(scanner.nextLine());
			}

			System.out.print("Enter Location: ");
			market.setLocation(scanner.nextLine());

			marketHoursRAF.seek(marketHoursRAF.length()); 
			marketHoursRAF.writeInt(market.getId()); 
			marketHoursRAF.writeUTF(market.getDay()); 
			marketHoursRAF.writeUTF(market.getHours()); 
			marketHoursRAF.writeUTF(market.getLocation());

			System.out.println("Market hours and location added successfully!");
			return true;

		} catch (IOException e) {
			System.out.println("Error accessing files: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @brief Validates the day of the week.
	 * @param day The day of the week to validate.
	 * @return `true` if the day is valid (Monday to Sunday); otherwise, `false`.
	 */
	public static boolean validateDay(String day) {
		String[] validDays = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
		for (String validDay : validDays) {
			if (validDay.equalsIgnoreCase(day)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @brief Validates the format of working hours.
	 * @param hours The working hours to validate (e.g., "09:00 - 18:00").
	 * @return `true` if the format and values are valid; otherwise, `false`.
	 * @note Ensures that the start time is earlier than the end time.
	 */
	public static boolean validateWorkingHours(String hours) {
		String[] parts = hours.split(" - ");
		if (parts.length != 2) {
			return false;
		}

		String[] startTime = parts[0].split(":");
		String[] endTime = parts[1].split(":");
		if (startTime.length != 2 || endTime.length != 2) {
			return false;
		}

		try {
			int startHour = Integer.parseInt(startTime[0]);
			int startMinute = Integer.parseInt(startTime[1]);
			int endHour = Integer.parseInt(endTime[0]);
			int endMinute = Integer.parseInt(endTime[1]);

			if (startHour < 0 || startHour > 23 || endHour < 0 || endHour > 23) {
				return false;
			}
			if (startMinute < 0 || startMinute > 59 || endMinute < 0 || endMinute > 59) {
				return false;
			}
			if (startHour > endHour || (startHour == endHour && startMinute >= endMinute)) {
				return false;
			}

			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @brief Updates the hours and location of an existing market.
	 * @details Searches for a market by ID in the `marketHours.bin` file. Prompts the user to update the day, working hours, 
	 *          and location, and saves the changes back to the file.
	 * @return `true` if the update is successful; otherwise, `false`.
	 * @throws IOException If there is an error accessing or modifying the file.
	 * @note Displays an error message if the market ID is not found.
	 */
	public static boolean updateMarketHoursAndLocation() {
		clearScreen();

		try (RandomAccessFile file = new RandomAccessFile("marketHours.bin", "rw")) {
			out.print("Enter Market ID to update: ");
			int marketId = scanner.nextInt();
			scanner.nextLine();

			boolean found = false;

			while (file.getFilePointer() < file.length()) {
				long recordPosition = file.getFilePointer();
				MarketHours market = MarketHours.readFromFile(file);

				if (market.getId() == marketId) {
					found = true;

					out.print("Enter new Day (e.g., Monday): ");
					String day = scanner.nextLine();
					while (!validateDay(day)) {
						out.println("Invalid day. Please enter a valid day (e.g., Monday): ");
						day = scanner.nextLine();
					}

					out.print("Enter new Working Hours (e.g., 09:00 - 18:00): ");
					String hours = scanner.nextLine();
					while (!validateWorkingHours(hours)) {
						out.println("Invalid hours. Please enter valid hours (e.g., 09:00 - 18:00): ");
						hours = scanner.nextLine();
					}

					out.print("Enter new Location: ");
					String location = scanner.nextLine();

					market.setDay(day);
					market.setHours(hours);
					market.setLocation(location);

					file.seek(recordPosition); 
					market.writeToFile(file); 
					out.println("Market hours and location updated successfully!");
					return true;
				}
			}

			if (!found) {
				out.printf("Market ID %d not found.%n", marketId);
			}
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	/**
	 * @brief Displays all market hours and locations.
	 * @details Reads the `marketHours.bin` file and prints the details of all stored market hours and locations.
	 * @return `true` if the display operation is successful; otherwise, `false`.
	 * @throws IOException If there is an error reading the file.
	 * @note If the file is empty, a message is displayed to the user.
	 */
	public static boolean displayMarketHoursAndLocations() {
		try (RandomAccessFile file = new RandomAccessFile("marketHours.bin", "r")) {

			if (file.length() == 0) {
				System.out.println("No market hours available.");
				return true;
			}

			System.out.println("\n--- Market Hours and Locations ---");
			while (file.getFilePointer() < file.length()) {
				try {
					MarketHours market = MarketHours.readFromFile(file);
					System.out.printf("Market ID: %d\nDay: %s\nWorking Hours: %s\nLocation: %s\n\n",
							market.getId(), market.getDay(), market.getHours(), market.getLocation());
				} catch (IOException e) {
					System.err.println("Error reading MarketHours from file: " + e.getMessage());
					break;
				}
			}

			return true;

		} catch (IOException e) {
			System.err.println("Error opening market hours file: " + e.getMessage());
			return false;
		}
	}





//	public static MarketHoursNode insertXORList(MarketHoursNode head, MarketHours data) {
//	        MarketHoursNode newNode = new MarketHoursNode(data);
//	        newNode.xorPtr = null;
//
//	        if (head == null) {
//	            return newNode; // Case when list is empty, return new node as head.
//	        }
//
//	        MarketHoursNode prev = null;
//	        MarketHoursNode curr = head;
//	        MarketHoursNode next;
//
//	        while (curr != null) {
//	            next = xorFunction(prev, curr.xorPtr);
//	            if (data.getId() < curr.data.getId()) {
//	                newNode.xorPtr = xorFunction(prev, curr);
//	                if (prev != null) {
//	                    prev.xorPtr = xorFunction(xorFunction(prev.xorPtr, curr), newNode);
//	                }
//	                curr.xorPtr = xorFunction(newNode, next);
//	                if (prev == null) {
//	                    head = newNode;
//	                }
//	                return head;
//	            }
//	            prev = curr;
//	            curr = next;
//	        }
//
//	        // Insert new node at the end of the list
//	        prev.xorPtr = xorFunction(xorFunction(prev.xorPtr, null), newNode);
//	        newNode.xorPtr = prev;
//
//	        return head;
//	    }
//
//
//
//	    public static void traverseXORListGroupedByID(MarketHoursNode head) {
//	        MarketHoursNode curr = head;
//	        MarketHoursNode prev = null;
//	        MarketHoursNode next;
//	        Scanner scanner = new Scanner(System.in);
//
//	        while (curr != null) {
//	            int currentID = curr.data.getId();
//
//	            // Display all entries with the same ID
//	            System.out.println("\n--- Market Hours and Locations (Use 'n' for next ID group, 'p' for previous ID group, 'q' to quit) ---");
//	            System.out.printf("\nID: %d\n", currentID);
//	            while (curr != null && curr.data.getId() == currentID) {
//	                System.out.printf("  Day: %s, Hours: %s, Location: %s\n",
//	                        curr.data.getDay(), curr.data.getHours(), curr.data.getLocation());
//	                next = xorFunction(prev, curr.xorPtr);
//	                prev = curr;
//	                curr = next;
//	            }
//
//	            // User interaction for next or previous group
//	            if (curr != null || prev != null) {
//	                System.out.print("\nEnter your choice (n/p/q): ");
//	                char choice = scanner.next().charAt(0);
//
//	                if (choice == 'n') {
//	                    // Continue to next group (already set in curr)
//	                } else if (choice == 'p') {
//	                    while (prev != null && prev.data.getId() == currentID) {
//	                        next = xorFunction(prev.xorPtr, curr);
//	                        curr = prev;
//	                        prev = next;
//	                    }
//
//	                    if (prev != null) {
//	                        currentID = prev.data.getId();
//	                        while (prev != null && prev.data.getId() == currentID) {
//	                            next = xorFunction(prev.xorPtr, curr);
//	                            curr = prev;
//	                            prev = next;
//	                        }
//	                    } else {
//	                        System.out.println("You have reached the beginning of the list.");
//	                        curr = head;
//	                        prev = null;
//	                    }
//	                } else if (choice == 'q') {
//	                    break;
//	                } else {
//	                    System.out.println("Invalid choice. Please enter 'n', 'p', or 'q'.");
//	                }
//	            } else {
//	                System.out.println("You have reached the end of the list.");
//	            }
//	        }
//	    }
//
//		 public static void addToXorMap(MarketHoursNode node) {
//		        xorMap.put(System.identityHashCode(node), node);
//		    }
//
	/**
	 * @var xorMap
	 * @brief A mapping of unique integer keys to MarketHoursNode objects.
	 * @details Represents a data structure used to manage and access market hours and locations efficiently.
	 *          The keys are unique integers (e.g., market IDs), and the values are `MarketHoursNode` objects
	 *          containing the details of market hours and locations.
	 * @note This map is static and final, meaning it is shared across all instances of the class and cannot be re-assigned.
	 * @see MarketHoursNode
	 */
		 private static final Map<Integer, MarketHoursNode> xorMap = new HashMap<>();
//
//
//		    private static MarketHoursNode xorFunction(MarketHoursNode a, MarketHoursNode b) {
//		        if (a == null && b == null) {
//		            return null;
//		        }
//		        if (a == null) {
//		            return b;
//		        }
//		        if (b == null) {
//		            return a;
//		        }
//		        int xorKey = System.identityHashCode(a) ^ System.identityHashCode(b);
//		        return xorMap.get(xorKey);
//		    }

		 /**
		  * @brief Manages product and keyword search functionality.
		  * @details Displays a menu to allow users to search for products by name or enter keywords for a more detailed search.
		  *          Navigates back to the main menu upon selection.
		  * @return `true` if the user exits to the main menu; otherwise, loops through the menu options.
		  */
	    public static boolean searchProductsOrEnterKeyword() {
	        int choice;

	        do {
	        	clearScreen();
	            out.println("==========================================");
	            out.println("|   Search Products or Enter Keyword     |");
	            out.println("==========================================");
	            out.println("| 1. Enter Search Products               |");
	            out.println("| 2. Enter Keywords                      |");
	            out.println("| 0. Return to Main Menu                 |");
	            out.println("==========================================");
	            out.print("Choose an option: ");
	            choice = getInput();

	            switch (choice) {
	                case 1:
	                    enterSearchProducts();
	                    break;
	                case 2:
	                    enterKeywords();
	                    break;
	                case 0:
	                    out.println("Returning to main menu...\n");
	                    break;
	                default:
	                    out.println("Invalid option. Please try again.\n");
	                    break;
	            }

	        } while (choice != 0);

	        return true;
	    }
	    
	    /**
	     * @brief Searches for vendors offering a specific product.
	     * @details Prompts the user for a product name and searches for matching products in the binary file `products.bin`.
	     *          Uses the KMP string matching algorithm to locate matches. Displays the vendors offering the product.
	     * @return `true` if the search completes successfully; otherwise, `false`.
	     * @throws IOException If there is an error accessing the product or vendor files.
	     */
	    public static boolean enterSearchProducts() {
	        try (RandomAccessFile productFile = new RandomAccessFile("products.bin", "r");
	             RandomAccessFile vendorFile = new RandomAccessFile("vendor.bin", "r")) {

	            Product product = new Product();
	            Vendor vendor = new Vendor();
	            boolean found = false;

	            // Get favorite product name from user
	            System.out.print("Enter the name of your favorite product to search for vendors: ");
	            java.util.Scanner scanner = new java.util.Scanner(System.in);
	            String favoriteProduct = scanner.nextLine();

	            System.out.println("\n--- Vendors Offering '" + favoriteProduct + "' ---\n");

	            // Search with KMP by scanning the product file
	            while (productFile.getFilePointer() < productFile.length()) {
	                product.readFromFile(productFile);
	                if (KMPSearch(favoriteProduct, product.getProductName())) {
	                    vendorFile.seek(0); // Rewind vendor file
	                    while (vendorFile.getFilePointer() < vendorFile.length()) {
	                        vendor.readFromRandomAccessFile(vendorFile);
	                        if (vendor.getId() == product.getVendorId()) {
	                            System.out.printf("Vendor: %s, ID: %d\n", vendor.getName(), vendor.getId());
	                            found = true;
	                            break;
	                        }
	                    }
	                }
	            }

	            if (!found) {
	                System.out.printf("No vendors found offering '%s'.\n", favoriteProduct);
	            }

	            System.out.println("\nPress Enter to return to menu...");
	            scanner.nextLine();

	            return true;

	        } catch (IOException e) {
	            System.out.println("Error opening product or vendor file.");
	            return false;
	        }
	    }

	    /**
	     * @brief Builds the Longest Prefix Suffix (LPS) array for the KMP algorithm.
	     * @details Prepares the LPS array to optimize the pattern matching process in the KMP algorithm.
	     * @param pattern The pattern string for which the LPS array is computed.
	     * @param lps An array to store the computed LPS values.
	     */
	    public static void computeLPSArray(String pattern, int[] lps) {
	        int length = 0;
	        lps[0] = 0; // lps[0] is always 0

	        int i = 1;
	        while (i < pattern.length()) {if (pattern.charAt(i) == pattern.charAt(length)) {length++;lps[i] = length;i++;} else {if (length != 0) {length = lps[length - 1];} else {lps[i] = 0;i++;}
	            }
	        }
	    }

	    /**
	     * @brief Performs the KMP search algorithm.
	     * @details Searches for a pattern in a given text using the Knuth-Morris-Pratt algorithm.
	     * @param pattern The pattern to search for.
	     * @param text The text to search within.
	     * @return `true` if the pattern is found in the text; otherwise, `false`.
	     */
	    public static boolean KMPSearch(String pattern, String text) {
	        int M = pattern.length();
	        int N = text.length();

	        int[] lps = new int[M];
	        computeLPSArray(pattern, lps);

	        int i = 0;
	        int j = 0;
	        while (i < N) {
	            if (pattern.charAt(j) == text.charAt(i)) {j++;i++;}

	            if (j == M) {return true;
	            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
	                if (j != 0) {j = lps[j - 1];

	                } else {
	                    i++;
	                }
	            }
	        }

	        return false; // Pattern not found
	    }


	    /**
	     * @brief Searches for products and vendors using keywords.
	     * @details Prompts the user to enter a keyword. Builds a graph of products and vendors, and performs a DFS to find matches.
	     *          Additionally, identifies Strongly Connected Components (SCC) in the graph.
	     * @return `true` if the search completes successfully; otherwise, `false`.
	     * @throws IOException If there is an error accessing the product or vendor files.
	     */
	    public static boolean enterKeywords() {
	        try (RandomAccessFile productFile = new RandomAccessFile("products.bin", "r");
	             RandomAccessFile vendorFile = new RandomAccessFile("vendor.bin", "r")) {

	            Scanner scanner = new Scanner(System.in);
	            System.out.print("\nEnter a keyword to search: ");
	            String keyword = scanner.nextLine();

	            // Create a list for all nodes
	            List<Node> nodes = new ArrayList<>();

	         // Adding products as nodes
	            while (productFile.getFilePointer() < productFile.length()) {
	                Product product = new Product();
	                product.readFromFile(productFile); // Use the instance method to read data
	                Node productNode = new Node(String.format("Product: %s, Season: %s, Vendor ID: %d, Price: %.2f, Quantity: %d",
	                        product.getProductName(), product.getSeason(), product.getVendorId(), product.getPrice(), product.getQuantity()));
	                nodes.add(productNode);
	            }

	            // Adding vendors as nodes
	            while (vendorFile.getFilePointer() < vendorFile.length()) {
	                Vendor vendor = new Vendor();
	                vendor.readFromRandomAccessFile(vendorFile); // Use the instance method to read data
	                Node vendorNode = new Node(String.format("Vendor: %s, ID: %d",
	                        vendor.getName(), vendor.getId()));
	                nodes.add(vendorNode);
	            }

	            // Fill adjacency lists (neighbors)
	            for (Node node : nodes) {
	                for (Node potentialNeighbor : nodes) {
	                    if (!node.equals(potentialNeighbor) && potentialNeighbor.getInfo().contains(node.getInfo())) {node.addNeighbor(potentialNeighbor);
	                    }
	                }
	            }

	            // Search keyword with DFS
	            boolean found = false;
	            for (Node node : nodes) {
	                Set<Node> visited = new HashSet<>();
	                if (DFS(node, keyword, visited)) {
	                    found = true;
	                }
	            }

	            if (!found) {System.out.printf("No matches found for keyword '%s'.\n", keyword);}

	            // Running the SCC Algorithm
	            System.out.println("\nFinding Strongly Connected Components (SCC)...");
	            findSCC(nodes);

	            return true;

	        } catch (IOException e) {
	            System.out.println("Error opening product or vendor file.");
	            return false;
	        }
	    }

	    /**
	     * @brief Performs a Depth-First Search (DFS) on the graph.
	     * @details Searches for a keyword in the graph using DFS. If a match is found, the matched node information is displayed.
	     * @param node The starting node for the DFS.
	     * @param keyword The keyword to search for.
	     * @param visited A set of visited nodes to prevent revisiting during the search.
	     * @return `true` if a match is found; otherwise, `false`.
	     */
	    public static boolean DFS(Node node, String keyword, Set<Node> visited) {
	        Stack<Node> stack = new Stack<>();
	        stack.push(node);

	        while (!stack.isEmpty()) {
	            Node currentNode = stack.pop();

	            if (visited.contains(currentNode)) {continue;
	            }

	            visited.add(currentNode);

	            if (currentNode.getInfo().contains(keyword)) {
	                System.out.println("Match found: " + currentNode.getInfo());
	                return true;
	            }

	            for (Node neighbor : currentNode.getNeighbors()) {
	                stack.push(neighbor);
	            }
	        }

	        return false;
	    }

	    /**
	     * @brief Identifies Strongly Connected Components (SCC) in a graph.
	     * @details Implements Tarjan's algorithm to find SCCs in a directed graph represented by nodes and their neighbors.
	     * @param nodes A list of nodes representing the graph.
	     */
	    public static void findSCC(List<Node> nodes) {
	        Map<Node, Integer> ids = new HashMap<>();
	        Map<Node, Integer> low = new HashMap<>();
	        Set<Node> onStack = new HashSet<>();
	        Stack<Node> stack = new Stack<>();
	        int[] id = {0};

	        for (Node node : nodes) {
	            if (!ids.containsKey(node)) {
	                tarjanDFS(node, id, ids, low, stack, onStack);
	            }
	        }
	    }

	    /**
	     * @brief Performs a depth-first search as part of Tarjan's algorithm.
	     * @details Recursively explores the graph to compute low-link values and identify SCCs.
	     * @param node The current node being explored.
	     * @param id An array containing the current ID for assigning to nodes.
	     * @param ids A map storing the IDs of nodes.
	     * @param low A map storing the low-link values of nodes.
	     * @param stack A stack for managing the nodes in the current SCC.
	     * @param onStack A set of nodes currently in the stack.
	     */
	    public static void tarjanDFS(Node node, int[] id, Map<Node, Integer> ids, Map<Node, Integer> low,
	                                  Stack<Node> stack, Set<Node> onStack) {
	        ids.put(node, id[0]);
	        low.put(node, id[0]);
	        id[0]++;
	        stack.push(node);
	        onStack.add(node);

	        for (Node neighbor : node.getNeighbors()) {
	            if (!ids.containsKey(neighbor)) {
	                tarjanDFS(neighbor, id, ids, low, stack, onStack);
	                low.put(node, Math.min(low.get(node), low.get(neighbor)));
	            } else if (onStack.contains(neighbor)) {
	                low.put(node, Math.min(low.get(node), ids.get(neighbor)));
	            }
	        }

	        if (ids.get(node).equals(low.get(node))) {
	            System.out.print("SCC: ");
	            while (true) {
	                Node n = stack.pop();
	                onStack.remove(n);
	                System.out.print(n.getInfo() + " ");
	                if (n.equals(node)) {
	                    break;
	                }
	            }
	            System.out.println();
	        }
	    }
	    
}

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	    
	



	

