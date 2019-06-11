package labs.introtoprogramming.lab5.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.object.Box;
import labs.introtoprogramming.lab5.object.Sphere;
import labs.introtoprogramming.lab5.object.Triangle;
import labs.introtoprogramming.lab5.scene.SceneObject;
import labs.introtoprogramming.lab5.scene.Transform;
import org.junit.Test;


public class KDTreeTests {

  private static List<SceneObject> DUMMY_OBJECTS = Arrays.asList(
          new Box(new Transform(), Vector3.ONE.multiply(-3), Vector3.ONE.multiply(3)),
          new Triangle(new Transform(), Vector3.RIGHT, Vector3.RIGHT.multiply(-1), Vector3.UP),
          new Sphere(new Transform(), 1)
  );

  @Test
  public void testInstantiation() {
    KDTree tree = new KDTree(DUMMY_OBJECTS);
    Box boundary = tree.boundary();
    assertEquals(boundary.lowerBounds, DUMMY_OBJECTS.get(0).getBoundary().lowerBounds);
    assertEquals(boundary.upperBounds, DUMMY_OBJECTS.get(0).getBoundary().upperBounds);
  }

  @Test
  public void testEmptyList() {
    KDTree tree = new KDTree(Collections.emptyList());
    assertFalse(tree.intersect(new Ray(Vector3.ZERO, Vector3.ZERO)));
    assertNull(tree.getIntersection());
  }

  @Test
  public void test() {
    KDTree tree = new KDTree(DUMMY_OBJECTS);
    assertTrue(tree.intersect(new Ray(Vector3.ZERO, Vector3.FORWARD)));
    assertEquals(DUMMY_OBJECTS.get(1), tree.getIntersection());
  }
}
