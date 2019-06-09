package labs.introtoprogramming.lab5.scene;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.gui.Input;

public class SceneObject {

  protected Transform transform;
  protected Mesh mesh;
  protected Input input;

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

  protected void update(int delta) {}

  public Transform getTransform() {
    return transform;
  }

  public Mesh getMesh() {
    return mesh;
  }

  public boolean intersect(Ray ray) {
    return false;
  }

  public void setInput(Input input) {
    this.input = input;
  }

  protected Input getInput() {
    return input;
  }
}
