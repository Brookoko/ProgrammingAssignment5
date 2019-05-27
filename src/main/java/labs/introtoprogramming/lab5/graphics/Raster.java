package labs.introtoprogramming.lab5.graphics;

import java.awt.Color;
import java.awt.Image;

public interface Raster {

  Image toImage();

  void setPixel(int x, int y, int rgb);
  void setPixel(int x, int y, byte red, byte green, byte blue);

  Color getPixelColor(int x, int y);
  int getPixelRGB(int x, int y);

  int getWidth();
  int getHeight();

}