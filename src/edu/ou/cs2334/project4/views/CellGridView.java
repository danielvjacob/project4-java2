package edu.ou.cs2334.project4.views;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * CellGrid View Class, created the grid with the nonoGram for the viewer
 * 
 * @author danieljacob
 *
 */
public class CellGridView {

	private ArrayList<ToggleButton> gridButtons;
	private GridPane gridPane;
	private int numRows;
	private int numCols;
	
	
	/**
	 * Creates the cell grid view
	 * 
	 * @param numRows number of rows in the gridPane
	 * @param numCols number of columns in the gridPane
	 * @param cellLength the length of each cell in the gridPane
	 */
	public CellGridView(int numRows, int numCols, int cellLength) {
		this.numRows = numRows;
		this.numCols = numCols;
		this.gridButtons = new ArrayList<>();
		gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		
		initButtons(numRows, numCols, cellLength);
		
	}
	
	/**
	 * Creates toggle buttons for the grid Pane
	 * 
	 * @param numRows number of rows in the grid Pane
	 * @param numCols number of columns in the grid Pane
	 * @param cellLength the length of each cell in the grid Pane
	 */
	public void initButtons(int numRows, int numCols, int cellLength) {
		gridButtons.clear();
		gridPane.getChildren().clear();
		this.numCols = numCols;
		this.numRows = numRows;

		for (int row = 0; row < numRows; ++row) {
			for (int col = 0; col < numCols; ++col) {
				ToggleButton button = new ToggleButton();
				button.setMaxWidth(cellLength);
				button.setMinWidth(cellLength);
				button.setMaxHeight(cellLength);
				button.setMinHeight(cellLength);
				button.setPrefHeight(cellLength);
				button.setPrefWidth(cellLength);

//				button.setMaxSize(cellLength, cellLength);
//				button.setMinSize(cellLength, cellLength);

				gridButtons.add(button);
				gridPane.add(button, col, row);
			}
		}
	}
	/**
	 * Getter for rows of grid Pane
	 * 
	 * @return the number of rows in the grid Pane
	 */
	public int getNumRows() {
		return numRows;
	}
	/**
	 * Getter for columns of grid Pane
	 * 
	 * @return the number of columns in the grid Pane
	 */
	public int getNumCols() {
		return numCols;
	}
	
	/**
	 * Getter for toggle buttons array list
	 * 
	 * @param row row index of selected cell
	 * @param col column index of selected cell
	 * @return a toggle button object of the selected cell
	 */
	public ToggleButton getToggleButton(int row, int col) {
		return gridButtons.get((row * numCols)+col);
		
	}
	
	/**
	 * Getter for grid Pane
	 * 
	 * @return returns the gridPane
	 */
	public Pane getPane() {
		return gridPane;
	}
	
	
	
	
	
	
}
