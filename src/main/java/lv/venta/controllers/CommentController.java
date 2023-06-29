package lv.venta.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lv.venta.models.Comments;
import lv.venta.services.impl.CommentsCRUDService;
import lv.venta.services.impl.ThesisCRUDService;
import lv.venta.services.users.impl.AcademicPersonelCRUDService;

@Controller
@RequestMapping("/comments")
public class CommentController {

//	@Autowired
//	private AcademicPersonelCRUDService academicPersonelService;
//	
//	@Autowired
//	private ThesisCRUDService thesisService;
	
	@Autowired
	private CommentsCRUDService commentsService;
	
	@GetMapping("/comments")
	private String commentsScreen(Model model) {
		
		return "index";
		
	}
	
	@GetMapping("/Comments/showAll")
    public String showAllComments(Model model) {
    	ArrayList<Comments> tempArray = commentsService.selectAllComments();
        model.addAttribute("comments", tempArray);
        return "comment";
    }

	@GetMapping("/comments/showOne/{id}")
	private String showOnePersonel(@PathVariable("id") int id, Model model) {
		
		try {
			
			Comments temp = new Comments();
			
			temp = commentsService.findById(id);
			
			model.addAttribute("comments", temp);
			
			return "show-one-comments";
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "error-page";
		
	}
	
	@GetMapping("/Comments/add")
	public String postComment(Model model) {
		
	    
	    Comments tempComments = new Comments();
	    
	    model.addAttribute("comments", tempComments);
	    
	    
	    return "insert-new-comments";
	}
	
	@PostMapping("/comments/add")
	private String createCommentsPost(@Valid Comments comments, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
	        
	        return "error-page";
	    }
		
		Comments com = new Comments(
				comments.getText(), 
				comments.getDate(),
				comments.getPersonel(), 
				comments.getThesis());
		
		
		commentsService.insertNewComments(com);
		
		
		return "redirect:/personel/showAll";
	}
	
//	@GetMapping("/delete")
//	public String deleteComment(Model model) {
//		try
//		{	
//			commentsService.deleteComment();
//			model.addAttribute("myAllComments", commentsService.retrieveAllComments());
//			return "comment";
//		}
//		catch(Exception e){
//			return "error-page";
//		}
//		
//	}
	
}
