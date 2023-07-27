package WrightFlightManager.MODEL;

import java.util.Date;

/**
 * @class Flight
 * @brief This class represents a flight with its attributes and methods.
 * <p>
 * The Flight class encapsulates information about a flight, including its flight number,
 * origin and destination airports, plane type, planned departure and arrival dates, actual
 * departure and arrival dates, departure and arrival gates, and the number of filled seats in
 * first class and coach class. Objects of this class can be used to store and retrieve flight-related
 * information in the WrightFlightManager application.
 */
public class Flight {
    private final String flightNumber;
    private String originAirport;
    private String destinationAirport;
    private String planeType;
    private Date plannedDeparture;
    private Date plannedArrival;
    private Date actualDeparture;
    private Date actualArrival;
    private String departureGate;
    private String arrivalGate;
    private int firstClassSeatsFilled;
    private int coachClassSeatsFilled;

    /**
     * @brief This parameterized constructor is for creating a new flight entry in the database and
     * initializes the variables for firstClassSeatsFilled and coachClassSeatsFilled to zero.
     * <p>
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param flightNumber       A String representing the four-digit flight number.
     * @param originAirport      A String representing the three-letter airport code of origin.
     * @param destinationAirport A String representing the three-letter airport code of destination.
     * @param planeType          A String representing the type of plane the flight will use.
     * @param plannedDeparture   A Date representing the planned date and time of departure.
     * @param plannedArrival     A Date representing the planned date and time of arrival.
     * @param departureGate      A String representing the gate the flight will depart from.
     * @param arrivalGate        A String representing the gate the flight will arrive at.
     */
    public Flight(String flightNumber, String originAirport, String destinationAirport, String planeType, Date plannedDeparture, Date plannedArrival, String departureGate, String arrivalGate) {
        this.flightNumber = flightNumber;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.planeType = planeType;
        this.plannedDeparture = plannedDeparture;
        this.plannedArrival = plannedArrival;
        this.actualDeparture = null;
        this.actualArrival = null;
        this.departureGate = departureGate;
        this.arrivalGate = arrivalGate;
        this.firstClassSeatsFilled = 0;
        this.coachClassSeatsFilled = 0;
    }

    /**
     * @brief This parameterized constructor is for Flight objects that already exist and are read-in
     * from the Flights database file.
     * <p>
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param flightNumber          A String representing the four-digit flight number.
     * @param originAirport         A String representing the three-letter airport code of origin.
     * @param destinationAirport    A String representing the three-letter airport code of destination.
     * @param planeType             A String representing the type of plane the flight will use.
     * @param plannedDeparture      A Date representing the planned date and time of departure.
     * @param plannedArrival        A Date representing the planned date and time of arrival.
     * @param actualDeparture       A Date representing the actual date and time of departure.
     * @param actualArrival         A Date representing the actual date and time of arrival.
     * @param departureGate         A String representing the gate the flight will depart from.
     * @param arrivalGate           A String representing the gate the flight will arrive at.
     * @param firstClassSeatsFilled An integer representing the number of first class seats already filled.
     * @param coachClassSeatsFilled An integer representing the number of coach class seats already filled.
     */
    public Flight(String flightNumber, String originAirport, String destinationAirport, String planeType, Date plannedDeparture, Date plannedArrival, Date actualDeparture, Date actualArrival, String departureGate, String arrivalGate, int firstClassSeatsFilled, int coachClassSeatsFilled) {
        this.flightNumber = flightNumber;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.planeType = planeType;
        this.plannedDeparture = plannedDeparture;
        this.plannedArrival = plannedArrival;
        this.actualDeparture = actualDeparture;
        this.actualArrival = actualArrival;
        this.departureGate = departureGate;
        this.arrivalGate = arrivalGate;
        this.firstClassSeatsFilled = firstClassSeatsFilled;
        this.coachClassSeatsFilled = coachClassSeatsFilled;
    }

    /**
     * @brief Retrieves the Flight's four-digit ID number.
     * <p>
     * The getFlightNumber method takes no parameters and returns the Flight's four-digit ID number.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return A String representing the four-digit flight identification number.
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * @brief Retrieves the three-letter code for the Flight's airport of origin.
     * <p>
     * The getOriginAirport method takes no parameters and returns the three-letter code for the
     * Flight's airport of origin.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return A String representing the three-letter airport code.
     */
    public String getOriginAirport() {
        return originAirport;
    }

    /**
     * @brief Sets the airport of origin for the Flight.
     * <p>
     * The setOriginAirport method takes a single String as a parameter and sets that to the airport
     * of origin.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param originAirport A String representing the three-letter airport code for the origin airport.
     */
    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    /**
     * @brief Retrieves the three-letter code for the Flight's airport of destination.
     * <p>
     * The getDestinationAirport method takes no parameters and returns the three-letter code for the
     * Flight's airport of destination.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return A String representing the three-letter airport code.
     */
    public String getDestinationAirport() {
        return destinationAirport;
    }

    /**
     * @brief Sets the airport of destination for the Flight.
     * <p>
     * The setDestinationAirport method takes a single String as a parameter and sets that to the
     * destination airport.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param destinationAirport A String representing the three-letter airport code for the
     *                           destination airport.
     */
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    /**
     * @brief Retrieves the type of plane the Flight will be on.
     * <p>
     * The getPlaneType method takes no parameters and returns the type of plane the Flight will be
     * on.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return A String representing the type of plane for the Flight.
     */
    public String getPlaneType() {
        return planeType;
    }

