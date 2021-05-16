package application;
	
import java.io.File;
import java.util.LinkedHashMap;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

import application.model.FBAppModel;

/*
 *  Name:			Fernando Canseco 	Jose Cintron 	Dhruv Patel 	Xavier Ramos 	Victor Gloria
 *  				TSO262				ZEF510			ZST725			XZZ259			UES618
 *  
 *  CS-3443-001, Professor Dr. Heena Rathore
 *  Group Project Application: "Flashcard Buddy"
 */

// Main.java is the Main class for a JavaFX project. Builds the Stage and the Scene.
public class Main extends Application {
	public static File data = new File("flashcards.txt");
	public static LinkedHashMap <String, String> h = new LinkedHashMap<String, String>();
	// GLOBAL Variables used throughout the program, mainly being the file containg Flashcard information and the Linked Hash Map to connect the program together.
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			h = FBAppModel.hash(); 
			// Updates the Hash Map with the most recent information from a previous run of the program -- basically updates the Hash Map per run, saving data.
			
			primaryStage.setTitle("Flashcard Buddy");
			primaryStage.setResizable(false);
			// Program's window settings, sets window title and locks resizable potential
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
