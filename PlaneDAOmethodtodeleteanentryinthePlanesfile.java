//issue 43
package WrightFlightManager.dao;

import WrightFlightManager.MODEL.Plane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAOmethodtodeleteanentryinthePlanesfile {
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

    public void addPlane(Plane plane) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String line = plane.getPlaneType() + "|" + plane.getFirstClassSeatCapacity() + "|" + plane.getCoachClassSeatCapacity() + "\n";
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updatePlane(Plane plane) {
        List<Plane> planes = getAllPlanes();

        for (int i = 0; i < planes.size(); i++) {
            Plane p = planes.get(i);
            if (p.getPlaneType().equals(plane.getPlaneType())) {
                p.setFirstClassSeatCapacity(plane.getFirstClassSeatCapacity());
                p.setCoachClassSeatCapacity(plane.getCoachClassSeatCapacity());
                planes.set(i, p);
                break;
            }
        }

        saveAllPlanes(planes);
    }

    public void deletePlane(String planeType) {
        List<Plane> planes = getAllPlanes();

        planes.removeIf(plane -> plane.getPlaneType().equals(planeType));

        saveAllPlanes(planes);
    }

    private void saveAllPlanes(List<Plane> planes) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Plane plane : planes) {
                String line = plane.getPlaneType() + "|" + plane.getFirstClassSeatCapacity() + "|" + plane.getCoachClassSeatCapacity() + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
