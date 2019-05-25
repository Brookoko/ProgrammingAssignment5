package labs.introtoprogramming.lab5.graphics;

public class Raster {

  private final int width;
  private final int height;

  private byte[][] red;
  private byte[][] green;
  private byte[][] blue;

  public Raster(int width, int height) {
    this.width = width;
    this.height = height;
    this.red = new byte[width][height];
    this.green = new byte[width][height];
    this.blue = new byte[width][height];
  }

  public void setPixel(int x, int y, byte red, byte green, byte blue) {
    this.red[x][y] = red;
    this.green[x][y] = green;
    this.blue[x][y] = blue;
  }
}
