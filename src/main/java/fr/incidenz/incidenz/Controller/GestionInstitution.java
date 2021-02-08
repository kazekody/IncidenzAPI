package fr.incidenz.incidenz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.incidenz.incidenz.Model.Institution;
import fr.incidenz.incidenz.Repository.IInstitutionRepository;
import fr.incidenz.incidenz.Service.IInstitutionService;
import fr.incidenz.incidenz.Tools.Response;

@CrossOrigin
@RestController
@RequestMapping("/GestionInstitution")
public class GestionInstitution {

    @Autowired
    public IInstitutionService institutionService;

    @Autowired
    public IInstitutionRepository institutionRepository;

    @PostMapping("/createInstitution")
    public Response createInstitution(@RequestBody Institution institution){
        Response response = new Response();
        Institution institutionBd = institutionRepository.findByEmail(institution.getEmail());
        System.out.println(institutionBd);
        if(institutionBd != null){
            response.setReturnValue(null);
        }else if(institutionBd == null) {
            response.setReturnValue(institutionService.addInstitution(institution));
        }
        return response;
       }


       @GetMapping("/listInstitution")
    public Response listAllInstitution(){
        Response response = new Response();
        response.setReturnValue(institutionService.getInstitution());
        return response;
    }

    @GetMapping("/getInstitutionById/{idInstitution}")
    public Response getInstitutionById (@PathVariable("idInstitution") String idInstitution){
        Response response = new Response();
        response.setReturnValue(institutionService.getInstitutionbyId(idInstitution));
        
        return response;
    }
    
}
