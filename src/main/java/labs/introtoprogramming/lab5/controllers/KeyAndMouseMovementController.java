package labs.introtoprogramming.lab5.controllers;

import labs.introtoprogramming.lab5.gui.Input;
import labs.introtoprogramming.lab5.scene.SceneObject;

public class KeyAndMouseMovementController extends Controller {

  private static double DEFAULT_MOVEMENT_SPEED = 0.0015;
  private static double DEFAULT_MOUSE_SENSITIVITY = 0.006;
  private double movementSpeed = DEFAULT_MOVEMENT_SPEED;
  private double mouseSensitivity = DEFAULT_MOUSE_SENSITIVITY;

  private SceneObject controllableObject;

  public KeyAndMouseMovementController(SceneObject controllableObject) {
    this.controllableObject = controllableObject;
  }

  @Override
  public void update(int delta, Input input) {
    controllableObject.getTransform().setPosition(controllableObject.getTransform().position().add(
            input.movementVector().multiply(movementSpeed * delta)
    ));
    controllableObject.getTransform().setRotation(controllableObject.getTransform().rotation().add(
            input.mouseMovement().multiply(mouseSensitivity * delta)
    ));
  }
}
