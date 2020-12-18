package fr.incidenz.incidenz.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.incidenz.Enum.Categorie_Institution;

@Entity
@Table(name="Institution_table")
public class Institution {

    @Id
    @Column(name="id_Insitution", unique = true , nullable = false, updatable = false)
    private String idInsitution;

    @Column(name = "Libelle")
    private String Libelle;

    @Column(name = "Email_Insitution")
    private String email;

    @Column(name = "Password_Institution" ) 
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="Categorie_Institution")
    private Categorie_Institution categorie;



    public Institution() {
    }

    public Institution(String idInsitution, String Libelle, String email, String password, Categorie_Institution categorie) {
        this.idInsitution = idInsitution;
        this.Libelle = Libelle;
        this.email = email;
        this.password = password;
        this.categorie = categorie;
    }

    public String getIdInsitution() {
        return this.idInsitution;
    }

    public void setIdInsitution(String idInsitution) {
        this.idInsitution = idInsitution;
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

    public Categorie_Institution getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie_Institution categorie) {
        this.categorie = categorie;
    }

    public Institution idInsitution(String idInsitution) {
        this.idInsitution = idInsitution;
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

    public Institution categorie(Categorie_Institution categorie) {
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
        return Objects.equals(idInsitution, institution.idInsitution) && Objects.equals(Libelle, institution.Libelle) && Objects.equals(email, institution.email) && Objects.equals(password, institution.password) && Objects.equals(categorie, institution.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInsitution, Libelle, email, password, categorie);
    }

    @Override
    public String toString() {
        return "{" +
            " idInsitution='" + getIdInsitution() + "'" +
            ", Libelle='" + getLibelle() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", categorie='" + getCategorie() + "'" +
            "}";
    }


}
