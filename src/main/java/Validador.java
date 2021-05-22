import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    public static boolean validarNombre(String nombre) {

        Pattern pat = Pattern.compile("[A-Z][a-z]{1,}$");
        Matcher mat = pat.matcher(nombre);

        if(mat.matches()){
            return true;
        }
        System.out.println("Nombre no válido");
        return false;
    }

    public static boolean validarApellido(String apellido){

        Pattern pat = Pattern.compile("[A-Z][a-z]{1,}$");
        Matcher mat = pat.matcher(apellido);

        if(mat.matches()){
            return true;
        }
        System.out.println("Apellido no válido");
        return false;
    }

    public static boolean validarNumTelefono(String numTelefono){

        Pattern pat = Pattern.compile("[1-9][0-9]{7}$");
        Matcher mat = pat.matcher(String.valueOf(numTelefono));

        if(mat.matches()){
            return true;
        }
        System.out.println("Número telefónico no válido");
        return false;
    }

    public static String entradaString() {

        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    public static int entradaInt() {

        int entrada = 0;

        try {
            entrada = Integer.parseInt(entradaString());
        } catch (NumberFormatException ex) {
            System.out.println("Entrada no válida");
        }
        return entrada;
    }
}
