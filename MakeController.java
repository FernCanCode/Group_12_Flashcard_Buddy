/*
 *  Name:			| Fernando Canseco	| Jose Cintron		| Dhruv Patel		| Xavier Ramos		| Victor Gloria		|
 *  ab123:			| TSO262			|					|					|					|					|
 *  Date:			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			|		
 *  Class:			| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		|
 *  Assignment:		| Group Project		| Group Project		| Group Project		| Group Project		| Group Project		|
 */
/*
 *  MakeController.java is a controller for this javafx project
 *  manages the user interaction with MakeBack.fxml and MakeFront.fxml
 */
package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MakeController {
	Model model = new Model();
	String front=null,back=null;
	@FXML
	private AnchorPane mainPane;

    @FXML
    private TextArea makeFrontText;

    @FXML
    private Button makeFrontNext;

    @FXML
    private Button makeFrontCancel;

    @FXML
    private TextArea makeBackText;

    @FXML
    private Button makeBackCreate;

    @FXML
    private Button makeBackBack;


    //Changes Scene to MakeBack
    //Stores the text entered by the user, to be used on the front of the flash card
    public void handleNext(ActionEvent event) throws IOException
    {
    	//Code for storing information from user entered into 'makeFrontText' TextField
    	//This information will be used to populate the front of the flashcard
    	front = makeFrontText.getText();
    	model.handleNext(front);
    	//Scene Transition
    	//To Be executed after information has been stored from user
    	mainPane = FXMLLoader.load(getClass().getResource("MakeBack.fxml")); //pane you are GOING to
    	Scene scene = new Scene(mainPane); //pane you are going to SHOW
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //pane you are ON
    	window.setScene(scene);
    	window.show();
    }
    
    public void handleCancel(ActionEvent event) throws IOException
    {
    	mainPane = FXMLLoader.load(getClass().getResource("Main.fxml")); //pane you are GOING to
    	Scene scene = new Scene(mainPane); //pane you are going to SHOW
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //pane you are ON
    	window.setScene(scene);
    	window.show();
    }
    
    public void handleBack(ActionEvent event) throws IOException
    {
    	mainPane = FXMLLoader.load(getClass().getResource("MakeFront.fxml")); //pane you are GOING to
    	Scene scene = new Scene(mainPane); //pane you are going to SHOW
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //pane you are ON
    	window.setScene(scene);
    	window.show();
    }
    
    //handles the creation of the flashcard
    //Stores information entered into text box by user
    public void handleCreate(ActionEvent event) throws IOException
    {
    	back = makeBackText.getText();
    	model.handleCreate(back);
    	mainPane = FXMLLoader.load(getClass().getResource("Main.fxml")); //pane you are GOING to
    	Scene scene = new Scene(mainPane); //pane you are going to SHOW
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //pane you are ON
    	window.setScene(scene);
    	window.show();
    }
    

}

	


