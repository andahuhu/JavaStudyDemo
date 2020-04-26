package cn.itjinxun.jdbc;

import itjinxun.Jdbc.JdbcConnector;
import itjinxun.Jdbc.dao.StudentDao;
import itjinxun.Jdbc.dao.impl.StudentDaoImpl;
import itjinxun.Jdbc.entity.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {
    @Test
    public void test(){//jdbc封装基础及DAO初步封装
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setS_name("孙");
        List<Student> list = studentDao.queryStudentsByPar(student);
        for (Student stu :
                list) {
            System.out.println(stu);
        }
    }
}
