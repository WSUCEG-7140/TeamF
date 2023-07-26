package WrightFlightManager.SECURITY;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @interface iAuthorizer
 * @brief This interface defines the contract for password hashing and verification operations.
 *
 * The iAuthorizer interface provides a set of methods for computing hash values for passwords,
 * generating random salts, and verifying if a provided plaintext password matches a stored hash
 * and salt. Classes that implement this interface are expected to provide concrete implementations
 * for these methods, allowing customized password security mechanisms.
 */
public interface iAuthorizer {

    /**
     * @brief Computes a salted/hashed password based on the plaintext password and the salt.
     *
     * This method takes a plaintext password and a salt as input and returns a salted/hashed password.
     * The salt is used as an additional input to a one-way function that hashes the password.
     *
     * @param plaintextPassword The password that the user entered.
     * @param salt The salt, a random string of characters, used as an additional input to a
     *             one-way function that hashes the password.
     * @return A hash of the password and salt.
     */
    String computeHash(String plaintextPassword, String salt);

    /**
     * @brief Generates a random salt as an array of random integers and casts it to a String.
     *
     * This method generates a random salt to be used in password hashing. The salt is typically a
     * random string of characters that adds randomness to the hash, making it more secure against
     * various attacks.
     *
     * @note The specific algorithm and provider used for salt generation may depend on the implementation.
     * @return The random salt values as a String.
     * @throws NoSuchAlgorithmException Occurs if the salt generation algorithm is missing.
     * @throws NoSuchProviderException Occurs if the algorithm provider is missing.
     */
    String createSalt() throws NoSuchAlgorithmException, NoSuchProviderException;

    /**
     * @brief Verifies if the provided plaintext password matches the stored hash and salt.
     *
     * This method takes a stored hash, a stored salt, and a user-provided plaintext password as input.
     * It computes the hash for the provided password using the stored salt and then compares it with the
     * stored hash to determine if they match.
     *
     * @param hash The hash stored in a local file or database.
     * @param salt The salt stored in a local file or database.
     * @param plaintextPassword The password provided by a user.
     * @return A boolean value representing if the password's hash matches the hash for the stored password.
     */
    boolean verifyHashMatch(String hash, String salt, String plaintextPassword);
}
