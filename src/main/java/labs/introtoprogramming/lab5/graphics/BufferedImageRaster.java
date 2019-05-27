package labs.introtoprogramming.lab5.graphics;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BufferedImageRaster implements Raster {

  private final BufferedImage image;

  public BufferedImageRaster(int width, int height) {
    // Image Data Model compatible with default screen device to avoid any conversions while rendering
    image = GraphicsEnvironment.getLocalGraphicsEnvironment()
              .getDefaultScreenDevice()
              .getDefaultConfiguration().createCompatibleImage(width, height);
  }

  @Override
  public Image toImage() {
    return image;
  }

  @Override
  public void setPixel(int x, int y, int rgb) {
    image.setRGB(x, y, rgb);
  }

  @Override
  public void setPixel(int x, int y, byte red, byte green, byte blue) {
    image.setRGB(x, y, 0xFF << 24 | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | (blue & 0xFF));
  }

  @Override
  public Color getPixelColor(int x, int y) {
    return new Color(image.getRGB(x, y));
  }

  @Override
  public int getPixelRGB(int x, int y) {
    return image.getRGB(x, y);
  }

  @Override
  public int getWidth() {
    return image.getWidth();
  }

  @Override
  public int getHeight() {
    return image.getHeight();
  }
}
