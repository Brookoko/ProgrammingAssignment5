package labs.introtoprogramming.lab5.object;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.Transform;

public class Disk extends Plane {
  private static final double DEFAULT_SIZE = 1;

  private double radius;

  public Disk(Transform transform, double radius) {
    super(transform);
    this.radius = radius;
  }

  public Disk(Transform transform) {
    this(transform, DEFAULT_SIZE);
  }

  @Override
  public boolean intersect(Ray ray) {
    if (super.intersect(ray)) {
      Vector3 intersection = ray.getPoint();
      Vector3 direction = intersection.subtract(transform.position());
      double distance = direction.magnitudeSquared();
      return (distance <= radius * radius);
    }
    return false;
  }
}
