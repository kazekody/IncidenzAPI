package fr.incidenz.incidenz.Impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.incidenz.incidenz.Model.User;
import fr.incidenz.incidenz.Repository.IUserRepository;
import fr.incidenz.incidenz.Service.IUserService;

@Service
public class UserImpl implements IUserService {


    @Autowired
    public IUserRepository userRepository;

    @Override
    public User addUser(User user) {
        String id = "USER" + user.getNom().substring(0, 2).toUpperCase() + user.getPrenom().
        substring(0,2).toUpperCase();
        for(int i = 0; i <= 3; i++) {
           Random nombre = new Random();
           int nombreFinal = nombre.nextInt(9-0+1)+0;
           id = id + nombreFinal;
        }
        user.setIdUser(id);
        return userRepository.save(user);
    }

    @Override
    public List<User> listAllUser() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public Boolean deleteUser(String IdUser) {
        User existingUser = this.userRepository.findByIdUser(IdUser);
        if(existingUser != null){
        userRepository.deleteUser(IdUser);
        return true;
        } else {
                return false;
        }   

    }

    @Override
    public User modifyUser(User user) {
       User existingUser = this.userRepository.findByIdUser(user.getIdUser());
       if(existingUser != null){
           User newUser = existingUser;
           newUser.setEmail(user.getEmail());
           newUser.setNom(user.getNom());
           newUser.setPrenom(user.getPrenom());
           newUser.setPassword(user.getPassword());
           userRepository.save(newUser);
           return newUser;
       } else {
                return existingUser;
       }

    }

    @Override
    public User getUserbyId(String idUser) {
        User existingUser = this.userRepository.findByIdUser(idUser);
        if(existingUser != null)
        return userRepository.findByIdUser(idUser);
        else {
            return existingUser;
        }

    }


    
}
