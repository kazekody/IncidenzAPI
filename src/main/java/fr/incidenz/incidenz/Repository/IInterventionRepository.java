package fr.incidenz.incidenz.Repository;

import org.springframework.stereotype.Repository;

import fr.incidenz.incidenz.Model.Incident;
import fr.incidenz.incidenz.Model.Institution;
import fr.incidenz.incidenz.Model.Intervention;

import java.util.Date;
//import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface IInterventionRepository extends JpaRepository <Intervention, Long> {

    Intervention findByIdIntervention(Long idIntervention);

    List<Intervention> findByInstitution(Institution institution);

    List<Intervention> findByIncident(Incident incident);

    List<Intervention> findByDateIntervention(Date date);

    @Modifying
	@Transactional
	@Query(value = "SELECT * from intervention_table AS intervention ,incident_table as incident WHERE intervention.id_incident = incident.id_incident AND incident.categorie=?1" , nativeQuery = true)
	List<Intervention> findByCategorieIncident(@Param("categorie")String categorie);

    


    
}
