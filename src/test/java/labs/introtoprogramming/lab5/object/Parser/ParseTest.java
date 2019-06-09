package labs.introtoprogramming.lab5.object.Parser;

import labs.introtoprogramming.lab5.object.Builder.LoadDataFromParserObject;
import org.junit.Test;

public class ParseTest {


    @Test
    public void ParseTest() {
        try {
                LoadDataFromParserObject builder = new LoadDataFromParserObject();
                ParseObjFile obj = new ParseObjFile(builder,"LibertStatue.obj" );
                obj.toString();
            } catch (java.io.FileNotFoundException e) {

                e.printStackTrace();
            } catch (java.io.IOException e) {

                e.printStackTrace();
            }


    }
}
