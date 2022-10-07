package appPackage.services.implementations;

import appPackage.data.Course;
import appPackage.repositories.CourseRepository;
import appPackage.services.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl() {
    }

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getOneByName(String name) {

        return courseRepository.getByOne(name);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAll();
    }
}
