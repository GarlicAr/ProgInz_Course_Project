package lv.venta.services.users.impl;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.users.Student;
import lv.venta.repos.users.IRepoStudent;
import lv.venta.services.users.IStudentCRUDService;

@Service
public class StudentCRUDService implements IStudentCRUDService{


	@Autowired
	IRepoStudent studentRepo;
	@Override
	public ArrayList<Student> selectAllStudents() {
		return (ArrayList<Student>) studentRepo.findAll();
	}
	
	@Override
	public Student selectStudentByMatriculaNo(String matriculaNo) throws Exception {
		for (Student temp : selectAllStudents()) {
			if (temp.getMatriculaNo().equals(matriculaNo)) {
				return temp;
			}
		}
		throw new Exception("Nepareizs matrikulasNo");
	}
	
	@Override
	public void deleteStudentByMatriculaNo(String matriculaNo) throws Exception {
		boolean isFound = false;
		for (Student temp : selectAllStudents()) {
			if(temp.getMatriculaNo().equals(matriculaNo)) {
				selectAllStudents().remove(temp);
				isFound = true;
				break;
			}
		} 
		if(!isFound) {		
			throw new Exception("Nepareizs matrikulasNo");
		}
	}
	@Override
	public void insertNewStudent(Student student) {
	    for(Student temp : selectAllStudents()) {
	        if(temp.getMatriculaNo().equals(student.getMatriculaNo())) {
	            throw new RuntimeException("A student with this matricula number already exists.");
	        }
	    }
	    studentRepo.save(student);
	}


	@Override
	public void updateStudentByMatriculaNo(String matriculaNo, Student inputStudent) throws Exception {
	    List<Student> allStudents = (List<Student>) studentRepo.findAll();
	    Optional<Student> optionalStudent = allStudents.stream()
	            .filter(student -> student.getMatriculaNo().equals(matriculaNo))
	            .findFirst();
	    if (optionalStudent.isPresent()) {
	        Student studentToUpdate = optionalStudent.get();
	        studentToUpdate.setPersonName(inputStudent.getPersonName());
	        studentToUpdate.setSurname(inputStudent.getSurname());
	        studentToUpdate.setPersonalCode(inputStudent.getPersonalCode());
	        studentToUpdate.setUser(inputStudent.getUser());
	        studentToUpdate.setMatriculaNo(inputStudent.getMatriculaNo());
	        studentToUpdate.setDebt(inputStudent.isDebt());
	        studentRepo.save(studentToUpdate);
	    } else {
	        throw new Exception("Nepareizs matrikulasNo");
	    }
	}

		
	
		
	
}
