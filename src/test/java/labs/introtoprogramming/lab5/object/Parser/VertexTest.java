package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.io.obj.Vertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VertexTest {

    @Test
    public void testVertex() {
        Vertex vertex = new Vertex(Vector3.ZERO, Vector3.ONE);
        assertEquals(Vector3.ZERO, vertex.geometry);
        assertEquals(Vector3.ONE, vertex.normal);
    }
}
