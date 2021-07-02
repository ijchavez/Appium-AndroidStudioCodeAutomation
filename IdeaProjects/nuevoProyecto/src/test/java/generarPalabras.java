import java.util.Random;

public class generarPalabras{
    public static void main(String[] args) {
        String pass = generarPassword();
        System.out.println(pass);


    }
    public static String generarPassword(){
        String palabra = "";
        int number = (int)(10000 * Math.random());
        int caracteres = (int)(Math.random()*1)+4;
        for (int i=0; i<caracteres; i++){
            int codigoAscii = (int)Math.floor(Math.random()*(122 - 100)+100);
            palabra = palabra + (char)codigoAscii;

        }
        String pass = palabra + number;
        return pass;

    }

}
