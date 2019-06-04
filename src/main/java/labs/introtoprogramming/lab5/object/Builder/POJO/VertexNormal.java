package labs.introtoprogramming.lab5.object.Builder.POJO;

public class VertexNormal {
    private float x = 0;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    private float y = 0;
    private float z = 0;



    public void add(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public VertexNormal(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        if(null == this)
            return "null";
        else
            return x+","+y+","+z;
    }
}
