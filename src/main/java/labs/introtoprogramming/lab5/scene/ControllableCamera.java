package labs.introtoprogramming.lab5.scene;

import labs.introtoprogramming.lab5.graphics.Raster;

public class ControllableCamera extends Camera {

  private static double DEFAULT_MOVEMENT_SPEED = 0.0015;
  private static double DEFAULT_MOUSE_SENSITIVITY = 0.006;
  private double movementSpeed = DEFAULT_MOVEMENT_SPEED;
  private double mouseSensitivity = DEFAULT_MOUSE_SENSITIVITY;

  public ControllableCamera(Raster raster, Transform transform) {
    super(raster, transform);
  }

  @Override
  protected void update(int delta) {
    getTransform().setPosition(
            getTransform().position().add(getInput().movementVector().multiply(movementSpeed * delta))
    );
    getTransform().setRotation(getTransform().rotation().add(
            getInput().mouseMovement().multiply(mouseSensitivity * delta)
    ));
  }
}
