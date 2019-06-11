package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.geometry.Vector3;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private List<Vertex> vertices = new ArrayList<>();
    private Vector3 polygonNormal;

    public List<Vertex> getVertecies() {
        return vertices;
    }

    public void setVertecies(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public Vector3 getPolygonNormal() {
        return polygonNormal;
    }

    public void calculatePolygonNormalTriangle() {
        if (vertices.size() == 3) {

            Vector3 fromOneToTwo = vertices.get(0).getVertexG().subtract(vertices.get(1).getVertexG());
            Vector3 fromOneToThree = vertices.get(0).getVertexG().subtract(vertices.get(2).getVertexG());
            polygonNormal = fromOneToTwo.crossProduct(fromOneToThree);
        }
    }

    public void setPolygonNormal(Vector3 polygonNormal) {
        this.polygonNormal = polygonNormal;
    }
}