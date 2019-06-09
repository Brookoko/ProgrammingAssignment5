package labs.introtoprogramming.lab5.scenes;

import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.object.Box;
import labs.introtoprogramming.lab5.object.Sphere;
import labs.introtoprogramming.lab5.scene.BasicScene;
import labs.introtoprogramming.lab5.scene.Transform;

public class DemoScene extends BasicScene {

  public DemoScene() {
    addSceneObjects(
            new Sphere(new Transform(Vector3.FORWARD.multiply(-3)), 1),
            new Box(new Transform(Vector3.FORWARD.multiply(-10)), 1),
            new Box(new Transform(Vector3.RIGHT.multiply(5)), 1)
    );
  }
}
