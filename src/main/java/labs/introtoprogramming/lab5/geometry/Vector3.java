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
    return new Vector3(x / magnitude, y / magnitude, z / magnitude);
  }

  public double distance(Vector3 target) {
    double X = Math.pow(target.x - x, 2);
    double Y = Math.pow(target.y - y, 2);
    double Z = Math.pow(target.z - z, 2);
    return Math.sqrt(X + Y + Z);
  }

  public double dotProduct(Vector3 target) {
    return target.x * x + target.y * y + target.z * z;
  }

  public Vector3 multiply(double t) {
    return new Vector3(x * t, y * t, z * t);
  }

  public Vector3 subtract(Vector3 target) {
    return new Vector3(x - target.x, y - target.y, z - target.z);
  }

  public Vector3 add(Vector3 target) {
    return new Vector3(x + target.x, y + target.y, z + target.z);
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
