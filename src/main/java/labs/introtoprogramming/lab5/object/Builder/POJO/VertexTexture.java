package labs.introtoprogramming.lab5.object.Builder.POJO;

public class VertexTexture {
    public float u = 0;
    public float v = 0;

    public VertexTexture(float u, float v) {
        this.u = u;
        this.v = v;
    }

    public String toString() {
        if (null == this) {
            return "null";
        } else {
            return u + "," + v;
        }
    }
}
