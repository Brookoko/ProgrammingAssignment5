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

    public void calculatePolygonNormal(){
        if(vertices.size() == 3){
            Vector3 fromOneToTwo = new Vector3(vertices.get(0).getVertexG().x - vertices.get(1).getVertexG().x,
                    vertices.get(0).getVertexG().y - vertices.get(1).getVertexG().y,
                    vertices.get(0).getVertexG().z - vertices.get(1).getVertexG().z);
            Vector3 fromOneToThree = new Vector3(vertices.get(0).getVertexG().x - vertices.get(2).getVertexG().x,
                    vertices.get(0).getVertexG().y - vertices.get(2).getVertexG().y,
                    vertices.get(0).getVertexG().z - vertices.get(2).getVertexG().z);

            polygonNormal = new Vector3(fromOneToTwo.x*fromOneToThree.y + fromOneToThree.x*fromOneToTwo.y,
                    fromOneToThree.x*fromOneToTwo.z + fromOneToThree.z*fromOneToTwo.x,
                    fromOneToTwo.y*fromOneToThree.z + fromOneToThree.y*fromOneToTwo.z);

        }

    }

    public void setPolygonNormal(Vector3 polygonNormal) {
        this.polygonNormal = polygonNormal;
    }
}