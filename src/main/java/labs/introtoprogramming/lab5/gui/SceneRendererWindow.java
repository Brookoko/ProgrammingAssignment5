package labs.introtoprogramming.lab5.gui;

import java.util.Timer;
import java.util.TimerTask;
import labs.introtoprogramming.lab5.exception.NoCameraException;
import labs.introtoprogramming.lab5.scene.BasicRaytracingRender;
import labs.introtoprogramming.lab5.scene.Scene;
import labs.introtoprogramming.lab5.scene.SceneRender;

public class SceneRendererWindow extends Window {

  private static final String UPDATE_LOOP_TIMER_NAME = "UpdateLoop";
  private static final int UPDATE_LOOP_DELAY = 100; // ms
  private static final int TARGET_FPS = 60;
  private static final int UPDATE_RATE = 1000/TARGET_FPS;

  private SceneRender render;
  private Scene scene;
  private MouseController mouseController;
  private Input input;

  public SceneRendererWindow(Scene scene) {
    this(new BasicRaytracingRender(scene), scene);
  }

  public SceneRendererWindow(SceneRender render, Scene scene) {
    this.render = render;
    this.scene = scene;
    input = new Input();
    scene.getCamera().ifPresent(camera -> setRaster(camera.raster()));
    mouseController = new MouseController(input, frame);
  }

  public void show() {
    super.show();
    startUpdateLoop();
    setupKeyboardListener();
    mouseController.hideCursor();
  }

  private void setupKeyboardListener() {
    frame.addKeyListener(new InputKeyListener(input));
  }

  private void startUpdateLoop() {
    new Timer(UPDATE_LOOP_TIMER_NAME, true).scheduleAtFixedRate(new TimerTask() {
      long previousTime = System.currentTimeMillis();

      @Override
      public void run() {
        long currentTime = System.currentTimeMillis();
        updateIteration((int) (currentTime - previousTime));
        previousTime = currentTime;
      }
    }, UPDATE_LOOP_DELAY, UPDATE_RATE);
  }

  private void updateIteration(int delta) {
    this.mouseController.update();
    scene.update(delta, input);
    render.render(scene);
    this.update();
  }

  private void setScene(Scene scene) {
    this.scene = scene;
  }
}
