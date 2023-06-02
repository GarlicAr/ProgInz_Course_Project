package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.enums.Degree;
import lv.venta.models.Course;
import lv.venta.models.Thesis;
import lv.venta.models.users.Academic_personel;
import lv.venta.models.users.Person;
import lv.venta.models.users.Student;
import lv.venta.models.users.User;
import lv.venta.repos.IRepoCourse;
import lv.venta.repos.IRepoThesis;
import lv.venta.repos.users.IRepoAcademicPersonel;
import lv.venta.repos.users.IRepoPerson;
import lv.venta.repos.users.IRepoStudent;
import lv.venta.repos.users.IRepoUser;

@SpringBootApplication
public class ProgInzCourseProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzCourseProjectApplication.class, args);
	}
	
	@Bean //Calls function when system runs
	public CommandLineRunner testModel(
			IRepoCourse courseRep, 
			IRepoThesis thesisRep, 
			IRepoAcademicPersonel academicPersonelRep, 
			IRepoPerson personRep,
			IRepoStudent studentRep,
			IRepoUser userRep) {
		
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				//Users
				User user1 = new User("123", "test@test.com");
				User user2 = new User("123", "test1@test.com");
				User user3 = new User("123", "test2@test.com");
				User user4 = new User("123", "test3@test.com");
				userRep.save(user1);
				userRep.save(user2);
				userRep.save(user3);
				userRep.save(user4);
				
				
				//Courses
				Course c1 = new Course("Java", 4);
				Course c2 = new Course("DataStr", 2);
				courseRep.save(c1);
				courseRep.save(c2);
				
				
				//Academic personel / Students
				Academic_personel ac1 = new Academic_personel("Karina", "Skirmante", "123455-24234", user1, Degree.master);
				Academic_personel ac2 = new Academic_personel("Karlis", "Immers", "123455-00001", user2, Degree.master);
				academicPersonelRep.save(ac1);
				academicPersonelRep.save(ac2);
				Student student1 = new Student("Arvids", "Ivbuls", "203421-92342", user3, "123ADT123", false );
				Student student2 = new Student("Zigis", "Celotajs", "422452-12343", user4, "001RDB100", true );
				studentRep.save(student1);
				studentRep.save(student2);
				student2.addDebtCourse(c1);
				c1.addStudent(student2);
				//=======SAVE===========
				courseRep.save(c1);
				courseRep.save(c2);
				//======================
				
				
				//Thesis
				Thesis th1 = new Thesis("Sistemas izstrade", "System development", "Development", "1. 2. 3.", student1, ac1);
				Thesis th2 = new Thesis("Kripto", "Crypto", "Blockchain", "1. 2. 3.", student2, ac2);
				th1.addReviewer(ac2);
				th2.addReviewer(ac1);
				thesisRep.save(th1);
				thesisRep.save(th2);
				ac1.addThesisForReview(th2);
				ac2.addThesisForReview(th1);
				academicPersonelRep.save(ac1);
				academicPersonelRep.save(ac2);
				
				
			}
		};
	}
}


