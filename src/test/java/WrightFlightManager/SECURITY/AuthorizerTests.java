package WrightFlightManager.SECURITY;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizerTests {

    @org.junit.jupiter.api.Test
    void computeHash() {

        // Dependency injected for instance
        iAuthorizer auth = new Authorizer();

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

        // Computed values
        String correctHash = auth.computeHash(correctPassword, checkSalt);
        String incorrectSaltHash = auth.computeHash(correctPassword, incorrectSalt);
        String incorrectHash1 = auth.computeHash(incorrectPassword1, checkSalt);
        String incorrectHash2 = auth.computeHash(incorrectPassword2, checkSalt);
        String incorrectHash3 = auth.computeHash(incorrectPassword3, checkSalt);
        String incorrectHash4 = auth.computeHash(incorrectPassword4, checkSalt);

        // Assertions
        assertNotNull(correctHash);
        assertNotNull(incorrectSaltHash);
        assertNotNull(incorrectHash1);
        assertNotNull(incorrectHash2);
        assertNotNull(incorrectHash3);
        assertNotNull(incorrectHash4);
        assertEquals(checkHash, correctHash);
        assertNotEquals(checkHash, incorrectSaltHash);
        assertNotEquals(checkHash, incorrectHash1);
        assertNotEquals(checkHash, incorrectHash2);
        assertNotEquals(checkHash, incorrectHash3);
        assertNotEquals(checkHash, incorrectHash4);
    }

    @org.junit.jupiter.api.Test
    void createSalt() throws NoSuchAlgorithmException, NoSuchProviderException {

        // Dependency injected for instance
        iAuthorizer auth = new Authorizer();

        // Assertions
        assertNotNull(auth.createSalt());
        assertTrue(auth.createSalt().length() > 0);
    }

    @org.junit.jupiter.api.Test
    void verifyHashMatch() {

        // Dependency injected for instance
        iAuthorizer auth = new Authorizer();

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
    }
}