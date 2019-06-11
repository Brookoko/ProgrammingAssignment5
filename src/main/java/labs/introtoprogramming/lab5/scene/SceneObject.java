package labs.introtoprogramming.lab5.scene;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.object.Box;

public class SceneObject {

  protected Transform transform;
  protected Mesh mesh;

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

  public Box getBoundary() {
    return null;
  }
}
