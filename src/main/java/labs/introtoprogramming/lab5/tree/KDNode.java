package labs.introtoprogramming.lab5.tree;

import labs.introtoprogramming.lab5.geometry.Ray;
import labs.introtoprogramming.lab5.object.Box;
import labs.introtoprogramming.lab5.scene.SceneObject;

import java.util.List;

public class KDNode {
  Box boundaryBox;
  private KDNode[] children;

  private List<SceneObject> objects;

  public KDNode(List<SceneObject> objects, Box boundaryBox, KDNode[] children) {
    this.objects = objects;
    this.boundaryBox = boundaryBox;
    this.children = children;
  }

  public SceneObject intersect(Ray ray) {
    if (boundaryBox.intersect(ray)) {
      SceneObject res = checkChildren(ray);
      if (res != null) {
        return res;
      }
      double minDist = Double.MAX_VALUE;
      for (SceneObject obj : objects) {
        if (obj.intersect(ray)) {
          double dist = ray.getScale();
          if (dist < minDist) {
            minDist = dist;
            res = obj;
          }
        }
      }
      return res;
    }
    return null;
  }

  private SceneObject checkChildren(Ray ray) {
    SceneObject res;
    for (KDNode node : children) {
      if (node == null) {
        continue;
      }
      res = node.intersect(ray);
      if (res != null) {
        return res;
      }
    }
    return null;
  }
}
