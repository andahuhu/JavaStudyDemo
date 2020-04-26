package itjinxun.Jdbc;

import java.sql.*;

public class JdbcConnector {
    public static void connectJdbc(){
        try {
            //1、加载JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            //2、获取与数据库的连接
            String url = "jdbc:mysql://127.0.0.1:3306/mysql";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url,username,password);
            //3、获取Statement
            Statement smt = connection.createStatement();
            //4、执行SQL语句，获取结果集
            ResultSet rs = smt.executeQuery("select s_id as sid,s_name,s_sex,s_age from student");
            //5、遍历结果集
            while(rs.next()){
                //int id =  rs.getInt("s_id");
                int id =  rs.getInt("sid");//通过列别名获取值
                int id1 =  rs.getInt(1);//通过列别名获取值
                String name = rs.getString("s_name");//通过列名获取值
                String sex = rs.getString("s_sex");
                Date date = rs.getDate("s_age");
                System.out.println(id1+","+id+","+name+","+sex+","+date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6、关闭与数据库连接
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void connectJdbc1(String name){
        try {
            //1、加载JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            //2、获取与数据库的连接
            String url = "jdbc:mysql://127.0.0.1:3306/mysql";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url,username,password);
            //3、获取Statement
            Statement smt = connection.createStatement();
            //4、执行SQL语句，获取结果集
            String sql = "select s_id as sid,s_name,s_sex,s_age from student where s_name ="+name;
            ResultSet rs = smt.executeQuery(sql);
            //5、遍历结果集
            while(rs.next()){
                int id =  rs.getInt("sid");
                String sName = rs.getString("s_name");
                String sex = rs.getString("s_sex");
                Date date = rs.getDate("s_age");
                System.out.println(id+","+sName+","+sex+","+date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6、关闭与数据库连接
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void connectJdbc2(){
        try {
            //1、加载JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            //2、获取与数据库的连接
            String url = "jdbc:mysql://127.0.0.1:3306/mysql";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url,username,password);
            //3、获取PreparedStatement
            String sql = "select s_id as sid,s_name,s_sex,s_age from student where s_id = ? AND s_name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,3);
            ps.setString(2,"孙风");
            //4、执行SQL语句，获取结果集
            ResultSet rs = ps.executeQuery();
            //5、遍历结果集
            while(rs.next()){
                int id =  rs.getInt("sid");
                String name = rs.getString("s_name");
                String sex = rs.getString("s_sex");
                Date date = rs.getDate("s_age");
                System.out.println(id+","+name+","+sex+","+date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6、关闭与数据库连接
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
