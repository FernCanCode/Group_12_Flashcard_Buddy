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
	int indx = 0, total = 0;
	String front, ndx=Integer.toString(indx);
	Alert a = new Alert(AlertType.NONE);
	
	//METHODS MakeController.java
	
	//handleNext
	public void handleNext(String frontText)
	{	
		if(frontText.length() > 0)
		{
			ndx = Integer.toString(total);
			indexMap.put(ndx, frontText);
			flashcardMap.put(frontText, null);
			front = frontText;
			//debug println
			System.out.println(flashcardMap.toString());
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
		//debugging println
		System.out.println(flashcardMap.toString());
		if(backText.length() > 0)
		{
			ndx = Integer.toString(total);
			front = indexMap.get(ndx);
			flashcardMap.put(front, backText);
			total++;
			a.setAlertType(AlertType.CONFIRMATION);
			a.setContentText("Flashcard successfully created.");
			a.show();
			//debugging pritnln
			System.out.println(flashcardMap.toString());
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
		ndx=Integer.toString(indx);
		String frontKey = indexMap.get(ndx);
		String frontDisplay = flashcardMap.get(frontKey);
		return frontDisplay;
	}
	//handleDisplay
	public String handleDisplay()
	{
		ndx=Integer.toString(indx);
		String frontKey = "NULL";
		frontKey = indexMap.get(ndx);
		return frontKey;
	}
	
	
	//END StudyController.java METHODS
}
