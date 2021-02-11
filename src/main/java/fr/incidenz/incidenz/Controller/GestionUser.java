package fr.incidenz.incidenz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.incidenz.incidenz.Model.User;
import fr.incidenz.incidenz.Repository.IUserRepository;
import fr.incidenz.incidenz.Service.IUserService;
import fr.incidenz.incidenz.Tools.Response;

@CrossOrigin
@RestController
@RequestMapping("/GestionUser")
public class GestionUser {

    @Autowired
    public IUserService userService;

    @Autowired
    public IUserRepository userRepository;
    
    @PostMapping("/createUser")
    public Response createUser(@RequestBody User user){
        Response response = new Response();
        User user1 = userRepository.findByEmail(user.getEmail());
        if(user1 != null){
            response.setReturnValue(null);
        }else if(user1 == null) {
            response.setReturnValue(userService.addUser(user));
        }
        return response;
       }

    @GetMapping("/listUser")
    public Response listAllUser(){
        Response response = new Response();
        response.setReturnValue(userService.listAllUser());
        return response;
    }

    @GetMapping("/getUser/{idUser}")
    public Response getUserIdUser (@PathVariable("idUser") String idUser){
        Response response = new Response();
        response.setReturnValue(userService.getUserbyId(idUser));
        
        return response;
    }

    @DeleteMapping("/deleteUser/{idUser}")
    public Response deleteUser (@PathVariable("idUser") String idUser){
        Response response = new Response();
        if(userService.deleteUser(idUser)){
            response.setReturnValue(true);
            return response;
        } else {
            response.setReturnValue(false);
            return response;
        }
    }

    @PostMapping("/modifyUser")
    public Response modifyUser(@RequestBody User user){
        Response response = new Response();
        response.setReturnValue(userService.modifyUser(user));
        return response;
       }



}
