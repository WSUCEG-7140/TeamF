package WrightFlightManager.SECURITY;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface iAuthorizer {

    String computeHash(String plaintextPassword, String salt);
    String createSalt() throws NoSuchAlgorithmException, NoSuchProviderException;
    boolean verifyHashMatch(String hash, String salt, String plaintextPassword);
}
