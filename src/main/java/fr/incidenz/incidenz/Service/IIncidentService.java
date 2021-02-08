package fr.incidenz.incidenz.Service;
import java.util.List;

import fr.incidenz.incidenz.Model.Incident;

public interface IIncidentService {

    public Incident addIncident (String titre, String categorie, String description, String idUser);

    public List<Incident> listAllIncident();
    
    public Incident modifyIncident(Incident incident);

    public Incident getIncidentById(String idIncident);

    public Boolean deleteIncident(String idIncident);

    public List<Incident> getIncidentByIdUser(String idUser);

    public List<Incident> getIncidentByCategorie(String categorie);

    public List<Incident> getIncidentByDate(String date);

    public List<Incident> listIncidentByCategorieDate(String categorie, String date);

    public List<Incident> getIncidentByCategorieAndStatus(String categorie , String status);
    
}
