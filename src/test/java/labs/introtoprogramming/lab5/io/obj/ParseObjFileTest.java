package labs.introtoprogramming.lab5.io.obj;

import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.object.Box;
import labs.introtoprogramming.lab5.object.Triangle;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParseObjFileTest {
    private static final double DELTA = 1e-10;

    @Test
    public void ParseTest() throws IOException {
        //4//4 5//5 18//18 17//17
        ParseObjFile obj = new ParseObjFile();
        obj.load(ParseObjFileTest.class.getResourceAsStream("/box.obj"));
        List<Triangle> triangles = obj.getPolygons();
        for (Triangle tria : triangles) {
          System.out.println(tria);
        }
        Box boundary = triangles.get(0).getBoundary();
        assertEquals(new Vector3(-0.5, -0.5, 0.5), boundary.lowerBounds);
        assertEquals(new Vector3(0.5, 0.5, 0.5), boundary.upperBounds);
    }
}
