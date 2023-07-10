package edu.ou.cs2334.project4.handlers;


import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * This class is a general handler involving file selection
 * 
 * @author danieljacob
 *
 */
public class AbstractBaseHandler {
	
	protected Window window;
	protected FileChooser fileChooser;

	/**
	 * Assigns the instance variables and constructs the abstract base handler
	 * 
	 * @param window the given window of the nonogram
	 * @param fileChooser the choosen file
	 */
	public AbstractBaseHandler(Window window, FileChooser fileChooser) {
		this.window = window;
		this.fileChooser = fileChooser;
	}

	
}
