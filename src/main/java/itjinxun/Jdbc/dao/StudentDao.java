package itjinxun.Jdbc.dao;

import itjinxun.Jdbc.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> queryStudentsByPar(Student student);
}
