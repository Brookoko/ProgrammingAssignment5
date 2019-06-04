package labs.introtoprogramming.lab5.object;

import labs.introtoprogramming.lab5.object.Builder.BuildParserObj;
import labs.introtoprogramming.lab5.object.Parser.ParseObj;
import org.junit.Test;

public class ParseTest {


    @Test
    public void ParseTest() {
        try {
                BuildParserObj builder = new BuildParserObj();
                ParseObj obj = new ParseObj(builder,"LibertStatue.obj" );
                obj.toString();
            } catch (java.io.FileNotFoundException e) {

                e.printStackTrace();
            } catch (java.io.IOException e) {

                e.printStackTrace();
            }


    }
}
