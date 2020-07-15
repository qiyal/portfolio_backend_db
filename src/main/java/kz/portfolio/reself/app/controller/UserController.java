package kz.portfolio.reself.app.controller;

import kz.portfolio.reself.app.mail.MyConstants;
import kz.portfolio.reself.app.model.*;
import kz.portfolio.reself.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/me")
    public User getUser() {
        return userService.getUser();
    }

    @GetMapping("/education")
    public List<Education> getAllEducation() {
        return userService.getAllEducations();
    }

    @GetMapping("/experience")
    public List<Experience> getAllExperience() {
        return userService.getAllExperience();
    }

    @GetMapping("/skills")
    public List<Skill> getAllSkills() {
        return userService.getAllSkills();
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {return userService.getAllProjects();}

    @PostMapping("/sent/email")
    public void sendEmail(@RequestBody Message message) {
        SimpleMailMessage newMessage = new SimpleMailMessage();

        newMessage.setTo(message.getEmail());
        newMessage.setSubject(message.getSubject());
        newMessage.setText("I am " + message.getName() + " .\n" + message.getText());

        // Send Message!
        javaMailSender.send(newMessage);
    }
}
