package labs.introtoprogramming.lab5.scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import labs.introtoprogramming.lab5.controllers.Controller;
import labs.introtoprogramming.lab5.gui.Input;

public class BasicScene extends Scene {
  private List<SceneObject> entities;
  private List<Controller> controllers = new ArrayList<>();
  private Color background;

  public BasicScene(List<SceneObject> entities, Color background) {
    this.entities = entities;
    this.background = background;
  }

  public BasicScene(List<SceneObject> entities) {
    this(entities, new Color(0, 0, 0));
  }

  public BasicScene() {
    this(new ArrayList<>());
  }

  @Override
  public void update(int delta, Input input) {
    controllers.forEach(controller -> controller.update(delta, input));
  }

  @Override
  public List<SceneObject> getSceneObjects() {
    return entities;
  }

  @Override
  public List<Light> getLights() {
    return entities.stream()
            .filter(obj -> obj instanceof Light)
            .map(obj -> (Light) obj)
            .collect(Collectors.toList());
  }

  @Override
  public List<Controller> getControllers() {
    return controllers;
  }

  @Override
  public Optional<Camera> getCamera() {
    return entities.stream()
            .filter(obj -> obj instanceof Camera)
            .map(obj -> (Camera) obj)
            .findFirst();
  }

  @Override
  public Color getBackgroundColor() {
    return background;
  }

  @Override
  public void addSceneObject(SceneObject obj) {
    entities.add(obj);
  }

  @Override
  public void addController(Controller controller) {
    this.controllers.add(controller);
  }
}
