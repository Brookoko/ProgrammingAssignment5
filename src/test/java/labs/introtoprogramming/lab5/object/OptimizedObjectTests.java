package labs.introtoprogramming.lab5.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.SceneObject;
import labs.introtoprogramming.lab5.scene.Transform;
import org.junit.Test;

public class OptimizedObjectTests {
  private static final double DELTA = 1e-10;

  private static List<SceneObject> DUMMY_OBJECTS = Arrays.asList(
          new Box(new Transform(), Vector3.ONE.multiply(-5), Vector3.ONE.multiply(5)),
          new Triangle(new Transform(), Vector3.RIGHT, Vector3.RIGHT.multiply(-1), Vector3.UP),
          new Sphere(new Transform(), 1)
  );

  @Test
  public void testInstantiation() {
    OptimizedObject obj = new OptimizedObject(new Transform(), DUMMY_OBJECTS);
    Box boundary = obj.getBoundary();
    Box expected = DUMMY_OBJECTS.get(0).getBoundary();
    assertEquals(expected.lowerBounds, boundary.lowerBounds);
    assertEquals(expected.upperBounds, boundary.upperBounds);
  }

  @Test
  public void testIntersection() {
    OptimizedObject obj = new OptimizedObject(new Transform(), DUMMY_OBJECTS);
    Ray ray = new Ray(Vector3.FORWARD.multiply(2), Vector3.FORWARD.multiply(-1));
    assertTrue(obj.intersect(ray));
    assertEquals(1, ray.getScale(), DELTA);
  }
}
