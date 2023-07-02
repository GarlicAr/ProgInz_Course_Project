package lv.venta.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import lv.venta.models.Study_program;
import lv.venta.repos.IRepoStudyProgram;
import lv.venta.services.IStudyProgramCRUDService;

@Service
public class StudyProgramCRUDService implements IStudyProgramCRUDService{
	
	@Autowired
	IRepoStudyProgram studyProgramRepo; 
	
	@Autowired
	StudyProgramCRUDService studyProgramService;

	@Override
	public List<Study_program> getAll() {
		return (List<Study_program>) studyProgramRepo.findAll();
	}
	@Override
	public List<Study_program> allStudy_programs() {
		
		return (List<Study_program>) studyProgramRepo.findAll();
	}

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
		
		Study_program newStudyProgram = new Study_program();
		
		try {
			
			for(Study_program temp : getAll()) {
				if(temp.getStudyProgram_id() == id) {
					
					newStudyProgram = temp;
					
					return newStudyProgram;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public void deleteStudyProgramById(int id) {
		try {
			if(findById(id)!= null) {			
				for(Study_program temp: getAll()) {
					if(temp.getStudyProgram_id() == id) {
						studyProgramRepo.delete(temp);
					}
				}
			}
			else {
				throw new Exception("Programa netika atrasta!");
			}
	
		}
		catch (Exception e) {	
		}
	}
	
	 @Override
	    public Study_program selectStudyProgramById(long studyProgram_id) throws Exception {
	        for (Study_program temp : selectAllPrograms()) {
	        	if(temp.getStudyProgram_id() == studyProgram_id) {
	        		return temp;
	        	}
	        }
	        throw new Exception("Neparizes studyProgram_id");
	    }
	 
	public void updateStudyProgram(long id, @Valid Study_program study_program) throws Exception {
		Study_program temp = new Study_program();
        temp = selectStudyProgramById(id);

        temp.setFaculty(study_program.getFaculty());
        temp.setLevel(study_program.getLevel());
        temp.setTitle(study_program.getTitle());

        studyProgramRepo.save(temp);
    	}
	}

	
	
	
	

