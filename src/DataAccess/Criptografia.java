
package DataAccess;

import java.math.BigInteger;

import java.security.MessageDigest; // Fornece algoritmos de hash criptográfico
import java.security.NoSuchAlgorithmException; // Exceção pra erro da classe java security


public class Criptografia { 
    public static String getSHA(String texto) {
        try {

            // O método estático getInstance é chamado com hash SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // O método digest() é chamado para calcular a hash da mensagem, forçando formato UTF_8 para evitar problemas com acentos
            byte[] messageDigest = md.digest(texto.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            // texto.getBytes() - Converte a string recebida em um vetor de bytes
            // md.digest - Calcula o hash UTF_8 desses bytes e retorna um vetor bytes
            // Esse vetor de bytes criptografados é guardada em "messageDiest"
            
            // Convertemos o vetor de bytes em um BigInt
            BigInteger no = new BigInteger(1, messageDigest);
            
            
            // A mensagem em BigInt é convertida para hexadecimal (ex: 255 -> "ff")
            String hashtext = no.toString(16);
            while (hashtext.length() < 64) {
                hashtext = "0" + hashtext;
            }
            
            // Retorna o hash em hexadecimal
            return hashtext;
            
        }

        // Em caso de erro, é lançada uma exceção
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    
}

