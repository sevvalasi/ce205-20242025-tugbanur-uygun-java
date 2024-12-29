package com.sevval.tugba.naz.irem.market;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @class MarketTest
 * @brief Test class for the Market class.
 */
public class MarketTest {

  private static final String userFile = "users.dat";
  private static final String vendorFile = "vendors.dat";
  private static final String productFile = "products.dat";
  private static final String marketHoursFile = "marketHours.dat";
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final InputStream originalIn = System.in;
  Scanner InputScanner = new Scanner(System.in);




  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    // Cleanup test files
    new File(userFile).delete();
    new File(vendorFile).delete();
    new File(productFile).delete();
    new File(marketHoursFile).delete();
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  /*@Test
  public void testCreateTestUserFile() {
    File file = new File(userFile);
    assertTrue(file.exists());
  }

  @Test
  public void testCreateTestVendorFile() {
    File file = new File(vendorFile);
    assertTrue(file.exists());
  }

  @Test
  public void testCreateTestProductFile() {
    File file = new File(productFile);
    assertTrue(file.exists());
  }

  @Test
  public void testCreateTestMarketHoursFile() {
    File file = new File(marketHoursFile);
    assertTrue(file.exists());
  }*/

  private void createEmptyTestHuffFile(String fileName) {
    try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
      // Dosyaya hiçbir veri yazılmıyor, boş bir dosya oluşturuluyor
    } catch (IOException e) {
      e.printStackTrace();
      fail("Failed to create empty test Huff file");
    }
  }

  private void createTestHuffFile(String fileName, String username, String password) {
    try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
      // Kullanıcı adı ve şifreyi dosyaya yaz
      byte[] usernameBytes = username.getBytes();
      byte[] passwordBytes = password.getBytes();
      file.writeInt(usernameBytes.length);
      file.write(usernameBytes);
      file.writeInt(passwordBytes.length);
      file.write(passwordBytes);
    } catch (IOException e) {
      e.printStackTrace();
      fail("Failed to create test Huff file");
    }
  }


  private static void initializeTestEnvironment() throws Exception {
    createTestUserFile();
    createTestVendorFile();
    createTestProductFile();
    createTestMarketHoursFile();
    initializeTestHashTable();
  }

  private static void createTestUserFile() throws Exception {
    String[][] users = {
            {"tugba", "password123"},
            {"naz", "password456"}
    };
    writeObjectToFile(userFile, users);
  }

  private static void createTestVendorFile() throws Exception {
    Object[][] vendors = {
            {1, "Vendor1"},
            {2, "Vendor2"}
    };
    writeObjectToFile(vendorFile, vendors);
  }

  private static void createTestProductFile() throws Exception {
    Object[][] products = {
            {1, "Tomato", 25, 100, "Winter"},
            {2, "Apple", 30, 50, "Fall"}
    };
    writeObjectToFile(productFile, products);
  }

  private static void createTestMarketHoursFile() throws Exception {
    Object[][] marketHours = {
            {1, "monday", "9:00 - 5:00", "Main Street"},
            {2, "tuesday", "10:00 - 6:00", "Market Square"}
    };
    writeObjectToFile(marketHoursFile, marketHours);
  }

  private static void initializeTestHashTable() throws Exception {
    Map<Integer, Double> hashTable = new HashMap<>();
    hashTable.put(101, 10.5); // Vendor 1 için ürün 101
    hashTable.put(102, 15.0); // Vendor 2 için ürün 102
    writeObjectToFile("hashTable.dat", hashTable);
  }

  private static void writeObjectToFile(String fileName, Object object) throws Exception {
    try (FileOutputStream fos = new FileOutputStream(fileName);
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(object);
    }
  }

  @Test
  public void testUserAuthentication1() {
    // Arrange
    String input = "2\nnaz\n1234\n\n1\na\n4"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output

    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.userAuthentication();


  }

  @Test
  public void testuserAuthenticationGuestMode() {
    // Arrange
    String input = "3\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.userAuthentication();

  }

  @Test
  public void testMainMenu() {
    // Arrange
    String input = "1\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();


  }
  @Test
  public void testMainMenu2() {
    // Arrange
    String input = "2\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();


  }

    @Test
  public void testMainMenu3() {
    // Arrange
    String input = "3\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();


  }
  @Test
  public void testMainMenu4() {
    // Arrange
    String input = "4\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();


  }


  @Test
  public void testMainMenu5() {
    // Arrange
    String input = "5\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();


  }
  @Test
  public void testMainMenuExit() {
    // Arrange
    String input = "0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();

  }


  @Test
  public void testuserAuthenticationRegister() {
    // Arrange
    String input = "2\nasd\nasd\n\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.userAuthentication();

  }



