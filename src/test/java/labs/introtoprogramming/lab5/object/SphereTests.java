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
    Ray ray = new Ray(Vector3.zero(), Vector3.right());
    Sphere sphere = new Sphere(new Transform(Vector3.right().multiply(2)), 1);
    assertTrue(sphere.intersect(ray));
    assertEquals(ray.getMultiplier(), 1, DELTA);
  }

  @Test
  public void testIntersectionInner() {
    Ray ray = new Ray(Vector3.zero(), Vector3.right());
    Sphere sphere = new Sphere(new Transform(Vector3.zero()), 1);
    assertTrue(sphere.intersect(ray));
    assertEquals(ray.getMultiplier(), 1, DELTA);
  }

  @Test
  public void testNoIntersection() {
    Ray ray = new Ray(Vector3.zero(), Vector3.right());
    Sphere sphere = new Sphere(new Transform(Vector3.one().multiply(2)), 1);
    assertFalse(sphere.intersect(ray));
    assertEquals(ray.getMultiplier(), 1, DELTA);
  }

  @Test
  public void testIntersectionOppositeDirection() {
    Ray ray = new Ray(Vector3.zero(), Vector3.right().multiply(-1));
    Sphere sphere = new Sphere(new Transform(Vector3.right().multiply(2)), 1);
    assertFalse(sphere.intersect(ray));
    assertEquals(ray.getMultiplier(), 1, DELTA);
  }
}
