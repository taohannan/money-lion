package com.moneylion.demo.repository;

import com.moneylion.demo.model.Features;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturesRepository extends JpaRepository<Features,Long> {

    Features findByName(String name);
}
