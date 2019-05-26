package labs.introtoprogramming.lab5.scene;

public abstract class Camera extends SceneObject {
  private double size;

  public Camera(Transform transform, double size) {
    super(transform);
    this.size = size;
  }

  public Camera(Transform transform) {
    this(transform, 1);
  }

  public double size() {
    return size;
  }

  public double fieldOfView() {
    return 2 * Math.atan(size);
  }
}
