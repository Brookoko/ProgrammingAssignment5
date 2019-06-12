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
    System.out.println(normal);
    System.out.println(getTransform().rotation().multiply(-1));
    System.out.println(normal.dotProduct(getTransform().rotation().multiply(-1)));
    return Math.max(intensity() * normal.dotProduct(getTransform().rotation().multiply(-1)), 0);
  }

  public double getMaxDist(Vector3 point) {
    return Double.POSITIVE_INFINITY;
  }
}
