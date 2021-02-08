package fr.incidenz.incidenz.Service;

import java.util.List;

import fr.incidenz.incidenz.Model.User;

public interface IUserService {

    public User addUser (User user);

    public List<User> listAllUser();
    
    public User modifyUser(User user);

    public User getUserbyId(String idUser);

    public Boolean deleteUser(String idUser);

    
    
}
