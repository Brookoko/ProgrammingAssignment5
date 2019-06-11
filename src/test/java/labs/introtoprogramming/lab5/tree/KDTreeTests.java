package labs.introtoprogramming.lab5.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.object.Box;
import labs.introtoprogramming.lab5.object.Disk;
import labs.introtoprogramming.lab5.object.Plane;
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

  private static List<SceneObject> DUMMY_TRIANGLES = Arrays.asList(
          new Triangle(new Transform(Vector3.FORWARD.multiply(-3)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-16)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-9)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.ONE.multiply(-10)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.ONE.multiply(-8)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-10).add(Vector3.UP)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-10).add(Vector3.UP.multiply(3))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-10).add(Vector3.UP.multiply(-3))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-10).add(Vector3.UP.multiply(-1))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-9)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-15)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-18)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.ONE.multiply(-9)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.ONE.multiply(-11)), Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12).add(Vector3.UP.multiply(3))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12).add(Vector3.UP.multiply(-3))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12).add(Vector3.UP.multiply(-1))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12).add(Vector3.UP.multiply(-1))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12).add(Vector3.UP.multiply(-1))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12).add(Vector3.UP.multiply(-1))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12).add(Vector3.UP.multiply(-1))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12).add(Vector3.UP.multiply(-1))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12).add(Vector3.UP.multiply(-1))),
                  Vector3.RIGHT, Vector3.UP, Vector3.RIGHT.multiply(-1)),
          new Triangle(new Transform(Vector3.FORWARD.multiply(-12).add(Vector3.UP)), Vector3.RIGHT,
                  Vector3.UP, Vector3.RIGHT.multiply(-1))
  );

  private static List<SceneObject> DUMMY_OBJECTS_WITHOUT_BOUNDARY = Arrays.asList(
          new Plane(new Transform()),
          new Disk(new Transform(Vector3.ONE.multiply(-50))),
          new Plane(new Transform(Vector3.ONE.multiply(100))),
          new Disk(new Transform(Vector3.ONE.multiply(50)))
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
  public void testIntersection() {
    KDTree tree = new KDTree(new ArrayList<>(DUMMY_OBJECTS));
    assertTrue(tree.intersect(new Ray(Vector3.ZERO, Vector3.FORWARD)));
    assertEquals(DUMMY_OBJECTS.get(1), tree.getIntersection());
  }

  @Test
  public void testBuild() {
    KDTree tree = new KDTree(new ArrayList<>(DUMMY_TRIANGLES));
    assertTrue(tree.intersect(new Ray(Vector3.FORWARD, Vector3.FORWARD.multiply(-1))));
    assertEquals(DUMMY_TRIANGLES.get(0), tree.getIntersection());
  }

  @Test
  public void testBuildObjectWithoutBoundary() {
    KDTree tree = new KDTree(new ArrayList<>(DUMMY_OBJECTS_WITHOUT_BOUNDARY));
    Box boundary = tree.boundary();
    assertEquals(Vector3.ONE.multiply(Double.MAX_VALUE), boundary.upperBounds);
    assertEquals(Vector3.ONE.multiply(Double.MIN_VALUE), boundary.lowerBounds);
    assertTrue(tree.intersect(new Ray(Vector3.UP.multiply(-2), Vector3.UP.multiply(1))));
    assertEquals(DUMMY_OBJECTS_WITHOUT_BOUNDARY.get(0), tree.getIntersection());
  }
}
