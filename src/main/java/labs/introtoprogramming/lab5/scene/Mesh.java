package labs.introtoprogramming.lab5.scene;

import java.awt.Color;

public class Mesh {

  private Color color;

  public Mesh(Color color) {
    this.color = color;
  }

  public Mesh() {
    this(new Color(255, 255, 255));
  }

  public Color color() {
    return color;
  }
}
