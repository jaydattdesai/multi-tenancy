package com.jaydatt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaydatt.entity.SampleEntity;

@Repository
public interface SampleRepository extends CrudRepository<SampleEntity, Integer>{

}
