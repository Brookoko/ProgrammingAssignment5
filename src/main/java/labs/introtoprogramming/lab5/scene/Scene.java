package labs.introtoprogramming.lab5.scene;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class Scene {

  public abstract void update(int delta);

  public abstract List<SceneObject> getSceneObjects();

  public abstract List<PointLight> getLights();

  public abstract Optional<Camera> getCamera();

  abstract Color getBackgroundColor();

  public abstract void addSceneObject(SceneObject obj);

  public void addSceneObjects(SceneObject... obj) {
    Arrays.stream(obj).forEach(this::addSceneObject);
  }
}
