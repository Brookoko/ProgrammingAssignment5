package labs.introtoprogramming.lab5;

import java.awt.AWTException;
        import java.awt.Robot;
        import java.awt.Toolkit;

public class Main {

  public static void main(String[] args) {
    try {
      new Robot().mouseMove((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
    } catch (AWTException e) {
      e.printStackTrace();
    }
  }
}