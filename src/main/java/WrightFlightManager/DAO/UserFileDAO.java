package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.Role;
import WrightFlightManager.MODEL.User;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
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
     * Linked Issue: #47 https://github.com/WSUCEG-7140/TeamF/issues/47
     * @param newUser The User object representing the new user to be added.
     * @return True if the user is successfully added, false otherwise.
     */
    @Override
    public boolean addNewUser(User newUser) {
        boolean addSuccessful = false;
        boolean foundInHashMap = isUserInFile(newUser);

        if (!foundInHashMap) {
            HashMap<String, User> allUsers = getAllUsers();
            allUsers.put(newUser.getUsername(), newUser);
            addSuccessful = writeToUsersFile(allUsers);
        }
        return addSuccessful;
    }

    /**
     * @brief Retrieves all users from the data storage system.
     * <p>
     * This method retrieves all user records from the file-based data storage system and returns them in
     * a HashMap where the key is the user's ID (an integer) and the value is the corresponding User object.
     * Linked Issue: #49 https://github.com/WSUCEG-7140/TeamF/issues/49
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
     * Linked Issue: #50 https://github.com/WSUCEG-7140/TeamF/issues/50
     * @param userToDelete The User object representing the user to be deleted.
     * @return True if the user is successfully deleted, false otherwise.
     */
    @Override
    public boolean deleteUser(User userToDelete) {
        boolean deleteSuccessful = false;
        boolean removedFromHashMap = false;

        HashMap<String, User> allUsers = getAllUsers();

        Iterator<Map.Entry<String, User>> itr = allUsers.entrySet().iterator();

        while(itr.hasNext())
        {
            Map.Entry<String, User> entry = itr.next();
            if (entry.getKey().equals(userToDelete.getUsername())) {
                itr.remove();
                removedFromHashMap = true;
            }
        }
        if (removedFromHashMap) {
            deleteSuccessful = writeToUsersFile(allUsers);
        }


        return deleteSuccessful;
    }

    /**
     * @brief Helper method to check if a User is in the user file.
     * <p>
     * The isUserInFile method is a helper method that takes a user as a parameter to check if a that
     * User is in the user file by searching for a match of the username
     * Linked Issue: #49 https://github.com/WSUCEG-7140/TeamF/issues/49
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

    /**
     * @brief Helper method to write over the file specified by the userFileName field with a new list of users.
     * <p>
     * The writeToUsersFile is a helper method to write over the file specified by the userFileName
     * field with a new list of users
     * Linked Issue: #47 https://github.com/WSUCEG-7140/TeamF/issues/47
     * @param updatedUsers  This represents the new list of roles to be written to the roles file
     * @return              Returns true if successfully written to roles file
     */
    private boolean writeToUsersFile(HashMap<String, User> updatedUsers) {
        boolean writeSuccessful = false;

        try {
            Path filePath = Path.of(userFileName);
            FileWriter fw = new FileWriter(filePath.toFile(), false);
            for (Map.Entry<String, User> entry : updatedUsers.entrySet()) {
                User temp = entry.getValue();
                StringBuilder sb = new StringBuilder();
                sb.append(temp.getUsername()).append("|");
                sb.append(temp.getPasswordHash()).append("|");
                sb.append(temp.getPasswordSalt()).append("|");
                sb.append(temp.getUserRole().getRoleId()).append("|");
                sb.append(temp.getFirstName()).append("|");
                sb.append(temp.getLastName()).append("|");
                sb.append(temp.getStreetAddress()).append("|");
                sb.append(temp.getCity()).append("|");
                sb.append(temp.getState()).append("|");
                sb.append(temp.getZipcode()).append("|");
                sb.append(temp.getPhoneNumber()).append("|");
                sb.append(temp.getEmailAddress()).append("\n");
                fw.write(sb.toString());
            }
            fw.flush();
            fw.close();
            writeSuccessful = true;
        } catch (IOException e) {
            // Ignored
        }

        return writeSuccessful;
    }
}
