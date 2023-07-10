package edu.ou.cs2334.project4.handlers;

import edu.ou.cs2334.project4.models.NonogramMakerModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

/**
 * Handlers Events in accords to the toggle Buttons, implements Eventhandler interface
 * 
 * @author danieljacob
 *
 */
public class ToggleButtonEventHandler implements EventHandler<ActionEvent> {

	private NonogramMakerModel model;
	private int rowIdx;
	private int colIdx;
	
	/**
	 * Creates a toggleButtonHandler to be used when a button is changed
	 * 
	 * @param model the Nonogram Model that was constructed
	 * @param rowIdx the selected row index
	 * @param colIdx the selected column index
	 */
	public ToggleButtonEventHandler(NonogramMakerModel model, int rowIdx, int colIdx) {
		this.model = model;
		this.rowIdx = rowIdx;
		this.colIdx = colIdx;
		
	}
	
	/**
	 * Handles an action which is the user changing the state of one of the cells
	 * 
	 */
	public void handle(ActionEvent event) {
		
		ToggleButton t = (ToggleButton) event.getSource();
		
		
		model.setCell(rowIdx, colIdx, t.isSelected());
		
		
	
	}
}
