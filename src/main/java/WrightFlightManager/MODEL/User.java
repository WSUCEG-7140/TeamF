package WrightFlightManager.MODEL;

/**
 * @class User
 * @brief This class represents a user with various personal information.
 * <p>
 * The User class encapsulates information about a user, including their username,
 * password hash and salt, role, first name, last name, street address, city, state,
 * zipcode, phone number, and email address. Objects of this class can be used to store
 * and retrieve user-related information in the WrightFlightManager application.
 */
public class User {
    private final String username;
    private String passwordHash;
    private String passwordSalt;
    private Role userRole;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipcode;
    private String phoneNumber;
    private String emailAddress;

    /**
     * The User constructor creates a new User object and requires all parameters
     * (cannot build a User object with a non-parameterized constructor).
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param username      A String representing the user's username.
     * @param passwordHash  A String representing the hash value for the user's password.
     * @param passwordSalt  A String representing the salt needed to hash the user's password.
     * @param userRole      A Role object representing the user's role.
     * @param firstName     A String representing the user's first name.
     * @param lastName      A String representing the user's last name.
     * @param streetAddress A String representing the user's street address.
     * @param city          A String representing the user's city.
     * @param state         A String representing the user's state.
     * @param zipcode       A String representing the user's zipcode.
     * @param phoneNumber   A String representing the user's phone number.
     * @param emailAddress  A String representing the user's email address.
     */
    public User(String username, String passwordHash, String passwordSalt, Role userRole, String firstName, String lastName, String streetAddress, String city, String state, String zipcode, String phoneNumber, String emailAddress) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.userRole = userRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * @brief Retrieves the user's username.
     * <p>
     * The getUsername method takes no parameters and returns the user's username.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @brief Retrieves the user's password hash.
     * <p>
     * The getPasswordHash method takes no parameters and returns the user's password hash.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the hash value for the user's password.
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * @brief Sets the user's password hash.
     * <p>
     * The setPasswordHash method takes a String as a parameter to update the user's password hash.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param passwordHash A String representing a new password's hash value.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * @brief Retrieves the user's password salt.
     * <p>
     * The getPasswordSalt method takes no parameters and returns the user's password salt.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the salt needed to hash the user's password.
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * @brief Sets the user's password salt.
     * <p>
     * The setPasswordSalt method takes a String as a parameter to update the user's password salt.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param passwordSalt A String representing a new password's salt value.
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    /**
     * @brief Retrieves the user's role.
     * <p>
     * The getUserRole method takes no parameters and returns the user's role as a Role object.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A Role object representing the user's role.
     */
    public Role getUserRole() {
        return userRole;
    }

    /**
     * @brief Sets the user's role.
     * <p>
     * The setUserRole method takes a Role object as a parameter to update the user's role.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param userRole A Role object representing the user's new role.
     */
    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    /**
     * @brief Retrieves the user's first name.
     * <p>
     * The getFirstName method takes no parameters and returns the user's first name.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @brief Sets the user's first name.
     * <p>
     * The setFirstName method takes a String as a parameter to update the user's first name.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param firstName A String representing the user's new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @brief Retrieves the user's last name.
     * <p>
     * The getLastName method takes no parameters and returns the user's last name.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @brief Sets the user's last name.
     * <p>
     * The setLastName method takes a String as a parameter to update the user's last name.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param lastName A String representing the user's new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @brief Retrieves the user's full address.
     * <p>
     * The getFullAddress method takes no parameters and returns the user's full mailing address,
     * formatted as a single String.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String formatted to represent the user's full mailing address.
     */
    public String getFullAddress() {
        return streetAddress + ", " + city + ", " + state + "  " + zipcode;
    }

    /**
     * @brief Retrieves the user's street address.
     * <p>
     * The getStreetAddress method takes no parameters and returns the user's street address.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the user's street address.
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @brief Sets the user's street address.
     * <p>
     * The setStreetAddress method takes a String as a parameter to update the user's street address.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param streetAddress A String representing the user's new street address.
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * @brief Retrieves the user's city.
     * <p>
     * The getCity method takes no parameters and returns the user's city.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the user's city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @brief Sets the user's city.
     * <p>
     * The setCity method takes a String as a parameter to update the user's city.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param city A String representing the user's new city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @brief Retrieves the user's state.
     * <p>
     * The getState method takes no parameters and returns the user's state.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the user's state.
     */
    public String getState() {
        return state;
    }

    /**
     * @brief Sets the user's state.
     * <p>
     * The setState method takes a String as a parameter to update the user's state.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param state A String representing the user's new state.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @brief Retrieves the user's zipcode.
     * <p>
     * The getZipcode method takes no parameters and returns the user's zipcode.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the user's zipcode.
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @brief Sets the user's zipcode.
     * <p>
     * The setZipcode method takes a String as a parameter to update the user's zipcode.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param zipcode A String representing the user's zipcode.
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @brief Retrieves the user's phone number.
     * <p>
     * The getPhoneNumber method takes no parameters and returns the user's phone number.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the user's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @brief Sets the user's phone number.
     * <p>
     * The setPhoneNumber method takes a String as a parameter to update the user's phone number.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param phoneNumber A String representing the user's new phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @brief Retrieves the user's email address.
     * <p>
     * The getEmailAddress method takes no parameters and returns the user's email address.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @return A String representing the user's email address.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @brief Sets the user's email address.
     * <p>
     * The setEmailAddress method takes a String as a parameter to update the user's email address.
     * Linked Issue: #75 https://github.com/WSUCEG-7140/TeamF/issues/75
     * @param emailAddress A String representing the user's new email address.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
