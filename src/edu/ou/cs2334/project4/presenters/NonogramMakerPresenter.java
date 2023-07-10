package edu.ou.cs2334.project4.presenters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.ou.cs2334.project4.handlers.OpenHandler;
import edu.ou.cs2334.project4.handlers.SaveHandler;
import edu.ou.cs2334.project4.handlers.ToggleButtonEventHandler;
import edu.ou.cs2334.project4.interfaces.Openable;
import edu.ou.cs2334.project4.interfaces.Saveable;
import edu.ou.cs2334.project4.models.NonogramMakerModel;
import edu.ou.cs2334.project4.views.CellGridView;
import edu.ou.cs2334.project4.views.NonogramMakerView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

/**
 * This class connects the graphical view and the model data
 * 
 * @author danieljacob
 *
 */
public class NonogramMakerPresenter implements Openable, Saveable{

	private NonogramMakerView view;
	private NonogramMakerModel model;
	private int cellLength;
	
	/**
	 * Constructs the nonogramMakerPresenter to present it for us
	 * 
	 * @param numRows the number of rows in the nonogram puzzle
	 * @param numCols the number of columns in the nonogram puzzle
	 * @param cellLength the length of each cell in the nonogram
	 */
	public NonogramMakerPresenter(int numRows, int numCols, int cellLength) {
		
		model = new NonogramMakerModel(numRows, numCols);
		view = new NonogramMakerView( numRows,  numCols,  cellLength);
		this.cellLength = cellLength;
		init();
		
	}
	
	private Window getWindow() {
		try { 
			return view.getPane().getScene().getWindow();
		}
		catch(NullPointerException e) {
			return null;
		}
	}
	private void init() {
		initToggleButtons();
		bindToggleButtons();
		configureMenuItems();
		
	}
	private void initToggleButtons() {
		view.initButtons(model.getNumRows(), model.getNumCols(), cellLength);
		
		if(getWindow() != null) {
			getWindow().sizeToScene();
		}
		
	}
	private void bindToggleButtons() {
		
		
		for (int row = 0; row < model.getNumRows(); ++row) {
			for (int col = 0; col < model.getNumCols(); ++col) {
				view.getToggleButton(row, col).setSelected(model.getCell(row, col));
				view.getToggleButton(row, col).setOnAction(new ToggleButtonEventHandler(model, row, col));
			}
		}
		
	}
	private void configureMenuItems() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		fileChooser.setInitialDirectory(new File("."));
		view.getMenuItem(NonogramMakerView.MENU_ITEM_OPEN).setOnAction(new OpenHandler(getWindow(), fileChooser, this));
		
		FileChooser fileChooser2 = new FileChooser();
		fileChooser2.setTitle("Save");
		fileChooser2.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		fileChooser2.setInitialDirectory(new File("."));
		view.getMenuItem(NonogramMakerView.MENU_ITEM_SAVE).setOnAction(new SaveHandler(getWindow(), fileChooser2, this));
	
		
		
	}
	
	/**
	 * A getter for the pane of the presenter
	 * 
	 * @return returns the view of the pane
	 */
	public Pane getPane() {
		return view.getPane();
	}
	/**
	 * re-initializes the model and opens the given file
	 */
	public void open(File file) throws FileNotFoundException {
		model = new NonogramMakerModel(file);
		init();
	}

	@Override
	/**
	 * calls the saveToFile method and saves the nonogram file
	 */
	public void save(String filename) throws IOException {
		model.saveToFile(filename);
		
	}
	
}
