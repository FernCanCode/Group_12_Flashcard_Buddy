/*
 *  Name:			| Fernando Canseco	| Jose Cintron		| Dhruv Patel		| Xavier Ramos		| Victor Gloria		|
 *  ab123:			| TSO262			| ZEF510			| ZST725			| XZZ259			| UES618			|
 *  Date:			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			|		
 *  Class:			| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		|
 *  Assignment:		| Group Project		| Group Project		| Group Project		| Group Project		| Group Project		|
 */
/*
 *  MakeController.java is a controller for this javafx project
 *  manages the user interaction with Make.fxml
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

public class MakeController {
	//Instantiates Model object, model handles data manipulation
	Model model = new Model();
	//used to store user input
	String front="",back="";
	
	//Make.fxml elements
	@FXML
	private AnchorPane mainPane;

    @FXML
    private TextField makeBackText;

    @FXML
    private TextField makeFrontText;

    @FXML
    private Button makeFrontCancel;

    @FXML
    private Button makeCardCreate;

    //Stores the text entered by the user, to be used on the front of the flash card and back of the flash card
    //Returns the user back to Main.fxml once the flashcard creation is complete
    public void handleCreate(ActionEvent event) throws IOException
    {
    	//Stores user input into local Strings
    	front = makeFrontText.getText();
    	back = makeBackText.getText();
    	//passes off user input to Model class
    	model.handleCreate(front, back);
    	//Returns user to Main.fxml
    	mainPane = FXMLLoader.load(getClass().getResource("Main.fxml")); //pane you are GOING to
    	Scene scene = new Scene(mainPane); //pane you are going to SHOW
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //pane you are ON
    	window.setScene(scene);
    	window.show();
    }
    
    //Returns the user to Main.fxml without creating a flash card
    public void handleCancel(ActionEvent event) throws IOException
    {
    	mainPane = FXMLLoader.load(getClass().getResource("Main.fxml")); //pane you are GOING to
    	Scene scene = new Scene(mainPane); //pane you are going to SHOW
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //pane you are ON
    	window.setScene(scene);
    	window.show();
    }
    

    


}

	


