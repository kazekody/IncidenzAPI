package fr.incidenz.incidenz.Impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.incidenz.incidenz.Model.Incident;
import fr.incidenz.incidenz.Model.User;
import fr.incidenz.incidenz.Repository.IIncidentRepository;
import fr.incidenz.incidenz.Repository.IUserRepository;
import fr.incidenz.incidenz.Service.IIncidentService;

@Service
public class IncidentImpl implements IIncidentService {

    @Autowired
    public IIncidentRepository incidentRepository;

    @Autowired
    public IUserRepository userRepository;

    @Override
    public Incident addIncident(String titre, String categorie, String description, String idUser, Double latitude, Double longitude) {
        Incident incident = new Incident();
        incident.setCategorie(categorie);
        incident.setTitre(titre);
        incident.setDescription(description);
        incident.setLatitude(latitude);
        incident.setLongitude(longitude);
        User user = userRepository.findByIdUser(idUser);
        incident.setUser(user);
        String id = "IN" + incident.getCategorie().toString().substring(0, 2).toUpperCase();
        for (int i = 0; i <= 3; i++) {
            Random nombre = new Random();
            int nombreFinal = nombre.nextInt(9 - 0 + 1) + 0;
            id = id + nombreFinal;
        }
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        incident.setDateIncident(date);
        incident.setHeureIncident(time);
        incident.setIdIncident(id);
        incident.setStatus("En attente");
        return incidentRepository.save(incident);
    }

    @Override
    public List<Incident> listAllIncident() {
        List<Incident> incidentList = incidentRepository.findAll();
        return incidentList;
    }

    @Override
    public Incident modifyIncident(Incident incident) {
        Incident existingIncident = this.incidentRepository.findByIdIncident(incident.getIdIncident());
        if (existingIncident != null) {
            Incident newIncident = existingIncident;
            newIncident.setCategorie(incident.getCategorie());
            newIncident.setDescription(incident.getDescription());
            newIncident.setTitre(incident.getTitre());
            incidentRepository.save(newIncident);
            return newIncident;
        } else {
            return existingIncident;
        }
    }

    @Override
    public Incident getIncidentById(String IdIncident) {
        Incident existingIncident = this.incidentRepository.findByIdIncident(IdIncident);
        if (existingIncident != null)
            return incidentRepository.findByIdIncident(IdIncident);
        else {
            return existingIncident;
        }
    }

    @Override
    public Boolean deleteIncident(String IdIncident) {
        Incident existingUser = this.incidentRepository.findByIdIncident(IdIncident);
        if (existingUser != null) {
            incidentRepository.deleteIncident(IdIncident);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Incident> getIncidentByIdUser(String idUser) {
        User user = this.userRepository.findByIdUser(idUser);
        if (user != null) {
            List<Incident> listIncident = incidentRepository.findByUser(user);
            return listIncident;
        } else {
            return null;
        }
    }

    @Override
    public List<Incident> getIncidentByCategorie(String categorie) {
        List<Incident> listIncident = incidentRepository.findByCategorie(categorie);
        return listIncident;
    }

    @Override
    public List<Incident> getIncidentByDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date, formatter);

        List<Incident> listIncident = incidentRepository.findByDateIncident(date1);
        return listIncident;
    }

    @Override
    public List<Incident> listIncidentByCategorieDate(String categorie, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date, formatter);
        List<Incident> listIncident = incidentRepository.findByCategorieAndDateIncident(categorie,date1);
        return listIncident;
    }

    @Override
    public List<Incident> getIncidentByCategorieAndStatus(String categorie, String status) {
        List<Incident> listIncident = incidentRepository.findByCategorieAndStatus(categorie , status);
        return listIncident;
    }

    @Override
    public List<Incident> getIncidentByCategorieAndDate(String categorie, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date, formatter);
        List<Incident> listIncident = incidentRepository.findByCategorieAndDateIncident(categorie , date1);
        return listIncident;
    }



}
