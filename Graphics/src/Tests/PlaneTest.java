package tests;

import org.junit.Before;
import org.junit.Test;
import main.Plane;
import main.Vector;

import static org.junit.Assert.*;

public class PlaneTest {

    public Plane plane;

    @Before
    public void setUp() throws Exception {
        plane = new Plane(new Vector(-2,0,0),new Vector(0,10,0));
    }

    @Test
    public void testGetIntersect() throws Exception {
        assertTrue(plane.getIntersect(new Vector(0,10,0),new Vector(1,9,0)).equals(new Vector(10,0,0)));
    }
}