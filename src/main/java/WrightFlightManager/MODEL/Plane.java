package WrightFlightManager.MODEL;

/**
 * @class Plane
 * @brief This class represents a plane with its type and seat capacities.
 * <p>
 * The Plane class encapsulates information about a plane, including its type and seat capacities
 * for first class and coach class. Objects of this class can be used to store and retrieve plane-related
 * information in the WrightFlightManager application.
 */
public class Plane {
    private final String planeType;
    private int firstClassSeatCapacity;
    private int coachClassSeatCapacity;

    /**
     * The Plane constructor creates a new Plane object and requires all parameters
     * (cannot build a Plane object with a non-parameterized constructor).
     * Linked Issue: #72 https://github.com/WSUCEG-7140/TeamF/issues/72
     * @param planeType              A String representing the type of plane.
     * @param firstClassSeatCapacity An integer representing the number of first class seats on the plane.
     * @param coachClassSeatCapacity An integer representing the number of coach class seats on the plane.
     */
    public Plane(String planeType, int firstClassSeatCapacity, int coachClassSeatCapacity) {
        this.planeType = planeType;
        this.firstClassSeatCapacity = firstClassSeatCapacity;
        this.coachClassSeatCapacity = coachClassSeatCapacity;
    }

    /**
     * @brief Retrieves the type of the plane.
     * <p>
     * The getPlaneType method takes no parameters and returns the plane type.
     * Linked Issue: #72 https://github.com/WSUCEG-7140/TeamF/issues/72
     * @return A String representing the type of plane.
     */
    public String getPlaneType() {
        return planeType;
    }

    /**
     * @brief Retrieves the maximum number of first class seats the plane has.
     * <p>
     * The getFirstClassSeatCapacity method takes no parameters and returns the maximum number
     * of first class seats the plane has.
     * Linked Issue: #72 https://github.com/WSUCEG-7140/TeamF/issues/72
     * @return An integer representing the number of first class seats on the plane.
     */
    public int getFirstClassSeatCapacity() {
        return firstClassSeatCapacity;
    }

    /**
     * @brief Sets the maximum number of first class seats for the plane.
     * <p>
     * The setFirstClassSeatCapacity method takes an integer as a parameter to update the plane's
     * maximum number of first class seats.
     * Linked Issue: #72 https://github.com/WSUCEG-7140/TeamF/issues/72
     * @param firstClassSeatCapacity An integer representing the number of first class seats to
     *                               update the plane's first class seat capacity to.
     */
    public void setFirstClassSeatCapacity(int firstClassSeatCapacity) {
        this.firstClassSeatCapacity = firstClassSeatCapacity;
    }

    /**
     * @brief Retrieves the maximum number of coach class seats the plane has.
     * <p>
     * The getCoachClassSeatCapacity method takes no parameters and returns the maximum number
     * of coach class seats the plane has.
     * Linked Issue: #72 https://github.com/WSUCEG-7140/TeamF/issues/72
     * @return An integer representing the number of coach class seats on the plane.
     */
    public int getCoachClassSeatCapacity() {
        return coachClassSeatCapacity;
    }

    /**
     * @brief Sets the maximum number of coach class seats for the plane.
     * <p>
     * The setCoachClassSeatCapacity method takes an integer as a parameter to update the plane's
     * maximum number of coach class seats.
     * Linked Issue: #72 https://github.com/WSUCEG-7140/TeamF/issues/72
     * @param coachClassSeatCapacity An integer representing the number of coach class seats to
     *                               update the plane's coach class seat capacity to.
     */
    public void setCoachClassSeatCapacity(int coachClassSeatCapacity) {
        this.coachClassSeatCapacity = coachClassSeatCapacity;
    }
}
