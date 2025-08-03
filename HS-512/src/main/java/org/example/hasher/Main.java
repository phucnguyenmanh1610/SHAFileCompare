package org.example.hasher;



public class Main {
    public static void main(String[] args) {
        int length = 128;

        // 1. Generate random string
        String original = Hasher.generateRandomHexString(length);
        System.out.println("🔑 Original string: " + original);

        // 2. Hash with SHA-512 and measure time
        long startHash = System.nanoTime();
        String hashed = Hasher.hashSHA512(original);
        long endHash = System.nanoTime();

        System.out.println("🔒 SHA-512 hash: " + hashed);
        System.out.printf("⏱️ Hashing time: %.6f ms%n", (endHash - startHash) / 1e6);

        // 3. Simulate decoding with sample dictionary
        String[] dictionary = {
                "123456", "abcdef", "test", original, "openai", "hello"
        };

        long startDecode = System.nanoTime();
        String match = Decode.simulateDecode(hashed, dictionary);
        long endDecode = System.nanoTime();

        if (match != null) {
            System.out.println("🔍 Match found in dictionary: " + match);
        } else {
            System.out.println("❌ No match found in dictionary.");
        }

        System.out.printf("⏱️ Decode simulation time: %.6f ms%n", (endDecode - startDecode) / 1e6);
    }
}
