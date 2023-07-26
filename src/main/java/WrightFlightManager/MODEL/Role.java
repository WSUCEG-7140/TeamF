package WrightFlightManager.MODEL;

/**
 * @class Role
 * @brief This class represents a role with its ID number and title.
 * <p>
 * The Role class encapsulates information about a role, including its unique ID number
 * and its title. Objects of this class can be used to store and retrieve role-related
 * information in the WrightFlightManager application.
 */
public class Role {
    private int roleId;
    private String roleTitle;

    /**
     * The Role constructor creates a new Role object and requires both parameters
     * (cannot build a Role object with a non-parameterized constructor).
     * Linked Issue: #74 https://github.com/WSUCEG-7140/TeamF/issues/74
     * @param roleId    An integer identifying the role.
     * @param roleTitle A String representing the name of the role.
     */
    public Role(int roleId, String roleTitle) {
        this.roleId = roleId;
        this.roleTitle = roleTitle;
    }

    /**
     * @brief Retrieves the ID number of the role.
     * <p>
     * The getRoleId method takes no parameters and returns the role's ID number.
     * Linked Issue: #74 https://github.com/WSUCEG-7140/TeamF/issues/74
     * @return An integer representing the role's ID number.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * @brief Sets the ID number of the role.
     * <p>
     * The setRoleId method takes an integer as a parameter to update a roleId.
     * Linked Issue: #74 https://github.com/WSUCEG-7140/TeamF/issues/74
     * @param roleId An integer to change the role's ID number to.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * @brief Retrieves the title of the role.
     * <p>
     * The getRoleTitle method takes no parameters and returns the role's title.
     * Linked Issue: #74 https://github.com/WSUCEG-7140/TeamF/issues/74
     * @return A String representing the name of the role.
     */
    public String getRoleTitle() {
        return roleTitle;
    }

    /**
     * @brief Sets the title of the role.
     * <p>
     * The setRoleTitle method takes a String as a parameter to update the title of a role.
     * Linked Issue: #74 https://github.com/WSUCEG-7140/TeamF/issues/74
     * @param roleTitle A String to change the role's title to.
     */
    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }
}
