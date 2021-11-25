import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

    /**
     * Creamos una clase DES para la encriptación y descencriptación.
     */
public class DES {
    /**
     * Creamos el método encryption para nuestro archivo.
     */
    public static void encryption()
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException
    {
        try
        {
            /**
             * Creamos nuestro key y especificamos el tipo de algoritmo DES.
             */
            Cipher cipher=Cipher.getInstance("DES");
            KeyGenerator keyg=KeyGenerator.getInstance("DES");
            Key key=keyg.generateKey();
            /**
             * Creamos el ENCRYPT_MODE.
             */
            cipher.init(Cipher.ENCRYPT_MODE, key);
            /**
             * Insertamos la ubicación de nuestro archivo.
             */
            CipherInputStream cipt=new CipherInputStream(new FileInputStream(new File("C:\\Users\\Carlos\\Desktop\\04_LucioHuaman_T4\\LucioHuaman.jpg")), cipher);
            /**
             * Guardamos el archivo encriptado en la misma ubicación con tipo de archivo .txt
             */
            FileOutputStream fileip=new FileOutputStream(new File("C:\\Users\\Carlos\\Desktop\\04_LucioHuaman_T4\\encrypt.txt"));
            System.err.println("Imagen Ecriptada dentro de la carpeta - 04_LucioHuamán_T4");

            int i;
            while((i=cipt.read())!=-1)
            {
                fileip.write(i);

            }
            /**
             * Creamos el DECRYPT_MODE.
             */
            cipher.init(Cipher.DECRYPT_MODE, key);
            /**
             * Insertamos la ubicación de nuestro archivo encriptado.
             */
            CipherInputStream ciptt=new CipherInputStream(new FileInputStream(new File("C:\\Users\\Carlos\\Desktop\\04_LucioHuaman_T4\\encrypt.txt")), cipher);
            /**
             * Guardamos el archivo descencriptado en la misma ubicación con tipo de archivo .jpg
             */
            FileOutputStream fileop=new FileOutputStream(new File("C:\\Users\\Carlos\\Desktop\\04_LucioHuaman_T4\\decrypt.jpg"));
            System.err.println("Descencriptando la imagen Encriptada en la carpeta - 04_LucioHuamán_T4");

            int j;
            while((j=ciptt.read())!=-1)
            {
                fileop.write(j);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
        /**
         * Creamos una clase principal para imprimir nuestros métodos
         */
    public static void main(String[] args)
    {
        try
        {
            DES.encryption();

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
