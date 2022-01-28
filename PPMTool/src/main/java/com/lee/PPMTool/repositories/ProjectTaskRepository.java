package com.lee.PPMTool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lee.PPMTool.domain.Backlog;

@Repository
public interface ProjectTaskRepository extends CrudRepository<Backlog, Long>{

}
