package fr.incidenz.incidenz.Service;

import java.util.List;

import fr.incidenz.incidenz.Model.Institution;

public interface IInstitutionService {

    public void addInstitution (Institution institution);

    public List<Institution> getInstitution();
    
    public void modifyInstitution();

    public Institution getInstitutionbyId();
    
}
