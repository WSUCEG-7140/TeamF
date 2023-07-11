package WrightFlightManager.MODEL;

public class Plane {
    private final String planeType;
    private int firstClassSeatCapacity;
    private int coachClassSeatCapacity;

    /**
     * The Plane constructor creates a new Plane object and requires all parameters
     * (cannot build a Plane object with a non-parameterized constructor)
     * @param planeType                 A String representing the type of plane
     * @param firstClassSeatCapacity    An integer representing the number of first class seats
     *                                  on the plane
     * @param coachClassSeatCapacity    An integer representing the number of coach class seats
     *                                  on the plane
     */
    public Plane(String planeType, int firstClassSeatCapacity, int coachClassSeatCapacity) {
        this.planeType = planeType;
        this.firstClassSeatCapacity = firstClassSeatCapacity;
        this.coachClassSeatCapacity = coachClassSeatCapacity;
    }

    /**
     * The getPlaneType method takes no parameters and returns the plane type
     * @return  A String representing the type of plane
     */
    public String getPlaneType() {
        return planeType;
    }

    /**
     * The getFirstClassSeatCapacity method takes no parameters and returns the maximum number
     * of first class seats the plane has
     * @return  An integer representing the number of first class seats on the plane
     */
    public int getFirstClassSeatCapacity() {
        return firstClassSeatCapacity;
    }

    /**
     * The setFirstClassSeatCapacity method takes an integer as a parameter to update the plane's
     * maximum number of first class seats
     * @param firstClassSeatCapacity    An integer representing the number of first class seats to
     *                                  update the plane's first class seat capacity to
     */
    public void setFirstClassSeatCapacity(int firstClassSeatCapacity) {
        this.firstClassSeatCapacity = firstClassSeatCapacity;
    }

    /**
     * The getCoachClassSeatCapacity method takes no parameters and returns the maximum number
     * of coach class seats the plane has
     * @return  An integer representing the number of coach class seats on the plane
     */
    public int getCoachClassSeatCapacity() {
        return coachClassSeatCapacity;
    }

    /**
     * The setCoachClassSeatCapacity method takes an integer as a parameter to update the plane's
     * maximum number of coach class seats
     * @param coachClassSeatCapacity    An integer representing the number of coach class seats to
     *                                  update the plane's coach class seat capacity to
     */
    public void setCoachClassSeatCapacity(int coachClassSeatCapacity) {
        this.coachClassSeatCapacity = coachClassSeatCapacity;
    }
}
