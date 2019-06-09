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

  public double getMouseDeltaX() {
    return mouseDeltaX;
  }

  public void setMouseDeltaX(double mouseDeltaX) {
    this.mouseDeltaX = mouseDeltaX;
  }

  public double getMouseDeltaY() {
    return mouseDeltaY;
  }

  public void setMouseDeltaY(double mouseDeltaY) {
    this.mouseDeltaY = mouseDeltaY;
  }

  public boolean isForwardKeyDown() {
    return forwardKeyDown;
  }

  public void setForwardKeyDown(boolean forwardKeyDown) {
    this.forwardKeyDown = forwardKeyDown;
  }

  public boolean isBackwardKeyDown() {
    return backwardKeyDown;
  }

  public void setBackwardKeyDown(boolean backwardKeyDown) {
    this.backwardKeyDown = backwardKeyDown;
  }

  public boolean isLeftKeyDown() {
    return leftKeyDown;
  }

  public void setLeftKeyDown(boolean leftKeyDown) {
    this.leftKeyDown = leftKeyDown;
  }

  public boolean isRightKeyDown() {
    return rightKeyDown;
  }

  public void setRightKeyDown(boolean rightKeyDown) {
    this.rightKeyDown = rightKeyDown;
  }

  public boolean isUpKeyDown() {
    return upKeyDown;
  }

  public void setUpKeyDown(boolean upKeyDown) {
    this.upKeyDown = upKeyDown;
  }

  public boolean isDownKeyDown() {
    return downKeyDown;
  }

  public void setDownKeyDown(boolean downKeyDown) {
    this.downKeyDown = downKeyDown;
  }

}
