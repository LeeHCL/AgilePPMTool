package com.lee.PPMTool.exception;

public class ProjectNotFoundExceptionResponse {
	
	private String ProjectNotFound;
	
	public ProjectNotFoundExceptionResponse(String projecNotFound) {
		ProjectNotFound = projecNotFound;
	}

	public String getProjectNotFound() {
		return ProjectNotFound;
	}

	public void setProjectNotFound(String projectNotFound) {
		ProjectNotFound = projectNotFound;
	}
	
	
}