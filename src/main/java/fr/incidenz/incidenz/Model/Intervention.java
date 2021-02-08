package fr.incidenz.incidenz.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Intervention_table")
public class Intervention implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Column(name = "Id_Intervention", unique = true, updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long idIntervention;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_Intervention")
    public Date dateIntervention;

    @Column(name = "Type")
    public String type;

    @Column(name = "Commentaire")
    public String commentaire;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Institution")
    public Institution institution;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Incident")
    public Incident incident;


    public Intervention() {
    }


    public Intervention(Long idIntervention, Date dateIntervention, String type, String commentaire) {
        this.idIntervention = idIntervention;
        this.dateIntervention = dateIntervention;
        this.type = type;
        this.commentaire = commentaire;
    }


    public Long getIdIntervention() {
        return this.idIntervention;
    }

    public void setIdIntervention(Long idIntervention) {
        this.idIntervention = idIntervention;
    }

    public Date getDateIntervention() {
        return this.dateIntervention;
    }

    public void setDateIntervention(Date dateIntervention) {
        this.dateIntervention = dateIntervention;
    }

    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Incident getIncident() {
        return this.incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.commentaire = Commentaire;
    }



    @Override
    public String toString() {
        return "{" +
            " idIntervention='" + getIdIntervention() + "'" +
            ", dateIntervention='" + getDateIntervention() + "'" +
            ", type='" + getType() + "'" +
            ", Commentaire='" + getCommentaire() + "'" +
            ", institution='" + getInstitution() + "'" +
            ", incident='" + getIncident() + "'" +
            "}";
    }
 

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Intervention)) {
            return false;
        }
        Intervention intervention = (Intervention) o;
        return Objects.equals(idIntervention, intervention.idIntervention) && Objects.equals(dateIntervention, intervention.dateIntervention) && Objects.equals(type, intervention.type) && Objects.equals(commentaire, intervention.commentaire) && Objects.equals(institution, intervention.institution) && Objects.equals(incident, intervention.incident);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIntervention, dateIntervention, type, commentaire, institution, incident);
    }

    
}
