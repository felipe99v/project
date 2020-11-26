package co.com.poli.project;

import co.com.poli.project.domain.Project;
import co.com.poli.project.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProjectRepositoryMockTest {
    @Autowired
    private ProjectRepository projectRepository;
    @Test
    public void when_findAll_then_allproject(){
        Project project = new Project();
        project.setProjectName("test11");
        project.setProjectIdentifier("500g0fj");
        project.setDescription("test1");
        project.setStartDate(new Date());
        project.setEndDate(new Date());

        List<Project> projects = projectRepository.findAll();
        Assertions.assertThat(projects.size()).isEqualTo(3);
    }

}
