package edu.ou.cs2334.project4;

import java.util.ArrayList;
import java.util.List;

import edu.ou.cs2334.project4.presenters.NonogramMakerPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Launches the inherited launch method and runs the program
 * 
 * @author danieljacob
 *
 */
public class Main extends Application {

	private int IDX_NUM_COLS = 1;
	private int IDX_NUM_ROWS = 0;
	private int IDX_CELL_SIZE = 2;
	
	/**
	 * Calls the launch method from JavaFXexample
	 * 
	 * @param args is the String arguments which is passed to the main for the program to run
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * A method that starts the given program and adds a style sheet
	 * 
	 * @param primaryStage is the stage which the scene of the presenter is placed on
	 */
	public void start(Stage primaryStage) throws Exception{
		
		
		
		List<String> list = getParameters().getUnnamed();
		int col = Integer.parseInt(list.get(IDX_NUM_COLS));
		int row = Integer.parseInt(list.get(IDX_NUM_ROWS));
		int cell = Integer.parseInt(list.get(IDX_CELL_SIZE));
		
		NonogramMakerPresenter presenter = new NonogramMakerPresenter(row, col, cell);
		
		Scene scene = new Scene(presenter.getPane());
		
		primaryStage.setScene(scene);
		
		scene.getStylesheets().add("style.css");
		
		primaryStage.setTitle(this.getClass().getName());
		primaryStage.setResizable(false);
		primaryStage.show();
		
		
		
		
	
		
		
	}
}
