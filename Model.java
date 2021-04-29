/*
 *  Name:			| Fernando Canseco	| Jose Cintron		| Dhruv Patel		| Xavier Ramos		| Victor Gloria		|
 *  ab123:			| TSO262			| ZEF510			| ZST725			| XZZ259			| UES618			|
 *  Date:			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			|		
 *  Class:			| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		|
 *  Assignment:		| Group Project		| Group Project		| Group Project		| Group Project		| Group Project		|
 */
/*
 *  Model.java is a Model Class for this javafx project
 *  Handles the storage and manipulation of data inputed by the user
 */
package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Model 
{
	//HashMap used to store the 'front' and 'back' values of the flash cards
	HashMap<String, String> flashcardMap = new HashMap<String,String>();
	//A Set used to store the 'front' values of the flash cards as Keys
	//Used to populate the ArrayList keyList
	Set<String> keySet = flashcardMap.keySet();
	//ArrayList which holds the 'key' values, allows for access of values by using an index value
	ArrayList<String> keyList = new ArrayList<String>(keySet);
	//Local index tracking value
	int indx = 0;
	//local Strings
	String display="", ndx=Integer.toString(indx);
	//Generic Alert with no alert type, type modified as needed within class
	Alert a = new Alert(AlertType.NONE);
	//Instantiates a Properties object 
	Properties properties = new Properties();

		
	//Instantiates a file object
	//Allows the user to maintain a flash card collection between sessions
	File file = new File("flashcardCollection.properties");
	
	//File writers
	FileOutputStream writer = null;
	FileOutputStream indexWriter = null;
		
	//Constructor for Model class
	//Requires no input parameters
		public Model()
		{
			//Attempts to populate the HashMap by reading from a file if that file is available
			try 
			{
	    		
		    	//File reader
		    	//reads and populates properties with the content of the file
		    	FileInputStream reader=new FileInputStream(file);
		        properties.load(reader);
		        reader.close();
		        properties.load(new FileInputStream("flashcardCollection.properties"));
		        //populates the hashmap inventoryMap with the contents of properties
		        for(String key: properties.stringPropertyNames())
		        {
		        	flashcardMap.put(key, properties.get(key).toString());
		        }
		        //Saves the 'key' values to a set
		        keySet = flashcardMap.keySet();
		        //Uses the above set to fill an ArrayList of 'key' values
		        keyList = new ArrayList<String>(keySet);
		        
		    }
		    catch(FileNotFoundException er)
		    {
		    	a.setAlertType(AlertType.ERROR);
		    	a.setContentText("Properties file not found not found");
		   		a.show();
		   	}
		    catch(IOException e)
		    {
		    	a.setAlertType(AlertType.ERROR);
		    	a.setContentText("Flashcards not found");
		    	a.show();
		    }
			
		}
	
	//METHODS MakeController.java
	
	//Receives an integer value as a parameter
	//Allows for smooth navigation of Flash card collection 
	public void currentIndex(int index)
	{
		indx = index;
	}
	
	//handleCreate
	//Receives two String values as parameters
	//Takes user input and creates a flash card by adding those values to the flashcardMap
	//Displays alert to user 
	public void handleCreate(String frontText, String backText)
	{	
		if(frontText.length() > 0 && backText.length() > 0)
		{	
			//Saves user input to flashcardMap
			flashcardMap.put(frontText, backText);
			//Saves altered flashcardMap to a properties object
			properties.putAll(flashcardMap);
			//Sets alert type and displays alert
			a.setAlertType(AlertType.CONFIRMATION);
			a.setContentText("Flashcard successfully created.");
			a.show();
			//Outputs new hashmap information to the data.properties file
			try 
			{
				writer = new FileOutputStream(file,true);
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try 
			{
				properties.store(writer, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    			
		}
		else
		{
			a.setAlertType(AlertType.ERROR);
			a.setContentText("Flashcards cannot be left blank. Please enter text.");
			a.show();
		}
	}
	//END MakeController.java METHODS

	
	//METHODS StudyController.java
	
	//handlePrevious
	//Alters local index value to reflect user navigation
	//Displays alert if there are no previous cards
	public void handlePrevious()
	{
		//Checks to make sure that there are previous cards in the flash card collection
		if(indx > 0)
		{
			indx--;
		}
		//Displays alert to user
		else
		{
			a.setAlertType(AlertType.ERROR);
			a.setContentText("This is the first flashcard in your collection.");
			a.show();
		}
	}
	
	//handleNext
	//Receives integer index value as parameter
	//Alters local index value to reflect user navigation
	//Displays alert if there are no more cards to progress to in the flash card collection
	public void handleNext(int index)
	{
		//Increases index if applicable
		if(index < keyList.size()-1)
		{
			indx++;
		}
		//Displays alert to user
		else
		{
			a.setAlertType(AlertType.ERROR);
			a.setContentText("This is the last flashcard in your collection.");
			a.show();
		}
	}
	
	//handleFlip
	//Receives integer flashIndex as parameter
	//Checks whether the card is the final one in the collection or not
	//Stores the correct display value in a local String
	public String handleFlip(int flashIndex)
	{
		//Checks whether flash card is the last one in the collection
		String backDisplay;
		if(flashIndex < keyList.size())
		{
			backDisplay = flashcardMap.get(keyList.get(flashIndex));
		}
		else
		{
			backDisplay = flashcardMap.get(keyList.get(flashIndex-1));
		}
		//returns correct display value to user 
		return backDisplay;
	}
	
	//handleDisplay
	//Receives integer flashIndex as parameter
	//Retrieves the 'front' value of the flash card
	//Returns 'front' value to user
	public String handleDisplay(int flashIndex)
	{
		//Checks whether or not the flash card is the last one in the collection
		if(flashIndex < keyList.size())
		{
		display = keyList.get(flashIndex);
		}
		else
		{
			display = keyList.get(flashIndex-1);
		}
		//returns correct display value to user
		return display;
		

	}
	
	//handleDelete
	//Receives String key as parameter 
	//Removes the flash card from the flashcardMap by using the passed String
	//Assigns index of the key within the ArrayList
	//Removes the flash card from the keyList using the integer kNdx
	public void handleDelete(String key)
	{
		flashcardMap.remove(key);
		int kNdx = keyList.indexOf(key);
		keyList.remove(kNdx);
		properties.remove(key);
		
	}
	
	
	//END StudyController.java METHODS
}
