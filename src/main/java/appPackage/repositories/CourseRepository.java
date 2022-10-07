package appPackage.repositories;


import appPackage.data.Course;

import java.util.List;

public interface CourseRepository {


    Course getByOne(String name);
    List<Course> getAll();

}
