package lock;

import pojo.Person;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-02 下午 3:40
 */
public class MyThreadLocal {

    public static void main(String[] args) {

        ThreadLocal threadLocal = new ThreadLocal(){
            @Override
            protected Object initialValue() {
                return super.initialValue();
            }
        };

        Person person = new Person(){
            @Override
            public void setName(String name) {
                super.setName(name+"重写set");
            }
        };
        person.setName("123");
        System.out.println(person.getName());

    }

}
