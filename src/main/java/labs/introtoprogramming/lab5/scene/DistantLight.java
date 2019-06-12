package labs.introtoprogramming.lab5.scene;

import java.awt.Color;
import labs.introtoprogramming.lab5.geometry.Vector3;

public class DistantLight extends Light {

  Vector3 direction;

  public DistantLight(Transform transform, double intensity) {
    super(transform, intensity);
  }

  @Override
  public double illuminate(Vector3 normal, double distance) {
    return Math.max(intensity() * normal.dotProduct(getTransform().applyVector(Vector3.FORWARD.multiply(1)).normalize()), 0);
  }

  public double getMaxDist(Vector3 point) {
    return Double.POSITIVE_INFINITY;
  }
}
