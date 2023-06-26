package lv.venta.services.users.impl;

import java.util.ArrayList;

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
	        if(temp.getPersonName().equals(student.getPersonName()) && 
	           temp.getSurname().equals(student.getSurname()) &&
	           temp.getPersonalCode().equals(student.getPersonalCode()) && 
	           temp.getUser().getUser_id()==student.getUser().getUser_id() &&
	           temp.getMatriculaNo().equals(student.getMatriculaNo()) &&
	           temp.isDebt() == student.isDebt()) {
	            studentRepo.save(temp);
	        }
	    }

	    Student newStudent = new Student(student.getPersonName(), student.getSurname(), 
	                                     student.getPersonalCode(), student.getUser(), 
	                                     student.getMatriculaNo(), student.isDebt());

	    studentRepo.save(newStudent);
	}
	public Student updateStudentByMatriculaNo(String matriculaNo) throws Exception {
		for(Student temp : selectAllStudents()) {
			if(temp.getMatriculaNo().equals(matriculaNo)) {
				return temp;
			}
		} throw new Exception("Nepareizs matrikulasNo");
	}
		
	
		
	
}
