package labs.introtoprogramming.lab5.controllers;

import static junit.framework.TestCase.assertTrue;

import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.graphics.BufferedImageRaster;
import labs.introtoprogramming.lab5.graphics.Raster;
import labs.introtoprogramming.lab5.gui.Input;
import labs.introtoprogramming.lab5.scene.Camera;
import labs.introtoprogramming.lab5.scene.SceneObject;
import labs.introtoprogramming.lab5.scene.Transform;
import org.junit.Test;

public class KeyAndMouseControllerTests {

  @Test
  public void testUpdate() {
    Raster raster = new BufferedImageRaster(100, 100);
    SceneObject camera = new Camera(raster, new Transform(Vector3.ZERO));
    KeyAndMouseMovementController controller = new KeyAndMouseMovementController(camera);
    Input input = new Input();
    input.setForwardKeyDown(true);
    input.setRightKeyDown(true);
    controller.update(10, input);
    assertTrue(camera.getTransform().position().x > 0);
    assertTrue(camera.getTransform().position().z < 0);
  }

}
