package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau,Long> {
}
