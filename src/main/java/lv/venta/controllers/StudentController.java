package lv.venta.controllers;

import lv.venta.models.users.Student;
import lv.venta.services.users.IStudentCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentCRUDService studentService;

    @GetMapping("/showAll")
    public String showAllStudents(Model model) {
        model.addAttribute("myStudents", studentService.selectAllStudents());
        return "student-all-page";
    }

    @GetMapping("/show/{matriculaNo}")
    public String showStudentByMatriculaNo(@PathVariable("matriculaNo") String matriculaNo, Model model) {
    	if(matriculaNo != null) {
	        try {
	            model.addAttribute("MyStudentByMatriculaNo", studentService.selectStudentByMatriculaNo(matriculaNo));
	            return "student-one-page";
	        } catch (Exception e) {
	            return "error-page";
	        }
    	}return "error-page";
    }

    @GetMapping("/remove/{matriculaNo}")
    public String removeStudentByMatriculaNo(@PathVariable("matriculaNo") String matriculaNo, Model model) {
        try {
            studentService.deleteStudentByMatriculaNo(matriculaNo);
            model.addAttribute("myAllStudents", studentService.selectAllStudents());
            return "student-all-page";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/insertNew")
    public String insertNewStudent(Student student) {
        return "student-add-page";
    }

    @PostMapping("/inserNew")
    public String insertNewStudent(@Valid Student student, BindingResult result) {
        if (!result.hasErrors()) {
            studentService.insertNewStudent(student);
            return "redirect:/student/showAll";
        } else {
            return "error-page";
        }
    }

    @GetMapping("/update/{matriculaNo}")
    public String updateStudentByMatriculaNo(@PathVariable("matriculaNo") String matriculaNo, Model model) {
        try {
            model.addAttribute("student", studentService.updateStudentByMatriculaNo(matriculaNo));
            return "student-update-page";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @PostMapping("/update/{matriculaNo}")
    public String updateStudentByMatriculaNo(@PathVariable("matriculaNo") String matriculaNo, @Valid Student student, BindingResult result) {
        if (!result.hasErrors()) {
            try {
                Student temp = studentService.updateStudentByMatriculaNo(matriculaNo);
                return "redirect:/student/show/" + temp.getMatriculaNo();
            } catch (Exception e) {
                return "redirect:/error-page";
            }
        } else {
            return "update-page";
        }
    }
}
