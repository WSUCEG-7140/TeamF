//Issue 37
/**
 * @file
 * @brief AirportDAOmethodtoupdateanentryintheAirportfile class contains methods to manipulate Airport data in the "Airports.psv" file.
 */

/**
 * @class AirportDAOmethodtoupdateanentryintheAirportfile
 * @brief The AirportDAOmethodtoupdateanentryintheAirportfile class provides methods to read, add, and update Airport data in the "Airports.psv" file.
 */
public class AirportDAOmethodtoupdateanentryintheAirportfile {
    private static final String FILE_PATH = "Airports.psv";

    /**
     * @brief Get all airports from the "Airports.psv" file.
     * @return A list of Airport objects representing all the airports in the file.
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

    /**
     * @brief Add a new airport to the "Airports.psv" file.
     * @param airport The Airport object representing the airport to be added.
     */
    public void addAirport(Airport airport) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String line = airport.getAirportID() + "|" + airport.getAirportName() + "\n";
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Update an existing airport's information in the "Airports.psv" file.
     * @param airport The Airport object representing the updated airport information.
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

    // Private helper method to save all airports to the file
    private void saveAllAirports(List<Airport> airports) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Airport airport : airports) {
                String line = airport.getAirportID() + "|" + airport.getAirportName() + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
