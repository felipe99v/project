package co.com.poli.project.service;

import co.com.poli.project.domain.Project;
import co.com.poli.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceLmpl implements ProjectService{


    private final ProjectRepository projectRepository;

    public ProjectServiceLmpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProject(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        Project projectBD = getProject(project.getId());
        if (projectBD==null){
            return null;
        }
        projectBD.setProjectName(project.getProjectName());
        projectBD.setDescription(project.getDescription());
        projectBD.setStartDate(project.getStartDate());
        projectBD.setEndDate(project.getEndDate());
        return projectRepository.save(projectBD);
    }

    @Override
    public Project deleteProject(Long id) {
        return null;
    }
}