//  @Test
//  public void testuserAuthenticationLogin() {
//    // Arrange
//    String input = "1\nnaz\n1818\n0\n4\n"; // Choose option 0 to exit
//    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//    System.setIn(inputStream);
//    Market market = new Market(new Scanner(System.in), System.out);
//    // Act
//    boolean result = Market.userAuthentication();
//
//  }

  @Test
  public void testAddVendor() {
    // Arrange
    String input = "1\nelma\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.listingOfLocalVendors();

  }

  @Test
  public void testUpdateVendor() {
    // Arrange
    String input = "2\n567269\nelmaa\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.listingOfLocalVendors();

  }

  @Test
  public void testDeleteVendor() {
    // Arrange
    String input = "3\n655538\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.listingOfLocalVendors();

  }

  @Test
  public void testListVendor() {
    // Arrange
    String input = "4\nn\np\ns\nq\nx\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.listingOfLocalVendors();

  }


  @Test
  public void testaddProduct() {
    // Arrange
    String input = "1\n655538\nelma\n12\n122\nyaz\n\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.listingOfLocalProducts();

  }

  // Helper method to create vendor data for testing
  private void createVendorFileForTest(String fileName, int vendorId, String vendorName) throws IOException {
    try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
      raf.setLength(0); // Clear file
      raf.writeInt(vendorId);
      raf.writeUTF(vendorName);
    }
  }


  @Test
  public void testupdateProduct() {
    // Arrange
    String input = "2\nelma\nelmaa\n11\n12\nkış\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.listingOfLocalProducts();

  }


  @Test
  public void testDeleteProduct() {
    // Arrange
    String input = "3\naramutt\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.listingOfLocalProducts();

  }

  @Test
  public void testListingOfLocalVendorsandProducts() throws Exception {
    // Arrange
    String vendorFileName = "vendor.bin";
    String productFileName = "products.bin";

    // Create dummy vendor and product data for the test
    createVendorFileForTest(vendorFileName, new Vendor(1, "Vendor A"), new Vendor(2, "Vendor B"));
    createProductFileForTest(productFileName,
            new Product(1, "Product X", 100.0, 10, "Summer"),
            new Product(1, "Product Y", 200.0, 5, "Winter"),
            new Product(2, "Product Z", 300.0, 20, "Spring")
    );

    // Simulate user input: Choose a strategy and exit
    String input = "1\n"; // Select "Linear Probing" and then Exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    boolean result = Market.listingOfLocalVendorsandProducts();

    // Assert
    assertTrue("Listing of local vendors and products should return true", result);
    String output = outputStream.toString();
    assertTrue(output.contains("Vendor: Vendor A")); // Check if vendor is listed
    assertTrue(output.contains("Product: Product X")); // Check if products are listed
    assertTrue(output.contains("Using Linear Probing")); // Check collision resolution strategy
  }

  // Helper method to create vendor data for testing
  private void createVendorFileForTest(String fileName, Vendor... vendors) throws IOException {
    try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
      raf.setLength(0); // Clear file
      for (Vendor vendor : vendors) {
        vendor.writeToRandomAccessFile(raf);
      }
    }
  }

  // Helper method to create product data for testing
  private void createProductFileForTest(String fileName, Product... products) throws IOException {
    try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
      raf.setLength(0); // Clear file
      for (Product product : products) {
        product.writeToFile(raf);
      }
    }
  }

  @Test
  public void testReturnToMenuExit() {
    // Arrange
    String input = "0\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.listingOfLocalProducts();

  }


  @Test
  public void testpriceComparison() {
    // Arrange
    String input = "1\nelma\n\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.priceComparison();

}

  @Test
  public void testpriceComparison2() {
    // Arrange
    String input = "2\nelma\n\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.priceComparison();

  }

  @Test
  public void testLoginUserFromHuffFileValidCredentials() {
    // Arrange
    String testFileName = "test_users.huff";
    createTestHuffFile(testFileName, "validUser", "validPass");

    System.setOut(new PrintStream(new ByteArrayOutputStream())); // Suppress console output

    // Act
    boolean result = Market.loginUserFromHuffFile("validUser", "validPass");


    // Clean up
    new File(testFileName).delete();
  }

  @Test
  public void testLoginUserFromHuffFileInvalidUsername() {
    // Arrange
    String testFileName = "test_users.huff";
    createTestHuffFile(testFileName, "validUser", "validPass");

    System.setOut(new PrintStream(new ByteArrayOutputStream())); // Suppress console output

    // Act
    boolean result = Market.loginUserFromHuffFile("invalidUser", "validPass");

    // Assert
    assertFalse("Invalid username should return false", result);

    // Clean up
    new File(testFileName).delete();
  }

  @Test
  public void testLoginUserFromHuffFileInvalidPassword() {
    // Arrange
    String testFileName = "test_users.huff";
    createTestHuffFile(testFileName, "validUser", "validPass");

    System.setOut(new PrintStream(new ByteArrayOutputStream())); // Suppress console output

    // Act
    boolean result = Market.loginUserFromHuffFile("validUser", "invalidPass");

    // Assert
    assertFalse("Invalid password should return false", result);

    // Clean up
    new File(testFileName).delete();
  }

  @Test
  public void testLoginUserFromHuffFileEmptyFile() {
    // Arrange
    String testFileName = "test_users.huff";
    createEmptyTestHuffFile(testFileName);

    System.setOut(new PrintStream(new ByteArrayOutputStream())); // Suppress console output

    // Act
    boolean result = Market.loginUserFromHuffFile("validUser", "validPass");

    // Assert
    assertFalse("Empty file should return false", result);

    // Clean up
    new File(testFileName).delete();
  }


  @Test
  public void testAddVendorProductRelation() {
    // Arrange
    int vendorId = 1;
    int productId = 101;
    float price = 99.99f;

    // Act
    Market.addVendorProductRelation(vendorId, productId, price);

    // Assert
    assertEquals(1, Market.sparseMatrixSize); // Ensure the matrix size increased
    assertEquals(vendorId, Market.sparseMatrix[0].getVendorId());
    assertEquals(productId, Market.sparseMatrix[0].getProductId());
    assertEquals(price, Market.sparseMatrix[0].getPrice(), 0.01);
  }

  @Test
  public void testListProductsByVendor() {
    // Arrange
    Market.addVendorProductRelation(1, 101, 50.0f);
    Market.addVendorProductRelation(1, 102, 30.5f);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    boolean result = Market.listProductsByVendor(1);

    // Assert
    assertTrue(result);
    String output = outputStream.toString();
    assertTrue(output.contains("Product ID: 101, Price: 50.00"));
    assertTrue(output.contains("Product ID: 102, Price: 30.50"));
  }

  @Test
  public void testHashFunctions() {
    // Arrange
    int key = 123;

    // Act & Assert
    assertEquals(key % Market.TABLE_SIZE, Market.hashFunction(key));
    assertEquals((key + 1) % Market.TABLE_SIZE, Market.linearProbing(key, 1));
    assertEquals((key + 1 * 1) % Market.TABLE_SIZE, Market.quadraticProbing(key, 1));
    assertEquals((key % Market.TABLE_SIZE + 1 * (1 + (key % (Market.TABLE_SIZE - 1)))) % Market.TABLE_SIZE,
            Market.doubleHashing(key, 1));
  }

  @Test
  public void testWriteAndReadVendor() throws IOException {
    // Arrange
    String fileName = "vendorTest.bin";
    Vendor vendor = new Vendor(1, "Vendor A");

    // Act
    try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
      Market.writeVendor(raf, vendor);
    }

    Vendor readVendor;
    try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
      readVendor = Market.readVendor(raf);
    }

    // Assert
    assertEquals(vendor.getId(), readVendor.getId());
    assertEquals(vendor.getName(), readVendor.getName());

    // Cleanup
    new File(fileName).delete();
  }

  @Test
  public void testWriteAndReadProduct() throws IOException {
    // Arrange
    String fileName = "productTest.bin";
    Product product = new Product(1, "Product X", 99.99, 10, "Summer");

    // Act
    try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
      Market.writeProduct(raf, product);
    }

    Product readProduct;
    try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
      readProduct = Market.readProduct(raf);
    }

    // Assert
    assertNotNull(readProduct);
    assertEquals(product.getVendorId(), readProduct.getVendorId());
    assertEquals(product.getProductName(), readProduct.getProductName());
    assertEquals(product.getPrice(), readProduct.getPrice(), 0.01);
    assertEquals(product.getQuantity(), readProduct.getQuantity());
    assertEquals(product.getSeason(), readProduct.getSeason());

    // Cleanup
    new File(fileName).delete();
  }


  @Test
  public void testBrentsMethodSearch() {
    // Arrange
    Market.initializeHashTable();
    int key1 = 101, key2 = 202, key3 = 303;
    int index1 = Market.hashFunction(key1);
    int index2 = Market.linearProbing(key1, 1); // Intentional collision

    Market.hashTable[index1] = new HashTableEntry(true, key1);
    Market.hashTable[index2] = new HashTableEntry(true, key2);

    // Act
    int result = Market.brentsMethodSearch(key1);

    // Assert
    assertEquals(index1, result); // Brent's method should return the correct index
  }

  @Test
  public void testLinearProbing() {
    // Arrange
    int key = 20;
    int i = 1;
    int tableSize = Market.TABLE_SIZE;

    // Act
    int index = Market.linearProbing(key, i);

    // Assert
    assertEquals("Linear probing should calculate the correct index", (key + i) % tableSize, index);
  }

  @Test
  public void testQuadraticProbing() {
    // Arrange
    int key = 20;
    int i = 2;
    int tableSize = Market.TABLE_SIZE;

    // Act
    int index = Market.quadraticProbing(key, i);

    // Assert
    assertEquals("Quadratic probing should calculate the correct index", (key + i * i) % tableSize, index);
  }

  @Test
  public void testDoubleHashing() {
    // Arrange
    int key = 25;
    int i = 3;
    int tableSize = Market.TABLE_SIZE;
    int h1 = key % tableSize;
    int h2 = 1 + (key % (tableSize - 1));

    // Act
    int index = Market.doubleHashing(key, i);

    // Assert
    assertEquals("Double hashing should calculate the correct index", (h1 + i * h2) % tableSize, index);
  }

  @Test
  public void testLinearQuotient() {
    // Arrange
    int key = 15;
    int i = 4;
    int tableSize = Market.TABLE_SIZE;

    // Act
    int index = Market.linearQuotient(key, i);

    // Assert
    assertEquals("Linear quotient should calculate the correct index", (key + i * 7) % tableSize, index);
  }

  @Test
  public void testProgressiveOverflowSearch() {
    // Arrange
    int key = 30;
    int overflowSize = Market.OVERFLOW_SIZE;
    Market.initializeHashTable();

    // Add an entry to the overflow area
    Market.overflowArea[0] = new OverflowEntry(true, key);

    // Act
    boolean result = Market.progressiveOverflowSearch(key);

    // Assert
    assertTrue("Progressive overflow search should find the key", result);

    // Negative test: non-existent key
    int nonExistentKey = 999;
    boolean nonExistentResult = Market.progressiveOverflowSearch(nonExistentKey);
    assertFalse("Progressive overflow search should return false for a non-existent key", nonExistentResult);
  }


  @Test
  public void testmarketHoursAndLocations() {
    // Arrange
    String input = "4\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();


  }


  @Test
  public void testmarketHoursAndLocations1() {
    // Arrange
    String input = "1\n170369\nmonday\n11:00 - 12:00\nev\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();


  }

  @Test
  public void testmarketHoursAndLocations2() {
    // Arrange
    String input = "2\n170369\nmtuesday\n11:00 - 13:00\naraba\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();


  }

  @Test
  public void testmarketHoursAndLocations3() {
    // Arrange
    String input = "3\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();


  }


  @Test
  public void testmarketHoursAndLocationsExit() {
    // Arrange
    String input = "0\n0\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();

  }


  @Test
  public void testmarketHoursAndLocationsInvalidInput() {
    // Arrange
    String input = "33\n0\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();

  }

    @Test
    public void testValidateDayValidInputs() {
      // Valid day inputs
      assertTrue("Monday should be valid", Market.validateDay("Monday"));
      assertTrue("tuesday should be valid", Market.validateDay("tuesday"));
      assertTrue("WEDNESDAY should be valid", Market.validateDay("WEDNESDAY"));
      assertTrue("thursday should be valid", Market.validateDay("thursday"));
      assertTrue("Friday should be valid", Market.validateDay("Friday"));
      assertTrue("saturday should be valid", Market.validateDay("saturday"));
      assertTrue("SUNDAY should be valid", Market.validateDay("SUNDAY"));
    }

    @Test
    public void testValidateDayInvalidInputs() {
      // Invalid day inputs
      assertFalse("Invalid day 'Funday'", Market.validateDay("Funday"));
      assertFalse("Empty input should be invalid", Market.validateDay(""));
      assertFalse("Numeric input should be invalid", Market.validateDay("123"));
      assertFalse("Random string input should be invalid", Market.validateDay("RandomDay"));
    }

    @Test
    public void testValidateWorkingHoursValidInputs() {
      // Valid working hours inputs
      assertTrue("Valid hours '09:00 - 18:00'", Market.validateWorkingHours("09:00 - 18:00"));
      assertTrue("Valid hours '00:00 - 23:59'", Market.validateWorkingHours("00:00 - 23:59"));
      assertTrue("Valid hours '08:30 - 17:00'", Market.validateWorkingHours("08:30 - 17:00"));
    }

    @Test
    public void testValidateWorkingHoursInvalidInputs() {
      // Invalid formats
      assertFalse("Missing ' - ' separator", Market.validateWorkingHours("09:0018:00"));
      assertFalse("Invalid format '0900 - 1800'", Market.validateWorkingHours("0900 - 1800"));
      assertFalse("Single time provided", Market.validateWorkingHours("09:00"));
      assertFalse("Empty input", Market.validateWorkingHours(""));

      // Invalid logic
      assertFalse("End time earlier than start time", Market.validateWorkingHours("18:00 - 09:00"));
      assertFalse("End time equals start time", Market.validateWorkingHours("12:00 - 12:00"));
      assertFalse("Invalid hours '24:00 - 01:00'", Market.validateWorkingHours("24:00 - 01:00"));
      assertFalse("Invalid minutes '09:60 - 18:00'", Market.validateWorkingHours("09:60 - 18:00"));
      assertFalse("Non-numeric input 'xx:yy - zz:ww'", Market.validateWorkingHours("xx:yy - zz:ww"));
    }


  @Test
  public void testsearchProductsOrEnterKeyword() {
    // Arrange
    String input = "5\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.searchProductsOrEnterKeyword();


  }

  @Test
  public void testenterSearchProducts() {
    // Arrange
    String input = "1\nelmaa\n\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.enterSearchProducts();


  }


  @Test
  public void testenterKeywords() {
    // Arrange
    String input = "2\nelmaa\n\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.enterKeywords();


  }

  @Test
  public void testsearchProductsOrEnterKeywordExit() {
    // Arrange
    String input = "0\n0\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();

  }


}
