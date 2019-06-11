package labs.introtoprogramming.lab5.scenes;

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class DemoSceneTests {

  @Test
  public void testInstantiation() {
    DemoScene scene = new DemoScene();
    assertTrue(scene.getSceneObjects().size() > 0);
  }
}
