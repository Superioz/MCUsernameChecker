package main.de.superioz.mcusernamechecker;

import main.de.superioz.mcusernamechecker.scenes.FunctionController;
import main.de.superioz.mcusernamechecker.scenes.RootController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    // variables
    public Stage mainStage;
    public BorderPane rootPane;
    public String title = "MCUsernameChecker";

    @Override
    public void start(Stage stage) throws Exception{
        mainStage = stage;
        stage.setTitle(title+" | Premium Usernameprüfung");
        stage.setResizable(false);
        stage.centerOnScreen();

        // init the layout
        this.initLayout();
        this.initInnerContent();

        // show app
        stage.show();
    }

    public void initLayout(){
        try{
            // load fxml file of root
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scenes/root.fxml"));
            rootPane = loader.load();

            // giving controller access to root
            RootController rootController = loader.getController();
            rootController.setMain(this);

            // setting root pane
            Scene scene = new Scene(rootPane);
            scene.getStylesheets().add(Main.class.getResource("style/style.css").toExternalForm());
            mainStage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void initInnerContent(){
        try{
            // load the content fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scenes/ignchecker.fxml"));
            AnchorPane ignChecker = loader.load();

            // setting content
            rootPane.setCenter(ignChecker);

            // load controller and giving access to main
            FunctionController controller = loader.getController();
            controller.setMain(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void showError(String headerText, String contentText){
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Programm Error");
        dialog.setHeaderText(headerText);
        dialog.setContentText(contentText);

        dialog.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
