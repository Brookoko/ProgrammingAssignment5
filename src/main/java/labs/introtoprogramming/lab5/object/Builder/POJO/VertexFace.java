package labs.introtoprogramming.lab5.object.Builder.POJO;

public class VertexFace {
    public int index = -1;
    public VertexGeometry vertexG = null;
    public VertexTexture vertexT = null;
    public VertexNormal vertexN = null;

    public String toString() {
        return vertexG + "|" + vertexN + "|" + vertexT;
    }
}
