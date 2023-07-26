// Issue 39

package WrightFlightManager.dao;

import WrightFlightManager.MODEL.Plane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAO {
    private static final String FILE_PATH = "Planes.psv";

    /**
     * Retrieves a list of all planes from the data store.
     *
     * This method reads the data from the "Planes.psv" file and converts it into a list of Plane objects.
     * Each line in the file represents a plane and is formatted as follows:
     * PlaneType|FirstClassSeatCapacity|CoachClassSeatCapacity
     *
     * @return A list of Plane objects representing all the planes stored in the file.
     */
    public List<Plane> getAllPlanes() {
        List<Plane> planes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 3) {
                    String planeType = data[0];
                    int firstClassSeatCapacity = Integer.parseInt(data[1]);
                    int coachClassSeatCapacity = Integer.parseInt(data[2]);
                    planes.add(new Plane(planeType, firstClassSeatCapacity, coachClassSeatCapacity));
                }
            }
        } catch (IOException e) {
            // If there is an issue reading the file, the exception will be caught and printed.
            e.printStackTrace();
        }

        return planes;
    }
}

