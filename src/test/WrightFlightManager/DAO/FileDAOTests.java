package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.Role;
import WrightFlightManager.MODEL.User;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FileDAOTests {

    iRoleDAO defaultRoleDAO = new RoleFileDAO();
    iRoleDAO roleDAO = new RoleFileDAO("src/main/java/WrightFlightManager/FILES/_Roles_TEST.psv");
    iRoleDAO errorRoleDAO = new RoleFileDAO("BADFILEPATH/BADFILE.psv");

    iUserDAO defaultUserDAO = new UserFileDAO();
    iUserDAO userDAO = new UserFileDAO("src/main/java/WrightFlightManager/FILES/_Users_TEST.psv");
    iUserDAO errorUserDAO = new UserFileDAO("BADFILEPATH/BADFILE.psv");

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
        assertTrue(defaultUsers.size() > 0);
        assertTrue(allUsers.size() > 0);
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
        HashMap<Integer, Role> defaultRoles = defaultRoleDAO.getAllRoles();
        HashMap<Integer, Role> allRoles = roleDAO.getAllRoles();
        assertTrue(defaultRoles.size() > 0);
        assertTrue(allRoles.size() > 0);
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