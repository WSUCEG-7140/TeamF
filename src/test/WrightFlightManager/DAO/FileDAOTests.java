package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.Flight;
import WrightFlightManager.MODEL.Role;
import WrightFlightManager.MODEL.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FileDAOTests {

    iFlightDAO defaultFlightDAO = new FlightFileDAO();
    iFlightDAO flightDAO = new
            FlightFileDAO("src/main/java/WrightFlightManager/FILES/_Flights_TEST.psv");
    iFlightDAO errorFlightDAO = new
            FlightFileDAO("BADFILEPATH/BADFILE.psv");

    iRoleDAO defaultRoleDAO = new RoleFileDAO();
    iRoleDAO roleDAO = new
            RoleFileDAO("src/main/java/WrightFlightManager/FILES/_Roles_TEST.psv");
    iRoleDAO errorRoleDAO = new RoleFileDAO("BADFILEPATH/BADFILE.psv");

    iUserDAO defaultUserDAO = new UserFileDAO();
    iUserDAO userDAO = new
            UserFileDAO("src/main/java/WrightFlightManager/FILES/_Users_TEST.psv");
    iUserDAO errorUserDAO = new UserFileDAO("BADFILEPATH/BADFILE.psv");

    @Test
    void testIOExceptionThrown() throws IOException {
        iFlightDAO exceptionDAO = new
                FlightFileDAO("BADFILEPATH/BADFILE.psv");
    }

    @Test
    void addNewFlight() {
        Flight newFlight = new Flight(
                "0000",
                "XXX",
                "ZZZ",
                "S550",
                new Date(123, 7, 13, 22, 10, 17),
                new Date((2023 - 1900), 7, 14, 0, 10, 17),
                new Date(123, 7, 13, 17, 30, 17),
                new Date(123, 7, 13, 19, 50, 00),
                "A4",
                "B2",
                2,
                4
        );

        assertTrue(flightDAO.addNewFlight(newFlight));
    }

    @Test
    void getAllFlights() {
        HashMap<String, Flight> defaultFlights =
                defaultFlightDAO.getAllFlights();
        HashMap<String, Flight> allFlights = flightDAO.getAllFlights();
        HashMap<String, Flight> noFlights =
                errorFlightDAO.getAllFlights();
        assertTrue(defaultFlights.size() > 0);
        assertTrue(allFlights.size() > 0);
        assertNotNull(noFlights);
        assertEquals(0, noFlights.size());
    }

    @Test
    void updateFlight() {
        Flight updatedFlight = new Flight(
                "0000",
                "YYY",
                "WWW",
                "S550",
                new Date(123, 7, 13, 22, 10, 17),
                new Date((2023 - 1900), 7, 14, 0, 10, 17),
                new Date(123, 7, 13, 17, 30, 17),
                new Date(123, 7, 13, 19, 50, 00),
                "A4",
                "B2",
                2,
                4
        );
        Flight fakeFlight = new Flight(
                "XXXX",
                "YYY",
                "WWW",
                "S550",
                new Date(123, 7, 13, 22, 10, 17),
                new Date((2023 - 1900), 7, 14, 0, 10, 17),
                new Date(123, 7, 13, 17, 30, 17),
                new Date(123, 7, 13, 19, 50, 00),
                "A4",
                "B2",
                2,
                4
        );
        assertTrue(flightDAO.updateFlight(updatedFlight));
        assertFalse(flightDAO.updateFlight(fakeFlight));
    }

    @Test
    void deleteFlight() {
        Flight flightToDelete = new Flight(
                "0000",
                "YYY",
                "WWW",
                "S550",
                new Date(123, 7, 13, 22, 10, 17),
                new Date((2023 - 1900), 7, 14, 0, 10, 17),
                new Date(123, 7, 13, 17, 30, 17),
                new Date(123, 7, 13, 19, 50, 00),
                "A4",
                "B2",
                2,
                4
        );
        Flight flightToDelete2 = new Flight(
                "0000",
                "YYY",
                "WWW",
                "S550",
                new Date(123, 7, 13, 22, 10, 17),
                new Date((2023 - 1900), 7, 14, 0, 10, 17),
                new Date(123, 7, 13, 17, 30, 17),
                new Date(123, 7, 13, 19, 50, 00),
                "A4",
                "B2",
                2,
                4
        );
        assertTrue(flightDAO.deleteFlight(flightToDelete));
        assertFalse(flightDAO.deleteFlight(flightToDelete2));
    }

    @Test
    void addNewUser() {
        User newUser = new User(
                "testuser",
                "asdf",
                "asdf",
                new Role(1, "Passenger"),
                "test",
                "user",
                "123 NOWHERE ROAD",
                "Columbus",
                "Ohio",
                "12345",
                "555-555-5555",
                "email@address.com");
        assertTrue(userDAO.addNewUser(newUser));
        assertFalse(userDAO.addNewUser(newUser));
    }
    @Test
    void getAllUsers() {
        HashMap<String, User> defaultUsers = defaultUserDAO.getAllUsers();
        HashMap<String, User> allUsers = userDAO.getAllUsers();
        HashMap<String, User> noUsers = errorUserDAO.getAllUsers();
        assertTrue(defaultUsers.size() > 0);
        assertTrue(allUsers.size() > 0);
        assertNotNull(noUsers);
        assertEquals(0, noUsers.size());
    }

    @Test
    void updateUser() {
        User updatedUser = new User(
                "testuser",
                "zzzz",
                "xxxx",
                new Role(1, "Passenger"),
                "test",
                "user",
                "123 NOWHERE ROAD",
                "Columbus",
                "Ohio",
                "12345",
                "555-555-5555",
                "email@address.com");
        User fakeUser = new User(
                "batman",
                "zzzz",
                "xxxx",
                new Role(1, "Passenger"),
                "test",
                "user",
                "123 NOWHERE ROAD",
                "Columbus",
                "Ohio",
                "12345",
                "555-555-5555",
                "email@address.com");
        assertTrue(userDAO.updateUser(updatedUser));
        assertFalse(userDAO.updateUser(fakeUser));
    }

    @Test
    void deleteUser() {
        User userToDelete = new User(
                "testuser",
                "asdf",
                "asdf",
                new Role(1, "Passenger"),
                "test",
                "user",
                "123 NOWHERE ROAD",
                "Columbus",
                "Ohio",
                "12345",
                "555-555-5555",
                "email@address.com");
        User userToDelete2 = new User(
                "testuser",
                "asdf",
                "asdf",
                new Role(1, "Passenger"),
                "test",
                "user",
                "123 NOWHERE ROAD",
                "Columbus",
                "Ohio",
                "12345",
                "555-555-5555",
                "email@address.com");
        assertTrue(userDAO.deleteUser((userToDelete)));
        assertFalse(userDAO.deleteUser(userToDelete2));
    }

    @Test
    void addNewRole() {
        Role newRole = new Role(99, "TEST ROLE");
        Role newRole2 = new Role(98, "TEST ROLE");
        Role newRole3 = new Role(99, "OTHER ROLE");
        Role newRole4 = new Role(77, "test role");
        assertTrue(roleDAO.addNewRole(newRole));
        assertFalse(roleDAO.addNewRole(newRole));
        assertFalse(roleDAO.addNewRole(newRole2));
        assertFalse(roleDAO.addNewRole(newRole3));
        assertTrue(roleDAO.addNewRole(newRole4));
    }

    @Test
    void getAllRoles() {
        HashMap<Integer, Role> defaultRoles =
                defaultRoleDAO.getAllRoles();
        HashMap<Integer, Role> allRoles = roleDAO.getAllRoles();
        HashMap<Integer, Role> noRoles = errorRoleDAO.getAllRoles();
        assertTrue(defaultRoles.size() > 0);
        assertTrue(allRoles.size() > 0);
        assertNotNull(noRoles);
        assertEquals(0, noRoles.size());
    }

    @Test
    void updateRole() {
        Role updatedRole = new Role(99, "MODIFIED TEST ROLE");
        assertTrue(roleDAO.updateRole(updatedRole));
        Role updatedRole2 = new Role(88, "MODIFIED TEST ROLE");
        assertTrue(roleDAO.updateRole(updatedRole2));
    }

    @Test
    void deleteRole() {
        Role roleToDelete = new Role(88, "MODIFIED TEST ROLE");
        Role roleToDelete2 = new Role(77, "test role");
        Role roleToDelete3 = new Role(77, "test role");
        assertTrue(roleDAO.deleteRole(roleToDelete));
        assertTrue(roleDAO.deleteRole(roleToDelete2));
        assertFalse(roleDAO.deleteRole(roleToDelete3));
    }
}
