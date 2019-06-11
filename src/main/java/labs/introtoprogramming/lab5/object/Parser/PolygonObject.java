package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.scene.SceneObject;

import java.util.ArrayList;

public class PolygonObject extends SceneObject {
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private ArrayList<Polygon> polygons = new ArrayList<>();

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }


    public ArrayList<Polygon> getPolygons() {
        return polygons;
    }

    public void addVertex(Vertex vertex){
        vertices.add(vertex);
    }

    public void addPolygon(Polygon polygon){
        polygons.add(polygon);
    }
}
