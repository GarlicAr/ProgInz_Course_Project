package lv.venta.services;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import lv.venta.models.Study_program;

public interface IStudyProgramCRUDService {

	List<Study_program> selectAllPrograms();

	List<Study_program> getAll();

	void addNewStudyProgram(Study_program Study_program);

	List<Study_program> allStudy_programs();
	
	Study_program findById(long id);

	Study_program selectStudyProgramById(long studyProgram_id) throws Exception;

//	void updateStudyProgram(long id, @Valid Study_program study_program) throws Exception;
//
//	void deleteStudyProgramById(int id) throws Exception;
//
//	Study_program findById(int id);

}
