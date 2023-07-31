//issue 43
/**
 * @file PlaneDAOmethodtodeleteanentryinthePlanesfile.java
 * @brief This file contains the implementation of the PlaneDAOmethodtodeleteanentryinthePlanesfile class.
 */

package WrightFlightManager.dao;

import WrightFlightManager.MODEL.Plane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @class PlaneDAOmethodtodeleteanentryinthePlanesfile
 * @brief This class provides data access operations for Plane objects using a pipe-separated values (PSV) file.
 */
public class PlaneDAOmethodtodeleteanentryinthePlanesfile {
    /**
     * @brief The file path to access the plane data.
     */
    private static final String FILE_PATH = "Planes.psv";

    /**
     * @brief Retrieves a list of all planes stored in the data file.
     * @return A List of Plane objects containing all planes in the data file.
     * @details This function reads the data from the PSV file and converts it into a list of Plane objects.
     *          Each line in the file is expected to be in the format: "planeType|firstClassSeatCapacity|coachClassSeatCapacity".
     * @exception IOException If an I/O error occurs while reading the data from the file.
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
            e.printStackTrace();
        }

        return planes;
    }

    /**
     * @brief Adds a new plane entry to the data storage.
     * @param plane The Plane object to be added.
     * @details This function takes a Plane object, converts it into a string representation,
     *          and appends it to the data storage file.
     * @note The plane data is stored in a pipe-separated values (PSV) format: "planeType|firstClassSeatCapacity|coachClassSeatCapacity".
     * @exception IOException If an I/O error occurs while writing the data to the file.
     */
    public void addPlane(Plane plane) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String line = plane.getPlaneType() + "|" + plane.getFirstClassSeatCapacity() + "|" + plane.getCoachClassSeatCapacity() + "\n";
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Updates an existing plane entry in the data storage.
     * @param plane The Plane object containing the updated information.
     * @details This function searches for a plane with the same planeType in the data storage,
     *          and if found, updates its firstClassSeatCapacity and coachClassSeatCapacity.
     * @exception IOException If an I/O error occurs while reading or writing the data to the file.
     */
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

    /**
     * @brief Deletes a plane entry from the data storage based on the plane type.
     * @param planeType The type of the plane to be deleted.
     * @details This function searches for a plane with the specified planeType in the data storage,
     *          and if found, removes it from the list of planes.
     * @exception IOException If an I/O error occurs while reading or writing the data to the file.
     */
    public void deletePlane(String planeType) {
        List<Plane> planes = getAllPlanes();

        planes.removeIf(plane -> plane.getPlaneType().equals(planeType));

        saveAllPlanes(planes);
    }

    /**
     * @brief Saves the list of planes to the data storage file.
     * @param planes The List of Plane objects to be saved.
     * @details This function takes a List of Plane objects, converts them into string representations,
     *          and writes them to the data storage file in PSV format.
     * @exception IOException If an I/O error occurs while writing the data to the file.
     */
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
