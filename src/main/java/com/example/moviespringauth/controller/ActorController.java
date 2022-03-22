package com.example.moviespringauth.controller;

import com.example.moviespringauth.Entities.Actor;
import com.example.moviespringauth.Service.Interface.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public ResponseEntity<List<Actor>>getActors() {
        return ResponseEntity.ok().body(actorService.getActors());
    }

    @GetMapping("/{firstName}")
    public Actor findActorByFirstName(@PathVariable String firstName) {
        return actorService.getActorByFirstName(firstName);
    }

    @GetMapping("/{lastName}")
    public Actor findActorByLastName(@PathVariable String lastName) {
        return actorService.getActorByLastName(lastName);
    }

    @PostMapping("/save")
    public ResponseEntity<Actor>saveActor(@RequestBody Actor actor) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/actor/save").toUriString());
        return ResponseEntity.created(uri).body(actorService.saveActor(actor));
    }

    @PostMapping("/saveCountries")
    public List<Actor> addActors(@RequestBody List<Actor> actors) {
        return actorService.saveActors(actors);
    }

    @PutMapping("/update")
    public Actor updateActor(@RequestBody Actor actor) {
        return actorService.updateActor(actor);
    }

    @DeleteMapping("/delete/{actorId}")
    public String deleteActor(@PathVariable Long actorId) {
        return actorService.deleteActor(actorId);
    }
}
