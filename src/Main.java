import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        int key = Integer.parseInt (args[1]);
        String[] encryptedMessage = args[0].split(":");

        String decryptedMessage = decrypt(encryptedMessage,key);

        System.out.println("Decrypted message: " + decryptedMessage);


    }

    private static String decrypt(String[] encryptedMessage, Integer key) {
        HashMap hashes = new HashMap();
        hashes = Constants.kody();
        String[] decryptedArray = new String[encryptedMessage.length];
        StringBuilder finalMessage = new StringBuilder();
        for (int i=0; i<encryptedMessage.length; i++){
           decryptedArray[i] =  Integer.toString((Integer.parseInt(encryptedMessage[i])) / key);

           String[] decryptedArr = new String[decryptedArray.length];
           decryptedArr[i] = (String) hashes.get(Integer.parseInt(decryptedArray[i]));


           finalMessage.append(decryptedArr[i]);
        }
        return finalMessage.toString();
    }
}
