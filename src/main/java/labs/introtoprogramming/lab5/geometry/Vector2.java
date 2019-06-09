package labs.introtoprogramming.lab5.geometry;

public class Vector2 implements Cloneable {
    private static final double COORDINATES_PRECISION = 1e-10;

    public static final Vector2 ZERO = new Vector2(0, 0);
    public static final Vector2 RIGHT = new Vector2(1, 0);
    public static final Vector2 UP = new Vector2(0, 1);
    public static final Vector2 ONE = new Vector2(1, 1);

    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public Vector2(Vector2 v) {
        x = v.x;
        y = v.y;
    }

    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }

    public double magnitudeSquared() {
        return x * x + y * y ;
    }

    public Vector2 normalize() {
        double magnitude = magnitude();
        if (magnitude > 0) {
            double inverseMagnitude = 1 / magnitude;
            return multiply(inverseMagnitude);
        }
        return multiply(1);
    }

    public double distance(Vector2 v) {
        return subtract(v).magnitude();
    }

    public double dotProduct(Vector2 v) {
        return v.x * x + v.y * y;
    }


    public Vector2 multiply(double t) {
        return new Vector2(x * t, y * t);
    }

    public Vector2 subtract(Vector2 v) {
        return new Vector2(x - v.x, y - v.y);
    }

    public Vector2 add(Vector2 v) {
        return new Vector2(x + v.x, y + v.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector2)) return false;
        if (obj == this) return true;
        Vector2 vector = (Vector2) obj;
        return Math.abs(vector.x - x) < COORDINATES_PRECISION &&
                Math.abs(vector.y - y) < COORDINATES_PRECISION;
    }

    @Override
    public int hashCode() {
        return (int) (x + y);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
