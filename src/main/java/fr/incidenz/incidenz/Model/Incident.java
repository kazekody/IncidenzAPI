package fr.incidenz.incidenz.Model;

import java.io.Serializable;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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

    @Column(name = "Titre", nullable = false)
    private String titre;

    @Column(name = "Description", nullable = false)
    private String Description;

    @Column(name="Categorie", nullable = false)
    private String categorie;

    @Column(name = "Date_Incident", nullable = false)
    private LocalDate dateIncident = LocalDate.now();

    @Column(name = "Heure_Incident", nullable = false)
    private LocalTime heureIncident = LocalTime.now();

    @Column(name="Status", nullable = false)
    private String status;

    @Column(name="Latitude", nullable = false)
    private Float latitude;

    @Column(name="Longitude", nullable = false)
    private Float longitude;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Incident")
    private List<ImageModel> listImageModeList = new ArrayList<>();
    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="idUser", nullable=false)
    private User user;



    public Incident() {
    }

    public Incident(String idIncident, String titre, String Description, String categorie, LocalDate dateIncident, LocalTime heureIncident, 
    String status, Float latitude, Float longitude) {
        this.idIncident = idIncident;
        this.titre = titre;
        this.Description = Description;
        this.categorie = categorie;
        this.dateIncident = dateIncident;
        this.heureIncident = heureIncident;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    @Override
    public String toString() {
        return "{" +
            " idIncident='" + getIdIncident() + "'" +
            ", titre='" + getTitre() + "'" +
            ", Description='" + getDescription() + "'" +
            ", categorie='" + getCategorie() + "'" +
            ", dateIncident='" + getDateIncident() + "'" +
            ", heureIncident='" + getHeureIncident() + "'" +
            ", status='" + getStatus() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            "}";
    }
  
    

    public String getIdIncident() {
        return this.idIncident;
    }

    public void setIdIncident(String idIncident) {
        this.idIncident = idIncident;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public LocalDate getDateIncident() {
        return this.dateIncident;
    }

    public void setDateIncident(LocalDate dateIncident) {
        this.dateIncident = dateIncident;
    }

    public LocalTime getHeureIncident() {
        return this.heureIncident;
    }

    public void setHeureIncident(LocalTime heureIncident) {
        this.heureIncident = heureIncident;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public List<ImageModel> getListImageModeList() {
        return this.listImageModeList;
    }

    public void setListImageModeList(List<ImageModel> listImageModeList) {
        this.listImageModeList = listImageModeList;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }




    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Incident)) {
            return false;
        }
        Incident incident = (Incident) o;
        return Objects.equals(idIncident, incident.idIncident) && Objects.equals(titre, incident.titre) && Objects.equals(Description, incident.Description) && Objects.equals(categorie, incident.categorie) && Objects.equals(dateIncident, incident.dateIncident) && Objects.equals(heureIncident, incident.heureIncident) && Objects.equals(status, incident.status) && Objects.equals(latitude, incident.latitude) && Objects.equals(longitude, incident.longitude) && Objects.equals(listImageModeList, incident.listImageModeList) && Objects.equals(user, incident.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIncident, titre, Description, categorie, dateIncident, heureIncident, status, latitude, longitude, listImageModeList, user);
    }
   











    
}
