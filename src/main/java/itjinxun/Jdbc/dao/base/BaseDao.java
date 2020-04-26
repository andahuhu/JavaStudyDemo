package itjinxun.Jdbc.dao.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class BaseDao {
    private String driver;
    private String url;
    private String user;
    private String pwd;

    public BaseDao(){
        Properties properties = new Properties();
        String path = BaseDao.class.getClassLoader().getResource("jdbc.properties").getPath();
        try {
            properties.load(new FileInputStream(new File(path)));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            pwd = properties.getProperty("pwd");
            //加载驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection conn;

    public Connection getConn() throws SQLException {
        return conn = DriverManager.getConnection(url,user,pwd);
    }

    public void closeConn(){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
