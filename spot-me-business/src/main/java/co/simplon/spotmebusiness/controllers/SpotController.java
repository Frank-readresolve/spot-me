package co.simplon.spotmebusiness.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import co.simplon.spotmebusiness.services.SpotService;
import jakarta.validation.Valid;

// /spots => collection of resources of type "Spot"
@RequestMapping("/spots")
@RestController
public class SpotController {

    private final SpotService service;

    public SpotController(SpotService service) {
	this.service = service;
    }

    // @RequestBody => TXT/JSON
    // @ModelAttribute => multipart form data
    // POST "/spots" => Unique Rest endpoint identifier in the application
    @PostMapping
    void create(@Valid @ModelAttribute SpotCreate inputs) {
	service.create(inputs);
    }

}
