package edu.ou.cs2334.project4.interfaces;

import java.io.IOException;

/**
 * Interface used to specify that a class has a special method to handle saving a file
 * 
 * @author danieljacob
 *
 */
public interface Saveable {

	/**
	 * saves a file with a given string name
	 * 
	 * @param filename the name of the given file
	 * @throws IOException throws exception if file is not found
	 */
	void save(String filename) throws IOException;
	
}
