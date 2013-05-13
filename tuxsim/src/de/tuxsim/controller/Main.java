/**Dev-Class to test file read **/


package de.tuxsim.controller;


import de.tuxsim.controller.MainController.StartListener;
import de.tuxsim.view.Mainview;

/**
 * Main class, generates the 
 * @author tuxpad
 *
 */
public class Main {

	/**Main Class, init a maincontroller and starts gui
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MainController());
		t1.start();
		

	

	}


}
/**Dev-Class to test file read **/


