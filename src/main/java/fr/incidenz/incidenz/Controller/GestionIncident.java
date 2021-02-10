package fr.incidenz.incidenz.Controller;
//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.incidenz.incidenz.Model.Incident;
import fr.incidenz.incidenz.Service.IIncidentService;
import fr.incidenz.incidenz.Service.IUserService;
import fr.incidenz.incidenz.Tools.Response;

@CrossOrigin
@RestController
@RequestMapping("/GestionIncident")
public class GestionIncident {

    @Autowired
    public IIncidentService incidentService;
    @Autowired
    public IUserService userService;

    @PostMapping("/createIncident/{idUser}/{titre}/{categorie}/{description}/{latitude}/{longitude}")
    public Response createIncident(@PathVariable("idUser") String idUser, @PathVariable("titre") String titre,
            @PathVariable("categorie") String categorie, @PathVariable("description") String description,
            @PathVariable("latitude") Float latitude, @PathVariable("longitude") Float longitude) {
        Response response = new Response();
        response.setReturnValue(incidentService.addIncident(titre, categorie, description, idUser, latitude,longitude));
        return response;
    }

    @GetMapping("/listIncident")
    public Response listAllIncident() {
        Response response = new Response();
        response.setReturnValue(incidentService.listAllIncident());
        return response;
    }

    @GetMapping("/getIncidentByIdUser/{idUser}")
    public Response getIncidentByIdUser(@PathVariable("idUser") String idUser) {
        Response response = new Response();
        response.setReturnValue(incidentService.getIncidentByIdUser(idUser));

        return response;
    }

    @DeleteMapping("/deleteIncident/{idIncident}")
    public Response deleteIncident(@PathVariable("idIncident") String idIncident) {
        Response response = new Response();
        if (incidentService.deleteIncident(idIncident)) {
            response.setReturnValue(true);
            return response;
        } else {
            response.setReturnValue(false);
            return response;
        }
    }

    @PostMapping("/modifyIncident")
    public Response modifyIncident(@RequestBody Incident incident) {
        Response response = new Response();
        response.setReturnValue(incidentService.modifyIncident(incident));
        return response;
    }

    @GetMapping("/getIncidentByIdIncident/{idIncident}")
    public Response getIncidentById(@PathVariable("idIncident") String idIncident) {
        Response response = new Response();
        response.setReturnValue(incidentService.getIncidentById(idIncident));

        return response;
    }

    @GetMapping("/getIncidentByCategorie/{categorie}")
    public Response getIncidentByCategorie(@PathVariable("categorie") String categorie) {
        Response response = new Response();
        response.setReturnValue(incidentService.getIncidentByCategorie(categorie));

        return response;
    }

    @GetMapping("/listIncidentByDate/{date}")
    public Response listIncidentByDate(@PathVariable("date") String date) {
           Response response = new Response();
           response.setReturnValue(incidentService.getIncidentByDate(date));
           return response;
       }


       @GetMapping("/getIncidentByCategorieAndStatus/{categorie}/{status}")
       public Response getIncidentByCategorieAndStatus(@PathVariable("categorie") String categorie ,
       @PathVariable("status") String status) {
           Response response = new Response();
           response.setReturnValue(incidentService.getIncidentByCategorieAndStatus(categorie,status));
   
           return response;
       }


       @GetMapping("/getIncidentByCategorieAndDate/{categorie}/{date}")
       public Response getIncidentByCategorieAndDate(@PathVariable("categorie") String categorie ,
       @PathVariable("date") String date) {
           Response response = new Response();
           response.setReturnValue(incidentService.getIncidentByCategorieAndDate(categorie,date));
           return response;
       }

          
}
