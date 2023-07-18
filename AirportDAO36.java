//Issue 36
import WrightFlightManager.MODEL.Airport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO {
    private static final String FILE_PATH = "Airports.psv";

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
	
	 public void addAirport(Airport airport) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String line = airport.getAirportID() + "|" + airport.getAirportName() + "\n";
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
