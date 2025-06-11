import cl.ucn.modelo.Identifier;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IdentifierTest {
    // Encapsulamos el metodo principal en pequeños
    // pasos usando la clase original para testear el metodo y la clase
    // de esta forma podemos saber en que paso o procedimiento
    // del metodo principal falla la clase.

    Identifier identifier = new Identifier();
    private  boolean hasValidLength(String s, boolean valid_id) {
        if (valid_id && (s.length() >= 1) && (s.length() < 6)) {
            return true;
        } else {
            return false;
        }
    }
    private boolean hasValidCharacters(String s, boolean valid_id) {
        char achar;

        if (s.length() > 1) {
            int i = 1;
            while (i < s.length()) {
                achar = s.charAt(i);
                if (!identifier.valid_f(achar)) {
                    valid_id = false;
                }
                i++;
            }
        }
        return valid_id;
    }
    private boolean firstCharacterValid(String s) {
        char achar;
        boolean valid_id = false;

        achar = s.charAt(0);
        valid_id = identifier.valid_s(achar);
        return valid_id;
    }

    @Test
    public void testValidCharacters() {

        ValidPartitions validPartitions = new ValidPartitions();
        validPartitions.createValidPartitions();
        for (String s : validPartitions.validIdentifiers) {
            assertTrue("❌ Error  checking " + s + " if first character is valid, should be true", firstCharacterValid(s));

        }
        for (String s : validPartitions.validIdentifiers) {
            assertTrue("❌ Error checking if " + s + " has valid characters, should be true", hasValidCharacters(s, true));

        }
        for (String s : validPartitions.validIdentifiers) {
            assertTrue("❌ Error checking if " + s + " has valid length, should be true", hasValidLength(s, true));
        }

    }

    @Test
    public void testInvalidCharacters(){
        InvalidPartittions invalidPartitions = new InvalidPartittions();
        invalidPartitions.createInvalidPartitions();
        for(String s : invalidPartitions.invalidIdentifiers){
            assertFalse("❌Error  checking "+s+" if first character is valid, should be false", firstCharacterValid(s));

        }
        for(String s : invalidPartitions.invalidIdentifiers){
            assertFalse("❌ Error checking if "+s+" has valid characters, should be false", hasValidCharacters(s,true));

        }
        for(String s : invalidPartitions.invalidIdentifiers){
            assertFalse("❌ Error checking if "+s+" has valid length, should be false", hasValidLength(s,true));
        }

    }





}
