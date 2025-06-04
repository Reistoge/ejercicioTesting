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
        startWithLetter.add("abc");//->
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


}
