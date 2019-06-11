package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.geometry.Vector3;
import org.junit.Test;
import org.omg.CORBA.DATA_CONVERSION;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParseObjFileTest {
    private static final double DELTA = 1e-10;

    @Test
    public void ParseTest() throws IOException {
        //4//4 5//5 18//18 17//17
        ParseObjFile obj = new ParseObjFile(
                ParseObjFileTest.class.getResourceAsStream("/LibertStatue.obj"));
        Vector3 geometry = obj.getVerticesGeometry().get(4);
        Polygon polygon = obj.getPolygonObject().getPolygons().get(4);
        Vector3 findGeometry = polygon.getVertecies().get(0).getVertexG();
        assertEquals(geometry.x, findGeometry.x, DELTA);
        obj.getPolygonObject().toString();
    }
}
