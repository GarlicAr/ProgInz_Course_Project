package lv.venta.repos.users;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.users.User;

public interface IRepoUser extends CrudRepository<User, Long>{

}
