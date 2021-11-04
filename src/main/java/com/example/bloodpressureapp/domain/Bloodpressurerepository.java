package com.example.bloodpressureapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Bloodpressurerepository extends CrudRepository<Bloodpressure, Long> {

    List<Bloodpressure> findByid(Long id);
    
}