import Builder.BuildMe;
import Parser.ParseMe;

public class ParseTest {


    public static void main(String[] args) {



            try {
                BuildMe builder = new BuildMe();
                ParseMe obj = new ParseMe(builder,"LibertStatue.obj" );
            } catch (java.io.FileNotFoundException e) {

                e.printStackTrace();
            } catch (java.io.IOException e) {

                e.printStackTrace();
            }


    }
}
