//Isue 35
/**
 * @file AirportDAO35.java
 * @brief This file contains the implementation of the AirportDAO35 class.
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
 * @class AirportDAO35
 * @brief This class handles the data access operations for Airport objects.
 */
public class AirportDAO35 {
    /**
     * @brief The file path to store the airport data.
     */
    private static final String FILE_PATH = "Airports.psv";

    /**
     * @brief Adds a new airport entry to the data storage.
     * @param airport The Airport object to be added.
     * @details This function takes an Airport object, converts it into a string representation,
     *          and appends it to the data storage file.
     * @note The airport data is stored in a pipe-separated values (PSV) format: "airportID|airportName".
     * @exception IOException If an I/O error occurs while writing the data to the file.
     */
    public void addAirport(Airport airport) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String line = airport.getAirportID() + "|" + airport.getAirportName() + "\n";
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

