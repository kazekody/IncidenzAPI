package fr.incidenz.incidenz.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.incidenz.incidenz.Model.User;

@Repository
public interface IUserRepository extends JpaRepository <User, String>{

	User findByIdUser(String idUser);
	
	User findByEmail(String email);

	User findByPassword(String password);

    @Modifying
	@Transactional
	@Query(value = "delete from User user where user.idUser=:idUser")
	void deleteUser(@Param("idUser")String idUser);

    
}
