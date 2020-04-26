package cn.itjinxun.jdbc;

import itjinxun.Jdbc.JdbcConnector;
import itjinxun.Jdbc.dao.StudentDao;
import itjinxun.Jdbc.dao.impl.StudentDaoImpl;
import org.junit.Test;

public class jdbcConnectorTest {
    @Test
    public void test1(){//jdbc初识,使用Statement执行SQL
        JdbcConnector.connectJdbc();
    }

    @Test
    public void test2(){//jdbc初识,使用Statement执行SQL,SQL注入案例
        JdbcConnector.connectJdbc1("'孙风' or 1=1");
    }

    @Test
    public void test3(){//jdbc初识，使用PreparedStatement执行SQL
        JdbcConnector.connectJdbc2();
    }

    @Test
    public void test4(){
        StudentDao studentDao = new StudentDaoImpl();

    }
}
