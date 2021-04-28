/*
 *  Name:			| Fernando Canseco	| Jose Cintron		| Dhruv Patel		| Xavier Ramos		| Victor Gloria		|
 *  ab123:			| TSO262			|					|					|					|					|
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

public class Model {
	
	HashMap<String, String> flashcardMap = new HashMap<String,String>();
	Set<String> keySet = flashcardMap.keySet();
	ArrayList<String> keyList = new ArrayList<String>(keySet);
	int indx = 0;
	String display="", ndx=Integer.toString(indx);
	Alert a = new Alert(AlertType.NONE);
	//Instantiates a Properties object 
	Properties properties = new Properties();

		
	//Instantiates a file object
	File file = new File("flashcardCollection.properties");

	FileOutputStream writer = null;
	FileOutputStream indexWriter = null;
		
		public Model()
		{
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
		        keySet = flashcardMap.keySet();
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
	
	public void currentIndex(int index)
	{
		indx = index;
	}
	//handleCreate
	public void handleCreate(String frontText, String backText)
	{	
		if(frontText.length() > 0 && backText.length() > 0)
		{	
			flashcardMap.put(frontText, backText);
			properties.putAll(flashcardMap);
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
	public void handlePrevious()
	{
		if(indx > 0)
		{
			indx--;
		}
		else
		{
			a.setAlertType(AlertType.ERROR);
			a.setContentText("This is the first flashcard in your collection.");
			a.show();
		}
	}
//	handleNext
	public void handleNext(int index)
	{
		if(index < keyList.size()-1)
		{
			indx++;
		}
		else
		{
			a.setAlertType(AlertType.ERROR);
			a.setContentText("This is the last flashcard in your collection.");
			a.show();
		}
	}
	//handleFlip
	public String handleFlip(int flashIndex)
	{
		String backDisplay;
		if(flashIndex < keyList.size())
		{
			backDisplay = flashcardMap.get(keyList.get(flashIndex));
		}
		else
		{
			backDisplay = flashcardMap.get(keyList.get(flashIndex-1));
		}
		return backDisplay;
	}
	
	//handleDisplay
	public String handleDisplay(int flashIndex)
	{
		if(flashIndex < keyList.size())
		{
		display = keyList.get(flashIndex);
		}
		else
		{
			display = keyList.get(flashIndex-1);
		}
		return display;
		

	}
	
	
	//END StudyController.java METHODS
}
