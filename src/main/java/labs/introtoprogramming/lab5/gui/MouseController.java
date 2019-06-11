package labs.introtoprogramming.lab5.gui;

import java.awt.AWTException;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

class MouseController {

  private static final String BLANK_CURSOR_NAME = "blank cursor";

  private Input input;
  private JFrame frame;

  private Robot robot;
  private Point prevLocation;

  MouseController(Input input, JFrame frame) {
    this.input = input;
    this.frame = frame;
    try {
      this.robot = new Robot();
    } catch(AWTException e) {
      throw new AssertionError(e);
    }
  }

  void hideCursor() {
    BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
    Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            cursorImg, new Point(0, 0), BLANK_CURSOR_NAME);
    frame.setCursor(blankCursor);
  }

  void update() {
    if (!frame.isFocused()) {
      return;
    }

    int centerX = frame.getX() + frame.getWidth() / 2;
    int centerY = frame.getY() + frame.getHeight() / 2;
    Point mouseLocation = MouseInfo.getPointerInfo().getLocation();

    if (prevLocation != null) {
      input.setMouseDeltaX(mouseLocation.getX() - centerX);
      input.setMouseDeltaY(mouseLocation.getY() - centerY);
    }

    prevLocation = mouseLocation;
    robot.mouseMove(centerX, centerY);
  }

}
