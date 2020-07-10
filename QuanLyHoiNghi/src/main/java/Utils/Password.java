package Utils;

// Ref: https://gist.github.com/jnizet/edeaaae1f583b5c6ecf1#file-passwordpatcher-java

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

public class Password {

    public static String genPassword(String password) {
        Random random = new Random();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            return enc.encodeToString(salt) + "$"+ enc.encodeToString(hash);
        }  catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean checkPassword(String submittedPassword, String hashedPassword){
        Base64.Encoder enc = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        String[] stored = hashedPassword.split("\\$");
        KeySpec spec1 = new PBEKeySpec(submittedPassword.toCharArray(), decoder.decode(stored[0]), 65536, 128);
        try {
            SecretKeyFactory f1 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] hash1 = f1.generateSecret(spec1).getEncoded();
            return stored[1].equals(enc.encodeToString(hash1));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        System.out.print("Enter password: ");
//        String password = new Scanner(System.in).nextLine();
//        String encode = genPassword(password);
//        System.out.println(encode);
//        String check = null;
//
//        while(!checkPassword(check, encode)){
//            System.out.print("Do it again: ");
//            check = new Scanner(System.in).nextLine();
//        }
//    }
}
