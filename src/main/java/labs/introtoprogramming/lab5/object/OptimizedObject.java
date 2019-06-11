package labs.introtoprogramming.lab5.object;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.scene.SceneObject;
import labs.introtoprogramming.lab5.scene.Transform;
import labs.introtoprogramming.lab5.tree.KDTree;

import java.util.ArrayList;

public class OptimizedObject extends SceneObject {
  private KDTree tree;

  public OptimizedObject(Transform transform, ArrayList<SceneObject> objects) {
    super(transform);
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
}
