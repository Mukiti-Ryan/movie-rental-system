package com.example.moviespringauth.Service.Interface;

import com.example.moviespringauth.Entities.Actor;

import java.util.List;

public interface ActorService {
    Actor saveActor(Actor actor);
    List<Actor> saveActors(List<Actor> actors);
    List<Actor> getActors();
    Actor getActorByLastName(String lastName);
    Actor getActorByFirstName(String firstName);
    String deleteActor(Long actorId);
    Actor updateActor(Actor actor);
}
