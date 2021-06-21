package com.qa.hobby.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hobby.domain.Race;
//allows spring to create a repository from context
@Repository
public interface RaceRepo extends JpaRepository<Race, Integer> {

}
