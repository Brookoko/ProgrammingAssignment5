package labs.introtoprogramming.lab5.io.obj;

import labs.introtoprogramming.lab5.geometry.Vector3;

public class Vertex {
    /**
     * Vertex parameters: geometry coordinates and coordinates of normals
     */
    public Vector3 geometry;
    public Vector3 normal;

    public Vertex(Vector3 geometry, Vector3 normal) {
        this.geometry = geometry;
        this.normal = normal;
    }
}
