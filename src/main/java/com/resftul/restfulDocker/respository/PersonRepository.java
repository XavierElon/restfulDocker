package com.resftul.restfulDocker.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resftul.restfulDocker.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
