package dubbo.Impl;

import dubbo.UserService;

/**
 * @author heng.zhou
 * @description:
 * @create 2020-02-02 5:03 下午
 */
public class UserServiceImpl implements UserService {

    public void setPort(int port) {
        this.port = port;
    }

    private int port;



    @Override
    public String getName(Integer id) {
        return "当前用户id："+id+" 调用服务端口号: "+port;
    }
}
