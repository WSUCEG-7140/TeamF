//Issue 34
/**
 * @file AirportDAODataAccessObjectforAirport.psvfile
 * @brief This file contains the implementation of the AirportDAODataAccessObjectforAirport.psvfile class.
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
 * @brief This class provides data access operations for Airport objects using a pipe-separated values (PSV) file.
 */
public class AirportDAODataAccessObjectforAirport.psvfile {
    /**
     * @brief The file path to access the airport data.
     */
    private static final String FILE_PATH = "Airports.psv";

    /**
     * @brief Retrieves a list of all airports stored in the data file.
     * @return A List of Airport objects containing all airports in the data file.
     * @details This function reads the data from the PSV file and converts it into a list of Airport objects.
     *          Each line in the file is expected to be in the format: "airportID|airportName".
     * @exception IOException If an I/O error occurs while reading the data from the file.
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

        return airports;
    }
}
