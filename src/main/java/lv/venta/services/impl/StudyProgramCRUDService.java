package lv.venta.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Study_program;
import lv.venta.models.users.Academic_personel;
import lv.venta.models.users.User;
import lv.venta.repos.IRepoStudyProgram;
import lv.venta.services.IStudyProgramCRUDService;

@Service
public class StudyProgramCRUDService implements IStudyProgramCRUDService{
	
	@Autowired
	IRepoStudyProgram studyProgramRepo; 

	@Override
	public List<Study_program> getAll() {
		return (List<Study_program>) studyProgramRepo.findAll();
	}
	@Override
	public List<Study_program> allStudy_programs() {
		
		return (List<Study_program>) studyProgramRepo.findAll();
	}
//	@Override
//	public Object insertNewStudyProgram(Study_program Study_program) {
//		if(findById(Study_program.getStudyProgram_id() )== null) {
//
//			
//			studyProgramRepo.save(Study_program);
//		}
//	}
	public Study_program findById(int id) {
		
		Study_program newStudy_program = new Study_program();
			
			try {
				for(Study_program temp : getAll()) {
					if(temp.getStudyProgram_id() == id) {
						
						newStudy_program = temp;
						
						return newStudy_program;
						
					}
				}
	
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			return null;
		}
	@Override
		public void addNewStudyProgram(Study_program Study_program) {
		
			if(findById(Study_program.getStudyProgram_id() )== null) {

			
				studyProgramRepo.save(Study_program);
		}
	}
	@Override
	public List<Study_program> selectAllPrograms() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Study_program findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}
