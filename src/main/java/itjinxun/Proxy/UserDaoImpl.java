package itjinxun.Proxy;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(User user){
        System.out.println("保存用户："+user.getName()+"，"+user.getAge());
        return true;
    }

    @Override
    public void query() {

    }

    @Override
    public boolean delete() {
        System.out.println("执行删除");
        return false;
    }
}
