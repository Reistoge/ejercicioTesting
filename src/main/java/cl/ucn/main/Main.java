package cl.ucn.main;

import cl.ucn.modelo.Identifier;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String a = "a";
        System.out.println( a.substring(0,a.length()));

        List<String > test = List.of("a","b","c");
        for(String message : test) {
            System.out.println("Mensaje: " + message);
        }
//        if (args.length == 0) {
//            System.out.println("Uso: IdentifierMain <string>");
//        } else {
//            Identifier id = new Identifier();
//            if (id.validateIdentifier(args[0])) {
//                System.out.println("Válido");
//            } else {
//                System.out.println("Inválido");
//            }
//        }
    }
}
