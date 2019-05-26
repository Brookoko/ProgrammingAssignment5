package labs.introtoprogramming.lab5.geometry;

public class Ray {
  private Vector3 origin;
  private Vector3 direction;
  private double t;

  public Ray(Vector3 origin, Vector3 direction, double t) {
    this.origin = origin;
    this.direction = direction;
    this.t = t;
  }

  public Ray(Vector3 origin, Vector3 direction) {
    this(origin, direction, 1);
  }

  public void setMultiplier(double t) {
    this.t = t;
  }

  public double getMultiplier() {
    return t;
  }

  public Vector3 getOrigin() {
    return origin;
  }

  public Vector3 getDirection() {
    return direction;
  }

  public Vector3 getPoint() {
    return origin.add(direction.multiply(t));
  }
}
