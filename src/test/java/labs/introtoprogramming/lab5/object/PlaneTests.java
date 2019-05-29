package labs.introtoprogramming.lab5.object;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.Transform;
import org.junit.Test;

public class PlaneTests {

  @Test
  public void testIntersection() {
    Plane plane = new Plane(new Transform(Vector3.ZERO));
    Ray ray = new Ray(Vector3.UP.multiply(-3), Vector3.UP.multiply(1));
    assertTrue(plane.intersect(ray));
  }

  @Test
  public void testParallel() {
    Plane plane = new Plane(new Transform(Vector3.ZERO));
    Ray ray = new Ray(Vector3.ZERO, Vector3.FORWARD);
    assertFalse(plane.intersect(ray));
  }

  @Test
  public void testReverseToNormal() {
    Plane plane = new Plane(new Transform(Vector3.ZERO));
    Ray ray = new Ray(Vector3.UP.multiply(3), Vector3.UP.multiply(-1));
    assertFalse(plane.intersect(ray));
  }
}
