package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.geometry.Vector3;

import java.util.ArrayList;

public class PolygonObject {
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private Vector3 polygonNormal;

    public ArrayList<Vertex> getVertecies() {
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

    public void setPolygonNormal(Vector3 polygonNormal) {
        this.polygonNormal = polygonNormal;
    }
}