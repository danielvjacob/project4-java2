package edu.ou.cs2334.project4.views;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * creates the nonoGram Viewer using the nonoGram puzzle maker and the selected choices by user
 * 
 * @author danieljacob
 *
 */
public class NonogramMakerView {

	private BorderPane borderPane;
	private MenuBar menuBar;
	private CellGridView cellGridView;
	private Map<String, MenuItem> menuItemsMap = new HashMap<String, MenuItem>();
	
	/**
	 * Final static variable for open in menu
	 */
	public static String MENU_ITEM_OPEN = "MENU_ITEM_OPEN";
	/**
	 * Final static variable for save in menu
	 */
	public static String MENU_ITEM_SAVE = "MENU_ITEM_SAVE";
	/**
	 * Final static variable for exit in menu
	 */
	public static String MENU_ITEM_EXIT = "MENU_ITEM_EXIT";
	
	/**
	 * Constructs the nonoGram viewer grid
	 * 
	 * @param numRows number of rows in the viewer grid
	 * @param numCols number of columns in the viewer grid
	 * @param cellLength the length of each cell in the viewer grid
	 */
	public NonogramMakerView(int numRows, int numCols, int cellLength) {
		borderPane = new BorderPane();
		cellGridView = new CellGridView(numRows, numCols, cellLength);
		initMenuBar();
		borderPane.setCenter(cellGridView.getPane());
		borderPane.setTop(menuBar);
	
		
	}
	
	/**
	 * Creates the menu bar and creates a map of the choices
	 * 
	 */
	public void initMenuBar() {
		Menu menu = new Menu("_File");
		MenuItem open = new MenuItem("_Open");
		MenuItem save = new MenuItem("_Save");
		MenuItem exit = new MenuItem("_Exit");
		
		menu.getItems().addAll(open, save, exit);
		
		
		menuItemsMap.put(MENU_ITEM_OPEN, open);
		menuItemsMap.put(MENU_ITEM_SAVE, save);
		menuItemsMap.put(MENU_ITEM_EXIT, exit);
		
	
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		menuBar = new MenuBar(menu);
	}
	
	/**
	 * get the selected menu option
	 * 
	 * @param name of selected menu option
	 * @return the option that was selected from map
	 */
	public MenuItem getMenuItem(String name) {
		 return menuItemsMap.get(name);
	}
	
	/**
	 * Getter for the border Bane
	 * 
	 * @return the Pane object that was created for the viewer
	 */
	public Pane getPane() {
		return borderPane;
	}
	/**
	 * Creating toggle buttons for the viewer grid using the method in CellGrid view
	 * 
	 * @param numRows numRows number of rows in the viewer grid
	 * @param numCols numCols number of columns in the viewer grid
	 * @param cellLength cellLength the length of each cell in the viewer grid
	 */
	public void initButtons(int numRows, int numCols, int cellLength) {
		cellGridView.initButtons(numRows, numCols, cellLength);
	}
	
	/**
	 * Toggle button getter for viewer grid
	 * 
	 * @param row the selected row index 
	 * @param col the selected column index
	 * @return the Toggle button of the chosen cell
	 */
	public ToggleButton getToggleButton(int row, int col) {
		return cellGridView.getToggleButton(row, col);
	}
	
	/**
	 * Getter for cellGrids rows
	 * 
	 * @return the number rows in the cell grid
	 */
	public int getNumRows() {
		return cellGridView.getNumRows();
	}
	/**
	 * Getter for cellGrids columns
	 * 
	 * @return the number rows in the cell grid
	 */
	public int getNumCols() {
		return cellGridView.getNumCols();
	}
	
	
	
	
	 

	
	
}
