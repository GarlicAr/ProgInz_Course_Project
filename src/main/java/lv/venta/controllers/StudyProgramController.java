package lv.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lv.venta.enums.Degree;
import lv.venta.models.Study_program;
import lv.venta.models.users.Academic_personel;
import lv.venta.services.impl.StudyProgramCRUDService;


@Controller
public class StudyProgramController {
	
	@Autowired
	private StudyProgramCRUDService studyProgramService;
	
	@GetMapping("/Study_program/showAll")
    public String showAllStudyPrograms(Model model) {
    	List<Study_program> studyPrograms = studyProgramService.getAll();
        model.addAttribute("Study_program", studyPrograms);
        return "show-all-programs";
    }
	
	@GetMapping("/Study_program/showOne/{id}")
	private String showOneProgram(@PathVariable("id") int id, Model model) {
		
		try {
			
			Study_program temp = new Study_program();
			
			temp = studyProgramService.findById(id);
			
			model.addAttribute("Study_program", temp);
			
			return "show-one-program";

		}catch (Exception e) {
			// TODO: handle exception
		}

		return "error-page";
		
	}
	
	@GetMapping("/Study_program/update/{id}")
    public String updateStudyProgramById(@PathVariable("id") int id, org.springframework.ui.Model model) {
        

		try {
			Study_program temp = studyProgramService.findById(id);

			model.addAttribute("Study_program", temp);
			return "update-program";
		}catch (Exception e) {
			
			return "error-page";
			
		}
        
    }
	
	@GetMapping("/Study_program/add")
	private String createStudyProgram(Model model) {
		
		List<Study_program> Study_program = studyProgramService.allStudy_programs(); // Fetch all users
        model.addAttribute("Study_program", Study_program);
        model.addAttribute("Study_program", new Study_program());

		return "programs-add-page";
		
	}
	
	@PostMapping("/Study_program/add")
	private String createStudyProgramPost(@Valid Study_program Study_program, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
	        
	        return "error-page";
	    }
		
		Study_program sp = new Study_program(
				Study_program.getFaculty(), 
				Study_program.getLevel(), 
				Study_program.getTitle());
		
		
				studyProgramService.addNewStudyProgram(sp);
		
		
		return "redirect:/Study_program/showAll";
	}
	
	
}
