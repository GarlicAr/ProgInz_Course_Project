package lv.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.models.Course;
import lv.venta.models.users.Student;
import lv.venta.services.impl.CourseCRUDService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	CourseCRUDService courseService;
	
	@GetMapping("/showAll")
	public String showAllCourses(Model model) {
		
		
		List<Course> courses = courseService.getAll();
		
		model.addAttribute("courses", courses);
		
		return "show-all-courses";
		
		
	}
	
	
	@GetMapping("/showOne/{id}")
	public String showOneCourse(@PathVariable("id") long id,Model model) {
		
		
		Course course = courseService.findCourseById(id);
		
		List<Student> debt = courseService.getDebtStudents(null);
		
		model.addAttribute("courses", course);
		
		return "show-one-courses";
		
		
	}

}
