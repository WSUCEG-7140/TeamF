package WrightFlightManager.SECURITY;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Authorizer implements iAuthorizer {

    public String computeHash(String plaintextPassword, String salt) {
        return "TODO";
    }
    public String createSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        return "TODO";
    }
    public boolean verifyHashMatch(String hash, String salt, String plaintextPassword) {
        return false;
    }
}
