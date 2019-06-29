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

//        Mirror(new TreeNode(3));
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(32);
        node.next=node1;
        ListNode node2 = FindKthToTail(node,2);
        System.out.println(node2.val);

    }

    public  void convert(StringBuilder name){
      name.append("dasfasdf");
    }

    public  void convert(Integer name){
      name=3;
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

    public static class ListNode {
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

    public double Power(double base, int exponent) {
        double mul = 1.0;
        if (exponent == 0) return 1.0000000;

        if (base < 0.0000001 && base > -0.0000001) {
            return 0;
        }

        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                mul = mul * base;
            }
        } else {
            exponent = -exponent;
            for (int i = 0; i < exponent; i++) {
                mul = mul * base;
            }
            mul = 1.0 / mul;
        }

        return mul;
    }

    public static ListNode FindKthToTail(ListNode head, int k) {

        int size=getSize(head);
        System.out.println(head);

        int index = size-k;
        int index1=0;
        while (head!=null){
            if(index1==index) {
                break;
            }
            head = head.next;
            index1++;
        }

        return head;

    }

    public static ListNode FindKthToTai1(ListNode head, int k) {

        if(head==null) return head;

        ListNode node = FindKthToTai1(head.next,k);

        return node;
    }

    public static ListNode ReverseList(ListNode head) {

        if(head==null || head.next==null) return head;

        ListNode node = ReverseList(head.next);

        head.next.next=head;
        head.next=null;

        return node;
    }

    public static int getSize(ListNode head){
        int size=0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if(root1==null || root2 ==null) return false;


        return isSubtree(root1,root2)||HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);

    }

    public boolean isSubtree(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val==root2.val){
            return isSubtree(root1.left,root2.left)&&isSubtree(root1.right,root2.right);
        }
        return false;
    }
}