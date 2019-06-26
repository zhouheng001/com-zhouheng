package niukesuanfa;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

class Solution {

    public static void main(String[] args) {

//        Integer a = 10;
//        Integer b = 10;
//        Integer c = new Integer(10);
//        Integer d = new Integer( 10);
//        System.out.println(a.equals(b));
//        System.out.println(c.equals(d));
//        System.out.println(c == d);
//        System.out.println(a == b);

        Mirror(new TreeNode(3));
    }

    public static boolean Find(int target, Vector<Vector<Integer>> array) {

        boolean exist = false;

        for (Vector<Integer> integers : array) {
            for (Integer integer : integers) {
                if (integer.equals(target)) exist = true;
            }
        }


        return exist;
    }

    public String replaceSpace(StringBuffer str) {
        String str1 = String.valueOf(str);
        return str1.replaceAll(" ", "%20");
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList list = new ArrayList();

        ListNode reverse = reverse(listNode);

        while (reverse != null) {
            list.add(reverse.val);
            reverse = reverse.next;
        }


        return list;
    }

    public ListNode reverse(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }

        ListNode reverse = reverse(listNode.next);

        listNode.next.next = listNode;
        listNode.next = null;

        return reverse;

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        Integer re = null;
        if (!stack2.empty()) {
            re = stack2.pop();
        } else {

            while (!stack1.empty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }

            if (!stack2.empty()) {
                re = stack2.pop();
            }

        }

        return re;
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[0]) {
                array[0] = array[i];
            }
        }

        return array[0];
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void Mirror(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) return;

        TreeNode mid = root.left;
        root.left = root.right;
        root.right = mid;

        Mirror(root.left);
        Mirror(root.right);
    }


}