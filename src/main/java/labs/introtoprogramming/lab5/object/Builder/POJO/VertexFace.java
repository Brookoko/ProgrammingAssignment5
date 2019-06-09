package labs.introtoprogramming.lab5.object.Builder.POJO;

/**
 * Class that describes structure of vertex.
 */
public class VertexFace {
    private int index = -1;
    private VertexGeometry vertexG = null;
    private VertexTexture vertexT = null;
    private VertexNormal vertexN = null;

    public void setIndex(int index) {
        this.index = index;
    }

    public void setVertexG(VertexGeometry vertexG) {
        this.vertexG = vertexG;
    }

    public void setVertexT(VertexTexture vertexT) {
        this.vertexT = vertexT;
    }

    public void setVertexN(VertexNormal vertexN) {
        this.vertexN = vertexN;
    }

    public int getIndex() {
        return index;
    }

    public VertexGeometry getVertexG() {
        return vertexG;
    }

    public VertexTexture getVertexT() {
        return vertexT;
    }

    public VertexNormal getVertexN() {
        return vertexN;
    }


    public String toString() {
        return vertexG + "|" + vertexN + "|" + vertexT;
    }
}
