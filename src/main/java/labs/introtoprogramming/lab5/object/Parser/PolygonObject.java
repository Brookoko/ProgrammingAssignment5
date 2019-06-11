package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.scene.SceneObject;

import java.util.ArrayList;
import java.util.List;

public class PolygonObject extends SceneObject {
    private List<Vertex> vertices = new ArrayList<>();
    private List<Polygon> polygons = new ArrayList<>();

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Polygon> getPolygons() {
        return polygons;
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public void addPolygon(Polygon polygon) {
        polygons.add(polygon);
    }
}
