package co.com.poli.project.controller;

import co.com.poli.project.domain.Project;
import co.com.poli.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {
private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(){
        List<Project>  projects = projectService.getAllProject();
        if(projects.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(projects);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") Long id) {
        Project project = projectService.getProject(id);
        if (project == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(project);
    }
    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
        Project projectBD = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(projectBD);
    }
    @PutMapping
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long id, @RequestBody Project project) {
        project.setId(id);
        Project projectBD = projectService.updateProject(project);
        if (projectBD == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projectBD);
    }


}
