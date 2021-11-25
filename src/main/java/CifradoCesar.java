import java.util.Scanner;

    /**
     * Cifrado Sustitución
     * Creamos una clase CifradoCesar para la encriptación y descencriptación.
     */
public class CifradoCesar {

    public static void main(String[] args) {
        /**
         * Creamos una clase Scanner para leer la entrada del teclado.
         */
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        /**
         * Insertamos las cadenas y lo guardamos en un String.
         */
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        /**
         * Insertamos la frase o valor de entrada.
         */
        System.out.println("Dame una frase");
        String frase = sn.next();

        String texto = codificar(letras, frase);
        System.out.println("Texto codificado de : " + frase + "  es  " + texto);

        String texto1 = descodificar(letras, texto);
        System.out.println("Texto descodificado de : " + texto + "  es  " + texto1);

    }
        /**
         * Creamos el método codificar.
         */
    public static String codificar(String letras, String texto){
        String textoCodificado = "";
        /**
         * El texto codificado se imprime en mayuscula.
         */
        texto = texto.toUpperCase();

        /**
         * Recorremos la cadena con un bucle.
         */
        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);

            int pos = letras.indexOf(caracter);
            /**
             * El texto que vamos a decodificar se encuentre en nuestra cadena.
             */
            if(pos == -1){
                textoCodificado += caracter;
            }else{
                textoCodificado += letras.charAt( (pos + 3) % letras.length() );
            }

        }

        return textoCodificado;
    }
        /**
         * Creamos el método descodificar.
         */
    public static String descodificar(String letras, String texto1){
        String textoDescodificado = "";
        /**
         * El texto descodificado se imprime en mayuscula.
         */
        texto1 = texto1.toUpperCase();
        /**
         * Recorremos la cadena descodificada con un bucle.
         */
        char caracter;
        for (int i = 0; i < texto1.length(); i++) {
            caracter = texto1.charAt(i);

            int pos = letras.indexOf(caracter);
            /**
             * El texto decodificado se encuentre en el texto que ingresamos al inicio.
             */
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
