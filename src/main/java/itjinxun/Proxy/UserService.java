package itjinxun.Proxy;

import java.lang.reflect.Proxy;

/*
 * 业务服务层，
 * 基于接口来做事：
 * 接口命名以Service为后缀
 * 接口实现命名以ServiceImpl为后缀
 * */
public class UserService {
    public static void directCall(){
        User user1 = new User("张三",20);
        new UserDaoImpl().save(user1);
        User user2 = new User("",18);
        new UserDaoImpl().save(user2);
        User user3 = new User("王五",-22);
        new UserDaoImpl().save(user3);
    }

    public static void staticProxyCall(){
        User user1 = new User("张三",-20);
        UserDao userDao = new UserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save(user1);
    }

    public static void jdkProxyCall(){
        User user1 = new User("张三",-20);
        UserDao userDao = new UserDaoImpl();
        UserInvocationHandler handler = new UserInvocationHandler(userDao);
        UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(
                userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(),
                handler
        );
        userDaoProxy.save(user1);
        userDaoProxy.delete();
    }

    public static void jdkProxyCall2(){
        User user = new User("张三",-20);
        User2Dao user2Dao = new User2Dao();
        UserInvocationHandler handler = new UserInvocationHandler(user2Dao);
        User2Dao user2DaoProxy = (User2Dao) Proxy.newProxyInstance(
                user2Dao.getClass().getClassLoader(),
                user2Dao.getClass().getInterfaces(),
                handler
        );
        user2DaoProxy.save(user);
    }

    public static void cjlibProxyCall(){
        User user = new User("张三",-20);
        User2Dao user2Dao = new User2Dao();
        User2DaoCglibProxy cjlibProxy = new User2DaoCglibProxy(user2Dao);
        User2Dao user2DaoProxy = (User2Dao) cjlibProxy.getProxyInstance();
        user2DaoProxy.save(user);

        /*UserDao userDao = new UserDaoImpl();
        User2DaoCglibProxy cjlibProxy2 = new User2DaoCglibProxy(userDao);
        UserDao userDaoProxy = (UserDao) cjlibProxy2.getProxyInstance();
        userDaoProxy.save(user);*/
    }

    public static void main(String[] args) {
        //直接调用
        //directCall();

        //静态代理
        //staticProxyCall();

        //动态代理
        //jdkProxyCall();

        //动态代理 被代理对象不是基于接口来实现的
        //jdkProxyCall2();

        //cjlib代理
        cjlibProxyCall();
    }
}
