package labs.introtoprogramming.lab5.scene;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import labs.introtoprogramming.lab5.controllers.Controller;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.gui.Input;
import labs.introtoprogramming.lab5.object.Box;
import org.junit.Test;

public class SceneTests {

  @Test
  public void testSceneUpdateUpdatesControllers() {
    Scene scene = new BasicScene();
    MockSceneController controller = new MockSceneController();
    scene.addSceneObjects(new Box(new Transform(Vector3.ZERO), 1));
    scene.addController(controller);
    scene.update(10, new Input());
    assertTrue(controller.updated);
    assertEquals(10, controller.updatedWithDelta);
  }

  private class MockSceneController extends Controller {
    boolean updated = false;
    int updatedWithDelta = 0;

    @Override
    public void update(int delta, Input input) {
      this.updated = true;
      this.updatedWithDelta = delta;
    }
  }
}
