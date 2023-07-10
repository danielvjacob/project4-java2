package edu.ou.cs2334.project4.handlers;

import java.io.File;
import java.io.FileNotFoundException;

import edu.ou.cs2334.project4.interfaces.Openable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * Handles opening of any files
 * 
 * @author danieljacob
 *
 */
public class OpenHandler extends AbstractBaseHandler implements EventHandler<ActionEvent> {

	private Openable opener;
	
	/**
	 * constructs the openHandler object
	 * 
	 * @param window the window that contains the diealog
	 * @param fileChooser the object that selects the file
	 * @param opener the openable object which the open method is called on
	 */
	public OpenHandler(Window window, FileChooser fileChooser, Openable opener ) {
		 super(window, fileChooser);
		 this.opener = opener;
	}
	
	
	@Override
	/**
	 * handle method overides the parent method and handles any opening of file dialog
	 */
	//went through this method and the one in saveHandler with Nathan Stephani
	public void handle(ActionEvent event) {
	File file = fileChooser.showOpenDialog(window);
	
		if (file != null) {
			try {
				opener.open(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	
}
