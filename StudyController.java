/*
 *  Name:			| Fernando Canseco	| Jose Cintron		| Dhruv Patel		| Xavier Ramos		| Victor Gloria		|
 *  ab123:			| TSO262			| ZEF510			| ZST725			| XZZ259			| UES618			|
 *  Date:			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			|		
 *  Class:			| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		|
 *  Assignment:		| Group Project		| Group Project		| Group Project		| Group Project		| Group Project		|
 */
/*
 *  StudyController.java is a controller for this javafx project
 *  manages the user interaction with Study.fxml
 */
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StudyController {
	//Initializes a Model object
	Model model = new Model();
	//local integer used to track user navigation through flash card array
	int index = 0;
	
	//Study.fxml elements
	@FXML
	private AnchorPane mainPane;
	
    @FXML
    private Button studyBegin;
	
    @FXML
    private Button studyFlipFront;
    
    @FXML
    private TextField studyText;

    @FXML
    private Button studyPrevious;

    @FXML
    private Button studyFlip;

    @FXML
    private Button studyExit;

    @FXML
    private Button studyNext;
    
    @FXML
    private Button studyDeleteCard;
    
    //Returns the user to Main.fxml
    public void handleExit(ActionEvent event) throws IOException
    {
    	mainPane = FXMLLoader.load(getClass().getResource("Main.fxml")); //pane you are GOING to
    	Scene scene = new Scene(mainPane); //pane you are going to SHOW
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //pane you are ON
    	window.setScene(scene);
    	window.show();
    }
    
    //Handles the default display when the Study scene is first opened
    //Allows the user to begin studying
    public void handleBegin()
    {
    	//Passes user current flash card to the Model class
    	model.currentIndex(index);
    	//Stores the value of the flash card front passed from the Model class in a local String
    	String defaultText = model.handleDisplay(index);
    	//Sets the flash card front to display the correct value
    	studyText.setText(defaultText);
    }
    
    
    //Changes the flashcard to the previous card
    //Reduces the local index value by one if applicable
    public void handlePrevious(ActionEvent event) throws IOException
    {
    	//Calls to the Model class method
    	model.handlePrevious();
    	//Reduces the local index value by 1 if the index is greater than 0
    	if(index > 0)
        	index--;
    	//Stores new value for Flash Card passed from Model in a local String
    	String front = model.handleDisplay(index);
    	//Sets correct display for flash card front
    	studyText.setText(front);
    	
    	
    }
    
    //Changes the flashcard to the next card
    //Increases the local index value by one if applicable
    public void handleNext(ActionEvent event) throws IOException
    {
    	//Passes local index value to the Model class
    	model.handleNext(index);
    	//Checks that the current flash card is not the final flash card in the set of flash cards
    	//If check is passed, increases index by 1
    	if(index < model.keyList.size())
    	index++;
    	//Stores new value for Flash Card passed from Model in a local String
    	String front = model.handleDisplay(index);
    	//Sets correct display for flash card front
    	studyText.setText(front);
    }
    
    //Flips the flashcard from the front to the back
    //This will just change the value displayed within the TextField 'studyText'
    public void handleFlip(ActionEvent event) throws IOException
    {
    	//Displays the flash card 'back' value to the display box
    	String back = model.handleFlip(index);
    	studyText.setText(back);
    }
    
    //Flips the flashcard from the back to the front
    public void handleFlipBack(ActionEvent event) throws IOException
    {
    	//Displays the flash card 'front' value to the display box
    	String front = model.handleDisplay(index);
    	studyText.setText(front);
    }
    
    //Handles the deletion of individual flash cards
    @FXML
    void handleDelete(ActionEvent event) throws IOException {
    	//Makes a call to the Model class to retrieve the 'key' value based on the passed index value
    	//Stores that 'key' in local String
    	String key = model.handleDisplay(index);
    	//Checks whether or not the 'key' exists
    	if(key != null)
    	//Passes the key value to the Model class to handle the deletion
    	model.handleDelete(key);
    	//Alters index based on whether deletion was successful and the change is applicable
    	if(index < model.keyList.size()) 
    	{
    		
    	}
    	else
    	{
    		index--;
    	}
    	//Makes a call to Model class to retrieve new display based on passed Index
    	//Stores display value in a local String
    	String newDisplay = model.handleDisplay(index);
    	//Displays the correct value in the display box
    	studyText.setText(newDisplay);
    }

}
