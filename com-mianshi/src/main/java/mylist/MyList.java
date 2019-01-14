package mylist;

import lombok.Data;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-14 下午 11:18
 */
@Data
public class MyList<T> {
    private int size;
    private Node node;

    @Data
    class Node {
        private T data;
        private Node n;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", n=" + n +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", node=" + node +
                '}';
    }

    public void add(T t) {

        if (node == null) {
            node = new Node();
            node.setN(null);
            node.setData(t);
            size++;
        } else {
            Node node1 = new Node();
            node1.setData(t);
            node1.setN(node);
            node= node1;
            size++;
        }
    }

    public T getIndex(int index){

        T t = null;
        for (int i= size-1;i>=index;i--) {
            t = node.getData();
            node = node.getN();
        }
        return t;
    }
}
