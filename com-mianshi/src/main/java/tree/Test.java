package tree;

import com.alibaba.fastjson.JSONObject;

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

//        getCengNode(node, 3);

        int ceng = getCeng(node);
        System.out.println(ceng);

//        for (int i=1;i<=ceng;i++){
//            getCengNode(node,i);
//            System.out.println();
//        }


    }

    public static void getCengNode(MyTree myTree, int n) {
        if (myTree == null) {
            return;
        }

        if (n == 1) {
            System.out.print(myTree.getValue() + " ");
            return;
        }

        n--;

        getCengNode(myTree.getLeftMode(), n);
        getCengNode(myTree.getRightMode(), n);


    }

    public static int getCeng(MyTree myTree) {
        if (myTree == null) return 0;

        return Math.max(getCeng(myTree.getLeftMode()), getCeng(myTree.getRightMode())) + 1;
    }


    public static int getCeng1(MyTree myTree) {
        if (myTree == null) return 0;

        int ceng1 = getCeng1(myTree.getLeftMode());
        int ceng11 = getCeng1(myTree.getRightMode());

        return (ceng1>ceng11?ceng1:ceng11) +1;
    }


    @org.junit.Test
    public void test() {
        Object o = new Object();
        String s = String.valueOf(o);
        System.out.println(s);
        System.out.println(Integer.toHexString(o.hashCode()));
        String string = JSONObject.toJSONString(o);
        System.out.println(string);
    }

}
