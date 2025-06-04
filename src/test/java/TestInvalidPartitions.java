import cl.ucn.modelo.Identifier;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isLetter;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestInvalidPartitions {
    // se hace otro test despues de que el identifier falla, haciendo un check paso por paso
    // no se copia la logica principal solo se usa el metodo de
    // testeo y despues se verifica por separado si el valor es realmente valido u invalido
    @Test
    public void testInvalidPartitions(){
        Identifier id = new Identifier();
        InvalidPartittions  invalidPartitions = new InvalidPartittions();
        invalidPartitions.createInvalidPartitions();
        for (String identifier : invalidPartitions.invalidIdentifiers) {

            assertFalse(errorMessage(identifier), id.validateIdentifier(identifier));

        }


    }
    public String errorMessage(String identifier) {

        if(identifier == null || identifier.isEmpty()) {
            return "✅ El identificador no puede ser nulo o vacío.";

        }
        List<String> testMessages = new ArrayList<>();
        String firstChar = identifier.substring(0, 1);
        // probando regla 1
        testMessages.add("1. El identificador "+ identifier +" debe comenzar con una letra (mayúscula o minúscula).");
        if(firstChar.matches("[a-zA-Z]")) {
            testMessages.add("  ❌ El identificador comienza con una letra: |"+ firstChar+"|" + identifier.substring(1, identifier.length()));
        } else {
            testMessages.add("  ✅ El identificador no comienza con una letra: |"+ firstChar+"|" + identifier.substring(1, identifier.length())+" --> "+"|a|"+identifier.substring(1, identifier.length()));
        }
        // probando regla 2
        testMessages.add("2. Los caracteres siguientes (si los hay) son letras o dígitos.");
        testMessages.add("Caracteres del identificador: " + identifier);
        for (char ch : identifier.toCharArray()) {
            if (isLetter(ch) || Character.isDigit(ch)) {
                testMessages.add("  ❌ El caracter |" + ch + "| es válido");
            } else {
                testMessages.add("  ✅ El caracter |" + ch + "| no es válido");
            }
        }
        // probando regla 3
        testMessages.add("3. La longitud total del identificador "+ identifier +" debe ser de 1 a 5 caracteres (inclusive).");
        if(identifier.length() >= 1 && identifier.length() <= 5) {
            testMessages.add("  ❌ La longitud del identificador es válida : " + identifier + ".length() --> "+ identifier.length());
        } else if(identifier.length() < 1) {
            //testMessages.add("  ✅ La longitud del identificador es menor a 1");
        }
        else if(identifier.length() > 5) {
            //testMessages.add("  ✅ La longitud del identificador es mayor a 5: " + identifier+ " --> " + identifier.substring(1, 5));
        }
        String response = "";
        for(String message : testMessages) {
            response += "\n"+(message);
        }
        return response;

    }

}
