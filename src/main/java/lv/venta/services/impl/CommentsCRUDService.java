package lv.venta.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Comments;
import lv.venta.repos.IRepoComments;
import lv.venta.services.ICommentsCRUDService;

@Service
public class CommentsCRUDService implements ICommentsCRUDService{
	
	@Autowired
	IRepoComments commentsRepo;

	@Override
	public List<Comments> getAll() {
		return (List<Comments>) commentsRepo.findAll();
	}

}
