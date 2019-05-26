package labs.introtoprogramming.lab5.scene;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;

public class SceneObject {

  protected Transform transform;
  protected Mesh mesh;

  public SceneObject(Transform transform, Mesh mesh) {
    this.transform = transform;
    this.mesh = mesh;
  }

  public SceneObject(Transform transform) {
    this(transform, new Mesh());
  }

  public SceneObject(Vector3 position) {
    this(new Transform(position), new Mesh());
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
}
