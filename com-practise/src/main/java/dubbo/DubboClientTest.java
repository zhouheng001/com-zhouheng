package dubbo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heng.zhou
 * @description: dubbo
 * @create 2020-02-02 4:57 下午
 */
public class DubboClientTest {

    public static void main(String[] args) throws IOException {
        DubboClientTest dubboClientTest = new DubboClientTest();
        List<UserService> list = new ArrayList<>();
//        list.add(dubboClientTest.buildRemoteService("dubbo://127.0.0.1:20880/dubbo.UserService"));
//        list.add(dubboClientTest.buildRemoteService("dubbo://127.0.0.1:20881/dubbo.UserService"));
//        list.add(dubboClientTest.buildRemoteService("dubbo://127.0.0.1:20882/dubbo.UserService"));
//        list.add(dubboClientTest.buildRemoteService("dubbo://127.0.0.1:20883/dubbo.UserService"));
        UserService userService = dubboClientTest.buildRemoteService(null);

        String cmd;
        int count = 0;
        while (!"exist".equals(cmd = read())) {
            System.out.println(userService.getName(123));
        }
    }

    static String remoteUrl = "dubbo://127.0.0.1:20880/dubbo.UserService";

    // 构建远程服务对象
    public UserService buildRemoteService(String remoteUrl) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("young-app");
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(application);
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setUrl(remoteUrl);
        referenceConfig.setRegistry(new RegistryConfig("multicast://224.1.1.1:12345"));
        UserService userService = referenceConfig.get();
        return userService;
    }

    private static String read() throws IOException {
        byte[] bytes = new byte[1024];
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(System.in));
        return lineNumberReader.readLine();
    }
}
