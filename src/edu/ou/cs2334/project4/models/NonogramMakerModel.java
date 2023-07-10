package edu.ou.cs2334.project4.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * NonogramMakerModel class which creates and stores the Nonogram puzzle
 * 
 * @author danieljacob
 *
 */
public class NonogramMakerModel {
	
	private static char EMPTY_CELL_CHAR = '0';
	private static char FILLED_CELL_CHAR = '1';
	private int numRows;
	private int numCols;
	private boolean[] grid;
	
	/**
	 * Constructs a NonoGram model in a 1D array with given dimensions for rows and columns
	 * 
	 * @param numRows the number of rows for the Nonogram
	 * @param numCols the number of columns for the Nonogram
	 */
	public NonogramMakerModel(int numRows, int numCols) {
		
		if (numRows <= 0 || numCols <= 0) {
			throw new IllegalArgumentException();
		}
		this.numRows = numRows;
		this.numCols = numCols;
		
		
		
		grid = new boolean[numRows * numCols];
	}
	
	/**
	 * Constructs a nonogram model in a 1D array  from a given file
	 * 
	 * @param file a file which contains the description of the Nonograms
	 * @throws FileNotFoundException throws this exceptions if no file is found
	 */
	public NonogramMakerModel(File file) throws FileNotFoundException {
	
		
		
		Scanner scan = new Scanner(file);
		
		this.numRows = scan.nextInt();
		this.numCols = scan.nextInt();
		
		grid = new boolean[numRows * numCols];
		
		scan.nextLine();
		
		for (int i =0 ; i < numRows + numCols; ++i) {
			scan.nextLine();
		}
		
		for (int row = 0; row < numRows; ++row) {
			
			String line = scan.nextLine();
			
			for(int col = 0; col < numCols; ++col) {
				
				char currChar = line.charAt(col);
				boolean state;
				
				if(currChar == EMPTY_CELL_CHAR) {
					state = false;
				}
				else {
					state = true;
				}
				setCell(row, col, state);
			}
		}	
	}
	/**
	 * constructs a nonogram model by calling the previous file constructor and converting the given string to a file
	 * 
	 * @param fileName the string which is the name of the given fiel
	 * @throws FileNotFoundException will throw this exception if no file can be created
	 */
	public NonogramMakerModel(String fileName) throws FileNotFoundException {
		this(new File(fileName));
		
	}
	
	/**
	 * Getter for nonograms grid which is a 1D array
	 * 
	 * @return the 1D array which contains the nonoGram model
	 */
	public boolean[] getGrid() {
		return Arrays.copyOf(grid, grid.length);
	}
	
	/**
	 * getter for number of rows in nonogram models
	 * 
	 * @return the number of rows in the nonogram
	 */
	public int getNumRows() {
		return numRows;
	}

	/**
	 * getter for number of columns in nonogram
	 * 
	 * @return the number of columns contained in model
	 */
	public int getNumCols() {
		return numCols;
	}
	
	/**
	 * Sets a given cell in the nonogram model to whatever state is desired
	 * 
	 * @param rowIndex index of row that desired cell sits in
	 * @param colIndex index of column that desired cell sits in
	 * @param state the state that is replacing the current cell
	 */
	public void setCell(int rowIndex, int colIndex, boolean state) {
		int placement = (numCols * rowIndex) + colIndex;
		
		grid[placement] = state;
	}
	
	/**
	 * getter for a specific cell in nonogram model
	 * 
	 * @param rowIndex index of row that desired cell sits in
	 * @param colIndex index of column that desired cell sits in
	 * @return the state of the choosen cell
	 */
	public boolean getCell(int rowIndex, int colIndex) {
		int placement = (numCols * rowIndex) + colIndex;
		
		return grid[placement];
	}
	/**
	 * Creates a projection of the nonograms filled in cells
	 * 
	 * @param cells an array of a given row or column
	 * @return a list of integers that displays which cells are filled
	 */
	public static List<Integer> project(boolean[] cells){
		List<Integer> list = new ArrayList<Integer>();
		
		int count = 0;
		for (int i = 0; i < cells.length; ++i) {
			if (cells[i] == true) {
				++count;
			}
			else {
				if (count != 0) {
					list.add(count);
				}
				count = 0;
			}
		}
		if (count >= 1) {
			list.add(count);
		}
		if (list.size() == 0) {
			list.add(0);
		}
		return list;
	}
	
	/**
	 * Creates a projection of filled cells of a specific row from the nonoGram
	 * 
	 * @param rowIndex index of row that desired cell sits in
	 * @return a list of integers displaying which cells are filled for a given row
	 */
	public List<Integer> projectRow(int rowIndex){
		boolean[] row = new boolean[numCols];
		
		for (int i = 0; i < numCols; ++i) {
			row[i] = grid[(numCols * rowIndex) + i];
		}
		
		return (project(row));
		
	}
	
	/**
	 * Creates a projection of filled cells of a specific column from the nonoGram
	 * 
	 * @param colIndex index of column that desired cell sits in
	 * @return a list of integers displaying which cells are filled for a given column
	 */
	public List<Integer> projectCol(int colIndex){
		boolean[] col = new boolean[numRows];
		
		for (int i = 0; i < numRows; ++i) {
			col[i] = grid[colIndex + (numCols*i)];
		}
		
		return (project(col));
		
	}
	
	/**
	 * Saves output of toString method to a file
	 * 
	 * @param fileName the name of the file which it is being stored to
	 * @throws IOException throws this exception if file cannot be written to
	 */
	public void saveToFile(String fileName) throws IOException {
		File output = new File(fileName);
		FileWriter writer = new FileWriter(output);
		writer.write(toString());
		writer.close();
	}
	
	/**
	 * To string method for this class, creates string representation of entire nonogram model
	 */
	public String toString() {
		String total = "";
		
		total += getNumRows() + " ";
		total += getNumCols() + "\n";
		
		for (int i = 0; i < getNumRows(); ++i) {
			for (int j = 0; j < projectRow(i).size(); ++j) {
				if (j > 0) {
				total += " ";
				}
				total += projectRow(i).get(j);
			}
			total += "\n";
		}
		
		for (int i = 0; i < getNumCols(); ++i) {
			for (int j = 0; j < projectCol(i).size(); ++j) {
				if (j > 0) {
					total += " ";
				}
				total += projectCol(i).get(j);
			}
			total += "\n";
		}
		
		int counter = 0;
		int rowCounter = 0;
		for (int i = 0; i < getNumRows() * getNumCols(); ++i) {
			if (getGrid()[i] == true) {
				total += '1';
			}
			else {
				total += '0';
			}
			++counter;
			if (counter == getNumCols() && rowCounter < (getNumRows()-1)) {
				total += "\n";
				++rowCounter;
				counter = 0;
			}
		}
		

		return total;
	}
	
	

}
