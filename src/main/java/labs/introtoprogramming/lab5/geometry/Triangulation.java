package labs.introtoprogramming.lab5.geometry;

import labs.introtoprogramming.lab5.io.obj.Polygon;
import labs.introtoprogramming.lab5.io.obj.Vertex;
import labs.introtoprogramming.lab5.object.Triangle;
import labs.introtoprogramming.lab5.scene.Transform;

import java.util.ArrayList;
import java.util.List;

public class Triangulation {

  public List<Triangle> splitPolygons(List<Polygon> polygons) {
    List<Triangle> triangles = new ArrayList<>();
    for (Polygon pol : polygons) {
      List<Vertex> ver = pol.getVertices();
      Vector3 pillar = ver.get(0).geometry;
      for (int i = 0; i < ver.size() - 1; i++) {
        triangles.add(new Triangle(new Transform(),
                pillar, ver.get(i).geometry, ver.get(i + 1).geometry));
      }
    }
    return triangles;
  }
}
