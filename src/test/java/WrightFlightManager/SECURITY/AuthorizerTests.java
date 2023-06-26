package WrightFlightManager.SECURITY;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizerTests {
    
    @org.junit.jupiter.api.Test
    void computeHash() {

        // Dependency injected for instance
        iAuthorizer auth = new Authorizer("SHA-512");
        iAuthorizer badAuth = new Authorizer("WRONG");

        // Correct values provided
        String checkHash = "c2d4055d872781c388c9c295ecc97796ab8214fe33e14cf2df7e285edbd2734589a65e483289d73b0d8bdb0db43e1b7fbd94e35ce32a8301db536d34d5b94f5d";
        String checkSalt = "[-38, 58, 28, -122, 56, 83, 90, -92, -40, 37, 107, 123, 103, -125, 50, 35]";
        String correctPassword = "flowerpot";

        // Incorrect values provided
        String incorrectSalt = "[-38, 58, 28, -122, 56, 83, 90, -92, -40, 37, 107, 123, 103, -125, 50, 34]";
        String incorrectPassword1 = "sandwiches";
        String incorrectPassword2 = "flowerpo";
        String incorrectPassword3 = "flowerpot ";
        String incorrectPassword4 = "";

        // Assertions
        assertNotNull(auth.computeHash(correctPassword, checkSalt));
        assertNotNull(auth.computeHash(correctPassword, incorrectSalt));
        assertNotNull(auth.computeHash(incorrectPassword1, checkSalt));
        assertNotNull(auth.computeHash(incorrectPassword2, checkSalt));
        assertNotNull(auth.computeHash(incorrectPassword3, checkSalt));
        assertNotNull(auth.computeHash(incorrectPassword4, checkSalt));
        assertEquals(checkHash, auth.computeHash(correctPassword, checkSalt));
        assertNotEquals(checkHash, auth.computeHash(correctPassword, incorrectSalt));
        assertNotEquals(checkHash, auth.computeHash(incorrectPassword1, checkSalt));
        assertNotEquals(checkHash, auth.computeHash(incorrectPassword2, checkSalt));
        assertNotEquals(checkHash, auth.computeHash(incorrectPassword3, checkSalt));
        assertNotEquals(checkHash, auth.computeHash(incorrectPassword4, checkSalt));
        assertDoesNotThrow(() -> {
            badAuth.computeHash(correctPassword, checkSalt);
        });
    }

    @org.junit.jupiter.api.Test
    void createSalt() throws NoSuchAlgorithmException, NoSuchProviderException {

        // Dependency injected for instance
        iAuthorizer auth = new Authorizer("SHA-512");

        // Assertions
        assertNotNull(auth.createSalt());
        assertTrue(auth.createSalt().length() > 0);
        assertDoesNotThrow(() -> {
            auth.createSalt();
        });
    }

    @org.junit.jupiter.api.Test
    void verifyHashMatch() {

        // Dependency injected for instance
        iAuthorizer auth = new Authorizer("SHA-512");

        // Correct values provided
        String checkHash = "c2d4055d872781c388c9c295ecc97796ab8214fe33e14cf2df7e285edbd2734589a65e483289d73b0d8bdb0db43e1b7fbd94e35ce32a8301db536d34d5b94f5d";
        String checkSalt = "[-38, 58, 28, -122, 56, 83, 90, -92, -40, 37, 107, 123, 103, -125, 50, 35]";
        String correctPassword = "flowerpot";

        // Incorrect values provided
        String incorrectPassword1 = "";
        String incorrectPassword2 = " ";
        String incorrectPassword3 = "flowerpo ";
        String incorrectPassword4 = "flowerpots";
        String incorrectPassword5 = "flowerpot ";
        String incorrectPassword6 = "adfkgjhadsflkgj";

        // Assertions
        assertTrue(auth.verifyHashMatch(checkHash, checkSalt, correctPassword));
        assertFalse(auth.verifyHashMatch(checkHash, checkSalt, incorrectPassword1));
        assertFalse(auth.verifyHashMatch(checkHash, checkSalt, incorrectPassword2));
        assertFalse(auth.verifyHashMatch(checkHash, checkSalt, incorrectPassword3));
        assertFalse(auth.verifyHashMatch(checkHash, checkSalt, incorrectPassword4));
        assertFalse(auth.verifyHashMatch(checkHash, checkSalt, incorrectPassword5));
        assertFalse(auth.verifyHashMatch(checkHash, checkSalt, incorrectPassword6));
        assertDoesNotThrow(() -> {
            auth.verifyHashMatch(checkHash, checkSalt, correctPassword);
        });
    }
}