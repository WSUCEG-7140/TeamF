/**

 @file PlaneDAOmethodtoreadentriesfromthePlanesfile.java
 @brief This file contains the PlaneDAOmethodtoreadentriesfromthePlanesfile class, which provides methods to read and write plane data from/to a file.
 Issue 41
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

 @class PlaneDAOmethodtoreadentriesfromthePlanesfile

 @brief The PlaneDAOmethodtoreadentriesfromthePlanesfile class provides methods to read and write plane data from/to a file.
 */
public class PlaneDAOmethodtoreadentriesfromthePlanesfile {

    /** @brief The file path of the planes data file. */
    private static final String FILE_PATH = "Planes.psv";

    /**

     @brief Retrieve a list of all planes from the data file.

     @return List of Plane objects representing all planes stored in the file.
     */
    public List<Plane> getAllPlanes() {
        List<Plane> planes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\|");
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

     @brief Add a new plane to the data file.
     @param plane The Plane object representing the plane to be added.
     */
    public void addPlane(Plane plane) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String line = plane.getPlaneType() + "|" + plane.getFirstClassSeatCapacity() + "|" + plane.getCoachClassSeatCapacity() + "\n";
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




