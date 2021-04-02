package com.zhouheng.hutool;

import cn.hutool.Hutool;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.emoji.EmojiUtil;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2021-01-28 9:26 上午
 */
public class HutoolTest {

    public static void main(String[] args) {
        Set<Class<?>> allUtils = Hutool.getAllUtils();
//        for (Class<?> allUtil : allUtils) {
//            System.out.println(allUtil);
//        }

//        String emoji = EmojiUtil.toUnicode(":smile:");
//        System.out.println(emoji);

        List<String> list =new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("2");

//        for (String s : list) {
//            if(!list.contains("2")){
//                break;
//            }
//            if("2".equals(s)){
//                list.remove(s);
//            }
//        }

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){

            String next = iterator.next();
            if("2".equals(next)){
                iterator.remove();
            }
        }

        System.out.println(list);
    }
}
