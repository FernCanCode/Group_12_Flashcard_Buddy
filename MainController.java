/*
 *  Name:			| Fernando Canseco	| Jose Cintron		| Dhruv Patel		| Xavier Ramos		| Victor Gloria		|
 *  ab123:			| TSO262			|					|					|					|					|
 *  Date:			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			|		
 *  Class:			| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		|
 *  Assignment:		| Group Project		| Group Project		| Group Project		| Group Project		| Group Project		|
 */
/*
 *  MainController.java is a controller for this javafx project
 *  manages the user interaction with Main.fxml
 */
package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private AnchorPane mainPane;

    @FXML
    private Button ClickMake;

    @FXML
    private Button ClickStudy;

    @FXML
    private Button ClickExit;
    

    //Handles the Make Flashcard button event
    //Changes the mainPane to Make.fxml
    @FXML
    public void handleMake(ActionEvent event) throws IOException
    {
    	mainPane = FXMLLoader.load(getClass().getResource("MakeFront.fxml")); //pane you are GOING to
    	Scene scene = new Scene(mainPane); //pane you are going to SHOW
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow(); //pane you are ON
    	window.setScene(scene);
    	window.show();
    }
    
    //Handles the Study Flashcards button event
    //Changes the mainPane to Study.fxml
    @FXML
    public void handleStudy(ActionEvent event) throws IOException
    {
    	mainPane = FXMLLoader.load(getClass().getResource("Study.fxml"));
    	Scene scene = new Scene(mainPane);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    //Handles the Exit button event
    //Exits the application
    @FXML
    public void handleExit(ActionEvent event) throws IOException
    {
    	System.exit(0);
    }
}
