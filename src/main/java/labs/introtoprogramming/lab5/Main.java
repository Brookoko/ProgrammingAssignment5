package labs.introtoprogramming.lab5;

import labs.introtoprogramming.lab5.controllers.KeyAndMouseMovementController;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.graphics.BufferedImageRaster;
import labs.introtoprogramming.lab5.graphics.Raster;
import labs.introtoprogramming.lab5.gui.SceneRendererWindow;
import labs.introtoprogramming.lab5.io.obj.ParseObjFile;
import labs.introtoprogramming.lab5.object.OptimizedObject;
import labs.introtoprogramming.lab5.scene.BasicScene;
import labs.introtoprogramming.lab5.scene.DistantLight;
import labs.introtoprogramming.lab5.scene.Light;
import labs.introtoprogramming.lab5.scene.PointLight;
import labs.introtoprogramming.lab5.scene.Scene;
import labs.introtoprogramming.lab5.scene.Camera;
import labs.introtoprogramming.lab5.scene.SceneObject;
import labs.introtoprogramming.lab5.scene.Transform;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.Collectors;

public class Main {

  private static final String APP_TILE = "ray tracing demo";
  private static final int SCREEN_WIDTH = 640;
  private static final int SCREEN_HEIGHT = 640;

  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  private void run() throws IOException {
    Scene demoScene = new BasicScene();
    SceneObject empty = new SceneObject();
    ParseObjFile parser = new ParseObjFile();
    parser.load(new FileInputStream(new File("assets/box.obj")));
    OptimizedObject obj = new OptimizedObject(new Transform(),
            parser.getPolygons().stream().map(el -> (SceneObject) el).collect(Collectors.toList()));
    Camera camera = createCamera();
    Light light = new DistantLight(new Transform(Vector3.ONE.multiply(10), new Vector3(0, 90, 45)), 1000);
    camera.getTransform().setParent(empty.getTransform());
    camera.lookAt(new Vector3(0, 0, 3), obj.getTransform().position());
    demoScene.addSceneObjects(camera);
    demoScene.addSceneObjects(obj);
    demoScene.addSceneObjects(light);
    demoScene.addController(new KeyAndMouseMovementController(empty));

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
