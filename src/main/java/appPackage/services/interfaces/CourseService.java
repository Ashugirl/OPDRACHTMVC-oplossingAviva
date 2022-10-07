package appPackage.services.interfaces;

import appPackage.data.Course;

import java.util.List;

public interface CourseService {

    Course getOneByName(String name);
    List<Course> getAllCourses();
}
