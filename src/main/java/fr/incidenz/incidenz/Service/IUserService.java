package fr.incidenz.incidenz.Service;

import java.util.List;

import fr.incidenz.incidenz.Model.User;

public interface IUserService {

    public void addUser (User user);

    public List<User> getUser();
    
    public void modifyUser();

    public User getUserbyId();

    
    
}
