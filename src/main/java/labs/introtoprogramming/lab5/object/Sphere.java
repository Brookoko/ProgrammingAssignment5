package labs.introtoprogramming.lab5.object;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.SceneObject;
import labs.introtoprogramming.lab5.scene.Transform;

public class Sphere extends SceneObject {

  private double radius;

  public Sphere(Transform transform, double radius) {
    super(transform);
    this.radius = radius;
  }

  @Override
  public boolean intersect(Ray ray) {
    Vector3 originToCenter = transform.position().subtract(ray.getOrigin());
    double distToCenter = originToCenter.dotProduct(ray.getDirection());
    double sqrtDistToRay = originToCenter.sqrtMagnitude() - distToCenter * distToCenter;
    if (sqrtDistToRay > radius * radius) {
      return false;
    }
    double distFromCenterToIntersection = Math.sqrt(
            radius * radius - sqrtDistToRay);
    double firstIntersection = distToCenter - distFromCenterToIntersection;
    double secondIntersection = distToCenter + distFromCenterToIntersection;
    double intersection;
    if (firstIntersection < 0) {
      if (secondIntersection < 0) {
        return false;
      }
      intersection = secondIntersection;
    } else {
      if (firstIntersection > secondIntersection) {
        intersection = secondIntersection;
      } else {
        intersection = firstIntersection;
      }
    }
    ray.setMultiplier(intersection);
    return true;
  }
}
