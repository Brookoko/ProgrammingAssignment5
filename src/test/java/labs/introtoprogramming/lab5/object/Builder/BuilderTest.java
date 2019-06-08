package labs.introtoprogramming.lab5.object.Builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderTest {
    private BuildParserObj object = new BuildParserObj();

    @Test
    public void testSetCurrentGroupNames() {
        String[] groupNames = {"firstGroup", "secondGroup", "thirdGroup"};
        object.setCurrentGroupNames(groupNames);
        assertEquals(groupNames[0], object.getCurrentGroups().get(0));
        assertEquals(groupNames[1], object.getCurrentGroups().get(1));
        assertEquals(groupNames[2], object.getCurrentGroups().get(2));
    }
}
