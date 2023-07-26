package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.Role;
import WrightFlightManager.MODEL.User;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @class UserFileDAO
 * @brief Handles data access operations related to the User model using a file-based data storage system.
 * <p>
 * The UserFileDAO class implements the iUserDAO interface to manage data related to the "User" entity
 * using a file-based storage system. It represents the Data Access Object (DAO) pattern in the context
 * of managing roles.
 * <p>
 * For more information about the Data Access Object (DAO) pattern, please refer to
 * the Wikipedia page:
 * @ref https://en.wikipedia.org/wiki/Data_access_object
 */
public class UserFileDAO implements iUserDAO {

    /**
     * @brief Name of the file storing user data.
     */
    private final String userFileName;

    /**
     * @brief Default constructor for UserFileDAO.
     * <p>
     * This constructor sets the default path for the file storing user data.
     * The default path is "src/main/java/WrightFlightManager/FILES/Users.psv".
     * Linked Issue: #9 https://github.com/WSUCEG-7140/TeamF/issues/9
     */
    public UserFileDAO() {
        userFileName = "src/main/java/WrightFlightManager/FILES/Users.psv";
    }

    /**
     * @brief Parameterized constructor for UserFileDAO.
     * <p>
     * This constructor allows specifying a custom file path for storing user data.
     * Linked Issue: #9 https://github.com/WSUCEG-7140/TeamF/issues/9
     * @param userFileName The custom file path for storing user data.
     */
    public UserFileDAO(String userFileName) {
        this.userFileName = userFileName;
    }

    /**
     * @brief Adds a new user to the data storage system.
     * <p>
     * This method is responsible for adding a new user to the data storage system.
     * The user information is obtained from the provided User object.
     * @param newUser The User object representing the new user to be added.
     * @return True if the user is successfully added, false otherwise.
     */
    @Override
    public boolean addNewUser(User newUser) {
        return false;
    }

    /**
     * @brief Retrieves all users from the data storage system.
     * <p>
     * This method retrieves all user records from the file-based data storage system and returns them in
     * a HashMap where the key is the user's ID (an integer) and the value is the corresponding User object.
     * Linked Issue: #69 https://github.com/WSUCEG-7140/TeamF/issues/49
     * @return A HashMap<Integer, User> containing all user records in the data storage system.
     */
    @Override
    public HashMap<String, User> getAllUsers() {
        HashMap<String, User> allUsers = new HashMap<>();

        try {
            RoleFileDAO roleDAO = new RoleFileDAO();
            HashMap<Integer, Role> allRoles = roleDAO.getAllRoles();
            Path userFilePath = Path.of(userFileName);
            Scanner fileRead = new Scanner(userFilePath);
            while (fileRead.hasNextLine()) {
                String line = fileRead.nextLine();
                String[] splitLine = line.split("\\|");
                if (splitLine.length == 12) {
                    String username = splitLine[0];
                    String passwordHash = splitLine[1];
                    String passwordSalt = splitLine[2];
                    Role userRole = null;
                    for(Map.Entry<Integer, Role> entry : allRoles.entrySet()) {
                        if (entry.getKey() == Integer.parseInt(splitLine[3])) {
                            userRole = entry.getValue();
                            break;
                        }
                    }
                    String firstName = splitLine[4];
                    String lastName = splitLine[5];
                    String streetAddress = splitLine[6];
                    String city = splitLine[7];
                    String state = splitLine[8];
                    String zipcode = splitLine[9];
                    String phoneNumber = splitLine[10];
                    String emailAddress = splitLine[11];
                    allUsers.put(username, new User(
                            username,
                            passwordHash,
                            passwordSalt,
                            userRole,
                            firstName,
                            lastName,
                            streetAddress,
                            city,
                            state,
                            zipcode,
                            phoneNumber,
                            emailAddress));
                }
            }
            fileRead.close();
        } catch (IOException e) {
            // Ignore
        }
        return allUsers;
    }

    /**
     * @brief Updates an existing user's information in the data storage system.
     * <p>
     * This method is responsible for updating an existing user's information in the data storage system.
     * The new user information is obtained from the provided User object, which should have the same user ID
     * as the one to be updated.
     * @param updatedUser The User object representing the updated user information.
     * @return True if the user information is successfully updated, false otherwise.
     */
    @Override
    public boolean updateUser(User updatedUser) {
        return false;
    }

    /**
     * @brief Deletes a user from the data storage system.
     * <p>
     * This method is used to delete a user from the file-based data storage system. The user to be deleted is
     * identified by the provided User object, which should have the same user ID as the one to be deleted.
     * @param userToDelete The User object representing the user to be deleted.
     * @return True if the user is successfully deleted, false otherwise.
     */
    @Override
    public boolean deleteUser(User userToDelete) {
        return false;
    }

    /**
     * @brief Helper method to check if a User is in the user file.
     * <p>
     * The isUserInFile method is a helper method that takes a user as a parameter to check if a that
     * User is in the user file by searching for a match of the username
     * Linked Issue: #69 https://github.com/WSUCEG-7140/TeamF/issues/49
     * @param checkUser This represents the User being searched for within the file
     * @return          Returns true if the user was found in the file
     */
    private boolean isUserInFile(User checkUser) {

        boolean userFound = false;
        HashMap<String, User> allUsers = getAllUsers();

        for(Map.Entry<String, User> entry : allUsers.entrySet()) {
            if (entry.getKey().equals(checkUser.getUsername())) {
                userFound = true;
                break;
            }
        }

        return userFound;
    }
}
