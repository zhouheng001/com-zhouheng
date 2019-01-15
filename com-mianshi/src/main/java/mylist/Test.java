package mylist;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-14 下午 11:24
 */
public class Test {
    /**
     * @see MyList
     * @param args
     */
    public static void main(String[] args) {

        MyList<String> myList = new MyList();
        myList.add("23");
        myList.add("34");
        myList.add("45");

        System.out.println(myList);

        MyList<String>.Node node = myList.getNode();
        while (node!=null){
            System.out.println(node.getData());
            node = node.getN();
        }
    }

    public static void reverse(MyList myList){
        MyList.Node node = myList.getNode();


    }

}
