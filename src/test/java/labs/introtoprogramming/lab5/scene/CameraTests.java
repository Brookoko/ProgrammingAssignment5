package labs.introtoprogramming.lab5.scene;

import static org.junit.Assert.assertEquals;

import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.graphics.BufferedImageRaster;
import labs.introtoprogramming.lab5.graphics.Raster;
import org.junit.Test;

public class CameraTests {
  private static final double DELTA = 1e-6;
  private static final Raster DUMMY_RASTER = new BufferedImageRaster(600, 400);

  @Test
  public void testInstantiation() {
    Camera cam = new Camera(DUMMY_RASTER, new Transform(Vector3.ZERO));
    assertEquals(cam.size(), 1, DELTA);
    assertEquals(cam.fieldOfView(), 2 * Math.atan(1), DELTA);
    assertEquals(cam.aspectRatio(), 600.0 / 400.0, DELTA);
    assertEquals(DUMMY_RASTER, cam.raster());
  }

  @Test
  public void testSize() {
    Camera cam = new Camera(DUMMY_RASTER, new Transform(Vector3.ZERO), 100);
    assertEquals(cam.size(), 100, DELTA);
  }

  @Test
  public void testAspectRatio() {
    Camera cam = new Camera(new BufferedImageRaster(1000, 1), new Transform(Vector3.ZERO));
    assertEquals(cam.aspectRatio(), 1000, DELTA);
  }

  @Test
  public void testFieldOfView() {
    Camera cam = new Camera(DUMMY_RASTER, new Transform(Vector3.ZERO), 10);
    assertEquals(cam.fieldOfView(), 2.94225535, DELTA);
  }

  @Test
  public void testLookAt() {
    Camera cam = new Camera(DUMMY_RASTER, new Transform(Vector3.ZERO), 10);
    cam.lookAt(Vector3.UP.multiply(10), Vector3.ONE.multiply(5));
    Vector3 res = cam.transform.applyPoint(Vector3.ONE);
    assertEquals(new Vector3(-0.82136720504, 11.2440169359, 0.3333333333), res);
  }
}
