package labs.introtoprogramming.lab5.object.Builder.POJO;

/**
 *
 */

public class VertexTexture {
    private float u = 0;
    private float v = 0;

    public float getU() {
        return u;
    }

    public void setU(float u) {
        this.u = u;
    }

    public float getV() {
        return v;
    }

    public void setV(float v) {
        this.v = v;
    }

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
