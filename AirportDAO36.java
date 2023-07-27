//Issue 36
/**
 * @file
 * @brief AirportDAO class provides methods to read and add Airport data from/to the "Airports.psv" file.
 */

/**
 * @class AirportDAO
 * @brief The AirportDAO class provides methods to interact with the "Airports.psv" file and manipulate Airport data.
 */
public class AirportDAO {
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
}
