package labs.introtoprogramming.lab5.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class InputKeyListener implements KeyListener {

  private Input input;

  InputKeyListener(Input input) {
    this.input = input;
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // ignore
  }

  @Override
  public void keyPressed(KeyEvent e) {
    keyCodeUpdate(e.getKeyCode(), true);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    keyCodeUpdate(e.getKeyCode(), false);
  }

  private void keyCodeUpdate(int keyCode, boolean isDown) {
    if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
      input.setForwardKeyDown(isDown);
    }
    if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
      input.setBackwardKeyDown(isDown);
    }
    if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
      input.setLeftKeyDown(isDown);
    }
    if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
      input.setRightKeyDown(isDown);
    }
    if (keyCode == KeyEvent.VK_Q) {
      input.setUpKeyDown(isDown);
    }
    if (keyCode == KeyEvent.VK_Z) {
      input.setDownKeyDown(isDown);
    }
  }
}
