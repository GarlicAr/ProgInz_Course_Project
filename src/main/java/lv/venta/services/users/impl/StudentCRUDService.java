package lv.venta.services.users.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lv.venta.models.users.Student;
import lv.venta.services.users.IStudentCRUDService;

@Service
public class StudentCRUDService implements IStudentCRUDService{

	ArrayList<Student> allStudents = new ArrayList<Student>();
	
	@Override
	public ArrayList<Student> selectAllStudents() {
		return allStudents;
	}
	
	@Override
	public Student selectStudentByMatriculaNo(String matriculaNo) throws Exception {
		for (Student temp : allStudents) {
			if (temp.getMatriculaNo().equals(matriculaNo)) {
				return temp;
			}
		}
		throw new Exception("Nepareizs matrikulasNo");
	}
	
	@Override
	public void deleteStudentByMatriculaNo(String matriculaNo) throws Exception {
		boolean isFound = false;
		for (Student temp : allStudents) {
			if(temp.getMatriculaNo().equals(matriculaNo)) {
				allStudents.remove(temp);
				isFound = true;
				break;
			}
		} 
		if(!isFound) {		
			throw new Exception("Nepareizs matrikulasNo");
		}
	}
	@Override
	public Student insertNewStudent(Student student) {
	    for(Student temp : allStudents) {
	        if(temp.getPersonName().equals(student.getPersonName()) && 
	           temp.getSurname().equals(student.getSurname()) &&
	           temp.getPersonalCode().equals(student.getPersonalCode()) && 
	           temp.getUser().equals(student.getUser()) &&
	           temp.getMatriculaNo().equals(student.getMatriculaNo()) &&
	           temp.isDebt() == student.isDebt()) {
	            return temp;
	        }
	    }

	    Student newStudent = new Student(student.getPersonName(), student.getSurname(), 
	                                     student.getPersonalCode(), student.getUser(), 
	                                     student.getMatriculaNo(), student.isDebt());

	    allStudents.add(newStudent);
	    return newStudent;
	}
	public Student updateStudentByMatriculaNo(String matriculaNo) throws Exception {
		for(Student temp : allStudents) {
			if(temp.getMatriculaNo().equals(matriculaNo)) {
				return temp;
			}
		} throw new Exception("Nepareizs matrikulasNo");
	}
		
	
		
	
}
