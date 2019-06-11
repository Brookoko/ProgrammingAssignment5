package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.geometry.Vector3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VertexTest {
    @Test
    public void testVertex(){
        Vertex vertex = new Vertex();
        vertex.setVertexN(new Vector3(0, 0, 0));
        vertex.setVertexG(new Vector3(1, 1, 1));
        assertEquals(1, vertex.getVertexG().x, 0);
        assertEquals(0, vertex.getVertexN().x, 0 );
        vertex.toString();
    }
}
