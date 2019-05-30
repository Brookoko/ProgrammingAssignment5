package labs.introtoprogramming.lab5.object;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.Transform;
import org.junit.Test;

public class SphereTests {
  private static final double DELTA = 1e-10;

  @Test
  public void testIntersection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    Sphere sphere = new Sphere(new Transform(Vector3.RIGHT.multiply(2)), 1);
    assertTrue(sphere.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }

  @Test
  public void testIntersectionInner() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    Sphere sphere = new Sphere(new Transform(Vector3.ZERO), 1);
    assertTrue(sphere.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }

  @Test
  public void testNoIntersection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    Sphere sphere = new Sphere(new Transform(Vector3.ONE.multiply(2)), 1);
    assertFalse(sphere.intersect(ray));
    assertEquals(ray.getScale(), 1, DELTA);
  }

  @Test
  public void testIntersectionOppositeDirection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT.multiply(-1));
    Sphere sphere = new Sphere(new Transform(Vector3.RIGHT.multiply(2)), 1);
    assertFalse(sphere.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }
}
