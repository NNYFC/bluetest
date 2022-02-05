package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Epreuve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpreuveRepository extends JpaRepository<Epreuve,Integer> {
}
