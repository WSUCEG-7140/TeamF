package WrightFlightManager.MODEL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTests {

    private final int initRoleId = 1;
    private final String initRoleTitle = "Passenger";

    Role testRole = new Role(initRoleId, initRoleTitle);

    private final String actualUsername = "DrummerMan";
    private final String initPasswordHash = "d68ba97f98bf28166f2e6ac9ad4d77ba18e04c3b8e32371bf7a026cefb221464cd37912a79d9c5f7bbf805f1360d7e6a4fc4737cf878f66c002141a2ee9e83b3";
    private final String initPasswordSalt = "[64, -34, 114, -77, -9, -38, -48, 53, -54, -69, -11, -11, -102, -116, -25, -15]";
    private final String initFirstName = "Babatunde";
    private final String initLastName = "Olatunji";
    private final String initStreetAddress = "123 Any Street";
    private final String initCity = "New York City";
    private final String initState = "New York";
    private final String initZipCode = "12345";
    private final String initPhoneNumber = "1234567890";
    private final String initEmailAddress = "somebody@website.com";

    User testUser = new User(actualUsername, initPasswordHash, initPasswordSalt, testRole, initFirstName, initLastName, initStreetAddress, initCity, initState, initZipCode, initPhoneNumber, initEmailAddress);

    @Test
    void getUsername() {
        assertEquals(actualUsername, testUser.getUsername());
        assertNotEquals("Drummerman", testUser.getUsername());
        assertNotEquals("drummerman", testUser.getUsername());
        assertNotEquals("DRUMMERMAN", testUser.getUsername());
        assertNotEquals("DrummerMan ", testUser.getUsername());
        assertNotEquals("", testUser.getUsername());
        assertNotEquals(" ", testUser.getUsername());
    }

    @Test
    void getRoleId() {
        assertEquals(1, testRole.getRoleId());
        assertEquals(initRoleId, testRole.getRoleId());
        assertNotEquals(0, testRole.getRoleId());
        assertNotEquals(11, testRole.getRoleId());
    }

    @Test
    void setRoleId() {
        int newRoleId = 2;
        testRole.setRoleId(newRoleId);
        assertEquals(newRoleId, testRole.getRoleId());
        assertNotEquals(initRoleId, testRole.getRoleId());
    }

    @Test
    void getRoleTitle() {
        assertEquals("Passenger", testRole.getRoleTitle());
        assertEquals(initRoleTitle, testRole.getRoleTitle());
        assertNotEquals("Flight Attendant", testRole.getRoleTitle());
        assertNotEquals("Passenge", testRole.getRoleTitle());
        assertNotEquals("Passenger ", testRole.getRoleTitle());
    }

    @Test
    void setRoleTitle() {
        String newRoleTitle = "Flight Attendant";
        testRole.setRoleTitle(newRoleTitle);
        assertEquals(newRoleTitle, testRole.getRoleTitle());
        assertNotEquals(initRoleTitle, testRole.getRoleTitle());
    }

    @Test
    void getPasswordHash() {
        assertEquals(initPasswordHash, testUser.getPasswordHash());
        assertNotEquals("", testUser.getPasswordHash());
        assertNotEquals(" ", testUser.getPasswordHash());
        assertNotEquals("1", testUser.getPasswordHash());
    }

    @Test
    void setPasswordHash() {
        String newPasswordHash = "1234567890";
        testUser.setPasswordHash(newPasswordHash);
        assertEquals(newPasswordHash, testUser.getPasswordHash());
        assertNotEquals(initPasswordHash, testUser.getPasswordHash());
    }

    @Test
    void getPasswordSalt() {
        assertEquals(initPasswordSalt, testUser.getPasswordSalt());
        assertNotEquals("", testUser.getPasswordSalt());
        assertNotEquals(" ", testUser.getPasswordSalt());
        assertNotEquals("1", testUser.getPasswordSalt());
    }

    @Test
    void setPasswordSalt() {
        String newPasswordSalt = "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]";
        testUser.setPasswordSalt(newPasswordSalt);
        assertEquals(newPasswordSalt, testUser.getPasswordSalt());
        assertNotEquals(initPasswordSalt, testUser.getPasswordSalt());
    }

    @Test
    void getUserRole() {
        assertEquals(initRoleId, testUser.getUserRole().getRoleId());
        assertEquals(initRoleTitle, testUser.getUserRole().getRoleTitle());
        assertNotEquals(2, testUser.getUserRole().getRoleId());
        assertNotEquals("Flight Attendant", testUser.getUserRole().getRoleTitle());
    }

    @Test
    void setUserRole() {
        Role newRole = new Role(2, "Flight Attendant");
        testUser.setUserRole(newRole);
        assertEquals(newRole.getRoleId(), testUser.getUserRole().getRoleId());
        assertEquals(newRole.getRoleTitle(), testUser.getUserRole().getRoleTitle());
        assertNotEquals(initRoleId, testUser.getUserRole().getRoleId());
        assertNotEquals(initRoleTitle, testUser.getUserRole().getRoleTitle());
    }

    @Test
    void getFirstName() {
        assertEquals(initFirstName, testUser.getFirstName());
        assertEquals("Babatunde", testUser.getFirstName());
        assertNotEquals("John", testUser.getFirstName());
    }

    @Test
    void setFirstName() {
        String newFirstName = "John";
        testUser.setFirstName(newFirstName);
        assertEquals(newFirstName, testUser.getFirstName());
        assertNotEquals(initFirstName, testUser.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals(initLastName, testUser.getLastName());
        assertEquals("Olatunji", testUser.getLastName());
        assertNotEquals("Doe", testUser.getLastName());
    }

    @Test
    void setLastName() {
        String newLastName = "Doe";
        testUser.setLastName(newLastName);
        assertEquals(newLastName, testUser.getLastName());
        assertNotEquals(initLastName, testUser.getLastName());
    }

    @Test
    void getFullAddress() {
        String initFullAddress = "123 Any Street, New York City, New York  12345";
        String newFullAddress = "789 Far Way, Cincinnati, Ohio  45202";
        assertEquals(initFullAddress, testUser.getFullAddress());
        assertNotEquals(newFullAddress, testUser.getFullAddress());
    }

    @Test
    void getStreetAddress() {
        assertEquals(initStreetAddress, testUser.getStreetAddress());
        assertNotEquals("789 Far Way", testUser.getStreetAddress());
    }

    @Test
    void setStreetAddress() {
        String newStreetAddress = "789 Far Way";
        testUser.setStreetAddress(newStreetAddress);
        assertEquals(newStreetAddress, testUser.getStreetAddress());
        assertNotEquals(initStreetAddress, testUser.getStreetAddress());
    }

    @Test
    void getCity() {
        assertEquals(initCity, testUser.getCity());
        assertNotEquals("Cincinnati", testUser.getCity());
    }

    @Test
    void setCity() {
        String newCity = "Cincinnati";
        testUser.setCity(newCity);
        assertEquals(newCity, testUser.getCity());
        assertNotEquals(initCity, testUser.getCity());
    }

    @Test
    void getState() {
        assertEquals(initState, testUser.getState());
        assertNotEquals("Ohio", testUser.getState());
    }

    @Test
    void setState() {
        String newState = "Ohio";
        testUser.setState(newState);
        assertEquals(newState, testUser.getState());
        assertNotEquals(initState, testUser.getState());
    }

    @Test
    void getZipcode() {
        assertEquals(initZipCode, testUser.getZipcode());
        assertNotEquals("45202", testUser.getZipcode());
    }

    @Test
    void setZipcode() {
        String newZipcode = "45202";
        testUser.setZipcode(newZipcode);
        assertEquals(newZipcode, testUser.getZipcode());
        assertNotEquals(initZipCode, testUser.getZipcode());
    }

    @Test
    void getPhoneNumber() {
        assertEquals(initPhoneNumber, testUser.getPhoneNumber());
        assertNotEquals("0987654321", testUser.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        String newPhoneNumber = "0987654321";
        testUser.setPhoneNumber(newPhoneNumber);
        assertEquals(newPhoneNumber, testUser.getPhoneNumber());
        assertNotEquals(initPhoneNumber, testUser.getPhoneNumber());
    }

    @Test
    void getEmailAddress() {
        assertEquals(initEmailAddress, testUser.getEmailAddress());
        assertNotEquals("person@place.net", testUser.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        String newEmailAddress = "person@place.net";
        testUser.setEmailAddress(newEmailAddress);
        assertEquals(newEmailAddress, testUser.getEmailAddress());
        assertNotEquals(initEmailAddress, testUser.getEmailAddress());
    }
}