package labs.introtoprogramming.lab5.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

public class KDNodeTests {
  private static List<SceneObject> DUMMY_OBJECTS = Arrays.asList(
          new Box(new Transform(), Vector3.ONE, Vector3.ONE.multiply(-1)),
          new Triangle(new Transform(), Vector3.RIGHT, Vector3.RIGHT.multiply(-1), Vector3.UP),
          new Sphere(new Transform(), 1)
  );

  @Test
  public void testInstantiation() {
    KDNode node = new KDNode(Collections.emptyList(),
            new Box(new Transform(), Vector3.ZERO, Vector3.ZERO),
            new KDNode[0]);
    assertEquals(node.boundaryBox.upperBounds, Vector3.ZERO);
    assertEquals(node.boundaryBox.lowerBounds, Vector3.ZERO);
  }

  @Test
  public void testIntersectionNoObjects() {
    KDNode node = new KDNode(Collections.emptyList(),
            new Box(new Transform(), Vector3.ZERO, Vector3.ZERO),
            new KDNode[0]);
    assertNull(node.intersect(new Ray(Vector3.ZERO, Vector3.ZERO)));
  }

  @Test
  public void testIntersectionMissBox() {
    KDNode node = new KDNode(DUMMY_OBJECTS,
            new Box(new Transform(), Vector3.ONE.multiply(-1), Vector3.ZERO),
            new KDNode[0]);
    assertNull(node.intersect(new Ray(Vector3.FORWARD, Vector3.UP)));
  }

  @Test
  public void testIntersectionChildIntersection() {
    KDNode child = new KDNode(DUMMY_OBJECTS,
            new Box(new Transform(), Vector3.ONE.multiply(-5), Vector3.ONE.multiply(5)),
            new KDNode[0]);
    KDNode node = new KDNode(Collections.emptyList(),
            new Box(new Transform(), Vector3.ONE.multiply(-5), Vector3.ONE.multiply(5)),
            new KDNode[] { child });
    assertEquals(DUMMY_OBJECTS.get(2), node.intersect(new Ray(Vector3.FORWARD, Vector3.UP)));
  }

  @Test
  public void testIntersectionOwnObjectIntersection() {
    KDNode node = new KDNode(DUMMY_OBJECTS,
            new Box(new Transform(), Vector3.ONE.multiply(-5), Vector3.ONE.multiply(5)),
            new KDNode[0]);
    assertEquals(DUMMY_OBJECTS.get(2), node.intersect(new Ray(Vector3.FORWARD, Vector3.UP)));
  }
}
