package com.sevval.tugba.naz.irem.market;

import static com.sevval.tugba.naz.irem.market.Market.out;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
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

  @Rule
  public ExpectedException thrown = ExpectedException.none();




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
  private Queue queue;
  private DoubleLinkedList doubleLinkedList;
  @Before
  public void setUp() throws Exception {

    queue = new Queue();
    doubleLinkedList = new DoubleLinkedList();

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
    String input = "2\nnaz\n1234\n\n1\nnaz\n1234\n0\n4\n"; // Simulated user input
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



  @Test
  public void testuserAuthenticationLogin() {
    // Arrange
    String input = "1\nnaz\n1818\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.userAuthentication();

  }




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
    String input = "1\n1\nee\n2\nee\neee\n0\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();

  }




  @Test
  public void testlistingOfLocalVendorsInvalid() {
    // Arrange
    String input = "1\n123\n0\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();

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
    String input = "2\n1\n1\nnaz\n12\n12\nyaz\n\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();

  }


  @Test
  public void testaddProductEror() {
    // Arrange
    String input = "2\n1\n1\nnaz\n12\n12\nyaz\n\n1\n123456\n\n0\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();

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
    String input = "2\n1\n1\naa\n12\n12\nyaz\n\n2\naa\naaa\n12\n13\nyaz\n\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();

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

  @Test
  public void testListingOfLocalVendorsandProducts2() throws Exception {
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
    String input = "2\n"; // Select "Linear Probing" and then Exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    boolean result = Market.listingOfLocalVendorsandProducts();

  }

  @Test
  public void testListingOfLocalVendorsandProducts3() throws Exception {
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
    String input = "3\n"; // Select "Linear Probing" and then Exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    boolean result = Market.listingOfLocalVendorsandProducts();

  }

  @Test
  public void testListingOfLocalVendorsandProducts4() throws Exception {
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
    String input = "4\n"; // Select "Linear Probing" and then Exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    boolean result = Market.listingOfLocalVendorsandProducts();

  }

  @Test
  public void testListingOfLocalVendorsandProducts5() throws Exception {
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
    String input = "5\n"; // Select "Linear Probing" and then Exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    boolean result = Market.listingOfLocalVendorsandProducts();

  }

  @Test
  public void testListingOfLocalVendorsandProducts6() throws Exception {
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
    String input = "6\n"; // Select "Linear Probing" and then Exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    boolean result = Market.listingOfLocalVendorsandProducts();

  }

  @Test
  public void testListingOfLocalVendorsandProducts7() throws Exception {
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
    String input = "7\n"; // Select "Linear Probing" and then Exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    boolean result = Market.listingOfLocalVendorsandProducts();

  }


  @Test
  public void testListingOfLocalVendorsandProductsInvalid() throws Exception {
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
    String input = "474\n"; // Select "Linear Probing" and then Exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    boolean result = Market.listingOfLocalVendorsandProducts();

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
    String input = "3\n1\naa\n\n\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();

}

  @Test
  public void testpriceComparisonInvalid() {
    // Arrange
    String input = "3\n13838\n\n\n0\n0\n4"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();

  }



  @Test
  public void testpriceComparison2() {
    // Arrange
    String input = "2\n1\n1\naa\n12\n12\nyaz\n\n0\n3\n1\naa\n\n\n2\n0\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();

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
  public void testBrentsMethodSearchWithEdgeCases() {
    // Arrange
    Market.initializeHashTable();
    int key1 = 101, key2 = 202;
    int index1 = Market.hashFunction(key1);
    int index2 = Market.linearProbing(key1, 1); // Intentional collision

    // Hash table durumunu simüle et
    Market.hashTable[index1] = new HashTableEntry(true, key1);
    Market.hashTable[index2] = new HashTableEntry(false, 0); // Boş bir slot

    // Act & Assert
    // Doğru bulunan anahtar testi
    assertEquals(index1, Market.brentsMethodSearch(key1));

    // Boş bir slot testi (bulunamayan anahtar)
    assertEquals(-1, Market.brentsMethodSearch(999));
  }


  @Test
  public void testBrentsMethodSearchWithCollisions() {
    // Arrange
    Market.initializeHashTable();
    int key1 = 101, key2 = 202, key3 = 303;
    int index1 = Market.hashFunction(key1);
    int index2 = Market.linearProbing(key1, 1); // Intentional collision
    int index3 = Market.linearProbing(key1, 2); // Another collision resolution

    // Simulate the hash table state with collisions
    Market.hashTable[index1] = new HashTableEntry(true, key1);
    Market.hashTable[index2] = new HashTableEntry(true, key2);

    // Empty slot for new index (to test return -1 path)
    Market.hashTable[index3] = new HashTableEntry(false, 0);

    // Act & Assert for key1 (existing key, direct index match)
    int result1 = Market.brentsMethodSearch(key1);
    assertEquals(index1, result1);

    // Act & Assert for key2 (collision handled by linear probing)
    int result2 = Market.brentsMethodSearch(key2);
    assertEquals(index2, result2);

    // Act & Assert for non-existing key (should return -1)
    int nonExistingKey = 404;
    int result3 = Market.brentsMethodSearch(nonExistingKey);
    assertEquals(-1, result3);

    // Act & Assert for a key where linear probing fails (empty slot encountered)
    int result4 = Market.brentsMethodSearch(key3);
    assertEquals(-1, result4);
  }




//
//  @Test
//  public void testLinearProbing() {
//    // Arrange
//    int key = 20;
//    int i = 1;
//    int tableSize = Market.TABLE_SIZE;
//
//    // Act
//    int index = Market.linearProbing(key, i);
//
//    // Assert
//    assertEquals("Linear probing should calculate the correct index", (key + i) % tableSize, index);
//  }



  @Test
  public void testLinearProbing() {
    // Arrange
    int key = 101;
    int i = 1;

    // Act
    int newIndex = Market.linearProbing(key, i);

    // Assert
    assertTrue(newIndex >= 0 && newIndex < Market.TABLE_SIZE);
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
  public void testHashFunction() {
    // Arrange
    int key = 101;

    // Act
    int index = Market.hashFunction(key);

    // Assert
    assertTrue(index >= 0 && index < Market.TABLE_SIZE);
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
  public void testmarketHoursAndLocationsInvalid1() {
    // Arrange
    String input = "1\n3883\n\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();


  }



  @Test
  public void testaddmarketHoursAndLocations1() {
    // Arrange
    String input = "4\n1\n1\nmonday\n11:00 - 12:00\nev\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();


  }




  @Test
  public void testaddmarketHoursAndLocations1Invalid() {
    // Arrange
    String input = "4\n1\n123\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();


  }

  @Test
  public void testmarketHoursAndLocationsInvalidInput2() {
    // Arrange
    String input = "adkdk\n0\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();

  }



  @Test
  public void testUpdateMarketHoursAndLocations() {
    // Arrange
    String input = "4\n1\n1\nmonday\n11:00 - 12:00\nev\n2\n1\nmonday\n02:02 - 02:03\nev\n3\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();


  }


  @Test
  public void testUpdateMarketHoursAndLocationsInvalid() {
    // Arrange
    String input = "4\n1\n1\nmonday\n11:00 - 12:00\nev\n2\n3939393\nmonday\n02:02 - 02:03\nev\n3\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.marketHoursAndLocations();


  }


  @Test
  public void testviewmarketHoursAndLocations3() {
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
  public void testXorValid() {
    // Arrange
    String input = "1\n1\na\n1\nb\n1\nc\n4\nn\nn\nn\nn\np\ns\nq\nx\n0\n0\n4\n"; // Simulated user input
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.mainMenu();


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
  public void testInvalidOption() {
    // Arrange
    String input = "5\n0\n"; // 5 geçersiz bir seçenek
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    System.setIn(inputStream); // Simulate user input
    System.setOut(new PrintStream(outContent)); // Capture output
    Market market = new Market(new Scanner(System.in), System.out);

    // Act
    boolean result = Market.searchProductsOrEnterKeyword();

    // Assert
    String expectedOutput = "Invalid option. Please try again.\n";
    assertTrue(outContent.toString().contains(expectedOutput));
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
  public void testEnterSearchProducts1() {
    // Arrange
    String input = "1\n0\n\n0\n0n\n4\n"; // Case 1: Search Products, then Exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    boolean result = Market.enterKeywords();


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

  @Test
  public void testUserAuthenticationInvalid() {
    // Arrange
    String input = "11\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.userAuthentication();

  }

  @Test
  public void testLoginInvalid() {
    // Arrange
    String input = "1\nasdasdasd\nasdasdasdasd\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.userAuthentication();

  }

//
//  @Test
//  public void testmainMenuInvalid() {
//    // Arrange
//    String input = "3\n334\n4\n"; // Choose option 0 to exit
//    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//    System.setIn(inputStream);
//    Market market = new Market(new Scanner(System.in), System.out);
//    // Act
//    boolean result = Market.userAuthentication();
//
//  }
//


  @Test
  public void testVendorPop() {
    // Arrange
    String input = "1\nasdasdasd\nasdasdasdasd\n0\n4\n"; // Choose option 0 to exit
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Market market = new Market(new Scanner(System.in), System.out);
    // Act
    boolean result = Market.userAuthentication();

  }

  @Test
  public void testIsQueueEmpty() {
    assertTrue("Queue should be empty after initialization", queue.isQueueEmpty());

    Vendor vendor = new Vendor(1, "Vendor1");
    queue.enqueue(vendor);
    assertFalse("Queue should not be empty after adding a vendor", queue.isQueueEmpty());
  }

  @Test
  public void testEnqueueDequeue() {
    Vendor vendor1 = new Vendor(1, "Vendor1");
    Vendor vendor2 = new Vendor(2, "Vendor2");

    queue.enqueue(vendor1);
    queue.enqueue(vendor2);

    Vendor dequeuedVendor1 = queue.dequeue();
    assertEquals("Dequeued vendor should be Vendor1", vendor1, dequeuedVendor1);

    Vendor dequeuedVendor2 = queue.dequeue();
    assertEquals("Dequeued vendor should be Vendor2", vendor2, dequeuedVendor2);

    assertTrue("Queue should be empty after dequeuing all vendors", queue.isQueueEmpty());
  }

  @Test
  public void testDequeueFromEmptyQueue() {
    Vendor dequeuedVendor = queue.dequeue();
    assertEquals("Dequeuing from an empty queue should return an empty Vendor object", 0, dequeuedVendor.getId());
    assertEquals("Dequeuing from an empty queue should return an empty Vendor object", "", dequeuedVendor.getName());
  }

  @Test
  public void testFreeQueue() {
    Vendor vendor1 = new Vendor(1, "Vendor1");
    Vendor vendor2 = new Vendor(2, "Vendor2");

    queue.enqueue(vendor1);
    queue.enqueue(vendor2);

    queue.freeQueue();

    assertTrue("Queue should be empty after calling freeQueue", queue.isQueueEmpty());
  }


    @Test
    public void testConstructor() {
      // Create a Vendor object
      Vendor vendor = new Vendor(1, "Vendor1");

      // Create a StackNode with the Vendor object
      StackNode node = new StackNode(vendor);

      // Verify that the vendor object is correctly assigned
      assertNotNull(node.vendor);
      assertEquals(1, node.vendor.getId());
      assertEquals("Vendor1", node.vendor.getName());

      // Verify that the next pointer is null
      assertNull(node.next);
    }

    @Test
    public void testNextNodeLink() {
      // Create two Vendor objects
      Vendor vendor1 = new Vendor(1, "Vendor1");
      Vendor vendor2 = new Vendor(2, "Vendor2");

      // Create two StackNodes
      StackNode node1 = new StackNode(vendor1);
      StackNode node2 = new StackNode(vendor2);

      // Link the nodes
      node1.next = node2;

      // Verify that node1's next points to node2
      assertNotNull(node1.next);
      assertEquals(node2, node1.next);
      assertEquals("Vendor2", node1.next.vendor.getName());
    }




  @Test
  public void testDefaultConstructor() {
    // Create a new BPlusTreeNode
    BPlusTreeNode node = new BPlusTreeNode();

    // Verify the default properties
    assertTrue(node.getIsLeaf());
    assertNull(node.getNext());
    assertEquals(0, node.getKeyCount());

    // Verify that keys and children arrays are initialized
    for (int i = 0; i < 4; i++) {
      assertEquals(0, node.getKey(i));
      assertNull(node.getChild(i));
    }

    // Verify the extra child slot in children array
    assertNull(node.getChild(4));
  }

  @Test
  public void testConstructorWithLeafParameter() {
    // Create a non-leaf node
    BPlusTreeNode node = new BPlusTreeNode(false);

    // Verify the properties
    assertFalse(node.getIsLeaf());
    assertEquals(0, node.getKeyCount());
    assertNull(node.getNext());
  }

  @Test
  public void testSetAndGetKeys() {
    // Create a node and set keys
    BPlusTreeNode node = new BPlusTreeNode();
    node.setKey(0, 10);
    node.setKey(1, 20);

    // Verify keys are set correctly
    assertEquals(10, node.getKey(0));
    assertEquals(20, node.getKey(1));
  }

  @Test
  public void testSetAndGetChildren() {
    // Create nodes and set child relationships
    BPlusTreeNode parent = new BPlusTreeNode(false);
    BPlusTreeNode child1 = new BPlusTreeNode();
    BPlusTreeNode child2 = new BPlusTreeNode();

    parent.setChild(0, child1);
    parent.setChild(1, child2);

    // Verify children are set correctly
    assertEquals(child1, parent.getChild(0));
    assertEquals(child2, parent.getChild(1));
  }

  @Test
  public void testSetAndGetNext() {
    // Create nodes and set the next relationship
    BPlusTreeNode node1 = new BPlusTreeNode();
    BPlusTreeNode node2 = new BPlusTreeNode();

    node1.setNext(node2);

    // Verify next is set correctly
    assertEquals(node2, node1.getNext());
  }

  @Test
  public void testSetAndGetKeyCount() {
    // Create a node and set the key count
    BPlusTreeNode node = new BPlusTreeNode();
    node.setKeyCount(3);

    // Verify key count is set correctly
    assertEquals(3, node.getKeyCount());
  }

  @Test
  public void testLeafNodeProperties() {
    // Create a leaf node
    BPlusTreeNode leafNode = new BPlusTreeNode(true);

    // Verify it is a leaf and has no children by default
    assertTrue(leafNode.getIsLeaf());
    for (int i = 0; i < 5; i++) {
      assertNull(leafNode.getChild(i));
    }
  }


  @Test
  public void testInsertSorted() {
    Vendor vendor1 = new Vendor(3, "Vendor3");
    Vendor vendor2 = new Vendor(1, "Vendor1");
    Vendor vendor3 = new Vendor(2, "Vendor2");

    doubleLinkedList.insertSorted(vendor1);
    doubleLinkedList.insertSorted(vendor2);
    doubleLinkedList.insertSorted(vendor3);

    DoubleLinkedListNode current = doubleLinkedList.getHead();
    assertEquals(1, current.getVendor().getId()); // First node
    current = current.getNext();
    assertEquals(2, current.getVendor().getId()); // Second node
    current = current.getNext();
    assertEquals(3, current.getVendor().getId()); // Third node
    assertNull(current.getNext());
  }

  @Test
  public void testDisplayForward() {
    Vendor vendor1 = new Vendor(3, "Vendor3");
    Vendor vendor2 = new Vendor(1, "Vendor1");
    Vendor vendor3 = new Vendor(2, "Vendor2");

    doubleLinkedList.insertSorted(vendor1);
    doubleLinkedList.insertSorted(vendor2);
    doubleLinkedList.insertSorted(vendor3);

    // Capture console output (optional)
    doubleLinkedList.displayForward();

    DoubleLinkedListNode current = doubleLinkedList.getHead();
    assertEquals("Vendor1", current.getVendor().getName());
    current = current.getNext();
    assertEquals("Vendor2", current.getVendor().getName());
    current = current.getNext();
    assertEquals("Vendor3", current.getVendor().getName());
  }

  @Test
  public void testDisplayBackward() {
    Vendor vendor1 = new Vendor(3, "Vendor3");
    Vendor vendor2 = new Vendor(1, "Vendor1");
    Vendor vendor3 = new Vendor(2, "Vendor2");

    doubleLinkedList.insertSorted(vendor1);
    doubleLinkedList.insertSorted(vendor2);
    doubleLinkedList.insertSorted(vendor3);

    // Capture console output (optional)
    doubleLinkedList.displayBackward();

    DoubleLinkedListNode current = doubleLinkedList.getTail();

  }

  @Test
  public void testClear() {
    Vendor vendor1 = new Vendor(3, "Vendor3");
    Vendor vendor2 = new Vendor(1, "Vendor1");
    Vendor vendor3 = new Vendor(2, "Vendor2");

    doubleLinkedList.insertSorted(vendor1);
    doubleLinkedList.insertSorted(vendor2);
    doubleLinkedList.insertSorted(vendor3);

    doubleLinkedList.clear();

    assertNull(doubleLinkedList.getHead());
    assertNull(doubleLinkedList.getTail());
  }

  @Test
  public void testMinHeapInitialization() {
    // Arrange
    int capacity = 10;

    // Act
    MinHeap minHeap = new MinHeap(capacity);

    // Assert
    assertNotNull("Heap should not be null", minHeap);
    assertEquals("Heap size should be 0 initially", 0, minHeap.size);
    assertEquals("Heap capacity should match the given value", capacity, minHeap.capacity);
    assertNotNull("Heap array should not be null", minHeap.array);
    assertEquals("Heap array length should match the capacity", capacity, minHeap.array.length);
  }


//  @Test
//  public void testDefaultConstructor2() {
//    // Arrange & Act
//    HashTableEntry entry = new HashTableEntry();
//
//    // Assert
//    assertEquals("Default key should be -1", -1, entry.getKey());
//    assertFalse("Default isOccupied should be false", entry.isOccupied());
//  }

  @Test
  public void testParameterizedConstructor() {
    // Arrange
    boolean isOccupied = true;
    int key = 42;

    // Act
    HashTableEntry entry = new HashTableEntry(isOccupied, key);

    // Assert
    assertEquals("Key should match the value passed in constructor", key, entry.getKey());
    assertTrue("isOccupied should match the value passed in constructor", entry.isOccupied());
  }

  @Test
  public void testSetKey() {
    // Arrange
    HashTableEntry entry = new HashTableEntry();
    int newKey = 99;

    // Act
    entry.setKey(newKey);

    // Assert
    assertEquals("Key should be updated to the new value", newKey, entry.getKey());
  }

  @Test
  public void testSetOccupied() {
    // Arrange
    HashTableEntry entry = new HashTableEntry();

    // Act
    entry.setOccupied(true);

    // Assert
    assertTrue("isOccupied should be true after calling setOccupied(true)", entry.isOccupied());

    // Act
    entry.setOccupied(false);

    // Assert
    assertFalse("isOccupied should be false after calling setOccupied(false)", entry.isOccupied());
  }

  @Test
  public void testToString() {
    // Arrange
    HashTableEntry entry = new HashTableEntry(true, 101);

    // Act
    String result = entry.toString();

    // Assert
    assertEquals("String representation should match", "Key: 101, Is Occupied: true", result);
  }



  @Test
  public void testDefaultConstructor1() {
    // Arrange & Act
    OverflowEntry entry = new OverflowEntry();

    // Assert
    assertEquals("Default key should be -1", -1, entry.getKey());
    assertFalse("Default isOccupied should be false", entry.isOccupied());
  }

  @Test
  public void testParameterizedConstructor1() {
    // Arrange
    boolean isOccupied = true;
    int key = 42;

    // Act
    OverflowEntry entry = new OverflowEntry(isOccupied, key);

    // Assert
    assertEquals("Key should match the value passed in constructor", key, entry.getKey());
    assertTrue("isOccupied should match the value passed in constructor", entry.isOccupied());
  }

  @Test
  public void testSetOccupied1() {
    // Arrange
    OverflowEntry entry = new OverflowEntry();

    // Act
    entry.setOccupied(true);

    // Assert
    assertTrue("isOccupied should be true after calling setOccupied(true)", entry.isOccupied());

    // Act
    entry.setOccupied(false);

    // Assert
    assertFalse("isOccupied should be false after calling setOccupied(false)", entry.isOccupied());
  }

  @Test
  public void testSetKey1() {
    // Arrange
    OverflowEntry entry = new OverflowEntry();
    int newKey = 100;

    // Act
    entry.setKey(newKey);

    // Assert
    assertEquals("Key should be updated to the new value", newKey, entry.getKey());
  }

  @Test
  public void testToString1() {
    // Arrange
    OverflowEntry entry = new OverflowEntry(true, 101);

    // Act
    String result = entry.toString();

    // Assert
    assertEquals("String representation should match expected format",
            "Key: 101, Is Occupied: true", result);
  }


  @Test
  public void testConstructorWithData() {
    // Arrange
    MarketHours mockData = new MarketHours(); // Ensure this matches your constructor
    mockData.setId(647617); // Use setter to initialize the object
    mockData.setDay("Monday");
    mockData.setHours("11:00 - 12:00");
    mockData.setLocation("ev");

    // Act
    MarketHoursNode node = new MarketHoursNode(mockData);

    // Assert
    assertNotNull("Node should not be null", node);
    assertEquals("Data should match the initialized MarketHours", mockData, node.data);
    assertNull("xorPtr should be null", node.xorPtr);
  }


  @Test
  public void testConstructorWithXorHash() {
    // Arrange
    int xorHash = 12345;

    // Act
    MarketHoursNode node = new MarketHoursNode(xorHash);

    // Assert
    assertNotNull("Node should not be null", node);
    // No specific functionality to test here since this constructor does nothing
    assertNull("Data should be null", node.data);
    assertNull("xorPtr should be null", node.xorPtr);
  }


  @Test
  public void testMarketAppMain() {
    // Arrange
    String simulatedInput = "1\nabc\ncba\n4\n"; // Kullanıcı giriş yapıyor ve çıkış seçeneğini seçiyor
    InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Act
    MarketApp.main(new String[0]);


  }

  @Test
  public void testMinHeapNodeConstructor() {
    // Arrange
    char expectedData = 'a';
    int expectedFreq = 5;

    // Act
    MinHeapNode node = new MinHeapNode(expectedData, expectedFreq);

    // Assert
    assertNotNull(node); // Node null olmamalı
    assertEquals(expectedData, node.data); // Data doğru atanmalı
    assertEquals(expectedFreq, node.freq); // Freq doğru atanmalı
    assertNull(node.left); // Left başlangıçta null olmalı
    assertNull(node.right); // Right başlangıçta null olmalı
  }

  @Test
  public void testStackConstructor() {
    // Act
    Stack stack = new Stack();

    // Assert
    assertNotNull(stack); // Stack nesnesi null olmamalı
    assertNull(stack.top); // Yığın başlangıçta boş olmalı (top null)
  }

  @Test
  public void testCreateAndBuildMinHeap() {
    char[] data = {'a', 'b', 'c', 'd'};
    int[] freq = {5, 1, 2, 3};
    HuffmanCoding huffman = new HuffmanCoding();

    MinHeap minHeap = huffman.createAndBuildMinHeap(data, freq, data.length);

    assertEquals(4, minHeap.size);
    assertEquals('b', minHeap.array[0].data); // En düşük frekansa sahip karakter
    assertEquals(1, minHeap.array[0].freq);
  }


  @Test
  public void testBuildHuffmanTree() {
    char[] data = {'a', 'b', 'c', 'd'};
    int[] freq = {5, 1, 2, 3};
    HuffmanCoding huffman = new HuffmanCoding();

    MinHeapNode root = huffman.buildHuffmanTree(data, freq, data.length);

    assertEquals('$', root.data); // Root node'da birleşim sembolü olmalı
    assertEquals(11, root.freq);  // Toplam frekans
  }

  @Test
  public void testHuffmanCodes() {
    char[] data = {'a', 'b', 'c', 'd'};
    int[] freq = {5, 1, 2, 3};
    HuffmanCoding huffman = new HuffmanCoding();

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output)); // Konsol çıktısını yakalamak için

    huffman.HuffmanCodes(data, freq, data.length);

    String expectedOutput = "b: 00\nc: 01\nd: 10\na: 11\n"; // Beklenen Huffman kodları

  }

  @Test
  public void testEdgeCaseSingleCharacter() {
    char[] data = {'a'};
    int[] freq = {5};
    HuffmanCoding huffman = new HuffmanCoding();

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    huffman.HuffmanCodes(data, freq, data.length);

    String expectedOutput = "a: \n"; // Tek bir karakter için boş kod

  }



//
//  @Test
//  public void testIsStackEmpty() {
//    // Arrange
//    Stack stack = new Stack();
//
//  }

  @Test
  public void testPushAndPop() {
    // Arrange
    Stack stack = new Stack();
    Vendor vendor1 = new Vendor(1, "Vendor1");
    Vendor vendor2 = new Vendor(2, "Vendor2");

    // Act
    stack.push(vendor1);
    stack.push(vendor2);


  }

  @Test
  public void testPopOnEmptyStack() {
    // Arrange
    Stack stack = new Stack();

    // Act
    Vendor poppedVendor = stack.pop();


  }





//  @Test
//  public void testPush() {
//    // Arrange
//    Stack stack = new Stack();
//    Vendor vendor = new Vendor(1, "Vendor 1");
//
//    // Act
//    stack.push(vendor);
//  }

//  @Test
//  public void testPop() {
//    // Arrange
//    Stack stack = new Stack();
//    Vendor vendor1 = new Vendor(1, "Vendor 1");
//    Vendor vendor2 = new Vendor(2, "Vendor 2");
//    stack.push(vendor1);
//    stack.push(vendor2);
//
//    // Act
//    Vendor poppedVendor = stack.pop();
//
//
//  }

//  @Test
//  public void testPopEmptyStack() {
//    // Arrange
//    Stack stack = new Stack();
//
//    // Act
//    Vendor poppedVendor = stack.pop();
//
//
//  }

//  @Test
//  public void testFreeStack() {
//    // Arrange
//    Stack stack = new Stack();
//    stack.push(new Vendor(1, "Vendor 1"));
//    stack.push(new Vendor(2, "Vendor 2"));
//
//    // Act
//    stack.freeStack();
//
//  }




  @Test
  public void testCreateNode() {
    BPlusTreeNode node = new BPlusTreeNode();
    assertNotNull(node);
    assertTrue(node.getIsLeaf());
    assertEquals(0, node.getKeyCount());
    assertNull(node.getNext());
  }


  @Test
  public void testReadMarketHoursSuccess() {
      File testFile = new File("testMarketHours.bin");
      try (RandomAccessFile file = new RandomAccessFile(testFile, "rw")) {
          file.writeInt(1); // Market ID
          file.writeUTF("Monday"); // Day
          file.writeUTF("09:00 - 18:00"); // Working Hours
          file.writeUTF("Central Market"); // Location
          file.seek(0);
      } catch (IOException e) {
          fail("IOException occurred: " + e.getMessage());
      } finally {
          testFile.delete();
      }
  }
  
  @Test
  public void testReadMarketHoursInvalidData() throws IOException {
    // Test dosyasını oluştur
    File testFile = new File("testMarketHoursInvalid.bin");
    try (RandomAccessFile file = new RandomAccessFile(testFile, "rw")) {
      // Geçersiz veri yaz
      file.writeUTF("Invalid Data");
      file.seek(0);

      // IOException bekle
      thrown.expect(IOException.class);
      MarketHours.readMarketHours(file);
    } finally {
      // Test dosyasını sil
      testFile.delete();
    }
  }



  @Test
  public void testDefaultProductConstructor() {
    // Varsayılan yapıcı metod ile bir ürün oluştur
    ProductSelection.Product product = new ProductSelection.Product();


  }

  @Test
  public void testParameterizedProductConstructor() {
    // Parametreli yapıcı metod ile bir ürün oluştur
    ProductSelection.Product product = new ProductSelection.Product(
            "Apple", 1.5, 10, "Fall", 1001
    );


  }

  @Test
  public void testSelectedProductNameBuffer() {
    // selectedProductName için StringBuffer'ı test et
    ProductSelection.selectedProductName.append("Apple");


    // Buffer'ı temizle ve tekrar kontrol et
    ProductSelection.selectedProductName.setLength(0);

  }



  @Test
  public void testIsStackEmpty1() {
    // Arrange
    Stack stack = new Stack();

    // Act & Assert
    assertTrue("Stack should be empty initially", stack.isStackEmpty());

    stack.push(new Vendor(1, "Vendor 1"));
    assertFalse("Stack should not be empty after pushing an element", stack.isStackEmpty());
  }

  @Test
  public void testPush() {
    // Arrange
    Stack stack = new Stack();
    Vendor vendor = new Vendor(1, "Vendor 1");

    // Act
    stack.push(vendor);

    // Assert
    assertNotNull("Top of the stack should not be null after push", stack.top);
    assertEquals("Top of the stack should be the pushed vendor", vendor, stack.top.vendor);
  }


  @Test
  public void testPop() {
    // Arrange
    Stack stack = new Stack();
    Vendor vendor1 = new Vendor(1, "Vendor 1");
    Vendor vendor2 = new Vendor(2, "Vendor 2");
    stack.push(vendor1);
    stack.push(vendor2);

    // Act
    Vendor poppedVendor = stack.pop();

    // Assert
    assertEquals("Popped vendor should be the last pushed vendor", vendor2, poppedVendor);
    assertNotNull("Stack top should not be null after popping one vendor", stack.top);
    assertEquals("Stack top should now be the previous vendor", vendor1, stack.top.vendor);

    // Act - Popping the last element
    poppedVendor = stack.pop();

    // Assert
    assertEquals("Popped vendor should now be the first pushed vendor", vendor1, poppedVendor);
    assertNull("Stack top should be null after popping all vendors", stack.top);
  }

  @Test
  public void testPopEmptyStack() {
    // Arrange
    Stack stack = new Stack();

    // Act
    Vendor poppedVendor = stack.pop();

    // Assert
    assertEquals("Popping from an empty stack should return a default Vendor object", 0, poppedVendor.getId());
    assertEquals("Popping from an empty stack should return a default Vendor object", "", poppedVendor.getName());
  }

  @Test
  public void testFreeStack() {
    // Arrange
    Stack stack = new Stack();
    stack.push(new Vendor(1, "Vendor 1"));
    stack.push(new Vendor(2, "Vendor 2"));

    // Act
    stack.freeStack();

    // Assert
    assertNull("Stack top should be null after freeing the stack", stack.top);
  }


  @Test
  public void testXORNodeConstructor() {
    // Arrange: Test verisi olarak bir MarketHours nesnesi oluştur
    MarketHours testMarketHours = new MarketHours();
    testMarketHours.setId(1);
    testMarketHours.setDay("Monday");
    testMarketHours.setHours("09:00 - 17:00");
    testMarketHours.setLocation("Main Market");

    // Act: XORNode nesnesi oluştur
    XORNode node = new XORNode(testMarketHours);

    // Assert: XORNode özelliklerini kontrol et
    assertNotNull("Node data should not be null", node.data);
    assertEquals("Data ID should match", 1, node.data.getId());
    assertEquals("Data day should match", "Monday", node.data.getDay());
    assertEquals("Data hours should match", "09:00 - 17:00", node.data.getHours());
    assertEquals("Data location should match", "Main Market", node.data.getLocation());
    assertNull("Both pointer should be null initially", node.both);
  }

  @Test
  public void testXorLinkedListConstructor() {
    // Act: XorLinkedList nesnesi oluştur
    XorLinkedList xorLinkedList = new XorLinkedList();

  }

  @Test
  public void testBPlusTreeConstructor() {
    // Act: BPlusTree nesnesi oluştur
    BPlusTree bPlusTree = new BPlusTree();

  }



  @Test
  public void testGetProducts() {
    // Arrange
    Bucket bucket = new Bucket();

    // Act
    List<Product> products = bucket.getProducts();

    // Assert
    assertNotNull("Ürünler listesi null olmamalı", products);
    assertTrue("Ürünler listesi başlangıçta boş olmalı", products.isEmpty());
  }


  @Test
  public void testAddProduct1() {
    // Arrange
    Bucket bucket = new Bucket();
    Product product = new Product(123456, "elma", 10, 11, "summer");

    // Act
    bucket.addProduct(product);

    // Assert
    List<Product> products = bucket.getProducts();
    assertEquals("Ürün listesi bir öğe içermeli", 1, products.size());
    assertEquals("Eklenen ürün listede olmalı", product, products.get(0));
  }


  @Test
  public void testToString2() {
    // Arrange
    Bucket bucket = new Bucket();
    Product product1 = new Product(123456, "elma", 10, 12, "summer");
    Product product2 = new Product(127272, "elma", 5, 11, "summer");
    bucket.addProduct(product1);
    bucket.addProduct(product2);

    // Act
    String bucketContents = bucket.toString();

  }




  }