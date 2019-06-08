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
        assertEquals(0, vertexTexture.getU(), 0);
        assertEquals(1, vertexTexture.getV(), 0);
    }

    @Test
    public void VertexNormalTest(){
        VertexNormal normal = new VertexNormal(0, 4, 5);
        assertEquals(0, normal.getX(),0);
        assertEquals(4, normal.getY(), 0);
        assertEquals(5, normal.getZ(), 0);
        normal.add(5,5,5);
        assertEquals(5, normal.getX(), 0);
        assertEquals(5, normal.getX(), 0);
        assertEquals(5, normal.getX(), 0);
        normal.setZ(2);
        assertEquals(2, normal.getZ(),0);
    }

    @Test
    public void VertexGeometryTest(){
        VertexGeometry geometry = new VertexGeometry(0,0,0);
       assertEquals(0, geometry.getX(),0);
       assertEquals(0, geometry.getY(),0);
       assertEquals(0, geometry.getZ(),0);
    }

    @Test
    public void VertexFaceTest(){
        VertexFace vertexFace = new VertexFace();
        vertexFace.setVertexT(new VertexTexture(1,2));
        vertexFace.setVertexG(new VertexGeometry(0,0,0));
        vertexFace.setVertexN(new VertexNormal(0,0,0));
        assertEquals(1, vertexFace.getVertexT().getU(), 0);
        assertEquals(2, vertexFace.getVertexT().getV(), 0);

        assertEquals(0,  vertexFace.getVertexG().getX(), 0);
        assertEquals(0,  vertexFace.getVertexG().getY(), 0);
        assertEquals(0,  vertexFace.getVertexG().getZ(), 0);

        assertEquals(0,  vertexFace.getVertexN().getZ(), 0);
        assertEquals(0,  vertexFace.getVertexN().getX(), 0);
        assertEquals(0,  vertexFace.getVertexN().getY(), 0);
    }
}
