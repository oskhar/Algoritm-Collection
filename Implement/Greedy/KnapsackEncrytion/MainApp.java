package Implement.Greedy.KnapsackEncrytion;

import java.util.Random;

public class MainApp {
    // Function to generate a super-increasing sequence for the public key
    public static int[] generateSuperIncreasingSequence(int n) {
        Random random = new Random();
        int[] sequence = new int[n];
        sequence[0] = random.nextInt(100) + 1;
        for (int i = 1; i < n; i++) {
            sequence[i] = sequence[i - 1] + random.nextInt(10) + 1;
        }
        return sequence;
    }

    // Function to generate the private key from the public key
    public static int[] generatePrivateKey(int[] publicKey, int q, int r) {
        int[] privateKey = new int[publicKey.length];
        for (int i = 0; i < publicKey.length; i++) {
            privateKey[i] = (r * publicKey[i]) % q;
        }
        return privateKey;
    }

    // Function to encrypt the plaintext using the public key
    public static int knapsackEncrypt(String plaintext, int[] publicKey) {
        int encryptedMessage = 0;
        for (int i = 0; i < plaintext.length(); i++) {
            if (plaintext.charAt(i) == '1') {
                encryptedMessage += publicKey[i];
            }
        }
        return encryptedMessage;
    }

    // Function to decrypt the ciphertext using the private key
    public static String knapsackDecrypt(int ciphertext, int[] privateKey, int q) {
        StringBuilder decryptedMessage = new StringBuilder();
        int rInverse = modInverse(3, q); // Modular multiplicative inverse of r
        for (int i = privateKey.length - 1; i >= 0; i--) {
            if ((ciphertext * rInverse) % q >= privateKey[i]) {
                decryptedMessage.insert(0, '1');
                ciphertext -= privateKey[i];
            } else {
                decryptedMessage.insert(0, '0');
            }
        }
        return decryptedMessage.toString();
    }

    // Function to calculate modular multiplicative inverse
    public static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return 1;
    }

    // Example usage
    public static void main(String[] args) {
        int n = 8; // Number of elements in the super-increasing sequence
        int q = 103; // Modulus (should be greater than the sum of the super-increasing sequence)
        int r = 3; // Multiplier for generating private key

        // Generate the public key and private key
        int[] publicKey = generateSuperIncreasingSequence(n);
        int[] privateKey = generatePrivateKey(publicKey, q, r);

        String plaintext = "11111110";
        int ciphertext = knapsackEncrypt(plaintext, publicKey);
        String decryptedMessage = knapsackDecrypt(ciphertext, privateKey, q);

        System.out.println("Original Message: " + plaintext);
        System.out.println("Encrypted Ciphertext: " + ciphertext);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
