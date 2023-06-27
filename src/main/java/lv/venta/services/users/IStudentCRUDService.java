package lv.venta.services.users;

import java.util.ArrayList;

import lv.venta.models.users.Student;

public interface IStudentCRUDService {

	ArrayList<Student> selectAllStudents();
	
	Student selectStudentByMatriculaNo(String matriculaNo) throws Exception;
	
	void deleteStudentByMatriculaNo(String matriculaNo) throws Exception;
	
	void insertNewStudent(Student student);
	
	void updateStudentByMatriculaNo(String matriculaNo, Student student) throws Exception;
}
