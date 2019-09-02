package com.example.demo.repository;

import com.example.demo.model.Computer;
import com.example.demo.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends CrudRepository<Computer, Object> {

}
