package lv.venta.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import lv.venta.models.Comments;
import lv.venta.models.users.Student;
import lv.venta.services.impl.CommentsCRUDService;
import lv.venta.services.impl.ThesisCRUDService;

@Controller
@RequestMapping("/comments")
public class CommentController {


	
	@Autowired
	private CommentsCRUDService commentsService;
	

	@GetMapping("/showAll")
    public String showAllComments(Model model) {
    	List<Comments> comments = commentsService.getAll();
        model.addAttribute("comments", comments);
        return "show-all-comments";
    }

	@GetMapping("/showOne/{id}")
	private String showOneCommentsById(@PathVariable("id") int id, Model model) {
		
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
	
	@GetMapping("/add")
	public String postComment(Model model) {
		
//	    Comments tempComments = new Comments(null, null, null, null);
//	    
//	    model.addAttribute("comments", tempComments);
	    
	  //List<Comments> comment = commentsService.selectAllComments();
		
//		model.addAttribute("text", new Comments());
//		
//		model.addAttribute("date", LocalDateTime.now());
//		
//		model.addAttribute("personel", academic_personel);
//		
//		model.addAttribute("thesis", thesis_id);
		
		List<Comments> comment = commentsService.selectAllComments();
        model.addAttribute("comments", comment);
        model.addAttribute("comments", new Comments());
	    
	    return "insert-new-comments";
	}
	
	@PostMapping("/add")
	private String createCommentsPost(@Valid Comments comments, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
	        
	        return "error-page";
	    }
		
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formattedDateTime = now.format(formatter);
		
		Comments comm = new Comments(
				comments.getText(), 
				comments.getDate(),
				comments.getPersonel(), 
				comments.getThesis());
		
		
		commentsService.insertNewComments(comm);
		
		
		return "redirect:/comments/showAll";
	}
	
	@GetMapping("/update/{id}")
    public String showCommentsUpdatePage(@PathVariable("id") int id, org.springframework.ui.Model model) {
        
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formattedDateTime = now.format(formatter);
	    
		try {
			Comments temp = commentsService.findById(id);

			model.addAttribute("comments", temp);
			return "update-comments";
		}catch (Exception e) {
			
			return "error-page";
			
		}
        
    }
	
	@PostMapping("/update/{id}")
    public String updateCommentsById(@PathVariable("id") int id, @Valid Comments comments, BindingResult result) {

		if (result.hasErrors()) {
            return "update-comments";
        } else {
            try {
                commentsService.updateCommentsById(id, comments);
                return "redirect:/comments/showAll" + comments.getComment_id();
            } catch (Exception e) {
                return "redirect:/error-page";
            }
        }
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
