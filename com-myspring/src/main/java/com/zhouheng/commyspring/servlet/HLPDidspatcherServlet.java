package com.zhouheng.commyspring.servlet;

import com.zhouheng.commyspring.anno.HLPAutowired;
import com.zhouheng.commyspring.anno.HLPController;
import com.zhouheng.commyspring.anno.HLPRequestMapping;
import com.zhouheng.commyspring.anno.HLPService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class HLPDidspatcherServlet extends HttpServlet {
    private Properties p = new Properties();
    private List<String> classNames = new ArrayList<String>();
    private Map<String, Object> ioc = new HashMap<String, Object>();
    private Map<String, Method> handlerMapping = new HashMap<String, Method>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        String application = config.getInitParameter("contextConfigLocation");
        System.out.println("application = " + application);


        //1.加载配置文件application.properties
        doLoadConfig(application);

        //2.扫描配置文件中描述的相关的所有类
        doScanner(p.getProperty("scanPackage"));
        //3.实例化所有扫描到的类，并放到ioc容器中（自己实现ioc容器）
        doInstance();
        //4.依赖注入，di从ioc容器中找到加@autowired这个注解的属性，并找到其在ioc容器中的实例，动态赋值
        doAutowired();
        //5.把在@controller中加了@requestMapping这个注解的方法和url构造成一个对应关系，一个map结构，key是URL；value是method
        initHandlerMapping();
        //6.等待用户请求，根据用户请求的url去map中找对应的method
        //   调用doPost/doGet方法，通过反射机制动态调用该方法并执行

    }

    //1.加载配置文件application.properties
    private void doLoadConfig(String location) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(location);
        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //2.扫描配置文件中描述的相关的所有类
    //递归扫描
    private void doScanner(String packageName) {
        URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(packageName + "." + file.getName());
            } else {
                classNames.add(packageName + "." + file.getName().replaceAll(".class", "").trim());
            }
        }
    }

    //3.实例化所有扫描到的类，并放到ioc容器中（自己实现ioc容器）
    private void doInstance() {
        try {
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(HLPController.class)) {
                    String beanName = lowerFirst(clazz.getSimpleName());
                    ioc.put(beanName, clazz.newInstance());
                } else if (clazz.isAnnotationPresent(HLPService.class)) {
                    //第一种形式，默认首字母小写
                    //第二种形式，如果自己起了名字，优先用自己定义的名字去匹配
                    //第三种形式，利用接口本身作为key，把其对应类的实例作为值
                    HLPService service = clazz.getAnnotation(HLPService.class);
                    String beanName = service.value();

                    if (!"".equals(beanName.trim())) {
                        ioc.put(beanName, clazz.newInstance());
                        continue;
                    }
                    Object instance = clazz.newInstance();

                    beanName = lowerFirst(clazz.getSimpleName());
                    ioc.put(beanName, instance);

                    Class<?>[] interfaces = clazz.getInterfaces();
                    for (Class<?> i : interfaces) {
                        ioc.put(i.getName(), instance);
                    }
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //4.依赖注入，di从ioc容器中找到加@autowired这个注解的属性，并找到其在ioc容器中的实例，动态赋值
    private void  doAutowired(){
        if(ioc.isEmpty()){return;}

        for(Map.Entry<String,Object> entry: ioc.entrySet() ){
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for(Field field: fields){
                if(!field.isAnnotationPresent(HLPAutowired.class)){continue;}
                HLPAutowired autowired = field.getAnnotation(HLPAutowired.class);

                String beanName = autowired.value().trim();
                if("".equals(beanName)){
                    beanName=field.getType().getName();
                }
                //即使是private，也要强吻
                field.setAccessible(true);
                //开始赋值
                try {
                    field.set(entry.getValue(),ioc.get(beanName));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //5.把在@controller中加了@requestMapping这个注解的方法和url构造成一个对应关系，一个map结构，key是URL；value是method
    private  void initHandlerMapping(){
        if(ioc.isEmpty()){return;}
        for(Map.Entry<String,Object> entry: ioc.entrySet()){
            Class<?> clazz = entry.getValue().getClass();
            if(!clazz.isAnnotationPresent(HLPController.class)){continue;}

            String url = "";
            if(clazz.isAnnotationPresent(HLPRequestMapping.class)){
                HLPRequestMapping requestMapping = clazz.getAnnotation(HLPRequestMapping.class);
                url = requestMapping.value();
            }
            Method[] methods = clazz.getMethods();
            for(Method method:methods){
                if(!method.isAnnotationPresent(HLPRequestMapping.class)){continue;}
                HLPRequestMapping hlpRequestMapping = method.getAnnotation(HLPRequestMapping.class);
                String mapping =("/"+url+"/"+hlpRequestMapping.value()).replaceAll("/+","/") ;
                handlerMapping.put(mapping,method);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatcher(req,resp);
    }

    private void   doDispatcher(HttpServletRequest req, HttpServletResponse resp){
        if(handlerMapping.isEmpty()){return;}

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath,"").replaceAll("/+","/");

        Method method = handlerMapping.get(url);
    }

    /**
     * 把字符串的首字母小写
     *
     * @param name
     * @return
     */
    private String lowerFirst(String name) {
        char[] charArray = name.toCharArray();
        charArray[0] += 32;
        return String.valueOf(charArray);
    }

}
