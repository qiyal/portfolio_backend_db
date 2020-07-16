package kz.portfolio.reself.app.repository;

import kz.portfolio.reself.app.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Page<Project> findByType(String type, Pageable pageable);
}
