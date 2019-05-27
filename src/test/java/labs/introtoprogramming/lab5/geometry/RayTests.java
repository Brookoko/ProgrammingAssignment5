package labs.introtoprogramming.lab5.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RayTests {
  private static final double DELTA = 1e-10;
  
  @Test
  public void testInstantiation() {
    Ray ray = new Ray(Vector3.zero(), Vector3.right(), 1);
    assertEquals(Vector3.zero(), ray.getOrigin());
    assertEquals(Vector3.right(), ray.getDirection());
    assertEquals(1, ray.getMultiplier(), DELTA);
  }

  @Test
  public void testMultiplier() {
    Ray ray = new Ray(Vector3.zero(), Vector3.right());
    ray.setMultiplier(10);
    assertEquals(10, ray.getMultiplier(), DELTA);
  }

  @Test
  public void testGetPoint() {
    Ray ray = new Ray(Vector3.zero(), Vector3.one());
    ray.setMultiplier(10);
    assertEquals(new Vector3(10, 10, 10), ray.getPoint());
  }

  @Test
  public void testSetDirection() {
    Ray ray = new Ray(Vector3.zero(), Vector3.zero());
    ray.setDirection(Vector3.one());
    assertEquals(Vector3.one(), ray.getDirection());
  }
}
