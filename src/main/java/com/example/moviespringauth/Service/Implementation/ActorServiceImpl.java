package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.Actor;
import com.example.moviespringauth.Repositories.ActorRepository;
import com.example.moviespringauth.Service.Interface.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional

public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor saveActor(Actor actor) {
        log.info("Saving new actor {} to the database", actor.getFirstName());
        return actorRepository.save(actor);
    }

    @Override
    public List<Actor> saveActors(List<Actor> actors) {
        log.info("Saving new actors to the database");
        return actorRepository.saveAll(actors);
    }

    @Override
    public List<Actor> getActors() {
        log.info("Fetching all actors");
        return actorRepository.findAll();
    }

    @Override
    public Actor getActorByFirstName(String firstName) {
        log.info("Fetching actor with the first name {} from the database", firstName);
        return actorRepository.findByFirstName(firstName);
    }

    @Override
    public Actor getActorByLastName(String lastName) {
        log.info("Fetching actor with the last name {} from the database", lastName);
        return actorRepository.findByLastName(lastName);
    }

    @Override
    public String deleteActor(Long actorId) {
        actorRepository.deleteById(actorId);
        return "Actor has been removed" +actorId;
    }

    @Override
    public Actor updateActor(Actor actor) {
        Actor existingActor = actorRepository.findById(actor.getActorId()).orElse(null);
        existingActor.setFirstName(actor.getFirstName());
        existingActor.setLastName(actor.getLastName());
        existingActor.setFilms(actor.getFilms());
        return actorRepository.save(existingActor);
    }
}
