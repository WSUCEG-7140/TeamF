package WrightFlightManager.MODEL;

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
     * (cannot build a User object with a non-parameterized constructor)
     * @param username      A String representing the user's username
     * @param passwordHash  A String representing the hash value for the user's password
     * @param passwordSalt  A String representing the salt needed to hash the user's password
     * @param userRole      A Role representing the user's role
     * @param firstName     A String representing the user's first name
     * @param lastName      A String representing the user's last name
     * @param streetAddress A String representing the user's street address
     * @param city          A String representing the user's city
     * @param state         A String representing the user's state
     * @param zipcode       A String representing the user's zipcode
     * @param phoneNumber   A String representing the user's phone number
     * @param emailAddress  A String representing the user's email address
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
     * The getUsername method takes no parameters and returns the user's username
     * @return  A String representing the user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * The getPasswordHash method takes no parameters and returns the user's password hash
     * @return  A String representing the hash value for the user's password
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * The setPasswordHash method takes a String as a parameter to update the user's password hash
     * @param passwordHash  A String representing a new password's hash value
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * The getPasswordSalt method takes no parameters and returns the user's password salt
     * @return  A String representing the salt needed to hash the user's password
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * The setPasswordSalt method takes a String as a parameter to update the user's password salt
     * @param passwordSalt  A String representing a new password's salt value
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    /**
     * The getUserRole method takes no parameters and returns the user's role
     * @return  A Role object representing the user's role
     */
    public Role getUserRole() {
        return userRole;
    }

    /**
     * The setUserRole method takes a Role object as a parameter to update the user's userRole field
     * @param userRole  A Role object representing the user's new role
     */
    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    /**
     * The getFirstName method takes no parameters and returns the user's first name
     * @return  A String representing the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * The setFirstName method takes a String as a parameter to update the user's first name
     * @param firstName A String representing the user's new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * The getLastName method takes no parameters and returns the user's last name
     * @return  A String representing the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * The setLastName method takes a String as a parameter to update the user's last name
     * @param lastName  A String representing the user's new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * The getFullAddress method takes no parameters and returns the user's full address
     * @return  A String formatted to represent the user's full mailing address
     */
    public String getFullAddress() {
        return streetAddress + ", " + city + ", " + state + "  " + zipcode;
    }

    /**
     * The getStreetAddress method takes no parameters and returns the user's street address
     * @return  A String representing the user's street address
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * The setStreetAddress method takes a String as a parameter to update the user's street address
     * @param streetAddress A String representing the user's new street address
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * The getCity method takes no parameters and returns the user's city
     * @return  A String representing the user's city
     */
    public String getCity() {
        return city;
    }

    /**
     * The setCity method takes a String as a parameter to update the user's city
     * @param city  A String representing the user's new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * The getState method takes no parameters and returns the user's state
     * @return  A String representing the user's state
     */
    public String getState() {
        return state;
    }

    /**
     * The setState method takes a String as a parameter to update the user's state
     * @param state A String representing the user's new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * The getZipcode method takes no parameters and returns the user's zipcode
     * @return  A String representing the user's zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * The setZipcode method takes a String as a parameter to update the user's zipcode
     * @param zipcode   A String representing the user's zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * The getPhoneNumber method takes no parameters and returns the user's phone number
     * @return  A String representing the user's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * The setPhoneNumber method takes a String as a parameter to update the user's phone number
     * @param phoneNumber   A String representing the user's new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * The getEmailAddress method takes no parameters and returns the user's email address
     * @return A String representing the user's email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * The setEmailAddress method takes a String as a parameter to update the user's email address
     * @param emailAddress  A String representing the user's new email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
