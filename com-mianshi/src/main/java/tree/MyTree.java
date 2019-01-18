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
  private MyTree leftMode;
  private MyTree rightMode;

  public MyTree() {
  }

    public MyTree(int value) {
        this.value = value;
    }

    public MyTree(int value, MyTree leftMode, MyTree rightMode) {
    this.value = value;
    this.leftMode = leftMode;
    this.rightMode = rightMode;
  }
}
