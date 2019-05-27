package labs.introtoprogramming.lab5.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RayTests {
  private static final double DELTA = 1e-10;
  
  @Test
  public void testInstantiation() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT, 1);
    assertEquals(Vector3.ZERO, ray.getOrigin());
    assertEquals(Vector3.RIGHT, ray.getDirection());
    assertEquals(1, ray.getScale(), DELTA);
  }

  @Test
  public void testMultiplier() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.RIGHT);
    ray.setScale(10);
    assertEquals(10, ray.getScale(), DELTA);
  }

  @Test
  public void testGetPoint() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.ONE);
    ray.setScale(10);
    assertEquals(new Vector3(10, 10, 10), ray.getPoint());
  }

  @Test
  public void testSetDirection() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.ZERO);
    ray.setDirection(Vector3.ONE);
    assertEquals(Vector3.ONE, ray.getDirection());
  }
}
