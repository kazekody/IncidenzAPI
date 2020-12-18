package fr.incidenz.incidenz.Model;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.incidenz.Enum.Categorie_Incident;
import fr.incidenz.Enum.Status;

@Entity
@Table(name = "Incident_table")
public class Incident implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Column(name = "Id_Incident", unique = true, updatable = false, nullable = false)
    @Id
    private String idIncident;

    @Column(name = "Titre")
    private String titre;

    @Column(name = "Description")
    private String Description;

    @Enumerated(EnumType.STRING)
    @Column(name="Categorie")
    private Categorie_Incident categorie;

    @Column(name = "Date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name="Categorie")
    private Status status;

    //private ArrayList<ImageModel> listImageModeList;







    
}
