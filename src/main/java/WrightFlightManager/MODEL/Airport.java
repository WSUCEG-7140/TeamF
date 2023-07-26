package WrightFlightManager.MODEL;

/**
 * @class Airport
 * @brief This class represents an airport with its ID and name.
 *
 * The Airport class encapsulates information about an airport, including its unique
 * three-letter airport code (ID) and its name. Objects of this class can be used to
 * store and retrieve airport-related information in the WrightFlightManager application.
 */
public class Airport {
    private final String airportID;
    private String airportName;

    /**
     * @brief The Airport constructor creates a new Airport object and requires both parameters
     * (cannot build an Airport object with a non-parameterized constructor).
     * <p>
     * The Airport constructor creates a new Airport object and requires both parameters
     * (cannot build an Airport object with a non-parameterized constructor)
     * Linked Issue: #71 https://github.com/WSUCEG-7140/TeamF/issues/71
     * @param airportID     A String representing the three-letter airport code
     * @param airportName   A String representing the name of the airport identified by the
     *                      three-letter airport code
     */
    public Airport(String airportID, String airportName) {
        this.airportID = airportID;
        this.airportName = airportName;
    }

    /**
     * @brief Retrieves the airport's ID.
     * <p>
     * The getAirportId method takes no parameters and returns the airport's ID
     * Linked Issue: #71 https://github.com/WSUCEG-7140/TeamF/issues/71
     * @return  A String representing the three-letter airport ID code
     */
    public String getAirportID() {
        return airportID;
    }

    /**
     * @brief Retrieves the airport's name.
     * <p>
     * The getAirportName method takes no parameters and returns the airport's name
     * Linked Issue: #71 https://github.com/WSUCEG-7140/TeamF/issues/71
     * @return  A String representing the name of the airport
     */
    public String getAirportName() {
        return airportName;
    }

    /**
     * @brief Sets the name of the airport to the provided value.
     * <p>
     * The setAirportName method takes a single String as a parameter and sets the name
     * of the airport to that String
     * Linked Issue: #71 https://github.com/WSUCEG-7140/TeamF/issues/71
     * @param airportName   A String representing the new name for the airport
     */
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
