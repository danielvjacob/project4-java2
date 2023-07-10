package edu.ou.cs2334.project4.handlers;

import java.io.File;
import java.io.IOException;

import edu.ou.cs2334.project4.interfaces.Saveable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * Handles saving of any files
 * 
 * @author danieljacob
 *
 */
public class SaveHandler extends AbstractBaseHandler implements EventHandler<ActionEvent> {
	
	private Saveable saver;
	
	/**
	 * 
	 * @param window the given window of the nonogram
	 * @param fileChooser the choosen file
	 * @param saver the object implements the interface
	 */
	public SaveHandler(Window window, FileChooser fileChooser, Saveable saver) {
		super(window, fileChooser);
		this.saver = saver;
		
		
	}

	
	@Override
	/**
	 * handle method overides the parent method and handles any saving of file dialog
	 */
	//went through this method and the one in openHandler with Nathan Stephani
	public void handle(ActionEvent arg0) {
	
		File file = fileChooser.showSaveDialog(window);
		
		
		if (file != null) {
			try {
				saver.save(file.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
