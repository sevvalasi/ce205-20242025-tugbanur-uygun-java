package com.sevval.tugba.naz.irem.market;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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

//  @Test
//  public void testUserAuthenticationLogin() {
//    // Arrange
//    String input = "2\nnaz\n1234\n\n1\na\n4"; // Simulated user input
//    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//
//    System.setIn(inputStream); // Simulate user input
//    System.setOut(new PrintStream(outContent)); // Capture output
//
//    Market market = new Market(new Scanner(System.in), System.out);
//    // Act
//    boolean result = Market.userAuthentication();
//
//
//  }

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



}
