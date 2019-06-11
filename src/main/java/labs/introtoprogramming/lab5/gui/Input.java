package labs.introtoprogramming.lab5.gui;

import labs.introtoprogramming.lab5.geometry.Vector3;

public class Input {

  private boolean forwardKeyDown = false;
  private boolean backwardKeyDown = false;
  private boolean leftKeyDown = false;
  private boolean rightKeyDown = false;
  private boolean upKeyDown = false;
  private boolean downKeyDown = false;

  private double mouseDeltaX = 0;
  private double mouseDeltaY = 0;

  public Vector3 movementVector() {
    return new Vector3((leftKeyDown ? -1 : 0) + (rightKeyDown ? 1 : 0),
              (upKeyDown ? 1 : 0) + (downKeyDown ? -1 : 0),
            (forwardKeyDown ? -1 : 0) + (backwardKeyDown ? 1 : 0));
  }

  public Vector3 mouseMovement() {
    //noinspection SuspiciousNameCombination
    return new Vector3(mouseDeltaY, mouseDeltaX, 0);
  }

  public void setMouseDeltaX(double mouseDeltaX) {
    this.mouseDeltaX = mouseDeltaX;
  }

  public void setMouseDeltaY(double mouseDeltaY) {
    this.mouseDeltaY = mouseDeltaY;
  }

  public void setForwardKeyDown(boolean forwardKeyDown) {
    this.forwardKeyDown = forwardKeyDown;
  }

  public void setBackwardKeyDown(boolean backwardKeyDown) {
    this.backwardKeyDown = backwardKeyDown;
  }

  public void setLeftKeyDown(boolean leftKeyDown) {
    this.leftKeyDown = leftKeyDown;
  }

  public void setRightKeyDown(boolean rightKeyDown) {
    this.rightKeyDown = rightKeyDown;
  }

  public void setUpKeyDown(boolean upKeyDown) {
    this.upKeyDown = upKeyDown;
  }

  public void setDownKeyDown(boolean downKeyDown) {
    this.downKeyDown = downKeyDown;
  }
}
