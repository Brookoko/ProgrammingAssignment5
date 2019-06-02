package labs.introtoprogramming.lab5.object;

import labs.introtoprogramming.lab5.object.Builder.BuildMe;
import labs.introtoprogramming.lab5.object.Parser.ParseMe;
import org.junit.Test;

public class ParseTest {


    @Test
    public void ParseTest(String fileName) {
        try {
                BuildMe builder = new BuildMe();
                ParseMe obj = new ParseMe(builder,"LibertStatue.obj" );
                obj.toString();
            } catch (java.io.FileNotFoundException e) {

                e.printStackTrace();
            } catch (java.io.IOException e) {

                e.printStackTrace();
            }


    }
}
