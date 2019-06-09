package labs.introtoprogramming.lab5.scene;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.graphics.BufferedImageRaster;
import labs.introtoprogramming.lab5.graphics.Raster;
import labs.introtoprogramming.lab5.gui.Input;
import org.junit.Test;

public class ControllableCameraTests {

  @Test
  public void testUpdate() {
    Raster raster = new BufferedImageRaster(100, 100);
    SceneObject camera = new ControllableCamera(raster, new Transform(Vector3.ZERO));
    Input input = new Input();
    input.setForwardKeyDown(true);
    input.setRightKeyDown(true);
    camera.setInput(input);
    camera.update(10);
    assertTrue(camera.getTransform().position().x > 0);
    assertTrue(camera.getTransform().position().z < 0);
  }

}
