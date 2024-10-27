import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Encrytion {

    private Scanner sc = new Scanner(System.in);
    private List<Character> key;
    private List<Character> shuffledKey;
    private Map<Character, Character> encryptedMap;
    private Map<Character, Character> decryptedMap;
    
    public Encrytion() {
        key = new ArrayList<>();
        shuffledKey = new ArrayList<>();
        createKey();
        getQuestion();
    }
    private void getQuestion() {

        while (true) {
            System.out.println("(1) New Key, (2) Get Key,(3) Encrypt, (4) Decrypt, (5) Quit");
            int choice;
            try {
                choice = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You're a fucking idiot!, You can't do that!");
                continue;
            }

            switch (choice) {
                case 1:
                    createKey();
                    break;
                case 2:
                    getKey();
                    break;
                case 3:
                    encrypt();
                    break;
                case 4:
                    decrypt();
                    break;
                case 5:
                    quit();
                    break;
                default:
                    System.out.println("Yo Motherfucker!, You're a fucking idiot!, You can't do that!");
            }
        }

    }
    private void createKey() {
        for(int i = 33; i < 127; i++) {
            key.add((char) i);
        }
        shuffledKey = new ArrayList<>(key);
        Collections.shuffle(shuffledKey);

        encryptedMap = new HashMap<>();
        decryptedMap = new HashMap<>();
        for(int i = 0; i < key.size(); i++) {
            encryptedMap.put(key.get(i), shuffledKey.get(i));
            decryptedMap.put(shuffledKey.get(i), key.get(i));
        }
    }
    private void getKey() {
        // System.out.print("Your key is: ");
        // for(int i = 0; i < key.size(); i++) {
        //     System.out.print(key.get(i));
        // }
        // System.out.println();
        System.out.print("Your key is: ");
        for(int i = 0; i < shuffledKey.size(); i++) {
            System.out.print(shuffledKey.get(i));
        }
        System.out.println();

    }
    private void encrypt(){

        String textToEncrypt = sc.nextLine();
        StringBuffer encryptedText = new StringBuffer();
        for(int i = 0; i < textToEncrypt.length(); i++) {
            encryptedText.append(encryptedMap.get(textToEncrypt.charAt(i)));
        }
        System.out.println("Your encrypted text is: " + encryptedText);
    }
    private void decrypt(){
        String textToDecrypt = sc.nextLine();
        StringBuffer encryptedText = new StringBuffer();
        for(int i = 0; i < textToDecrypt.length(); i++) {
            encryptedText.append(decryptedMap.get(textToDecrypt.charAt(i)));
        }
        System.out.println("Your encrypted text is: " + encryptedText);
    }
    private void quit(){
        System.out.println("Bye Bruh!");
        System.exit(0);
    }
}
