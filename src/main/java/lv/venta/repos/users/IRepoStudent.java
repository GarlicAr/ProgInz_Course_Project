package lv.venta.repos.users;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.users.Student;

public interface IRepoStudent extends CrudRepository<Student, Long>{

}
