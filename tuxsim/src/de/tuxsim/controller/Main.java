/**Dev-Class to test file read **/

package de.tuxsim.controller;

/**
 * Main class starts the init Thread
 * @author tuxpad
 *
 */
public class Main {

	/**
	 * Main Method to start the init Thread
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MainController());
		t1.start();

	}
}


