package lv.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lv.venta.models.Course;
import lv.venta.models.users.Academic_personel;
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
	
	@GetMapping("/add")
	public String insertNewCourse(Model model) {
		
		
		model.addAttribute("courses", new Course());
		
		return "insert-new-course";
		
	}
	
	@PostMapping("/add")
	public String insertNewCourse2(@Valid Course course, BindingResult bindingResult) {
		
		
		if (bindingResult.hasErrors()) {
	        
	        return "error-page";
	    }
		
		Course temp = new Course(course.getTitle(), course.getCreditPoints());
		
		courseService.insertNewCourse(temp);
		
		return "redirect:/courses/showAll";
		
	}
	
	
	//TODO update
	
	
	//TODO pievienot Parādniekus!

}
