package appPackage.repositories;

import appPackage.data.Course;
import appPackage.data.Student;

import java.util.List;


public interface StudentRepository {

    List<Student> findByCourse(Course course);
    List<Student> findAll();
    Student getOne(String username);
    Student save(Student student);

}
