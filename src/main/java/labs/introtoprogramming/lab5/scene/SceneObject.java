package labs.introtoprogramming.lab5.scene;

import java.awt.Color;
import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.object.Box;

public class SceneObject {

  private static double DEFAULT_ALBEDO = 0.18;

  protected Transform transform;
  protected Mesh mesh;
  protected double albedo = DEFAULT_ALBEDO;

  /**
   * Base class of scene objects.
   *
   * @param transform container of object transformations
   * @param mesh container of
   */
  public SceneObject(Transform transform, Mesh mesh) {
    this.transform = transform;
    this.mesh = mesh;
  }

  public SceneObject(Transform transform) {
    this(transform, new Mesh());
  }

  public SceneObject() {
    this(new Transform(), new Mesh());
  }

  public Transform getTransform() {
    return transform;
  }

  public Mesh getMesh() {
    return mesh;
  }

  public boolean intersect(Ray ray) {
    return false;
  }

  public Vector3 getNormal(Vector3 hitPoint) { return Vector3.ZERO; }

  public Box getBoundary() {
    return null;
  }

  public double albedo() {
    return albedo;
  }
}
