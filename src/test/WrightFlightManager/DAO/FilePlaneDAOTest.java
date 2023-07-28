/*
jUnit Test for PlaneDAO
Please change the class name accordingly
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.io.File;
import java.io.IOException;


public class FilePlaneDAOTest {
    private PlaneDAO43 planeDAO;

    @Before
    public void setUp() {
        //Clear test data file before each test
        File testDataFile = new File("Planes.psv");
        if (testDataFile.exists()) {
            testDataFile.delete();
        }

        //Now Create PlaneDAO43 object before we want to test all methods
        planeDAO = new PlaneDAO43();
    }

    @Test
    public void testGetAllPlanes() {
        //Test for getAllPlanes() method returns a non empty list
        List<Plane> planes = planeDAO.getAllPlanes();
        assertNotNull(planes);
		//check the test data file is empty
        assertTrue(planes.isEmpty()); 
    }

    @Test
    public void testAddPlane() {
        //Test for addPlane() method adds a new plane to the file
        Plane plane = new Plane("AirIndia 123", 20, 300);
        planeDAO.addPlane(plane);

        //retrieve all planes after adding the new one in list
        List<Plane> planes = planeDAO.getAllPlanes();

        //Check the new plane is present in the list or not
        assertEquals(1, planes.size());
        assertEquals(plane.getPlaneType(), planes.get(0).getPlaneType());
        assertEquals(plane.getFirstClassSeatCapacity(), planes.get(0).getFirstClassSeatCapacity());
        assertEquals(plane.getCoachClassSeatCapacity(), planes.get(0).getCoachClassSeatCapacity());
    }

    @Test
    public void testUpdatePlane() {
        //Testfor updatePlane() method updates the plane capacity correctly
        Plane plane = new Plane("AirIndia 123", 20, 300);
        planeDAO.addPlane(plane);

        //Update the plane capacity
        Plane updatedPlane = new Plane("AirIndia 123", 30, 350);
        planeDAO.updatePlane(updatedPlane);

        //Retrieve all planes after the updating
        List<Plane> planes = planeDAO.getAllPlanes();

        //Test if the plane capacity is updated in the list or not
        assertEquals(1, planes.size());
        assertEquals(updatedPlane.getPlaneType(), planes.get(0).getPlaneType());
        assertEquals(updatedPlane.getFirstClassSeatCapacity(), planes.get(0).getFirstClassSeatCapacity());
        assertEquals(updatedPlane.getCoachClassSeatCapacity(), planes.get(0).getCoachClassSeatCapacity());
    }

    @Test
    public void testDeletePlane() {
        //Test for deletePlane() method which will removes the plane from the list
        Plane plane = new Plane("AirIndia 123", 20, 300); 
        planeDAO.addPlane(plane);

        //Invoke deletePlane() to remove the plane from the list
        planeDAO.deletePlane("AirIndia 123");

        //Again get all planes after the deletion
        List<Plane> planes = planeDAO.getAllPlanes();

        //Test if the plane is no longer available in the list
        assertTrue(planes.isEmpty());
    }
}
