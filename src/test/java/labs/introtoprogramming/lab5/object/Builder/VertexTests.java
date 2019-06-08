package labs.introtoprogramming.lab5.object.Builder;

import labs.introtoprogramming.lab5.object.Builder.POJO.VertexGeometry;
import labs.introtoprogramming.lab5.object.Builder.POJO.VertexNormal;
import labs.introtoprogramming.lab5.object.Builder.POJO.VertexTexture;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VertexTests {

    @Test
    public void VertexTextureTest(){
        VertexTexture vertexTexture = new VertexTexture(0,1);
        assertEquals(new VertexTexture(0,1), vertexTexture);
    }

    @Test
    public void VertexNormalTest(){
        VertexNormal normal = new VertexNormal(0, 4, 5);
        assertEquals(new VertexNormal(0,4,5), normal);
        normal.add(5,5,5);
        assertEquals(new VertexNormal(5,5,5), normal);
        normal.setZ(2);
        assertEquals(new VertexNormal(5,5,2), normal);
    }

    @Test
    public void VertexGeometryTest(){
        VertexGeometry geometry = new VertexGeometry(0,0,0);
        assertEquals(new VertexGeometry(0,0,0), geometry);
    }
}
