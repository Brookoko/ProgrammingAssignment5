package labs.introtoprogramming.lab5.scene;

import java.awt.Color;
import java.util.List;
import java.util.Optional;

public interface Scene {

  List<SceneObject> getSceneObjects();

  List<PointLight> getLights();

  Optional<Camera> getCamera();

  Color getBackgroundColor();

}
