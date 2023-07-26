package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.User;

import java.util.HashMap;

/**
 * @interface iUserDAO
 * @brief This interface defines the contract for managing users using a data access object (DAO) approach.
 *
 * The iUserDAO interface provides a set of methods for performing CRUD (Create, Read, Update, Delete) operations
 * related to the "User" entity. Classes that implement this interface are expected to provide concrete
 * implementations for these methods, allowing interaction with a data storage system for managing users.
 */
public interface iUserDAO {

    /**
     * @brief Adds a new user to the data storage system.
     *
     * This method is responsible for adding a new user to the data storage system.
     * The user information is obtained from the provided User object.
     *
     * @param newUser The User object representing the new user to be added.
     * @return True if the user is successfully added, false otherwise.
     */
    boolean addNewUser(User newUser);

    /**
     * @brief Retrieves all users from the data storage system.
     *
     * This method retrieves all user records from the data storage system and returns them in
     * a HashMap where the key is the user's ID (an integer) and the value is the corresponding User object.
     *
     * @return A HashMap<Integer, User> containing all user records in the data storage system.
     */
    HashMap<Integer, User> getAllUsers();

    /**
     * @brief Updates an existing user's information in the data storage system.
     *
     * This method is responsible for updating an existing user's information in the data storage system.
     * The new user information is obtained from the provided User object, which should have the same user ID
     * as the one to be updated.
     *
     * @param updatedUser The User object representing the updated user information.
     * @return True if the user information is successfully updated, false otherwise.
     */
    boolean updateUser(User updatedUser);

    /**
     * @brief Deletes a user from the data storage system.
     *
     * This method is used to delete a user from the data storage system. The user to be deleted is
     * identified by the provided User object, which should have the same user ID as the one to be deleted.
     *
     * @param userToDelete The User object representing the user to be deleted.
     * @return True if the user is successfully deleted, false otherwise.
     */
    boolean deleteUser(User userToDelete);
}
