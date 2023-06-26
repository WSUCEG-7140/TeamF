package WrightFlightManager.SECURITY;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Authorizer implements iAuthorizer {

    private final String algorithm;

    public Authorizer(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Takes a plain text password and a salt as input, and returns a salted/hashed
     * password as output
     *
     * @param plaintextPassword The password that the user entered.
     * @param salt              The salt is a random string of characters that is
     *                          used as an additional input to a
     *                          one-way function that hashes a password or
     *                          passphrase.
     * @return A hash of the password and salt
     */
    public String computeHash(String plaintextPassword, String salt) {
        String computedHash = null;

        try {

            // Create MessageDigest instance for SHA-512 algorithm
            MessageDigest md = MessageDigest.getInstance(algorithm);

            // Update SHA-512 instance with salt as bytes and get hashed bytes for plaintextPassword
            md.update(salt.getBytes());
            byte[] bytes = md.digest(plaintextPassword.getBytes());

            // Store hashed byte values as chars in a StringBuilder
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16)
                        .substring(1));
            }

            // Set output value to computed hash chars
            computedHash = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            // Ignored
        }

        // Returns hashed value as a String or null if hash failed
        return computedHash;
    }

    /**
     * Generates an array of random integers to serve as salt for a hash function
     * and casts it to a String
     *
     * @return The random salt values
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     */
    public String createSalt() throws NoSuchAlgorithmException, NoSuchProviderException {

        // Call to SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

        // Initialize array for salt
        byte[] salt = new byte[16];

        // Get a random salt and store bytes in salt array
        sr.nextBytes(salt);

        // Return salt array in string format
        return Arrays.toString(salt);
    }

    /**
     * Takes a hash, a salt, and a user-provided plaintext password as input, computes the
     * hash for the provided password using the salt, and returns a boolean value representing
     * whether the saved hash and the generated hash match.
     *
     * @param storedHash        A hash stored in a local file.
     * @param storedSalt        A salt stored in a local file.
     * @param plaintextPassword A password provided by a user.
     * @return
     */
    public boolean verifyHashMatch(String storedHash, String storedSalt, String plaintextPassword) {
        return storedHash.equals(computeHash(plaintextPassword, storedSalt));
    }
}
