/**
 * @file AirportDAODataAccessObjectforAirport.psvfile
 *
 * @brief This file contains the implementation of the AirportDAODataAccessObjectforAirport.psvfile class,
 *        which is responsible for reading airport data from a pipe-separated values (psv) file.
 *
 * @details The class provides a method to retrieve a list of all airports stored in the "Airports.psv" file.
 *          Each line in the file represents an airport with the format "AirportID|AirportName".
 *          The class uses FileReader and BufferedReader to read the data from the file and creates
 *          Airport objects based on the retrieved information.
 */

package WrightFlightManager.dao;

import WrightFlightManager.MODEL.Airport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @class AirportDAODataAccessObjectforAirport.psvfile
 *
 * @brief The AirportDAODataAccessObjectforAirport.psvfile class is responsible for accessing airport data
 *        from the "Airports.psv" file and providing methods to work with airport information.
 */
public class AirportDAODataAccessObjectforAirport.psvfile {
    
    /**
     * @brief The path to the "Airports.psv" file.
     */
    private static final String FILE_PATH = "Airports.psv";

    /**
     * @brief Retrieves a list of all airports stored in the "Airports.psv" file.
     *
     * @details Reads the "Airports.psv" file line by line and creates Airport objects for each valid entry.
     *
     * @return A list of Airport objects representing all airports stored in the file.
     */
    public List<Airport> getAllAirports() {
        List<Airport> airports = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 2) {
                    String airportID = data[0];
                    String airportName = data[1];
                    airports.add(new Airport(airportID, airportName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
