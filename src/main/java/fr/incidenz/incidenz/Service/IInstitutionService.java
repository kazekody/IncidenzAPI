package fr.incidenz.incidenz.Service;

import java.util.List;

import fr.incidenz.incidenz.Model.Institution;

public interface IInstitutionService {

    public Institution addInstitution (Institution institution);

    public List<Institution> getInstitution();
    
    public Institution modifyInstitution(Institution institution);

    public Institution getInstitutionbyId(String IdInstitution);

    public Boolean deleteInstitution(String IdInstitution);
    
}
