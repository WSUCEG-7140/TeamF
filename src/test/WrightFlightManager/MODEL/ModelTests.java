package WrightFlightManager.MODEL;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ModelTests {

    /**
     * Tests for the Airport Class
     */
    private final String airportID = "XXX";
    private String airportName = "TEST AIRPORT";

    Airport testAirport = new Airport(airportID, airportName);

    @Test
    void getAirportID() {
        assertEquals("XXX", testAirport.getAirportID());
        assertNotEquals("xxx", testAirport.getAirportID());
        assertNotEquals("", testAirport.getAirportID());
    }

    @Test
    void getAirportName() {
        assertEquals("TEST AIRPORT", testAirport.getAirportName());
        assertNotEquals("test airport", testAirport.getAirportName());
        assertNotEquals("", testAirport.getAirportName());
    }

    @Test
    void setAirportName() {
        testAirport.setAirportName("TEST NAME");
        assertEquals("TEST NAME", testAirport.getAirportName());
        assertNotEquals("TEST AIRPORT", testAirport.getAirportName());
        assertNotEquals("", testAirport.getAirportName());
    }

    /**
     * Tests for the Baggage Class
     */
    private final int bagId = 1;
    private final String username = "TESTUSER";
    private String bagOriginAirport = "XXX";
    private String bagDestinationAirport = "ZZZ";
    private Date checkedInTime = new Date(123, Calendar.AUGUST, 15, 15, 45, 30);
    private double weightInPounds = 38.75;

    Baggage testNewBag = new Baggage(bagId, username, bagOriginAirport, bagDestinationAirport);
    Baggage testExistingBag = new Baggage(bagId, username, bagOriginAirport, bagDestinationAirport, checkedInTime, weightInPounds);

    @Test
    void getBagId() {
        assertEquals(1, testNewBag.getBagId());
        assertEquals(1, testExistingBag.getBagId());
        assertNotEquals(2, testNewBag.getBagId());
        assertNotEquals(2, testExistingBag.getBagId());
    }

    @Test
    void getUsernameForBaggage() {
        assertEquals("TESTUSER", testNewBag.getUsername());
        assertEquals("TESTUSER", testExistingBag.getUsername());
        assertNotEquals("TestUser", testNewBag.getUsername());
        assertNotEquals("TestUser", testExistingBag.getUsername());
        assertNotEquals("TEST", testNewBag.getUsername());
        assertNotEquals("TEST", testExistingBag.getUsername());
        assertNotEquals("TESTUSER ", testNewBag.getUsername());
        assertNotEquals("TESTUSER ", testExistingBag.getUsername());
        assertNotEquals("", testNewBag.getUsername());
        assertNotEquals("", testExistingBag.getUsername());
    }

    @Test
    void getBagOriginAirport() {
        assertEquals("XXX", testNewBag.getBagOriginAirport());
        assertEquals("XXX", testExistingBag.getBagOriginAirport());
        assertNotEquals("xxx", testNewBag.getBagOriginAirport());
        assertNotEquals("xxx", testExistingBag.getBagOriginAirport());
        assertNotEquals("XX", testNewBag.getBagOriginAirport());
        assertNotEquals("XX", testExistingBag.getBagOriginAirport());
        assertNotEquals("", testNewBag.getBagOriginAirport());
        assertNotEquals("", testExistingBag.getBagOriginAirport());
    }

    @Test
    void getBagDestinationAirport() {
        assertEquals("ZZZ", testNewBag.getBagDestinationAirport());
        assertEquals("ZZZ", testExistingBag.getBagDestinationAirport());
        assertNotEquals("zzz", testNewBag.getBagDestinationAirport());
        assertNotEquals("zzz", testExistingBag.getBagDestinationAirport());
        assertNotEquals("ZZ", testNewBag.getBagDestinationAirport());
        assertNotEquals("ZZ", testExistingBag.getBagDestinationAirport());
        assertNotEquals("", testNewBag.getBagDestinationAirport());
        assertNotEquals("", testExistingBag.getBagDestinationAirport());
    }

    @Test
    void getCheckedInDateTime() {
        assertNull(testNewBag.getCheckedInDateTime());
        assertEquals("Tue Aug 15 15:45:30 EDT 2023", testExistingBag.getCheckedInDateTime().toString());
    }

    @Test
    void setCheckedInDateTime() {
        testNewBag.setCheckedInDateTime();
        assertNotNull(testNewBag.getCheckedInDateTime());
    }

    @Test
    void testSetCheckedInDateTime() {
        Date newCheckIn = new Date(123, Calendar.AUGUST, 16, 12, 0, 0);
        testExistingBag.setCheckedInDateTime(newCheckIn);
        assertEquals("Wed Aug 16 12:00:00 EDT 2023", testExistingBag.getCheckedInDateTime().toString());
    }

    @Test
    void getWeightInPounds() {
        assertEquals(0, testNewBag.getWeightInPounds());
        assertEquals(38.75, testExistingBag.getWeightInPounds());
    }

    @Test
    void setWeightInPounds() {
        testNewBag.setWeightInPounds(10.0);
        testExistingBag.setWeightInPounds(35);
        assertEquals(10, testNewBag.getWeightInPounds());
        assertEquals(35.0, testExistingBag.getWeightInPounds());
        assertNotEquals(0, testNewBag.getWeightInPounds());
        assertNotEquals(38.75, testExistingBag.getWeightInPounds());
    }

    /**
     * Tests for the Flight Class
     */
    private final String flightNumber = "0000";
    private String originAirport = "XXX";
    private String destinationAirport = "ZZZ";
    private String planeType = "S550";
    private Date plannedDeparture = new Date(123, Calendar.AUGUST, 13, 22, 10, 17);
    private Date plannedArrival = new Date((2023 - 1900), Calendar.AUGUST, 14, 0, 10, 17);
    private Date actualDeparture = new Date(123, Calendar.AUGUST, 13, 17, 30, 17);
    private Date actualArrival = new Date(123, Calendar.AUGUST, 13, 19, 50, 0);
    private String departureGate = "A4";
    private String arrivalGate = "B2";
    private int firstClassSeatsFilled = 2;
    private int coachClassSeatsFilled = 4;

    Flight testFlightA = new Flight(flightNumber, originAirport, destinationAirport, planeType, plannedDeparture, plannedArrival, departureGate, arrivalGate);
    Flight testFlightB = new Flight(flightNumber, originAirport, destinationAirport, planeType, plannedDeparture, plannedArrival, actualDeparture, actualArrival, departureGate, arrivalGate, firstClassSeatsFilled, coachClassSeatsFilled);

    @Test
    void getFlightNumber() {
        assertEquals("0000", testFlightA.getFlightNumber());
        assertEquals("0000", testFlightB.getFlightNumber());
        assertNotEquals("0", testFlightA.getFlightNumber());
        assertNotEquals("0", testFlightB.getFlightNumber());
        assertNotEquals("", testFlightA.getFlightNumber());
        assertNotEquals("", testFlightB.getFlightNumber());
    }

    @Test
    void getOriginAirport() {
        assertEquals("XXX", testFlightA.getOriginAirport());
        assertEquals("XXX", testFlightB.getOriginAirport());
        assertNotEquals("xxx", testFlightA.getOriginAirport());
        assertNotEquals("xxx", testFlightB.getOriginAirport());
        assertNotEquals("", testFlightA.getOriginAirport());
        assertNotEquals("", testFlightB.getOriginAirport());
        assertNotEquals("XX", testFlightA.getOriginAirport());
        assertNotEquals("XX", testFlightB.getOriginAirport());
    }

    @Test
    void setOriginAirport() {
        testFlightA.setOriginAirport("RRR");
        testFlightB.setOriginAirport("RRR");
        assertEquals("RRR", testFlightA.getOriginAirport());
        assertEquals("RRR", testFlightB.getOriginAirport());
        assertNotEquals("XXX", testFlightA.getOriginAirport());
        assertNotEquals("XXX", testFlightB.getOriginAirport());
        assertNotEquals("", testFlightA.getOriginAirport());
        assertNotEquals("", testFlightB.getOriginAirport());
    }

    @Test
    void getDestinationAirport() {
        assertEquals("ZZZ", testFlightA.getDestinationAirport());
        assertEquals("ZZZ", testFlightB.getDestinationAirport());
        assertNotEquals("zzz", testFlightA.getDestinationAirport());
        assertNotEquals("zzz", testFlightB.getDestinationAirport());
        assertNotEquals("", testFlightA.getDestinationAirport());
        assertNotEquals("", testFlightB.getDestinationAirport());
        assertNotEquals("ZZ", testFlightA.getDestinationAirport());
        assertNotEquals("ZZ", testFlightB.getDestinationAirport());
    }

    @Test
    void setDestinationAirport() {
        testFlightA.setDestinationAirport("SSS");
        testFlightB.setDestinationAirport("SSS");
        assertEquals("SSS", testFlightA.getDestinationAirport());
        assertEquals("SSS", testFlightB.getDestinationAirport());
        assertNotEquals("ZZZ", testFlightA.getDestinationAirport());
        assertNotEquals("ZZZ", testFlightB.getDestinationAirport());
        assertNotEquals("", testFlightA.getDestinationAirport());
        assertNotEquals("", testFlightB.getDestinationAirport());
    }

    @Test
    void getPlaneTypeFromFlight() {
        assertEquals("S550", testFlightA.getPlaneType());
        assertEquals("S550", testFlightB.getPlaneType());
        assertNotEquals("S55", testFlightA.getPlaneType());
        assertNotEquals("S55", testFlightB.getPlaneType());
        assertNotEquals("s550", testFlightA.getPlaneType());
        assertNotEquals("s550", testFlightB.getPlaneType());
        assertNotEquals("S", testFlightA.getPlaneType());
        assertNotEquals("S", testFlightB.getPlaneType());
        assertNotEquals("", testFlightA.getPlaneType());
        assertNotEquals("", testFlightB.getPlaneType());
    }

    @Test
    void setPlaneType() {
        testFlightA.setPlaneType("CS180");
        testFlightB.setPlaneType("CS150");
        assertEquals("CS180", testFlightA.getPlaneType());
        assertEquals("CS150", testFlightB.getPlaneType());
        assertNotEquals("CS150", testFlightA.getPlaneType());
        assertNotEquals("CS180", testFlightB.getPlaneType());
        assertNotEquals("CS18", testFlightA.getPlaneType());
        assertNotEquals("CS15", testFlightB.getPlaneType());
        assertNotEquals("cs180", testFlightA.getPlaneType());
        assertNotEquals("cs150", testFlightB.getPlaneType());
        assertNotEquals("", testFlightA.getPlaneType());
        assertNotEquals("", testFlightB.getPlaneType());
    }

    @Test
    void getPlannedDeparture() {
        assertEquals("Sun Aug 13 22:10:17 EDT 2023", testFlightA.getPlannedDeparture().toString());
        assertEquals("Sun Aug 13 22:10:17 EDT 2023", testFlightB.getPlannedDeparture().toString());
        assertNotEquals("", testFlightA.getPlannedDeparture().toString());
        assertNotEquals("", testFlightB.getPlannedDeparture().toString());
    }

    @Test
    void setPlannedDeparture() {
        Date newPlannedDepartureA = new Date(123, Calendar.AUGUST, 13, 17, 10, 17);
        Date newPlannedDepartureB = new Date(123, Calendar.AUGUST, 13, 16, 10, 17);
        testFlightA.setPlannedDeparture(newPlannedDepartureA);
        testFlightB.setPlannedDeparture(newPlannedDepartureB);
        assertEquals("Sun Aug 13 17:10:17 EDT 2023", testFlightA.getPlannedDeparture().toString());
        assertEquals("Sun Aug 13 16:10:17 EDT 2023", testFlightB.getPlannedDeparture().toString());
        assertNotEquals("Sun Aug 13 22:10:17 EDT 2023", testFlightA.getPlannedDeparture().toString());
        assertNotEquals("Sun Aug 13 22:10:17 EDT 2023", testFlightB.getPlannedDeparture().toString());
    }

    @Test
    void getPlannedArrival() {
        assertEquals("Mon Aug 14 00:10:17 EDT 2023", testFlightA.getPlannedArrival().toString());
        assertEquals("Mon Aug 14 00:10:17 EDT 2023", testFlightB.getPlannedArrival().toString());
        assertNotEquals("", testFlightA.getPlannedArrival().toString());
        assertNotEquals("", testFlightB.getPlannedArrival().toString());
    }

    @Test
    void setPlannedArrival() {
        Date newPlannedArrivalA = new Date(123, Calendar.AUGUST, 13, 19, 10, 17);
        Date newPlannedArrivalB = new Date(123, Calendar.AUGUST, 13, 18, 10, 17);
        testFlightA.setPlannedArrival(newPlannedArrivalA);
        testFlightB.setPlannedArrival(newPlannedArrivalB);
        assertEquals("Sun Aug 13 19:10:17 EDT 2023", testFlightA.getPlannedArrival().toString());
        assertEquals("Sun Aug 13 18:10:17 EDT 2023", testFlightB.getPlannedArrival().toString());
        assertNotEquals("Mon Aug 14 00:10:17 EDT 2023", testFlightA.getPlannedArrival().toString());
        assertNotEquals("Mon Aug 14 00:10:17 EDT 2023", testFlightB.getPlannedArrival().toString());
    }

    @Test
    void getActualDeparture() {
        assertNull(testFlightA.getActualDeparture());
        assertEquals("Sun Aug 13 17:30:17 EDT 2023", testFlightB.getActualDeparture().toString());
    }

    @Test
    void setActualDeparture() {
        Date actualDepartureA = new Date(123, Calendar.AUGUST, 13, 17, 40, 17);
        Date actualDepartureB = new Date(123, Calendar.AUGUST, 13, 16, 40, 17);
        testFlightA.setActualDeparture(actualDepartureA);
        testFlightB.setActualDeparture(actualDepartureB);
        assertNotNull(testFlightA.getActualDeparture());
        assertEquals("Sun Aug 13 17:40:17 EDT 2023", testFlightA.getActualDeparture().toString());
        assertEquals("Sun Aug 13 16:40:17 EDT 2023", testFlightB.getActualDeparture().toString());
        assertNotEquals("Sun Aug 13 19:30:17 EDT 2023", testFlightB.getActualDeparture().toString());
    }

    @Test
    void getActualArrival() {
        assertNull(testFlightA.getActualArrival());
        assertEquals("Sun Aug 13 19:50:00 EDT 2023", testFlightB.getActualArrival().toString());
    }

    @Test
    void setActualArrival() {
        Date actualArrivalA = new Date(123, Calendar.AUGUST, 13, 20, 00, 00);
        Date actualArrivalB = new Date(123, Calendar.AUGUST, 13, 18, 30, 15);
        testFlightA.setActualArrival(actualArrivalA);
        testFlightB.setActualArrival(actualArrivalB);
        assertNotNull(testFlightA.getActualArrival());
        assertEquals("Sun Aug 13 20:00:00 EDT 2023", testFlightA.getActualArrival().toString());
        assertEquals("Sun Aug 13 18:30:15 EDT 2023", testFlightB.getActualArrival().toString());
        assertNotEquals("Sun Aug 13 19:50:00 EDT 2023", testFlightB.getActualArrival().toString());
    }

    @Test
    void getDepartureGate() {
        assertEquals("A4", testFlightA.getDepartureGate());
        assertEquals("A4", testFlightB.getDepartureGate());
        assertNotEquals("A", testFlightA.getDepartureGate());
        assertNotEquals("A", testFlightB.getDepartureGate());
        assertNotEquals("4", testFlightA.getDepartureGate());
        assertNotEquals("4", testFlightB.getDepartureGate());
        assertNotEquals("", testFlightA.getDepartureGate());
        assertNotEquals("", testFlightB.getDepartureGate());
        assertNotEquals("a4", testFlightA.getDepartureGate());
        assertNotEquals("a4", testFlightB.getDepartureGate());
    }

    @Test
    void setDepartureGate() {
        testFlightA.setDepartureGate("C1");
        testFlightB.setDepartureGate("C2");
        assertEquals("C1", testFlightA.getDepartureGate());
        assertEquals("C2", testFlightB.getDepartureGate());
        assertNotEquals("A4", testFlightA.getDepartureGate());
        assertNotEquals("A4", testFlightB.getDepartureGate());
        assertNotEquals("C2", testFlightA.getDepartureGate());
        assertNotEquals("C1", testFlightB.getDepartureGate());
    }

    @Test
    void getArrivalGate() {
        assertEquals("B2", testFlightA.getArrivalGate());
        assertEquals("B2", testFlightB.getArrivalGate());
        assertNotEquals("B", testFlightA.getArrivalGate());
        assertNotEquals("B", testFlightB.getArrivalGate());
        assertNotEquals("2", testFlightA.getArrivalGate());
        assertNotEquals("2", testFlightB.getArrivalGate());
        assertNotEquals("", testFlightA.getArrivalGate());
        assertNotEquals("", testFlightB.getArrivalGate());
        assertNotEquals("b2", testFlightA.getArrivalGate());
        assertNotEquals("b2", testFlightB.getArrivalGate());
    }

    @Test
    void setArrivalGate() {
        testFlightA.setArrivalGate("D1");
        testFlightB.setArrivalGate("D2");
        assertEquals("D1", testFlightA.getArrivalGate());
        assertEquals("D2", testFlightB.getArrivalGate());
        assertNotEquals("B2", testFlightA.getArrivalGate());
        assertNotEquals("B2", testFlightB.getArrivalGate());
        assertNotEquals("D2", testFlightA.getArrivalGate());
        assertNotEquals("D1", testFlightB.getArrivalGate());
    }

    @Test
    void getFirstClassSeatsFilled() {
        assertEquals(0, testFlightA.getFirstClassSeatsFilled());
        assertEquals(2, testFlightB.getFirstClassSeatsFilled());
    }

    @Test
    void setFirstClassSeatsFilled() {
        testFlightA.setFirstClassSeatsFilled(1);
        testFlightB.setFirstClassSeatsFilled(3);
        assertEquals(1, testFlightA.getFirstClassSeatsFilled());
        assertEquals(3, testFlightB.getFirstClassSeatsFilled());
        assertNotEquals(0, testFlightA.getFirstClassSeatsFilled());
        assertNotEquals(2, testFlightB.getFirstClassSeatsFilled());
    }

    @Test
    void getCoachClassSeatsFilled() {
        assertEquals(0, testFlightA.getCoachClassSeatsFilled());
        assertEquals(4, testFlightB.getCoachClassSeatsFilled());
    }

    @Test
    void setCoachClassSeatsFilled() {
        testFlightA.setCoachClassSeatsFilled(2);
        testFlightB.setCoachClassSeatsFilled(2);
        assertEquals(2, testFlightA.getCoachClassSeatsFilled());
        assertEquals(2, testFlightB.getCoachClassSeatsFilled());
        assertNotEquals(0, testFlightA.getCoachClassSeatsFilled());
        assertNotEquals(4, testFlightB.getCoachClassSeatsFilled());
    }

    /**
     * Tests for the Plane Class
     */
    private final String typeOfPlane = "G6";
    private int firstClassCapacity = 5;
    private int coachClassCapacity = 0;

    Plane testPlane = new Plane(typeOfPlane, firstClassCapacity, coachClassCapacity);

    @Test
    void getPlaneType() {
        assertEquals("G6", testPlane.getPlaneType());
        assertNotEquals("G", testPlane.getPlaneType());
        assertNotEquals("6", testPlane.getPlaneType());
        assertNotEquals("g6", testPlane.getPlaneType());
    }

    @Test
    void getFirstClassSeatCapacity() {
        assertEquals(5, testPlane.getFirstClassSeatCapacity());
        assertNotEquals(0, testPlane.getFirstClassSeatCapacity());
    }

    @Test
    void setFirstClassSeatCapacity() {
        testPlane.setFirstClassSeatCapacity(2);
        assertEquals(2, testPlane.getFirstClassSeatCapacity());
        assertNotEquals(5, testPlane.getFirstClassSeatCapacity());
    }

    @Test
    void getCoachClassSeatCapacity() {
        assertEquals(0, testPlane.getCoachClassSeatCapacity());
        assertNotEquals(5, testPlane.getCoachClassSeatCapacity());
    }

    @Test
    void setCoachClassSeatCapacity() {
        testPlane.setCoachClassSeatCapacity(6);
        assertEquals(6, testPlane.getCoachClassSeatCapacity());
        assertNotEquals(0, testPlane.getCoachClassSeatCapacity());
    }

    /**
     * Tests for the Role Class
     */
    private final int initRoleId = 1;
    private final String initRoleTitle = "Passenger";

    Role testRole = new Role(initRoleId, initRoleTitle);

    @Test
    void getRoleId() {
        assertEquals(1, testRole.getRoleId());
        assertEquals(initRoleId, testRole.getRoleId());
        assertNotEquals(0, testRole.getRoleId());
        assertNotEquals(11, testRole.getRoleId());
    }

    @Test
    void setRoleId() {
        int newRoleId = 2;
        testRole.setRoleId(newRoleId);
        assertEquals(newRoleId, testRole.getRoleId());
        assertNotEquals(initRoleId, testRole.getRoleId());
    }

    @Test
    void getRoleTitle() {
        assertEquals("Passenger", testRole.getRoleTitle());
        assertEquals(initRoleTitle, testRole.getRoleTitle());
        assertNotEquals("Flight Attendant", testRole.getRoleTitle());
        assertNotEquals("Passenge", testRole.getRoleTitle());
        assertNotEquals("Passenger ", testRole.getRoleTitle());
    }

    @Test
    void setRoleTitle() {
        String newRoleTitle = "Flight Attendant";
        testRole.setRoleTitle(newRoleTitle);
        assertEquals(newRoleTitle, testRole.getRoleTitle());
        assertNotEquals(initRoleTitle, testRole.getRoleTitle());
    }

    /**
     * Tests for the User Class
     */
    private final String actualUsername = "DrummerMan";
    private final String initPasswordHash = "d68ba97f98bf28166f2e6ac9ad4d77ba18e04c3b8e32371bf7a026cefb221464cd37912a79d9c5f7bbf805f1360d7e6a4fc4737cf878f66c002141a2ee9e83b3";
    private final String initPasswordSalt = "[64, -34, 114, -77, -9, -38, -48, 53, -54, -69, -11, -11, -102, -116, -25, -15]";
    private final String initFirstName = "Babatunde";
    private final String initLastName = "Olatunji";
    private final String initStreetAddress = "123 Any Street";
    private final String initCity = "New York City";
    private final String initState = "New York";
    private final String initZipCode = "12345";
    private final String initPhoneNumber = "1234567890";
    private final String initEmailAddress = "somebody@website.com";

    User testUser = new User(actualUsername, initPasswordHash, initPasswordSalt, testRole, initFirstName, initLastName, initStreetAddress, initCity, initState, initZipCode, initPhoneNumber, initEmailAddress);

    @Test
    void getUsername() {
        assertEquals(actualUsername, testUser.getUsername());
        assertNotEquals("Drummerman", testUser.getUsername());
        assertNotEquals("drummerman", testUser.getUsername());
        assertNotEquals("DRUMMERMAN", testUser.getUsername());
        assertNotEquals("DrummerMan ", testUser.getUsername());
        assertNotEquals("", testUser.getUsername());
        assertNotEquals(" ", testUser.getUsername());
    }

    @Test
    void getPasswordHash() {
        assertEquals(initPasswordHash, testUser.getPasswordHash());
        assertNotEquals("", testUser.getPasswordHash());
        assertNotEquals(" ", testUser.getPasswordHash());
        assertNotEquals("1", testUser.getPasswordHash());
    }

    @Test
    void setPasswordHash() {
        String newPasswordHash = "1234567890";
        testUser.setPasswordHash(newPasswordHash);
        assertEquals(newPasswordHash, testUser.getPasswordHash());
        assertNotEquals(initPasswordHash, testUser.getPasswordHash());
    }

    @Test
    void getPasswordSalt() {
        assertEquals(initPasswordSalt, testUser.getPasswordSalt());
        assertNotEquals("", testUser.getPasswordSalt());
        assertNotEquals(" ", testUser.getPasswordSalt());
        assertNotEquals("1", testUser.getPasswordSalt());
    }

    @Test
    void setPasswordSalt() {
        String newPasswordSalt = "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]";
        testUser.setPasswordSalt(newPasswordSalt);
        assertEquals(newPasswordSalt, testUser.getPasswordSalt());
        assertNotEquals(initPasswordSalt, testUser.getPasswordSalt());
    }

    @Test
    void getUserRole() {
        assertEquals(initRoleId, testUser.getUserRole().getRoleId());
        assertEquals(initRoleTitle, testUser.getUserRole().getRoleTitle());
        assertNotEquals(2, testUser.getUserRole().getRoleId());
        assertNotEquals("Flight Attendant", testUser.getUserRole().getRoleTitle());
    }

    @Test
    void setUserRole() {
        Role newRole = new Role(2, "Flight Attendant");
        testUser.setUserRole(newRole);
        assertEquals(newRole.getRoleId(), testUser.getUserRole().getRoleId());
        assertEquals(newRole.getRoleTitle(), testUser.getUserRole().getRoleTitle());
        assertNotEquals(initRoleId, testUser.getUserRole().getRoleId());
        assertNotEquals(initRoleTitle, testUser.getUserRole().getRoleTitle());
    }

    @Test
    void getFirstName() {
        assertEquals(initFirstName, testUser.getFirstName());
        assertEquals("Babatunde", testUser.getFirstName());
        assertNotEquals("John", testUser.getFirstName());
    }

    @Test
    void setFirstName() {
        String newFirstName = "John";
        testUser.setFirstName(newFirstName);
        assertEquals(newFirstName, testUser.getFirstName());
        assertNotEquals(initFirstName, testUser.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals(initLastName, testUser.getLastName());
        assertEquals("Olatunji", testUser.getLastName());
        assertNotEquals("Doe", testUser.getLastName());
    }

    @Test
    void setLastName() {
        String newLastName = "Doe";
        testUser.setLastName(newLastName);
        assertEquals(newLastName, testUser.getLastName());
        assertNotEquals(initLastName, testUser.getLastName());
    }

    @Test
    void getFullAddress() {
        String initFullAddress = "123 Any Street, New York City, New York  12345";
        String newFullAddress = "789 Far Way, Cincinnati, Ohio  45202";
        assertEquals(initFullAddress, testUser.getFullAddress());
        assertNotEquals(newFullAddress, testUser.getFullAddress());
    }

    @Test
    void getStreetAddress() {
        assertEquals(initStreetAddress, testUser.getStreetAddress());
        assertNotEquals("789 Far Way", testUser.getStreetAddress());
    }

    @Test
    void setStreetAddress() {
        String newStreetAddress = "789 Far Way";
        testUser.setStreetAddress(newStreetAddress);
        assertEquals(newStreetAddress, testUser.getStreetAddress());
        assertNotEquals(initStreetAddress, testUser.getStreetAddress());
    }

    @Test
    void getCity() {
        assertEquals(initCity, testUser.getCity());
        assertNotEquals("Cincinnati", testUser.getCity());
    }

    @Test
    void setCity() {
        String newCity = "Cincinnati";
        testUser.setCity(newCity);
        assertEquals(newCity, testUser.getCity());
        assertNotEquals(initCity, testUser.getCity());
    }

    @Test
    void getState() {
        assertEquals(initState, testUser.getState());
        assertNotEquals("Ohio", testUser.getState());
    }

    @Test
    void setState() {
        String newState = "Ohio";
        testUser.setState(newState);
        assertEquals(newState, testUser.getState());
        assertNotEquals(initState, testUser.getState());
    }

    @Test
    void getZipcode() {
        assertEquals(initZipCode, testUser.getZipcode());
        assertNotEquals("45202", testUser.getZipcode());
    }

    @Test
    void setZipcode() {
        String newZipcode = "45202";
        testUser.setZipcode(newZipcode);
        assertEquals(newZipcode, testUser.getZipcode());
        assertNotEquals(initZipCode, testUser.getZipcode());
    }

    @Test
    void getPhoneNumber() {
        assertEquals(initPhoneNumber, testUser.getPhoneNumber());
        assertNotEquals("0987654321", testUser.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        String newPhoneNumber = "0987654321";
        testUser.setPhoneNumber(newPhoneNumber);
        assertEquals(newPhoneNumber, testUser.getPhoneNumber());
        assertNotEquals(initPhoneNumber, testUser.getPhoneNumber());
    }

    @Test
    void getEmailAddress() {
        assertEquals(initEmailAddress, testUser.getEmailAddress());
        assertNotEquals("person@place.net", testUser.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        String newEmailAddress = "person@place.net";
        testUser.setEmailAddress(newEmailAddress);
        assertEquals(newEmailAddress, testUser.getEmailAddress());
        assertNotEquals(initEmailAddress, testUser.getEmailAddress());
    }
}