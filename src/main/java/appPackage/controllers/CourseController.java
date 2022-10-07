package appPackage.controllers;

import appPackage.services.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/allCourses")
    public String showAll(Model model){
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }


}
