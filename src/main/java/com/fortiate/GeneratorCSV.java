package com.fortiate;

import java.util.ArrayList;

public class GeneratorCSV {

	public static void main(String[] args) {
		
		// Array List to store every row
		ArrayList<String> dataElementsArrayList = new ArrayList<String>();
		// Array to store comma separated data in each row
		String[] dataElementArray = new String[] {};

		// TODO Import from csv file named iso_de.csv
		dataElementsArrayList = importDE("","");
		
		// TODO Generate iso 8583 msgs on console for each row of data
		// dataElementsList.forEach(action);
		generateISOMessage(dataElementArray);
		
	}
	
	public static ArrayList importDE(String pathToFile,String fileType)
	{
		 
		// TODO read records from file
		
		// TODO add the data read to an arraylist
		
		// TODO return the list
		
		return null;
		
	}
	
	public static void generateISOMessage(String[] dataElementArray )
	{
		
		// TODO similar to generator.java
		
		// TODO example field.setValue(3, dataElementArray[3]); // Processing Code - n6
				
	}

}
