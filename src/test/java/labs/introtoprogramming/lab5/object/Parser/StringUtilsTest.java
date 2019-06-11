package labs.introtoprogramming.lab5.object.Parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilsTest {
    private static final double DELTA = 1e-10;

    @Test
    public void testStringUtil() {
        String firstLine = "1//2 1//3 1//5";
        String secondLine = "1/4/2 1/7/3 1/2/5";
        Integer[] firstArr = StringUtils.parseCodeLine(firstLine);
        Integer[] secondArr = StringUtils.parseCodeLine(secondLine);
        assertEquals(1, secondArr[0], DELTA);
        assertEquals(1, secondArr[1], DELTA);
    }
}
