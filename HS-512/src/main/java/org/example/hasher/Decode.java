package org.example.hasher;

public class Decode {
    public static String simulateDecode(String hash, String[] dictionary) {
        for (String candidate : dictionary) {
            String candidateHash = Hasher.hashSHA512(candidate);
            if (candidateHash.equals(hash)) {
                return candidate;
            }
        }
        return null;
    }
}
