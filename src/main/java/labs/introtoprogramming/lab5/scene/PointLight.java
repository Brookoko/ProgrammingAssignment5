package labs.introtoprogramming.lab5.scene;

import labs.introtoprogramming.lab5.geometry.Vector3;

public class PointLight extends Light {
  public PointLight(Transform transform, double intensity) {
    super(transform, intensity);
  }

  @Override
  public double illuminate(Vector3 normal, double distance) {
    return Math.max((intensity() * normal.dotProduct(getTransform().rotation().multiply(-1))) / (4 * Math.PI * Math.pow(distance, 2)), 0);
  }

  @Override
  public double getMaxDist(Vector3 point) {
    return point.distance(transform.position());
  }
}
