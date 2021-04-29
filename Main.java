/*
 *  Name:			| Fernando Canseco	| Jose Cintron		| Dhruv Patel		| Xavier Ramos		| Victor Gloria		|
 *  ab123:			| TSO262			| ZEF510			|					| XZZ259			| UES618			|
 *  Date:			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			| 4/23/21			|		
 *  Class:			| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		| CS-3443-001		|
 *  Assignment:		| Group Project		| Group Project		| Group Project		| Group Project		| Group Project		|
 */
/*
 *  Main.java is the Main class for a JavaFX project. Builds the Stage and the Scene.
 */
package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//links the root with the fxml file we created in scene builder "Main.fxml"
			//Uses FXMLLoader class to Load the Sample.fxml
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			//Creates Scene and links AnchorPane to the scene
			//Scene(Pane, width, height)
			Scene scene = new Scene(root,400,350);
			//Provides the stylesheet for the scene
			//Says that the scene should have the style properties that are present in the stlyesheet we pass as a parameter
			//in this case it is "application.css"
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//Creates Stage object and links the Scene to the Stage
			primaryStage.setScene(scene);
			//Displays the stage
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//main method, 'launches' the 'start' method found above
	public static void main(String[] args) {
		launch(args);
	}
}
