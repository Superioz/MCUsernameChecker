package de.superioz.mcuc.scenes;

import de.superioz.mcuc.Main;
import de.superioz.mcuc.PremiumChecker;
import de.superioz.mcuc.UsernameVerifier;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Class created on 06.02.2015 at 20:14
 */
public class FunctionController {

    // Variablen
    public Main app;

    // FXML Variablen
    @FXML
    private TextField textField;
    @FXML
    private Label resultLabel;
    @FXML
    private ProgressIndicator progressIndicator;

    // Übergebe die Mainapp zum bearbeiten
    public void setMain(Main main){
        this.app = main;
    }

    /*
    Überprüfe ob der eingegebe Name ein Premium Account ist
     */
    @FXML
    public void handleCheckUsername(){
        String givenName = textField.getText();

        if(givenName.isEmpty()){
            this.app.showError("Falsche Eingabe!", "Das Textfeld darf nicht leer bleiben, sonst kann nicht überprüft werden, ob der Spieler wirklich ein Premium User ist. Drücke 'Ok' um zur Applikation zurück zu kehren.");
            return;
        }
        else if(!(UsernameVerifier.verifyUsername(givenName, this.app))){
            return;
        }

        progressIndicator.setVisible(true);
        final boolean[] isPremium = {false};

        // Setze den Timer neu um Text verschwinden zu lassen
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isPremium[0] = PremiumChecker.checkUsername(givenName, app);

                // Nachdem Server angepingt wurde, kann weitergemacht werden
                progressIndicator.setVisible(false);

                Platform.runLater(() -> {
                    // Nehme isPremium und setze entsprechend das Label
                    resultLabel.setVisible(true);
                    setResultLabel(isPremium[0]);
                });
            }
        }, 60*25);

        // Setze den Timer neu um Text verschwinden zu lassen
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> resultLabel.setVisible(false));
            }
        }, 60*100);
    }

    public void setResultLabel(boolean isPremium){
        if(isPremium){
            resultLabel.setText("Der Username ist bereits vergeben.");
            resultLabel.setTextFill(Color.RED);
        }
        else{
            resultLabel.setText("Der Username ist noch frei.");
            resultLabel.setTextFill(Color.GREEN);
        }
    }

}
