package cl.ucn.main;

import cl.ucn.modelo.Identifier;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: IdentifierMain <string>");
        } else {
            Identifier id = new Identifier();
            if (id.validateIdentifier(args[0])) {
                System.out.println("Válido");
            } else {
                System.out.println("Inválido");
            }
        }
    }
}
