package labs.introtoprogramming.lab5.object.Builder.POJO;

import labs.introtoprogramming.lab5.geometry.Vector3;

import java.util.ArrayList;

public class FacePlate {

    private ArrayList<VertexFace> vertices = new ArrayList<VertexFace>();
    private Material material = null;
    private Vector3 faceNormal = new Vector3(0, 0, 0);
    private Material map = null;

    public ArrayList<VertexFace> getVertices() {
        return vertices;
    }

    public Material getMaterial() {
        return material;
    }

    public Material getMap() {
        return map;
    }

    public void add(VertexFace vertex) {
        vertices.add(vertex);
    }

    public void setVertices(ArrayList<VertexFace> vertices) {
        this.vertices = vertices;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setMap(Material map) {

        this.map = map;
    }

    public FacePlate(Material material, Material map) {
        this.material = material;
        this.map = map;
    }

    public void setFaceNormal(Vector3 faceNormal) {
        this.faceNormal = faceNormal;
    }

    public FacePlate(ArrayList<VertexFace> vertices, Material material, Material map) {
        this.vertices = vertices;
        this.material = material;
        this.map = map;
    }

    public String toString() {
        String result = "\tvertices: " + vertices.size() + " :\n";
        for (VertexFace f : vertices) {
            result += " \t\t( " + f.toString() + " )\n";
        }
        return result;
    }
}
