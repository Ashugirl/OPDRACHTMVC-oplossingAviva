package appPackage.services.interfaces;

import appPackage.data.Course;
import appPackage.data.Student;

import java.util.List;

public interface StudentService {

    Student getStudentByUsername(String username);
    List <Student> getAllStudents();
    List <Student> getAllStudentsByCourse(Course course);
    Student createStudent(Student student);





}
