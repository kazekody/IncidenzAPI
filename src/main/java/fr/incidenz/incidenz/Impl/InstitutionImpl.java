package fr.incidenz.incidenz.Impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.incidenz.incidenz.Model.Institution;
import fr.incidenz.incidenz.Repository.IInstitutionRepository;
import fr.incidenz.incidenz.Service.IInstitutionService;

@Service
public class InstitutionImpl implements IInstitutionService {

    @Autowired
    public IInstitutionRepository institutionRepository;

    @Override
    public Institution addInstitution(Institution institution) {
        String id = "INSTI" + institution.getLibelle().substring(0, 2).toUpperCase() + institution.getCategorie()
        .toString().substring(0,3).toUpperCase();
        for(int i = 0; i <= 3; i++) {
            Random nombre = new Random();
            int nombreFinal = nombre.nextInt(9-0+1)+0;
            id = id + nombreFinal;
         }
        institution.setidInstitution(id);
        return institutionRepository.save(institution);
    }

    @Override
    public List<Institution> getInstitution() {
        List<Institution> institutionList = institutionRepository.findAll();
        return institutionList;
    }

    @Override
    public Institution modifyInstitution(Institution institution) {
        Institution existingInstitution = this.institutionRepository.findByIdInstitution(institution.getidInstitution());
        if(existingInstitution != null){
            Institution newInstitution = existingInstitution;
            newInstitution.setEmail(institution.getEmail());
            newInstitution.setLibelle(institution.getLibelle());
            newInstitution.setCategorie(institution.getCategorie());
            newInstitution.setPassword(institution.getPassword());
            institutionRepository.save(newInstitution);
            return newInstitution;
        } else {
            return existingInstitution;
        }
    }

    @Override
    public Institution getInstitutionbyId(String idInstitution) {
        Institution existingInstitution = this.institutionRepository.findByIdInstitution(idInstitution);
        if (existingInstitution != null)
            return institutionRepository.findByIdInstitution(idInstitution);
        else {
            return existingInstitution; 
        }
    }

    @Override
    public Boolean deleteInstitution(String idInstitution) {
        Institution existingInstitution = this.institutionRepository.findByIdInstitution(idInstitution);
        if(existingInstitution != null){
        institutionRepository.deleteInstitution(idInstitution);
        return true;
        } else {
            return false;
        }   
    }

    
    
    
}
