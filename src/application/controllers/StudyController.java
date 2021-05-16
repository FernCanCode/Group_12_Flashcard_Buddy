package application.controllers;

import java.util.LinkedHashMap;
import java.util.Random;

import application.Main;
import application.model.FBAppModel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// StudyController.java is a controller for this JavaFX project manages the user interaction with Study.fxml
public class StudyController {
	int index = 0;
	boolean random = false;
	String condition = "FRONT";
	LinkedHashMap <String, String> h = Main.h;
	// Variables used for flowing the program together
	
	@FXML
	Button text, next, previous;
	
	@FXML
	Button delete, clear, exit;
	
	@FXML
	ToggleButton shuffle;
	
	@FXML
	TextField card;
	
	@FXML
	ImageView flashcard;
	// Variables used for connecting specified JavaFX elements
	
	public void next() throws Exception {
		// FUNCTION: GO TO NEXT
		Object arr[][] = FBAppModel.array(h);
		//handles navigation of flashcards to the right
		try {
			if (index < arr.length - 1) {
				index++;
			} else {
				index = 0;
			}
			//Handles shuffle functionality
			if (random) {
				Random rand = new Random();
				index = rand.nextInt(arr.length);
			} // SHUFFLE
			
			Integer num = index + 1;
			card.setText(num.toString());
			text.setText((String)arr[index][0]);
		} catch(Exception e) {
			FBAppModel.alert("ERROR", "Flashcards do not exist!");
		}
	}
	
	public void previous() throws Exception {
		// FUNCTION: GO TO PREVIOUS
		Object arr[][] = FBAppModel.array(h);
		//Handles navigation of flashcards to the left
		try {
			if (index > 0) {
				index--;
			} else {
				index = FBAppModel.array(h).length - 1;
			}
			//Handles shuffle functionality
			if (random) {
				Random rand = new Random();
				index = rand.nextInt(FBAppModel.array(h).length);
			} // SHUFFLE
			
			Integer num = index + 1;
			card.setText(num.toString());
			text.setText((String)arr[index][0]);
		} catch(Exception e) {
			FBAppModel.alert("ERROR", "Flashcards do not exist!");
		}
	}
	
	@FXML
	public void flashcard() throws Exception {
		// FUNCTION: FLASHCARD. FLIP ON CLICK
		Object arr[][] = FBAppModel.array(h);
		try {
			if (condition.equals("FRONT")) { 		// FRONT VIEW
				Image image = new Image(getClass().getResourceAsStream("/view/resources/Front.png")); // IMAGE INFORMATION
				flashcard.setImage(image);
				text.setText((String)arr[index][0]);												  // TEXT  INFORMATION
				condition = "BACK";
			} else if (condition.equals("BACK")) {	// BACK VIEW
				Image image = new Image(getClass().getResourceAsStream("/view/resources/Back.png"));
				flashcard.setImage(image);
				text.setText((String)arr[index][1]);
				condition = "FRONT";
			}
		} catch(Exception e) {
			FBAppModel.alert("ERROR", "Flashcard does not exist!");
		}
	}
	
	@FXML
	public void shuffle() throws Exception {
		// FUNCTION: TOGGLE SHUFFLE
		if (!random) {
			random = true;
		} else if (random) {
			random = false;
		}
	}
	
	@FXML
	public void delete() throws Exception {
		// FUNCTION: DELETE FLASHCARD
		try {
			Object arr[][] = FBAppModel.array(h);
			h.remove((String)arr[index][0]);
			FBAppModel.update(h);
			FBAppModel.alert("CONFIRMATION", "Flashcard was deleted!");
		} catch(Exception e) {
			FBAppModel.alert("ERROR", "No available flashcard to delete!");
		}
	}
	
	@FXML
	public void clear() throws Exception {
		// FUNCTION: CLEAR FLASHCARDS
		h.clear();
		FBAppModel.update(h);
		FBAppModel.alert("CONFIRMATION", "All flashcards have been deleted!");
	}
	
	@FXML
	public void exit() throws Exception {
		// FUNCTION: GO HOME
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
		Stage window = (Stage) exit.getScene().getWindow();
		window.setScene(new Scene(root, 600, 400));	
	}
}
