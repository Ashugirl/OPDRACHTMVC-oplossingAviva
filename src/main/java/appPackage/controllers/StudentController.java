package appPackage.controllers;

import appPackage.data.Course;
import appPackage.data.Student;
import appPackage.services.interfaces.CourseService;
import appPackage.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;
    private CourseService courseService;

    @Autowired
    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("allStudents")
    public String showAll(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        Student student = new Student();
        student.setCourse(new Course(""));
        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAllCourses());
        return "students";
    }

    @GetMapping("allStudents/{courseToClick}")
    public String showAll(Model model, @PathVariable("courseToClick")String courseName){
        Course course = courseService.getOneByName(courseName);
        model.addAttribute("students", studentService.getAllStudentsByCourse(course));
        Student student = new Student();
        student.setCourse(course);
        model.addAttribute("student", student);
        List<Course> justCurrentCourse = new ArrayList<>();
        justCurrentCourse.add(course);
        model.addAttribute("courses", justCurrentCourse);
        return "students";
    }

    @PostMapping("/createStudent")
    public String createStudent(Student student){
        Course course = courseService.getOneByName(student.getCourse().getCourseName());
        student.setCourse(course);
        studentService.createStudent(student);
        return "redirect:/allStudents";
    }


}
