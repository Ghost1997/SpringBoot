package com.sujit.bfo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sujit.bfo.model.BFO;

@Repository
public interface bfoRepository extends JpaRepository<BFO, String> {
	
	Optional<BFO> findById(int id);

}
