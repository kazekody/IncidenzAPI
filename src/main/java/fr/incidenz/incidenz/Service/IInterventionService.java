package fr.incidenz.incidenz.Service;

//import java.util.Date;
import java.util.List;

import fr.incidenz.incidenz.Model.Intervention;

public interface IInterventionService {

    public Intervention addIntervention (Intervention intervention);

    public List<Intervention> listAllIntervention();

    public Intervention getInterventionbyId(Long idIntervention);

    public List<Intervention> listInterventionByIdInstitution(String idInstitution);

    public List<Intervention> listInterventionByIdIncident(String idIncident);

    public List<Intervention> listInterventionDate(String date);

    public List<Intervention> listInterventionByCategorie(String categorie);




    
}
