package labs.introtoprogramming.lab5.scene;

import labs.introtoprogramming.lab5.geometry.Vector3;

public class Transform {
  private Vector3 position;
  private Vector3 rotation;
  private Vector3 scale;

  public Transform(Vector3 position, Vector3 rotation) {
    this.position = position;
    this.rotation = rotation;
    this.scale = Vector3.one();
  }

  public Transform(Vector3 position) {
    this(position, Vector3.zero());
  }

  public Transform() {
    this(Vector3.zero(), Vector3.zero());
  }

  public Vector3 position() {
    return position.multiply(1);
  }

  public Vector3 rotation() {
    return rotation.multiply(1);
  }

  public Vector3 scale() {
    return scale.multiply(1);
  }

  public void setPosition(Vector3 position) {
    this.position = position;
  }

  public void setRotation(Vector3 rotation) {
    this.rotation = rotation;
  }

  public void setScale(Vector3 scale) {
    this.scale = scale;
  }
}
