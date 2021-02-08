package fr.incidenz.incidenz.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Image_table")
public class ImageModel {

            @Id
            @Column(name = "id_Image", nullable= false , unique = true, updatable = false)
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long idImage;
        
            @Column(name = "nom_Image")
            private String nomImage;
        
            @Column(name = "type")
            private String type;
       
            @Column(name = "picByte", length = 1000)
            private byte[] picByte;


            public Long getIdImage() {
                return this.idImage;
                }

            public void setIdImage(Long idImage) {
                this.idImage = idImage;
                }

            public String getNomImage() {
                return this.nomImage;
                }

             public void setNomImage(String nomImage) {
                this.nomImage = nomImage;
                }

        

    public ImageModel(Long idImage, String nomImage, String type, byte[] picByte) {
        this.idImage = idImage;
        this.nomImage = nomImage;
        this.type = type;
        this.picByte = picByte;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return this.picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    public ImageModel idImage(Long idImage) {
        this.idImage = idImage;
        return this;
    }

    public ImageModel nomImage(String nomImage) {
        this.nomImage = nomImage;
        return this;
    }

    public ImageModel type(String type) {
        this.type = type;
        return this;
    }

    public ImageModel picByte(byte[] picByte) {
        this.picByte = picByte;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ImageModel)) {
            return false;
        }
        ImageModel imageModel = (ImageModel) o;
        return Objects.equals(idImage, imageModel.idImage) && Objects.equals(nomImage, imageModel.nomImage) && Objects.equals(type, imageModel.type) && Objects.equals(picByte, imageModel.picByte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImage, nomImage, type, picByte);
    }

    @Override
    public String toString() {
        return "{" +
            " idImage='" + getIdImage() + "'" +
            ", nomImage='" + getNomImage() + "'" +
            ", type='" + getType() + "'" +
            ", picByte='" + getPicByte() + "'" +
            "}";
    }

    public ImageModel() {
        super();
    }

   public ImageModel(String nomImage, String type, byte[] picByte) {
        this.nomImage = nomImage;
        this.type = type;
        this.picByte = picByte;
    }
            
}
