package lv.venta.services;

import java.util.ArrayList;
import java.util.List;


import lv.venta.models.Study_program;

public interface IStudyProgramCRUDService {

//	public List<Study_program> getAll();
//	
//	
//
//	ArrayList<Study_program> selectAllStudyProgram();
//	
//	Study_program findById(long id);
//	
	List<Study_program> selectAllPrograms();
//	
//	void addStudyProgram(Study_program Study_program);
//	
//	void deleteStudyProgramById(long id) throws Exception;
//	
//	void updateStudyProgramById(int id, Study_program Study_program);
	
	
	
	List<Study_program> getAll();

	void addNewStudyProgram(Study_program Study_program);

	List<Study_program> allStudy_programs();
	
	Study_program findById(long id);

}
