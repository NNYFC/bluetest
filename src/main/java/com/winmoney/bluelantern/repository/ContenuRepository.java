package com.winmoney.bluelantern.repository;

import com.winmoney.bluelantern.model.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContenuRepository extends JpaRepository<Contenu,Integer> {
    List<Contenu> findAllByIdcours(int idcours);
}
