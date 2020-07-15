package kz.portfolio.reself.app.service;

import kz.portfolio.reself.app.model.User;
import kz.portfolio.reself.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public User getUser() {
        return userRepository.findById(1).get();
    }

    @Override
    public List getAllEducations() {
        return educationRepository.findAll();
    }

    @Override
    public List getAllExperience() {
        return experienceRepository.findAll();
    }

    @Override
    public List getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public List getAllProjects() {
        return projectRepository.findAll();
    }

}
