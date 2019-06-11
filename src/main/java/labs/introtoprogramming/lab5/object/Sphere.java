package labs.introtoprogramming.lab5.object;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.SceneObject;
import labs.introtoprogramming.lab5.scene.Transform;

public class Sphere extends SceneObject {

  private double radius;

  /**
   * Representation of spherical object.
   *
   * @param transform container of object transformations
   * @param radius size of sphere
   */
  public Sphere(Transform transform, double radius) {
    super(transform);
    this.radius = radius;
  }

  @SuppressWarnings("Duplicates")
  @Override
  public boolean intersect(Ray ray) {
    Vector3 originToCenter = transform.position().subtract(ray.getOrigin());
    double distToCenter = originToCenter.dotProduct(ray.getDirection());
    double sqrtDistToRay = originToCenter.magnitudeSquared() - distToCenter * distToCenter;
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
    ray.setScale(intersection);
    return true;
  }

  @Override
  public Box getBoundary() {
    Vector3 pos = transform.position();
    Vector3 size = Vector3.ONE.multiply(radius);
    return new Box(new Transform(), pos.subtract(size), pos.add(size));
  }

  public Vector3 getNormal(Vector3 hitPoint) {
    return hitPoint.subtract(transform.position()).normalize();
  }
}
