package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    Actor findByFirstName(String firstName);
    Actor findByLastName(String lastName);
//    TODO: Add find feature for names
    List<Actor> findAllByFirstName(String firstName);
    List<Actor> findAllByLastName(String lastName);
}
