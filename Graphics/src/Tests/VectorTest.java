package Tests;

import static org.junit.Assert.*;

import main.Plane;
import org.junit.Before;
import org.junit.Test;
import main.Vector;

public class VectorTest {

    public Vector A;
    public Vector B;

    @Before
    public void setUp() throws Exception {
        A = new Vector(0,0,10);
        B = new Vector(0,10,10);
    }

    @Test
    public void testGetPlaneIntersect() throws Exception {

    }

    @Test
    public void testSubtract() throws Exception {
        Vector C = new Vector(0,10,0);
        assertTrue(B.subtract(A).equals(C));// check if subtraction works correctly
        assertTrue(new Vector(0,10,0).equals(C));//check if itself hasn't changed
    }

    @Test
    public void testAdd() throws Exception {
        Vector C = new Vector(0,10,20);
        assertTrue(B.add(A).equals(C));// check if subtraction works correctly
        assertTrue(new Vector(0,10,20).equals(C));//check if itself hasn't changed
    }

    @Test
    public void testScale() throws Exception {
        assertTrue(A.scale(10).equals(new Vector(0,0,100)));// check if scaling went correctly
        assertTrue(new Vector(0,0,10).equals(A));//check if itself hasn't changed
    }

    @Test
    public void testDot() throws Exception {

    }

    @Test
    public void testCross() throws Exception {

    }

    @Test
    public void testCalcLength() throws Exception {

    }

    @Test
    public void testCalcAngle() throws Exception {

    }

    @Test
    public void testCalcNormal() throws Exception {

    }

    @Test
    public void testIsInTriangle() throws Exception {

    }

    @Test
    public void testRotate() throws Exception {

    }

    @Test
    public void testRotateX() throws Exception {

    }

    @Test
    public void testRotateY() throws Exception {

    }

    @Test
    public void testRotateZ() throws Exception {

    }

    @Test
    public void testCastRay() throws Exception {

    }

    @Test
    public void testProject() throws Exception {
        Vector C = new Vector(0,20,20);
        assertTrue(A.project(C).equals(new Vector(0,0,20)));//check if C was properly projected onto A
        assertTrue(A.equals(new Vector(0,0,10)));//check if A hasn't changed
    }

    @Test
    public void testReflection(){
        Plane plane = new Plane(new Vector(-10,0,0), new Vector(1,0,0));
        Vector C = new Vector(-10,10,0);
        Vector reflection = C.reflectOn(plane,plane.getIntersect(new Vector(0,0,0), C));
        assertTrue(new Vector(0, 20, 0).equals(reflection));
    }

    @Test
    public void testNormalize() throws Exception {
        Vector vector = new Vector(3,5,6);
        Vector normalized = vector.normalize();
        assertTrue(normalized.length == 1);
    }
}