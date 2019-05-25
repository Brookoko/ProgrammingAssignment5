package labs.introtoprogramming.lab5.graphics;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.image.BufferedImage;
import org.junit.Test;

public class ArrayRasterTests {

  @Test
  public void testSetPixelRGB() {
    Raster raster = new ArrayRaster(100, 100);
    raster.setPixel(0, 0, 42);
    assertEquals(42, raster.getPixelRGB(0, 0) & 0xFFFFFF);
  }

  @Test
  public void testSetPixel() {
    Raster raster = new ArrayRaster(100, 100);
    raster.setPixel(1, 2, (byte) 1, (byte) 2, (byte) 3);
    assertEquals(new Color(1, 2, 3).getRGB(), raster.getPixelRGB(1, 2));
  }

  @Test
  public void testGetPixelColor() {
    Raster raster = new ArrayRaster(100, 100);
    raster.setPixel(1, 2, (byte) 255, (byte) 0, (byte) 0);
    assertEquals(Color.RED, raster.getPixelColor(1, 2));
  }

  @Test
  public void testToImage() {
    Raster raster = new ArrayRaster(2, 2);
    raster.setPixel(1, 1, Color.RED.getRGB());
    assertEquals(Color.RED.getRGB(), ((BufferedImage) raster.toImage()).getRGB(1, 1));
  }
}
