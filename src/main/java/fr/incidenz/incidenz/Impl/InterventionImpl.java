package fr.incidenz.incidenz.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.incidenz.incidenz.Model.Incident;
import fr.incidenz.incidenz.Model.Institution;
import fr.incidenz.incidenz.Model.Intervention;
import fr.incidenz.incidenz.Repository.IIncidentRepository;
import fr.incidenz.incidenz.Repository.IInstitutionRepository;
import fr.incidenz.incidenz.Repository.IInterventionRepository;
import fr.incidenz.incidenz.Service.IInterventionService;

@Service
public class InterventionImpl implements IInterventionService {

    @Autowired
    public IInterventionRepository interventionRepository;

    @Autowired
    public IIncidentRepository incidentRepository;

    @Autowired
    public IInstitutionRepository institutionRepository;


    @Override
    public Intervention addIntervention(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    @Override
    public List<Intervention> listAllIntervention() {
        List<Intervention> listIntervention = interventionRepository.findAll();
        return listIntervention;
    }

    @Override
    public Intervention getInterventionbyId (Long idIntervention) {
        return interventionRepository.findByIdIntervention(idIntervention);
    }

    @Override
    public List<Intervention> listInterventionByIdInstitution(String idInstitution) {
        Institution institution = institutionRepository.findByIdInstitution(idInstitution);
        List<Intervention> listIntervention = interventionRepository.findByInstitution(institution);
        return listIntervention;
    }

    @Override
    public List<Intervention> listInterventionByIdIncident(String idIncident) {
        Incident incident = incidentRepository.findByIdIncident(idIncident);
        List<Intervention> listIntervention = interventionRepository.findByIncident(incident);
        return listIntervention;
    }

    @Override
    public List<Intervention> listInterventionDate(String date) {
        Date date1 = new Date();
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
           
            e.printStackTrace();
        }
        List<Intervention> listIntervention = interventionRepository.findByDateIntervention(date1);
        return listIntervention;
    }

    @Override
    public List<Intervention> listInterventionByCategorie(String categorie) {
        List<Intervention> listIntervention = interventionRepository.findByCategorieIncident(categorie);
        return listIntervention;
    }

    
    
}
