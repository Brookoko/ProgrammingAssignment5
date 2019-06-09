package labs.introtoprogramming.lab5.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.Transform;
import org.junit.Test;

public class TriangleTests {
  private static final double DELTA = 1e-10;

  @Test
  public void testIntersection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    Triangle triangle = new Triangle(new Transform(Vector3.RIGHT.multiply(2)),
            Vector3.FORWARD, Vector3.UP, Vector3.FORWARD.multiply(-1));
    assertTrue(triangle.intersect(ray));
    assertEquals(2, ray.getScale(), DELTA);
  }

  @Test
  public void testNoIntersection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    Triangle triangle = new Triangle(new Transform(Vector3.UP.multiply(10)),
            Vector3.FORWARD, Vector3.UP, Vector3.FORWARD.multiply(-1));
    assertFalse(triangle.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }

  @Test
  public void testNoIntersectionParallel() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    Triangle triangle = new Triangle(new Transform(Vector3.RIGHT.multiply(10)),
            Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1));
    assertFalse(triangle.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }

  @Test
  public void testOutOfBoundNoIntersection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    Triangle triangle = new Triangle(new Transform(Vector3.RIGHT.multiply(2)),
            Vector3.FORWARD.multiply(-1), Vector3.ONE, Vector3.UP.multiply(1));
    assertFalse(triangle.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }
}
