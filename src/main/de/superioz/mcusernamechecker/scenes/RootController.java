package main.de.superioz.mcusernamechecker.scenes;

import main.de.superioz.mcusernamechecker.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * Class created on 06.02.2015 at 20:14
 */
public class RootController {

    // variables
    public Main app;

    // setting main app to use
    public void setMain(Main main){
        this.app = main;
    }

    /*
    Exit programm, when clicked
     */
    @FXML
    public void handleExitProgram(){
        System.exit(0);
    }

    /*
    show help dialog, when clicked
     */
    @FXML
    public void handleHelp(){
        Alert helpDialog = new Alert(Alert.AlertType.INFORMATION);
        helpDialog.setTitle(app.title);
        helpDialog.setHeaderText("Programmnutzung");
        helpDialog.setContentText("Das Programm ist sehr simpel zu benutzen. Das einzigste, was man benötigt, ist eine laufende Internetverbindung, da es sonst dazu führen könnte, das Anzeigefehler entstehen (muss nicht, kann aber).\n"
        + "Als erstes trägt man den gewünschten Usernamen ein, folgende Regeln beachten:\n"
        + "- Nur Buchstaben von a-z oder A-Z\n"
        + "- Zahlen von 0-9 sind erlaubt\n"
        + "- Keine Sonderzeichen, außer '_'\n"
        + "Danach drückt man den Button 'Überprüfe Name' und fertig! Das Programm spuckt eine Antwot aus.");

        helpDialog.show();
    }

    /*
    show dialog about author
     */
    @FXML
    public void handleAbout(){
        Alert aboutDialog = new Alert(Alert.AlertType.INFORMATION);
        aboutDialog.setTitle(app.title);
        aboutDialog.setHeaderText("Über dieses Programm");
        aboutDialog.setContentText(
                "MCUsernameChecker ist ein Programm von Superioz und dient zur Überprüfung eines Minecraft Usernames, ob dieser als Premium angemeldet ist. Damit lässt sich zum Beispiel sehen, ob dieser Name schon vergeben ist und ist nützlich, wenn man sehen möchte, ob man einen bestimmten Namen benutzen kann."
        );

        aboutDialog.show();
    }

}
