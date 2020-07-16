package kz.portfolio.reself.app.service;

import kz.portfolio.reself.app.model.Education;
import kz.portfolio.reself.app.model.User;

import java.util.List;

public interface UserService {
    User getUser();
    List getAllEducations();
    List getAllExperience();
    List getAllSkills();
}
