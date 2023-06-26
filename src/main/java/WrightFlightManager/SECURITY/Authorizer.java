package WrightFlightManager.SECURITY;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Authorizer implements iAuthorizer {

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
        return "TODO";
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
        return null;
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
        return false;
    }
}
