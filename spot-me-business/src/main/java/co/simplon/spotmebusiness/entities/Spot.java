package co.simplon.spotmebusiness.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_spots")
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spot")
    private Long id;

    @Column(name = "spot_name")
    private String name;

    @Column(name = "spot_desc")
    private String description;

    @Column(name = "spot_lat")
    private double lat;

    @Column(name = "spot_lng")
    private double lng;

    @Column(name = "spot_img")
    private String imageId;

    public Spot() {
	// Default for ORM
    }

    public Long getId() {
	return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
	// handled by db
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public double getLat() {
	return lat;
    }

    public void setLat(double lat) {
	this.lat = lat;
    }

    public double getLng() {
	return lng;
    }

    public void setLng(double lng) {
	this.lng = lng;
    }

    public String getImageId() {
	return imageId;
    }

    public void setImageId(String imageId) {
	this.imageId = imageId;
    }

    @Override
    public String toString() {
	return String.format(
		"{id=%s, name=%s, description=%s, lat=%s, lng=%s, imageId=%s}",
		id, name, description, lat, lng, imageId);
    }

}
