import java.util.Scanner;

public class CifradoCesar {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

        System.out.println("Dame una frase");
        String frase = sn.next();

        String texto = codificar(letras, frase);
        System.out.println("Texto codificado de : " + frase + "  es  " + texto);

        String texto1 = descodificar(letras, texto);
        System.out.println("Texto descodificado de : " + texto + "  es  " + texto1);

    }

    public static String codificar(String letras, String texto){
        String textoCodificado = "";

        texto = texto.toUpperCase();

        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);

            int pos = letras.indexOf(caracter);

            if(pos == -1){
                textoCodificado += caracter;
            }else{
                textoCodificado += letras.charAt( (pos + 3) % letras.length() );
            }

        }

        return textoCodificado;
    }

    public static String descodificar(String letras, String texto1){
        String textoDescodificado = "";

        texto1 = texto1.toUpperCase();

        char caracter;
        for (int i = 0; i < texto1.length(); i++) {
            caracter = texto1.charAt(i);

            int pos = letras.indexOf(caracter);

            if(pos == -1){
                textoDescodificado += caracter;
            }else{
                if(pos - 3 < 0){
                    textoDescodificado += letras.charAt( letras.length() + (pos - 3) );
                }else{
                    textoDescodificado += letras.charAt( (pos - 3) % letras.length() );
                }
            }

        }

        return textoDescodificado;
    }

}
