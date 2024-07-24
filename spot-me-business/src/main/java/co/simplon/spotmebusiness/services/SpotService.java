package co.simplon.spotmebusiness.services;

import java.io.File;
import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import co.simplon.spotmebusiness.dtos.SpotUpdate;
import co.simplon.spotmebusiness.dtos.SpotView;
import co.simplon.spotmebusiness.entities.Spot;
import co.simplon.spotmebusiness.repositories.SpotRepository;

@Service
public class SpotService {

    @Value("${spotmebusiness.uploads.dest}")
    private String uploadsDest;

    private final SpotRepository spots;

    public SpotService(SpotRepository spots) {
	this.spots = spots;
    }

    public void create(SpotCreate inputs) {
	Spot entity = new Spot();
	entity.setName(inputs.name());
	entity.setDescription(inputs.description());
	entity.setLat(inputs.lat());
	entity.setLng(inputs.lng());
	MultipartFile image = inputs.image();
	if (image != null) {
	    String imageId = buildImageId(image);
	    storeImage(image, imageId);
	    entity.setImageId(imageId);
	}
	spots.save(entity);
    }

    private String buildImageId(MultipartFile image) {
	UUID uuid = UUID.randomUUID();
	String name = image.getOriginalFilename();
	int index = name.lastIndexOf('.');
	String ext = name.substring(index, name.length());
	return uuid + ext;
    }

    private void storeImage(MultipartFile image, String imageId) {
	try {
	    String dest = String.format("%s/%s", uploadsDest, imageId);
	    File file = new File(dest);
	    image.transferTo(file);
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    public Collection<SpotView> getAll() {
	return spots.findAllProjectedBy();
    }

    public void deleteOne(Long id) {
	spots.deleteById(id);
    }

    public void updateOne(Long id, SpotUpdate inputs) {
	Spot entity = spots.findById(id).get();
	entity.setName(inputs.name());
	entity.setDescription(inputs.description());
	entity.setLat(inputs.lat());
	entity.setLng(inputs.lng());
	spots.save(entity);
    }

}
