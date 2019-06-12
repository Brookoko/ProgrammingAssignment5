package labs.introtoprogramming.lab5.gui;

import java.awt.Canvas;
import java.awt.Graphics;
import labs.introtoprogramming.lab5.graphics.Raster;

public class RasterRendererComponent extends Canvas {

  private Raster raster;

  private int framesRendered = 0;

  @Override
  public void update(Graphics g) {
    g.drawImage(raster.toImage(), 0, 0, this);
    framesRendered++;
  }

  void setRaster(Raster raster) {
    this.raster = raster;
  }

  int getFramesRendered() {
    return framesRendered;
  }

  void resetFramesRendered() {
    this.framesRendered = 0;
  }
}
