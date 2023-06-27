package WrightFlightManager.MODEL;

public class Role {

    private int roleId;
    private String roleTitle;

    /**
     * The Role constructor creates a new Role object and requires both parameters
     * (cannot build a Role object with a non-parameterized constructor)
     * @param roleId    An integer identifying the role
     * @param roleTitle A String representing the name of the role
     */
    public Role(int roleId, String roleTitle) {
        this.roleId = roleId;
        this.roleTitle = roleTitle;
    }

    /**
     * The getRoleId method takes no parameters and returns the role's ID number
     * @return  An integer representing the role's ID number
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * The setRoleId method takes an integer as a parameter to update a roleId
     * @param roleId    An integer to change the role's ID number to
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * The getRollTitle method takes no parameters and returns the roll's title
     * @return  A String representing the name of the role
     */
    public String getRoleTitle() {
        return roleTitle;
    }

    /**
     * The setRollTitle method takes a String as a parameter to update the title of a roll
     * @param roleTitle A String to change the role's title to
     */
    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }
}
