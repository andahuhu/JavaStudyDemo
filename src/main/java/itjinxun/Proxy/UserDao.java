package itjinxun.Proxy;

/*
* 数据库读写操作，DAO层
* */
public interface UserDao {
    boolean save(User user);

    void query();

    boolean delete();
}
