package fr.incidenz.incidenz.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.incidenz.incidenz.Model.Institution;

@Repository
public interface IInstitutionRepository extends JpaRepository <Institution , String>{
 
	Institution findByIdInstitution(String idInstitution);
	
	Institution findByEmail(String email);

	Institution findByPassword(String password);

    @Modifying
	@Transactional
	@Query(value = "delete from Institution institution where institution.idInstitution=:idInstitution")
	void deleteInstitution(@Param("idInstitution")String idInstitution);

}
