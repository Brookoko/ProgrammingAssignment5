package labs.introtoprogramming.lab5.object.Builder;

import labs.introtoprogramming.lab5.object.Builder.POJO.FacePlate;
import labs.introtoprogramming.lab5.object.Builder.POJO.Material;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FacePlateTests {


    @Test

    public void testFacePlate() {
        String materStr = "firstMaterial";
        String mapStr = "map";
        Material material = new Material(materStr);
        Material map = new Material(mapStr);
        FacePlate fp = new FacePlate(material, map);
        assertEquals(mapStr, fp.getMap());
        assertEquals(materStr, fp.getMaterial());
    }

}
