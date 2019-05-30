package labs.introtoprogramming.lab5.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.Transform;
import org.junit.Test;

public class DiskTests {
  private static final double DELTA = 1e-10;

  @Test
  public void testIntersection() {
    Disk disk = new Disk(new Transform(Vector3.ZERO));
    Ray ray = new Ray(Vector3.UP.multiply(-3), Vector3.UP.multiply(1));
    assertTrue(disk.intersect(ray));
    assertEquals(3, ray.getScale(), DELTA);
  }

  @Test
  public void testParallel() {
    Disk disk = new Disk(new Transform(Vector3.ZERO));
    Ray ray = new Ray(Vector3.ZERO, Vector3.FORWARD);
    assertFalse(disk.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }

  @Test
  public void testReverseToNormal() {
    Disk disk = new Disk(new Transform(Vector3.ZERO));
    Ray ray = new Ray(Vector3.UP.multiply(3), Vector3.UP.multiply(-1));
    assertFalse(disk.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }

  @Test
  public void testGreaterThanRadius() {
    Disk disk = new Disk(new Transform(Vector3.RIGHT), 0.5);
    Ray ray = new Ray(Vector3.UP.multiply(-3), Vector3.UP.multiply(1));
    assertFalse(disk.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }
}
