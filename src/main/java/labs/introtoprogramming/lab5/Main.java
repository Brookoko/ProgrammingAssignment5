package labs.introtoprogramming.lab5;

import labs.introtoprogramming.lab5.controllers.KeyAndMouseMovementController;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.graphics.BufferedImageRaster;
import labs.introtoprogramming.lab5.graphics.Raster;
import labs.introtoprogramming.lab5.gui.SceneRendererWindow;
import labs.introtoprogramming.lab5.scene.Scene;
import labs.introtoprogramming.lab5.scene.Camera;
import labs.introtoprogramming.lab5.scene.Transform;
import labs.introtoprogramming.lab5.scenes.DemoScene;

public class Main {

  private static final String APP_TILE = "ray tracing demo";
  private static final int SCREEN_WIDTH = 640;
  private static final int SCREEN_HEIGHT = 640;

  public static void main(String[] args) {
    new Main().run();
  }

  private void run() {
    Scene demoScene = new DemoScene();
    Camera camera = createCamera();
    demoScene.addSceneObjects(camera);
    demoScene.addController(new KeyAndMouseMovementController(camera));

    SceneRendererWindow window = new SceneRendererWindow(demoScene);
    window.setTitle(APP_TILE);
    window.setDisplayFPS(true);
    window.show();
  }

  private Camera createCamera() {
    Raster raster = new BufferedImageRaster(SCREEN_WIDTH, SCREEN_HEIGHT);
    return new Camera(raster, new Transform(Vector3.ZERO));
  }
}
