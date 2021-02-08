package fr.incidenz.incidenz.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.incidenz.incidenz.Model.ImageModel;

public interface IImageModelRepository extends JpaRepository<ImageModel , String>{
 
    
    ImageModel findByIdImage(String idImage);

    @Modifying
	@Transactional
	@Query(value = "delete from ImageModel imageModel where imageModel.idImage=:idImage")
	void deleteImage(@Param("idImage")String idImage);
}
