package com.tujia.com.aopandannotation.aop;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-05 下午 6:06
 */
public class TestAopLayout extends PatternLayout {

    static {
        defaultConverterMap.put("trace_id", BingoTraceIdConverter.class.getName());
    }

    public TestAopLayout() {
        super();
    }

    public static class BingoTraceIdConverter extends ClassicConverter {


        @Override
        public String convert(ILoggingEvent iLoggingEvent) {
            return "123";
        }
    }
}
