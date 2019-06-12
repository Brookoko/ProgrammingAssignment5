package labs.introtoprogramming.lab5.object;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.geometry.Vector3;
import labs.introtoprogramming.lab5.scene.SceneObject;
import labs.introtoprogramming.lab5.scene.Transform;
import labs.introtoprogramming.lab5.tree.KDTree;

import java.util.List;

public class OptimizedObject extends SceneObject {
  private KDTree tree;

  public OptimizedObject(Transform transform, List<SceneObject> objects) {
    super(transform);
    for (SceneObject obj : objects) {
      obj.getTransform().setParent(transform);
    }
    tree = new KDTree(objects);
  }

  @Override
  public boolean intersect(Ray ray) {
    return tree.intersect(ray);
  }

  @Override
  public Box getBoundary() {
    return tree.boundary();
  }

  @Override
  public Vector3 getNormal(Vector3 hitPoint) {
    SceneObject obj = tree.getIntersection();
    if (obj == null) {
      return super.getNormal(hitPoint);
    }
    return obj.getNormal(hitPoint);
  }
}
