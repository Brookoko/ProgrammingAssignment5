package labs.introtoprogramming.lab5.object.Builder;

import labs.introtoprogramming.lab5.object.Builder.POJO.FacePlate;
import labs.introtoprogramming.lab5.object.Builder.POJO.VertexFace;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FacePlateTests {


    @Test
    public void testCalculateNormal(){

        VertexFace first = new VertexFace();
        VertexFace second = new VertexFace();
        VertexFace third = new VertexFace();
        assertEquals(first, second);
    }

}
