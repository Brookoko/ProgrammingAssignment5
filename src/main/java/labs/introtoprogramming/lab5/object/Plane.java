package labs.introtoprogramming.lab5.object;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.SceneObject;
import labs.introtoprogramming.lab5.scene.Transform;

public class Plane extends SceneObject {
  private static final double DELTA = 1e-10;

  public Plane(Transform transform) {
    super(transform);
  }

  @Override
  public boolean intersect(Ray ray) {
    Vector3 origin = transform.position();
    Vector3 normal = transform.applyVector(Vector3.UP);
    double angle = normal.dotProduct(ray.getDirection());
    if (angle > DELTA) {
      Vector3 direction = origin.subtract(ray.getOrigin());
      double scale = direction.dotProduct(normal) / angle;
      if (scale >= 0) {
        ray.setScale(scale);
        return true;
      }
      return false;
    }
    return false;
  }
}
