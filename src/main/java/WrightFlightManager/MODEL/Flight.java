package WrightFlightManager.MODEL;

import java.util.Date;

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
     * This parameterized constructor is for the creation of a new flight entry in the database and
     * will initialize the variables for firstClassSeatsFilled and coachClassSeatsFilled to zero
     * @param flightNumber          A String representing the four digit flight number
     * @param originAirport         A String representing the three-letter airport code of origin
     * @param destinationAirport    A String representing the three-letter airport code of destination
     * @param planeType             A String representing the type of plane the flight will use
     * @param plannedDeparture      A Date representing the planned date and time of departure
     * @param plannedArrival        A Date representing the planned date and time of arrival
     * @param departureGate         A String representing the gate the flight will depart from
     * @param arrivalGate           A String representing the gate the flight will arrive at
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
     * This parameterized constructor is for Flight objects that already exist and are read-in from
     * the Flights database file
     * @param flightNumber          A String representing the four digit flight number
     * @param originAirport         A String representing the three-letter airport code of origin
     * @param destinationAirport    A String representing the three-letter airport code of destination
     * @param planeType             A String representing the type of plane the flight will use
     * @param plannedDeparture      A Date representing the planned date and time of departure
     * @param plannedArrival        A Date representing the planned date and time of arrival
     * @param departureGate         A String representing the gate the flight will depart from
     * @param arrivalGate           A String representing the gate the flight will arrive at
     * @param firstClassSeatsFilled An integer representing the number of first class seats already filled
     * @param coachClassSeatsFilled An integer representing the number of coach class seats already filled
     */
    public Flight(String flightNumber, String originAirport, String destinationAirport, String planeType, Date plannedDeparture, Date plannedArrival, String departureGate, String arrivalGate, int firstClassSeatsFilled, int coachClassSeatsFilled) {
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
        this.firstClassSeatsFilled = firstClassSeatsFilled;
        this.coachClassSeatsFilled = coachClassSeatsFilled;
    }

    /**
     * The getFlightNumber method takes no parameters and returns the Flight's four-digit ID number
     * @return  An integer representing the four-digit flight identification number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * The getOriginAirport method takes no parameters and returns the three-letter code for the
     * Flight's airport of origin
     * @return  A String representing the three-letter airport code
     */
    public String getOriginAirport() {
        return originAirport;
    }

    /**
     * The setOriginAirport method takes a single String as a parameter and sets that to the airport
     * of origin
     * @param originAirport A String representing the three-letter airport code for the origin airport
     */
    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    /**
     * The getDestinationAirport method takes no parameters and returns the three-letter code for the
     * Flight's airport of destination
     * @return  A String representing the three-letter airport code
     */
    public String getDestinationAirport() {
        return destinationAirport;
    }

    /**
     * The setDestinationAirport method takes a single String as a parameter and sets that to the
     * destination airport
     * @param destinationAirport    A String representing the three-letter airport code for the
     *                              destination airport
     */
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    /**
     * The getPlaneType method takes no parameters and returns the type of plane the Flight will be
     * on
     * @return  A String representing the type of plane for the Flight
     */
    public String getPlaneType() {
        return planeType;
    }

    /**
     * The setPlaneType method takes a single String as a parameter and sets that to the type of
     * plane the flight will use
     * @param planeType A String representing the type of plane for the flight
     */
    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    /**
     * The getPlannedDeparture method takes no parameters and returns the Date (including time) of
     * the Flight's planned departure
     * @return  A Date representing the planned date and time of departure
     */
    public Date getPlannedDeparture() {
        return plannedDeparture;
    }

    /**
     * The setPlannedDeparture method takes a Date (including time) to set the Flight's planned
     * departure date/time
     * @param plannedDeparture  A Date representing the planned date and time of departure
     */
    public void setPlannedDeparture(Date plannedDeparture) {
        this.plannedDeparture = plannedDeparture;
    }

    /**
     * The getPlannedArrival method takes no parameters and returns the Date (including time) of
     * the Flight's planned arrival
     * @return  A Date representing the planned date and time of arrival
     */
    public Date getPlannedArrival() {
        return plannedArrival;
    }

    /**
     * The setPlannedArrival method takes a Date (including time) to set the Flight's planned
     * arrival date/time
     * @param plannedArrival    A Date representing the planned date and time of arrival
     */
    public void setPlannedArrival(Date plannedArrival) {
        this.plannedArrival = plannedArrival;
    }

    /**
     * The getActualDeparture method takes no parameters and returns the Date (including time) of
     * the Flight's actual departure
     * @return  A Date representing the actual date and time of departure
     */
    public Date getActualDeparture() {
        return actualDeparture;
    }

    /**
     * The setActualDeparture method takes a Date (including time) to set the Flight's actual
     * departure date/time
     * @param actualDeparture   A Date representing the actual date and time of departure
     */
    public void setActualDeparture(Date actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    /**
     * The getActualArrival method takes no parameters and returns the Date (including time) of
     * the Flight's actual arrival
     * @return  A Date representing the actual date and time of arrival
     */
    public Date getActualArrival() {
        return actualArrival;
    }

    /**
     * The setActualArrival method takes a Date (including time) to set the Flight's actual
     * arrival date/time
     * @param actualArrival A Date representing the actual date and time of arrival
     */
    public void setActualArrival(Date actualArrival) {
        this.actualArrival = actualArrival;
    }

    /**
     * The getDepartureGate method takes no parameters and returns the gate the Flight will depart
     * from
     * @return  A String representing the gate the Flight will depart from
     */
    public String getDepartureGate() {
        return departureGate;
    }

    /**
     * The setDepartureGate method takes a single String as a parameter and sets the Flight's
     * departure gate
     * @param departureGate A String representing the gate the flight will depart from
     */
    public void setDepartureGate(String departureGate) {
        this.departureGate = departureGate;
    }

    /**
     * The getArrivalGate method takes no parameters and returns the gate the Flight will arrive
     * at
     * @return  A String representing the gate the Flight will arrive at
     */
    public String getArrivalGate() {
        return arrivalGate;
    }

    /**
     * The setArrivalGate method takes a single String as a parameter and sets the Flight's
     * arrival gate
     * @param arrivalGate   A String representing the gate the flight will arrive at
     */
    public void setArrivalGate(String arrivalGate) {
        this.arrivalGate = arrivalGate;
    }

    /**
     * The getFirstClassSeatsFilled method takes no parameters and returns the number of first
     * class seats already filled for the flight
     * @return  An integer representing the number of first class seats already filled
     */
    public int getFirstClassSeatsFilled() {
        return firstClassSeatsFilled;
    }

    /**
     * The setFirstClassSeatsFilled method takes an integer as a parameter and sets the Flight's
     * number of first class seats that are already filled
     * @param firstClassSeatsFilled An integer representing the number of first class seats
     *                              already filled
     */
    public void setFirstClassSeatsFilled(int firstClassSeatsFilled) {
        this.firstClassSeatsFilled = firstClassSeatsFilled;
    }

    /**
     * The getCoachClassSeatsFilled method takes no parameters and returns the number of coach
     * class seats already filled for the flight
     * @return  An integer representing the number of coach class seats already filled
     */
    public int getCoachClassSeatsFilled() {
        return coachClassSeatsFilled;
    }

    /**
     * The setCoachClassSeatsFilled method takes an integer as a parameter and sets the Flight's
     * number of coach class seats that are already filled
     * @param coachClassSeatsFilled An integer representing the number of coach class seats
     *                              already filled
     */
    public void setCoachClassSeatsFilled(int coachClassSeatsFilled) {
        this.coachClassSeatsFilled = coachClassSeatsFilled;
    }
}
