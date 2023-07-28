/**

 @file PlaneDAOmethodtocreateanentryinthePlanesfile.java
 @brief This file contains the PlaneDAO class responsible for managing plane data.
 @author [Your Name]
 @date [Date]
 @details
 The PlaneDAO class provides methods to interact with the "Planes.psv" file and perform operations
 such as adding a new plane entry to the file.
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

 @class PlaneDAOmethodtocreateanentryinthePlanesfile

 @brief Provides methods to interact with the "Planes.psv" file and manage plane data.
 */
public class PlaneDAOmethodtocreateanentryinthePlanesfile {

    /**

     @brief The file path for the "Planes.psv" file.
     */
    private static final String FILE_PATH = "Planes.psv";
    /**

     @brief Adds a new plane entry to the "Planes.psv" file.
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
/**

 @example ExamplePlaneDAOUsage.java
 Detailed example on how to use the PlaneDAO class to interact with plane data.
 */



