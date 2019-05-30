package labs.introtoprogramming.lab5.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.Transform;
import org.junit.Test;

public class BoxTests {
  private static final double DELTA = 1e-10;

  @Test
  public void testIntersection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    Box box = new Box(new Transform(Vector3.RIGHT.multiply(2)),1);
    assertTrue(box.intersect(ray));
    assertEquals(1.5, ray.getScale(), DELTA);
  }

  @Test
  public void testIntersectionInner() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    Box box = new Box(new Transform(Vector3.ZERO), 1);
    assertTrue(box.intersect(ray));
    assertEquals(0.5, ray.getScale(), DELTA);
  }

  @Test
  public void testNoIntersectionUpAxis() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    Box box = new Box(new Transform(Vector3.ONE.multiply(2)), 1);
    assertFalse(box.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }

  @Test
  public void testNoIntersectionForwardAxis() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.FORWARD);
    Box box = new Box(new Transform(Vector3.ONE.multiply(2)), 1);
    assertFalse(box.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }


  @Test
  public void testIntersectionOppositeDirection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT.multiply(-1));
    Box box = new Box(new Transform(Vector3.RIGHT.multiply(2)), 1);
    assertFalse(box.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }

  @Test
  public void testIntersectionNegativeDirection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.ONE.multiply(-1));
    Box box = new Box(new Transform(Vector3.ONE.multiply(-2)),1);
    assertTrue(box.intersect(ray));
    assertEquals(1.5, ray.getScale(), DELTA);
  }

  @Test
  public void testIntersectionZeroDirection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.ZERO);
    Box box = new Box(new Transform(Vector3.RIGHT.multiply(2)),1);
    assertFalse(box.intersect(ray));
  }
}
