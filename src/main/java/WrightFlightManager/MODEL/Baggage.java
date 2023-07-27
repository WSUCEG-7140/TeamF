package WrightFlightManager.MODEL;

import java.util.Date;

/**
 * @class Baggage
 * @brief This class represents a piece of baggage associated with a flight booking.
 * <p>
 * The Baggage class encapsulates information about a piece of baggage, including its unique
 * ID, the username of the owner, airport of origin, airport of destination, check-in date and time,
 * and weight in pounds. Objects of this class can be used to store and retrieve baggage-related
 * information in the WrightFlightManager application.
 */
public class Baggage {
    private final int bagId;
    private final String username;
    private String bagOriginAirport;
    private String bagDestinationAirport;
    private Date checkedInDateTime;
    private double weightInPounds;

    /**
     * @brief The Baggage parameterized constructor creates a new Baggage object if it is included
     * when the flight is booked.
     * <p>
     * The constructor initializes a Baggage object with the provided bag ID, username, airport of
     * origin, and airport of destination. The weight of the baggage is set to 0 by default.
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     * @param bagId                 An integer representing a unique ID number for a bag.
     * @param username              A String representing the username of the baggage's owner.
     * @param bagOriginAirport      A String representing the three-letter airport code of origin.
     * @param bagDestinationAirport A String representing the three-letter airport code of destination.
     */
    public Baggage(int bagId, String username, String bagOriginAirport, String bagDestinationAirport) {
        this.bagId = bagId;
        this.username = username;
        this.bagOriginAirport = bagOriginAirport;
        this.bagDestinationAirport = bagDestinationAirport;
        this.weightInPounds = 0;
    }

    /**
     * @brief The Baggage parameterized constructor creates a Baggage object for baggage on file that was already
     * checked in at the airport for the flight.
     * <p>
     * The constructor initializes a Baggage object with the provided bag ID, username, airport of
     * origin, airport of destination, check-in date and time, and weight in pounds.
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     * @param bagId                 An integer representing a unique ID number for a bag.
     * @param username              A String representing the username of the baggage's owner.
     * @param bagOriginAirport      A String representing the three-letter airport code of origin.
     * @param bagDestinationAirport A String representing the three-letter airport code of destination.
     * @param checkedInDateTime     A Date (including time) representing when the bag was checked in at the
     *                              airport of origin.
     * @param weightInPounds        A double representing the weight of the bag (in pounds) when it was checked
     *                              in at the airport of origin.
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
     * @brief Retrieves the baggage's unique ID number.
     * <p>
     * The getBagId method takes no parameters and returns the baggage's ID number.
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     * @return An integer representing the baggage's unique ID number.
     */
    public int getBagId() {
        return bagId;
    }

    /**
     * @brief Retrieves the username of the owner that checked the baggage.
     * <p>
     * The getUsername method takes no parameters and returns the username of the baggage's owner.
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     * @return A String representing the username of the baggage's owner.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @brief Retrieves the baggage's airport of origin.
     * <p>
     * The getBagOriginAirport method takes no parameters and returns the baggage's airport of origin.
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     * @return A String representing the three-letter airport code of origin.
     */
    public String getBagOriginAirport() {
        return bagOriginAirport;
    }

    /**
     * @brief Retrieves the baggage's airport of destination.
     * <p>
     * The getBagDestinationAirport method takes no parameters and returns the baggage's airport of destination.
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     * @return A String representing the three-letter airport code of destination.
     */
    public String getBagDestinationAirport() {
        return bagDestinationAirport;
    }

    /**
     * @brief Retrieves the date (including time) that the bag was checked in.
     * <p>
     * The getCheckedInDateTime method takes no parameters and returns the date (including time) that the bag
     * was checked in at the airport of origin.
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     * @return A Date (including time) that the baggage was checked in at the airport of origin.
     */
    public Date getCheckedInDateTime() {
        return checkedInDateTime;
    }

    /**
     * @brief Sets the check-in date and time to the current Date (including time).
     * <p>
     * The setCheckedInDateTime method takes no parameters and sets the checkedInDateTime to the current
     * Date (including time).
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     */
    public void setCheckedInDateTime() {
        this.checkedInDateTime = new Date();
    }

    /**
     * @brief Sets the check-in date and time for baggage that has already been checked in.
     * <p>
     * The setCheckedInDateTime method takes a Date (including time) as a parameter to set when the baggage
     * was checked in at the airport of origin.
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     * @param checkedInDateTime The Date (including time) that the baggage was checked in at the airport
     *                          of origin.
     */
    public void setCheckedInDateTime(Date checkedInDateTime) {
        this.checkedInDateTime = checkedInDateTime;
    }

    /**
     * @brief Retrieves the weight of the baggage when it was checked in.
     * <p>
     * The getWeightInPounds method takes no parameters and returns the weight of the baggage at check-in (in pounds).
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     * @return A double representing the weight of the baggage at check-in (in pounds).
     */
    public double getWeightInPounds() {
        return weightInPounds;
    }

    /**
     * @brief Sets the weight of the baggage.
     * <p>
     * The setWeightInPounds method takes a double as a parameter to set the weightInPounds for the baggage.
     * Linked Issue: #76 https://github.com/WSUCEG-7140/TeamF/issues/76
     * @param weightInPounds A double representing the weight of the baggage in pounds.
     */
    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }
}
