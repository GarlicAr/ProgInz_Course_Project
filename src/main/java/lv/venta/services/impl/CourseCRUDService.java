package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Course;
import lv.venta.models.users.Student;
import lv.venta.repos.IRepoCourse;
import lv.venta.services.ICourseCRUDService;

@Service
public class CourseCRUDService implements ICourseCRUDService {

	@Autowired
	IRepoCourse courseRepo;

	@Override
	public List<Course> getAll() {

		return (List<Course>) courseRepo.findAll();
	}

	@Override
	public void deleteCourseById(long id) {

		try {

			for (Course course : getAll()) {
				if (course.getCourseId() == id) {
					courseRepo.delete(course);
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void updateCourseById(long id, Course course) {

		try {
			Course temp = new Course();

			for (Course cours : getAll()) {
				if (cours.getCourseId() == id) {

					temp = cours;

					temp.setTitle(course.getTitle());
					temp.setCreditPoints(course.getCreditPoints());
					if (cours.getStudentsWithDebt() != null) {
						temp.setStudentsWithDebt(course.getStudentsWithDebt());
					}

					courseRepo.save(temp);

					break;

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void insertNewCourse(Course course) {

		try {

			if (course != null) {
				for (Course courses : getAll()) {
					if (!courses.getTitle().equals(course.getTitle())) {
						courseRepo.save(course);
						return;
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<Student> getDebtStudents(Course course) {

		try {

			List<Student> debt = new ArrayList<>();

			if (course.getStudentsWithDebt() != null) {
				debt.add((Student) course.getStudentsWithDebt());
				return debt;
			}

			return null;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;

	}
	
	
	public Course findCourseById(long id) {
		try {
			
			for(Course course: getAll()) {
				if(course.getCourseId() == id) {
					return course;
				}
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

}
