package labs.introtoprogramming.lab5.object.Builder.POJO;

import labs.introtoprogramming.lab5.geometry.Vector2;
import labs.introtoprogramming.lab5.geometry.Vector3;

/**
 * Class that describes structure of vertex.
 */
public class VertexFace {
    private int index = -1;
    private Vector3 vertexG = null;
    private Vector2 vertexT = null;
    private Vector3 vertexN = null;

    public void setIndex(int index) {
        this.index = index;
    }

    public void setVertexG(Vector3 vertexG) {
        this.vertexG = vertexG;
    }

    public void setVertexT(Vector2 vertexT) {
        this.vertexT = vertexT;
    }

    public void setVertexN(Vector3 vertexN) {
        this.vertexN = vertexN;
    }

    public int getIndex() {
        return index;
    }

    public Vector3 getVertexG() {
        return vertexG;
    }

    public Vector2 getVertexT() {
        return vertexT;
    }

    public Vector3 getVertexN() {
        return vertexN;
    }


    public String toString() {
        return vertexG + "|" + vertexN + "|" + vertexT;
    }
}
