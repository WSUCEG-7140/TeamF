package WrightFlightManager.DAO;

import WrightFlightManager.MODEL.Flight;

import java.util.HashMap;

/**
 * @interface iFlightDAO
 * @brief This interface defines the contract for managing flights using a
data access object (DAO) approach.
 *
 * The iFlightDAO interface provides a set of methods for performing CRUD
(Create, Read, Update, Delete) operations
 * related to the "Flight" entity. Classes that implement this interface
are expected to provide concrete
 * implementations for these methods, allowing interaction with a data
storage system for managing flights.
 */
public interface iFlightDAO {

    /**
     * @brief Adds a new flight to the data storage.
     *
     * This method adds a new flight to the data storage (e.g., a file or
    database) if the flight number is not
     * already present in the data storage.
     *
     * @param newFlight The Flight object representing the new flight to
    be added.
     * @return true if the flight was successfully added, false otherwise.
     */
    boolean addNewFlight(Flight newFlight);

    /**
     * @brief Retrieves all flights from the data storage.
     *
     * This method retrieves all flights from the data storage and returns
    them as a HashMap, where the keys
     * are flight numbers (as Strings) and the values are Flight objects.
     *
     * @return A HashMap containing all Flights, where the keys are flight
    numbers (as Strings) and the values
     * are Flight objects.
     */
    HashMap<String, Flight> getAllFlights();

    /**
     * @brief Updates an existing flight in the data storage.
     *
     * This method updates an existing flight in the data storage based on
    the information provided in the
     * updatedFlight parameter. The update is performed based on the
    flight's unique identifier (flight number).
     *
     * @param updatedFlight The Flight object representing the updated
    flight information.
     * @return true if the flight was successfully updated, false
    otherwise.
     */
    boolean updateFlight(Flight updatedFlight);

    /**
     * @brief Deletes a flights from the data storage.
     *
     * This method deletes the specified flight from the data storage
    based on the information provided
     * in the flightToDelete parameter. The deletion is performed based on
    the flight's unique identifier
     * (flight number).
     *
     * @param flightToDelete The Role object representing the role to be
    deleted.
     * @return true if the role was successfully deleted, false otherwise.
     */
    boolean deleteFlight(Flight flightToDelete);
}

