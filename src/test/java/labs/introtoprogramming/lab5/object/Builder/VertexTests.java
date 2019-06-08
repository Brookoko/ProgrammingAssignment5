package labs.introtoprogramming.lab5.object.Builder;

import labs.introtoprogramming.lab5.object.Builder.POJO.VertexFace;
import labs.introtoprogramming.lab5.object.Builder.POJO.VertexGeometry;
import labs.introtoprogramming.lab5.object.Builder.POJO.VertexNormal;
import labs.introtoprogramming.lab5.object.Builder.POJO.VertexTexture;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VertexTests {

    @Test
    public void VertexTextureTest(){
        VertexTexture vertexTexture = new VertexTexture(0,1);
        assertEquals(new VertexTexture(0,1).getU(), vertexTexture.getU());
        assertEquals(new VertexTexture(0,1).getV(), vertexTexture.getV());
    }

    @Test
    public void VertexNormalTest(){
        VertexNormal normal = new VertexNormal(0, 4, 5);
        assertEquals(new VertexNormal(0,4,5).getX(), normal.getX());
        assertEquals(new VertexNormal(0,4,5).getY(), normal.getY());
        assertEquals(new VertexNormal(0,4,5).getZ(), normal.getZ());
        normal.add(5,5,5);
        assertEquals(new VertexNormal(5,5,5).getX(), normal.getX());
        assertEquals(new VertexNormal(5,5,5).getY(), normal.getY());
        assertEquals(new VertexNormal(5,5,5).getZ(), normal.getZ());
        normal.setZ(2);
        assertEquals(new VertexNormal(5,5,2).getZ(), normal.getZ());
    }

    @Test
    public void VertexGeometryTest(){
        VertexGeometry geometry = new VertexGeometry(0,0,0);
        assertEquals(new VertexGeometry(0,0,0).getX(), geometry.getX());
        assertEquals(new VertexGeometry(0,0,0).getY(), geometry.getY());
        assertEquals(new VertexGeometry(0,0,0).getZ(), geometry.getZ());
    }

    @Test
    public void VertexFaceTest(){
        VertexFace vertexFace = new VertexFace();
        vertexFace.setVertexT(new VertexTexture(1,2));
        vertexFace.setVertexG(new VertexGeometry(0,0,0));
        vertexFace.setVertexN(new VertexNormal(0,0,0));
        assertEquals(new VertexNormal(0,0,0).getX(), vertexFace.getVertexN().getX());
        assertEquals(new VertexNormal(0,0,0).getY(), vertexFace.getVertexN().getY());
        assertEquals(new VertexNormal(0,0,0).getZ(), vertexFace.getVertexN().getZ());
        assertEquals(new VertexGeometry(0,0,0).getX(), vertexFace.getVertexG().getX());
        assertEquals(new VertexGeometry(0,0,0).getY(), vertexFace.getVertexG().getY());
        assertEquals(new VertexGeometry(0,0,0).getZ(), vertexFace.getVertexG().getZ());
        assertEquals(new VertexTexture(1,2).getU(), vertexFace.getVertexT().getU());
        assertEquals(new VertexTexture(1,2).getV(), vertexFace.getVertexT().getV());
    }
}
