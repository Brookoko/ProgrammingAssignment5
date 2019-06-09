package labs.introtoprogramming.lab5.object.Builder.POJO;

import java.util.ArrayList;

public class FacePlate {

    private ArrayList<VertexFace> vertices = new ArrayList<VertexFace>();
    private Material material = null;

    public ArrayList<VertexFace> getVertices() {
        return vertices;
    }

    public Material getMaterial() {
        return material;
    }

    public Material getMap() {
        return map;
    }

    private Material map = null;

    public FacePlate() {
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

    public void setFaceNormal(VertexNormal faceNormal) {
        this.faceNormal = faceNormal;
    }

    private VertexNormal faceNormal = new VertexNormal(0, 0, 0);

    public void calculateTriangleNormal() {
        float[] edgeF = new float[3];
        float[] edgeS = new float[3];
        float[] normal = new float[3];
        VertexGeometry first = vertices.get(0).getVertexG();
        VertexGeometry second = vertices.get(1).getVertexG();
        VertexGeometry third = vertices.get(2).getVertexG();
        float[] pointOne = {first.getX(), first.getY(), first.getZ()};
        float[] pointTwo = {second.getX(), second.getY(), second.getZ()};
        float[] pointThree = {third.getX(), third.getY(), third.getZ()};

        edgeF[0] = pointTwo[0] - pointOne[0];
        edgeF[1] = pointTwo[1] - pointOne[1];
        edgeF[2] = pointTwo[2] - pointOne[2];

        edgeS[0] = pointThree[0] - pointTwo[0];
        edgeS[1] = pointThree[1] - pointTwo[1];
        edgeS[2] = pointThree[2] - pointTwo[2];

        normal[0] = edgeF[1] * edgeS[2] - edgeF[2] * edgeS[1];
        normal[1] = edgeF[2] * edgeS[0] - edgeF[0] * edgeS[2];
        normal[2] = edgeF[0] * edgeS[1] - edgeF[1] * edgeS[0];

        faceNormal.setX(normal[0]);
        faceNormal.setY(normal[1]);
        faceNormal.setZ(normal[2]);
    }

    public String toString() {
        String result = "\tvertices: "+vertices.size()+" :\n";
        for(VertexFace f : vertices) {
            result += " \t\t( "+f.toString()+" )\n";
        }
        return result;
    }
}
