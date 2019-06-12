package labs.introtoprogramming.lab5.scene;

import labs.introtoprogramming.lab5.geometry.Vector3;

public abstract class Light extends SceneObject {

  private double intensity;

  public Light(Transform transform, double intensity) {
    super(transform);
    this.intensity = intensity;
  }

  public double intensity() {
    return intensity;
  }

  public abstract double illuminate(Vector3 normal, double distance);

  public abstract double getMaxDist(Vector3 point);
}
