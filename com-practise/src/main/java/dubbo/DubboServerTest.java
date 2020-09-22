package dubbo;

import dubbo.Impl.UserServiceImpl;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;
import java.util.List;

/**
 * @author heng.zhou
 * @description: dubbo服务端
 * @create 2020-02-02 4:58 下午
 */
public class DubboServerTest {

    public static void main(String[] args) throws IOException {
       DubboServerTest dubboServerTest = new DubboServerTest();
//       dubboServerTest.openServer(20880);
        dubboServerTest.openServer(-1);
       System.in.read();
    }

    public void openServer(int port) {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("simple-app");

        ProtocolConfig protocolConfig=new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(port);
        protocolConfig.setThreads(20);

        //服务配置
        ServiceConfig<UserService> serviceConfig=new ServiceConfig();
        //设置当前所在应用
        serviceConfig.setApplication(config);
        //配置服务协议
        serviceConfig.setProtocol(protocolConfig);
        //设置一个空的注册中心
        serviceConfig.setRegistry(new RegistryConfig("multicast://224.1.1.1:12345"));
        serviceConfig.setLoadbalance("roundrobin");
        //设置服务接口
        serviceConfig.setInterface(UserService.class);
        //设置服务实现对象
        UserServiceImpl userService = new UserServiceImpl();
        serviceConfig.setRef(userService);
        //暴露服务
        serviceConfig.export();

        List<URL> exportedUrls = serviceConfig.getExportedUrls();
        userService.setPort(exportedUrls.get(0).getPort());
        System.out.println("服务已开启");
    }
}
