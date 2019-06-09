package labs.introtoprogramming.lab5.scene;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.object.Box;
import org.junit.Test;

public class SceneTests {

  @Test
  public void testSceneUpdateUpdatesObjects() {
    Scene scene = new BasicScene();
    MockSceneObject obj = new MockSceneObject();
    scene.addSceneObjects(new Box(new Transform(Vector3.ZERO), 1), obj);
    scene.update(10);
    assertTrue(obj.updated);
    assertEquals(10, obj.updatedWithDelta);
  }

  private class MockSceneObject extends SceneObject {
    boolean updated = false;
    int updatedWithDelta = 0;

    @Override
    public void update(int delta) {
      this.updated = true;
      this.updatedWithDelta = delta;
    }
  }
}
