# Group_12_Flashcard_Buddy
JavaFX application that creates and stores flashcards for the user to use.

Tasks To Do:
Debug Model.java and MakeController.java interaction
    User input isn't being properly saved to the HashMaps, so Study.java has nothing to display
     This may be due to the Model class being reinstantiated every single time a new .fxml is being loaded
     Possible fix would be to write out to a .properties file, this would also allow the user to save their flashcards between sessions
Application.css is completely empty. This needs to be filled with jpgs for the various buttons and scene elements. The scenes are currently very barebones, and we should try
    to make it look nice and presentable before it's due.
Previous and Next buttons on Study.fxml need work to get functional 
        This might have to wait until after we fix the debug issue.
Stretch Goals:
  These are features which would be nice to have included, but are not necessary for the basic function of the application
      1) Ability for user to delete individual flashcards from their collection
      2) Ability for user to delete entire collection all at once
      3) Ability for user to randomize their flashcard collection for study(This one seems pretty yikes)
      4) Any other cool features ya'll would like to add, let's really make this our own. So if there is anything you would like to see on it, just go ahead and add it.
                As long as it works it should be fine.
