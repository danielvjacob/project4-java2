package edu.ou.cs2334.project4.interfaces;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Interface used to specify that a class has a special method to handle opening a file
 * 
 * @author danieljacob
 *
 */
public interface Openable {
	
	/**
	 * opens the choosen file
	 * 
	 * @param file the choosen file 
	 * @throws FileNotFoundException if no file is found
	 */
	void open(File file) throws FileNotFoundException;

}
