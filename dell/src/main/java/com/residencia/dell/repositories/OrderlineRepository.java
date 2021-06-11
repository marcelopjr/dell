package com.residencia.dell.repositories;

import com.residencia.dell.entities.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderlineRepository extends JpaRepository<Orderline, Long> {

}
