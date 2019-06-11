package labs.introtoprogramming.lab5.gui;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;
import labs.introtoprogramming.lab5.geometry.Vector3;
import org.junit.Test;

public class InputTests {

  @Test
  public void testKeyForward() {
    Input input = new Input();
    input.setForwardKeyDown(true);
    assertEquals(new Vector3(0, 0, -1), input.movementVector());
  }

  @Test
  public void testKeyBackward() {
    Input input = new Input();
    input.setBackwardKeyDown(true);
    assertEquals(new Vector3(0, 0, 1), input.movementVector());
  }

  @Test
  public void testKeyLeft() {
    Input input = new Input();
    input.setLeftKeyDown(true);
    assertEquals(new Vector3(-1, 0, 0), input.movementVector());
  }

  @Test
  public void testKeyRight() {
    Input input = new Input();
    input.setRightKeyDown(true);
    assertEquals(new Vector3(1, 0, 0), input.movementVector());
  }

  @Test
  public void testKeyUp() {
    Input input = new Input();
    input.setUpKeyDown(true);
    assertEquals(new Vector3(0, 1, 0), input.movementVector());
  }

  @Test
  public void testKeyDown() {
    Input input = new Input();
    input.setDownKeyDown(true);
    assertEquals(new Vector3(0, -1, 0), input.movementVector());
  }

  @Test
  public void testMouseDelta() {
    Input input = new Input();
    input.setMouseDeltaX(2);
    input.setMouseDeltaY(3);
    assertEquals(new Vector3(3, 2, 0), input.mouseMovement());
  }
}
