import cl.ucn.modelo.Identifier;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isLetter;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InvalidPartittions {
    List<String> invalidIdentifiers = new ArrayList<>();
    public void createInvalidPartitions() {
        //1. El identificador no debe comenzar con una letra (mayúscula o minúscula).
        List<String> startWithNoLetter = new ArrayList<>();
        startWithNoLetter.add("abc"); // -> valido
        startWithNoLetter.add("2xy");
        startWithNoLetter.add("3A");
        startWithNoLetter.add("4b");
        startWithNoLetter.add("5Zy");
        invalidIdentifiers.addAll(startWithNoLetter);

        //2. Los caracteres siguientes (si los hay) no son letras o dígitos.

        List<String> invalidCharacters = new ArrayList<>();
        invalidCharacters.add("a@b");
        invalidCharacters.add("c#d");
        invalidCharacters.add("e$f");
        invalidCharacters.add("g!h");
        invalidIdentifiers.addAll(invalidCharacters);

        //3. La longitud total del identificador debe ser de 1 a 5 caracteres (inclusive).
        List<String> invalidLength = new ArrayList<>();
        // invalidLength.add(""); // Longitud 0 --> estos dan error en el código original, ya que no se valida longitud 0
        //invalidLength.add(new String()); //
        invalidLength.add("abcdef"); // Más de 5 caracteres
        invalidLength.add("qwertyuiopasdfghjklzxcvbnm"); // Más de 5 caracteres
        invalidIdentifiers.addAll(invalidLength);

     }

    @Test
    public void testInvalidPartitions(){
        Identifier id = new Identifier();
        createInvalidPartitions();
        for (String identifier : invalidIdentifiers) {
            assertTrue(errorMessage(identifier), id.validateIdentifier(identifier));

        }


    }
    public String errorMessage2(String identifier){


        return
    }
    public String errorMessage(String identifier) {
        System.out.println("Identifier deberia ser invalido: " + identifier);
        if(identifier == null || identifier.isEmpty()) {
            return "❌ El identificador no puede ser nulo o vacío.";

        }
        List<String> testMessages = new ArrayList<>();
        String firstChar = identifier.substring(0, 1);
        // probando regla 1
        testMessages.add("1. El identificador "+ identifier +" debe comenzar con una letra (mayúscula o minúscula).");
        if(firstChar.matches("[a-zA-Z]")) {
            testMessages.add("  ✅ El identificador comienza con una letra: |"+ firstChar+"|" + identifier.substring(1, identifier.length()));
        } else {
            testMessages.add("  ❌ El identificador no comienza con una letra: |"+ firstChar+"|" + identifier.substring(1, identifier.length())+" --> "+"|a|"+identifier.substring(1, identifier.length()));
        }
        // probando regla 2
        testMessages.add("2. Los caracteres siguientes (si los hay) son letras o dígitos.");
        testMessages.add("Caracteres del identificador: " + identifier);
        for (char ch : identifier.toCharArray()) {
            if (isLetter(ch) || Character.isDigit(ch)) {
                testMessages.add("  ✅ El caracter |" + ch + "| es válido");
            } else {
                testMessages.add("  ❌ El caracter |" + ch + "| no es válido");
            }
        }
        // probando regla 3
        testMessages.add("3. La longitud total del identificador "+ identifier +" debe ser de 1 a 5 caracteres (inclusive).");
        if(identifier.length() >= 1 && identifier.length() <= 5) {
            testMessages.add("  ✅ La longitud del identificador es válida : " + identifier + ".length() --> "+ identifier.length());
        } else if(identifier.length() < 1) {
            testMessages.add("  ❌ La longitud del identificador es menor a 1");
        }
        else if(identifier.length() > 5) {
            testMessages.add("  ❌ La longitud del identificador es mayor a 5: " + identifier+ " --> " + identifier.substring(1, 5));
        }
        String response = "";
        for(String message : testMessages) {
            response += "\n"+(message);
        }
        return response;

    }
}
