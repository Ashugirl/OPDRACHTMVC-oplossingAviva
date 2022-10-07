package appPackage.repositories;

import appPackage.data.Course;
import appPackage.data.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{






    @Override
    public List<Student> findByCourse(Course course) {
        for (Course c: SpoofDataBase.getCourses()){
            if (c.getCourseName().equals(course.getCourseName())){
                return c.getStudentList();
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return SpoofDataBase.getStudents();
    }

    @Override
    public Student getOne(String username) {
        for (Student student: SpoofDataBase.getStudents()){
            if(student.getUserName().equals(username)){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student save(Student student) {
        for (Student s: SpoofDataBase.getStudents()){
            if (s.getUserName().equals(student)){
                s.setOnBlackList(student.isOnBlackList());
                return student;
            }
        }
        SpoofDataBase.getStudents().add(student);
        for (Course course: SpoofDataBase.getCourses()){
            if (course.getCourseName().equals(student.getCourse().getCourseName())){
                List<Student> studentList = course.getStudentList();
                studentList.add(student);
                course.setStudentList(studentList);
            }
        }
        return student;

    }
}
