package co.com.poli.project.service;

import co.com.poli.project.domain.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProject();

    Project getProject(Long id);

    Project createProject(Project project);

    Project updateProject(Project project);

    Project deleteProject(Long id);

    Project findByProjectIdentifier(String projectIdentifier);
}
