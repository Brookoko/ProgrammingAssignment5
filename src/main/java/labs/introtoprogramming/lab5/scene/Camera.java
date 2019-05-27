package labs.introtoprogramming.lab5.scene;

public abstract class Camera extends SceneObject {
  private static final double DEFAULT_SIZE = 1;

  private double size;

  /**
   * Representation of camera.
   *
   * @param transform container of object transformations
   * @param size perspective size of camera (half of plane height at distance 1 from camera origin)
   */
  public Camera(Transform transform, double size) {
    super(transform);
    this.size = size;
  }

  public Camera(Transform transform) {
    this(transform, DEFAULT_SIZE);
  }

  public double size() {
    return size;
  }

  /**
   * Calculate camera field of view.
   * Assume that plane always at distance 1 and
   * size represents half of plane height
   * tangents of half of the field of view is equal to size
   *
   * @return field of view in radians
   */
  public double fieldOfView() {
    return 2 * Math.atan(size);
  }
}
