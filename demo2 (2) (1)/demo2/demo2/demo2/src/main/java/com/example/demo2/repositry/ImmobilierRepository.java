package com.example.demo2.repositry;

import com.example.demo2.entities.Immobilier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmobilierRepository extends CrudRepository<Immobilier,Long> {


}
