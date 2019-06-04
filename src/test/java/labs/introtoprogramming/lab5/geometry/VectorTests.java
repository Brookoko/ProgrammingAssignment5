package labs.introtoprogramming.lab5.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class VectorTests {
  private static final double DELTA = 1e-10;

  @Test
  public void testSqrtMagnitude() {
    Vector3 vector = Vector3.ONE;
    assertEquals(3, vector.magnitudeSquared(), DELTA);
  }

  @Test
  public void testMagnitude() {
    Vector3 vector = Vector3.RIGHT;
    assertEquals(1, vector.magnitude(), DELTA);
  }

  @Test
  public void testNormalize() {
    Vector3 a = new Vector3(2, 4, 4);
    assertEquals(new Vector3( 2.0 / 6, 4.0 / 6, 4.0 / 6), a.normalize());
  }

  @Test
  public void testNormalizeZeroVector() {
    Vector3 a = Vector3.ZERO;
    assertEquals(Vector3.ZERO, a.normalize());
  }

  @Test
  public void testDistance() {
    Vector3 from = Vector3.ZERO;
    Vector3 to = Vector3.RIGHT;
    assertEquals(1, from.distance(to), DELTA);
  }

  @Test
  public void testDistanceToSame() {
    Vector3 vector = Vector3.ONE;
    assertEquals(0, vector.distance(vector), DELTA);
  }

  @Test
  public void testDotProduct() {
    Vector3 a = Vector3.ONE;
    Vector3 b = Vector3.ONE.multiply(3);
    assertEquals(9, a.dotProduct(b), DELTA);
  }

  @Test
  public void testCrossProduct() {
    Vector3 a = Vector3.RIGHT;
    Vector3 b = Vector3.UP;
    assertEquals(Vector3.FORWARD, a.crossProduct(b));
  }

  @Test
  public void testMultiply() {
    Vector3 a = new Vector3(0, 1, 2);
    Vector3 res = a.multiply(3);
    assertEquals(new Vector3(0, 3, 6), res);
  }

  @Test
  public void testSubtract() {
    Vector3 a = new Vector3(3, 3, 3);
    Vector3 b = new Vector3(1, 2, 3);
    assertEquals(new Vector3(2, 1, 0), a.subtract(b));
  }

  @Test
  public void testAdd() {
    Vector3 a = new Vector3(3, 3, 3);
    Vector3 b = new Vector3(1, 2, 3);
    assertEquals(new Vector3(4, 5, 6), a.add(b));
  }

  @Test
  public void testEquals() {
    Vector3 a = Vector3.ONE;
    Vector3 b = Vector3.ONE;
    assertEquals(a, b);
  }

  @Test
  public void testEqualsSame() {
    Vector3 a = new Vector3(1, 1, 1);
    assertEquals(a, a);
  }

  @Test
  public void testEqualsNotVector() {
    Vector3 a = Vector3.ONE;
    Ray ray = new Ray(a, a);
    assertNotEquals(a, ray);
  }

  @Test
  public void testEqualsBiggerDeltaX() {
    Vector3 a = Vector3.ONE;
    Vector3 b = Vector3.ONE.add(Vector3.RIGHT.multiply(DELTA * 10));
    assertNotEquals(a, b);
  }

  @Test
  public void testEqualsBiggerDeltaY() {
    Vector3 a = Vector3.ONE;
    Vector3 b = Vector3.ONE.add(Vector3.UP.multiply(DELTA * 10));
    assertNotEquals(a, b);
  }

  @Test
  public void testEqualsBiggerDeltaZ() {
    Vector3 a = Vector3.ONE;
    Vector3 b = Vector3.ONE.add(Vector3.FORWARD.multiply(DELTA * 10));
    assertNotEquals(a, b);
  }

  @Test
  public void testHashCode() {
    Vector3 a = Vector3.ONE;
    assertEquals(3, a.hashCode(), DELTA);
  }
}
