package com.tignestor.articulos.dao.repositories;

import com.tignestor.articulos.model.entities.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

}
