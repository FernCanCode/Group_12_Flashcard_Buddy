package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// MainController.java is a controller for this javafx project manages the user interaction with Main.fxml
public class MainController {
	@FXML
	Button make, study, exit;
	// Variables used for connecting specified JavaFX elements
	
	@FXML
	public void make() throws Exception {
		// FUNCTION: GO TO MAKE SECTION
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/Make.fxml"));
		Stage window = (Stage) make.getScene().getWindow();
		window.setScene(new Scene(root, 600, 400));		
	}
	
	@FXML
	public void study() throws Exception {
		// FUNCTION: GO TO STUDY SECTION
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/Study.fxml"));
		Stage window = (Stage) study.getScene().getWindow();
		window.setScene(new Scene(root, 600, 400));
	}
	
	@FXML
	public void exit() throws Exception {
		// FUNCTION: EXIT PROGRAM
		System.exit(0);
	}
}
