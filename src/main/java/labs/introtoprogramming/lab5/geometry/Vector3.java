package labs.introtoprogramming.lab5.geometry;

public class Vector3 {

  private final double x;
  private final double y;
  private final double z;

  public Vector3(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public double magnitude() {
    return Math.sqrt(sqrtMagnitude());
  }

  public double sqrtMagnitude() {
    return x * x + y * y + z * z;
  }

  public Vector3 normalize() {
    double magnitude = magnitude();
    if (magnitude > 0) {
      double inverseMagnitude = 1 / magnitude;
      return multiply(inverseMagnitude);
    }
    return multiply(1);
  }

  public double distance(Vector3 v) {
    return new Vector3(
            v.x - x,
            v.y - y,
            v.z - z
    ).magnitude();
  }

  public double dotProduct(Vector3 v) {
    return v.x * x + v.y * y + v.z * z;
  }

  public Vector3 crossProduct(Vector3 v) {
    return new Vector3(
            y * v.z - z * v.y,
            z * v.x - x * v.z,
            x * v.y - y * v.x
    );
  }

  public Vector3 multiply(double t) {
    return new Vector3(x * t, y * t, z * t);
  }

  public Vector3 subtract(Vector3 v) {
    return new Vector3(x - v.x, y - v.y, z - v.z);
  }

  public Vector3 add(Vector3 v) {
    return new Vector3(x + v.x, y + v.y, z + v.z);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Vector3)) return false;
    if (obj == this) return true;
    Vector3 vector = (Vector3) obj;
    return Math.abs(vector.x - x) < 1e-10 &&
            Math.abs(vector.y - y) < 1e-10 &&
            Math.abs(vector.z - z) < 1e-10;
  }

  @Override
  public int hashCode() {
    return (int) (x + y + z);
  }

  public static Vector3 zero() {
    return new Vector3(0, 0, 0);
  }

  public static Vector3 right() {
    return new Vector3(1, 0, 0);
  }

  public static Vector3 up() {
    return new Vector3(0, 1, 0);
  }

  public static Vector3 forward() {
    return new Vector3(0, 0, 1);
  }

  public static Vector3 one() {
    return new Vector3(1, 1, 1);
  }
}
