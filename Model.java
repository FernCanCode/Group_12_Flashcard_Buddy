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

import java.util.HashMap;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Model {
	
	HashMap<String, String> flashcardMap = new HashMap<String,String>();
	HashMap<String,String> indexMap = new HashMap<String,String>();
	int indx = 0, ttlIndex = 0;
	String front, ndx=Integer.toString(indx);
	Alert a = new Alert(AlertType.NONE);
	
	//METHODS MakeController.java
	
	//handleNext
	public void handleNext(String frontText)
	{	
		if(frontText.length() > 1)
		{
			ndx = Integer.toString(ttlIndex);
			indexMap.put(ndx, frontText);
			flashcardMap.put(frontText, null);
			front = frontText;
		}
		else
		{
			a.setAlertType(AlertType.ERROR);
			a.setContentText("Flashcards cannot be left blank. Please enter text.");
			a.show();
		}
	}
	//handleCreate
	public void handleCreate(String backText)
	{
		if(backText.length() > 1)
		{
			flashcardMap.put(front, backText);
			indx++;
			a.setAlertType(AlertType.CONFIRMATION);
			a.setContentText("Flashcard successfully created.");
			a.show();
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
	//handleNext
	public void handleNext()
	{
		if(indx < indexMap.size())
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
	public String handleFlip()
	{
		String frontKey = indexMap.get(ndx);
		String frontDisplay = flashcardMap.get(frontKey);
		return frontDisplay;
	}
	//handleDisplay
	public String handleDisplay()
	{
		String frontKey = indexMap.get(ndx);
		return frontKey;
	}
	
	
	//END StudyController.java METHODS
}