    /**
     * @brief Sets the type of plane the Flight will use.
     * <p>
     * The setPlaneType method takes a single String as a parameter and sets that to the type of
     * plane the flight will use.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param planeType A String representing the type of plane for the flight.
     */
    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    /**
     * @brief Retrieves the planned date and time of departure for the Flight.
     * <p>
     * The getPlannedDeparture method takes no parameters and returns the Date (including time) of
     * the Flight's planned departure.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return A Date representing the planned date and time of departure.
     */
    public Date getPlannedDeparture() {
        return plannedDeparture;
    }

    /**
     * @brief Sets the planned date and time of departure for the Flight.
     * <p>
     * The setPlannedDeparture method takes a Date (including time) to set the Flight's planned
     * departure date/time.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param plannedDeparture A Date representing the planned date and time of departure.
     */
    public void setPlannedDeparture(Date plannedDeparture) {
        this.plannedDeparture = plannedDeparture;
    }

    /**
     * @brief Retrieves the planned date and time of arrival for the Flight.
     * <p>
     * The getPlannedArrival method takes no parameters and returns the Date (including time) of
     * the Flight's planned arrival.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return A Date representing the planned date and time of arrival.
     */
    public Date getPlannedArrival() {
        return plannedArrival;
    }

    /**
     * @brief Sets the planned date and time of arrival for the Flight.
     * <p>
     * The setPlannedArrival method takes a Date (including time) to set the Flight's planned
     * arrival date/time.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param plannedArrival A Date representing the planned date and time of arrival.
     */
    public void setPlannedArrival(Date plannedArrival) {
        this.plannedArrival = plannedArrival;
    }

    /**
     * @brief Retrieves the actual date and time of departure for the Flight.
     * <p>
     * The getActualDeparture method takes no parameters and returns the Date (including time) of
     * the Flight's actual departure.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return A Date representing the actual date and time of departure.
     */
    public Date getActualDeparture() {
        return actualDeparture;
    }

    /**
     * @brief Sets the actual date and time of departure for the Flight.
     * <p>
     * The setActualDeparture method takes a Date (including time) to set the Flight's actual
     * departure date/time.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param actualDeparture A Date representing the actual date and time of departure.
     */
    public void setActualDeparture(Date actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    /**
     * @brief Retrieves the actual date and time of arrival for the Flight.
     * <p>
     * The getActualArrival method takes no parameters and returns the Date (including time) of
     * the Flight's actual arrival.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return A Date representing the actual date and time of arrival.
     */
    public Date getActualArrival() {
        return actualArrival;
    }

    /**
     * @brief Sets the actual date and time of arrival for the Flight.
     * <p>
     * The setActualArrival method takes a Date (including time) to set the Flight's actual
     * arrival date/time.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param actualArrival A Date representing the actual date and time of arrival.
     */
    public void setActualArrival(Date actualArrival) {
        this.actualArrival = actualArrival;
    }

    /**
     * @brief Retrieves the gate the Flight will depart from.
     * <p>
     * The getDepartureGate method takes no parameters and returns the gate the Flight will depart
     * from.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return A String representing the gate the Flight will depart from.
     */
    public String getDepartureGate() {
        return departureGate;
    }

    /**
     * @brief Sets the gate from which the Flight will depart.
     * <p>
     * The setDepartureGate method takes a single String as a parameter and sets the Flight's
     * departure gate.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param departureGate A String representing the gate the flight will depart from.
     */
    public void setDepartureGate(String departureGate) {
        this.departureGate = departureGate;
    }

    /**
     * @brief Retrieves the gate the Flight will arrive at.
     * <p>
     * The getArrivalGate method takes no parameters and returns the gate the Flight will arrive
     * at.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return A String representing the gate the Flight will arrive at.
     */
    public String getArrivalGate() {
        return arrivalGate;
    }

    /**
     * @brief Sets the gate at which the Flight will arrive.
     * <p>
     * The setArrivalGate method takes a single String as a parameter and sets the Flight's
     * arrival gate.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param arrivalGate A String representing the gate the flight will arrive at.
     */
    public void setArrivalGate(String arrivalGate) {
        this.arrivalGate = arrivalGate;
    }

    /**
     * @brief Retrieves the number of first class seats already filled for the flight.
     * <p>
     * The getFirstClassSeatsFilled method takes no parameters and returns the number of first
     * class seats already filled for the flight.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return An integer representing the number of first class seats already filled.
     */
    public int getFirstClassSeatsFilled() {
        return firstClassSeatsFilled;
    }

    /**
     * @brief Sets the number of first class seats already filled for the Flight.
     * <p>
     * The setFirstClassSeatsFilled method takes an integer as a parameter and sets the Flight's
     * number of first class seats that are already filled.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param firstClassSeatsFilled An integer representing the number of first class seats
     *                              already filled.
     */
    public void setFirstClassSeatsFilled(int firstClassSeatsFilled) {
        this.firstClassSeatsFilled = firstClassSeatsFilled;
    }

    /**
     * @brief Retrieves the number of coach class seats already filled for the flight.
     * <p>
     * The getCoachClassSeatsFilled method takes no parameters and returns the number of coach
     * class seats already filled for the flight.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @return An integer representing the number of coach class seats already filled.
     */
    public int getCoachClassSeatsFilled() {
        return coachClassSeatsFilled;
    }

    /**
     * @brief Sets the number of coach class seats already filled for the Flight.
     * <p>
     * The setCoachClassSeatsFilled method takes an integer as a parameter and sets the Flight's
     * number of coach class seats that are already filled.
     * Linked Issue: #73 https://github.com/WSUCEG-7140/TeamF/issues/73
     * @param coachClassSeatsFilled An integer representing the number of coach class seats
     *                              already filled.
     */
    public void setCoachClassSeatsFilled(int coachClassSeatsFilled) {
        this.coachClassSeatsFilled = coachClassSeatsFilled;
    }
}
