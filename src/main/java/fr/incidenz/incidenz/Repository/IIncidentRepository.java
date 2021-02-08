package fr.incidenz.incidenz.Repository;

import java.time.LocalDate;
//import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.incidenz.incidenz.Model.Incident;
import fr.incidenz.incidenz.Model.User;

public interface IIncidentRepository extends JpaRepository<Incident , String> {

    
	Incident findByIdIncident(String idIncident);

	List<Incident> findByUser(User user);

	List<Incident> findByCategorie(String categorie);

	List<Incident> findByDateIncident(LocalDate date);

	List<Incident> findByCategorieAndStatus(String categorie, String status);

	List<Incident> findByCategorieAndDateIncident(String categorie, LocalDate dateIncident);

    @Modifying
	@Transactional
	@Query(value = "delete from Incident incident where incident.idIncident=:idIncident")
	void deleteIncident(@Param("idIncident")String idIncident);



	

    
}
