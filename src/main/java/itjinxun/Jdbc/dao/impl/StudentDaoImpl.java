package itjinxun.Jdbc.dao.impl;

import itjinxun.Jdbc.dao.StudentDao;
import itjinxun.Jdbc.dao.base.BaseDao;
import itjinxun.Jdbc.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao{

    @Override
    public List<Student> queryStudentsByPar(Student student) {
        try {
            Connection conn = super.getConn();
            StringBuilder sql = new StringBuilder();
            sql.append("select s_id,s_name,s_age,s_sex from student where 1=1 ");
            if(student != null){
                if(student.getS_id() != null){
                    sql.append(" and s_id = ? ");
                }
                if(student.getS_name() != null){
                    sql.append(" and s_name like ? ");
                }
                if(student.getS_age() != null){
                    sql.append(" and s_age = ? ");
                }
                if(student.getS_sex() != null){
                    sql.append(" and s_sex = ? ");
                }
            }
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            int index = 0;
            if(student != null){
                if(student.getS_id() != null){
                    ps.setObject(++index,student.getS_id());
                }
                if(student.getS_name() != null){
                    ps.setObject(++index,"%"+student.getS_name()+"%");
                }
                if(student.getS_age() != null){
                    ps.setObject(++index,student.getS_age());
                }
                if(student.getS_sex() != null){
                    ps.setObject(++index,student.getS_sex());
                }
            }
            LinkedList<Student> list = new LinkedList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student stu = new Student();
                stu.setS_id(rs.getInt("s_id"));
                stu.setS_name(rs.getString("s_name"));
                stu.setS_age(rs.getDate("s_age"));
                stu.setS_sex(rs.getString("s_sex"));
                list.add(stu);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.closeConn();
        }
        return null;
    }
}
