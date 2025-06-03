import cl.ucn.modelo.Identifier;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isLetter;
import static org.junit.Assert.assertTrue;

public class ValidPartitions {
    List<String> validIdentifiers = new ArrayList<>();
    public void createValidPartitions() {
        //1. El identificador debe comenzar con una letra (mayúscula o minúscula).
        List<String> startWithLetter = new ArrayList<>();
        startWithLetter.add("1abc");//->
        startWithLetter.add("xy");
        startWithLetter.add("A");
        startWithLetter.add("b");
        startWithLetter.add("Zy");
        validIdentifiers.addAll(startWithLetter);

        //2. Los caracteres siguientes (si los hay) son letras o dígitos.

        List<String> validCharacters = new ArrayList<>();
        validCharacters.add("a"); // Solo letra
        validCharacters.add("b1"); // Letra y dígito
        validCharacters.add("c3d4"); // Letras y dígitos
        validCharacters.add("ZyXwV"); // Letras mayúsculas y minúsculas

        validIdentifiers.addAll(validCharacters);

        //3. La longitud total del identificador debe ser de 1 a 5 caracteres (inclusive).
        List<String> validLength = new ArrayList<>();
        validLength.add("a"); // Longitud 1
        validLength.add("ab"); // Longitud 2
        validLength.add("abc"); // Longitud 3
        validLength.add("abcd"); // Longitud 4
        validLength.add("abcde"); // Longitud 5
        validIdentifiers.addAll(validLength);
    }

    @Test
    public void testValidPartitions(){
        Identifier id = new Identifier();
        createValidPartitions();
        for (String identifier : validIdentifiers) {
            assertTrue(errorMessage(identifier), id.validateIdentifier(identifier));

        }


    }
    public String errorMessage(String identifier) {
        System.out.println("Identifier deberia ser valido: " + identifier);
        if(identifier == null || identifier.isEmpty()) {
            return "❌ El identificador no puede ser nulo o vacío.";

        }
        List<String> testMessages = new ArrayList<>();
        String firstChar = identifier.substring(0, 1);
        testMessages.add("1. El identificador "+ identifier +" debe comenzar con una letra (mayúscula o minúscula).");
        if(firstChar.matches("[a-zA-Z]")) {
            testMessages.add("  ✅ El identificador comienza con una letra: |"+ firstChar+"|" + identifier.substring(1, identifier.length()));
        } else {
            testMessages.add("  ❌ El identificador no comienza con una letra: |"+ firstChar+"|" + identifier.substring(1, identifier.length())+" --> "+"|a|"+identifier.substring(1, identifier.length()));
        }
        testMessages.add("2. Los caracteres siguientes (si los hay) son letras o dígitos.");
        testMessages.add("Caracteres del identificador: " + identifier);
        for (char ch : identifier.toCharArray()) {
            if (isLetter(ch) || Character.isDigit(ch)) {
                testMessages.add("  ✅ El caracter |" + ch + "| es válido");
            } else {
                testMessages.add("  ❌ El caracter |" + ch + "| no es válido");
            }
        }
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
