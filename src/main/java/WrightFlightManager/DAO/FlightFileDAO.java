package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.Flight;
import WrightFlightManager.MODEL.Role;
import WrightFlightManager.MODEL.User;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @class FlightFileDAO
 * @brief Handles data access operations related to the Flight model using
a file-based data storage system.
 * <p>
 * The FlightFileDAO class implements the iFlightDAO interface to manage
data related to the "Flight" entity
 * using a file-based storage system. It represents the Data Access Object
(DAO) pattern in the context
 * of managing roles.
 * <p>
 * For more information about the Data Access Object (DAO) pattern, please
refer to
 * the Wikipedia page:
 * @ref https://en.wikipedia.org/wiki/Data_access_object
 */
public class FlightFileDAO implements iFlightDAO {

    /**
     * @brief Name of the file storing flight data.
     */
    private final String flightFileName;

    /**
     * @brief Default constructor for FlightFileDAO.
     * <p>
     * This constructor sets the default path for the file storing flight
    data.
     * The default path is
    "src/main/java/WrightFlightManager/FILES/Flights.psv".
     * Linked Issue: #7 https://github.com/WSUCEG-7140/TeamF/issues/7
     */
    public FlightFileDAO() {
        flightFileName =
                "src/main/java/WrightFlightManager/FILES/Flights.psv";
    }

    /**
     * @brief Parameterized constructor for FlightFileDAO.
     * <p>
     * This constructor allows specifying a custom file path for storing
    flight data.
     * Linked Issue: #7 https://github.com/WSUCEG-7140/TeamF/issues/7
     * @param flightFileName The custom file path for storing flight data.
     */
    public FlightFileDAO(String flightFileName) {
        this.flightFileName = flightFileName;
    }

    /**
     * @brief Adds a new flight to the data storage system.
     * <p>
     * This method is responsible for adding a new flight to the data
    storage system.
     * The flight information is obtained from the provided Flight object.
     * Linked Issue: #43 https://github.com/WSUCEG-7140/TeamF/issues/43
     * @param newFlight The User object representing the new flight to be
    added.
     * @return True if the flight is successfully added, false otherwise.
     */
    @Override
    public boolean addNewFlight(Flight newFlight) {
        boolean addSuccessful = false;
        boolean foundInHashMap = isFlightInFile(newFlight);

        if (!foundInHashMap) {
            HashMap<String, Flight> allFlights = getAllFlights();
            allFlights.put(newFlight.getFlightNumber(), newFlight);
            addSuccessful = writeToFlightsFile(allFlights);
        }
        return addSuccessful;
    }

    /**
     * @brief Retrieves all flights from the data storage system.
     * <p>
     * This method retrieves all flight records from the file-based data
    storage system and returns them in
     * a HashMap where the key is the flight number (a String) and the
    value is the corresponding Flight object.
     * Linked Issue: #44 https://github.com/WSUCEG-7140/TeamF/issues/44
     * @return A HashMap<String, Flight> containing all flight records in
    the data storage system.
     */
    @Override
    public HashMap<String, Flight> getAllFlights(){
        HashMap<String, Flight> allFlights = new HashMap<>();

        try {
            RoleFileDAO roleDAO = new RoleFileDAO();
            HashMap<Integer, Role> allRoles = roleDAO.getAllRoles();
            Path flightFilePath = Path.of(flightFileName);
            Scanner fileRead = new Scanner(flightFilePath);
            while (fileRead.hasNextLine()) {
                String line = fileRead.nextLine();
                String[] splitLine = line.split("\\|");
                if (splitLine.length == 12) {
                    String flightNumber = splitLine[0];
                    String originAirport = splitLine[1];
                    String destinationAirport = splitLine[2];
                    String planeType = splitLine[3];
                    Date plannedDeparture =
                            parseDateFromString(splitLine[4]);
                    Date plannedArrival =
                            parseDateFromString(splitLine[5]);
                    Date actualDeparture =
                            parseDateFromString(splitLine[6]);
                    Date actualArrival =
                            parseDateFromString(splitLine[7]);
                    String departureGate = splitLine[8];
                    String arrivalGate = splitLine[9];
                    int firstClassSeatsFilled =
                            Integer.parseInt(splitLine[10]);
                    int coachClassSeatsFilled =
                            Integer.parseInt(splitLine[11]);
                    allFlights.put(flightNumber, new Flight(
                            flightNumber,
                            originAirport,
                            destinationAirport,
                            planeType,
                            plannedDeparture,
                            plannedArrival,
                            actualDeparture,
                            actualArrival,
                            departureGate,
                            arrivalGate,
                            firstClassSeatsFilled,
                            coachClassSeatsFilled
                    ));
                }
            }
            fileRead.close();
        } catch (IOException e) {
            // Ignore
        }
        return allFlights;
    }

