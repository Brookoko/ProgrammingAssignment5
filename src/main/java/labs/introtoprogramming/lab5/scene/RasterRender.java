package labs.introtoprogramming.lab5.scene;

import labs.introtoprogramming.lab5.exception.NoCameraException;
import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.graphics.Raster;

import java.awt.Color;
import java.util.List;
import java.util.stream.Collectors;

public class RasterRender implements SceneRender {
  private List<SceneObject> intractable;
  private Raster raster;
  private int width = 1920; // Temporary value while Raster is not implemented.
  private int height = 1280; // It will be replaced with raster.getWidth() and raster.getHeight().

  public RasterRender(Raster raster) {
    this.raster = raster;
  }

  @Override
  public void render(Scene scene) {
    Camera camera = scene.getCamera().orElseThrow(NoCameraException::new);
    intractable = scene.getSceneObjects().stream()
            .filter(obj -> !(obj instanceof PointLight) && !(obj instanceof Camera))
            .collect(Collectors.toList());
    Vector3 pos = camera.getTransform().position();
    double aspectRation = (double) width / height;
    double fieldOfView = Math.tan(camera.fieldOfView() / 2);
    Ray primaryRay = new Ray(pos, Vector3.ZERO);
    for (int y = 0; y < height; y++) {
      double normalizedY = 1 - 2 * (y + 0.5) / height;
      double cameraY = (1 - 2 * normalizedY) * fieldOfView;
      for (int x = 0; x < width; x++) {
        double normalizedX = 2 * (x + 0.5) / width - 1;
        double cameraX = (2 * normalizedX - 1) * aspectRation * fieldOfView;
        Vector3 direction = new Vector3(cameraX, cameraY, -1).normalize();
        primaryRay.setDirection(direction);
        Color color = getColor(primaryRay, scene);
        raster.setPixel(x, y,
                (byte) color.getRed(),
                (byte) color.getGreen(),
                (byte) color.getBlue());
      }
    }
  }

  private Color getColor(Ray primaryRay, Scene scene) {
    SceneObject obj = findInteraction(primaryRay);
    return obj != null ? obj.getMesh().color() : scene.getBackgroundColor();
  }

  private SceneObject findInteraction(Ray primaryRay) {
    SceneObject intersection = null;
    double minDistance = Double.POSITIVE_INFINITY;
    for (SceneObject obj : intractable) {
      double distance = obj.getTransform().position().distance(primaryRay.getOrigin());
      if (distance < minDistance) {
        if (obj.intersect(primaryRay)) {
          minDistance = distance;
          intersection = obj;
        }
      }
    }
    return intersection;
  }
}
