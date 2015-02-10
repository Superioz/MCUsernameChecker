package main.de.superioz.mcuc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class created on 07.02.2015 at 14:25
 */
public class UsernameVerifier {

    public static boolean verifyUsername(String username, Main application){
        boolean isVerified = false;

        // creating patterns to better check the username
        Pattern pattern = Pattern.compile("[a-zA-Z_0-9]*");
        Matcher matcher = pattern.matcher(username);

        if(matcher.matches() && username.length()<=16)
            isVerified = true;
        else
            application.showError("Falsche Eingabe!", "Der Username darf keine Sonderzeichen, Umlaute etc. enthalten. Außerdem muss er unter 16 Zeichen besitzen. Insgesamt gelten nur 'a-z', 'A-Z', '0-9' und '_'. Befolge diese Regel und versuche es erneut. Mit 'Ok' kommst du zurück zur Applikation.");

        return isVerified;
    }

}
