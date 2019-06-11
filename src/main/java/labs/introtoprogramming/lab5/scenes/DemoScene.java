package labs.introtoprogramming.lab5.scenes;

import java.awt.Color;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.object.Box;
import labs.introtoprogramming.lab5.object.Sphere;
import labs.introtoprogramming.lab5.scene.BasicScene;
import labs.introtoprogramming.lab5.scene.DistantLight;
import labs.introtoprogramming.lab5.scene.PointLight;
import labs.introtoprogramming.lab5.scene.Transform;

public class DemoScene extends BasicScene {

  public DemoScene() {
    Box other = new Box(new Transform(new Vector3(0, -6, 0)), 10);
    Sphere sphere = new Sphere(new Transform(Vector3.FORWARD.multiply(-3)), 1);
    sphere.getMesh().setColor(Color.RED);
    addSceneObjects(
            sphere,
            new Box(new Transform(new Vector3(2, 2, -3)), 1),
            other,
            new DistantLight(new Transform(Vector3.ZERO, new Vector3(0, -1, 0)), 10)
            //new PointLight(new Transform(new Vector3(0, 0, -1), new Vector3(0, -1, 0)), 1000)
    );
  }
}
