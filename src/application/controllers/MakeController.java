package application.controllers;

import java.util.LinkedHashMap;

import application.Main;
import application.model.FBAppModel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


// MakeController.java is a controller for this javafx project manages the user interaction with MakeBack.fxml and MakeFront.fxml
public class MakeController {
	@FXML
	Button create, exit;
	
	@FXML
	TextField front, back;
	// Variables used for connecting specified JavaFX elements
	
	
	@FXML
	public void create() throws Exception {
		// FUNCTION: CREATE FLASHCARD
		try {
			LinkedHashMap<String, String> h = Main.h; // Linked Hash Map for flashcards 
			String key = front.getText(); // Front text
			String val = back.getText();  // Back  text
			
			if(key.equals("") | val.equals("")) {
				FBAppModel.alert("ERROR", "Please fill all of the required information!");
			} else { 
				h.put(key, val);
				FBAppModel.update(h);
				FBAppModel.alert("CONFIRMATION", "Flashcard was created!"); 
			} // Alert information, checks if success or not -- mainly due to errors of invalid input, which is aware from testing
			
			front.clear();
			back.clear();
		} catch(Exception e) {
			FBAppModel.alert("ERROR", "Program ran into an error.");
		}
	}
	
	@FXML
	public void exit() throws Exception {
		// FUNCTION: GO HOME
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
		Stage window = (Stage) exit.getScene().getWindow();
		window.setScene(new Scene(root, 600, 400));	
	}
}
