package de.superioz.mcuc;

import de.superioz.mcuc.scenes.FunctionController;
import de.superioz.mcuc.scenes.RootController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    // Variablen
    public Stage mainStage;
    public BorderPane rootPane;
    public String title = "MCUsernameChecker";

    @Override
    public void start(Stage stage) throws Exception{
        mainStage = stage;
        stage.setTitle(title+" | Premium Usernameprüfung");
        stage.setResizable(false);
        stage.centerOnScreen();

        // Initialisiere das Layout
        this.initLayout();
        this.initInnerContent();

        // Zeige App
        stage.show();
    }

    public void initLayout(){
        try{
            // Lade die FXML Datei von dem Root Layout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scenes/root.fxml"));
            rootPane = loader.load();

            // Gebe dem Controller Zugang zu Root
            RootController rootController = loader.getController();
            rootController.setMain(this);

            // Setze Rootpane in die Szene und setze sie in die Stage
            Scene scene = new Scene(rootPane);
            scene.getStylesheets().add(Main.class.getResource("style/style.css").toExternalForm());
            mainStage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void initInnerContent(){
        try{
            // Lade die FXML Datei vom Content innendrin
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("scenes/ignchecker.fxml"));
            AnchorPane ignChecker = loader.load();

            // Setze Content in die Root Pane hinein
            rootPane.setCenter(ignChecker);

            // Lade den Controller und übergebe diese Klasse
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
