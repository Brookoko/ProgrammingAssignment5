package labs.introtoprogramming.lab5.object;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.SceneObject;
import labs.introtoprogramming.lab5.scene.Transform;

public class Box extends SceneObject {
  private static final double DELTA = 1e-10;
  private static final double DEFAULT_SIZE = 1;

  private Vector3 lowerBounds;
  private Vector3 upperBounds;

  public Box(Transform transform, double size) {
    super(transform);
    Vector3 pos = transform.position();
    Vector3 bound = Vector3.ONE.multiply(size * 0.5);
    upperBounds = pos.add(bound);
    lowerBounds = pos.add(bound.multiply(-size));
  }

  public Box(Transform transform) {
    this(transform, DEFAULT_SIZE);
  }

  @Override
  public boolean intersect(Ray ray) {
    Vector3 direction = ray.getDirection();
    Vector3 origin = ray.getOrigin();
    double tMin, tMax, tyMin, tyMax, tzMin, tzMax;
    double x = Math.abs(direction.x) < DELTA ?
            direction.x >= 0 ? 1 / DELTA : -1 / DELTA : 1 / direction.x;
    double y = Math.abs(direction.y) < DELTA ?
            direction.y >= 0 ? 1 / DELTA : -1 / DELTA : 1 / direction.y;
    double z = Math.abs(direction.z) < DELTA ?
            direction.z >= 0 ? 1 / DELTA : -1 / DELTA : 1 / direction.z;

    if (direction.x >= 0) {
      tMin = (lowerBounds.x - origin.x) * x;
      tMax = (upperBounds.x - origin.x) * x;
    } else {
      tMin = (upperBounds.x - origin.x) * x;
      tMax = (lowerBounds.x - origin.x) * x;
    }

    if (direction.y >= 0) {
      tyMin = (lowerBounds.y - origin.y) * y;
      tyMax = (upperBounds.y - origin.y) * y;
    } else {
      tyMin = (upperBounds.y - origin.y) * y;
      tyMax = (lowerBounds.y - origin.y) * y;
    }

    if (tMin > tyMax || tyMin > tMax) {
      return  false;
    }
    tMin = Math.max(tyMin, tMin);
    tMax = Math.min(tyMax, tMax);

    if (direction.z >= 0) {
      tzMin = (lowerBounds.z - origin.z) * z;
      tzMax = (upperBounds.z - origin.z) * z;
    } else {
      tzMin = (upperBounds.z - origin.z) * z;
      tzMax = (lowerBounds.z - origin.z) * z;
    }

    if (tMin > tzMax || tzMin > tMax) {
      return  false;
    }

    tMin = Math.max(tzMin, tMin);
    tMax = Math.min(tzMax, tMax);

    double t;
    if (tMin < 0) {
      if (tMax < 0) {
        return false;
      }
      t = tMax;
    } else {
      if (tMin > tMax) {
        t = tMax;
      } else {
        t = tMin;
      }
    }

    ray.setScale(t);
    return true;
  }
}
