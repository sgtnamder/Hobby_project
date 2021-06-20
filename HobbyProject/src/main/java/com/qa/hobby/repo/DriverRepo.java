package com.qa.hobby.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hobby.domain.Driver;
// allows spring to create a repository from context
@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer> {

}
