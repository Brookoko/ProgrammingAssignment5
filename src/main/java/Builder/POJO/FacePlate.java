package Builder.POJO;

import java.util.ArrayList;

public class FacePlate {

    public ArrayList<VertexFace> vertices = new ArrayList<VertexFace>();
    public Material material = null;
    public Material map = null;

    public FacePlate() {
    }

    public void add(VertexFace vertex) {
        vertices.add(vertex);
    }
    public VertexNormal faceNormal = new VertexNormal(0, 0, 0);

    public void calculateTriangleNormal() {
        float[] edgeF = new float[3];
        float[] edgeS = new float[3];
        float[] normal = new float[3];
        VertexGeometry first = vertices.get(0).vertexG;
        VertexGeometry second = vertices.get(1).vertexG;
        VertexGeometry third = vertices.get(2).vertexG;
        float[] pointOne = {first.x, first.y, first.z};
        float[] pointTwo = {second.x, second.y, second.z};
        float[] pointThree = {second.x, second.y, second.z};

        edgeF[0] = pointTwo[0] - pointOne[0];
        edgeF[1] = pointTwo[1] - pointOne[1];
        edgeF[2] = pointTwo[2] - pointOne[2];

        edgeS[0] = pointThree[0] - pointTwo[0];
        edgeS[1] = pointThree[1] - pointTwo[1];
        edgeS[2] = pointThree[2] - pointTwo[2];

        normal[0] = edgeF[1] * edgeS[2] - edgeF[2] * edgeS[1];
        normal[1] = edgeF[2] * edgeS[0] - edgeF[0] * edgeS[2];
        normal[2] = edgeF[0] * edgeS[1] - edgeF[1] * edgeS[0];

        faceNormal.x = normal[0];
        faceNormal.y = normal[1];
        faceNormal.z = normal[2];
    }

    public String toString() {
        String result = "\tvertices: "+vertices.size()+" :\n";
        for(VertexFace f : vertices) {
            result += " \t\t( "+f.toString()+" )\n";
        }
        return result;
    }
}
