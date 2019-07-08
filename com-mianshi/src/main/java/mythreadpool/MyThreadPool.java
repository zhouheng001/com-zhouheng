package mythreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-05-23 下午 8:56
 */
public class MyThreadPool {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

//        List<Integer> list = new ArrayList<>();
//        Random random = new Random();
//        List<String> collect = null;
//        for (int i = 0, j = 0; i < 10000000; i++, j++) {
//            list.add(random.nextInt());
//        }
//
//
//        long l = System.currentTimeMillis();
//        try {
//           collect = forkjoin(list,new Integer(1));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        long l1 = System.currentTimeMillis();
//        System.out.println(l1 - l);



    }

    static <T> List<String> reverse(List<T> list,T t1) throws Exception {
        if (t1 instanceof Integer) {
            return list.parallelStream().map(li -> String.valueOf(li)).collect(Collectors.toList());
        } else {
            throw new Exception("参数不合法");
        }
    }

    static  <T> List<String> forkjoin(List<T> list,T t1) throws Exception {
        if (t1 instanceof Integer) {
            List<String> list1 = new ArrayList<>();
            ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
            MyJoinPool myJoinPool = new MyJoinPool(0,list.size(),list,list1);
            ForkJoinTask<List<String>> submit = forkJoinPool.submit(myJoinPool);
            return submit.get();
        } else {
            throw new Exception("参数不合法");
        }
    }

   private static class MyJoinPool<T> extends RecursiveAction {

       //定义递归子任务的阈值
       private final static int preSize = 1000;

       private int start;

       private int end;

       private List<T> list;

       private List<String> list1;

       public MyJoinPool(int start, int end, List<T> list,List<String> list1) {
           this.start = start;
           this.end = end;
           this.list = list;
           this.list1 = list1;
       }

       @Override
       protected void compute() {
           List<String> sum = null;
           if (end - start < preSize){
              list1 = list.subList(start,end).parallelStream().map(li -> String.valueOf(li)).collect(Collectors.toList());
           }else {
               int middle = (start + end) / 2;
               MyJoinPool sumTask = new MyJoinPool(start, middle,list,list1);
               MyJoinPool sumTask1 = new MyJoinPool(middle, end,list,list1);
               MyJoinPool.invokeAll(sumTask, sumTask1);
           }
       }
   }
}
