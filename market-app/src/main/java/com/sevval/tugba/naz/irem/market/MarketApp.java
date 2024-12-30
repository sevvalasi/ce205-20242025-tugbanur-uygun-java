/**

@file MarketApp.java
@brief This file serves as the main application file for the Market App.
@details This file contains the entry point of the application, which is the main method. It initializes the necessary components and executes the Market App.
*/
/**

@package com.sevval.tugba.naz.irem.market
@brief The com.sevval.tugba.naz.irem.market package contains all the classes and files related to the Market App.
*/
package com.sevval.tugba.naz.irem.market;

import java.util.Scanner;

/**
 *
 * @class MarketApp
 * @brief This class represents the main application class for the Market
 1*        App.
 * @details The MarketApp class provides the entry point for the Market
 *          App. It initializes the necessary components, performs calculations,
 *          and handles exceptions.
 * @author ugur.coruh
 */
public class MarketApp {
  /**
   * @brief Logger for the MarketApp class.
   */
	
	
 
  public static void main(String[] args) {
	  
	  Scanner Scanner = new Scanner(System.in);
      Market market = new Market(Scanner, System.out);
	  
   Market.userAuthentication();
  }

}
