package progetto.Utility;

import java.util.UUID;

public class GenerateUniqueId {

    public static String generateUniqueID(){
        return UUID.randomUUID().toString();
    }
}
