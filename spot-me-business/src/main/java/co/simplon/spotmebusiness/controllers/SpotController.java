package co.simplon.spotmebusiness.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.spotmebusiness.dtos.SpotCreate;
import jakarta.validation.Valid;

// /spots => collection of resources of type "Spot"
@RequestMapping("/spots")
@RestController
public class SpotController {

    // @RequestBody => TXT/JSON
    // @ModelAttribute => multipart form data
    // POST "/spots" => Unique Rest endpoint identifier in the application
    @PostMapping
    void create(@Valid @ModelAttribute SpotCreate inputs) {
	System.out.println(inputs);
    }

}
