//Issue 39
/**
*@file planeDAODataAccessObjectforPlanes.psvfile
*@brief This file contains the PlaneDAO class responsible for accessing plane data from a PSV file
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
*@class PlaneDAO
*@brief The PlaneDAO class provides methods to read plane data from a psv file
*/

public class PlaneDAODataAccessObjectforPlanes.psvfile {
/**
  *@brief The file path to the PSV file containing plane data.
    */
    private static final String FILE_PATH = "Planes.psv";
    /**
     *@brief Retrieves a list of all the planes from the PSV file.
     *@return A list of Plane Objects representing all the planes in the file.
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
}
