package WrightFlightManager.MODEL;

import java.util.Date;

public class Baggage {
    private final int bagId;
    private final String username;
    private String bagOriginAirport;
    private String bagDestinationAirport;
    private Date checkedInDateTime;
    private double weightInPounds;

    /**
     * The Baggage parameterized constructor creates a new Baggage object if it is included
     * when the flight is booked
     * @param bagId                 An integer representing a unique ID number for a bag
     * @param username              A String representing the username of whom the baggage belongs to
     * @param bagOriginAirport      A String representing the three-letter airport code of origin
     * @param bagDestinationAirport A String representing the three-letter airport code of destination
     */
    public Baggage(int bagId, String username, String bagOriginAirport, String bagDestinationAirport) {
        this.bagId = bagId;
        this.username = username;
        this.bagOriginAirport = bagOriginAirport;
        this.bagDestinationAirport = bagDestinationAirport;
        this.weightInPounds = 0;
    }

    /**
     * The Baggage parameterized constructor creates a Baggage object for Baggage on file that was already
     * checked in at the airport for the flight
     * @param bagId                 An integer representing a unique ID number for a bag
     * @param username              A String representing the username of whom the baggage belongs to
     * @param bagOriginAirport      A String representing the three-letter airport code of origin
     * @param bagDestinationAirport A String representing the three-letter airport code of destination
     * @param checkedInDateTime     A Date (including time) representing when the bag was checked in at the
     *                              airport of origin
     * @param weightInPounds        A double representing the wait of the bag (in pounds) when it was checked
     *                              in at the airport of origin
     */
    public Baggage(int bagId, String username, String bagOriginAirport, String bagDestinationAirport, Date checkedInDateTime, double weightInPounds) {
        this.bagId = bagId;
        this.username = username;
        this.bagOriginAirport = bagOriginAirport;
        this.bagDestinationAirport = bagDestinationAirport;
        this.checkedInDateTime = checkedInDateTime;
        this.weightInPounds = weightInPounds;
    }

    /**
     * The getBagId method takes no parameters and returns the Baggage's ID number
     * @return  An integer representing the Baggage's unique ID number
     */
    public int getBagId() {
        return bagId;
    }

    /**
     * The getUsername method takes no parameters and returns the username of the owner that checked
     * the Baggage
     * @return  A String representing the username of the Baggage's owner
     */
    public String getUsername() {
        return username;
    }

    /**
     * The getBagOriginAirport method takes no parameters and returns the Baggage's airport of origin
     * @return  A String representing the three-letter airport code of origin
     */
    public String getBagOriginAirport() {
        return bagOriginAirport;
    }

    /**
     * The getBagDestinationAirport method takes no parameters and returns the Baggage's airport of destination
     * @return  A String representing the three-letter airport code of destination
     */
    public String getBagDestinationAirport() {
        return bagDestinationAirport;
    }

    /**
     * The getCheckedInDateTime method takes no parameters and returns the date (including time) that the bag
     * was checked in
     * @return  A Date (including time) that the Baggage was checked in at the airport of origin
     */
    public Date getCheckedInDateTime() {
        return checkedInDateTime;
    }

    /**
     * The setCheckedInDateTime method takes no parameters and sets the checkedInDateTime to the current
     * Date (including time)
     */
    public void setCheckedInDateTime() {
        this.checkedInDateTime = new Date();
    }

    /**
     * The setCheckedInDateTime method takes a Date (including time) as a parameter to set when the Baggage
     * was checked in at the airport of origin to be used for Baggage that has already been checked in
     * @param checkedInDateTime The Date (including time) that the Baggage was checked in at the airport
     *                          of origin
     */
    public void setCheckedInDateTime(Date checkedInDateTime) {
        this.checkedInDateTime = checkedInDateTime;
    }

    /**
     * The getWeight method takes no parameters and returns the weight of the Baggage when it was checked in
     * @return  A double representing the weight of the Baggage at check in (in pounds)
     */
    public double getWeightInPounds() {
        return weightInPounds;
    }

    /**
     * The setWeightInPounds method takes a double as a parameter to set the weightInPounds for the Baggage
     * @param weightInPounds    A double representing the weight of the Baggage in pounds
     */
    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }
}
