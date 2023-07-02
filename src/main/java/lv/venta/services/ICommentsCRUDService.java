package lv.venta.services;



import java.util.ArrayList;

import lv.venta.models.Comments;

import java.util.List;

import lv.venta.models.Comments;


import java.util.ArrayList;
import java.util.List;



public interface ICommentsCRUDService {
	
	public List<Comments> getAll();
	
	

	ArrayList<Comments> selectAllComments();
	
	Comments findById(long id);
	
	void insertNewComments(Comments comments);
	
	void deleteCommentsById(long id) throws Exception;
	
	void updateCommentsById(int id, Comments comments);
	
	
}
