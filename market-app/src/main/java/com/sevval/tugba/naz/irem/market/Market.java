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

import static java.lang.System.out;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;




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
	
	    public static boolean mainMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int choice;


	        do {
	            out.println("\n--- Main Menu ---");
	            out.println("1. Listing of Local Vendors");
	            out.println("2. Listing of Local Products");
	            out.println("3. Price Comparison");
	            out.println("4. Market Hours and Locations");
	            out.println("5. Search Products or Enter Keywords");
	            out.println("0. Exit");
	            out.print("Choose an option: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    listingOfLocalVendors();
	                    break;
	                case 2:
	                   // listingOfLocalProducts();
	                    break;
	                case 3:
	                   // priceComparison();
	                    break;
	                case 4:
	                    //marketHoursAndLocations();
	                    break;
	                case 5:
	                   // searchProductsOrEnterKeyword();
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
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            out.println("\n--- Listing of Local Vendors and Products ---");
	            out.println("1. Add Vendor");
	            out.println("2. Update Vendor");
	            out.println("3. Delete Vendor");
	            out.println("4. List Vendors");
	            out.println("0. Return to Main Menu");
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
	                    //listVendors();
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
	    

		public boolean listingOfLocalProducts() {
	        int choice;

	        do {
	            out.println("\n--- List All Products ---");
	            out.println("1. Add Product");
	            out.println("2. Update Product");
	            out.println("3. Delete Product");
	            out.println("4. Listing of Local Products");
	            out.println("0. Return to Main Menu");
	            out.print("Choose an option: ");

	            choice = getInput();

	            switch (choice) {
	                case 1:
	                    //addProduct();
	                    break;
	                case 2:
	                    //updateProduct();
	                    break;
	                case 3:
	                    //deleteProduct();
	                    break;
	                case 4:
	                    //listingOfLocalVendorsandProducts();
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



		public static int getInput() {
		    try {
		        return Integer.parseInt(scanner.nextLine().trim());
		    } catch (NumberFormatException e) {
		        out.println("Invalid choice! Please enter a valid number:");
		        return -1; // Geçersiz bir değer döndürmek için
		    }
		}

	    public static boolean addVendor() {
	        Scanner scanner = new Scanner(System.in);
	        File file = new File("vendor.bin");
	        Random random = new Random();

	        try (FileOutputStream fos = new FileOutputStream(file, true);
	             ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))) {

	            out.println("\n--- List of Vendors ---");

	            // Rastgele 6 basamaklı bir ID üret
	            int vendorId = random.nextInt(900000) + 100000;
	            out.println("Assigned Vendor ID: " + vendorId);

	            // Kullanıcıdan vendor adı al
	            out.print("Enter Vendor Name: ");
	            String vendorName = scanner.nextLine();

	            // Vendor nesnesini oluştur
	            Vendor vendor = new Vendor(vendorId, vendorName);

	            // Vendor nesnesini dosyaya yaz
	            oos.writeObject(vendor);

	            out.println("Vendor added successfully!");

	            // Devam etmek için kullanıcıdan onay al
	            out.println("Press Enter to continue...");
	            scanner.nextLine();

	            return true;

	        } catch (IOException e) {
	            out.println("Error opening vendor file.");
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    public static boolean updateVendor() {
	        File file = new File("vendor.bin");
	        if (!file.exists()) {
	            out.println("Error: Vendor file not found.");
	            return false;
	        }

	        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
	            Scanner scanner = new Scanner(System.in);
	            out.print("Enter Vendor ID to update: ");
	            int id = scanner.nextInt();
	            scanner.nextLine(); // Clear the buffer

	            boolean found = false;
	            while (raf.getFilePointer() < raf.length()) {
	                // Read the Vendor object from the file
	                int vendorId = raf.readInt();
	                byte[] nameBytes = new byte[50];
	                raf.read(nameBytes);
	                String vendorName = new String(nameBytes).trim();

	                // Check if the ID matches
	                if (vendorId == id) {
	                    out.print("Enter new Vendor Name: ");
	                    String newName = scanner.nextLine();

	                    // Write back the updated Vendor data
	                    raf.seek(raf.getFilePointer() - 54); // Go back to the start of this Vendor entry
	                    raf.writeInt(vendorId);
	                    byte[] updatedName = newName.getBytes();
	                    if (updatedName.length > 50) {
	                        out.println("Vendor name is too long. Maximum length is 50 characters.");
	                        return false;
	                    }
	                    raf.write(Arrays.copyOf(updatedName, 50)); // Write the updated name with padding

	                    out.println("Vendor updated successfully!");
	                    found = true;
	                    break;
	                }
	            }

	            if (!found) {
	                out.println("Vendor with ID " + id + " not found.");
	            }

	            out.println("Press Enter to continue...");
	            scanner.nextLine(); // Wait for user input

	            return true;
	        } catch (IOException e) {
	            out.println("Error accessing the vendor file: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    public static boolean deleteVendor() {
	        File file = new File("vendor.bin");
	        File tempFile = new File("temp.bin");
	        boolean found = false;

	        if (!file.exists()) {
	            out.println("Error: vendor.bin file not found.");
	            return false;
	        }

	        try (
	            RandomAccessFile raf = new RandomAccessFile(file, "r");
	            RandomAccessFile tempRaf = new RandomAccessFile(tempFile, "rw")
	        ) {
	            
	            out.print("Enter Vendor ID to delete: ");
	            int id = scanner.nextInt();
	            scanner.nextLine(); // Clear input buffer

	            while (raf.getFilePointer() < raf.length()) {
	                int vendorId = raf.readInt(); // Read vendor ID
	                byte[] nameBytes = new byte[50];
	                raf.read(nameBytes); // Read vendor name
	                String vendorName = new String(nameBytes).trim();

	                if (vendorId != id) {
	                    tempRaf.writeInt(vendorId); // Write vendor ID
	                    tempRaf.write(nameBytes);  // Write vendor name
	                } else {
	                    found = true;
	                }
	            }
	        } catch (IOException e) {
	            out.println("Error processing file: " + e.getMessage());
	            return false;
	        }

	        // Replace original file with updated file
	        if (file.delete()) {
	            if (tempFile.renameTo(file)) {
	                if (found) {
	                    out.println("Vendor deleted successfully!");
	                } else {
	                    out.println("Vendor with the specified ID not found.");
	                }
	            } else {
	                out.println("Error renaming temp file.");
	            }
	        } else {
	            out.println("Error deleting original file.");
	        }

	        out.println("Press Enter to continue...");
	        try {
	            System.in.read();
	        } catch (IOException ignored) {
	        }

	        return true;
	    }
	    
	    public static boolean listVendors() {
	        File file = new File("vendor.bin");
	        if (!file.exists()) {
	            System.out.println("Error opening vendor file.");
	            return false;
	        }

	        // Vendor'ları stack ve queue'ya ekleme
	        Stack<Vendor> vendorStack = new Stack<>();
	        Queue<Vendor> vendorQueue = new LinkedList<>();

	        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
	            while (true) {
	                Vendor vendor = (Vendor) input.readObject();
	                if (!isDuplicate(vendorQueue, vendor)) {
	                    vendorQueue.add(vendor); // Queue'ya ekle
	                }
	                vendorStack.push(vendor); // Stack'e ekle
	                DoubleLinkedList.insertVendor(vendor); // Doubly linked list'e ekle
	            }
	        } catch (EOFException e) {
	            // Dosya sonuna ulaşıldı
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	     
	        DoubleLinkedListNode current = DoubleLinkedList.head;

	        while (current != null) {
	            System.out.printf("ID: %d, Name: %s%n", current.vendor.getId(), current.vendor.getName());
	            System.out.print("\n'n' for Next, 'p' for Previous, 's' for Stack traversal, 'q' for Queue traversal, 'x' to Quit: ");
	            String choice = scanner.nextLine().trim();

	            if ("n".equalsIgnoreCase(choice)) {
	                if (current.next != null) {
	                    current = current.next;
	                } else {
	                    System.out.println("No more vendors in this direction.");
	                }
	            } else if ("p".equalsIgnoreCase(choice)) {
	                if (current.prev != null) {
	                    current = current.prev;
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
	    
	    
	    
	    public boolean addProduct() {
	        File productFile = new File("products.bin");
	        File vendorFile = new File("vendor.bin");
	        Product product = new Product();
	        boolean found = false;

	        try (RandomAccessFile productRAF = new RandomAccessFile(productFile, "rw");
	             RandomAccessFile vendorRAF = new RandomAccessFile(vendorFile, "r")) {

	            // Get Vendor ID from user
	            Scanner scanner = new Scanner(System.in);
	            out.print("Enter Vendor ID for the product: ");
	            product.setVendorId(scanner.nextInt());
	            scanner.nextLine(); // Clear buffer

	            // Check the Vendor ID
	            while (vendorRAF.getFilePointer() < vendorRAF.length()) {
	                Vendor vendor = new Vendor(0, null);
	                vendor.readFromFile(vendorRAF); // Assuming `readFromFile` is implemented in Vendor class
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

	            // Append the product information to the file
	            productRAF.seek(productRAF.length());
	            product.writeToFile(productRAF); // Assuming `writeToFile` is implemented in Product class

	            out.println("Product added successfully!");
	            out.println("Press Enter to continue...");
	            scanner.nextLine();

	        } catch (IOException e) {
	            out.println("Error accessing files: " + e.getMessage());
	            return false;
	        }

	        return true;
	    }
	    
	    
	}
	    
	    
	



	

