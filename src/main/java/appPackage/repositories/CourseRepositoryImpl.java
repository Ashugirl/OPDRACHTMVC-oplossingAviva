package appPackage.repositories;

import appPackage.data.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository{



    public CourseRepositoryImpl() {

    }

    @Override
    public Course getByOne(String name) {
        for (Course course: SpoofDataBase.getCourses()){
            if (course.getCourseName().equals(name)){
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> getAll() {
        return SpoofDataBase.getCourses();
    }
}
