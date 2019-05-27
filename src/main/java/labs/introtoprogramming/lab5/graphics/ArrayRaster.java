package labs.introtoprogramming.lab5.graphics;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ArrayRaster implements Raster {

  private final int width;
  private final int height;

  private byte[][] red;
  private byte[][] green;
  private byte[][] blue;

  public ArrayRaster(int width, int height) {
    this.width = width;
    this.height = height;
    this.red = new byte[width][height];
    this.green = new byte[width][height];
    this.blue = new byte[width][height];
  }

  public Image toImage() {
    BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setRGB(x, y, getPixelRGB(x, y));
      }
    }
    return image;
  }

  public void setPixel(int x, int y, int rgb) {
    this.red[x][y] = (byte) ((rgb >> 16) & 0xFF);
    this.green[x][y] = (byte) ((rgb >> 8) & 0xFF);
    this.blue[x][y] = (byte) (rgb & 0xFF);
  }

  public void setPixel(int x, int y, byte red, byte green, byte blue) {
    this.red[x][y] = red;
    this.green[x][y] = green;
    this.blue[x][y] = blue;
  }

  public Color getPixelColor(int x, int y) {
    return new Color(red[x][y] & 255, green[x][y] & 255, blue[x][y] & 255);
  }

  public int getPixelRGB(int x, int y) {
    return 0xFF << 24 | ((red[x][y] & 0xFF) << 16) | ((green[x][y] & 0xFF) << 8) | (blue[x][y] & 0xFF);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
