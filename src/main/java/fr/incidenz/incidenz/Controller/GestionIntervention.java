package fr.incidenz.incidenz.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.incidenz.incidenz.Model.Incident;
import fr.incidenz.incidenz.Model.Institution;
import fr.incidenz.incidenz.Model.Intervention;
import fr.incidenz.incidenz.Service.*;
import fr.incidenz.incidenz.Tools.Response;

@CrossOrigin
@RestController
@RequestMapping("/GestionIntervention")
public class GestionIntervention {

    @Autowired
    public IInterventionService interventionService;

    @Autowired
    public IIncidentService incidentService;

    @Autowired
    public IInstitutionService institutionService;

    @PostMapping("/Intervention/{idInstitution}/{idIncident}/{commentaire}")
    public Response createIntervention(@PathVariable("idInstitution")
     String idInstitution, @PathVariable("idIncident")String idIncident, @PathVariable("commentaire")String commentaire){
        Response response = new Response();
        Intervention intervention = new Intervention();
        Institution institution = institutionService.getInstitutionbyId(idInstitution);
        Incident incident = incidentService.getIncidentById(idIncident);
        Date date = new Date();
       
        if(incident == null || institution == null){
            response.setReturnValue(null);
            System.out.println(incident +"/"+ institution);
        } else{
            intervention.setIncident(incident);
            intervention.setInstitution(institution);
            System.out.println(incident.getStatus());
            if(incident.getStatus().equalsIgnoreCase("En attente")){
                incident.setStatus("En cours de Traitement");
                intervention.setDateIntervention(date);
                intervention.setCommentaire(commentaire);
                intervention.setType("Traitement");
                response.setReturnValue(interventionService.addIntervention(intervention));
             }else if(incident.getStatus().equalsIgnoreCase("En cours de Traitement")){
                incident.setStatus("Résolu");
                intervention.setDateIntervention(date);
                intervention.setCommentaire(commentaire);
                intervention.setType("Résolution");
                response.setReturnValue(interventionService.addIntervention(intervention));
            }
        }
        return response;
       }

       @GetMapping("/listIntervention")
       public Response listAllIntervention(){
           Response response = new Response();
           response.setReturnValue(interventionService.listAllIntervention());
           return response;
       }


       @GetMapping("/listInterventionByIncident/{idIncident}")
       public Response listInterventionByIncident(@PathVariable("idIncident") String idIncident){
           Response response = new Response();
           response.setReturnValue(interventionService.listInterventionByIdIncident(idIncident));
           return response;
       }

       @GetMapping("/listInterventionByInstitution/{idInstitution}")
       public Response listInterventionByInstitution(@PathVariable("idInstitution") String idInstitution){
           Response response = new Response();
           response.setReturnValue(interventionService.listInterventionByIdInstitution(idInstitution));
           return response;
       }


       @GetMapping("/listInterventionByDate/{date}")
       public Response listInterventionByDate(@PathVariable("date") String date){
           Response response = new Response();
           response.setReturnValue(interventionService.listInterventionDate(date));
           return response;
       }
    
}
