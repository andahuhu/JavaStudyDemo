package itjinxun.Jdbc.dao;

import java.util.List;

public interface MySqlDao<T> {
    public List<T> queryList(T t);
}
