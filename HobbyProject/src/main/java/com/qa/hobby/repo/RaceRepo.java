package com.qa.hobby.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hobby.domain.Race;

@Repository
public interface RaceRepo extends JpaRepository<Race, Integer> {

}
