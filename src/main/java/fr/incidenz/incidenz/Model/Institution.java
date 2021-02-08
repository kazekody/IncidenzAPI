package fr.incidenz.incidenz.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Institution_table")
public class Institution  implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_Insitution", unique = true , nullable = false, updatable = false)
    private String idInstitution;

    @Column(name = "Libelle")
    private String Libelle;

    @Column(name = "Email_Insitution", unique = true)
    private String email;

    @Column(name = "Password_Institution" ) 
    private String password;

    
    @Column(name="Categorie_Institution")
    private String categorie;

    



    public Institution() {
    }

    public Institution(String idInstitution, String Libelle, String email, String password, String categorie) {
        this.idInstitution = idInstitution;
        this.Libelle = Libelle;
        this.email = email;
        this.password = password;
        this.categorie = categorie;
    }

    public String getidInstitution() {
        return this.idInstitution;
    }

    public void setidInstitution(String idInstitution) {
        this.idInstitution = idInstitution;
    }

    public String getLibelle() {
        return this.Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Institution idInstitution(String idInstitution) {
        this.idInstitution = idInstitution;
        return this;
    }

    public Institution Libelle(String Libelle) {
        this.Libelle = Libelle;
        return this;
    }

    public Institution email(String email) {
        this.email = email;
        return this;
    }

    public Institution password(String password) {
        this.password = password;
        return this;
    }

    public Institution categorie(String categorie) {
        this.categorie = categorie;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Institution)) {
            return false;
        }
        Institution institution = (Institution) o;
        return Objects.equals(idInstitution, institution.idInstitution) && Objects.equals(Libelle, institution.Libelle) && Objects.equals(email, institution.email) && Objects.equals(password, institution.password) && Objects.equals(categorie, institution.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInstitution, Libelle, email, password, categorie);
    }

    @Override
    public String toString() {
        return "{" +
            " idInstitution='" + getidInstitution() + "'" +
            ", Libelle='" + getLibelle() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", categorie='" + getCategorie() + "'" +
            "}";
    }


}
