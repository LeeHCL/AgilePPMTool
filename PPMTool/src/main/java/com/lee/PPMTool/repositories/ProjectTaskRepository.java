package com.lee.PPMTool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lee.PPMTool.domain.Backlog;
import com.lee.PPMTool.domain.ProjectTask;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long>{

}
