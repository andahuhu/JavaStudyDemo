package itjinxun.Proxy;

public class User2Dao{
    public static boolean save(User user){
        System.out.println("保存用户："+user.getName()+"，"+user.getAge());
        return true;
    }
}
