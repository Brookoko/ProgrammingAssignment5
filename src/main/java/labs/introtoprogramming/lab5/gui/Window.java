package labs.introtoprogramming.lab5.gui;

import java.awt.Toolkit;
import javax.swing.JFrame;
import labs.introtoprogramming.lab5.graphics.Raster;

public class Window {

  private static final int FPS_UPDATE_RATE = 100;

  private JFrame frame;
  private RasterRendererComponent renderer;
  private Toolkit toolkit;
  private String title;

  private boolean displayFPS = false;
  private long prevFPSTimestamp = -1;

  public Window() {
    System.setProperty("sun.java2d.opengl", "true");

    this.toolkit = Toolkit.getDefaultToolkit();

    this.frame = new JFrame();
    this.frame.setLayout(null);
    this.frame.setResizable(false);

    this.renderer = new RasterRendererComponent();
    this.frame.add(renderer);

    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void updateFPSCounter() {
    if (displayFPS && renderer.getFramesRendered() >= FPS_UPDATE_RATE) {
      long currentTime = System.currentTimeMillis();
      if (prevFPSTimestamp != -1) {
        double fps = Math.round(1000.0 / ((double) (currentTime - prevFPSTimestamp) / renderer.getFramesRendered()));
        frame.setTitle(title + " " + ((int) fps) + "FPS");
      }
      prevFPSTimestamp = currentTime;
      renderer.resetFramesRendered();
    }
  }

  public void update() {
    renderer.repaint();
    toolkit.sync();

    updateFPSCounter();
  }

  public void show() {
    frame.setVisible(true);
  }

  public void setDimensions(int width, int height) {
    // Centered on the screen
    frame.setBounds(getScreenWidth() / 2 - width / 2, getScreenHeight() / 2 - height / 2, width, height);
    renderer.setBounds(0, 0, width, height);
  }

  private int getScreenWidth() {
    return toolkit.getScreenSize().width;
  }

  private int getScreenHeight() {
    return toolkit.getScreenSize().height;
  }

  public void setTitle(String text) {
    this.title = text;
    frame.setTitle(text);
  }

  public void setRaster(Raster raster) {
    this.renderer.setRaster(raster);
  }
  
  public void setDisplayFPS(boolean displayFPS) {
    this.displayFPS = displayFPS;
  }
}
