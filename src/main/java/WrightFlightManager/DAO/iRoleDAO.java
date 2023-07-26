package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.Role;

import java.util.HashMap;

/**
 * @interface iRoleDAO
 * @brief This interface defines the contract for managing roles using a data access object (DAO) approach.
 *
 * The iRoleDAO interface provides a set of methods for performing CRUD (Create, Read, Update, Delete) operations
 * related to the "Role" entity. Classes that implement this interface are expected to provide concrete
 * implementations for these methods, allowing interaction with a data storage system for managing roles.
 */
public interface iRoleDAO {

    /**
     * @brief Adds a new role to the data storage.
     *
     * This method adds a new role to the data storage (e.g., a file or database) if the role ID and role title
     * are not already present in the data storage.
     *
     * @param newRole The Role object representing the new role to be added.
     * @return true if the role was successfully added, false otherwise.
     */
    boolean addNewRole(Role newRole);

    /**
     * @brief Retrieves all roles from the data storage.
     *
     * This method retrieves all roles from the data storage and returns them as a HashMap, where the keys
     * are role IDs (Integer) and the values are Role objects.
     *
     * @return A HashMap containing all roles, where the keys are role IDs and the values are Role objects.
     */
    HashMap<Integer, Role> getAllRoles();

    /**
     * @brief Updates an existing role in the data storage.
     *
     * This method updates an existing role in the data storage based on the information provided in the
     * updatedRole parameter. The update is performed based on the role's unique identifier (ID).
     *
     * @param updatedRole The Role object representing the updated role information.
     * @return true if the role was successfully updated, false otherwise.
     */
    boolean updateRole(Role updatedRole);

    /**
     * @brief Deletes a role from the data storage.
     *
     * This method deletes the specified role from the data storage based on the information provided
     * in the roleToDelete parameter. The deletion is performed based on the role's unique identifier (ID).
     *
     * @param roleToDelete The Role object representing the role to be deleted.
     * @return true if the role was successfully deleted, false otherwise.
     */
    boolean deleteRole(Role roleToDelete);
}
