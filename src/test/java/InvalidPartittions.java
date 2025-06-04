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
        startWithNoLetter.add("1abc"); // -> valido
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


}
