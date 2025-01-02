/**

@file Market.java
@brief This file serves as a demonstration file for the Market class.
@details This file contains the implementation of the Market class, which provides various mathematical operations.
*/

/**

@package com.sevval.tugba.naz.irem.market
@brief The com.sevval.tugba.naz.irem.market package contains all the classes and files related to the Market App.
*/
package com.sevval.tugba.naz.irem.market;

import java.util.Scanner;
import java.util.Set;

import static java.lang.System.out;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;




/**

@class Market
@brief This class represents a Market that performs mathematical operations.
@details The Market class provides methods to perform mathematical operations such as addition, subtraction, multiplication, and division. It also supports logging functionality using the logger object.
@author ugur.coruh
*/
public class Market {
    public StackNode top; // Top of the stack
    
	public static Scanner scanner;
    public static PrintStream out;
    
    public Market(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }
    
    private static boolean isAuthenticated = false;
    
    private static void clearScreen() {
        // This is just a placeholder for clear screen in Java since it's platform-dependent
        out.print("\033[H\033[2J");
        out.flush();
    }
    
    private static int getInput() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            out.println("Invalid input. Please enter a valid number.");
        }
        return scanner.nextInt();
    }

    
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
                    if (loginUser()) 
                	{
                        mainMenu();
                    }
                    break;
                case 2:
                    registerUser();
                   isAuthenticated = true;
                    break;
                case 3:
                    mainMenu();
                    break;
                case 4:
                    out.println("Exiting the program...");
                    return true;
                default:
                    out.println("Invalid option. Please try again.");
                    scanner.nextLine(); // Buffer'dan kalanı temizlemek için
                    break;
            }
    
        }     while (choice != 4);
        
        return true ; 
}

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
	                    listingOfLocalVendors();
	                    break;
	                case 2:
	                    listingOfLocalProducts();
	                    break;
	                case 3:
	                    priceComparison();
	                    break;
	                case 4:
	                    marketHoursAndLocations();
	                    break;
	                case 5:
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
	                    addVendor();
	                    break;
	                case 2:
	                    updateVendor();
	                    break;
	                case 3:
	                    deleteVendor();
	                    break;
	                case 4:
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
	                    addProduct();
	                    break;
	                case 2:
	                    updateProduct();
	                    break;
	                case 3:
	                    deleteProduct();
	                    break;
	                case 4:
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

		        }
		        return false;
		    }

	public static boolean loginUser() {
		String username;
		String password;

		// Kullanıcı adı kontrolü
		do {
			out.print("Username: ");
			username = scanner.nextLine();
			if (username.trim().isEmpty()) {
				out.println("Username cannot be empty. Please enter a valid username.");
			}
		} while (username.trim().isEmpty()); // Kullanıcı adı boş ise tekrar sor

		// Şifre kontrolü
		do {
			out.print("Password: ");
			password = scanner.nextLine();
			if (password.trim().isEmpty()) {
				out.println("Password cannot be empty. Please enter a valid password.");
			}
		} while (password.trim().isEmpty()); // Şifre boş ise tekrar sor

		// Giriş kontrolü
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


	public static boolean registerUser() {
		clearScreen(); // Ekranı temizler

		// Kullanıcı bilgilerini almak için bir User sınıfı oluşturuyoruz
		class User {
			String username;
			String password;
		}

		User user = new User();

		// Kullanıcıdan bilgi alırken boş girişleri kontrol et
		do {
			out.print("Username: ");
			user.username = scanner.nextLine();
			if (user.username.trim().isEmpty()) {
				out.println("Username cannot be empty. Please enter a valid username.");
			}
		} while (user.username.trim().isEmpty()); // Username boş ise tekrar sor

		do {
			out.print("Password: ");
			user.password = scanner.nextLine();
			if (user.password.trim().isEmpty()) {
				out.println("Password cannot be empty. Please enter a valid password.");
			}
		} while (user.password.trim().isEmpty()); // Password boş ise tekrar sor

		// Kullanıcı bilgilerini binary dosyasına yaz
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("users.bin", true))) {
			dos.writeUTF(user.username); // Kullanıcı adını yaz
			dos.writeUTF(user.password); // Şifreyi yaz
		} catch (IOException e) {

		}

		// Kullanıcıyı .huff dosyasına kaydet
		if (!saveUserToHuffFile(user.username, user.password)) {
			out.println("Failed to save user to .huff file.");
			return false;
		}

		// Kayıt işlemi başarılı
		out.println("Register is successful!");
		out.println("Press Enter to continue...");
		try {
			scanner.nextLine(); // Enter tuşuna basılmasını bekler
		} catch (Exception e) {

		}
		return true;
	}




	public static boolean saveUserToHuffFile(String username, String password) {
		        try (RandomAccessFile file = new RandomAccessFile("users.huff", "rw")) {
		            file.seek(file.length());  // Move to the end of the file
		            file.writeInt(username.length());
		            file.write(username.getBytes());
		            file.writeInt(password.length());
		            file.write(password.getBytes());
		            return true;
		        } catch (IOException e) {
		            System.err.println("Error opening file: " + e.getMessage());
		            return false;
		        }
		    }



	public static void addVendor() {
		Random random = new Random();

		File file = new File("vendor.bin");

		try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
			raf.seek(raf.length()); // Dosyanın sonuna git.

			int vendorId = 100000 + random.nextInt(900000); // Rastgele bir ID üret
			System.out.println("Assigned Vendor ID: " + vendorId);

			String vendorName;
			do {
				System.out.print("Enter Vendor Name: ");
				vendorName = scanner.nextLine(); // Kullanıcıdan vendor adı al
				if (vendorName.trim().isEmpty()) {
					System.out.println("Vendor Name cannot be empty. Please enter a valid name.");
				}
			} while (vendorName.trim().isEmpty()); // Boş giriş varsa tekrar sor

			raf.writeInt(vendorId); // ID'yi dosyaya yaz
			raf.writeUTF(vendorName); // Vendor adını dosyaya yaz

			System.out.println("Vendor added successfully!");
		} catch (IOException e) {

		}
	}


	public static void updateVendor() {
		File file = new File("vendor.bin");

		try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
			// Vendor Name'i al
			String vendorNameToUpdate;
			while (true) {
				System.out.print("Enter Vendor Name to update: ");
				vendorNameToUpdate = scanner.nextLine().trim(); // Vendor Name'i al
				if (!vendorNameToUpdate.isEmpty()) {
					break; // Geçerli bir giriş alındığında döngüden çık
				} else {
					System.out.println("Vendor Name cannot be empty. Please enter a valid name.");
				}
			}

			boolean isUpdated = false;
			while (raf.getFilePointer() < raf.length()) { // Dosyanın sonuna kadar oku
				long recordPosition = raf.getFilePointer(); // Mevcut kaydın başlangıç pozisyonunu kaydet
				int vendorId = raf.readInt(); // Vendor ID'yi oku
				String vendorName = raf.readUTF(); // Vendor ismini oku

				if (vendorName.equalsIgnoreCase(vendorNameToUpdate)) { // Eğer isim eşleşirse
					String newVendorName;
					do {
						System.out.print("Enter new Vendor Name: ");
						newVendorName = scanner.nextLine().trim();
						if (newVendorName.isEmpty()) {
							System.out.println("Vendor Name cannot be empty. Please enter a valid name.");
						}
					} while (newVendorName.isEmpty()); // Yeni isim boşsa tekrar sor

					raf.seek(recordPosition + 4); // ID'den sonraki pozisyona git
					raf.writeUTF(newVendorName); // Yeni ismi yaz
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
	            // Dosya sonuna ulaşıldı
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

	    
	    public static boolean isDuplicate(Queue<Vendor> queue, Vendor vendor) {
	        for (Vendor v : queue) {
	            if (v.getId() == vendor.getId()) {
	                // Vendor ID zaten kuyrukta varsa, tekrarlama var demektir
	                return true;
	            }
	        }
	        return false; // Eğer kuyruğun sonuna kadar aynı ID bulunmadıysa, tekrarlama yok demektir
	    }

	    // Check if the stack is empty
	    public boolean isStackEmpty() {
	        return top == null;
	    }

	    // Push a vendor onto the stack
	    public void push(Vendor vendor) {
	        StackNode newNode = new StackNode(vendor);
	        newNode.next = top;
	        top = newNode;
	    }
	    
	  
	    // Pop a vendor from the stack
	    public Vendor pop() {
	        if (isStackEmpty()) {
	            out.println("Stack is empty.");
	            return new Vendor(0, ""); // Return an empty vendor object
	        }
	        Vendor vendor = top.vendor;
	        top = top.next;
	        return vendor;
	    }

	    // Free all nodes in the stack
	    public void freeStack() {
	        while (!isStackEmpty()) {
	            pop();
	        }
	    }
	    
	    
	    
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
				productName = scanner.nextLine().trim(); // Kullanıcıdan ürün adı alınıyor
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
					scanner.nextLine(); // Double sonrası tampon temizliği
					System.out.print("Enter new Product Quantity: ");
					product.setQuantity(scanner.nextInt());
					scanner.nextLine(); // Int sonrası tampon temizliği
					System.out.print("Enter new Product Season: ");
					product.setSeason(scanner.nextLine().trim());
				}

				product.writeToFile(tempRAF);
			}

			if (!found) {
				System.out.println("Product with name '" + productName + "' not found.");
				tempFile.delete();
			} else {
				// Kapalı dosyalarla dosya değiştirme işlemi
				productRAF.close(); // RandomAccessFile nesnesini kapat
				tempRAF.close(); // RandomAccessFile nesnesini kapat


				System.out.println("Product updated successfully!");
			}

		} catch (IOException e) {

		}

		System.out.println("Press Enter to continue...");
		scanner.nextLine();
		return true;
	}




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
	                    continue; // Skip writing this product to temp file
	                }

	                product.writeToFile(tempRAF); // Ürünü geçici dosyaya yaz
	            }

	            if (!found) {
	                System.out.println("Product with name '" + productName + "' not found.");
	                tempFile.delete();
	            } else {
	                if (productFile.delete() && tempFile.renameTo(productFile)) {
	                    System.out.println("Product deleted successfully!");
	                } else {
	                    System.out.println("Error updating the product file.");
	                }
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
	                productRAF.seek(0); // Reset product file pointer for each vendor

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

	    public static void addVendorProductRelation(int vendorId, int productId, float price) {
	        if (price == 0) return;
	        sparseMatrix[sparseMatrixSize] = new SparseMatrixEntry(vendorId, productId, price);
	        sparseMatrixSize++;
	    }

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

	    public static int hashFunction(int key) {
	        return key % TABLE_SIZE;
	    }

	    public static void initializeHashTable() {
	        for (int i = 0; i < TABLE_SIZE; i++) {
	            hashTable[i] = new HashTableEntry(false, 0);
	            hashTableBuckets[i] = new Bucket();
	        }
	        for (int i = 0; i < OVERFLOW_SIZE; i++) {
	            overflowArea[i] = new OverflowEntry(false, 0);
	        }
	    }

	    public static int linearProbing(int key, int i) {
	        return (key + i) % TABLE_SIZE;
	    }

	    public static int quadraticProbing(int key, int i) {
	        return (key + i * i) % TABLE_SIZE;
	    }

	    public static int doubleHashing(int key, int i) {
	        int h1 = key % TABLE_SIZE;
	        int h2 = 1 + (key % (TABLE_SIZE - 1));
	        return (h1 + i * h2) % TABLE_SIZE;
	    }

	    public static int linearQuotient(int key, int i) {
	        return (key + i * 7) % TABLE_SIZE;
	    }

	    public static boolean progressiveOverflowSearch(int key) {
	        for (int i = 0; i < OVERFLOW_SIZE; i++) {
	            if (overflowArea[i].isOccupied() && overflowArea[i].getKey() == key) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public static boolean useOfBucketsSearch(int key) {
	        int index = hashFunction(key);
	        for (Product product : hashTableBuckets[index].product) {
	            if (product.getVendorId() == key) {
	                return true;
	            }
	        }
	        return false;
	    }

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
	    
	    public static String readFixedLengthString(RandomAccessFile raf, int length) throws IOException {
	        byte[] bytes = new byte[length];
	        raf.readFully(bytes); // Dosyadan belirtilen uzunlukta byte oku
	        return new String(bytes).trim(); // String'e çevir ve boşlukları temizle
	    }

	
	    public static Vendor readVendor(RandomAccessFile raf) throws IOException {
	        int vendorId = raf.readInt();
	        String vendorName = raf.readUTF();
	        return new Vendor(vendorId, vendorName);
	    }

	    public static Product readProduct(RandomAccessFile raf) throws IOException {
	        try {
	            String productName = raf.readUTF(); // Ürün adı
	            double price = raf.readDouble();    // Fiyat
	            int quantity = raf.readInt();       // Miktar
	            String season = raf.readUTF();      // Sezon bilgisi
	            int vendorId = raf.readInt();       // Vendor ID

	            return new Product(vendorId, productName, price, quantity, season);
	        } catch (EOFException e) {
	            return null; // Dosya sonuna ulaşıldığında null döndür
	        } catch (IOException e) {
	            System.out.println("Error reading product: " + e.getMessage());
	            throw e;
	        }
	    }

	    public static void writeVendor(RandomAccessFile raf, Vendor vendor) throws IOException {
	        raf.writeInt(vendor.getId()); // Write vendor ID
	        raf.writeUTF(vendor.getName()); // Write vendor name
	    }

	    public static void writeProduct(RandomAccessFile raf, Product product) throws IOException {
	        raf.writeUTF(product.getProductName()); // Ürün adı
	        raf.writeDouble(product.getPrice());    // Fiyat
	        raf.writeInt(product.getQuantity());    // Miktar
	        raf.writeUTF(product.getSeason());      // Sezon bilgisi
	        raf.writeInt(product.getVendorId());    // Vendor ID
	    }
	
	    
	        
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
                scanner.nextLine(); // Kullanıcıdan Enter tuşuna basmasını bekler

            } while (choice != 0);

            return true;
        }


	public static void selectProduct() {
		clearScreen();
		File productFile = new File("products.bin");

		String productName = "";

		// Ürün adı girilene kadar kullanıcıdan giriş al
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
		scanner.nextLine(); // Kullanıcının devam etmesini bekle
	}




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

	            // Fiyatlara göre sıralama
	            matchingProducts.sort(Comparator.comparingDouble(ProductSelection.Product::getPrice));

	            // En düşük ve en yüksek fiyatlı ürünleri al
	            ProductSelection.Product lowestPriceProduct = matchingProducts.get(0);
	            ProductSelection.Product highestPriceProduct = matchingProducts.get(matchingProducts.size() - 1);

	            // En düşük fiyatlı ürün bilgisi
	            out.println("==========================================");
	            out.println("|       Product with Lowest Price        |");
	            out.println("==========================================");
	            out.println("Vendor ID      : " + lowestPriceProduct.getVendorId());
	            out.println("Product Name   : " + lowestPriceProduct.getProductName());
	            out.println("Product Price  : " + lowestPriceProduct.getPrice());
	            out.println("Product Quantity: " + lowestPriceProduct.getQuantity());
	            out.println("Product Season : " + lowestPriceProduct.getSeason());
	            out.println("------------------------------------------");

	            // En yüksek fiyatlı ürün bilgisi
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

	    public BPlusTreeNode createNode(boolean isLeaf) {
	        BPlusTreeNode newNode = new BPlusTreeNode(isLeaf);
	        newNode.setIsLeaf(isLeaf);
	        newNode.setKeyCount(0);
	        newNode.setNext(null);
	        return newNode;
	    }

	    public BPlusTreeNode insert(BPlusTreeNode root, int key) {
	        // Insert logic for B+ Tree here (similar to the provided C function)
	        return null; // Placeholder for actual insert logic
	    }

	    public boolean search(BPlusTreeNode root, int key) {
	        // Search logic for B+ Tree here (similar to the provided C function)
	        return false; // Placeholder for actual search logic
	    }
	    
	    
	    
	    
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



	public static boolean addMarketHoursAndLocation() {
		clearScreen();

		try (RandomAccessFile marketHoursRAF = new RandomAccessFile("marketHours.bin", "rw");
			 RandomAccessFile vendorRAF = new RandomAccessFile("vendor.bin", "r")) {

			MarketHours market = new MarketHours();
			boolean found = false;

			// Market ID giriş ve doğrulama
			System.out.print("Enter Market ID: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a valid numeric Market ID: ");
				scanner.next(); // Geçersiz girdiyi temizle
			}
			market.setId(scanner.nextInt());
			scanner.nextLine(); // Tamponu temizle

			// Vendor dosyasından Market ID kontrolü
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
				return false; // Geçersiz girişle fonksiyonu sonlandır
			}

			// Gün giriş ve doğrulama
			System.out.print("Enter Day (e.g., Monday): ");
			market.setDay(scanner.nextLine());
			while (!validateDay(market.getDay())) {
				System.out.println("Invalid day. Please enter a valid day (e.g., Monday): ");
				market.setDay(scanner.nextLine());
			}

			// Çalışma saatleri giriş ve doğrulama
			System.out.print("Enter Working Hours (e.g., 09:00 - 18:00): ");
			market.setHours(scanner.nextLine());
			while (!validateWorkingHours(market.getHours())) {
				System.out.println("Invalid hours. Please enter valid hours (e.g., 09:00 - 18:00): ");
				market.setHours(scanner.nextLine());
			}

			// Lokasyon giriş
			System.out.print("Enter Location: ");
			market.setLocation(scanner.nextLine());

			// Dosyaya yazma
			marketHoursRAF.seek(marketHoursRAF.length()); // Dosyanın sonuna git
			marketHoursRAF.writeInt(market.getId()); // Market ID
			marketHoursRAF.writeUTF(market.getDay()); // Gün
			marketHoursRAF.writeUTF(market.getHours()); // Çalışma saatleri
			marketHoursRAF.writeUTF(market.getLocation()); // Konum

			System.out.println("Market hours and location added successfully!");
			return true;

		} catch (IOException e) {
			System.out.println("Error accessing files: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}



	public static boolean validateDay(String day) {
		String[] validDays = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
		for (String validDay : validDays) {
			if (validDay.equalsIgnoreCase(day)) {
				return true;
			}
		}
		return false;
	}


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



	public static boolean updateMarketHoursAndLocation() {
		clearScreen();

		try (RandomAccessFile file = new RandomAccessFile("marketHours.bin", "rw")) {
			out.print("Enter Market ID to update: ");
			int marketId = scanner.nextInt();
			scanner.nextLine(); // Tamponu temizle

			boolean found = false;

			while (file.getFilePointer() < file.length()) {
				long recordPosition = file.getFilePointer(); // Kayıt pozisyonunu al
				MarketHours market = MarketHours.readFromFile(file); // Kaydı oku

				if (market.getId() == marketId) {
					found = true;

					// Yeni verileri al
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

					// Güncellenmiş verileri yaz
					market.setDay(day);
					market.setHours(hours);
					market.setLocation(location);

					file.seek(recordPosition); // Kayıt pozisyonuna dön
					market.writeToFile(file);  // Güncel veriyi yaz
					out.println("Market hours and location updated successfully!");
					return true;
				}
			}

			if (!found) {
				out.printf("Market ID %d not found.%n", marketId);
			}
		} catch (IOException e) {
			out.println("Error accessing the market hours file: " + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
	}




	public static boolean displayMarketHoursAndLocations() {
		try (RandomAccessFile file = new RandomAccessFile("marketHours.bin", "r")) {

			if (file.length() == 0) {
				System.out.println("No market hours available.");
				return true;
			}

			System.out.println("\n--- Market Hours and Locations ---");
			while (file.getFilePointer() < file.length()) {
				try {
					MarketHours market = MarketHours.readFromFile(file); // Veriyi oku
					System.out.printf("Market ID: %d\nDay: %s\nWorking Hours: %s\nLocation: %s\n\n",
							market.getId(), market.getDay(), market.getHours(), market.getLocation());
				} catch (IOException e) {
					System.err.println("Error reading MarketHours from file: " + e.getMessage());
					break; // Okuma hatasında döngüyü kır
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

	    public static void computeLPSArray(String pattern, int[] lps) {
	        int length = 0;
	        lps[0] = 0; // lps[0] is always 0

	        int i = 1;
	        while (i < pattern.length()) {if (pattern.charAt(i) == pattern.charAt(length)) {length++;lps[i] = length;i++;} else {if (length != 0) {length = lps[length - 1];} else {lps[i] = 0;i++;}
	            }
	        }
	    }

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

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	    
	



	

