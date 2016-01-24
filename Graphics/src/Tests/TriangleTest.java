package tests;

import main.Triangle;
import main.Vector;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    public Triangle triangle;

    @Before
    public void setUp() throws Exception {
        Vector A = new Vector(0,10,0);
        Vector B = new Vector(10,0,0);
        Vector C = new Vector(-10,0,0);
        triangle = new Triangle(A,B,C);
    }

    @Test
    public void testGetTriangleArea() throws Exception {

    }

    @Test
    public void testRotate() throws Exception {

    }

    @Test
    public void testTranslate() throws Exception {

    }

    @Test
    public void testGetIntersect() throws Exception {

    }

    @Test
    public void testIsInTriangle() throws Exception {
        Vector A = new Vector(0,5,0);
        Vector B = new Vector(0,11,0);
        assertTrue(triangle.isInTriangle(A));
        assertFalse(triangle.isInTriangle(B));
    }
}