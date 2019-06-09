package labs.introtoprogramming.lab5.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Matrix44Tests {

  @Test
  public void testSetMatrix() {
    Matrix44 matrix44 = new Matrix44();
    matrix44.setMatrix(Vector3.RIGHT.multiply(2), Vector3.UP,
            Vector3.FORWARD.multiply(-1), Vector3.ONE);
    Vector3 v = matrix44.applyPoint(Vector3.ONE);
    assertEquals(new Vector3(3, 2, 0), v);
  }

  @Test
  public void testApplyVector() {
    Matrix44 matrix44 = new Matrix44();
    matrix44.setMatrix(Vector3.RIGHT, Vector3.UP, Vector3.FORWARD, Vector3.ONE.multiply(100));
    Vector3 v = matrix44.applyVector(Vector3.ONE);
    assertEquals(Vector3.ONE, v);
  }

  @Test
  public void testApplyPoint() {
    Matrix44 matrix44 = new Matrix44();
    matrix44.setMatrix(Vector3.RIGHT, Vector3.UP, Vector3.FORWARD, Vector3.ONE);
    Vector3 v = matrix44.applyPoint(Vector3.ONE);
    assertEquals(Vector3.ONE.multiply(2), v);
  }

  @Test
  public void testGenerateTransformation() {
    Matrix44 matrix44 = new Matrix44();
    matrix44.generateTransformation(Vector3.ONE, new Vector3(0, 0, 90), Vector3.ONE.multiply(2));
    Vector3 v = matrix44.applyPoint(Vector3.ONE);
    System.out.println(v);
    assertEquals(new Vector3(2, 0, 3), v);
  }
}
