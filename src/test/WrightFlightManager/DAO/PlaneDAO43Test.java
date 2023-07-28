/**
 * @file
 * @brief jUnit Test for PlaneDAO43 class.
 *
 * Please change the class name accordingly.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.io.File;
import java.io.IOException;

/**
 * @class PlaneDAO43Test
 * @brief Contains jUnit test cases for the PlaneDAO43 class.
 *
 * This class is responsible for testing the functionalities of the PlaneDAO43 class,
 * which is a Data Access Object (DAO) for managing Plane objects and their persistence.
 */
public class PlaneDAO43Test {
    private PlaneDAO43 planeDAO;

    /**
     * @brief Set up test environment before each test case.
     *
     * This method is executed before each test case to ensure a clean test environment.
     * It clears the test data file "Planes.psv" if it exists and creates a new PlaneDAO43 object.
     */
    @Before
    public void setUp() {
        File testDataFile = new File("Planes.psv");
        if (testDataFile.exists()) {
            testDataFile.delete();
        }

        planeDAO = new PlaneDAO43();
    }

    /**
     * @brief Test case for getAllPlanes() method.
     *
     * This test checks if the getAllPlanes() method returns a non-empty list and
     * verifies that the test data file is empty initially.
     */
    @Test
    public void testGetAllPlanes() {
        List<Plane> planes = planeDAO.getAllPlanes();
        assertNotNull(planes);
        assertTrue(planes.isEmpty());
    }

    /**
     * @brief Test case for addPlane() method.
     *
     * This test verifies that the addPlane() method correctly adds a new plane to the file,
     * and the plane details are correctly retrieved from the list after addition.
     */
    @Test
    public void testAddPlane() {
        Plane plane = new Plane("AirIndia 123", 20, 300);
        planeDAO.addPlane(plane);

        List<Plane> planes = planeDAO.getAllPlanes();

        assertEquals(1, planes.size());
        assertEquals(plane.getPlaneType(), planes.get(0).getPlaneType());
        assertEquals(plane.getFirstClassSeatCapacity(), planes.get(0).getFirstClassSeatCapacity());
        assertEquals(plane.getCoachClassSeatCapacity(), planes.get(0).getCoachClassSeatCapacity());
    }

    /**
     * @brief Test case for updatePlane() method.
     *
     * This test verifies that the updatePlane() method correctly updates the plane capacity
     * and the updated plane details are reflected in the list.
     */
    @Test
    public void testUpdatePlane() {
        Plane plane = new Plane("AirIndia 123", 20, 300);
        planeDAO.addPlane(plane);

        Plane updatedPlane = new Plane("AirIndia 123", 30, 350);
        planeDAO.updatePlane(updatedPlane);

        List<Plane> planes = planeDAO.getAllPlanes();

        assertEquals(1, planes.size());
        assertEquals(updatedPlane.getPlaneType(), planes.get(0).getPlaneType());
        assertEquals(updatedPlane.getFirstClassSeatCapacity(), planes.get(0).getFirstClassSeatCapacity());
        assertEquals(updatedPlane.getCoachClassSeatCapacity(), planes.get(0).getCoachClassSeatCapacity());
    }

    /**
     * @brief Test case for deletePlane() method.
     *
     * This test verifies that the deletePlane() method correctly removes the plane from the list,
     * and the plane is no longer available in the list after deletion.
     */
    @Test
    public void testDeletePlane() {
        Plane plane = new Plane("AirIndia 123", 20, 300);
        planeDAO.addPlane(plane);

        planeDAO.deletePlane("AirIndia 123");

        List<Plane> planes = planeDAO.getAllPlanes();

        assertTrue(planes.isEmpty());
    }
}
