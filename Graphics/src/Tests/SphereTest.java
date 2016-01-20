package Tests;

import main.Sphere;
import main.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class SphereTest {

    public Sphere sphere = new Sphere(new Vector(0,0,10),6);

    @Test
    public void testScale() throws Exception {

    }

    @Test
    public void testGetIntersect() throws Exception {
//        Vector intersect = sphere.getIntersect(new Vector(0,0,0),new Vector(0,0,10));
//        assertTrue(intersect.equals(new Vector(0,0,4)));
        Vector farIntersect = sphere.getIntersect(new Vector(0,0,0),new Vector(0,-6,10));
        assertTrue(farIntersect.equals(new Vector(0,-6,10)));
    }
}