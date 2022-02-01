package com.lee.PPMTool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lee.PPMTool.domain.Backlog;
import com.lee.PPMTool.domain.Project;
import com.lee.PPMTool.domain.ProjectTask;
import com.lee.PPMTool.exception.ProjectNotFoundException;
import com.lee.PPMTool.repositories.BacklogRepository;
import com.lee.PPMTool.repositories.ProjectRepository;
import com.lee.PPMTool.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {
	
	@Autowired
	private BacklogRepository backlogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
		
		try {
		Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
		projectTask.setBacklog(backlog);
		Integer BacklogSequence = backlog.getPTSequence();
		BacklogSequence++;
		
		backlog.setPTSequence(BacklogSequence);
		
		projectTask.setProjectSequence(backlog.getProjectIdentifier()+"-"+BacklogSequence);
		projectTask.setProjectIdentifier(projectIdentifier);
		
		if(projectTask.getPriority()==null) {
			projectTask.setPriority(3);
		}
		
		if(projectTask.getStatus()==""|| projectTask.getStatus()==null) {
			projectTask.setStatus("TO_DO");
		}
		
		return projectTaskRepository.save(projectTask);
		} catch (Exception e ) {
			throw new ProjectNotFoundException("Project not found");
		}
	}
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Iterable<ProjectTask> findBacklogById(String id) {
					
		Project project = projectRepository.findByProjectIdentifier(id);
		
		if(project==null) {
			throw new ProjectNotFoundException("Project with ID: '"+id+"' does not exist");
		}
		
		return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
	}
	
	public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id) {
		
		Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
		if(backlog==null) {
			throw new ProjectNotFoundException("Project with ID: '"+backlog_id+"'does not exist");
		}
		
		ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);
		
		if(projectTask == null ) {
			throw new ProjectNotFoundException("Project Task '"+pt_id+"' not found");
		}
		
		if(!projectTask.getProjectIdentifier().equals(backlog_id)) {
			throw new ProjectNotFoundException("Project Task '"+pt_id+"' does not exist in project: '"+backlog_id);
		}
		
		return projectTask;
	}

}
