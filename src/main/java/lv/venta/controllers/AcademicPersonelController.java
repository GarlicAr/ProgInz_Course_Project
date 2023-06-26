package lv.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.models.users.Academic_personel;
import lv.venta.services.users.impl.AcademicPersonelCRUDService;

@Controller
public class AcademicPersonelController {
	
	@Autowired
	AcademicPersonelCRUDService personelService;
	
	
	
	@GetMapping("/personel/showAll")
	private String showAllPersonel(Model model) {
		
		List<Academic_personel> academicPersonel = personelService.getAll();
		
		model.addAttribute("personel", academicPersonel);
		
		return "show-all-personel";
		
	}

}
