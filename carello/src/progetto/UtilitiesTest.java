package progetto;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UtilitiesTest{

    @Test
    public void testGenerateIdIsNotNull(){
        String unique = Utilities.generateUniqueID();
        assertNotNull(unique);
    }

    @Test
    public void testUnique(){
        String unique = Utilities.generateUniqueID();
        String unique2 = Utilities.generateUniqueID();
        assertNotEquals(unique,unique2);
    }
    
}