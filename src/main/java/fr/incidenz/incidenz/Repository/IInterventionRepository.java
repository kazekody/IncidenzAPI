package fr.incidenz.incidenz.Repository;

import org.springframework.stereotype.Repository;

import fr.incidenz.incidenz.Model.Incident;
import fr.incidenz.incidenz.Model.Institution;
import fr.incidenz.incidenz.Model.Intervention;

import java.util.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IInterventionRepository extends JpaRepository <Intervention, Long> {

    Intervention findByIdIntervention(Long idIntervention);

    List<Intervention> findByInstitution(Institution institution);

    List<Intervention> findByIncident(Incident incident);

    List<Intervention> findByDateIntervention(Date date);

    //List<Intervention> findByDateInterventionAndCategorie(Date date,String categorie);

    


    
}
