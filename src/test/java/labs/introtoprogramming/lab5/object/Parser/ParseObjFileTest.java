package labs.introtoprogramming.lab5.object.Parser;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ParseObjFileTest {


    @Test
    public void ParseTest() {
        ParseObjFile obj = null;
        try {
            obj = new ParseObjFile(new FileInputStream(
                    "LibertStatue.obj"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        obj.getPolygonObject().toString();


    }
}
