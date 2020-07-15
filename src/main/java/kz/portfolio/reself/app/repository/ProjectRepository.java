package kz.portfolio.reself.app.repository;

import kz.portfolio.reself.app.model.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findAllByType(String type, Pageable pageable);
}
