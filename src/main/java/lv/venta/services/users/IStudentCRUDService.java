package lv.venta.services.users;

import java.util.ArrayList;

import lv.venta.models.users.Student;

public interface IStudentCRUDService {

	ArrayList<Student> selectAllStudents();
	
	Student selectStudentByMatriculaNo(String matriculaNo) throws Exception;
	
	void deleteStudentByMatriculaNo(String matriculaNo) throws Exception;
	
	Student insertNewStudent(Student student);
	
	Student updateStudentByMatriculaNo(String matriculaNo) throws Exception;
}
