package Tests;

import static org.junit.Assert.*;
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

    @org.junit.Test
    public void testSubtract() throws Exception {
        Vector C = new Vector(0,10,0);
        assertTrue(B.subtract(A).equals(C));// check if subtraction works correctly
        assertTrue(new Vector(0,10,0).equals(C));//check if itself hasn't changed
    }

    @org.junit.Test
    public void testAdd() throws Exception {
        Vector C = new Vector(0,10,20);
        assertTrue(B.add(A).equals(C));// check if subtraction works correctly
        assertTrue(new Vector(0,10,20).equals(C));//check if itself hasn't changed
    }

    @org.junit.Test
    public void testScale() throws Exception {
        assertTrue(A.scale(10).equals(new Vector(0,0,100)));// check if scaling went correctly
        assertTrue(new Vector(0,0,10).equals(A));//check if itself hasn't changed
    }

    @org.junit.Test
    public void testDot() throws Exception {

    }

    @org.junit.Test
    public void testCross() throws Exception {

    }

    @org.junit.Test
    public void testCalcLength() throws Exception {

    }

    @org.junit.Test
    public void testCalcAngle() throws Exception {

    }

    @org.junit.Test
    public void testCalcNormal() throws Exception {

    }

    @org.junit.Test
    public void testIsInTriangle() throws Exception {

    }

    @org.junit.Test
    public void testRotate() throws Exception {

    }

    @org.junit.Test
    public void testRotateX() throws Exception {

    }

    @org.junit.Test
    public void testRotateY() throws Exception {

    }

    @org.junit.Test
    public void testRotateZ() throws Exception {

    }

    @org.junit.Test
    public void testCastRay() throws Exception {

    }

    @org.junit.Test
    public void testProject() throws Exception {
        Vector C = new Vector(0,20,20);
        assertTrue(A.project(C).equals(new Vector(0,0,20)));//check if C was properly projected onto A
        assertTrue(A.equals(new Vector(0,0,10)));//check if A hasn't changed
    }
}