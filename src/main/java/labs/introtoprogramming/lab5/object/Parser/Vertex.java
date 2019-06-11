package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.geometry.Vector3;

public class Vertex {
    /**
     * Vertex parameters: geometry coordinates and coordinates of normals
     */
    private Vector3 vertexG = null;
    private Vector3 vertexN = null;

    public void setVertexG(Vector3 vertexG) {
        this.vertexG = vertexG;
    }

    public void setVertexN(Vector3 vertexN) {
        this.vertexN = vertexN;
    }

    public Vector3 getVertexG() {
        return vertexG;
    }

    public Vector3 getVertexN() {
        return vertexN;
    }

    public String toString() {
        return vertexG + "|" + vertexN;
    }
}
