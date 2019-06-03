package labs.introtoprogramming.lab5.scene;

import labs.introtoprogramming.lab5.exception.NoCameraException;
import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.graphics.Raster;

import java.awt.Color;

public class BasicRaytracingRender implements SceneRender {
  private Raster raster;

  public BasicRaytracingRender(Raster raster) {
    this.raster = raster;
  }

  @Override
  public void render(Scene scene) {
    Camera camera = scene.getCamera().orElseThrow(NoCameraException::new);
    Vector3 pos = camera.getTransform().position();
    int width = raster.getWidth();
    int height = raster.getHeight();
    double aspectRatio = camera.aspectRatio();
    double fieldOfView = Math.tan(camera.fieldOfView() / 2);
    Ray primaryRay = new Ray(pos, Vector3.ZERO);
    for (int y = 0; y < height; y++) {
      double normalizedY = 1 - 2 * (y + 0.5) / height;
      double cameraY =  normalizedY * fieldOfView;
      for (int x = 0; x < width; x++) {
        double normalizedX = 2 * (x + 0.5) / width - 1;
        double cameraX = normalizedX * aspectRatio * fieldOfView;
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

  Color getColor(Ray primaryRay, Scene scene) {
    SceneObject obj = findInteraction(primaryRay, scene);
    return obj != null ? obj.getMesh().color() : scene.getBackgroundColor();
  }

  SceneObject findInteraction(Ray primaryRay, Scene scene) {
    SceneObject intersection = null;
    double minDistance = Double.POSITIVE_INFINITY;
    for (SceneObject obj : scene.getSceneObjects()) {
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
