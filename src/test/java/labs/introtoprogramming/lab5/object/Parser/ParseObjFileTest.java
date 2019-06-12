package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.io.obj.ParseObjFile;
import labs.introtoprogramming.lab5.io.obj.Polygon;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParseObjFileTest {
    private static final double DELTA = 1e-10;

    @Test
    public void ParseTest() throws IOException {
        //4//4 5//5 18//18 17//17
        ParseObjFile obj = new ParseObjFile();
        obj.load(ParseObjFileTest.class.getResourceAsStream("/LibertStatue.obj"));
    }
}
