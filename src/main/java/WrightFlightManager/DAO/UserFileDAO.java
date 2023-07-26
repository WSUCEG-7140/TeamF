package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.User;

import java.util.HashMap;

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
     * @return A HashMap<Integer, User> containing all user records in the data storage system.
     */
    @Override
    public HashMap<Integer, User> getAllUsers() {
        return null;
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
}
