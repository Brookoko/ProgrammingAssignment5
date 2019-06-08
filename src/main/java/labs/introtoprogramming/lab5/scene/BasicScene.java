package labs.introtoprogramming.lab5.scene;

import java.awt.Color;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasicScene implements Scene {
  private List<SceneObject> entities;
  private Color background;

  public BasicScene(List<SceneObject> entities, Color background) {
    this.entities = entities;
    this.background = background;
  }

  public BasicScene(List<SceneObject> entities) {
    this(entities, new Color(0, 0, 0));
  }

  @Override
  public List<SceneObject> getSceneObjects() {
    return entities;
  }

  @Override
  public List<PointLight> getLights() {
    return entities.stream()
            .filter(obj -> obj instanceof PointLight)
            .map(obj -> (PointLight) obj)
            .collect(Collectors.toList());
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
}
