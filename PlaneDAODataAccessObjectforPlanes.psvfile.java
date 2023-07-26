//Issue 39

package WrightFlightManager.dao;

import WrightFlightManager.MODEL.Plane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAODataAccessObjectforPlanes.psvfile {
    private static final String FILE_PATH = "Planes.psv";

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
            e.printStackTrace();
        }

        return planes;
    }
}
