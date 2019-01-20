package tree;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-15 17:24
 */
public class Test {

    public static void main(String[] args) {
        MyTree node = new MyTree(1);

        MyTree node1 = new MyTree(2);
        MyTree node2 = new MyTree(3);

        MyTree node3 = new MyTree(4);
        MyTree node4 = new MyTree(5);
        MyTree node5 = new MyTree(6);
        MyTree node6 = new MyTree(7);

        node.setLeftMode(node1);
        node.setRightMode(node2);

        node1.setLeftMode(node3);
        node1.setRightMode(node4);
        node2.setLeftMode(node5);
        node2.setRightMode(node6);

        /** 输出二叉树的第n层所有节点*/

        getCengNode(node,3);

    }

    public static void getCengNode(MyTree myTree,int n){
        if(myTree==null){
            return;
        }

        if(n==1){
            System.out.println(myTree.getValue());
            return;
        }

        n--;

        getCengNode(myTree.getLeftMode(),n);
        getCengNode(myTree.getRightMode(),n);



    }
}
