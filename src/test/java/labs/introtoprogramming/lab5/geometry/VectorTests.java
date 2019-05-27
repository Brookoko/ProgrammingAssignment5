package labs.introtoprogramming.lab5.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class VectorTests {
  private static final double DELTA = 1e-10;

  @Test
  public void testSqrtMagnitude() {
    Vector3 vector = Vector3.one();
    assertEquals(3, vector.sqrtMagnitude(), DELTA);
  }

  @Test
  public void testMagnitude() {
    Vector3 vector = Vector3.right();
    assertEquals(1, vector.magnitude(), DELTA);
  }

  @Test
  public void testNormalize() {
    Vector3 a = new Vector3(2, 4, 4);
    assertEquals(new Vector3( 2. / 6, 4. / 6, 4. / 6), a.normalize());
  }

  @Test
  public void testNormalizeZeroVector() {
    Vector3 a = Vector3.zero();
    assertEquals(Vector3.zero(), a.normalize());
  }

  @Test
  public void testDistance() {
    Vector3 from = Vector3.zero();
    Vector3 to = Vector3.right();
    assertEquals(1, from.distance(to), DELTA);
  }

  @Test
  public void testDistanceToSame() {
    Vector3 vector = Vector3.one();
    assertEquals(0, vector.distance(vector), DELTA);
  }

  @Test
  public void testDotProduct() {
    Vector3 a = Vector3.one();
    Vector3 b = Vector3.one().multiply(3);
    assertEquals(9, a.dotProduct(b), DELTA);
  }

  @Test
  public void testCrossProduct() {
    Vector3 a = Vector3.right();
    Vector3 b = Vector3.up();
    assertEquals(Vector3.forward(), a.crossProduct(b));
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
    Vector3 a = Vector3.one();
    Vector3 b = Vector3.one();
    assertEquals(a, b);
  }

  @Test
  public void testEqualsSame() {
    Vector3 a = new Vector3(1, 1, 1);
    assertEquals(a, a);
  }

  @Test
  public void testEqualsNotVector() {
    Vector3 a = Vector3.one();
    Ray ray = new Ray(a, a);
    assertNotEquals(a, ray);
  }

  @Test
  public void testEqualsBiggerDelta() {
    Vector3 a = Vector3.one();
    Vector3 b = Vector3.one().add(Vector3.one().multiply(DELTA * 10));
    assertNotEquals(a, b);
  }

  @Test
  public void testHashCode() {
    Vector3 a = Vector3.one();
    assertEquals(3, a.hashCode(), DELTA);
  }
}
