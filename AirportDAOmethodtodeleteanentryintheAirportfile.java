// Issue 38

import WrightFlightManager.MODEL.Airport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @class AirportDAO
 * @brief Provides data access operations for Airport objects.
 *
 * The AirportDAO class facilitates reading and writing Airport data to/from a file.
 * It offers methods to retrieve all airports, add a new airport, update an existing airport, and delete an airport entry.
 */
public class AirportDAO {
    private static final String FILE_PATH = "Airports.psv";

    /**
     * Retrieves a list of all airports from the data store.
     *
     * This method reads the data from the "Airports.psv" file and converts it into a list of Airport objects.
     * Each line in the file represents an airport and is formatted as follows:
     * AirportID|AirportName
     *
     * @return A list of Airport objects representing all the airports stored in the file.
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
            // If there is an issue reading the file, the exception will be caught and printed.
            e.printStackTrace();
        }

        return airports;
    }

    /**
     * Adds a new airport to the data store.
     *
     * This method takes an Airport object and appends its data to the "Airports.psv" file.
     *
     * @param airport The Airport object to be added to the data store.
     */
    public void addAirport(Airport airport) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String line = airport.getAirportID() + "|" + airport.getAirportName() + "\n";
            writer.write(line);
        } catch (IOException e) {
            // If there is an issue writing to the file, the exception will be caught and printed.
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing airport in the data store.
     *
     * This method takes an Airport object and searches for an airport with the same ID in the data store.
     * If found, it updates the airport's name with the new name provided in the given Airport object.
     *
     * @param airport The updated Airport object.
     */
    public void updateAirport(Airport airport) {
        List<Airport> airports = getAllAirports();

        for (int i = 0; i < airports.size(); i++) {
            Airport a = airports.get(i);
            if (a.getAirportID().equals(airport.getAirportID())) {
                a.setAirportName(airport.getAirportName());
                airports.set(i, a);
                break;
            }
        }

        saveAllAirports(airports);
    }

    /**
     * Deletes an airport entry from the data store using the airport ID.
     *
     * This method searches for the airport with the given ID in the data store and removes it from the list of airports.
     * The updated list is then saved back to the "Airports.psv" file.
     *
     * @param airportID The ID of the airport to be deleted.
     */
    public void deleteAirport(String airportID) {
        List<Airport> airports = getAllAirports();

        airports.removeIf(airport -> airport.getAirportID().equals(airportID));

        saveAllAirports(airports);
    }

    /**
     * Saves the list of airports back to the data store.
     *
     * This method takes a list of Airport objects and writes their data back to the "Airports.psv" file.
     *
     * @param airports The list of Airport objects to be saved to the data store.
     */
    private void saveAllAirports(List<Airport> airports) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Airport airport : airports) {
                String line = airport.getAirportID() + "|" + airport.getAirportName() + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            // If there is an issue writing to the file, the exception will be caught and printed.
            e.printStackTrace();
        }
    }
}

