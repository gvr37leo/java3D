package tests;

import main.Camera;
import main.Vector;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CameraTest {

    Camera camera;

    @Before
    public void setUp() throws Exception {
        camera = new Camera();
    }

    @Test
    public void testGenerateImage() throws Exception {

    }

    @Test
    public void testGenerateCameraRay() throws Exception {
        Vector topLeft = camera.generateCameraRay(0,0);
        Vector middle = camera.generateCameraRay(20,20);

        assertTrue(topLeft.normalize().equals(new Vector(-1,1,1).normalize()));
        assertTrue(middle.normalize().equals(new Vector(0,0,1).normalize()));
    }
}