package co.simplon.spotmebusiness.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import co.simplon.spotmebusiness.dtos.SpotUpdate;
import co.simplon.spotmebusiness.dtos.SpotView;
import co.simplon.spotmebusiness.services.SpotService;
import jakarta.validation.Valid;

@RequestMapping("/spots")
@RestController
public class SpotController {

    private final SpotService service;

    public SpotController(SpotService service) {
	this.service = service;
    }

    @PostMapping
    void create(@Valid @ModelAttribute SpotCreate inputs) {
	service.create(inputs);
    }

    @GetMapping
    Collection<SpotView> getAll() {
	return service.getAll();
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable("id") Long id) {
	service.deleteOne(id);
    }

    @PutMapping("/{id}")
    void updateOne(@PathVariable("id") Long id,
	    @Valid @ModelAttribute SpotUpdate inputs) {
	service.updateOne(id, inputs);
    }

}
