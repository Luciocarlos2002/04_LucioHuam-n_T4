
import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * Cifrado Asimétrico
 * Creamos una clase RSA para la encriptación y descencriptación.
 */
public class RSA {
    /**
     * Creamos una par de claves con KeyPairGenerator para obtener nuestras claves privadas y públicas.
     */
    private PrivateKey privateKey;
    private PublicKey publicKey;
    /**
     * Alojamos nuestras claves generadas en el constructor.
     */
    public RSA() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            KeyPair pair = generator.generateKeyPair();
            privateKey = pair.getPrivate();
            publicKey = pair.getPublic();
        } catch (Exception ignored) {
        }
    }
    /**
     * Crearemos dos métodos para codificar y decodificar.
     * Creamos el método encrypt.
     * Mensaje crifrado se convertira en bytes con el método cipher.doFinal(byte[]).
     */
    public String encrypt(String message) throws Exception{
        byte[] messageToBytes = message.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return encode(encryptedBytes);
    }
    private String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * Creamos el método decrypt.
     * Mensaje crifrado devolveran los bytes descifrados usando DECRYPT_MODE new String(bytes[]).
     */
    public String decrypt(String encryptedMessage) throws Exception{
        byte[] encryptedBytes = decode(encryptedMessage);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
        return new String(decryptedMessage,"UTF8");
    }
    private byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }
    /**
     * Creamos un método principal para probar el cifrado y decifrado.
     */
    public static void main(String[] args) {
        RSA rsa = new RSA();
        try{
            String encryptedMessage = rsa.encrypt("Hello World");
            String decryptedMessage = rsa.decrypt(encryptedMessage);

            System.err.println("Encriptando el mensaje a:\n"+encryptedMessage);
            System.err.println("Decifrando el Encriptado a:\n"+decryptedMessage);
        }catch (Exception ingored){}
    }
}
