package com.example.demo2.repositry;

import com.example.demo2.entities.Immobilier;
import com.example.demo2.entities.ImmobilierLocation;
import com.example.demo2.entities.ImmobilierLocationId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImmobilierLocationRepository extends CrudRepository<ImmobilierLocation, ImmobilierLocationId> {
    List<ImmobilierLocation> findAllByImmobilier(Immobilier immobilier);
}
