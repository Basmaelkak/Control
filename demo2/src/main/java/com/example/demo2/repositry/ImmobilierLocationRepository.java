package com.example.demo2.repositry;

import com.example.demo2.entities.ImmobilierLocation;
import com.example.demo2.entities.ImmobilierLocationId;
import org.springframework.data.repository.CrudRepository;

public interface ImmobilierLocationRepository extends CrudRepository<ImmobilierLocation, ImmobilierLocationId> {

}
