package MODEL;

import WrightFlightManager.MODEL.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTests {

    private final int initRoleId = 1;
    private final String initRoleTitle = "Passenger";

    Role testRole = new Role(initRoleId, initRoleTitle);

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
}