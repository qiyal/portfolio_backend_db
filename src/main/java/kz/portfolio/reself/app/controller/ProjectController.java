package kz.portfolio.reself.app.controller;

import kz.portfolio.reself.app.model.Project;
import kz.portfolio.reself.app.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/portfolio")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable("id") int id) {
        return projectRepository.findById(id).get();
    }

    @GetMapping("/projects")
    public ResponseEntity<Map<String, Object>> getAllProjects(
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size
    ) {

        try {
            List<Project> projects = new ArrayList<Project>();
            Pageable paging = PageRequest.of(page, size, Sort.by("date").descending());

            Page<Project> pageTuts;

            if (type == null) {
                pageTuts = projectRepository.findAll(paging);
            } else {
                pageTuts = projectRepository.findByType(type, paging);
            }

            projects = pageTuts.getContent();

            if (projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("projects", projects);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/projects/most-like")
    public ResponseEntity<Map<String, Object>> getMostLike(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int size
    ) {

        try {
            List<Project> projects = new ArrayList<Project>();
            Pageable paging = PageRequest.of(page, size, Sort.by("view").descending());

            Page<Project> pageTuts = projectRepository.findAll(paging);

            projects = pageTuts.getContent();

            if (projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("projects", projects);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
