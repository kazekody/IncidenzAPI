package fr.incidenz.incidenz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.incidenz.incidenz.Model.Institution;
import fr.incidenz.incidenz.Model.User;
import fr.incidenz.incidenz.Repository.IInstitutionRepository;
import fr.incidenz.incidenz.Repository.IUserRepository;
import fr.incidenz.incidenz.Tools.Response;

@CrossOrigin
@RestController
@RequestMapping("/Connexion")
public class Connexion {

    @Autowired
    public IUserRepository userRepository;

    @Autowired
    public IInstitutionRepository institutionRepository;

    @GetMapping("/connexionUser/{email}/{password}")
    public Response connexionUser(@PathVariable("email")String email, @PathVariable("password")String password){
        Response response = new Response();
        User userWithEmail = userRepository.findByEmail(email);
        if(userWithEmail != null){
            User userWithPassword = userRepository.findByPassword(password);
            if(userWithPassword != null){
                if(userWithEmail == userWithPassword){
                    response.setReturnValue(userWithEmail);
                }else{
                    response.setReturnValue(null);               }
            }
        }else{
            response.setReturnValue(null); 
        }
        
        return response;
    }

    
    @GetMapping("/connexionInstitution/{email}/{password}")
    public Response connexionInstitution(@PathVariable("email")String email, @PathVariable("password")String password){
        Response response = new Response();
        Institution isntiWithEmail = institutionRepository.findByEmail(email);
        if(isntiWithEmail != null){
            Institution instiWithPassword = institutionRepository.findByPassword(password);
            if(instiWithPassword != null){
                if(isntiWithEmail == instiWithPassword){
                    response.setReturnValue(isntiWithEmail);
                }else{
                    response.setReturnValue(null);               }
            }
        }else{
            response.setReturnValue(null); 
        }
        
        return response;
    }
    
}
