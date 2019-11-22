/*

 */
package acad277;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char cipher(char c, int k) {
        // declare some helping constants
        final int alphaLength = 26;
        final char asciiShift = Character.isUpperCase(c) ? 'A' : 'a';
        final int cipherShift = k % alphaLength;

        // shift down to 0..25 for a..z
        char shifted = (char) (c - asciiShift);
        // rotate the letter and handle "wrap-around" for negatives and value >= 26
        shifted = (char) ((shifted + cipherShift + alphaLength) % alphaLength);
        // shift back up to english characters
        return (char) (shifted + asciiShift);
    }

    // Rotate a string k-positions
    public static String cipher(String s, int k) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            sb.append(cipher(s.charAt(i), k));
//        }
//        return sb.toString();
        String[] original = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "y", "x", "z"};
        String[] encrypted =
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String password;
        int shift=0;

        System.out.print("Please enter a word to encrypt: ");
        password = keyboard.next();


        while (shift < 1 || shift > 25) {
            System.out.print("Please enter a key between 1-25: ");
            shift = keyboard.nextInt();
//
//            if (key < 1 || key > 25) {
//                System.out.printf(" The key must be between 1 and 25, you entered %d.\n", key);
//            }
        }




        System.out.println("Password:\t" + password);
        String encryption = cipher(password, shift);
        System.out.println("Encrypted:\t" + encryption);
        System.out.println("Decrypted:\t" + cipher(encryption, -shift));

    }
}