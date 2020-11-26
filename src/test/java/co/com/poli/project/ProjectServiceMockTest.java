package co.com.poli.project;

import co.com.poli.project.domain.Project;
import co.com.poli.project.repository.ProjectRepository;
import co.com.poli.project.service.ProjectService;
import co.com.poli.project.service.ProjectServiceLmpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class ProjectServiceMockTest {

    @Mock
    private ProjectRepository projectRepository;
    private ProjectService projectService;

    @BeforeEach
    public void started(){

        MockitoAnnotations.initMocks(this);

        projectService = new ProjectServiceLmpl(projectRepository);
        Project project = new Project();
        project.setId(1l);
        project.setProjectName("test11");
        project.setProjectIdentifier("500g0fj");
        project.setDescription("test1");
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        projectRepository.save(project);

        Mockito.when(projectRepository.findById(1L))
                .thenReturn(Optional.of(project));
        Mockito.when(projectRepository.save(project))
                .thenReturn(project);
    }
    @Test
    public void when_ValidGetId_Then_ReturnProject() {
        Project project = projectService.getProject(1L);
        Assertions.assertThat(project.getProjectName()).isEqualTo("test11");
    }

}
