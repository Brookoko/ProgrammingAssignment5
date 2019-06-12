package labs.introtoprogramming.lab5.scene;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import labs.introtoprogramming.lab5.controllers.Controller;
import labs.introtoprogramming.lab5.gui.Input;

public abstract class Scene {

  public abstract void update(int delta, Input input);

  public abstract List<SceneObject> getSceneObjects();

  public abstract List<Light> getLights();

  public abstract List<Controller> getControllers();

  public abstract Optional<Camera> getCamera();

  abstract Color getBackgroundColor();

  public abstract void addSceneObject(SceneObject obj);

  public void addSceneObjects(SceneObject... obj) {
    Arrays.stream(obj).forEach(this::addSceneObject);
  }

  public abstract void addController(Controller controller);
}
