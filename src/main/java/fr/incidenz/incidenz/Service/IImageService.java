package fr.incidenz.incidenz.Service;

import java.util.List;

import fr.incidenz.incidenz.Model.ImageModel;

public interface IImageService {

    public void ajouterImage(IImageService image);

    public List<ImageModel> listAllImage();

    
    
}
