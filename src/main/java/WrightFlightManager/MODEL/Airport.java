package WrightFlightManager.MODEL;

public class Airport {
    private final String airportID;
    private String airportName;

    /**
     * The Airport constructor creates a new Airport object and requires both parameters
     * (cannot build an Airport object with a non-parameterized constructor)
     * @param airportID     A String representing the three-letter airport code
     * @param airportName   A String representing the name of the airport identified by the
     *                      three-letter airport code
     */
    public Airport(String airportID, String airportName) {
        this.airportID = airportID;
        this.airportName = airportName;
    }

    /**
     * The getAirportId method takes no parameters and returns the airport's ID
     * @return  A String representing the three-letter airport ID code
     */
    public String getAirportID() {
        return airportID;
    }

    /**
     * The getAirportName method takes no parameters and returns the airport's name
     * @return  A String representing the name of the airport
     */
    public String getAirportName() {
        return airportName;
    }

    /**
     * The setAirportName method takes a single String as a parameter and sets the name
     * of the airport to that String
     * @param airportName   A String representing the new name for the airport
     */
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