    /**
     * @brief Updates an existing flight's information in the data storage
    system.
     * <p>
     * This method is responsible for updating an existing flight's
    information in the data storage system.
     * The new flight information is obtained from the provided Flight
    object, which should have the same flight
     * number as the one to be updated.
     * Linked Issue: #45 https://github.com/WSUCEG-7140/TeamF/issues/45
     * @param updatedFlight The Flight object representing the updated
    flight information.
     * @return True if the flight information is successfully updated,
    false otherwise.
     */
    @Override
    public boolean updateFlight(Flight updatedFlight) {
        return false;
    }

    /**
     * @brief Deletes a flight from the data storage system.
     * <p>
     * This method is used to delete a flight from the file-based data
    storage system. The flight to be deleted
     * is identified by the provided Flight object, which should have the
    same flight number as the one to be
     * deleted.
     * Linked Issue: #46 https://github.com/WSUCEG-7140/TeamF/issues/46
     * @param flightToDelete The Flight object representing the flight to
    be deleted.
     * @return True if the flight is successfully deleted, false
    otherwise.
     */
    @Override
    public boolean deleteFlight(Flight flightToDelete) {
        return false;
    }

    /**
     * @brief Helper method to check if a Flight is in the flights file.
     * <p>
     * The isFlightInFile method is a helper method that takes a flight as
    a parameter to check if a that
     * Flight is in the flights file by searching for a match of the
    flight number
     * Linked Issue: #43 https://github.com/WSUCEG-7140/TeamF/issues/43
     * @param checkFlight This represents the Flight being searched for
    within the file
     * @return Returns true if the flight was found in the file
     */
    private boolean isFlightInFile(Flight checkFlight) {
        return false;
    }

    /**
     * @brief Helper method to write over the file specified by the
    flightFileName field with a new list of
     * flights.
     * <p>
     * The writeToFlightsFile is a helper method to write over the file
    specified by the flightFileName
     * field with a new list of flights.
     * Linked Issue: #43 https://github.com/WSUCEG-7140/TeamF/issues/43
     * @param updatedFlights This represents the new list of flights to be
    written to the flights file
     * @return Returns true if successfully written to flights file
     */
    private boolean writeToFlightsFile(HashMap<String, Flight>
                                               updatedFlights) {
        return false;
    }

    /**
     * @brief Parses a date from a string representation.
     * <p>
     * This helper method takes a date string in the format "yyyy-MM-dd
    HH:mm:ss" and converts it into a
     * Date object. The expected input format for the date string is
    "yyyy-MM-dd HH:mm:ss". If the input date
     * string is empty or null, the method will return null.
     * @param dateToParse The date string to be parsed in the format
    "yyyy-MM-dd HH:mm:ss".
     * @return A Date object representing the parsed date, or null if the
    input date string is empty or null.
     */
    private Date parseDateFromString(String dateToParse) {

        Date dateFromString = null;

        if (dateToParse.length() >= 1) {
            String[] splitByHyphen = dateToParse.split("-");
            int year = Integer.parseInt(splitByHyphen[0]);
            int month = Integer.parseInt(splitByHyphen[1]);
            String[] stringBeforeSpace = splitByHyphen[2].split("\\s");
            int day = Integer.parseInt(stringBeforeSpace[0]);
            String[] splitByColon = stringBeforeSpace[1].split(":");
            int hours = Integer.parseInt(splitByColon[0]);
            int minutes = Integer.parseInt(splitByColon[1]);
            int seconds = Integer.parseInt(splitByColon[2]);

            dateFromString = new Date(year, month, day, hours, minutes,
                    seconds);
        }

        return dateFromString;
    }

}
