package com.resftul.restfulDocker.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resftul.restfulDocker.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
