package labs.introtoprogramming.lab5.scene;

import static org.junit.Assert.assertEquals;

import labs.introtoprogramming.lab5.geometry.Vector3;
import org.junit.Test;

public class TransformTests {

  @Test
  public void testInstantiation() {
    Transform tran = new Transform(Vector3.ONE, Vector3.ONE.multiply(45));
    assertEquals(Vector3.ONE, tran.position());
    assertEquals(Vector3.ONE.multiply(45), tran.rotation());
    assertEquals(Vector3.ONE, tran.scale());
  }

  @Test
  public void testSetPosition() {
    Transform tran = new Transform(Vector3.ZERO);
    tran.setPosition(Vector3.ONE.multiply(5));
    assertEquals(new Vector3(5, 6, 5), tran.applyPoint(Vector3.UP));
    assertEquals(Vector3.UP, tran.applyVector(Vector3.UP));
  }

  @Test
  public void testSetRotation() {
    Transform tran = new Transform(Vector3.ZERO);
    tran.setRotation(new Vector3(0, 0, 90));
    assertEquals(Vector3.RIGHT, tran.applyVector(Vector3.UP));
  }

  @Test
  public void testSetScale() {
    Transform tran = new Transform(Vector3.ZERO);
    tran.setScale(Vector3.ONE.multiply(5));
    assertEquals(Vector3.UP.multiply(5), tran.applyVector(Vector3.UP));
  }

  @Test
  public void testSetMatrix() {
    Transform tran = new Transform();
    tran.setMatrix(Vector3.RIGHT.multiply(2), Vector3.UP,
            Vector3.FORWARD.multiply(-1), Vector3.ONE.multiply(5));
    assertEquals(new Vector3(7, 6, 4), tran.applyPoint(Vector3.ONE));
  }
}
