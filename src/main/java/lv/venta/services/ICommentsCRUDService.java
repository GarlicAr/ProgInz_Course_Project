package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Comments;
import lv.venta.models.users.Student;

public interface ICommentsCRUDService {

	ArrayList<Comments> selectAllComments();
	
	Comments findById(long id);
	
	void insertNewComments(Comments comments);
	
	void deleteCommentsById(long id) throws Exception;
	
}
