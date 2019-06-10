package labs.introtoprogramming.lab5.object.Parser;

import org.junit.Test;

public class ParseTest {


    @Test
    public void ParseTest() {
        try {

                ParseObjFile obj = new ParseObjFile("LibertStatue.obj" );
                obj.toString();
            } catch (java.io.FileNotFoundException e) {

                e.printStackTrace();
            } catch (java.io.IOException e) {

                e.printStackTrace();
            }


    }
}
