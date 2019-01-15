package tree;

import lombok.Data;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-15 17:04
 */
@Data
public class MyTree {
  private int value;
  private MyTree left;
  private MyTree right;

  public MyTree() {
  }

  public MyTree(int value, MyTree left, MyTree right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}
