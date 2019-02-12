package javadevelopmentprotocol;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-23 15:43
 */
public class AliProtocol {
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if ("2".equals(item)) {
//                iterator.remove();
//            }
//        }
//
//        //反例
//        for (String item : list) {
//            if ("1".equals(item)) {
//                list.remove(item);
//            }
//        }

        testNPE();

    }

    void myTestMap() {
        Map maps = new HashMap();
    }

    /**
     * 时间规范
     *
     * @Description 如果是 JDK 8 的应用，
     * 可以使用 Instant 代替 Date ，
     * LocalDateTime 代替 Calendar ，
     * DateTimeFormatter 代替 SimpleDateFormat ，
     * 官方给出的解释： simple beautiful strong
     * immutable thread - safe
     */
    void dateTime() {

    }

    /**
     * 使用 JDK8 的 Optional 类来防止 NPE 问题
     */
    static void testNPE() {
        Optional<Integer> optional = Optional.ofNullable(getNpe(3));

        Integer integer = optional.get();
        System.out.println(integer);

    }

    static Integer getNpe(int a) {
        if (a == 2) {
            return null;
        }
        return 3;
    }
}
