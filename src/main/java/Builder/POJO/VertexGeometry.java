package Builder.POJO;

public class VertexGeometry {
    public float x = 0;
    public float y = 0;
    public float z = 0;

    public VertexGeometry(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Builder.POJO.VertexGeometry{" +
                "x :: " + x +
                ", y :: " + y +
                ", z :: " + z +
                '}';
    }
}
