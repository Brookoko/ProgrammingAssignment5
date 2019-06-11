package labs.introtoprogramming.lab5.object.Parser;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ParseObjFileTest {


    @Test
    public void ParseTest() throws IOException {
        ParseObjFile obj = new ParseObjFile(new FileInputStream(
                "LibertStatue.obj"));
        obj.getPolygonObject().toString();


    }
}
