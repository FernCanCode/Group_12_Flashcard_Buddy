/*
 *  Name:			| Fernando Canseco	| Jose Cintron		| Dhruv Patel		| Xavier Ramos		| Victor Gloria		|
 *  ab123:			| TSO262			|					|					|					|					|
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
	Model model = new Model();
	int index = 0;
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
    
    
    public void handleExit(ActionEvent event) throws IOException
    {
    	mainPane = FXMLLoader.load(getClass().getResource("Main.fxml")); //pane you are GOING to
    	Scene scene = new Scene(mainPane); //pane you are going to SHOW
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //pane you are ON
    	window.setScene(scene);
    	window.show();
    }
    
    //Handles the default display when the Study scene is first opened
    public void handleBegin()
    {
    	model.currentIndex(index);
    	String defaultText = model.handleDisplay(index);
    	studyText.setText(defaultText);
    }
    
    
    //Changes the flashcard to the previous card
    public void handlePrevious(ActionEvent event) throws IOException
    {
    	
    	model.handlePrevious();
    	if(index > 0)
        	index--;
    	String front = model.handleDisplay(index);
    	studyText.setText(front);
    	
    	
    }
    
    //Changes the flashcard to the next card
    public void handleNext(ActionEvent event) throws IOException
    {
    	model.handleNext(index);
    	if(index < model.keyList.size())
    	index++;
    	String front = model.handleDisplay(index);
    	
    	studyText.setText(front);
    }
    
    //Flips the flashcard from the front to the back
    //This will just change the value displayed within the TextField 'studyText'
    public void handleFlip(ActionEvent event) throws IOException
    {
    	String back = model.handleFlip(index);
    	studyText.setText(back);
    }
    
    public void handleFlipBack(ActionEvent event) throws IOException
    {
    	String front = model.handleDisplay(index);
    	studyText.setText(front);
    }

}
