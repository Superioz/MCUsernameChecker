package de.superioz.mcuc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Class created on 07.02.2015 at 12:29
 */
public class PremiumChecker {

    public static boolean checkUsername(String username, Main app){
        boolean isPrem = false;

        try {
            // URL für Überprüfung
            URL url = new URL("https://www.minecraft.net/haspaid.jsp?user=" + username);

            // Bekomme Text aus dem AutorisationslinkSuper
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;

            while ((str = in.readLine()) != null) {
                isPrem = convertStringToBoolean(str);
            }

            // Schließe Stream
            in.close();
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return isPrem;
    }

    public static boolean convertStringToBoolean(String string){
        if(string.equals("true"))
            return true;
        else if(string.equals("false"))
            return false;

        return false;
    }


}
