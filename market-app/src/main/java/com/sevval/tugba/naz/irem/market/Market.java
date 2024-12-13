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
import java.io.BufferedReader;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




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
	                DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
					doubleLinkedList.insertVendor(vendor); // Doubly linked list'e ekle
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
	                if (current.previous != null) {
	                    current = current.previous;
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
	    
	    public static boolean updateProduct() {
	        File productFile = new File("products.bin");
	        File tempFile = new File("temp.bin");
	        boolean found = false;

	        if (!productFile.exists()) {
	            System.out.println("Error: Product file not found.");
	            return false;
	        }

	        try (ObjectInputStream productInput = new ObjectInputStream(new FileInputStream(productFile));
	             ObjectOutputStream tempOutput = new ObjectOutputStream(new FileOutputStream(tempFile))) {

	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Enter Product Name to update: ");
	            String productName = scanner.nextLine();

	            while (true) {
	                try {
	                    Product product = (Product) productInput.readObject(); // Read product from file
	                    if (product.getProductName().equals(productName)) {
	                        found = true;
	                        // Receive new product information
	                        System.out.print("Enter new Product Name: ");
	                        product.setProductName(scanner.nextLine());
	                        System.out.print("Enter new Product Price: ");
	                        product.setPrice(scanner.nextFloat());
	                        System.out.print("Enter new Product Quantity: ");
	                        product.setQuantity(scanner.nextInt());
	                        scanner.nextLine(); // Consume newline
	                        System.out.print("Enter new Product Season: ");
	                        product.setSeason(scanner.nextLine());
	                    }
	                    tempOutput.writeObject(product); // Write product to temporary file
	                } catch (EOFException e) {
	                    break; // End of file reached
	                }
	            }

	            if (!found) {
	                System.out.println("Product with name " + productName + " not found.");
	                tempFile.delete(); // Delete temporary file
	            } else {
	                if (productFile.delete() && tempFile.renameTo(productFile)) {
	                    System.out.println("Product updated successfully!");
	                } else {
	                    System.out.println("Error: Could not update product file.");
	                }
	            }

	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return false;
	        }

	        System.out.println("Press Enter to continue...");
	        new Scanner(System.in).nextLine(); // Pause for user input

	        return true;
	    }

	    public static boolean deleteProduct() {
	        File productFile = new File("products.bin");
	        File tempFile = new File("temp.bin");

	        if (!productFile.exists()) {
	            System.out.println("Error opening product file.");
	            return false;
	        }

	        try (
	            FileInputStream fis = new FileInputStream(productFile);
	            ObjectInputStream input = new ObjectInputStream(fis);
	            FileOutputStream fos = new FileOutputStream(tempFile);
	            ObjectOutputStream output = new ObjectOutputStream(fos)
	        ) {
	            System.out.print("Enter Product Name to delete: ");
	            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	            String productName = reader.readLine();

	            boolean found = false;

	            while (true) {
	                try {
	                    Product product = (Product) input.readObject();
	                    if (product.getProductName().equals(productName)) {
	                        found = true;
	                        System.out.println("Product with name " + productName + " deleted successfully!");
	                        continue; // Skip product to delete
	                    }
	                    output.writeObject(product); // Write other products to temp file
	                } catch (EOFException e) {
	                    break; // End of file reached
	                }
	            }

	            if (!found) {
	                System.out.println("Product with name " + productName + " not found.");
	                tempFile.delete(); // Delete temporary file
	            } else {
	                if (!productFile.delete()) {
	                    System.out.println("Error deleting original product file.");
	                    return false;
	                }
	                if (!tempFile.renameTo(productFile)) {
	                    System.out.println("Error renaming temporary file to product file.");
	                    return false;
	                }
	            }
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return false;
	        }

	        System.out.println("Press Enter to continue...");
	        try {
	            System.in.read();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return true;
	    }

	    public static boolean listingOfLocalVendorsandProducts() {
	        File productFile = new File("products.bin");
	        File vendorFile = new File("vendor.bin");

	        if (!productFile.exists()) {
	            System.out.println("Error opening product file.");
	            return false;
	        }

	        if (!vendorFile.exists()) {
	            System.out.println("Error opening vendor file.");
	            return false;
	        }

	        System.out.println("\n--- Listing All Vendors and Their Products ---\n");

	        try (
	            FileInputStream vendorFis = new FileInputStream(vendorFile);
	            ObjectInputStream vendorInput = new ObjectInputStream(vendorFis);
	            FileInputStream productFis = new FileInputStream(productFile);
	            ObjectInputStream productInput = new ObjectInputStream(productFis);
	        ) {
	            Scanner scanner = new Scanner(System.in);
	            boolean vendorFound = false;

	            while (true) {
	                Vendor vendor;
	                try {
	                    vendor = (Vendor) vendorInput.readObject();
	                } catch (EOFException e) {
	                    break; // End of file
	                }

	                System.out.println("\nVendor: " + vendor.getName() + " (ID: " + vendor.getId() + ")");
	                System.out.println("--------------------------");
	                System.out.println("Select Collision Resolution Strategy for Vendor " + vendor.getId() + ":");
	                System.out.println("1. Linear Probing");
	                System.out.println("2. Quadratic Probing");
	                System.out.println("3. Double Hashing");
	                System.out.println("4. Linear Quotient");
	                System.out.println("5. Progressive Overflow");
	                System.out.println("6. Use of Buckets");
	                System.out.println("7. Brent's Method");
	                System.out.println("8. Exit");
	                int strategy = scanner.nextInt();

	                if (strategy == 8) {
	                    System.out.println("Exiting the vendor list.");
	                    return true;
	                }

	                productFis.getChannel().position(0); // Reset file to start
	                boolean productFound = false;

	                switch (strategy) {
	                    case 1:
	                        productFound = linearProbing(productInput, vendor.getId());
	                        break;
	                    case 2:
	                        productFound = quadraticProbing(productInput, vendor.getId());
	                        break;
	                    case 3:
	                        productFound = doubleHashing(productInput, vendor.getId());
	                        break;
	                    case 4:
	                        productFound = linearQuotient(productInput, vendor.getId());
	                        break;
	                    case 5:
	                        productFound = progressiveOverflow(productInput, vendor.getId());
	                        break;
	                    case 6:
	                        productFound = useOfBuckets(productInput, vendor.getId());
	                        break;
	                    case 7:
	                        productFound = brentsMethod(productInput, vendor.getId());
	                        break;
	                    default:
	                        System.out.println("Invalid strategy selected.");
	                        break;
	                }

	                if (!productFound) {
	                    System.out.println("No products available for this vendor.");
	                }
	                vendorFound = true;
	            }

	            if (!vendorFound) {
	                System.out.println("No products found for any vendor.");
	            }
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return false;
	        }

	        System.out.println("\nPress Enter to return to menu...");
	        try {
	            System.in.read();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
	    
	    public static boolean linearProbing(ObjectInputStream input, int vendorId) throws IOException, ClassNotFoundException {
	        boolean found = false;
	        while (true) {
	            try {
	                Product product = (Product) input.readObject();
	                if (product.getVendorId() == vendorId) {
	                    printProductDetails(product);
	                    found = true;
	                }
	            } catch (EOFException e) {
	                break; // End of file
	            }
	        }
	        return found;
	    }

	    public static boolean quadraticProbing(ObjectInputStream input, int vendorId) throws IOException, ClassNotFoundException {
	        // Similar to linearProbing
	        return linearProbing(input, vendorId);
	    }

	    public static boolean doubleHashing(ObjectInputStream input, int vendorId) throws IOException, ClassNotFoundException {
	        // Similar to linearProbing
	        return linearProbing(input, vendorId);
	    }

	    public static boolean linearQuotient(ObjectInputStream input, int vendorId) throws IOException, ClassNotFoundException {
	        // Similar to linearProbing
	        return linearProbing(input, vendorId);
	    }

	    public static boolean progressiveOverflow(ObjectInputStream input, int vendorId) throws IOException, ClassNotFoundException {
	        // Similar to linearProbing
	        return linearProbing(input, vendorId);
	    }

	    public static boolean useOfBuckets(ObjectInputStream input, int vendorId) throws IOException, ClassNotFoundException {
	        // Similar to linearProbing
	        return linearProbing(input, vendorId);
	    }

	    public static boolean brentsMethod(ObjectInputStream input, int vendorId) throws IOException, ClassNotFoundException {
	        // Similar to linearProbing
	        return linearProbing(input, vendorId);
	    }

	    public static void printProductDetails(Product product) {
	        System.out.printf("Product: %s, Price: %.2f, Quantity: %d, Season: %s\n",
	                product.getProductName(), product.getPrice(), product.getQuantity(), product.getSeason());
	    }

	    public static class PriceComparison {

	        private static Scanner scanner = new Scanner(System.in);

	        public static void clearScreen() {
	            // Terminali temizlemek için basit bir yöntem. İşletim sistemine bağlı olarak değişiklik gösterebilir.
	            System.out.print("\033[H\033[2J");
	            System.out.flush();
	        }

	        public static int getInput() {
	            // Kullanıcıdan bir tamsayı değeri alınması
	            int input = scanner.nextInt();
	            scanner.nextLine(); // Enter tuşundan sonra kalan newline karakterini temizler.
	            return input;
	        }

	        public static int selectProduct(StringBuffer selectedProductName) {
	            out.print("Enter the product name to select: ");
	            String input = scanner.nextLine();
	            if (!input.isEmpty()) {
	                selectedProductName.setLength(0); // Önceki değeri temizle
	                selectedProductName.append(input);
	                return 0; // Başarılı
	            }
	            return 1; // Başarısız
	        }

	        public static void comparePricesByName(String productName) {
	            // Fiyat karşılaştırma işlemleri burada yapılacaktır.
	            out.printf("Comparing prices for: %s\n", productName);
	            // Ürün fiyatlarını karşılaştırma işlemi
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
	                        if (selectProduct(selectedProductName) == 0) {
	                            out.printf("Product '%s' selected.\n", selectedProductName.toString());
	                        } else {
	                            out.println("Product selection failed.");
	                        }
	                        break;
	                    case 2:
	                        if (selectedProductName.length() > 0) {
	                            comparePricesByName(selectedProductName.toString());
	                        } else {
	                            out.println("No product selected. Please select a product first.");
	                        }
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

	        public static void main(String[] args) {
	            priceComparison();
	        }
	    }

	    public static boolean selectProduct() {
	        Scanner scanner = new Scanner(System.in);
	        File productFile = new File("products.bin");
	        try {
	            Scanner fileScanner = new Scanner(productFile);
	            out.println("\n--- Available Products ---");
	            int productCount = 0;

	            while (fileScanner.hasNextLine()) {
	                String line = fileScanner.nextLine();
	                String[] details = line.split(", ");
	                Product product = new Product();
	                out.printf("Name: %s, Price: %.2f, Quantity: %d, Season: %s, Vendor ID: %d\n", product.getProductName(), product.getPrice(), product.getQuantity(), product.getSeason(), product.getVendorId());
	                productCount++;
	            }
	            fileScanner.close();

	            if (productCount == 0) {
	                out.println("No products available.");
	                return false;
	            }

	            out.println("Enter the Product Name to select: ");
	            String selectedProductName = scanner.nextLine();

	            // Check if the product has been selected again
	            fileScanner = new Scanner(productFile);
	            boolean found = false;
	            while (fileScanner.hasNextLine()) {
	                String line = fileScanner.nextLine();
	                String[] details = line.split(", ");
	                if (details[0].equals(selectedProductName)) {
	                    out.printf("Selected Product: %s, Price: %.2f\n", details[0], Double.parseDouble(details[1]));
	                    found = true;
	                    break;
	                }
	            }

	            fileScanner.close();

	            if (!found) {
	                out.printf("Product with Name '%s' not found.\n", selectedProductName);
	                return false;
	            }

	        } catch (FileNotFoundException e) {
	            out.println("Error opening product file.");
	            return false;
	        }

	        return true;
	    }

	    public static void main(String[] args) {
	        if (selectProduct()) {
	            out.println("Product selection successful.");
	        } else {
	            out.println("Product selection failed.");
	        }
	    }
	    
	    public boolean comparePricesByName(String productName) {
	        File productFile;
	        Product[] products = new Product[100];
	        int productCount = 0;
	        boolean found = false;

	        try {
	            productFile = new File("products.bin");
	            Scanner scanner = new Scanner(productFile);
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                String[] details = line.split(",");
	                Product product = new Product(Integer.parseInt(details[0]), details[1], Double.parseDouble(details[2]), Integer.parseInt(details[3]), details[4]);
	                if (product.getProductName().equals(productName)) {
	                    products[productCount++] = product;
	                    found = true;
	                }
	            }
	            scanner.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Error opening product file.");
	            return false;
	        }

	        if (!found) {
	            System.out.println("No prices found for Product Name '" + productName + "'.");
	            return false;
	        }

	        // Sort products by price (using heap sort)
	        heapSort(products, productCount);

	        // Print sorted products
	        System.out.println("\n--- Price Comparison for Product Name '" + productName + "' (Sorted by Price) ---");
	        for (int i = 0; i < productCount; i++) {
	            System.out.println("Vendor ID: " + products[i].getVendorId() + ", Price: " + String.format("%.2f", products[i].getPrice()));
	        }

	        System.out.println("\nLowest Price: " + String.format("%.2f", products[0].getPrice()));
	        System.out.println("Highest Price: " + String.format("%.2f", products[productCount - 1].getPrice()));
	        return true;
	    }

	    private void heapSort(Product[] arr, int n) {
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapify(arr, n, i);
	        }

	        for (int i = n - 1; i >= 0; i--) {
	            Product temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;

	            heapify(arr, i, 0);
	        }
	    }

	    private void heapify(Product[] arr, int n, int i) {
	        int largest = i;
	        int left = 2 * i + 1;
	        int right = 2 * i + 2;

	        if (left < n && arr[left].getPrice() > arr[largest].getPrice())
	            largest = left;

	        if (right < n && arr[right].getPrice() > arr[largest].getPrice())
	            largest = right;

	        if (largest != i) {
	            Product swap = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = swap;

	            heapify(arr, n, largest);
	        }
	    
	    }

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
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("==========================================");
	            System.out.println("|      Market Hours and Locations        |");
	            System.out.println("==========================================");
	            System.out.println("| 1. Add Working Hours and Location      |");
	            System.out.println("| 2. Update Market Hours and Location    |");
	            System.out.println("| 3. View Market Hours and Locations     |");
	            System.out.println("| 0. Return to Main Menu                 |");
	            System.out.println("==========================================");
	            System.out.print("Choose an option: ");

	            if (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a valid option.");
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
	                    //updateMarketHoursAndLocation();
	                    break;
	                case 3:
	                 //   displayMarketHoursAndLocations();
	                    break;
	                case 0:
	                    System.out.println("Returning to main menu...");
	                    break;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	                    break;
	            }
	        } while (choice != 0);

	        return true;
	    }

	    
	    
	    public static boolean addMarketHoursAndLocation() {
	        try (FileOutputStream fos = new FileOutputStream("marketHours.bin", true);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             FileInputStream fis = new FileInputStream("vendor.bin");
	             ObjectInputStream ois = new ObjectInputStream(fis)) {

	            Scanner scanner = new Scanner(System.in);
	            MarketHours market = new MarketHours();
	            boolean found = false;

	            System.out.print("Enter Market ID: ");
	            while (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a valid numeric Market ID: ");
	                scanner.next(); // Clear invalid input
	            }
	            market.setId(scanner.nextInt());
	            scanner.nextLine(); // Clear the buffer

	            // Read vendors from the file and check for the given Market ID
	            List<Vendor> vendors = new ArrayList<>();
	            try {
	                while (true) {
	                    Vendor vendor = (Vendor) ois.readObject();
	                    vendors.add(vendor);
	                    if (vendor.getId() == market.getId()) { // getId() metodu ile vendorId'ye erişiyoruz
	                        found = true;
	                        break;
	                    }
	                }
	            } catch (EOFException e) {
	                // End of file reached
	            }

	            if (!found) {
	                System.out.println("Invalid Market ID. Please enter a valid Market ID from vendor.bin: ");
	                while (!found) {
	                    System.out.print("Enter Market ID: ");
	                    while (!scanner.hasNextInt()) {
	                        System.out.println("Invalid input. Please enter a valid numeric Market ID: ");
	                        scanner.next(); // Clear invalid input
	                    }
	                    market.setId(scanner.nextInt());
	                    scanner.nextLine(); // Clear the buffer

	                    for (Vendor vendor : vendors) {
	                    	if (vendor.getId() == market.getId()) { // getId() metodu ile vendorId'ye erişiyoruz
	                    	    found = true;
	                    	    break;
	                    	}
	                    }

	                    if (!found) {
	                        System.out.println("Invalid Market ID. Please try again.");
	                    }
	                }
	            }

	            MarketHours Market = new MarketHours(); 
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

	            // Write market hours to the file
	            oos.writeObject(market);
	            System.out.println("Market hours and location added successfully!");

	            return true;
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
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

	    private static boolean validateWorkingHours(String hours) {
	        // Validate format and logic (e.g., "09:00 - 18:00")
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

	    public boolean updateMarketHoursAndLocation() {
	        Scanner scanner = new Scanner(System.in);

	        try (RandomAccessFile file = new RandomAccessFile("marketHours.bin", "rw")) {
	            System.out.print("Enter Market ID to update: ");
	            int marketId;
	            while (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a valid numeric Market ID: ");
	                scanner.next(); // Clear invalid input
	            }
	            marketId = scanner.nextInt();
	            scanner.nextLine(); // Clear the buffer

	            boolean found = false;
	            while (file.getFilePointer() < file.length()) {
	                long recordPosition = file.getFilePointer(); // Remember the record position
	                MarketHours market = new MarketHours();
	                market.readFromFile(file);

	                if (market.getId() == marketId) {
	                    found = true;

	                    System.out.print("Enter new Day (e.g., Monday): ");
	                    String day = scanner.nextLine();
	                    while (!validateDay(day)) {
	                        System.out.println("Invalid day. Please enter a valid day (e.g., Monday): ");
	                        day = scanner.nextLine();
	                    }

	                    System.out.print("Enter new Working Hours (e.g., 09:00 - 18:00): ");
	                    String hours = scanner.nextLine();
	                    while (!validateWorkingHours(hours)) {
	                        System.out.println("Invalid hours. Please enter valid hours (e.g., 09:00 - 18:00): ");
	                        hours = scanner.nextLine();
	                    }

	                    System.out.print("Enter new Location: ");
	                    String location = scanner.nextLine();

	                    // Update the market object
	                    market.setDay(day);
	                    market.setHours(hours);
	                    market.setLocation(location);

	                    // Write updated market hours back to the file
	                    file.seek(recordPosition);
	                    market.writeToFile(file);

	                    System.out.println("Market hours and location updated successfully!");
	                    break;
	                }
	            }

	            if (!found) {
	                System.out.printf("Market ID %d not found.%n", marketId);
	            }
	        } catch (IOException e) {
	            System.out.println("Error accessing the market hours file: " + e.getMessage());
	            return false;
	        }

	        return true;
	    }
    
	    public static boolean displayMarketHoursAndLocations() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("marketHours.bin"))) {
        MarketHoursNode head = null;

        // Read all MarketHours from the file and insert into the XOR linked list
        while (true) {
            try {
                MarketHours market = (MarketHours) ois.readObject();
                head = insertXORList(head, market);
            } catch (EOFException e) {
                break;
            }
        }

        // Traverse and display the XOR linked list grouped by ID
        traverseXORListGroupedByID(head);
        return true;

    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error opening market hours file.");
        return false;
    }
}

	 // XOR bağlantısını simüle etmek için bir HashMap kullanıyoruz
	    private static final Map<Integer, MarketHoursNode> xorMap = new HashMap<>();

	    // XOR işlemini gerçekleştiren fonksiyon
	    public static MarketHoursNode xorFunction(MarketHoursNode a, MarketHoursNode b) {
	        int aAddress = (a != null) ? System.identityHashCode(a) : 0;
	        int bAddress = (b != null) ? System.identityHashCode(b) : 0;

	        int xorKey = aAddress ^ bAddress; // XOR işleminden elde edilen anahtar
	        return xorMap.get(xorKey); // XOR sonucu ile eşleşen düğümü döndür
	    }

	    // XOR Map'e düğüm ekleme
	    public static void addToXorMap(MarketHoursNode node) {
	        xorMap.put(System.identityHashCode(node), node);
	    }

	    // XOR bağlantı listesine düğüm ekleyen fonksiyon
	    public static MarketHoursNode insertXORList(MarketHoursNode head, MarketHours data) {
	        MarketHoursNode newNode = new MarketHoursNode(data);
	        addToXorMap(newNode); // Yeni düğümü XOR Map'e ekle

	        if (head == null) {
	            return newNode; // Eğer liste boşsa, yeni düğüm baş düğüm olur
	        }

	        MarketHoursNode prev = null;
	        MarketHoursNode curr = head;

	        // Düğümü uygun yerine yerleştirmek için listeyi dolaşıyoruz
	        while (curr != null && data.getId() > curr.data.getId()) {
	            MarketHoursNode next = xorFunction(prev, curr.xorPtr);
	            prev = curr;
	            curr = next;
	        }

	        // Yeni düğümü yerleştiriyoruz
	        newNode.xorPtr = xorFunction(prev, curr);

	        if (prev != null) {
	            prev.xorPtr = xorFunction(xorFunction(prev.xorPtr, curr), newNode);
	        }

	        if (curr != null) {
	            curr.xorPtr = xorFunction(newNode, xorFunction(curr.xorPtr, prev));
	        }

	        // Baş düğüm değişmediyse mevcut baş düğümü döndür
	        return (prev == null) ? newNode : head;
	    }

	    public static void traverseXORListGroupedByID(MarketHoursNode head) {
    MarketHoursNode curr = head;
    MarketHoursNode prev = null;
    MarketHoursNode next;
    Scanner scanner = new Scanner(System.in);

    while (curr != null) {
        int currentID = curr.data.getId();

        // Clear the screen (use "cls" for Windows, "clear" for Linux/Mac)
        

        // Display all entries with the same ID
        System.out.println("--- Market Hours and Locations (Use 'n' for next ID group, 'p' for previous ID group, 'q' to quit) ---");
        System.out.println("ID: " + currentID);
        while (curr != null && curr.data.getId() == currentID) {
            System.out.printf("  Day: %s, Hours: %s, Location: %s%n",
                    curr.data.getDay(), curr.data.getHours(), curr.data.getLocation());
            next = xorFunction(prev, curr.xorPtr);
            prev = curr;
            curr = next;
        }

        // User interaction for next or previous group
        if (curr != null || prev != null) {
            System.out.print("Enter your choice (n/p/q): ");
            char choice = scanner.next().charAt(0);

            if (choice == 'n') {
                // Continue to next group (already set in curr)
            } else if (choice == 'p') {
                // Traverse back to the start of the previous ID group
                while (prev != null && prev.data.getId() == currentID) {
                    next = xorFunction(prev.xorPtr, curr);
                    curr = prev;
                    prev = next;
                }

                // Now go further back to reach the start of the previous group
                if (prev != null) {
                    currentID = prev.data.getId();
                    while (prev != null && prev.data.getId() == currentID) {
                        next = xorFunction(prev.xorPtr, curr);
                        curr = prev;
                        prev = next;
                    }
                    // After the above loop, 'curr' will be at the start of the previous group
                } else {
                    System.out.println("You have reached the beginning of the list.");
                    curr = head;  // Reset to the head
                    prev = null;
                }
            } else if (choice == 'q') {
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'n', 'p', or 'q'.");
            }
        } else {
            System.out.println("You have reached the end of the list.");
        }
    }
}

// XOR Function for nodes
	 // XOR işlemini gerçekleştiren fonksiyon
	    private MarketHoursNode xor(MarketHoursNode a, MarketHoursNode b) {
	        if (a == null && b == null) {
	            return null; // Her iki düğüm de null ise null döndür
	        }
	        if (a == null) {
	            return b; // Birinci düğüm null ise ikinci düğümü döndür
	        }
	        if (b == null) {
	            return a; // İkinci düğüm null ise birinci düğümü döndür
	        }

	        // XOR Map kullanarak sonuç düğümü döndür
	        int xorKey = System.identityHashCode(a) ^ System.identityHashCode(b); // Adres XOR işlemi
	        return xorMap.get(xorKey); // XOR sonucu eşleşen düğümü döndür
	    }

    
}

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	    
	



	

