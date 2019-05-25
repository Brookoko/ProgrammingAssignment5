package labs.introtoprogramming.lab5.scene;

import java.awt.Color;
import java.util.List;

public interface Scene {

  List<SceneObject> getSceneObjects();

  List<PointLight> getLights();

  Color getBackgroundColor();

}
