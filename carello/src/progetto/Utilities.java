package progetto;

import java.util.UUID;

public class Utilities {

    public static String generateUniqueID(){
        return UUID.randomUUID().toString();
    }
}
