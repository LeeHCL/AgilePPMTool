package com.lee.PPMTool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.PPMTool.domain.Project;
import com.lee.PPMTool.exception.ProjectIdException;
import com.lee.PPMTool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIndetifier(project.getProjectIndetifier().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException(
					"Project ID " + project.getProjectIndetifier().toUpperCase() + " already exists");
		}
	}

	public Project findProjectByIdentifier(String projectId) {

		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

		if (project == null) {
			throw new ProjectIdException("Project does not exist");

		}

		return project;
	}

}
