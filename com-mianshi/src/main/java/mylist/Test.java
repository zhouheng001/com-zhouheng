package mylist;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-14 下午 11:24
 */
public class Test {
    /**
     * @param args
     * @see MyList
     */
    public static void main(String[] args) {
        MyList<String> myList = new MyList();
        myList.add("23");
        myList.add("34");
        myList.add("45");

        System.out.println(myList);

        MyList<String>.Node node = myList.getNode();
        while (node != null) {
            System.out.println(node.getData());
            node = node.getN();
        }

        /** 反转 */
        reverse(myList);
        MyList<String>.Node node1 = myList.getNode();
        while (node1 != null) {
            System.out.println(node1.getData());
            node1 = node1.getN();
        }
    }

    public static void reverse(MyList myList) {
        if (myList.getSize() == 0) {
            return;
        }

        MyList.Node node = reverseNode(myList.getNode());
        myList.setNode(node);

    }

    public static MyList.Node reverseNode(MyList.Node node) {
        if (node == null || node.getN() == null) {
            return node;
        }

        MyList.Node n = reverseNode(node.getN());
        node.getN().setN(node);
        node.setN(null);


        return n;
    }
}
