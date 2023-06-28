package lv.venta.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	private ThesisCRUDService commentsService;
	
	@GetMapping("/comments")
	private String commentsScreen(Model model) {
		
		return "index";
		
	}
	
//	@GetMapping("/showAllComments")
//    public String showAllComments(Model model) {
//    	ArrayList<Comments> tempArray = commentsService.selectAllComments();
//        model.addAttribute("comments", tempArray);
//        return "comment";
//    }

	
	@GetMapping("/addComment")
	public String postComment(Model model) {
		
	    
	    Comments tempComments = new Comments();
	    
	    model.addAttribute("comments", tempComments);
	    
	    
	    return "new-comment";
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
