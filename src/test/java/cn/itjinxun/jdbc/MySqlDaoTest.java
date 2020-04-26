package cn.itjinxun.jdbc;

import itjinxun.Jdbc.dao.MySqlDao;
import itjinxun.Jdbc.dao.impl.MySqlDaoImpl;
import itjinxun.Jdbc.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MySqlDaoTest {
    @Test
    public void test(){//一个简单的持久层框架源码实现
        MySqlDao<Student> dao = new MySqlDaoImpl<>();
        Student stu = new Student();
        stu.setS_id(2);
        List<Student> list = dao.queryList(stu);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
