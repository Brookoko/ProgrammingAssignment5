package labs.introtoprogramming.lab5.scene;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import labs.introtoprogramming.lab5.exception.NoCameraException;
import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.graphics.BufferedImageRaster;
import labs.introtoprogramming.lab5.graphics.Raster;
import labs.introtoprogramming.lab5.object.Sphere;
import org.junit.Test;

public class BasicRaytracingRenderTests {

  @Test
  public void testFindInteraction() {
    List<SceneObject> list = Collections.singletonList(
            new Sphere(new Transform(Vector3.FORWARD.multiply(3)), 1)
    );
    Ray ray = new Ray(Vector3.ZERO, Vector3.FORWARD);
    Raster raster = new BufferedImageRaster(100, 100);
    Scene scene = new BasicScene(list);
    BasicRaytracingRender render = new BasicRaytracingRender(raster);
    SceneObject interaction = render.findInteraction(ray, scene);
    assertEquals(list.get(0), interaction);
  }

  @Test
  public void testFindInteractionEmptyScene() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.FORWARD);
    Raster raster = new BufferedImageRaster(100, 100);
    Scene scene = new BasicScene(Collections.emptyList());
    BasicRaytracingRender render = new BasicRaytracingRender(raster);
    SceneObject interaction = render.findInteraction(ray, scene);
    assertNull(interaction);
  }

  @Test
  public void testFindInteractionSeveralObjects() {
    List<SceneObject> list = Arrays.asList(
            new Sphere(new Transform(Vector3.FORWARD.multiply(5)), 1),
            new Sphere(new Transform(Vector3.FORWARD.multiply(3)), 1),
            new Sphere(new Transform(Vector3.FORWARD.multiply(10)), 1)
    );
    Ray ray = new Ray(Vector3.ZERO, Vector3.FORWARD);
    Raster raster = new BufferedImageRaster(100, 100);
    Scene scene = new BasicScene(list);
    BasicRaytracingRender render = new BasicRaytracingRender(raster);
    SceneObject interaction = render.findInteraction(ray, scene);
    assertEquals(list.get(1), interaction);
  }

  @Test
  public void testGetColor() {
    List<SceneObject> list = Collections.singletonList(
            new Sphere(new Transform(Vector3.FORWARD.multiply(3)), 1)
    );
    Ray ray = new Ray(Vector3.ZERO, Vector3.FORWARD);
    Raster raster = new BufferedImageRaster(100, 100);
    Scene scene = new BasicScene(list);
    BasicRaytracingRender render = new BasicRaytracingRender(raster);
    Color color = render.getColor(ray, scene);
    assertEquals(list.get(0).getMesh().color(), color);
  }

  @Test
  public void testGetColorNoInteraction() {
    Ray ray = new Ray(Vector3.ZERO, Vector3.FORWARD);
    Raster raster = new BufferedImageRaster(100, 100);
    Scene scene = new BasicScene(Collections.emptyList());
    BasicRaytracingRender render = new BasicRaytracingRender(raster);
    Color color = render.getColor(ray, scene);
    assertEquals(scene.getBackgroundColor(), color);
  }

  @Test
  public void testRender() {
    List<SceneObject> list = Arrays.asList(
            new Sphere(new Transform(Vector3.FORWARD.multiply(-3)), 1),
            new Camera(new Transform(Vector3.ZERO))
    );
    Raster raster = new BufferedImageRaster(100, 100);
    Scene scene = new BasicScene(list);
    BasicRaytracingRender render = new BasicRaytracingRender(raster);
    render.render(scene);
    assertEquals(list.get(0).getMesh().color(), raster.getPixelColor(49, 49));
  }

  @Test(expected = NoCameraException.class)
  public void testRenderNoCamera() {
    List<SceneObject> list = Collections.singletonList(
            new Sphere(new Transform(Vector3.FORWARD.multiply(3)), 1)
    );
    Raster raster = new BufferedImageRaster(100, 100);
    Scene scene = new BasicScene(list);
    BasicRaytracingRender render = new BasicRaytracingRender(raster);
    render.render(scene);
  }
}
